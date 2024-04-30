/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link StaticBackend} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StaticBackend {
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
    @JsonProperty("address")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String address;
    @JsonProperty("tls")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final StaticBackendTls tls;

    /**
     * Creates a new instance of {@link StaticBackend}.
     *
     * @param id unique identifier for this static backend
     * @param uri URI of the StaticBackend API resource
     * @param createdAt timestamp when the backend was created, RFC 3339 format
     * @param description human-readable description of this backend. Optional
     * @param metadata arbitrary user-defined machine-readable data of this backend. Optional
     * @param address the address to forward to
     * @param tls tls configuration to use
     */
    @JsonCreator
    public StaticBackend(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("description") final Optional<String> description,
        @JsonProperty("metadata") final Optional<String> metadata,
        @JsonProperty("address") final String address,
        @JsonProperty("tls") final StaticBackendTls tls
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.description = description != null ? description : Optional.empty();
        this.metadata = metadata != null ? metadata : Optional.empty();
        this.address = Objects.requireNonNull(address, "address is required");
        this.tls = Objects.requireNonNull(tls, "tls is required");
    }

    /**
     * unique identifier for this static backend
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of the StaticBackend API resource
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
     * the address to forward to
     *
     * @return the value of the property as a {@link String}
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * tls configuration to use
     *
     * @return the value of the property as a {@link StaticBackendTls}
     */
    public StaticBackendTls getTls() {
        return this.tls;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final StaticBackend other = (StaticBackend) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.createdAt.equals(other.createdAt)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.address.equals(other.address)&&
            this.tls.equals(other.tls);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.createdAt,
            this.description,
            this.metadata,
            this.address,
            this.tls
        );
    }

    @Override
    public String toString() {
        return "StaticBackend{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', createdAt='" + this.createdAt +
            "', description='" + this.description.orElse("(null)") +
            "', metadata='" + this.metadata.orElse("(null)") +
            "', address='" + this.address +
            "', tls='" + this.tls +
            "'}";
    }
}
