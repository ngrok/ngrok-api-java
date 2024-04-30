/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.services;

import com.ngrok.NgrokApiClient;
import com.ngrok.definitions.*;

import java.util.AbstractMap;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * An API client for {@link EdgesHttpsRoutes}.
 *
 * See also <a href="https://ngrok.com/docs/api#api-edges-https-routes">https://ngrok.com/docs/api#api-edges-https-routes</a>.
 */
public class EdgesHttpsRoutes {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for EdgesHttpsRoutes.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public EdgesHttpsRoutes(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class CreateCallBuilder {
        private final String edgeId;
        private final String matchType;
        private final String match;
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private Optional<EndpointBackendMutate> backend = Optional.empty();
        private Optional<EndpointIpPolicyMutate> ipRestriction = Optional.empty();
        private Optional<EndpointCircuitBreaker> circuitBreaker = Optional.empty();
        private Optional<EndpointCompression> compression = Optional.empty();
        private Optional<EndpointRequestHeaders> requestHeaders = Optional.empty();
        private Optional<EndpointResponseHeaders> responseHeaders = Optional.empty();
        private Optional<EndpointWebhookValidation> webhookVerification = Optional.empty();
        private Optional<EndpointOAuth> oauth = Optional.empty();
        private Optional<EndpointSamlMutate> saml = Optional.empty();
        private Optional<EndpointOidc> oidc = Optional.empty();
        private Optional<EndpointWebsocketTcpConverter> websocketTcpConverter = Optional.empty();
        private Optional<EndpointUserAgentFilter> userAgentFilter = Optional.empty();
        private Optional<EndpointPolicy> policy = Optional.empty();

        private CreateCallBuilder(
            final String edgeId,
            final String matchType,
            final String match
        ) {
            this.edgeId = Objects.requireNonNull(edgeId, "edgeId is required");
            this.matchType = Objects.requireNonNull(matchType, "matchType is required");
            this.match = Objects.requireNonNull(match, "match is required");
        }
        
        /**
         * human-readable description of what this edge will be used for; optional, max 255
         * bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final String description) {
            this.description = Optional.of(Objects.requireNonNull(description, "description is required"));
            return this;
        }

        /**
         * human-readable description of what this edge will be used for; optional, max 255
         * bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this edge. Optional, max 4096
         * bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.of(Objects.requireNonNull(metadata, "metadata is required"));
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this edge. Optional, max 4096
         * bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * backend module configuration or <code>null</code>
         *
         * @param backend the value of the backend parameter as a {@link EndpointBackendMutate}
         * @return the call builder instance
         */
        public CreateCallBuilder backend(final EndpointBackendMutate backend) {
            this.backend = Optional.of(Objects.requireNonNull(backend, "backend is required"));
            return this;
        }

        /**
         * backend module configuration or <code>null</code>
         *
         * @param backend the value of the backend parameter as an {@link Optional} of {@link EndpointBackendMutate}
         * @return the call builder instance
         */
        public CreateCallBuilder backend(final Optional<EndpointBackendMutate> backend) {
            this.backend = Objects.requireNonNull(backend, "backend is required");
            return this;
        }
        
        /**
         * ip restriction module configuration or <code>null</code>
         *
         * @param ipRestriction the value of the ip_restriction parameter as a {@link EndpointIpPolicyMutate}
         * @return the call builder instance
         */
        public CreateCallBuilder ipRestriction(final EndpointIpPolicyMutate ipRestriction) {
            this.ipRestriction = Optional.of(Objects.requireNonNull(ipRestriction, "ipRestriction is required"));
            return this;
        }

        /**
         * ip restriction module configuration or <code>null</code>
         *
         * @param ipRestriction the value of the ip_restriction parameter as an {@link Optional} of {@link EndpointIpPolicyMutate}
         * @return the call builder instance
         */
        public CreateCallBuilder ipRestriction(final Optional<EndpointIpPolicyMutate> ipRestriction) {
            this.ipRestriction = Objects.requireNonNull(ipRestriction, "ipRestriction is required");
            return this;
        }
        
        /**
         * circuit breaker module configuration or <code>null</code>
         *
         * @param circuitBreaker the value of the circuit_breaker parameter as a {@link EndpointCircuitBreaker}
         * @return the call builder instance
         */
        public CreateCallBuilder circuitBreaker(final EndpointCircuitBreaker circuitBreaker) {
            this.circuitBreaker = Optional.of(Objects.requireNonNull(circuitBreaker, "circuitBreaker is required"));
            return this;
        }

        /**
         * circuit breaker module configuration or <code>null</code>
         *
         * @param circuitBreaker the value of the circuit_breaker parameter as an {@link Optional} of {@link EndpointCircuitBreaker}
         * @return the call builder instance
         */
        public CreateCallBuilder circuitBreaker(final Optional<EndpointCircuitBreaker> circuitBreaker) {
            this.circuitBreaker = Objects.requireNonNull(circuitBreaker, "circuitBreaker is required");
            return this;
        }
        
        /**
         * compression module configuration or <code>null</code>
         *
         * @param compression the value of the compression parameter as a {@link EndpointCompression}
         * @return the call builder instance
         */
        public CreateCallBuilder compression(final EndpointCompression compression) {
            this.compression = Optional.of(Objects.requireNonNull(compression, "compression is required"));
            return this;
        }

        /**
         * compression module configuration or <code>null</code>
         *
         * @param compression the value of the compression parameter as an {@link Optional} of {@link EndpointCompression}
         * @return the call builder instance
         */
        public CreateCallBuilder compression(final Optional<EndpointCompression> compression) {
            this.compression = Objects.requireNonNull(compression, "compression is required");
            return this;
        }
        
        /**
         * request headers module configuration or <code>null</code>
         *
         * @param requestHeaders the value of the request_headers parameter as a {@link EndpointRequestHeaders}
         * @return the call builder instance
         */
        public CreateCallBuilder requestHeaders(final EndpointRequestHeaders requestHeaders) {
            this.requestHeaders = Optional.of(Objects.requireNonNull(requestHeaders, "requestHeaders is required"));
            return this;
        }

        /**
         * request headers module configuration or <code>null</code>
         *
         * @param requestHeaders the value of the request_headers parameter as an {@link Optional} of {@link EndpointRequestHeaders}
         * @return the call builder instance
         */
        public CreateCallBuilder requestHeaders(final Optional<EndpointRequestHeaders> requestHeaders) {
            this.requestHeaders = Objects.requireNonNull(requestHeaders, "requestHeaders is required");
            return this;
        }
        
        /**
         * response headers module configuration or <code>null</code>
         *
         * @param responseHeaders the value of the response_headers parameter as a {@link EndpointResponseHeaders}
         * @return the call builder instance
         */
        public CreateCallBuilder responseHeaders(final EndpointResponseHeaders responseHeaders) {
            this.responseHeaders = Optional.of(Objects.requireNonNull(responseHeaders, "responseHeaders is required"));
            return this;
        }

        /**
         * response headers module configuration or <code>null</code>
         *
         * @param responseHeaders the value of the response_headers parameter as an {@link Optional} of {@link EndpointResponseHeaders}
         * @return the call builder instance
         */
        public CreateCallBuilder responseHeaders(final Optional<EndpointResponseHeaders> responseHeaders) {
            this.responseHeaders = Objects.requireNonNull(responseHeaders, "responseHeaders is required");
            return this;
        }
        
        /**
         * webhook verification module configuration or <code>null</code>
         *
         * @param webhookVerification the value of the webhook_verification parameter as a {@link EndpointWebhookValidation}
         * @return the call builder instance
         */
        public CreateCallBuilder webhookVerification(final EndpointWebhookValidation webhookVerification) {
            this.webhookVerification = Optional.of(Objects.requireNonNull(webhookVerification, "webhookVerification is required"));
            return this;
        }

        /**
         * webhook verification module configuration or <code>null</code>
         *
         * @param webhookVerification the value of the webhook_verification parameter as an {@link Optional} of {@link EndpointWebhookValidation}
         * @return the call builder instance
         */
        public CreateCallBuilder webhookVerification(final Optional<EndpointWebhookValidation> webhookVerification) {
            this.webhookVerification = Objects.requireNonNull(webhookVerification, "webhookVerification is required");
            return this;
        }
        
        /**
         * oauth module configuration or <code>null</code>
         *
         * @param oauth the value of the oauth parameter as a {@link EndpointOAuth}
         * @return the call builder instance
         */
        public CreateCallBuilder oauth(final EndpointOAuth oauth) {
            this.oauth = Optional.of(Objects.requireNonNull(oauth, "oauth is required"));
            return this;
        }

        /**
         * oauth module configuration or <code>null</code>
         *
         * @param oauth the value of the oauth parameter as an {@link Optional} of {@link EndpointOAuth}
         * @return the call builder instance
         */
        public CreateCallBuilder oauth(final Optional<EndpointOAuth> oauth) {
            this.oauth = Objects.requireNonNull(oauth, "oauth is required");
            return this;
        }
        
        /**
         * saml module configuration or <code>null</code>
         *
         * @param saml the value of the saml parameter as a {@link EndpointSamlMutate}
         * @return the call builder instance
         */
        public CreateCallBuilder saml(final EndpointSamlMutate saml) {
            this.saml = Optional.of(Objects.requireNonNull(saml, "saml is required"));
            return this;
        }

        /**
         * saml module configuration or <code>null</code>
         *
         * @param saml the value of the saml parameter as an {@link Optional} of {@link EndpointSamlMutate}
         * @return the call builder instance
         */
        public CreateCallBuilder saml(final Optional<EndpointSamlMutate> saml) {
            this.saml = Objects.requireNonNull(saml, "saml is required");
            return this;
        }
        
        /**
         * oidc module configuration or <code>null</code>
         *
         * @param oidc the value of the oidc parameter as a {@link EndpointOidc}
         * @return the call builder instance
         */
        public CreateCallBuilder oidc(final EndpointOidc oidc) {
            this.oidc = Optional.of(Objects.requireNonNull(oidc, "oidc is required"));
            return this;
        }

        /**
         * oidc module configuration or <code>null</code>
         *
         * @param oidc the value of the oidc parameter as an {@link Optional} of {@link EndpointOidc}
         * @return the call builder instance
         */
        public CreateCallBuilder oidc(final Optional<EndpointOidc> oidc) {
            this.oidc = Objects.requireNonNull(oidc, "oidc is required");
            return this;
        }
        
        /**
         * websocket to tcp adapter configuration or <code>null</code>
         *
         * @param websocketTcpConverter the value of the websocket_tcp_converter parameter as a {@link EndpointWebsocketTcpConverter}
         * @return the call builder instance
         */
        public CreateCallBuilder websocketTcpConverter(final EndpointWebsocketTcpConverter websocketTcpConverter) {
            this.websocketTcpConverter = Optional.of(Objects.requireNonNull(websocketTcpConverter, "websocketTcpConverter is required"));
            return this;
        }

        /**
         * websocket to tcp adapter configuration or <code>null</code>
         *
         * @param websocketTcpConverter the value of the websocket_tcp_converter parameter as an {@link Optional} of {@link EndpointWebsocketTcpConverter}
         * @return the call builder instance
         */
        public CreateCallBuilder websocketTcpConverter(final Optional<EndpointWebsocketTcpConverter> websocketTcpConverter) {
            this.websocketTcpConverter = Objects.requireNonNull(websocketTcpConverter, "websocketTcpConverter is required");
            return this;
        }
        
        /**
         * Sets the <code>user_agent_filter</code> parameter.
         *
         * @param userAgentFilter the value of the user_agent_filter parameter as a {@link EndpointUserAgentFilter}
         * @return the call builder instance
         */
        public CreateCallBuilder userAgentFilter(final EndpointUserAgentFilter userAgentFilter) {
            this.userAgentFilter = Optional.of(Objects.requireNonNull(userAgentFilter, "userAgentFilter is required"));
            return this;
        }

        /**
         * Sets (or unsets) the <code>user_agent_filter</code> parameter.
         *
         * @param userAgentFilter the value of the user_agent_filter parameter as an {@link Optional} of {@link EndpointUserAgentFilter}
         * @return the call builder instance
         */
        public CreateCallBuilder userAgentFilter(final Optional<EndpointUserAgentFilter> userAgentFilter) {
            this.userAgentFilter = Objects.requireNonNull(userAgentFilter, "userAgentFilter is required");
            return this;
        }
        
        /**
         * the traffic policy associated with this edge or null
         *
         * @param policy the value of the policy parameter as a {@link EndpointPolicy}
         * @return the call builder instance
         */
        public CreateCallBuilder policy(final EndpointPolicy policy) {
            this.policy = Optional.of(Objects.requireNonNull(policy, "policy is required"));
            return this;
        }

        /**
         * the traffic policy associated with this edge or null
         *
         * @param policy the value of the policy parameter as an {@link Optional} of {@link EndpointPolicy}
         * @return the call builder instance
         */
        public CreateCallBuilder policy(final Optional<EndpointPolicy> policy) {
            this.policy = Objects.requireNonNull(policy, "policy is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link HttpsEdgeRoute}
         */
        public CompletionStage<HttpsEdgeRoute> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/edges/https/" + this.edgeId + "/routes",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("match_type", Optional.of(this.matchType)),
                    new AbstractMap.SimpleEntry<>("match", Optional.of(this.match)),
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("backend", this.backend.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("ip_restriction", this.ipRestriction.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("circuit_breaker", this.circuitBreaker.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("compression", this.compression.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("request_headers", this.requestHeaders.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("response_headers", this.responseHeaders.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("webhook_verification", this.webhookVerification.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("oauth", this.oauth.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("saml", this.saml.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("oidc", this.oidc.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("websocket_tcp_converter", this.websocketTcpConverter.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("user_agent_filter", this.userAgentFilter.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("policy", this.policy.map(Function.identity()))
                ),
                Optional.of(HttpsEdgeRoute.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link HttpsEdgeRoute}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public HttpsEdgeRoute blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create an HTTPS Edge Route
     *
     * See also <a href="https://ngrok.com/docs/api#api-edges-https-routes-create">https://ngrok.com/docs/api#api-edges-https-routes-create</a>.
     *
     * @param edgeId unique identifier of this edge
     * @param matchType Type of match to use for this route. Valid values are &#34;exact_path&#34; and &#34;path_prefix&#34;.
     * @param match Route selector: &#34;/blog&#34; or &#34;example.com&#34; or &#34;example.com/blog&#34;
     * @return a call builder for this API call
     */
    public CreateCallBuilder create(
        final String edgeId,
        final String matchType,
        final String match
    ) {
        return new CreateCallBuilder(
            edgeId,
            matchType,
            match
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Get API call.
     */
    public class GetCallBuilder {
        private final String edgeId;
        private final String id;

        private GetCallBuilder(
            final String edgeId,
            final String id
        ) {
            this.edgeId = Objects.requireNonNull(edgeId, "edgeId is required");
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link HttpsEdgeRoute}
         */
        public CompletionStage<HttpsEdgeRoute> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/edges/https/" + this.edgeId + "/routes/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(HttpsEdgeRoute.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link HttpsEdgeRoute}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public HttpsEdgeRoute blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get an HTTPS Edge Route by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-edges-https-routes-get">https://ngrok.com/docs/api#api-edges-https-routes-get</a>.
     *
     * @param edgeId unique identifier of this edge
     * @param id unique identifier of this edge route
     * @return a call builder for this API call
     */
    public GetCallBuilder get(
        final String edgeId,
        final String id
    ) {
        return new GetCallBuilder(
            edgeId,
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Update API call.
     */
    public class UpdateCallBuilder {
        private final String edgeId;
        private final String id;
        private Optional<String> matchType = Optional.empty();
        private Optional<String> match = Optional.empty();
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private Optional<EndpointBackendMutate> backend = Optional.empty();
        private Optional<EndpointIpPolicyMutate> ipRestriction = Optional.empty();
        private Optional<EndpointCircuitBreaker> circuitBreaker = Optional.empty();
        private Optional<EndpointCompression> compression = Optional.empty();
        private Optional<EndpointRequestHeaders> requestHeaders = Optional.empty();
        private Optional<EndpointResponseHeaders> responseHeaders = Optional.empty();
        private Optional<EndpointWebhookValidation> webhookVerification = Optional.empty();
        private Optional<EndpointOAuth> oauth = Optional.empty();
        private Optional<EndpointSamlMutate> saml = Optional.empty();
        private Optional<EndpointOidc> oidc = Optional.empty();
        private Optional<EndpointWebsocketTcpConverter> websocketTcpConverter = Optional.empty();
        private Optional<EndpointUserAgentFilter> userAgentFilter = Optional.empty();
        private Optional<EndpointPolicy> policy = Optional.empty();

        private UpdateCallBuilder(
            final String edgeId,
            final String id
        ) {
            this.edgeId = Objects.requireNonNull(edgeId, "edgeId is required");
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Type of match to use for this route. Valid values are &#34;exact_path&#34; and
         * &#34;path_prefix&#34;.
         *
         * @param matchType the value of the match_type parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder matchType(final String matchType) {
            this.matchType = Optional.of(Objects.requireNonNull(matchType, "matchType is required"));
            return this;
        }

        /**
         * Type of match to use for this route. Valid values are &#34;exact_path&#34; and
         * &#34;path_prefix&#34;.
         *
         * @param matchType the value of the match_type parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder matchType(final Optional<String> matchType) {
            this.matchType = Objects.requireNonNull(matchType, "matchType is required");
            return this;
        }
        
        /**
         * Route selector: &#34;/blog&#34; or &#34;example.com&#34; or
         * &#34;example.com/blog&#34;
         *
         * @param match the value of the match parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder match(final String match) {
            this.match = Optional.of(Objects.requireNonNull(match, "match is required"));
            return this;
        }

        /**
         * Route selector: &#34;/blog&#34; or &#34;example.com&#34; or
         * &#34;example.com/blog&#34;
         *
         * @param match the value of the match parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder match(final Optional<String> match) {
            this.match = Objects.requireNonNull(match, "match is required");
            return this;
        }
        
        /**
         * human-readable description of what this edge will be used for; optional, max 255
         * bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final String description) {
            this.description = Optional.of(Objects.requireNonNull(description, "description is required"));
            return this;
        }

        /**
         * human-readable description of what this edge will be used for; optional, max 255
         * bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this edge. Optional, max 4096
         * bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.of(Objects.requireNonNull(metadata, "metadata is required"));
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this edge. Optional, max 4096
         * bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * backend module configuration or <code>null</code>
         *
         * @param backend the value of the backend parameter as a {@link EndpointBackendMutate}
         * @return the call builder instance
         */
        public UpdateCallBuilder backend(final EndpointBackendMutate backend) {
            this.backend = Optional.of(Objects.requireNonNull(backend, "backend is required"));
            return this;
        }

        /**
         * backend module configuration or <code>null</code>
         *
         * @param backend the value of the backend parameter as an {@link Optional} of {@link EndpointBackendMutate}
         * @return the call builder instance
         */
        public UpdateCallBuilder backend(final Optional<EndpointBackendMutate> backend) {
            this.backend = Objects.requireNonNull(backend, "backend is required");
            return this;
        }
        
        /**
         * ip restriction module configuration or <code>null</code>
         *
         * @param ipRestriction the value of the ip_restriction parameter as a {@link EndpointIpPolicyMutate}
         * @return the call builder instance
         */
        public UpdateCallBuilder ipRestriction(final EndpointIpPolicyMutate ipRestriction) {
            this.ipRestriction = Optional.of(Objects.requireNonNull(ipRestriction, "ipRestriction is required"));
            return this;
        }

        /**
         * ip restriction module configuration or <code>null</code>
         *
         * @param ipRestriction the value of the ip_restriction parameter as an {@link Optional} of {@link EndpointIpPolicyMutate}
         * @return the call builder instance
         */
        public UpdateCallBuilder ipRestriction(final Optional<EndpointIpPolicyMutate> ipRestriction) {
            this.ipRestriction = Objects.requireNonNull(ipRestriction, "ipRestriction is required");
            return this;
        }
        
        /**
         * circuit breaker module configuration or <code>null</code>
         *
         * @param circuitBreaker the value of the circuit_breaker parameter as a {@link EndpointCircuitBreaker}
         * @return the call builder instance
         */
        public UpdateCallBuilder circuitBreaker(final EndpointCircuitBreaker circuitBreaker) {
            this.circuitBreaker = Optional.of(Objects.requireNonNull(circuitBreaker, "circuitBreaker is required"));
            return this;
        }

        /**
         * circuit breaker module configuration or <code>null</code>
         *
         * @param circuitBreaker the value of the circuit_breaker parameter as an {@link Optional} of {@link EndpointCircuitBreaker}
         * @return the call builder instance
         */
        public UpdateCallBuilder circuitBreaker(final Optional<EndpointCircuitBreaker> circuitBreaker) {
            this.circuitBreaker = Objects.requireNonNull(circuitBreaker, "circuitBreaker is required");
            return this;
        }
        
        /**
         * compression module configuration or <code>null</code>
         *
         * @param compression the value of the compression parameter as a {@link EndpointCompression}
         * @return the call builder instance
         */
        public UpdateCallBuilder compression(final EndpointCompression compression) {
            this.compression = Optional.of(Objects.requireNonNull(compression, "compression is required"));
            return this;
        }

        /**
         * compression module configuration or <code>null</code>
         *
         * @param compression the value of the compression parameter as an {@link Optional} of {@link EndpointCompression}
         * @return the call builder instance
         */
        public UpdateCallBuilder compression(final Optional<EndpointCompression> compression) {
            this.compression = Objects.requireNonNull(compression, "compression is required");
            return this;
        }
        
        /**
         * request headers module configuration or <code>null</code>
         *
         * @param requestHeaders the value of the request_headers parameter as a {@link EndpointRequestHeaders}
         * @return the call builder instance
         */
        public UpdateCallBuilder requestHeaders(final EndpointRequestHeaders requestHeaders) {
            this.requestHeaders = Optional.of(Objects.requireNonNull(requestHeaders, "requestHeaders is required"));
            return this;
        }

        /**
         * request headers module configuration or <code>null</code>
         *
         * @param requestHeaders the value of the request_headers parameter as an {@link Optional} of {@link EndpointRequestHeaders}
         * @return the call builder instance
         */
        public UpdateCallBuilder requestHeaders(final Optional<EndpointRequestHeaders> requestHeaders) {
            this.requestHeaders = Objects.requireNonNull(requestHeaders, "requestHeaders is required");
            return this;
        }
        
        /**
         * response headers module configuration or <code>null</code>
         *
         * @param responseHeaders the value of the response_headers parameter as a {@link EndpointResponseHeaders}
         * @return the call builder instance
         */
        public UpdateCallBuilder responseHeaders(final EndpointResponseHeaders responseHeaders) {
            this.responseHeaders = Optional.of(Objects.requireNonNull(responseHeaders, "responseHeaders is required"));
            return this;
        }

        /**
         * response headers module configuration or <code>null</code>
         *
         * @param responseHeaders the value of the response_headers parameter as an {@link Optional} of {@link EndpointResponseHeaders}
         * @return the call builder instance
         */
        public UpdateCallBuilder responseHeaders(final Optional<EndpointResponseHeaders> responseHeaders) {
            this.responseHeaders = Objects.requireNonNull(responseHeaders, "responseHeaders is required");
            return this;
        }
        
        /**
         * webhook verification module configuration or <code>null</code>
         *
         * @param webhookVerification the value of the webhook_verification parameter as a {@link EndpointWebhookValidation}
         * @return the call builder instance
         */
        public UpdateCallBuilder webhookVerification(final EndpointWebhookValidation webhookVerification) {
            this.webhookVerification = Optional.of(Objects.requireNonNull(webhookVerification, "webhookVerification is required"));
            return this;
        }

        /**
         * webhook verification module configuration or <code>null</code>
         *
         * @param webhookVerification the value of the webhook_verification parameter as an {@link Optional} of {@link EndpointWebhookValidation}
         * @return the call builder instance
         */
        public UpdateCallBuilder webhookVerification(final Optional<EndpointWebhookValidation> webhookVerification) {
            this.webhookVerification = Objects.requireNonNull(webhookVerification, "webhookVerification is required");
            return this;
        }
        
        /**
         * oauth module configuration or <code>null</code>
         *
         * @param oauth the value of the oauth parameter as a {@link EndpointOAuth}
         * @return the call builder instance
         */
        public UpdateCallBuilder oauth(final EndpointOAuth oauth) {
            this.oauth = Optional.of(Objects.requireNonNull(oauth, "oauth is required"));
            return this;
        }

        /**
         * oauth module configuration or <code>null</code>
         *
         * @param oauth the value of the oauth parameter as an {@link Optional} of {@link EndpointOAuth}
         * @return the call builder instance
         */
        public UpdateCallBuilder oauth(final Optional<EndpointOAuth> oauth) {
            this.oauth = Objects.requireNonNull(oauth, "oauth is required");
            return this;
        }
        
        /**
         * saml module configuration or <code>null</code>
         *
         * @param saml the value of the saml parameter as a {@link EndpointSamlMutate}
         * @return the call builder instance
         */
        public UpdateCallBuilder saml(final EndpointSamlMutate saml) {
            this.saml = Optional.of(Objects.requireNonNull(saml, "saml is required"));
            return this;
        }

        /**
         * saml module configuration or <code>null</code>
         *
         * @param saml the value of the saml parameter as an {@link Optional} of {@link EndpointSamlMutate}
         * @return the call builder instance
         */
        public UpdateCallBuilder saml(final Optional<EndpointSamlMutate> saml) {
            this.saml = Objects.requireNonNull(saml, "saml is required");
            return this;
        }
        
        /**
         * oidc module configuration or <code>null</code>
         *
         * @param oidc the value of the oidc parameter as a {@link EndpointOidc}
         * @return the call builder instance
         */
        public UpdateCallBuilder oidc(final EndpointOidc oidc) {
            this.oidc = Optional.of(Objects.requireNonNull(oidc, "oidc is required"));
            return this;
        }

        /**
         * oidc module configuration or <code>null</code>
         *
         * @param oidc the value of the oidc parameter as an {@link Optional} of {@link EndpointOidc}
         * @return the call builder instance
         */
        public UpdateCallBuilder oidc(final Optional<EndpointOidc> oidc) {
            this.oidc = Objects.requireNonNull(oidc, "oidc is required");
            return this;
        }
        
        /**
         * websocket to tcp adapter configuration or <code>null</code>
         *
         * @param websocketTcpConverter the value of the websocket_tcp_converter parameter as a {@link EndpointWebsocketTcpConverter}
         * @return the call builder instance
         */
        public UpdateCallBuilder websocketTcpConverter(final EndpointWebsocketTcpConverter websocketTcpConverter) {
            this.websocketTcpConverter = Optional.of(Objects.requireNonNull(websocketTcpConverter, "websocketTcpConverter is required"));
            return this;
        }

        /**
         * websocket to tcp adapter configuration or <code>null</code>
         *
         * @param websocketTcpConverter the value of the websocket_tcp_converter parameter as an {@link Optional} of {@link EndpointWebsocketTcpConverter}
         * @return the call builder instance
         */
        public UpdateCallBuilder websocketTcpConverter(final Optional<EndpointWebsocketTcpConverter> websocketTcpConverter) {
            this.websocketTcpConverter = Objects.requireNonNull(websocketTcpConverter, "websocketTcpConverter is required");
            return this;
        }
        
        /**
         * Sets the <code>user_agent_filter</code> parameter.
         *
         * @param userAgentFilter the value of the user_agent_filter parameter as a {@link EndpointUserAgentFilter}
         * @return the call builder instance
         */
        public UpdateCallBuilder userAgentFilter(final EndpointUserAgentFilter userAgentFilter) {
            this.userAgentFilter = Optional.of(Objects.requireNonNull(userAgentFilter, "userAgentFilter is required"));
            return this;
        }

        /**
         * Sets (or unsets) the <code>user_agent_filter</code> parameter.
         *
         * @param userAgentFilter the value of the user_agent_filter parameter as an {@link Optional} of {@link EndpointUserAgentFilter}
         * @return the call builder instance
         */
        public UpdateCallBuilder userAgentFilter(final Optional<EndpointUserAgentFilter> userAgentFilter) {
            this.userAgentFilter = Objects.requireNonNull(userAgentFilter, "userAgentFilter is required");
            return this;
        }
        
        /**
         * the traffic policy associated with this edge or null
         *
         * @param policy the value of the policy parameter as a {@link EndpointPolicy}
         * @return the call builder instance
         */
        public UpdateCallBuilder policy(final EndpointPolicy policy) {
            this.policy = Optional.of(Objects.requireNonNull(policy, "policy is required"));
            return this;
        }

        /**
         * the traffic policy associated with this edge or null
         *
         * @param policy the value of the policy parameter as an {@link Optional} of {@link EndpointPolicy}
         * @return the call builder instance
         */
        public UpdateCallBuilder policy(final Optional<EndpointPolicy> policy) {
            this.policy = Objects.requireNonNull(policy, "policy is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link HttpsEdgeRoute}
         */
        public CompletionStage<HttpsEdgeRoute> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/edges/https/" + this.edgeId + "/routes/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("match_type", this.matchType.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("match", this.match.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("backend", this.backend.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("ip_restriction", this.ipRestriction.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("circuit_breaker", this.circuitBreaker.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("compression", this.compression.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("request_headers", this.requestHeaders.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("response_headers", this.responseHeaders.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("webhook_verification", this.webhookVerification.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("oauth", this.oauth.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("saml", this.saml.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("oidc", this.oidc.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("websocket_tcp_converter", this.websocketTcpConverter.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("user_agent_filter", this.userAgentFilter.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("policy", this.policy.map(Function.identity()))
                ),
                Optional.of(HttpsEdgeRoute.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link HttpsEdgeRoute}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public HttpsEdgeRoute blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Updates an HTTPS Edge Route by ID. If a module is not specified in the update,
     * it will not be modified. However, each module configuration that is specified
     * will completely replace the existing value. There is no way to delete an
     * existing module via this API, instead use the delete module API.
     *
     * See also <a href="https://ngrok.com/docs/api#api-edges-https-routes-update">https://ngrok.com/docs/api#api-edges-https-routes-update</a>.
     *
     * @param edgeId unique identifier of this edge
     * @param id unique identifier of this edge route
     * @return a call builder for this API call
     */
    public UpdateCallBuilder update(
        final String edgeId,
        final String id
    ) {
        return new UpdateCallBuilder(
            edgeId,
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Delete API call.
     */
    public class DeleteCallBuilder {
        private final String edgeId;
        private final String id;

        private DeleteCallBuilder(
            final String edgeId,
            final String id
        ) {
            this.edgeId = Objects.requireNonNull(edgeId, "edgeId is required");
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link Void}
         */
        public CompletionStage<Void> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.DELETE,
                "/edges/https/" + this.edgeId + "/routes/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.empty()
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public void blockingCall() throws InterruptedException {
            try {
                call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Delete an HTTPS Edge Route by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-edges-https-routes-delete">https://ngrok.com/docs/api#api-edges-https-routes-delete</a>.
     *
     * @param edgeId unique identifier of this edge
     * @param id unique identifier of this edge route
     * @return a call builder for this API call
     */
    public DeleteCallBuilder delete(
        final String edgeId,
        final String id
    ) {
        return new DeleteCallBuilder(
            edgeId,
            id
        );
    }
}
