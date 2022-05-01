package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link HttpsEdge} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HttpsEdge {
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String id;
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String description;
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String metadata;
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime createdAt;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("hostports")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.util.List<String>> hostports;
    @JsonProperty("mutual_tls")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointMutualTls> mutualTls;
    @JsonProperty("tls_termination")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointTlsTermination> tlsTermination;
    @JsonProperty("routes")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<HttpsEdgeRoute> routes;

    /**
     * Creates a new instance of {@link HttpsEdge}.
     *
     * @param id unique identifier of this edge
     * @param description human-readable description of what this edge will be used for; optional, max 255 bytes.
     * @param metadata arbitrary user-defined machine-readable data of this edge; optional, max 4096 bytes.
     * @param createdAt timestamp when the edge configuration was created, RFC 3339 format
     * @param uri URI of the edge API resource
     * @param hostports hostports served by this edge
     * @param mutualTls edge modules
     * @param tlsTermination the value of the <code>tls_termination</code> parameter as a {@link EndpointTlsTermination}
     * @param routes routes
     */
    @JsonCreator
    public HttpsEdge(
        @JsonProperty("id") final String id,
        @JsonProperty("description") final String description,
        @JsonProperty("metadata") final String metadata,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("hostports") final Optional<java.util.List<String>> hostports,
        @JsonProperty("mutual_tls") final Optional<EndpointMutualTls> mutualTls,
        @JsonProperty("tls_termination") final Optional<EndpointTlsTermination> tlsTermination,
        @JsonProperty("routes") final java.util.List<HttpsEdgeRoute> routes
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.description = Objects.requireNonNull(description, "description is required");
        this.metadata = Objects.requireNonNull(metadata, "metadata is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.hostports = hostports != null ? hostports : Optional.empty();
        this.mutualTls = mutualTls != null ? mutualTls : Optional.empty();
        this.tlsTermination = tlsTermination != null ? tlsTermination : Optional.empty();
        this.routes = routes != null ? routes : java.util.Collections.emptyList();
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
     * @return the value of the property as a {@link String}
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * arbitrary user-defined machine-readable data of this edge; optional, max 4096
     * bytes.
     *
     * @return the value of the property as a {@link String}
     */
    public String getMetadata() {
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
     * routes
     *
     * @return the value of the property as a {@link java.util.List} of {@link HttpsEdgeRoute}
     */
    public java.util.List<HttpsEdgeRoute> getRoutes() {
        return this.routes;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final HttpsEdge other = (HttpsEdge) o;
        return
            this.id.equals(other.id)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.createdAt.equals(other.createdAt)&&
            this.uri.equals(other.uri)&&
            this.hostports.equals(other.hostports)&&
            this.mutualTls.equals(other.mutualTls)&&
            this.tlsTermination.equals(other.tlsTermination)&&
            this.routes.equals(other.routes);
        
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
            this.mutualTls,
            this.tlsTermination,
            this.routes
        );
    }

    @Override
    public String toString() {
        return "HttpsEdge{" +
            "id='" + this.id +
            "', description='" + this.description +
            "', metadata='" + this.metadata +
            "', createdAt='" + this.createdAt +
            "', uri='" + this.uri +
            "', hostports='" + this.hostports.map(Object::toString).orElse("(null)") +
            "', mutualTls='" + this.mutualTls.map(Object::toString).orElse("(null)") +
            "', tlsTermination='" + this.tlsTermination.map(Object::toString).orElse("(null)") +
            "', routes='" + this.routes +
            "'}";
    }
}
