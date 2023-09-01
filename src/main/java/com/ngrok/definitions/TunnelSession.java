/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link TunnelSession} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TunnelSession {
    @JsonProperty("agent_version")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String agentVersion;
    @JsonProperty("credential")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Ref credential;
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String id;
    @JsonProperty("ip")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String ip;
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> metadata;
    @JsonProperty("os")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String os;
    @JsonProperty("region")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String region;
    @JsonProperty("started_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime startedAt;
    @JsonProperty("transport")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String transport;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;

    /**
     * Creates a new instance of {@link TunnelSession}.
     *
     * @param agentVersion version of the ngrok agent that started this ngrok tunnel session
     * @param credential reference to the tunnel credential or ssh credential used by the ngrok agent to start this tunnel session
     * @param id unique tunnel session resource identifier
     * @param ip source ip address of the tunnel session
     * @param metadata arbitrary user-defined data specified in the metadata property in the ngrok configuration file. See the metadata configuration option
     * @param os operating system of the host the ngrok agent is running on
     * @param region the ngrok region identifier in which this tunnel session was started
     * @param startedAt time when the tunnel session first connected to the ngrok servers
     * @param transport the transport protocol used to start the tunnel session. Either <code>ngrok/v2</code> or <code>ssh</code>
     * @param uri URI to the API resource of the tunnel session
     */
    @JsonCreator
    public TunnelSession(
        @JsonProperty("agent_version") final String agentVersion,
        @JsonProperty("credential") final Ref credential,
        @JsonProperty("id") final String id,
        @JsonProperty("ip") final String ip,
        @JsonProperty("metadata") final Optional<String> metadata,
        @JsonProperty("os") final String os,
        @JsonProperty("region") final String region,
        @JsonProperty("started_at") final java.time.OffsetDateTime startedAt,
        @JsonProperty("transport") final String transport,
        @JsonProperty("uri") final java.net.URI uri
    ) {
        this.agentVersion = Objects.requireNonNull(agentVersion, "agentVersion is required");
        this.credential = Objects.requireNonNull(credential, "credential is required");
        this.id = Objects.requireNonNull(id, "id is required");
        this.ip = Objects.requireNonNull(ip, "ip is required");
        this.metadata = metadata != null ? metadata : Optional.empty();
        this.os = Objects.requireNonNull(os, "os is required");
        this.region = Objects.requireNonNull(region, "region is required");
        this.startedAt = Objects.requireNonNull(startedAt, "startedAt is required");
        this.transport = Objects.requireNonNull(transport, "transport is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
    }

    /**
     * version of the ngrok agent that started this ngrok tunnel session
     *
     * @return the value of the property as a {@link String}
     */
    public String getAgentVersion() {
        return this.agentVersion;
    }

    /**
     * reference to the tunnel credential or ssh credential used by the ngrok agent to
     * start this tunnel session
     *
     * @return the value of the property as a {@link Ref}
     */
    public Ref getCredential() {
        return this.credential;
    }

    /**
     * unique tunnel session resource identifier
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * source ip address of the tunnel session
     *
     * @return the value of the property as a {@link String}
     */
    public String getIp() {
        return this.ip;
    }

    /**
     * arbitrary user-defined data specified in the metadata property in the ngrok
     * configuration file. See the metadata configuration option
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getMetadata() {
        return this.metadata;
    }

    /**
     * operating system of the host the ngrok agent is running on
     *
     * @return the value of the property as a {@link String}
     */
    public String getOs() {
        return this.os;
    }

    /**
     * the ngrok region identifier in which this tunnel session was started
     *
     * @return the value of the property as a {@link String}
     */
    public String getRegion() {
        return this.region;
    }

    /**
     * time when the tunnel session first connected to the ngrok servers
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getStartedAt() {
        return this.startedAt;
    }

    /**
     * the transport protocol used to start the tunnel session. Either
     * <code>ngrok/v2</code> or <code>ssh</code>
     *
     * @return the value of the property as a {@link String}
     */
    public String getTransport() {
        return this.transport;
    }

    /**
     * URI to the API resource of the tunnel session
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
        
        final TunnelSession other = (TunnelSession) o;
        return
            this.agentVersion.equals(other.agentVersion)&&
            this.credential.equals(other.credential)&&
            this.id.equals(other.id)&&
            this.ip.equals(other.ip)&&
            this.metadata.equals(other.metadata)&&
            this.os.equals(other.os)&&
            this.region.equals(other.region)&&
            this.startedAt.equals(other.startedAt)&&
            this.transport.equals(other.transport)&&
            this.uri.equals(other.uri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.agentVersion,
            this.credential,
            this.id,
            this.ip,
            this.metadata,
            this.os,
            this.region,
            this.startedAt,
            this.transport,
            this.uri
        );
    }

    @Override
    public String toString() {
        return "TunnelSession{" +
            "agentVersion='" + this.agentVersion +
            "', credential='" + this.credential +
            "', id='" + this.id +
            "', ip='" + this.ip +
            "', metadata='" + this.metadata.orElse("(null)") +
            "', os='" + this.os +
            "', region='" + this.region +
            "', startedAt='" + this.startedAt +
            "', transport='" + this.transport +
            "', uri='" + this.uri +
            "'}";
    }
}
