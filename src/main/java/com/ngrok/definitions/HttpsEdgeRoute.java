/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link HttpsEdgeRoute} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HttpsEdgeRoute {
    @JsonProperty("edge_id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String edgeId;
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String id;
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime createdAt;
    @JsonProperty("match_type")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String matchType;
    @JsonProperty("match")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String match;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> description;
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> metadata;
    @JsonProperty("backend")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointBackend> backend;
    @JsonProperty("ip_restriction")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointIpPolicy> ipRestriction;
    @JsonProperty("circuit_breaker")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointCircuitBreaker> circuitBreaker;
    @JsonProperty("compression")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointCompression> compression;
    @JsonProperty("request_headers")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointRequestHeaders> requestHeaders;
    @JsonProperty("response_headers")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointResponseHeaders> responseHeaders;
    @JsonProperty("webhook_verification")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointWebhookValidation> webhookVerification;
    @JsonProperty("oauth")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointOAuth> oauth;
    @JsonProperty("saml")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointSaml> saml;
    @JsonProperty("oidc")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointOidc> oidc;
    @JsonProperty("websocket_tcp_converter")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointWebsocketTcpConverter> websocketTcpConverter;
    @JsonProperty("user_agent_filter")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointUserAgentFilter> userAgentFilter;
    @JsonProperty("traffic_policy")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointTrafficPolicy> trafficPolicy;

    /**
     * Creates a new instance of {@link HttpsEdgeRoute}.
     *
     * @param edgeId unique identifier of this edge
     * @param id unique identifier of this edge route
     * @param createdAt timestamp when the edge configuration was created, RFC 3339 format
     * @param matchType Type of match to use for this route. Valid values are &#34;exact_path&#34; and &#34;path_prefix&#34;.
     * @param match Route selector: &#34;/blog&#34; or &#34;example.com&#34; or &#34;example.com/blog&#34;
     * @param uri URI of the edge API resource
     * @param description human-readable description of what this edge will be used for; optional, max 255 bytes.
     * @param metadata arbitrary user-defined machine-readable data of this edge. Optional, max 4096 bytes.
     * @param backend backend module configuration or <code>null</code>
     * @param ipRestriction ip restriction module configuration or <code>null</code>
     * @param circuitBreaker circuit breaker module configuration or <code>null</code>
     * @param compression compression module configuration or <code>null</code>
     * @param requestHeaders request headers module configuration or <code>null</code>
     * @param responseHeaders response headers module configuration or <code>null</code>
     * @param webhookVerification webhook verification module configuration or <code>null</code>
     * @param oauth oauth module configuration or <code>null</code>
     * @param saml saml module configuration or <code>null</code>
     * @param oidc oidc module configuration or <code>null</code>
     * @param websocketTcpConverter websocket to tcp adapter configuration or <code>null</code>
     * @param userAgentFilter the value of the <code>user_agent_filter</code> parameter as a {@link EndpointUserAgentFilter}
     * @param trafficPolicy the traffic policy associated with this edge or null
     */
    @JsonCreator
    public HttpsEdgeRoute(
        @JsonProperty("edge_id") final String edgeId,
        @JsonProperty("id") final String id,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("match_type") final String matchType,
        @JsonProperty("match") final String match,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("description") final Optional<String> description,
        @JsonProperty("metadata") final Optional<String> metadata,
        @JsonProperty("backend") final Optional<EndpointBackend> backend,
        @JsonProperty("ip_restriction") final Optional<EndpointIpPolicy> ipRestriction,
        @JsonProperty("circuit_breaker") final Optional<EndpointCircuitBreaker> circuitBreaker,
        @JsonProperty("compression") final Optional<EndpointCompression> compression,
        @JsonProperty("request_headers") final Optional<EndpointRequestHeaders> requestHeaders,
        @JsonProperty("response_headers") final Optional<EndpointResponseHeaders> responseHeaders,
        @JsonProperty("webhook_verification") final Optional<EndpointWebhookValidation> webhookVerification,
        @JsonProperty("oauth") final Optional<EndpointOAuth> oauth,
        @JsonProperty("saml") final Optional<EndpointSaml> saml,
        @JsonProperty("oidc") final Optional<EndpointOidc> oidc,
        @JsonProperty("websocket_tcp_converter") final Optional<EndpointWebsocketTcpConverter> websocketTcpConverter,
        @JsonProperty("user_agent_filter") final Optional<EndpointUserAgentFilter> userAgentFilter,
        @JsonProperty("traffic_policy") final Optional<EndpointTrafficPolicy> trafficPolicy
    ) {
        this.edgeId = Objects.requireNonNull(edgeId, "edgeId is required");
        this.id = Objects.requireNonNull(id, "id is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.matchType = Objects.requireNonNull(matchType, "matchType is required");
        this.match = Objects.requireNonNull(match, "match is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.description = description != null ? description : Optional.empty();
        this.metadata = metadata != null ? metadata : Optional.empty();
        this.backend = backend != null ? backend : Optional.empty();
        this.ipRestriction = ipRestriction != null ? ipRestriction : Optional.empty();
        this.circuitBreaker = circuitBreaker != null ? circuitBreaker : Optional.empty();
        this.compression = compression != null ? compression : Optional.empty();
        this.requestHeaders = requestHeaders != null ? requestHeaders : Optional.empty();
        this.responseHeaders = responseHeaders != null ? responseHeaders : Optional.empty();
        this.webhookVerification = webhookVerification != null ? webhookVerification : Optional.empty();
        this.oauth = oauth != null ? oauth : Optional.empty();
        this.saml = saml != null ? saml : Optional.empty();
        this.oidc = oidc != null ? oidc : Optional.empty();
        this.websocketTcpConverter = websocketTcpConverter != null ? websocketTcpConverter : Optional.empty();
        this.userAgentFilter = userAgentFilter != null ? userAgentFilter : Optional.empty();
        this.trafficPolicy = trafficPolicy != null ? trafficPolicy : Optional.empty();
    }

    /**
     * unique identifier of this edge
     *
     * @return the value of the property as a {@link String}
     */
    public String getEdgeId() {
        return this.edgeId;
    }

    /**
     * unique identifier of this edge route
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
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
     * Type of match to use for this route. Valid values are &#34;exact_path&#34; and
     * &#34;path_prefix&#34;.
     *
     * @return the value of the property as a {@link String}
     */
    public String getMatchType() {
        return this.matchType;
    }

    /**
     * Route selector: &#34;/blog&#34; or &#34;example.com&#34; or
     * &#34;example.com/blog&#34;
     *
     * @return the value of the property as a {@link String}
     */
    public String getMatch() {
        return this.match;
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
     * backend module configuration or <code>null</code>
     *
     * @return the value of the property as a {@link EndpointBackend} wrapped in an {@link Optional}
     */
    public Optional<EndpointBackend> getBackend() {
        return this.backend;
    }

    /**
     * ip restriction module configuration or <code>null</code>
     *
     * @return the value of the property as a {@link EndpointIpPolicy} wrapped in an {@link Optional}
     */
    public Optional<EndpointIpPolicy> getIpRestriction() {
        return this.ipRestriction;
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
     * webhook verification module configuration or <code>null</code>
     *
     * @return the value of the property as a {@link EndpointWebhookValidation} wrapped in an {@link Optional}
     */
    public Optional<EndpointWebhookValidation> getWebhookVerification() {
        return this.webhookVerification;
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

    /**
     * websocket to tcp adapter configuration or <code>null</code>
     *
     * @return the value of the property as a {@link EndpointWebsocketTcpConverter} wrapped in an {@link Optional}
     */
    public Optional<EndpointWebsocketTcpConverter> getWebsocketTcpConverter() {
        return this.websocketTcpConverter;
    }

    /**
     * Fetches the value of the <code>userAgentFilter</code> property.
     *
     * @return the value of the property as a {@link EndpointUserAgentFilter} wrapped in an {@link Optional}
     */
    public Optional<EndpointUserAgentFilter> getUserAgentFilter() {
        return this.userAgentFilter;
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
        
        final HttpsEdgeRoute other = (HttpsEdgeRoute) o;
        return
            this.edgeId.equals(other.edgeId)&&
            this.id.equals(other.id)&&
            this.createdAt.equals(other.createdAt)&&
            this.matchType.equals(other.matchType)&&
            this.match.equals(other.match)&&
            this.uri.equals(other.uri)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.backend.equals(other.backend)&&
            this.ipRestriction.equals(other.ipRestriction)&&
            this.circuitBreaker.equals(other.circuitBreaker)&&
            this.compression.equals(other.compression)&&
            this.requestHeaders.equals(other.requestHeaders)&&
            this.responseHeaders.equals(other.responseHeaders)&&
            this.webhookVerification.equals(other.webhookVerification)&&
            this.oauth.equals(other.oauth)&&
            this.saml.equals(other.saml)&&
            this.oidc.equals(other.oidc)&&
            this.websocketTcpConverter.equals(other.websocketTcpConverter)&&
            this.userAgentFilter.equals(other.userAgentFilter)&&
            this.trafficPolicy.equals(other.trafficPolicy);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.edgeId,
            this.id,
            this.createdAt,
            this.matchType,
            this.match,
            this.uri,
            this.description,
            this.metadata,
            this.backend,
            this.ipRestriction,
            this.circuitBreaker,
            this.compression,
            this.requestHeaders,
            this.responseHeaders,
            this.webhookVerification,
            this.oauth,
            this.saml,
            this.oidc,
            this.websocketTcpConverter,
            this.userAgentFilter,
            this.trafficPolicy
        );
    }

    @Override
    public String toString() {
        return "HttpsEdgeRoute{" +
            "edgeId='" + this.edgeId +
            "', id='" + this.id +
            "', createdAt='" + this.createdAt +
            "', matchType='" + this.matchType +
            "', match='" + this.match +
            "', uri='" + this.uri +
            "', description='" + this.description.orElse("(null)") +
            "', metadata='" + this.metadata.orElse("(null)") +
            "', backend='" + this.backend.map(Object::toString).orElse("(null)") +
            "', ipRestriction='" + this.ipRestriction.map(Object::toString).orElse("(null)") +
            "', circuitBreaker='" + this.circuitBreaker.map(Object::toString).orElse("(null)") +
            "', compression='" + this.compression.map(Object::toString).orElse("(null)") +
            "', requestHeaders='" + this.requestHeaders.map(Object::toString).orElse("(null)") +
            "', responseHeaders='" + this.responseHeaders.map(Object::toString).orElse("(null)") +
            "', webhookVerification='" + this.webhookVerification.map(Object::toString).orElse("(null)") +
            "', oauth='" + this.oauth.map(Object::toString).orElse("(null)") +
            "', saml='" + this.saml.map(Object::toString).orElse("(null)") +
            "', oidc='" + this.oidc.map(Object::toString).orElse("(null)") +
            "', websocketTcpConverter='" + this.websocketTcpConverter.map(Object::toString).orElse("(null)") +
            "', userAgentFilter='" + this.userAgentFilter.map(Object::toString).orElse("(null)") +
            "', trafficPolicy='" + this.trafficPolicy.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
