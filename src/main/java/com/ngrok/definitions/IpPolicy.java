package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link IpPolicy} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IpPolicy {
    @JsonProperty("id")
    private final String id;
    @JsonProperty("uri")
    private final java.net.URI uri;
    @JsonProperty("created_at")
    private final java.time.OffsetDateTime createdAt;
    @JsonProperty("description")
    private final String description;
    @JsonProperty("metadata")
    private final String metadata;
    @JsonProperty("action")
    private final String action;

    /**
     * Creates a new instance of {@link IpPolicy}.
     *
     * @param id unique identifier for this IP policy
     * @param uri URI of the IP Policy API resource
     * @param createdAt timestamp when the IP policy was created, RFC 3339 format
     * @param description human-readable description of the source IPs of this IP policy. optional, max 255 bytes.
     * @param metadata arbitrary user-defined machine-readable data of this IP policy. optional, max 4096 bytes.
     * @param action the IP policy action. Supported values are <code>allow</code> or <code>deny</code>
     */
    @JsonCreator
    public IpPolicy(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("description") final String description,
        @JsonProperty("metadata") final String metadata,
        @JsonProperty("action") final String action
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.description = Objects.requireNonNull(description, "description is required");
        this.metadata = Objects.requireNonNull(metadata, "metadata is required");
        this.action = Objects.requireNonNull(action, "action is required");
    }

    /**
     * unique identifier for this IP policy
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of the IP Policy API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * timestamp when the IP policy was created, RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * human-readable description of the source IPs of this IP policy. optional, max
     * 255 bytes.
     *
     * @return the value of the property as a {@link String}
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * arbitrary user-defined machine-readable data of this IP policy. optional, max
     * 4096 bytes.
     *
     * @return the value of the property as a {@link String}
     */
    public String getMetadata() {
        return this.metadata;
    }

    /**
     * the IP policy action. Supported values are <code>allow</code> or
     * <code>deny</code>
     *
     * @return the value of the property as a {@link String}
     */
    public String getAction() {
        return this.action;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final IpPolicy other = (IpPolicy) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.createdAt.equals(other.createdAt)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.action.equals(other.action);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.createdAt,
            this.description,
            this.metadata,
            this.action
        );
    }

    @Override
    public String toString() {
        return "IpPolicy{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', createdAt='" + this.createdAt +
            "', description='" + this.description +
            "', metadata='" + this.metadata +
            "', action='" + this.action +
            "'}";
    }
}
