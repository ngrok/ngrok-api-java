/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.linecorp.armeria.common.HttpHeaderNames;
import com.ngrok.EventSubscriptionTestBase;
import com.ngrok.Ngrok;
import com.ngrok.TestBase;
import com.ngrok.Version;
import com.ngrok.definitions.*;
import de.mkammerer.wiremock.WireMockExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class EventSubscriptionsTest extends EventSubscriptionTestBase {
    @RegisterExtension
    final WireMockExtension wireMock = new WireMockExtension(new WireMockConfiguration().dynamicPort().dynamicHttpsPort());

    public static final Map<String, Object> EVENT_DESTINATION_CREATE = Stream.of(
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

    private static final Map<String, Object> EVENT_SUBSCRIPTION_CREATE = Stream.of(
        entry("description", EVENT_SUBSCRIPTION.getDescription()),
        entry("metadata", EVENT_SUBSCRIPTION.getMetadata()),
        entry("sources", EVENT_SUBSCRIPTION.getSources().stream().map(source -> EventSourceReplace.newBuilder().type(source.getType()).build()).collect(Collectors.toList())),
        entry("destination_ids", USE_LIVE_API ? Collections.emptyList() : Collections.singletonList(EVENT_DESTINATION.getId()))
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    private static final EventSubscription UPDATED_EVENT_SUBSCRIPTION = new EventSubscription(
        EVENT_SUBSCRIPTION.getId(),
        EVENT_SUBSCRIPTION.getUri(),
        EVENT_SUBSCRIPTION.getCreatedAt(),
        EVENT_SUBSCRIPTION.getMetadata(),
        Optional.of("some updated description"),
        EVENT_SUBSCRIPTION.getSources(),
        EVENT_SUBSCRIPTION.getDestinations()
    );

    private static final Map<String, Object> EVENT_SUBSCRIPTION_UPDATE = Stream.of(
        entry("description", UPDATED_EVENT_SUBSCRIPTION.getDescription())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

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
                .withHeader(HttpHeaderNames.USER_AGENT.toString(), equalTo(USER_AGENT))
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
                .withHeader(HttpHeaderNames.USER_AGENT.toString(), equalTo(USER_AGENT))
                .withHeader("ngrok-version", equalTo(Version.API_VERSION))
                .willReturn(noContent())
        );

        wireMock.stubFor(
            post(urlPathEqualTo("/event_subscriptions"))
                .withHeader(HttpHeaderNames.AUTHORIZATION.toString(), equalTo("Bearer " + FAKE_API_SECRET))
                .withHeader(HttpHeaderNames.USER_AGENT.toString(), equalTo(USER_AGENT))
                .withHeader("ngrok-version", equalTo(Version.API_VERSION))
                .withHeader(HttpHeaderNames.CONTENT_TYPE.toString(), containing("application/json"))
                .withRequestBody(equalToJson(MAPPER.writeValueAsString(EVENT_SUBSCRIPTION_CREATE)))
                .willReturn(ok(MAPPER.writeValueAsString(EVENT_SUBSCRIPTION))
                    .withHeader(HttpHeaderNames.CONTENT_TYPE.toString(), "application/json")
                )
        );

        wireMock.stubFor(
            get(urlPathEqualTo("/event_subscriptions/" + EVENT_SUBSCRIPTION.getId()))
                .withHeader(HttpHeaderNames.AUTHORIZATION.toString(), equalTo("Bearer " + FAKE_API_SECRET))
                .withHeader(HttpHeaderNames.USER_AGENT.toString(), equalTo(USER_AGENT))
                .withHeader("ngrok-version", equalTo(Version.API_VERSION))
                .willReturn(ok(MAPPER.writeValueAsString(EVENT_SUBSCRIPTION))
                    .withHeader(HttpHeaderNames.CONTENT_TYPE.toString(), "application/json")
                )
        );

        wireMock.stubFor(
            get(urlPathEqualTo("/event_subscriptions"))
                .withQueryParam("limit", equalTo("10"))
                .withHeader(HttpHeaderNames.AUTHORIZATION.toString(), equalTo("Bearer " + FAKE_API_SECRET))
                .withHeader(HttpHeaderNames.USER_AGENT.toString(), equalTo(USER_AGENT))
                .withHeader("ngrok-version", equalTo(Version.API_VERSION))
                .willReturn(ok(MAPPER.writeValueAsString(EVENT_SUBSCRIPTION_LIST))
                    .withHeader(HttpHeaderNames.CONTENT_TYPE.toString(), "application/json")
                )
        );

        wireMock.stubFor(
            patch(urlPathEqualTo("/event_subscriptions/" + EVENT_SUBSCRIPTION.getId()))
                .withHeader(HttpHeaderNames.AUTHORIZATION.toString(), equalTo("Bearer " + FAKE_API_SECRET))
                .withHeader(HttpHeaderNames.USER_AGENT.toString(), equalTo(USER_AGENT))
                .withHeader("ngrok-version", equalTo(Version.API_VERSION))
                .withHeader(HttpHeaderNames.CONTENT_TYPE.toString(), containing("application/json"))
                .withRequestBody(equalToJson(MAPPER.writeValueAsString(EVENT_SUBSCRIPTION_UPDATE)))
                .willReturn(ok(MAPPER.writeValueAsString(UPDATED_EVENT_SUBSCRIPTION))
                    .withHeader(HttpHeaderNames.CONTENT_TYPE.toString(), "application/json")
                )
        );

        wireMock.stubFor(
            delete(urlPathEqualTo("/event_subscriptions/" + EVENT_SUBSCRIPTION.getId()))
                .withHeader(HttpHeaderNames.AUTHORIZATION.toString(), equalTo("Bearer " + FAKE_API_SECRET))
                .withHeader(HttpHeaderNames.USER_AGENT.toString(), equalTo(USER_AGENT))
                .withHeader("ngrok-version", equalTo(Version.API_VERSION))
                .willReturn(noContent())
        );
    }

    @Test
    public void testEventSubscriptions() throws InterruptedException {
        // Creating an event destination triggers server-side validation that the AWS resources
        // specified in the destination exist.  Since we don't have them, we'll leave the
        // destination out of our event subscription.
        final List<String> eventDestinationIds;
        if (USE_LIVE_API) {
            eventDestinationIds = Collections.emptyList();
        } else {
            eventDestinationIds = Collections.singletonList(testCreateEventDestination());
        }

        final String id = testCreateEventSubscription(eventDestinationIds);
        try {
            testGetEventSubscription(id, eventDestinationIds);
            testListEventSubscriptions(id, eventDestinationIds);
            testUpdateEventSubscription(id, eventDestinationIds);
            testDeleteEventSubscription(id);
            eventDestinationIds.forEach(this::testDeleteEventDestination);
        } catch (final Exception e) {
            if (USE_LIVE_API) {
                // Make an attempt to clean things up
                ngrok().eventSubscriptions().delete(id).blockingCall();
            }
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    private String testCreateEventSubscription(final List<String> eventDestinationIds) throws InterruptedException {
        final EventSubscription eventSubscription = ngrok().eventSubscriptions().create()
            .description((Optional<String>) EVENT_SUBSCRIPTION_CREATE.get("description"))
            .metadata((Optional<String>) EVENT_SUBSCRIPTION_CREATE.get("metadata"))
            .sources((List<EventSourceReplace>) EVENT_SUBSCRIPTION_CREATE.get("sources"))
            .destinationIds(eventDestinationIds)
            .blockingCall();
        assertEventSubscriptionFields(eventSubscription);
        return eventSubscription.getId();
    }

    private void testGetEventSubscription(final String id, final List<String> eventDestinationIds) throws InterruptedException {
        final EventSubscription eventSubscription = ngrok().eventSubscriptions().get(id)
            .blockingCall();
        assertEventSubscriptionFields(eventSubscription, eventDestinationIds);
    }

    private void testListEventSubscriptions(final String id, final List<String> eventDestinationIds) throws InterruptedException {
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
        assertEventSubscriptionFields(eventSubscription, eventDestinationIds);
    }

    private void testUpdateEventSubscription(final String id, final List<String> eventDestinationIds) throws InterruptedException {
        final EventSubscription eventSubscription = ngrok().eventSubscriptions().update(id)
            .description((Optional<String>) EVENT_SUBSCRIPTION_UPDATE.get("description"))
            .blockingCall();
        assertEventSubscriptionFields(eventSubscription, (Optional<String>) EVENT_SUBSCRIPTION_UPDATE.get("description"), eventDestinationIds);
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

    private void testDeleteEventDestination(final String id) {
        try {
            ngrok().eventDestinations().delete(id).blockingCall();
        } catch (final InterruptedException e) {
            fail(e.getMessage(), e);
        }
    }
}
