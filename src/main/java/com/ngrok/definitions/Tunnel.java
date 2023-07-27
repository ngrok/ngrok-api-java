/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link Tunnel} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tunnel {
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String id;
    @JsonProperty("public_url")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> publicUrl;
    @JsonProperty("started_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime startedAt;
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> metadata;
    @JsonProperty("proto")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> proto;
    @JsonProperty("region")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String region;
    @JsonProperty("tunnel_session")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Ref tunnelSession;
    @JsonProperty("endpoint")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Ref> endpoint;
    @JsonProperty("labels")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.util.Map<String, String>> labels;
    @JsonProperty("backends")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.util.List<Ref>> backends;
    @JsonProperty("forwards_to")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String forwardsTo;

    /**
     * Creates a new instance of {@link Tunnel}.
     *
     * @param id unique tunnel resource identifier
     * @param publicUrl URL of the ephemeral tunnel&#39;s public endpoint
     * @param startedAt timestamp when the tunnel was initiated in RFC 3339 format
     * @param metadata user-supplied metadata for the tunnel defined in the ngrok configuration file. See the tunnel <a href="/ngrok-agent/config#common-tunnel-configuration-properties">metadata configuration option</a> In API version 0, this value was instead pulled from the top-level <a href="/ngrok-agent/config#metadata">metadata configuration option</a>.
     * @param proto tunnel protocol for ephemeral tunnels. one of <code>http</code>, <code>https</code>, <code>tcp</code> or <code>tls</code>
     * @param region identifier of tune region where the tunnel is running
     * @param tunnelSession reference object pointing to the tunnel session on which this tunnel was started
     * @param endpoint the ephemeral endpoint this tunnel is associated with, if this is an agent-initiated tunnel
     * @param labels the labels the tunnel group backends will match against, if this is a backend tunnel
     * @param backends tunnel group backends served by this backend tunnel
     * @param forwardsTo upstream address the ngrok agent forwards traffic over this tunnel to. this may be expressed as a URL or a network address.
     */
    @JsonCreator
    public Tunnel(
        @JsonProperty("id") final String id,
        @JsonProperty("public_url") final Optional<java.net.URI> publicUrl,
        @JsonProperty("started_at") final java.time.OffsetDateTime startedAt,
        @JsonProperty("metadata") final Optional<String> metadata,
        @JsonProperty("proto") final Optional<String> proto,
        @JsonProperty("region") final String region,
        @JsonProperty("tunnel_session") final Ref tunnelSession,
        @JsonProperty("endpoint") final Optional<Ref> endpoint,
        @JsonProperty("labels") final Optional<java.util.Map<String, String>> labels,
        @JsonProperty("backends") final Optional<java.util.List<Ref>> backends,
        @JsonProperty("forwards_to") final String forwardsTo
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.publicUrl = publicUrl != null ? publicUrl : Optional.empty();
        this.startedAt = Objects.requireNonNull(startedAt, "startedAt is required");
        this.metadata = metadata != null ? metadata : Optional.empty();
        this.proto = proto != null ? proto : Optional.empty();
        this.region = Objects.requireNonNull(region, "region is required");
        this.tunnelSession = Objects.requireNonNull(tunnelSession, "tunnelSession is required");
        this.endpoint = endpoint != null ? endpoint : Optional.empty();
        this.labels = labels != null ? labels : Optional.empty();
        this.backends = backends != null ? backends : Optional.empty();
        this.forwardsTo = Objects.requireNonNull(forwardsTo, "forwardsTo is required");
    }

    /**
     * unique tunnel resource identifier
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URL of the ephemeral tunnel&#39;s public endpoint
     *
     * @return the value of the property as a {@link java.net.URI} wrapped in an {@link Optional}
     */
    public Optional<java.net.URI> getPublicUrl() {
        return this.publicUrl;
    }

    /**
     * timestamp when the tunnel was initiated in RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getStartedAt() {
        return this.startedAt;
    }

    /**
     * user-supplied metadata for the tunnel defined in the ngrok configuration file.
     * See the tunnel <a
     * href="/ngrok-agent/config#common-tunnel-configuration-properties">metadata
     * configuration option</a> In API version 0, this value was instead pulled from
     * the top-level <a href="/ngrok-agent/config#metadata">metadata configuration
     * option</a>.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getMetadata() {
        return this.metadata;
    }

    /**
     * tunnel protocol for ephemeral tunnels. one of <code>http</code>,
     * <code>https</code>, <code>tcp</code> or <code>tls</code>
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getProto() {
        return this.proto;
    }

    /**
     * identifier of tune region where the tunnel is running
     *
     * @return the value of the property as a {@link String}
     */
    public String getRegion() {
        return this.region;
    }

    /**
     * reference object pointing to the tunnel session on which this tunnel was started
     *
     * @return the value of the property as a {@link Ref}
     */
    public Ref getTunnelSession() {
        return this.tunnelSession;
    }

    /**
     * the ephemeral endpoint this tunnel is associated with, if this is an
     * agent-initiated tunnel
     *
     * @return the value of the property as a {@link Ref} wrapped in an {@link Optional}
     */
    public Optional<Ref> getEndpoint() {
        return this.endpoint;
    }

    /**
     * the labels the tunnel group backends will match against, if this is a backend
     * tunnel
     *
     * @return the value of the property as a {@link java.util.Map} of {@link String} to {@link String} wrapped in an {@link Optional}
     */
    public Optional<java.util.Map<String, String>> getLabels() {
        return this.labels;
    }

    /**
     * tunnel group backends served by this backend tunnel
     *
     * @return the value of the property as a {@link java.util.List} of {@link Ref} wrapped in an {@link Optional}
     */
    public Optional<java.util.List<Ref>> getBackends() {
        return this.backends;
    }

    /**
     * upstream address the ngrok agent forwards traffic over this tunnel to. this may
     * be expressed as a URL or a network address.
     *
     * @return the value of the property as a {@link String}
     */
    public String getForwardsTo() {
        return this.forwardsTo;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final Tunnel other = (Tunnel) o;
        return
            this.id.equals(other.id)&&
            this.publicUrl.equals(other.publicUrl)&&
            this.startedAt.equals(other.startedAt)&&
            this.metadata.equals(other.metadata)&&
            this.proto.equals(other.proto)&&
            this.region.equals(other.region)&&
            this.tunnelSession.equals(other.tunnelSession)&&
            this.endpoint.equals(other.endpoint)&&
            this.labels.equals(other.labels)&&
            this.backends.equals(other.backends)&&
            this.forwardsTo.equals(other.forwardsTo);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.publicUrl,
            this.startedAt,
            this.metadata,
            this.proto,
            this.region,
            this.tunnelSession,
            this.endpoint,
            this.labels,
            this.backends,
            this.forwardsTo
        );
    }

    @Override
    public String toString() {
        return "Tunnel{" +
            "id='" + this.id +
            "', publicUrl='" + this.publicUrl.map(Object::toString).orElse("(null)") +
            "', startedAt='" + this.startedAt +
            "', metadata='" + this.metadata.orElse("(null)") +
            "', proto='" + this.proto.orElse("(null)") +
            "', region='" + this.region +
            "', tunnelSession='" + this.tunnelSession +
            "', endpoint='" + this.endpoint.map(Object::toString).orElse("(null)") +
            "', labels='" + this.labels.map(Object::toString).orElse("(null)") +
            "', backends='" + this.backends.map(Object::toString).orElse("(null)") +
            "', forwardsTo='" + this.forwardsTo +
            "'}";
    }
}
