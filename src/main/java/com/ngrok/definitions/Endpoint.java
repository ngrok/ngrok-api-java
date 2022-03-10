package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link Endpoint} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Endpoint {
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String id;
    @JsonProperty("region")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String region;
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime createdAt;
    @JsonProperty("updated_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime updatedAt;
    @JsonProperty("public_url")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI publicUrl;
    @JsonProperty("proto")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String proto;
    @JsonProperty("hostport")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String hostport;
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String type;
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String metadata;
    @JsonProperty("domain")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Ref> domain;
    @JsonProperty("tcp_addr")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Ref> tcpAddr;
    @JsonProperty("tunnel")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Ref> tunnel;
    @JsonProperty("edge")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Ref> edge;

    /**
     * Creates a new instance of {@link Endpoint}.
     *
     * @param id unique endpoint resource identifier
     * @param region identifier of the region this endpoint belongs to
     * @param createdAt timestamp when the endpoint was created in RFC 3339 format
     * @param updatedAt timestamp when the endpoint was updated in RFC 3339 format
     * @param publicUrl URL of the hostport served by this endpoint
     * @param proto protocol served by this endpoint. one of <code>http</code>, <code>https</code>, <code>tcp</code>, or <code>tls</code>
     * @param hostport hostport served by this endpoint (hostname:port)
     * @param type whether the endpoint is <code>ephemeral</code> (served directly by an agent-initiated tunnel) or <code>edge</code> (served by an edge)
     * @param metadata user-supplied metadata of the associated tunnel or edge object
     * @param domain the domain reserved for this endpoint
     * @param tcpAddr the address reserved for this endpoint
     * @param tunnel the tunnel serving requests to this endpoint, if this is an ephemeral endpoint
     * @param edge the edge serving requests to this endpoint, if this is an edge endpoint
     */
    @JsonCreator
    public Endpoint(
        @JsonProperty("id") final String id,
        @JsonProperty("region") final String region,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("updated_at") final java.time.OffsetDateTime updatedAt,
        @JsonProperty("public_url") final java.net.URI publicUrl,
        @JsonProperty("proto") final String proto,
        @JsonProperty("hostport") final String hostport,
        @JsonProperty("type") final String type,
        @JsonProperty("metadata") final String metadata,
        @JsonProperty("domain") final Optional<Ref> domain,
        @JsonProperty("tcp_addr") final Optional<Ref> tcpAddr,
        @JsonProperty("tunnel") final Optional<Ref> tunnel,
        @JsonProperty("edge") final Optional<Ref> edge
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.region = Objects.requireNonNull(region, "region is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.updatedAt = Objects.requireNonNull(updatedAt, "updatedAt is required");
        this.publicUrl = Objects.requireNonNull(publicUrl, "publicUrl is required");
        this.proto = Objects.requireNonNull(proto, "proto is required");
        this.hostport = Objects.requireNonNull(hostport, "hostport is required");
        this.type = Objects.requireNonNull(type, "type is required");
        this.metadata = Objects.requireNonNull(metadata, "metadata is required");
        this.domain = domain != null ? domain : Optional.empty();
        this.tcpAddr = tcpAddr != null ? tcpAddr : Optional.empty();
        this.tunnel = tunnel != null ? tunnel : Optional.empty();
        this.edge = edge != null ? edge : Optional.empty();
    }

    /**
     * unique endpoint resource identifier
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * identifier of the region this endpoint belongs to
     *
     * @return the value of the property as a {@link String}
     */
    public String getRegion() {
        return this.region;
    }

    /**
     * timestamp when the endpoint was created in RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * timestamp when the endpoint was updated in RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * URL of the hostport served by this endpoint
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getPublicUrl() {
        return this.publicUrl;
    }

    /**
     * protocol served by this endpoint. one of <code>http</code>, <code>https</code>,
     * <code>tcp</code>, or <code>tls</code>
     *
     * @return the value of the property as a {@link String}
     */
    public String getProto() {
        return this.proto;
    }

    /**
     * hostport served by this endpoint (hostname:port)
     *
     * @return the value of the property as a {@link String}
     */
    public String getHostport() {
        return this.hostport;
    }

    /**
     * whether the endpoint is <code>ephemeral</code> (served directly by an
     * agent-initiated tunnel) or <code>edge</code> (served by an edge)
     *
     * @return the value of the property as a {@link String}
     */
    public String getType() {
        return this.type;
    }

    /**
     * user-supplied metadata of the associated tunnel or edge object
     *
     * @return the value of the property as a {@link String}
     */
    public String getMetadata() {
        return this.metadata;
    }

    /**
     * the domain reserved for this endpoint
     *
     * @return the value of the property as a {@link Ref} wrapped in an {@link Optional}
     */
    public Optional<Ref> getDomain() {
        return this.domain;
    }

    /**
     * the address reserved for this endpoint
     *
     * @return the value of the property as a {@link Ref} wrapped in an {@link Optional}
     */
    public Optional<Ref> getTcpAddr() {
        return this.tcpAddr;
    }

    /**
     * the tunnel serving requests to this endpoint, if this is an ephemeral endpoint
     *
     * @return the value of the property as a {@link Ref} wrapped in an {@link Optional}
     */
    public Optional<Ref> getTunnel() {
        return this.tunnel;
    }

    /**
     * the edge serving requests to this endpoint, if this is an edge endpoint
     *
     * @return the value of the property as a {@link Ref} wrapped in an {@link Optional}
     */
    public Optional<Ref> getEdge() {
        return this.edge;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final Endpoint other = (Endpoint) o;
        return
            this.id.equals(other.id)&&
            this.region.equals(other.region)&&
            this.createdAt.equals(other.createdAt)&&
            this.updatedAt.equals(other.updatedAt)&&
            this.publicUrl.equals(other.publicUrl)&&
            this.proto.equals(other.proto)&&
            this.hostport.equals(other.hostport)&&
            this.type.equals(other.type)&&
            this.metadata.equals(other.metadata)&&
            this.domain.equals(other.domain)&&
            this.tcpAddr.equals(other.tcpAddr)&&
            this.tunnel.equals(other.tunnel)&&
            this.edge.equals(other.edge);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.region,
            this.createdAt,
            this.updatedAt,
            this.publicUrl,
            this.proto,
            this.hostport,
            this.type,
            this.metadata,
            this.domain,
            this.tcpAddr,
            this.tunnel,
            this.edge
        );
    }

    @Override
    public String toString() {
        return "Endpoint{" +
            "id='" + this.id +
            "', region='" + this.region +
            "', createdAt='" + this.createdAt +
            "', updatedAt='" + this.updatedAt +
            "', publicUrl='" + this.publicUrl +
            "', proto='" + this.proto +
            "', hostport='" + this.hostport +
            "', type='" + this.type +
            "', metadata='" + this.metadata +
            "', domain='" + this.domain.map(Object::toString).orElse("(null)") +
            "', tcpAddr='" + this.tcpAddr.map(Object::toString).orElse("(null)") +
            "', tunnel='" + this.tunnel.map(Object::toString).orElse("(null)") +
            "', edge='" + this.edge.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
