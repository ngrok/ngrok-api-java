/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link ReservedAddr} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservedAddr {
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
    @JsonProperty("addr")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String addr;
    @JsonProperty("region")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String region;

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
     */
    @JsonCreator
    public ReservedAddr(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("description") final Optional<String> description,
        @JsonProperty("metadata") final Optional<String> metadata,
        @JsonProperty("addr") final String addr,
        @JsonProperty("region") final String region
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.description = description != null ? description : Optional.empty();
        this.metadata = metadata != null ? metadata : Optional.empty();
        this.addr = Objects.requireNonNull(addr, "addr is required");
        this.region = Objects.requireNonNull(region, "region is required");
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
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getDescription() {
        return this.description;
    }

    /**
     * arbitrary user-defined machine-readable data of this reserved address. Optional,
     * max 4096 bytes.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getMetadata() {
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
            this.region.equals(other.region);
        
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
            this.region
        );
    }

    @Override
    public String toString() {
        return "ReservedAddr{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', createdAt='" + this.createdAt +
            "', description='" + this.description.orElse("(null)") +
            "', metadata='" + this.metadata.orElse("(null)") +
            "', addr='" + this.addr +
            "', region='" + this.region +
            "'}";
    }
}
