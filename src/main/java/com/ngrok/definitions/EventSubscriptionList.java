package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EventSubscriptionList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventSubscriptionList implements Pageable {
    @JsonProperty("event_subscriptions")
    private final java.util.List<EventSubscription> eventSubscriptions;
    @JsonProperty("uri")
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link EventSubscriptionList}.
     *
     * @param eventSubscriptions The list of all Event Subscriptions on this account.
     * @param uri URI of the Event Subscriptions list API resource.
     * @param nextPageUri URI of next page, or null if there is no next page.
     */
    @JsonCreator
    public EventSubscriptionList(
        @JsonProperty("event_subscriptions") final java.util.List<EventSubscription> eventSubscriptions,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.eventSubscriptions = Objects.requireNonNull(eventSubscriptions, "eventSubscriptions is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * The list of all Event Subscriptions on this account.
     *
     * @return the value of the property as a {@link java.util.List<EventSubscription>}
     */
    public java.util.List<EventSubscription> getEventSubscriptions() {
        return this.eventSubscriptions;
    }

    /**
     * URI of the Event Subscriptions list API resource.
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * URI of next page, or null if there is no next page.
     *
     * @return the value of the property as a {@link java.net.URI} wrapped in an {@link Optional}
     */
    public Optional<java.net.URI> getNextPageUri() {
        return this.nextPageUri;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EventSubscriptionList other = (EventSubscriptionList) o;
        return
            this.eventSubscriptions.equals(other.eventSubscriptions)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.eventSubscriptions,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "EventSubscriptionList{" +
            "eventSubscriptions='" + this.eventSubscriptions +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
