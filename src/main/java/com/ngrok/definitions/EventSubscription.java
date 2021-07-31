package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EventSubscription} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventSubscription {
    @JsonProperty("id")
    private final String id;
    @JsonProperty("uri")
    private final java.net.URI uri;
    @JsonProperty("created_at")
    private final java.time.OffsetDateTime createdAt;
    @JsonProperty("metadata")
    private final String metadata;
    @JsonProperty("description")
    private final String description;
    @JsonProperty("sources")
    private final java.util.List<EventSource> sources;
    @JsonProperty("destinations")
    private final java.util.List<Ref> destinations;

    /**
     * Creates a new instance of {@link EventSubscription}.
     *
     * @param id Unique identifier for this Event Subscription.
     * @param uri URI of the Event Subscription API resource.
     * @param createdAt When the Event Subscription was created (RFC 3339 format).
     * @param metadata Arbitrary customer supplied information intended to be machine readable. Optional, max 4096 chars.
     * @param description Arbitrary customer supplied information intended to be human readable. Optional, max 255 chars.
     * @param sources Sources containing the types for which this event subscription will trigger
     * @param destinations Destinations to which these events will be sent
     */
    @JsonCreator
    public EventSubscription(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("metadata") final String metadata,
        @JsonProperty("description") final String description,
        @JsonProperty("sources") final java.util.List<EventSource> sources,
        @JsonProperty("destinations") final java.util.List<Ref> destinations
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.metadata = Objects.requireNonNull(metadata, "metadata is required");
        this.description = Objects.requireNonNull(description, "description is required");
        this.sources = Objects.requireNonNull(sources, "sources is required");
        this.destinations = Objects.requireNonNull(destinations, "destinations is required");
    }

    /**
     * Unique identifier for this Event Subscription.
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of the Event Subscription API resource.
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * When the Event Subscription was created (RFC 3339 format).
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Arbitrary customer supplied information intended to be machine readable.
     * Optional, max 4096 chars.
     *
     * @return the value of the property as a {@link String}
     */
    public String getMetadata() {
        return this.metadata;
    }

    /**
     * Arbitrary customer supplied information intended to be human readable. Optional,
     * max 255 chars.
     *
     * @return the value of the property as a {@link String}
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sources containing the types for which this event subscription will trigger
     *
     * @return the value of the property as a {@link java.util.List<EventSource>}
     */
    public java.util.List<EventSource> getSources() {
        return this.sources;
    }

    /**
     * Destinations to which these events will be sent
     *
     * @return the value of the property as a {@link java.util.List<Ref>}
     */
    public java.util.List<Ref> getDestinations() {
        return this.destinations;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EventSubscription other = (EventSubscription) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.createdAt.equals(other.createdAt)&&
            this.metadata.equals(other.metadata)&&
            this.description.equals(other.description)&&
            this.sources.equals(other.sources)&&
            this.destinations.equals(other.destinations);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.createdAt,
            this.metadata,
            this.description,
            this.sources,
            this.destinations
        );
    }

    @Override
    public String toString() {
        return "EventSubscription{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', createdAt='" + this.createdAt +
            "', metadata='" + this.metadata +
            "', description='" + this.description +
            "', sources='" + this.sources +
            "', destinations='" + this.destinations +
            "'}";
    }
}
