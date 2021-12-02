package com.ngrok;

import com.ngrok.definitions.AwsAuth;
import com.ngrok.definitions.AwsRole;
import com.ngrok.definitions.EventDestination;
import com.ngrok.definitions.EventSource;
import com.ngrok.definitions.EventSubscription;
import com.ngrok.definitions.EventTarget;
import com.ngrok.definitions.EventTargetCloudwatchLogs;
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
    public static final EventDestination EVENT_DESTINATION = new EventDestination(
        "9876543abcdefg",
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
        URI.create("https://api.ngrok.com/event_destinations/9876543abcdefg")
    );

    public static EventSource EVENT_SOURCE = new EventSource(
        "api_key_created.v0",
        URI.create("https://api.ngrok.com/event_sources/1802749824798")
    );

    public static Ref EVENT_DESTINATION_REF = new Ref(
        EVENT_DESTINATION.getId(),
        EVENT_DESTINATION.getUri()
    );

    public static final Map<String, Object> EVENT_SOURCE_JSON_FIELDS = Stream.of(
        entry("type", EVENT_SOURCE.getType()),
        entry("uri", EVENT_SOURCE.getUri())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static final Map<String, Object> EVENT_DESTINATION_REF_JSON_FIELDS = Stream.of(
        entry("id", EVENT_DESTINATION_REF.getId()),
        entry("uri", EVENT_DESTINATION_REF.getUri())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static EventSubscription EVENT_SUBSCRIPTION = new EventSubscription(
        "abcdef123456",
        URI.create("https://api.ngrok.com/event_subscriptions/abcdef123456"),
        OffsetDateTime.parse("2021-06-08T21:09:00-07:00"),
        "this event subscription is quite meta",
        "this is a great event subscription",
        Collections.singletonList(EVENT_SOURCE),
        USE_LIVE_API ? Collections.emptyList() : Collections.singletonList(EVENT_DESTINATION_REF)
    );

    public static final Map<String, Object> EVENT_SUBSCRIPTION_JSON_FIELDS = Stream.of(
        entry("id", EVENT_SUBSCRIPTION.getId()),
        entry("uri", EVENT_SUBSCRIPTION.getUri()),
        entry("description", EVENT_SUBSCRIPTION.getDescription()),
        entry("metadata", EVENT_SUBSCRIPTION.getMetadata()),
        entry("sources", Collections.singletonList(EVENT_SOURCE_JSON_FIELDS)),
        entry("destinations", USE_LIVE_API ? Collections.emptyList() : Collections.singletonList(EVENT_DESTINATION_REF_JSON_FIELDS)),
        entry("created_at", EVENT_SUBSCRIPTION.getCreatedAt())
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static void assertEventSubscriptionFields(final EventSubscription eventSubscription, final String expectedDescription, final List<String> expectedEventDestinationIds) {
        assertThat(eventSubscription).isNotNull();

        if (USE_LIVE_API) {
            assertThat(eventSubscription.getId()).isNotBlank();
            assertThat(eventSubscription.getUri().getHost()).isEqualTo(NgrokApiClient.DEFAULT_BASE_URI.getHost());
            assertThat(eventSubscription.getCreatedAt()).isAfter(OffsetDateTime.now().minus(Duration.ofMinutes(20)));
        } else {
            assertThat(eventSubscription.getId()).isEqualTo(EVENT_SUBSCRIPTION_JSON_FIELDS.get("id"));
            assertThat(eventSubscription.getUri()).isEqualTo(EVENT_SUBSCRIPTION_JSON_FIELDS.get("uri"));
            assertThat(eventSubscription.getCreatedAt()).isEqualTo(EVENT_SUBSCRIPTION_JSON_FIELDS.get("created_at"));
        }

        assertThat(eventSubscription.getDescription()).isEqualTo(expectedDescription);
        assertThat(eventSubscription.getMetadata()).isEqualTo(EVENT_SUBSCRIPTION_JSON_FIELDS.get("metadata"));
        assertThat(eventSubscription.getSources()).size().isEqualTo(1);
        assertThat(eventSubscription.getSources().get(0).getType()).isEqualTo(EVENT_SUBSCRIPTION.getSources().get(0).getType());
        assertThat(eventSubscription.getDestinations().stream().map(Ref::getId).collect(Collectors.toList())).hasSameElementsAs(expectedEventDestinationIds);
    }

    public static void assertEventSubscriptionFields(final EventSubscription eventSubscription, final List<String> expectedEventDestinationIds) {
        assertEventSubscriptionFields(eventSubscription, EVENT_SUBSCRIPTION.getDescription(), expectedEventDestinationIds);
    }

    public static void assertEventSubscriptionFields(final EventSubscription eventSubscription, final String expectedDescription) {
        assertEventSubscriptionFields(eventSubscription, expectedDescription, EVENT_SUBSCRIPTION.getDestinations().stream().map(Ref::getId).collect(Collectors.toList()));
    }

    public static void assertEventSubscriptionFields(final EventSubscription eventSubscription) {
        assertEventSubscriptionFields(eventSubscription, EVENT_SUBSCRIPTION.getDescription());
    }
}
