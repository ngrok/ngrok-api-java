package com.ngrok.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.linecorp.armeria.common.HttpHeaderNames;
import com.ngrok.Ngrok;
import com.ngrok.TestBase;
import com.ngrok.Version;
import com.ngrok.definitions.HttpsEdge;
import com.ngrok.definitions.HttpsEdgeList;
import de.mkammerer.wiremock.WireMockExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;

public class HttpsEdgesTest extends TestBase {
    private static final Optional<String> LIVE_HOSTPORT = Optional.ofNullable(System.getenv("NGROK_HOSTPORT"));
    private static final String TEST_HOSTPORT = "test-hostport-123.ngrok.io:443";

    private static final HttpsEdge MOCK_EDGE = new HttpsEdge(
        "some-id",
        "",
        "test scala client",
        OffsetDateTime.now(),
        URI.create("https://api.ngrok.com/edges/https/some-id"),
        Optional.of(Collections.singletonList(TEST_HOSTPORT)),
        Optional.empty(),
        Optional.empty(),
        Collections.emptyList()
    );

    private static final HttpsEdgeList MOCK_EDGE_LIST = new HttpsEdgeList(
        Collections.singletonList(MOCK_EDGE),
        URI.create("https://api.ngrok.com/edges/https"),
        Optional.empty()
    );

    private final List<String> testHostports;
    private final Map<String, Object> mockEdgeCreate;

    private HttpsEdgesTest() {
        if (USE_LIVE_API) {
            testHostports = Collections.singletonList(LIVE_HOSTPORT.get());
        } else {
            testHostports = Collections.singletonList(TEST_HOSTPORT);
        }

        mockEdgeCreate = Stream.of(
            entry("metadata", MOCK_EDGE.getMetadata()),
            entry("hostports", testHostports)
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @RegisterExtension
    final WireMockExtension wireMock = new WireMockExtension();

    private Ngrok ngrok() {
        return TestBase.ngrok(wireMock.getBaseUri());
    }

    @BeforeEach
    public void stubHttpsEdges() throws JsonProcessingException {
        if (USE_LIVE_API) {
            return;
        }

        wireMock.resetAll();

        wireMock.stubFor(
            post(urlPathEqualTo("/edges/https"))
                .withHeader(HttpHeaderNames.AUTHORIZATION.toString(), equalTo("Bearer " + FAKE_API_SECRET))
                .withHeader(HttpHeaderNames.USER_AGENT.toString(), equalTo(USER_AGENT))
                .withHeader("ngrok-version", equalTo(Version.API_VERSION))
                .withHeader(HttpHeaderNames.CONTENT_TYPE.toString(), containing("application/json"))
                .withRequestBody(equalToJson(MAPPER.writeValueAsString(mockEdgeCreate)))
          .willReturn(
            ok(MAPPER.writeValueAsString(MOCK_EDGE))
                .withHeader(HttpHeaderNames.CONTENT_TYPE.toString(), "application/json")
        )
      );

        wireMock.stubFor(
            get(urlPathEqualTo("/edges/https"))
                .withHeader(HttpHeaderNames.AUTHORIZATION.toString(), equalTo("Bearer " + FAKE_API_SECRET))
                .withHeader(HttpHeaderNames.USER_AGENT.toString(), equalTo(USER_AGENT))
                .withHeader("ngrok-version", equalTo(Version.API_VERSION))
                .willReturn(
                    ok(MAPPER.writeValueAsString(MOCK_EDGE_LIST))
                        .withHeader(HttpHeaderNames.CONTENT_TYPE.toString(), "application/json")
                )
        );

        wireMock.stubFor(
            delete(urlPathEqualTo("/edges/https/" + MOCK_EDGE.getId()))
                .withHeader(HttpHeaderNames.AUTHORIZATION.toString(), equalTo("Bearer " + FAKE_API_SECRET))
                .withHeader(HttpHeaderNames.USER_AGENT.toString(), equalTo(USER_AGENT))
                .withHeader("ngrok-version", equalTo(Version.API_VERSION))
                .willReturn(noContent())
        );
    }

    @Test
    public void testHttpsEdges() throws InterruptedException {
        if (USE_LIVE_API) {
            if (!LIVE_HOSTPORT.isPresent()) {
                throw new IllegalStateException("Please set NGROK_HOSTPORT to a valid endpoint HOST:PORT before running this test live");
            }
        }

        final String edgesId = assertCreateHttpsEdge(testHostports);
        try {
            assertListHttpsEdges(edgesId, testHostports);
        } finally {
            deleteHttpsEdge(edgesId);
        }
    }

    private String assertCreateHttpsEdge(final List<String> hostports) throws InterruptedException {
        final HttpsEdge edge = ngrok().edges().https().create()
            .metadata(MOCK_EDGE.getMetadata())
            .hostports(hostports)
            .blockingCall();
        assertThat(edge.getHostports().get()).containsExactlyElementsOf(testHostports);
        return edge.getId();
    }

    private void assertListHttpsEdges(final String expectedId, final List<String> expectedHostports) throws InterruptedException {
        final HttpsEdge edge = ngrok().edges().https().list().blockingCall().getPage().getHttpsEdges().stream()
            .filter(e -> e.getMetadata().equals(MOCK_EDGE.getMetadata()))
            .findFirst()
            .get();
        assertThat(edge.getId()).isEqualTo(expectedId);
        assertThat(edge.getHostports().get()).containsExactlyElementsOf(expectedHostports);
    }

    private void deleteHttpsEdge(final String id) throws InterruptedException {
        ngrok().edges().https().delete(id).blockingCall();
    }
}
