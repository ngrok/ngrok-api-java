/* Code generated for API Clients. DO NOT EDIT. */

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
    private final Optional<String> region;
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.time.OffsetDateTime> createdAt;
    @JsonProperty("updated_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.time.OffsetDateTime> updatedAt;
    @JsonProperty("public_url")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI publicUrl;
    @JsonProperty("proto")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String proto;
    @JsonProperty("scheme")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> scheme;
    @JsonProperty("hostport")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String hostport;
    @JsonProperty("host")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> host;
    @JsonProperty("port")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Long> port;
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String type;
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> metadata;
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> description;
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
    @JsonProperty("upstream_url")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> upstreamUrl;
    @JsonProperty("upstream_proto")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> upstreamProto;
    @JsonProperty("url")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> url;
    @JsonProperty("principal")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Ref> principal;
    @JsonProperty("principal_id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Ref> principalId;
    @JsonProperty("traffic_policy")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> trafficPolicy;
    @JsonProperty("bindings")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.util.List<String>> bindings;
    @JsonProperty("tunnel_session")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Ref> tunnelSession;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> uri;
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> name;

    /**
     * Creates a new instance of {@link Endpoint}.
     *
     * @param id unique endpoint resource identifier
     * @param region identifier of the region this endpoint belongs to
     * @param createdAt timestamp when the endpoint was created in RFC 3339 format
     * @param updatedAt timestamp when the endpoint was updated in RFC 3339 format
     * @param publicUrl URL of the hostport served by this endpoint
     * @param proto protocol served by this endpoint. one of <code>http</code>, <code>https</code>, <code>tcp</code>, or <code>tls</code>
     * @param scheme the value of the <code>scheme</code> parameter as a {@link String}
     * @param hostport hostport served by this endpoint (hostname:port) -&gt; soon to be deprecated
     * @param host the value of the <code>host</code> parameter as a {@link String}
     * @param port the value of the <code>port</code> parameter as a {@link long}
     * @param type whether the endpoint is <code>ephemeral</code> (served directly by an agent-initiated tunnel) or <code>edge</code> (served by an edge) or <code>cloud (represents a cloud endpoint)</code>
     * @param metadata user-supplied metadata of the associated tunnel or edge object
     * @param description user-supplied description of the associated tunnel
     * @param domain the domain reserved for this endpoint
     * @param tcpAddr the address reserved for this endpoint
     * @param tunnel the tunnel serving requests to this endpoint, if this is an ephemeral endpoint
     * @param edge the edge serving requests to this endpoint, if this is an edge endpoint
     * @param upstreamUrl the local address the tunnel forwards to
     * @param upstreamProto the protocol the agent uses to forward with
     * @param url the url of the endpoint
     * @param principal The ID of the owner (bot or user) that owns this endpoint
     * @param principalId TODO: deprecate me!
     * @param trafficPolicy The traffic policy attached to this endpoint
     * @param bindings the bindings associated with this endpoint
     * @param tunnelSession The tunnel session of the agent for this endpoint
     * @param uri URI of the clep API resource
     * @param name user supplied name for the endpoint
     */
    @JsonCreator
    public Endpoint(
        @JsonProperty("id") final String id,
        @JsonProperty("region") final Optional<String> region,
        @JsonProperty("created_at") final Optional<java.time.OffsetDateTime> createdAt,
        @JsonProperty("updated_at") final Optional<java.time.OffsetDateTime> updatedAt,
        @JsonProperty("public_url") final java.net.URI publicUrl,
        @JsonProperty("proto") final String proto,
        @JsonProperty("scheme") final Optional<String> scheme,
        @JsonProperty("hostport") final String hostport,
        @JsonProperty("host") final Optional<String> host,
        @JsonProperty("port") final Optional<Long> port,
        @JsonProperty("type") final String type,
        @JsonProperty("metadata") final Optional<String> metadata,
        @JsonProperty("description") final Optional<String> description,
        @JsonProperty("domain") final Optional<Ref> domain,
        @JsonProperty("tcp_addr") final Optional<Ref> tcpAddr,
        @JsonProperty("tunnel") final Optional<Ref> tunnel,
        @JsonProperty("edge") final Optional<Ref> edge,
        @JsonProperty("upstream_url") final Optional<String> upstreamUrl,
        @JsonProperty("upstream_proto") final Optional<String> upstreamProto,
        @JsonProperty("url") final Optional<String> url,
        @JsonProperty("principal") final Optional<Ref> principal,
        @JsonProperty("principal_id") final Optional<Ref> principalId,
        @JsonProperty("traffic_policy") final Optional<String> trafficPolicy,
        @JsonProperty("bindings") final Optional<java.util.List<String>> bindings,
        @JsonProperty("tunnel_session") final Optional<Ref> tunnelSession,
        @JsonProperty("uri") final Optional<java.net.URI> uri,
        @JsonProperty("name") final Optional<String> name
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.region = region != null ? region : Optional.empty();
        this.createdAt = createdAt != null ? createdAt : Optional.empty();
        this.updatedAt = updatedAt != null ? updatedAt : Optional.empty();
        this.publicUrl = Objects.requireNonNull(publicUrl, "publicUrl is required");
        this.proto = Objects.requireNonNull(proto, "proto is required");
        this.scheme = scheme != null ? scheme : Optional.empty();
        this.hostport = Objects.requireNonNull(hostport, "hostport is required");
        this.host = host != null ? host : Optional.empty();
        this.port = port != null ? port : Optional.empty();
        this.type = Objects.requireNonNull(type, "type is required");
        this.metadata = metadata != null ? metadata : Optional.empty();
        this.description = description != null ? description : Optional.empty();
        this.domain = domain != null ? domain : Optional.empty();
        this.tcpAddr = tcpAddr != null ? tcpAddr : Optional.empty();
        this.tunnel = tunnel != null ? tunnel : Optional.empty();
        this.edge = edge != null ? edge : Optional.empty();
        this.upstreamUrl = upstreamUrl != null ? upstreamUrl : Optional.empty();
        this.upstreamProto = upstreamProto != null ? upstreamProto : Optional.empty();
        this.url = url != null ? url : Optional.empty();
        this.principal = principal != null ? principal : Optional.empty();
        this.principalId = principalId != null ? principalId : Optional.empty();
        this.trafficPolicy = trafficPolicy != null ? trafficPolicy : Optional.empty();
        this.bindings = bindings != null ? bindings : Optional.empty();
        this.tunnelSession = tunnelSession != null ? tunnelSession : Optional.empty();
        this.uri = uri != null ? uri : Optional.empty();
        this.name = name != null ? name : Optional.empty();
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
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getRegion() {
        return this.region;
    }

    /**
     * timestamp when the endpoint was created in RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime} wrapped in an {@link Optional}
     */
    public Optional<java.time.OffsetDateTime> getCreatedAt() {
        return this.createdAt;
    }

    /**
     * timestamp when the endpoint was updated in RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime} wrapped in an {@link Optional}
     */
    public Optional<java.time.OffsetDateTime> getUpdatedAt() {
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
     * Fetches the value of the <code>scheme</code> property.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getScheme() {
        return this.scheme;
    }

    /**
     * hostport served by this endpoint (hostname:port) -&gt; soon to be deprecated
     *
     * @return the value of the property as a {@link String}
     */
    public String getHostport() {
        return this.hostport;
    }

    /**
     * Fetches the value of the <code>host</code> property.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getHost() {
        return this.host;
    }

    /**
     * Fetches the value of the <code>port</code> property.
     *
     * @return the value of the property as a {@link long} wrapped in an {@link Optional}
     */
    public Optional<Long> getPort() {
        return this.port;
    }

    /**
     * whether the endpoint is <code>ephemeral</code> (served directly by an
     * agent-initiated tunnel) or <code>edge</code> (served by an edge) or <code>cloud
     * (represents a cloud endpoint)</code>
     *
     * @return the value of the property as a {@link String}
     */
    public String getType() {
        return this.type;
    }

    /**
     * user-supplied metadata of the associated tunnel or edge object
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getMetadata() {
        return this.metadata;
    }

    /**
     * user-supplied description of the associated tunnel
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getDescription() {
        return this.description;
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

    /**
     * the local address the tunnel forwards to
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getUpstreamUrl() {
        return this.upstreamUrl;
    }

    /**
     * the protocol the agent uses to forward with
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getUpstreamProto() {
        return this.upstreamProto;
    }

    /**
     * the url of the endpoint
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getUrl() {
        return this.url;
    }

    /**
     * The ID of the owner (bot or user) that owns this endpoint
     *
     * @return the value of the property as a {@link Ref} wrapped in an {@link Optional}
     */
    public Optional<Ref> getPrincipal() {
        return this.principal;
    }

    /**
     * TODO: deprecate me!
     *
     * @return the value of the property as a {@link Ref} wrapped in an {@link Optional}
     */
    public Optional<Ref> getPrincipalId() {
        return this.principalId;
    }

    /**
     * The traffic policy attached to this endpoint
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getTrafficPolicy() {
        return this.trafficPolicy;
    }

    /**
     * the bindings associated with this endpoint
     *
     * @return the value of the property as a {@link java.util.List} of {@link String} wrapped in an {@link Optional}
     */
    public Optional<java.util.List<String>> getBindings() {
        return this.bindings;
    }

    /**
     * The tunnel session of the agent for this endpoint
     *
     * @return the value of the property as a {@link Ref} wrapped in an {@link Optional}
     */
    public Optional<Ref> getTunnelSession() {
        return this.tunnelSession;
    }

    /**
     * URI of the clep API resource
     *
     * @return the value of the property as a {@link java.net.URI} wrapped in an {@link Optional}
     */
    public Optional<java.net.URI> getUri() {
        return this.uri;
    }

    /**
     * user supplied name for the endpoint
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getName() {
        return this.name;
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
            this.scheme.equals(other.scheme)&&
            this.hostport.equals(other.hostport)&&
            this.host.equals(other.host)&&
            this.port.equals(other.port)&&
            this.type.equals(other.type)&&
            this.metadata.equals(other.metadata)&&
            this.description.equals(other.description)&&
            this.domain.equals(other.domain)&&
            this.tcpAddr.equals(other.tcpAddr)&&
            this.tunnel.equals(other.tunnel)&&
            this.edge.equals(other.edge)&&
            this.upstreamUrl.equals(other.upstreamUrl)&&
            this.upstreamProto.equals(other.upstreamProto)&&
            this.url.equals(other.url)&&
            this.principal.equals(other.principal)&&
            this.principalId.equals(other.principalId)&&
            this.trafficPolicy.equals(other.trafficPolicy)&&
            this.bindings.equals(other.bindings)&&
            this.tunnelSession.equals(other.tunnelSession)&&
            this.uri.equals(other.uri)&&
            this.name.equals(other.name);
        
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
            this.scheme,
            this.hostport,
            this.host,
            this.port,
            this.type,
            this.metadata,
            this.description,
            this.domain,
            this.tcpAddr,
            this.tunnel,
            this.edge,
            this.upstreamUrl,
            this.upstreamProto,
            this.url,
            this.principal,
            this.principalId,
            this.trafficPolicy,
            this.bindings,
            this.tunnelSession,
            this.uri,
            this.name
        );
    }

    @Override
    public String toString() {
        return "Endpoint{" +
            "id='" + this.id +
            "', region='" + this.region.orElse("(null)") +
            "', createdAt='" + this.createdAt.map(Object::toString).orElse("(null)") +
            "', updatedAt='" + this.updatedAt.map(Object::toString).orElse("(null)") +
            "', publicUrl='" + this.publicUrl +
            "', proto='" + this.proto +
            "', scheme='" + this.scheme.orElse("(null)") +
            "', hostport='" + this.hostport +
            "', host='" + this.host.orElse("(null)") +
            "', port='" + this.port.map(Object::toString).orElse("(null)") +
            "', type='" + this.type +
            "', metadata='" + this.metadata.orElse("(null)") +
            "', description='" + this.description.orElse("(null)") +
            "', domain='" + this.domain.map(Object::toString).orElse("(null)") +
            "', tcpAddr='" + this.tcpAddr.map(Object::toString).orElse("(null)") +
            "', tunnel='" + this.tunnel.map(Object::toString).orElse("(null)") +
            "', edge='" + this.edge.map(Object::toString).orElse("(null)") +
            "', upstreamUrl='" + this.upstreamUrl.orElse("(null)") +
            "', upstreamProto='" + this.upstreamProto.orElse("(null)") +
            "', url='" + this.url.orElse("(null)") +
            "', principal='" + this.principal.map(Object::toString).orElse("(null)") +
            "', principalId='" + this.principalId.map(Object::toString).orElse("(null)") +
            "', trafficPolicy='" + this.trafficPolicy.orElse("(null)") +
            "', bindings='" + this.bindings.map(Object::toString).orElse("(null)") +
            "', tunnelSession='" + this.tunnelSession.map(Object::toString).orElse("(null)") +
            "', uri='" + this.uri.map(Object::toString).orElse("(null)") +
            "', name='" + this.name.orElse("(null)") +
            "'}";
    }
}
