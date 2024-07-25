/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link TlsEdge} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TlsEdge {
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String id;
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> description;
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> metadata;
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime createdAt;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("hostports")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.util.List<String>> hostports;
    @JsonProperty("backend")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointBackend> backend;
    @JsonProperty("ip_restriction")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointIpPolicy> ipRestriction;
    @JsonProperty("mutual_tls")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointMutualTls> mutualTls;
    @JsonProperty("tls_termination")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointTlsTermination> tlsTermination;
    @JsonProperty("traffic_policy")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointTrafficPolicy> trafficPolicy;

    /**
     * Creates a new instance of {@link TlsEdge}.
     *
     * @param id unique identifier of this edge
     * @param description human-readable description of what this edge will be used for; optional, max 255 bytes.
     * @param metadata arbitrary user-defined machine-readable data of this edge. Optional, max 4096 bytes.
     * @param createdAt timestamp when the edge configuration was created, RFC 3339 format
     * @param uri URI of the edge API resource
     * @param hostports hostports served by this edge
     * @param backend edge modules
     * @param ipRestriction the value of the <code>ip_restriction</code> parameter as a {@link EndpointIpPolicy}
     * @param mutualTls the value of the <code>mutual_tls</code> parameter as a {@link EndpointMutualTls}
     * @param tlsTermination the value of the <code>tls_termination</code> parameter as a {@link EndpointTlsTermination}
     * @param trafficPolicy the traffic policy associated with this edge or null
     */
    @JsonCreator
    public TlsEdge(
        @JsonProperty("id") final String id,
        @JsonProperty("description") final Optional<String> description,
        @JsonProperty("metadata") final Optional<String> metadata,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("hostports") final Optional<java.util.List<String>> hostports,
        @JsonProperty("backend") final Optional<EndpointBackend> backend,
        @JsonProperty("ip_restriction") final Optional<EndpointIpPolicy> ipRestriction,
        @JsonProperty("mutual_tls") final Optional<EndpointMutualTls> mutualTls,
        @JsonProperty("tls_termination") final Optional<EndpointTlsTermination> tlsTermination,
        @JsonProperty("traffic_policy") final Optional<EndpointTrafficPolicy> trafficPolicy
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.description = description != null ? description : Optional.empty();
        this.metadata = metadata != null ? metadata : Optional.empty();
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.hostports = hostports != null ? hostports : Optional.empty();
        this.backend = backend != null ? backend : Optional.empty();
        this.ipRestriction = ipRestriction != null ? ipRestriction : Optional.empty();
        this.mutualTls = mutualTls != null ? mutualTls : Optional.empty();
        this.tlsTermination = tlsTermination != null ? tlsTermination : Optional.empty();
        this.trafficPolicy = trafficPolicy != null ? trafficPolicy : Optional.empty();
    }

    /**
     * unique identifier of this edge
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * human-readable description of what this edge will be used for; optional, max 255
     * bytes.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getDescription() {
        return this.description;
    }

    /**
     * arbitrary user-defined machine-readable data of this edge. Optional, max 4096
     * bytes.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getMetadata() {
        return this.metadata;
    }

    /**
     * timestamp when the edge configuration was created, RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * URI of the edge API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * hostports served by this edge
     *
     * @return the value of the property as a {@link java.util.List} of {@link String} wrapped in an {@link Optional}
     */
    public Optional<java.util.List<String>> getHostports() {
        return this.hostports;
    }

    /**
     * edge modules
     *
     * @return the value of the property as a {@link EndpointBackend} wrapped in an {@link Optional}
     */
    public Optional<EndpointBackend> getBackend() {
        return this.backend;
    }

    /**
     * Fetches the value of the <code>ipRestriction</code> property.
     *
     * @return the value of the property as a {@link EndpointIpPolicy} wrapped in an {@link Optional}
     */
    public Optional<EndpointIpPolicy> getIpRestriction() {
        return this.ipRestriction;
    }

    /**
     * Fetches the value of the <code>mutualTls</code> property.
     *
     * @return the value of the property as a {@link EndpointMutualTls} wrapped in an {@link Optional}
     */
    public Optional<EndpointMutualTls> getMutualTls() {
        return this.mutualTls;
    }

    /**
     * Fetches the value of the <code>tlsTermination</code> property.
     *
     * @return the value of the property as a {@link EndpointTlsTermination} wrapped in an {@link Optional}
     */
    public Optional<EndpointTlsTermination> getTlsTermination() {
        return this.tlsTermination;
    }

    /**
     * the traffic policy associated with this edge or null
     *
     * @return the value of the property as a {@link EndpointTrafficPolicy} wrapped in an {@link Optional}
     */
    public Optional<EndpointTrafficPolicy> getTrafficPolicy() {
        return this.trafficPolicy;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final TlsEdge other = (TlsEdge) o;
        return
            this.id.equals(other.id)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.createdAt.equals(other.createdAt)&&
            this.uri.equals(other.uri)&&
            this.hostports.equals(other.hostports)&&
            this.backend.equals(other.backend)&&
            this.ipRestriction.equals(other.ipRestriction)&&
            this.mutualTls.equals(other.mutualTls)&&
            this.tlsTermination.equals(other.tlsTermination)&&
            this.trafficPolicy.equals(other.trafficPolicy);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.description,
            this.metadata,
            this.createdAt,
            this.uri,
            this.hostports,
            this.backend,
            this.ipRestriction,
            this.mutualTls,
            this.tlsTermination,
            this.trafficPolicy
        );
    }

    @Override
    public String toString() {
        return "TlsEdge{" +
            "id='" + this.id +
            "', description='" + this.description.orElse("(null)") +
            "', metadata='" + this.metadata.orElse("(null)") +
            "', createdAt='" + this.createdAt +
            "', uri='" + this.uri +
            "', hostports='" + this.hostports.map(Object::toString).orElse("(null)") +
            "', backend='" + this.backend.map(Object::toString).orElse("(null)") +
            "', ipRestriction='" + this.ipRestriction.map(Object::toString).orElse("(null)") +
            "', mutualTls='" + this.mutualTls.map(Object::toString).orElse("(null)") +
            "', tlsTermination='" + this.tlsTermination.map(Object::toString).orElse("(null)") +
            "', trafficPolicy='" + this.trafficPolicy.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
