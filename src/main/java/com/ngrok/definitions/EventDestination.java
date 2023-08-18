/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EventDestination} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDestination {
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String id;
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> metadata;
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime createdAt;
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> description;
    @JsonProperty("format")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String format;
    @JsonProperty("target")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final EventTarget target;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;

    /**
     * Creates a new instance of {@link EventDestination}.
     *
     * @param id Unique identifier for this Event Destination.
     * @param metadata Arbitrary user-defined machine-readable data of this Event Destination. Optional, max 4096 bytes.
     * @param createdAt Timestamp when the Event Destination was created, RFC 3339 format.
     * @param description Human-readable description of the Event Destination. Optional, max 255 bytes.
     * @param format The output format you would like to serialize events into when sending to their target. Currently the only accepted value is <code>JSON</code>.
     * @param target An object that encapsulates where and how to send your events. An event destination must contain exactly one of the following objects, leaving the rest null: <code>kinesis</code>, <code>firehose</code>, <code>cloudwatch_logs</code>, or <code>s3</code>.
     * @param uri URI of the Event Destination API resource.
     */
    @JsonCreator
    public EventDestination(
        @JsonProperty("id") final String id,
        @JsonProperty("metadata") final Optional<String> metadata,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("description") final Optional<String> description,
        @JsonProperty("format") final String format,
        @JsonProperty("target") final EventTarget target,
        @JsonProperty("uri") final java.net.URI uri
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.metadata = metadata != null ? metadata : Optional.empty();
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.description = description != null ? description : Optional.empty();
        this.format = Objects.requireNonNull(format, "format is required");
        this.target = Objects.requireNonNull(target, "target is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
    }

    /**
     * Unique identifier for this Event Destination.
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * Arbitrary user-defined machine-readable data of this Event Destination.
     * Optional, max 4096 bytes.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getMetadata() {
        return this.metadata;
    }

    /**
     * Timestamp when the Event Destination was created, RFC 3339 format.
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Human-readable description of the Event Destination. Optional, max 255 bytes.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getDescription() {
        return this.description;
    }

    /**
     * The output format you would like to serialize events into when sending to their
     * target. Currently the only accepted value is <code>JSON</code>.
     *
     * @return the value of the property as a {@link String}
     */
    public String getFormat() {
        return this.format;
    }

    /**
     * An object that encapsulates where and how to send your events. An event
     * destination must contain exactly one of the following objects, leaving the rest
     * null: <code>kinesis</code>, <code>firehose</code>, <code>cloudwatch_logs</code>,
     * or <code>s3</code>.
     *
     * @return the value of the property as a {@link EventTarget}
     */
    public EventTarget getTarget() {
        return this.target;
    }

    /**
     * URI of the Event Destination API resource.
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EventDestination other = (EventDestination) o;
        return
            this.id.equals(other.id)&&
            this.metadata.equals(other.metadata)&&
            this.createdAt.equals(other.createdAt)&&
            this.description.equals(other.description)&&
            this.format.equals(other.format)&&
            this.target.equals(other.target)&&
            this.uri.equals(other.uri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.metadata,
            this.createdAt,
            this.description,
            this.format,
            this.target,
            this.uri
        );
    }

    @Override
    public String toString() {
        return "EventDestination{" +
            "id='" + this.id +
            "', metadata='" + this.metadata.orElse("(null)") +
            "', createdAt='" + this.createdAt +
            "', description='" + this.description.orElse("(null)") +
            "', format='" + this.format +
            "', target='" + this.target +
            "', uri='" + this.uri +
            "'}";
    }
}
