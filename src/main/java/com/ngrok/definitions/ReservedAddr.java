package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link ReservedAddr} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservedAddr {
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
    @JsonProperty("addr")
    private final String addr;
    @JsonProperty("region")
    private final String region;
    @JsonProperty("endpoint_configuration")
    private final Optional<Ref> endpointConfiguration;

    /**
     * Creates a new instance of {@link ReservedAddr}.
     *
     * @param id unique reserved address resource identifier
     * @param uri URI of the reserved address API resource
     * @param createdAt timestamp when the reserved address was created, RFC 3339 format
     * @param description human-readable description of what this reserved address will be used for
     * @param metadata arbitrary user-defined machine-readable data of this reserved address. Optional, max 4096 bytes.
     * @param addr hostname:port of the reserved address that was assigned at creation time
     * @param region reserve the address in this geographic ngrok datacenter. Optional, default is us. (au, eu, ap, us, jp, in, sa)
     * @param endpointConfiguration object reference to the endpoint configuration that will be applied to traffic to this address
     */
    @JsonCreator
    public ReservedAddr(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("description") final String description,
        @JsonProperty("metadata") final String metadata,
        @JsonProperty("addr") final String addr,
        @JsonProperty("region") final String region,
        @JsonProperty("endpoint_configuration") final Optional<Ref> endpointConfiguration
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.description = Objects.requireNonNull(description, "description is required");
        this.metadata = Objects.requireNonNull(metadata, "metadata is required");
        this.addr = Objects.requireNonNull(addr, "addr is required");
        this.region = Objects.requireNonNull(region, "region is required");
        this.endpointConfiguration = endpointConfiguration != null ? endpointConfiguration : Optional.empty();
    }

    /**
     * unique reserved address resource identifier
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of the reserved address API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * timestamp when the reserved address was created, RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * human-readable description of what this reserved address will be used for
     *
     * @return the value of the property as a {@link String}
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * arbitrary user-defined machine-readable data of this reserved address. Optional,
     * max 4096 bytes.
     *
     * @return the value of the property as a {@link String}
     */
    public String getMetadata() {
        return this.metadata;
    }

    /**
     * hostname:port of the reserved address that was assigned at creation time
     *
     * @return the value of the property as a {@link String}
     */
    public String getAddr() {
        return this.addr;
    }

    /**
     * reserve the address in this geographic ngrok datacenter. Optional, default is
     * us. (au, eu, ap, us, jp, in, sa)
     *
     * @return the value of the property as a {@link String}
     */
    public String getRegion() {
        return this.region;
    }

    /**
     * object reference to the endpoint configuration that will be applied to traffic
     * to this address
     *
     * @return the value of the property as a {@link Ref} wrapped in an {@link Optional}
     */
    public Optional<Ref> getEndpointConfiguration() {
        return this.endpointConfiguration;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final ReservedAddr other = (ReservedAddr) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.createdAt.equals(other.createdAt)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.addr.equals(other.addr)&&
            this.region.equals(other.region)&&
            this.endpointConfiguration.equals(other.endpointConfiguration);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.createdAt,
            this.description,
            this.metadata,
            this.addr,
            this.region,
            this.endpointConfiguration
        );
    }

    @Override
    public String toString() {
        return "ReservedAddr{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', createdAt='" + this.createdAt +
            "', description='" + this.description +
            "', metadata='" + this.metadata +
            "', addr='" + this.addr +
            "', region='" + this.region +
            "', endpointConfiguration='" + this.endpointConfiguration.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
