package com.ngrok.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.linecorp.armeria.common.HttpHeaderNames;
import com.ngrok.EventSubscriptionTestBase;
import com.ngrok.Ngrok;
import com.ngrok.TestBase;
import com.ngrok.Version;
import com.ngrok.definitions.AwsAuth;
import com.ngrok.definitions.AwsRole;
import com.ngrok.definitions.EventDestination;
import com.ngrok.definitions.EventSourceReplace;
import com.ngrok.definitions.EventSubscription;
import com.ngrok.definitions.EventSubscriptionList;
import com.ngrok.definitions.EventTarget;
import com.ngrok.definitions.EventTargetCloudwatchLogs;
import com.ngrok.definitions.Page;
import de.mkammerer.wiremock.WireMockExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.equalToJson;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.noContent;
import static com.github.tomakehurst.wiremock.client.WireMock.ok;
import static com.github.tomakehurst.wiremock.client.WireMock.patch;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;
import static org.assertj.core.api.Assertions.assertThat;

public class EventSubscriptionsTest extends EventSubscriptionTestBase {
    private static final EventDestination EVENT_DESTINATION = new EventDestination(
        "abcdefg",
        "Some extra metadata about this destination",
        OffsetDateTime.now(),
        "This is a cool destination",
        "json",
        EventTarget.newBuilder()
            .cloudwatchLogs(
                EventTargetCloudwatchLogs.newBuilder()
                    .auth(AwsAuth.newBuilder().role(AwsRole.newBuilder("arn:aws:iam::12345:role/my-role-name").build()).build())
                    .logGroupArn("arn:aws:logs:us-east-1:12345:log-grp:my-log-grp")
                    .build()
            )
            .build(),
        URI.create("https://api.ngrok.com/event_destinations/abcdefg")
    );

    private static final Map<String, Object> EVENT_DESTINATION_CREATE = Stream.of(
        entry("description", EVENT_DESTINATION.getDescription()),
        entry("metadata", EVENT_DESTINATION.getMetadata()),
        entry("format", EVENT_DESTINATION.getFormat()),
        entry("target", Stream.of(
            entry("cloudwatch_logs", Stream.of(
                entry("auth", Stream.of(
                    entry("role", Stream.of(
                        entry("role_arn", EVENT_DESTINATION.getTarget().getCloudwatchLogs().get().getAuth().getRole().get().getRoleArn())
                    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
                ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))),
                entry("log_group_arn", EVENT_DESTINATION.getTarget().getCloudwatchLogs().get().getLogGroupArn())
            ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    @RegisterExtension
    final WireMockExtension wireMock = new WireMockExtension();

    @SuppressWarnings("unchecked")
    private static final Map<String, Object> EVENT_SUBSCRIPTION_CREATE = Stream.of(
        entry("description", EVENT_SUBSCRIPTION_JSON_FIELDS.get("description")),
        entry("metadata", EVENT_SUBSCRIPTION_JSON_FIELDS.get("metadata")),
        entry("sources", Collections.singletonList(
            EventSourceReplace.newBuilder()
                .type((String) ((List<Map<String, Object>>) EVENT_SUBSCRIPTION_JSON_FIELDS.get("sources")).get(0).get("type"))
                .build()
        )),
        entry("destination_ids", Collections.singletonList(
            (String) ((List<Map<String, Object>>) EVENT_SUBSCRIPTION_JSON_FIELDS.get("destinations")).get(0).get("id"))
        )
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    private static final Map<String, Object> EVENT_SUBSCRIPTION_UPDATE = Stream.of(
        entry("description", "some updated description")
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    private static final EventSubscription UPDATED_EVENT_SUBSCRIPTION = new EventSubscription(
        (String) EVENT_SUBSCRIPTION_JSON_FIELDS.get("id"),
        (URI) EVENT_SUBSCRIPTION_JSON_FIELDS.get("uri"),
        (OffsetDateTime) EVENT_SUBSCRIPTION_JSON_FIELDS.get("created_at"),
        (String) EVENT_SUBSCRIPTION_JSON_FIELDS.get("metadata"),
        (String) EVENT_SUBSCRIPTION_UPDATE.get("description"),
        Collections.singletonList(EVENT_SOURCE),
        Collections.singletonList(EVENT_DESTINATION_REF)
    );

    private static final EventSubscriptionList EVENT_SUBSCRIPTION_LIST = new EventSubscriptionList(
        Collections.singletonList(EVENT_SUBSCRIPTION),
        URI.create("https://api.ngrok.com/event_subscriptions"),
        Optional.empty()
    );

    private Ngrok ngrok() {
        return TestBase.ngrok(wireMock.getBaseUri());
    }

    @BeforeEach
    public void stubEventSubscriptions() throws JsonProcessingException {
        if (USE_LIVE_API) {
            return;
        }

        wireMock.resetAll();

        wireMock.stubFor(
            post(urlPathEqualTo("/event_destinations"))
                .withHeader(HttpHeaderNames.AUTHORIZATION.toString(), equalTo("Bearer " + FAKE_API_SECRET))
                .withHeader(HttpHeaderNames.USER_AGENT.toString(), equalTo("ngrok-api-client-java/" + Version.CLIENT_VERSION))
                .withHeader("ngrok-version", equalTo(Version.API_VERSION))
                .withHeader(HttpHeaderNames.CONTENT_TYPE.toString(), containing("application/json"))
                .withRequestBody(equalToJson(MAPPER.writeValueAsString(EVENT_DESTINATION_CREATE)))
                .willReturn(ok(MAPPER.writeValueAsString(EVENT_DESTINATION))
                    .withHeader(HttpHeaderNames.CONTENT_TYPE.toString(), "application/json")
                )
        );

        wireMock.stubFor(
            delete(urlPathEqualTo("/event_destinations/" + EVENT_DESTINATION.getId()))
                .withHeader(HttpHeaderNames.AUTHORIZATION.toString(), equalTo("Bearer " + FAKE_API_SECRET))
                .withHeader(HttpHeaderNames.USER_AGENT.toString(), equalTo("ngrok-api-client-java/" + Version.CLIENT_VERSION))
                .withHeader("ngrok-version", equalTo(Version.API_VERSION))
                .willReturn(noContent())
        );

        wireMock.stubFor(
            post(urlPathEqualTo("/event_subscriptions"))
                .withHeader(HttpHeaderNames.AUTHORIZATION.toString(), equalTo("Bearer " + FAKE_API_SECRET))
                .withHeader(HttpHeaderNames.USER_AGENT.toString(), equalTo("ngrok-api-client-java/" + Version.CLIENT_VERSION))
                .withHeader("ngrok-version", equalTo(Version.API_VERSION))
                .withHeader(HttpHeaderNames.CONTENT_TYPE.toString(), containing("application/json"))
                .withRequestBody(equalToJson(MAPPER.writeValueAsString(EVENT_SUBSCRIPTION_CREATE)))
                .willReturn(ok(MAPPER.writeValueAsString(EVENT_SUBSCRIPTION))
                    .withHeader(HttpHeaderNames.CONTENT_TYPE.toString(), "application/json")
                )
        );

        wireMock.stubFor(
            get(urlPathEqualTo("/event_subscriptions/" + EVENT_SUBSCRIPTION_JSON_FIELDS.get("id")))
                .withHeader(HttpHeaderNames.AUTHORIZATION.toString(), equalTo("Bearer " + FAKE_API_SECRET))
                .withHeader(HttpHeaderNames.USER_AGENT.toString(), equalTo("ngrok-api-client-java/" + Version.CLIENT_VERSION))
                .withHeader("ngrok-version", equalTo(Version.API_VERSION))
                .willReturn(ok(MAPPER.writeValueAsString(EVENT_SUBSCRIPTION))
                    .withHeader(HttpHeaderNames.CONTENT_TYPE.toString(), "application/json")
                )
        );

        wireMock.stubFor(
            get(urlPathEqualTo("/event_subscriptions"))
                .withQueryParam("limit", equalTo("10"))
                .withHeader(HttpHeaderNames.AUTHORIZATION.toString(), equalTo("Bearer " + FAKE_API_SECRET))
                .withHeader(HttpHeaderNames.USER_AGENT.toString(), equalTo("ngrok-api-client-java/" + Version.CLIENT_VERSION))
                .withHeader("ngrok-version", equalTo(Version.API_VERSION))
                .willReturn(ok(MAPPER.writeValueAsString(EVENT_SUBSCRIPTION_LIST))
                    .withHeader(HttpHeaderNames.CONTENT_TYPE.toString(), "application/json")
                )
        );

        wireMock.stubFor(
            patch(urlPathEqualTo("/event_subscriptions/" + EVENT_SUBSCRIPTION_JSON_FIELDS.get("id")))
                .withHeader(HttpHeaderNames.AUTHORIZATION.toString(), equalTo("Bearer " + FAKE_API_SECRET))
                .withHeader(HttpHeaderNames.USER_AGENT.toString(), equalTo("ngrok-api-client-java/" + Version.CLIENT_VERSION))
                .withHeader("ngrok-version", equalTo(Version.API_VERSION))
                .withHeader(HttpHeaderNames.CONTENT_TYPE.toString(), containing("application/json"))
                .withRequestBody(equalToJson(MAPPER.writeValueAsString(EVENT_SUBSCRIPTION_UPDATE)))
                .willReturn(ok(MAPPER.writeValueAsString(UPDATED_EVENT_SUBSCRIPTION))
                    .withHeader(HttpHeaderNames.CONTENT_TYPE.toString(), "application/json")
                )
        );

        wireMock.stubFor(
            delete(urlPathEqualTo("/event_subscriptions/" + EVENT_SUBSCRIPTION_JSON_FIELDS.get("id")))
                .withHeader(HttpHeaderNames.AUTHORIZATION.toString(), equalTo("Bearer " + FAKE_API_SECRET))
                .withHeader(HttpHeaderNames.USER_AGENT.toString(), equalTo("ngrok-api-client-java/" + Version.CLIENT_VERSION))
                .withHeader("ngrok-version", equalTo(Version.API_VERSION))
                .willReturn(noContent())
        );
    }

    @Test
    public void testEventSubscriptions() throws InterruptedException {
        if (USE_LIVE_API) {
            LoggerFactory.getLogger(getClass()).warn("{} cannot currently be run against the live API", getClass().getSimpleName());
            return;
        }

        final String eventDestinationId = testCreateEventDestination();
        final String id = testCreateEventSubscription();
        try {
            testGetEventSubscription(id);
            testListEventSubscriptions(id);
            testUpdateEventSubscription(id);
            testDeleteEventSubscription(id);
            testDeleteEventDestination(eventDestinationId);
        } catch (final Exception e) {
            if (USE_LIVE_API) {
                // Make an attempt to clean things up
                try { ngrok().eventSubscriptions().delete(id).blockingCall(); } catch (final Exception e1) {}
                try { ngrok().eventDestinations().delete(eventDestinationId).blockingCall(); } catch (final Exception e1) {}
            }
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    private String testCreateEventSubscription() throws InterruptedException {
        final EventSubscription eventSubscription = ngrok().eventSubscriptions().create()
            .description((String) EVENT_SUBSCRIPTION_CREATE.get("description"))
            .metadata((String) EVENT_SUBSCRIPTION_CREATE.get("metadata"))
            .sources((List<EventSourceReplace>) EVENT_SUBSCRIPTION_CREATE.get("sources"))
            .destinationIds((List<String>) EVENT_SUBSCRIPTION_CREATE.get("destination_ids"))
            .blockingCall();
        assertEventSubscriptionFields(eventSubscription);
        return eventSubscription.getId();
    }

    public static void assertEventSubscriptionFields(final EventSubscription eventSubscription, final String expectedDescription) {
        assertThat(eventSubscription.getId()).isEqualTo(EVENT_SUBSCRIPTION_JSON_FIELDS.get("id"));
        assertThat(eventSubscription.getDescription()).isEqualTo(expectedDescription);
        assertThat(eventSubscription.getMetadata()).isEqualTo(EVENT_SUBSCRIPTION_JSON_FIELDS.get("metadata"));
        assertThat(eventSubscription.getSources()).containsAll(EVENT_SUBSCRIPTION.getSources());
        assertThat(eventSubscription.getDestinations()).containsAll(EVENT_SUBSCRIPTION.getDestinations());
    }

    public static void assertEventSubscriptionFields(final EventSubscription eventSubscription) {
        assertEventSubscriptionFields(eventSubscription, (String) EVENT_SUBSCRIPTION_JSON_FIELDS.get("description"));
    }

    private void testGetEventSubscription(final String id) throws InterruptedException {
        final EventSubscription eventSubscription = ngrok().eventSubscriptions().get(id)
            .blockingCall();
        assertEventSubscriptionFields(eventSubscription);
    }

    private void testListEventSubscriptions(final String id) throws InterruptedException {
        final EventSubscriptions eventSubscriptions = ngrok().eventSubscriptions();
        final Page<EventSubscriptionList> eventSubscriptionListPage = eventSubscriptions.list()
            .limit("10")
            .blockingCall();
        final EventSubscription eventSubscription;
        if (USE_LIVE_API) {
            eventSubscription = eventSubscriptionListPage.getPage().getEventSubscriptions()
                .stream()
                .filter(key -> key.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("API key with ID " + id + " not found in list"));
        } else {
            eventSubscription = eventSubscriptionListPage.getPage().getEventSubscriptions().get(0);
            assertThat(eventSubscriptionListPage.getPage().getNextPageUri()).isEmpty();
            assertThat(eventSubscriptionListPage.next()).isCompletedWithValue(Optional.empty());
        }
        assertEventSubscriptionFields(eventSubscription);
    }

    private void testUpdateEventSubscription(final String id) throws InterruptedException {
        final EventSubscription eventSubscription = ngrok().eventSubscriptions().update(id)
            .description((String) EVENT_SUBSCRIPTION_UPDATE.get("description"))
            .blockingCall();
        assertEventSubscriptionFields(eventSubscription, (String) EVENT_SUBSCRIPTION_UPDATE.get("description"));
    }

    private void testDeleteEventSubscription(final String id) throws InterruptedException {
        ngrok().eventSubscriptions().delete(id).blockingCall();
    }

    private String testCreateEventDestination() throws InterruptedException {
        final EventDestination dest = ngrok().eventDestinations().create()
            .description(EVENT_DESTINATION.getDescription())
            .metadata(EVENT_DESTINATION.getMetadata())
            .format(EVENT_DESTINATION.getFormat())
            .target(EVENT_DESTINATION.getTarget())
            .blockingCall();
        return dest.getId();
    }

    private void testDeleteEventDestination(final String id) throws InterruptedException {
        ngrok().eventDestinations().delete(id).blockingCall();
    }
}
