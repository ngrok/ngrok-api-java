/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link FailoverBackend} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FailoverBackend {
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String id;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime createdAt;
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> description;
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> metadata;
    @JsonProperty("backends")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> backends;

    /**
     * Creates a new instance of {@link FailoverBackend}.
     *
     * @param id unique identifier for this Failover backend
     * @param uri URI of the FailoverBackend API resource
     * @param createdAt timestamp when the backend was created, RFC 3339 format
     * @param description human-readable description of this backend. Optional
     * @param metadata arbitrary user-defined machine-readable data of this backend. Optional
     * @param backends the ids of the child backends in order
     */
    @JsonCreator
    public FailoverBackend(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("description") final Optional<String> description,
        @JsonProperty("metadata") final Optional<String> metadata,
        @JsonProperty("backends") final java.util.List<String> backends
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.description = description != null ? description : Optional.empty();
        this.metadata = metadata != null ? metadata : Optional.empty();
        this.backends = backends != null ? backends : java.util.Collections.emptyList();
    }

    /**
     * unique identifier for this Failover backend
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of the FailoverBackend API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * timestamp when the backend was created, RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * human-readable description of this backend. Optional
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getDescription() {
        return this.description;
    }

    /**
     * arbitrary user-defined machine-readable data of this backend. Optional
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getMetadata() {
        return this.metadata;
    }

    /**
     * the ids of the child backends in order
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getBackends() {
        return this.backends;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final FailoverBackend other = (FailoverBackend) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.createdAt.equals(other.createdAt)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.backends.equals(other.backends);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.createdAt,
            this.description,
            this.metadata,
            this.backends
        );
    }

    @Override
    public String toString() {
        return "FailoverBackend{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', createdAt='" + this.createdAt +
            "', description='" + this.description.orElse("(null)") +
            "', metadata='" + this.metadata.orElse("(null)") +
            "', backends='" + this.backends +
            "'}";
    }
}
