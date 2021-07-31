package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EventStream} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventStream {
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
    @JsonProperty("fields")
    private final java.util.List<String> fields;
    @JsonProperty("event_type")
    private final String eventType;
    @JsonProperty("destination_ids")
    private final java.util.List<String> destinationIds;
    @JsonProperty("sampling_rate")
    private final double samplingRate;

    /**
     * Creates a new instance of {@link EventStream}.
     *
     * @param id Unique identifier for this Event Stream.
     * @param uri URI of the Event Stream API resource.
     * @param createdAt Timestamp when the Event Stream was created, RFC 3339 format.
     * @param metadata Arbitrary user-defined machine-readable data of this Event Stream. Optional, max 4096 bytes.
     * @param description Human-readable description of the Event Stream. Optional, max 255 bytes.
     * @param fields A list of protocol-specific fields you want to collect on each event.
     * @param eventType The protocol that determines which events will be collected. Supported values are <code>tcp_connection_closed</code> and <code>http_request_complete</code>.
     * @param destinationIds A list of Event Destination IDs which should be used for this Event Stream. Event Streams are required to have at least one Event Destination.
     * @param samplingRate The percentage of all events you would like to capture. Valid values range from 0.01, representing 1% of all events to 1.00, representing 100% of all events.
     */
    @JsonCreator
    public EventStream(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("metadata") final String metadata,
        @JsonProperty("description") final String description,
        @JsonProperty("fields") final java.util.List<String> fields,
        @JsonProperty("event_type") final String eventType,
        @JsonProperty("destination_ids") final java.util.List<String> destinationIds,
        @JsonProperty("sampling_rate") final double samplingRate
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.metadata = Objects.requireNonNull(metadata, "metadata is required");
        this.description = Objects.requireNonNull(description, "description is required");
        this.fields = Objects.requireNonNull(fields, "fields is required");
        this.eventType = Objects.requireNonNull(eventType, "eventType is required");
        this.destinationIds = Objects.requireNonNull(destinationIds, "destinationIds is required");
        this.samplingRate = Objects.requireNonNull(samplingRate, "samplingRate is required");
    }

    /**
     * Unique identifier for this Event Stream.
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of the Event Stream API resource.
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * Timestamp when the Event Stream was created, RFC 3339 format.
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Arbitrary user-defined machine-readable data of this Event Stream. Optional, max
     * 4096 bytes.
     *
     * @return the value of the property as a {@link String}
     */
    public String getMetadata() {
        return this.metadata;
    }

    /**
     * Human-readable description of the Event Stream. Optional, max 255 bytes.
     *
     * @return the value of the property as a {@link String}
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * A list of protocol-specific fields you want to collect on each event.
     *
     * @return the value of the property as a {@link java.util.List<String>}
     */
    public java.util.List<String> getFields() {
        return this.fields;
    }

    /**
     * The protocol that determines which events will be collected. Supported values
     * are <code>tcp_connection_closed</code> and <code>http_request_complete</code>.
     *
     * @return the value of the property as a {@link String}
     */
    public String getEventType() {
        return this.eventType;
    }

    /**
     * A list of Event Destination IDs which should be used for this Event Stream.
     * Event Streams are required to have at least one Event Destination.
     *
     * @return the value of the property as a {@link java.util.List<String>}
     */
    public java.util.List<String> getDestinationIds() {
        return this.destinationIds;
    }

    /**
     * The percentage of all events you would like to capture. Valid values range from
     * 0.01, representing 1% of all events to 1.00, representing 100% of all events.
     *
     * @return the value of the property as a {@link double}
     */
    public double getSamplingRate() {
        return this.samplingRate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EventStream other = (EventStream) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.createdAt.equals(other.createdAt)&&
            this.metadata.equals(other.metadata)&&
            this.description.equals(other.description)&&
            this.fields.equals(other.fields)&&
            this.eventType.equals(other.eventType)&&
            this.destinationIds.equals(other.destinationIds)&&
            this.samplingRate == other.samplingRate;
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.createdAt,
            this.metadata,
            this.description,
            this.fields,
            this.eventType,
            this.destinationIds,
            this.samplingRate
        );
    }

    @Override
    public String toString() {
        return "EventStream{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', createdAt='" + this.createdAt +
            "', metadata='" + this.metadata +
            "', description='" + this.description +
            "', fields='" + this.fields +
            "', eventType='" + this.eventType +
            "', destinationIds='" + this.destinationIds +
            "', samplingRate='" + this.samplingRate +
            "'}";
    }
}
