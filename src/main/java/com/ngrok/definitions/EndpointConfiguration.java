package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointConfiguration} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointConfiguration {
    @JsonProperty("id")
    private final String id;
    @JsonProperty("type")
    private final String type;
    @JsonProperty("description")
    private final String description;
    @JsonProperty("metadata")
    private final String metadata;
    @JsonProperty("created_at")
    private final java.time.OffsetDateTime createdAt;
    @JsonProperty("uri")
    private final java.net.URI uri;
    @JsonProperty("circuit_breaker")
    private final Optional<EndpointCircuitBreaker> circuitBreaker;
    @JsonProperty("compression")
    private final Optional<EndpointCompression> compression;
    @JsonProperty("request_headers")
    private final Optional<EndpointRequestHeaders> requestHeaders;
    @JsonProperty("response_headers")
    private final Optional<EndpointResponseHeaders> responseHeaders;
    @JsonProperty("ip_policy")
    private final Optional<EndpointIpPolicy> ipPolicy;
    @JsonProperty("mutual_tls")
    private final Optional<EndpointMutualTls> mutualTls;
    @JsonProperty("tls_termination")
    private final Optional<EndpointTlsTermination> tlsTermination;
    @JsonProperty("webhook_validation")
    private final Optional<EndpointWebhookValidation> webhookValidation;
    @JsonProperty("oauth")
    private final Optional<EndpointOAuth> oauth;
    @JsonProperty("logging")
    private final Optional<EndpointLogging> logging;
    @JsonProperty("saml")
    private final Optional<EndpointSaml> saml;
    @JsonProperty("oidc")
    private final Optional<EndpointOidc> oidc;

    /**
     * Creates a new instance of {@link EndpointConfiguration}.
     *
     * @param id unique identifier of this endpoint configuration
     * @param type they type of traffic this endpoint configuration can be applied to. one of: <code>http</code>, <code>https</code>, <code>tcp</code>
     * @param description human-readable description of what this endpoint configuration will be do when applied or what traffic it will be applied to. Optional, max 255 bytes
     * @param metadata arbitrary user-defined machine-readable data of this endpoint configuration. Optional, max 4096 bytes.
     * @param createdAt timestamp when the endpoint configuration was created, RFC 3339 format
     * @param uri URI of the endpoint configuration API resource
     * @param circuitBreaker circuit breaker module configuration or <code>null</code>
     * @param compression compression module configuration or <code>null</code>
     * @param requestHeaders request headers module configuration or <code>null</code>
     * @param responseHeaders response headers module configuration or <code>null</code>
     * @param ipPolicy ip policy module configuration or <code>null</code>
     * @param mutualTls mutual TLS module configuration or <code>null</code>
     * @param tlsTermination TLS termination module configuration or <code>null</code>
     * @param webhookValidation webhook validation module configuration or <code>null</code>
     * @param oauth oauth module configuration or <code>null</code>
     * @param logging logging module configuration or <code>null</code>
     * @param saml saml module configuration or <code>null</code>
     * @param oidc oidc module configuration or <code>null</code>
     */
    @JsonCreator
    public EndpointConfiguration(
        @JsonProperty("id") final String id,
        @JsonProperty("type") final String type,
        @JsonProperty("description") final String description,
        @JsonProperty("metadata") final String metadata,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("circuit_breaker") final Optional<EndpointCircuitBreaker> circuitBreaker,
        @JsonProperty("compression") final Optional<EndpointCompression> compression,
        @JsonProperty("request_headers") final Optional<EndpointRequestHeaders> requestHeaders,
        @JsonProperty("response_headers") final Optional<EndpointResponseHeaders> responseHeaders,
        @JsonProperty("ip_policy") final Optional<EndpointIpPolicy> ipPolicy,
        @JsonProperty("mutual_tls") final Optional<EndpointMutualTls> mutualTls,
        @JsonProperty("tls_termination") final Optional<EndpointTlsTermination> tlsTermination,
        @JsonProperty("webhook_validation") final Optional<EndpointWebhookValidation> webhookValidation,
        @JsonProperty("oauth") final Optional<EndpointOAuth> oauth,
        @JsonProperty("logging") final Optional<EndpointLogging> logging,
        @JsonProperty("saml") final Optional<EndpointSaml> saml,
        @JsonProperty("oidc") final Optional<EndpointOidc> oidc
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.type = Objects.requireNonNull(type, "type is required");
        this.description = Objects.requireNonNull(description, "description is required");
        this.metadata = Objects.requireNonNull(metadata, "metadata is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.circuitBreaker = circuitBreaker != null ? circuitBreaker : Optional.empty();
        this.compression = compression != null ? compression : Optional.empty();
        this.requestHeaders = requestHeaders != null ? requestHeaders : Optional.empty();
        this.responseHeaders = responseHeaders != null ? responseHeaders : Optional.empty();
        this.ipPolicy = ipPolicy != null ? ipPolicy : Optional.empty();
        this.mutualTls = mutualTls != null ? mutualTls : Optional.empty();
        this.tlsTermination = tlsTermination != null ? tlsTermination : Optional.empty();
        this.webhookValidation = webhookValidation != null ? webhookValidation : Optional.empty();
        this.oauth = oauth != null ? oauth : Optional.empty();
        this.logging = logging != null ? logging : Optional.empty();
        this.saml = saml != null ? saml : Optional.empty();
        this.oidc = oidc != null ? oidc : Optional.empty();
    }

    /**
     * unique identifier of this endpoint configuration
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * they type of traffic this endpoint configuration can be applied to. one of:
     * <code>http</code>, <code>https</code>, <code>tcp</code>
     *
     * @return the value of the property as a {@link String}
     */
    public String getType() {
        return this.type;
    }

    /**
     * human-readable description of what this endpoint configuration will be do when
     * applied or what traffic it will be applied to. Optional, max 255 bytes
     *
     * @return the value of the property as a {@link String}
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * arbitrary user-defined machine-readable data of this endpoint configuration.
     * Optional, max 4096 bytes.
     *
     * @return the value of the property as a {@link String}
     */
    public String getMetadata() {
        return this.metadata;
    }

    /**
     * timestamp when the endpoint configuration was created, RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * URI of the endpoint configuration API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * circuit breaker module configuration or <code>null</code>
     *
     * @return the value of the property as a {@link EndpointCircuitBreaker} wrapped in an {@link Optional}
     */
    public Optional<EndpointCircuitBreaker> getCircuitBreaker() {
        return this.circuitBreaker;
    }

    /**
     * compression module configuration or <code>null</code>
     *
     * @return the value of the property as a {@link EndpointCompression} wrapped in an {@link Optional}
     */
    public Optional<EndpointCompression> getCompression() {
        return this.compression;
    }

    /**
     * request headers module configuration or <code>null</code>
     *
     * @return the value of the property as a {@link EndpointRequestHeaders} wrapped in an {@link Optional}
     */
    public Optional<EndpointRequestHeaders> getRequestHeaders() {
        return this.requestHeaders;
    }

    /**
     * response headers module configuration or <code>null</code>
     *
     * @return the value of the property as a {@link EndpointResponseHeaders} wrapped in an {@link Optional}
     */
    public Optional<EndpointResponseHeaders> getResponseHeaders() {
        return this.responseHeaders;
    }

    /**
     * ip policy module configuration or <code>null</code>
     *
     * @return the value of the property as a {@link EndpointIpPolicy} wrapped in an {@link Optional}
     */
    public Optional<EndpointIpPolicy> getIpPolicy() {
        return this.ipPolicy;
    }

    /**
     * mutual TLS module configuration or <code>null</code>
     *
     * @return the value of the property as a {@link EndpointMutualTls} wrapped in an {@link Optional}
     */
    public Optional<EndpointMutualTls> getMutualTls() {
        return this.mutualTls;
    }

    /**
     * TLS termination module configuration or <code>null</code>
     *
     * @return the value of the property as a {@link EndpointTlsTermination} wrapped in an {@link Optional}
     */
    public Optional<EndpointTlsTermination> getTlsTermination() {
        return this.tlsTermination;
    }

    /**
     * webhook validation module configuration or <code>null</code>
     *
     * @return the value of the property as a {@link EndpointWebhookValidation} wrapped in an {@link Optional}
     */
    public Optional<EndpointWebhookValidation> getWebhookValidation() {
        return this.webhookValidation;
    }

    /**
     * oauth module configuration or <code>null</code>
     *
     * @return the value of the property as a {@link EndpointOAuth} wrapped in an {@link Optional}
     */
    public Optional<EndpointOAuth> getOauth() {
        return this.oauth;
    }

    /**
     * logging module configuration or <code>null</code>
     *
     * @return the value of the property as a {@link EndpointLogging} wrapped in an {@link Optional}
     */
    public Optional<EndpointLogging> getLogging() {
        return this.logging;
    }

    /**
     * saml module configuration or <code>null</code>
     *
     * @return the value of the property as a {@link EndpointSaml} wrapped in an {@link Optional}
     */
    public Optional<EndpointSaml> getSaml() {
        return this.saml;
    }

    /**
     * oidc module configuration or <code>null</code>
     *
     * @return the value of the property as a {@link EndpointOidc} wrapped in an {@link Optional}
     */
    public Optional<EndpointOidc> getOidc() {
        return this.oidc;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointConfiguration other = (EndpointConfiguration) o;
        return
            this.id.equals(other.id)&&
            this.type.equals(other.type)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.createdAt.equals(other.createdAt)&&
            this.uri.equals(other.uri)&&
            this.circuitBreaker.equals(other.circuitBreaker)&&
            this.compression.equals(other.compression)&&
            this.requestHeaders.equals(other.requestHeaders)&&
            this.responseHeaders.equals(other.responseHeaders)&&
            this.ipPolicy.equals(other.ipPolicy)&&
            this.mutualTls.equals(other.mutualTls)&&
            this.tlsTermination.equals(other.tlsTermination)&&
            this.webhookValidation.equals(other.webhookValidation)&&
            this.oauth.equals(other.oauth)&&
            this.logging.equals(other.logging)&&
            this.saml.equals(other.saml)&&
            this.oidc.equals(other.oidc);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.type,
            this.description,
            this.metadata,
            this.createdAt,
            this.uri,
            this.circuitBreaker,
            this.compression,
            this.requestHeaders,
            this.responseHeaders,
            this.ipPolicy,
            this.mutualTls,
            this.tlsTermination,
            this.webhookValidation,
            this.oauth,
            this.logging,
            this.saml,
            this.oidc
        );
    }

    @Override
    public String toString() {
        return "EndpointConfiguration{" +
            "id='" + this.id +
            "', type='" + this.type +
            "', description='" + this.description +
            "', metadata='" + this.metadata +
            "', createdAt='" + this.createdAt +
            "', uri='" + this.uri +
            "', circuitBreaker='" + this.circuitBreaker.map(Object::toString).orElse("(null)") +
            "', compression='" + this.compression.map(Object::toString).orElse("(null)") +
            "', requestHeaders='" + this.requestHeaders.map(Object::toString).orElse("(null)") +
            "', responseHeaders='" + this.responseHeaders.map(Object::toString).orElse("(null)") +
            "', ipPolicy='" + this.ipPolicy.map(Object::toString).orElse("(null)") +
            "', mutualTls='" + this.mutualTls.map(Object::toString).orElse("(null)") +
            "', tlsTermination='" + this.tlsTermination.map(Object::toString).orElse("(null)") +
            "', webhookValidation='" + this.webhookValidation.map(Object::toString).orElse("(null)") +
            "', oauth='" + this.oauth.map(Object::toString).orElse("(null)") +
            "', logging='" + this.logging.map(Object::toString).orElse("(null)") +
            "', saml='" + this.saml.map(Object::toString).orElse("(null)") +
            "', oidc='" + this.oidc.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
