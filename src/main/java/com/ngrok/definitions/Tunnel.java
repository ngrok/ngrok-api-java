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
    private final java.net.URI publicUrl;
    @JsonProperty("started_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime startedAt;
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String metadata;
    @JsonProperty("proto")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String proto;
    @JsonProperty("region")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String region;
    @JsonProperty("tunnel_session")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Ref tunnelSession;

    /**
     * Creates a new instance of {@link Tunnel}.
     *
     * @param id unique tunnel resource identifier
     * @param publicUrl URL of the tunnel's public endpoint
     * @param startedAt timestamp when the tunnel was initiated in RFC 3339 format
     * @param metadata user-supplied metadata for the tunnel defined in the ngrok configuration file. See the tunnel <a href="https://ngrok.com/docs#tunnel-definitions-metadata">metadata configuration option</a> In API version 0, this value was instead pulled from the top-level <a href="https://ngrok.com/docs#config_metadata">metadata configuration option</a>.
     * @param proto tunnel protocol. one of <code>http</code>, <code>https</code>, <code>tcp</code> or <code>tls</code>
     * @param region identifier of tune region where the tunnel is running
     * @param tunnelSession reference object pointing to the tunnel session on which this tunnel was started
     */
    @JsonCreator
    public Tunnel(
        @JsonProperty("id") final String id,
        @JsonProperty("public_url") final java.net.URI publicUrl,
        @JsonProperty("started_at") final java.time.OffsetDateTime startedAt,
        @JsonProperty("metadata") final String metadata,
        @JsonProperty("proto") final String proto,
        @JsonProperty("region") final String region,
        @JsonProperty("tunnel_session") final Ref tunnelSession
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.publicUrl = Objects.requireNonNull(publicUrl, "publicUrl is required");
        this.startedAt = Objects.requireNonNull(startedAt, "startedAt is required");
        this.metadata = Objects.requireNonNull(metadata, "metadata is required");
        this.proto = Objects.requireNonNull(proto, "proto is required");
        this.region = Objects.requireNonNull(region, "region is required");
        this.tunnelSession = Objects.requireNonNull(tunnelSession, "tunnelSession is required");
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
     * URL of the tunnel's public endpoint
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getPublicUrl() {
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
     * href="https://ngrok.com/docs#tunnel-definitions-metadata">metadata configuration
     * option</a> In API version 0, this value was instead pulled from the top-level <a
     * href="https://ngrok.com/docs#config_metadata">metadata configuration option</a>.
     *
     * @return the value of the property as a {@link String}
     */
    public String getMetadata() {
        return this.metadata;
    }

    /**
     * tunnel protocol. one of <code>http</code>, <code>https</code>, <code>tcp</code>
     * or <code>tls</code>
     *
     * @return the value of the property as a {@link String}
     */
    public String getProto() {
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
            this.tunnelSession.equals(other.tunnelSession);
        
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
            this.tunnelSession
        );
    }

    @Override
    public String toString() {
        return "Tunnel{" +
            "id='" + this.id +
            "', publicUrl='" + this.publicUrl +
            "', startedAt='" + this.startedAt +
            "', metadata='" + this.metadata +
            "', proto='" + this.proto +
            "', region='" + this.region +
            "', tunnelSession='" + this.tunnelSession +
            "'}";
    }
}
