package com.ngrok;

import com.ngrok.definitions.EventSource;
import com.ngrok.definitions.EventSubscription;
import com.ngrok.definitions.Ref;

import java.net.URI;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class EventSubscriptionTestBase extends TestBase {
    public static final Map<String, Object> EVENT_SOURCE_JSON_FIELDS = Stream.of(
        entry("type", "http_request_complete"),
        entry("uri", URI.create("https://api.ngrok.com/event_sources/1802749824798"))
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final Map<String, Object> EVENT_DESTINATION_REF_JSON_FIELDS = Stream.of(
        entry("id", "9876543abcdefg"),
        entry("uri", URI.create("https://api.ngrok.com/event_destinations/9876543abcdefg"))
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final Map<String, Object> EVENT_SUBSCRIPTION_JSON_FIELDS = Stream.of(
        entry("id", "abcdef123456"),
        entry("uri", URI.create("https://api.ngrok.com/event_subscriptions/abcdef123456")),
        entry("description", "this is a great event subscription"),
        entry("metadata", "this event subscription is quite meta"),
        entry("sources", Collections.singletonList(EVENT_SOURCE_JSON_FIELDS)),
        entry("destinations", Collections.singletonList(EVENT_DESTINATION_REF_JSON_FIELDS)),
        entry("created_at", OffsetDateTime.parse("2021-06-08T21:09:00-07:00"))
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static EventSource EVENT_SOURCE = new EventSource(
        (String) EVENT_SOURCE_JSON_FIELDS.get("type"),
        (URI) EVENT_SOURCE_JSON_FIELDS.get("uri")
    );

    public static Ref EVENT_DESTINATION_REF = new Ref(
        (String) EVENT_DESTINATION_REF_JSON_FIELDS.get("id"),
        (URI) EVENT_DESTINATION_REF_JSON_FIELDS.get("uri")
    );

    public static EventSubscription EVENT_SUBSCRIPTION = new EventSubscription(
        (String) EVENT_SUBSCRIPTION_JSON_FIELDS.get("id"),
        (URI) EVENT_SUBSCRIPTION_JSON_FIELDS.get("uri"),
        (OffsetDateTime) EVENT_SUBSCRIPTION_JSON_FIELDS.get("created_at"),
        (String) EVENT_SUBSCRIPTION_JSON_FIELDS.get("metadata"),
        (String) EVENT_SUBSCRIPTION_JSON_FIELDS.get("description"),
        Collections.singletonList(EVENT_SOURCE),
        Collections.singletonList(EVENT_DESTINATION_REF)
    );

    public static void assertEventSubscriptionFields(final boolean useLiveApi, final EventSubscription eventSubscription, final List<EventSource> expectedEventSources, final List<Ref> expectedEventDestinations) {
        assertThat(eventSubscription).isNotNull();

        if (useLiveApi) {
            assertThat(eventSubscription.getId()).isNotBlank();
            assertThat(eventSubscription.getUri().getHost()).isEqualTo(NgrokApiClient.DEFAULT_BASE_URI.getHost());
            assertThat(eventSubscription.getCreatedAt()).isAfter(OffsetDateTime.now().minus(Duration.ofMinutes(20)));
        } else {
            assertThat(eventSubscription.getId()).isEqualTo(EVENT_SUBSCRIPTION_JSON_FIELDS.get("id"));
            assertThat(eventSubscription.getUri()).isEqualTo(EVENT_SUBSCRIPTION_JSON_FIELDS.get("uri"));
            assertThat(eventSubscription.getCreatedAt()).isEqualTo(EVENT_SUBSCRIPTION_JSON_FIELDS.get("created_at"));
        }

        assertThat(eventSubscription.getDescription()).isEqualTo(EVENT_SUBSCRIPTION_JSON_FIELDS.get("description"));
        assertThat(eventSubscription.getMetadata()).isEqualTo(EVENT_SUBSCRIPTION_JSON_FIELDS.get("metadata"));
        assertThat(eventSubscription.getSources()).isEqualTo(expectedEventSources);
        assertThat(eventSubscription.getDestinations()).isEqualTo(expectedEventDestinations);
    }
}
