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
 * Endpoint Configurations are a reusable group of modules that encapsulate how
 *  traffic to a domain or address is handled. Endpoint configurations are only
 *  applied to Domains and TCP Addresses they have been attached to.
 */
public class EndpointConfigurations {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for EndpointConfigurations.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public EndpointConfigurations(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class EndpointConfigurationsCreateCallBuilder {
        private String type = "";
        private String description = "";
        private String metadata = "";
        private Optional<EndpointCircuitBreaker> circuitBreaker = Optional.empty();
        private Optional<EndpointCompression> compression = Optional.empty();
        private Optional<EndpointRequestHeaders> requestHeaders = Optional.empty();
        private Optional<EndpointResponseHeaders> responseHeaders = Optional.empty();
        private Optional<EndpointIpPolicyMutate> ipPolicy = Optional.empty();
        private Optional<EndpointMutualTlsMutate> mutualTls = Optional.empty();
        private Optional<EndpointTlsTermination> tlsTermination = Optional.empty();
        private Optional<EndpointWebhookValidation> webhookValidation = Optional.empty();
        private Optional<EndpointOAuth> oauth = Optional.empty();
        private Optional<EndpointLoggingMutate> logging = Optional.empty();
        private Optional<EndpointSamlMutate> saml = Optional.empty();
        private Optional<EndpointOidc> oidc = Optional.empty();

        private EndpointConfigurationsCreateCallBuilder(
        ) {
        }
        
        /**
         * they type of traffic this endpoint configuration can be applied to. one of:
         * <code>http</code>, <code>https</code>, <code>tcp</code>
         *
         * @param type the value of the type parameter as a {@link String}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder type(final String type) {
            this.type = Objects.requireNonNull(type, "type is required");
            return this;
        }

        /**
         * they type of traffic this endpoint configuration can be applied to. one of:
         * <code>http</code>, <code>https</code>, <code>tcp</code>
         *
         * @param type the value of the type parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder type(final Optional<String> type) {
            this.type = Objects.requireNonNull(type, "type is required").orElse("");
            return this;
        }
        
        /**
         * human-readable description of what this endpoint configuration will be do when
         * applied or what traffic it will be applied to. Optional, max 255 bytes
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder description(final String description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }

        /**
         * human-readable description of what this endpoint configuration will be do when
         * applied or what traffic it will be applied to. Optional, max 255 bytes
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required").orElse("");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this endpoint configuration.
         * Optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder metadata(final String metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this endpoint configuration.
         * Optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required").orElse("");
            return this;
        }
        
        /**
         * circuit breaker module configuration or <code>null</code>
         *
         * @param circuitBreaker the value of the circuit_breaker parameter as a {@link EndpointCircuitBreaker}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder circuitBreaker(final EndpointCircuitBreaker circuitBreaker) {
            this.circuitBreaker = Optional.ofNullable(circuitBreaker);
            return this;
        }

        /**
         * circuit breaker module configuration or <code>null</code>
         *
         * @param circuitBreaker the value of the circuit_breaker parameter as an {@link Optional} of {@link EndpointCircuitBreaker}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder circuitBreaker(final Optional<EndpointCircuitBreaker> circuitBreaker) {
            this.circuitBreaker = Objects.requireNonNull(circuitBreaker, "circuitBreaker is required");
            return this;
        }
        
        /**
         * compression module configuration or <code>null</code>
         *
         * @param compression the value of the compression parameter as a {@link EndpointCompression}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder compression(final EndpointCompression compression) {
            this.compression = Optional.ofNullable(compression);
            return this;
        }

        /**
         * compression module configuration or <code>null</code>
         *
         * @param compression the value of the compression parameter as an {@link Optional} of {@link EndpointCompression}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder compression(final Optional<EndpointCompression> compression) {
            this.compression = Objects.requireNonNull(compression, "compression is required");
            return this;
        }
        
        /**
         * request headers module configuration or <code>null</code>
         *
         * @param requestHeaders the value of the request_headers parameter as a {@link EndpointRequestHeaders}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder requestHeaders(final EndpointRequestHeaders requestHeaders) {
            this.requestHeaders = Optional.ofNullable(requestHeaders);
            return this;
        }

        /**
         * request headers module configuration or <code>null</code>
         *
         * @param requestHeaders the value of the request_headers parameter as an {@link Optional} of {@link EndpointRequestHeaders}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder requestHeaders(final Optional<EndpointRequestHeaders> requestHeaders) {
            this.requestHeaders = Objects.requireNonNull(requestHeaders, "requestHeaders is required");
            return this;
        }
        
        /**
         * response headers module configuration or <code>null</code>
         *
         * @param responseHeaders the value of the response_headers parameter as a {@link EndpointResponseHeaders}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder responseHeaders(final EndpointResponseHeaders responseHeaders) {
            this.responseHeaders = Optional.ofNullable(responseHeaders);
            return this;
        }

        /**
         * response headers module configuration or <code>null</code>
         *
         * @param responseHeaders the value of the response_headers parameter as an {@link Optional} of {@link EndpointResponseHeaders}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder responseHeaders(final Optional<EndpointResponseHeaders> responseHeaders) {
            this.responseHeaders = Objects.requireNonNull(responseHeaders, "responseHeaders is required");
            return this;
        }
        
        /**
         * ip policy module configuration or <code>null</code>
         *
         * @param ipPolicy the value of the ip_policy parameter as a {@link EndpointIpPolicyMutate}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder ipPolicy(final EndpointIpPolicyMutate ipPolicy) {
            this.ipPolicy = Optional.ofNullable(ipPolicy);
            return this;
        }

        /**
         * ip policy module configuration or <code>null</code>
         *
         * @param ipPolicy the value of the ip_policy parameter as an {@link Optional} of {@link EndpointIpPolicyMutate}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder ipPolicy(final Optional<EndpointIpPolicyMutate> ipPolicy) {
            this.ipPolicy = Objects.requireNonNull(ipPolicy, "ipPolicy is required");
            return this;
        }
        
        /**
         * mutual TLS module configuration or <code>null</code>
         *
         * @param mutualTls the value of the mutual_tls parameter as a {@link EndpointMutualTlsMutate}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder mutualTls(final EndpointMutualTlsMutate mutualTls) {
            this.mutualTls = Optional.ofNullable(mutualTls);
            return this;
        }

        /**
         * mutual TLS module configuration or <code>null</code>
         *
         * @param mutualTls the value of the mutual_tls parameter as an {@link Optional} of {@link EndpointMutualTlsMutate}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder mutualTls(final Optional<EndpointMutualTlsMutate> mutualTls) {
            this.mutualTls = Objects.requireNonNull(mutualTls, "mutualTls is required");
            return this;
        }
        
        /**
         * TLS termination module configuration or <code>null</code>
         *
         * @param tlsTermination the value of the tls_termination parameter as a {@link EndpointTlsTermination}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder tlsTermination(final EndpointTlsTermination tlsTermination) {
            this.tlsTermination = Optional.ofNullable(tlsTermination);
            return this;
        }

        /**
         * TLS termination module configuration or <code>null</code>
         *
         * @param tlsTermination the value of the tls_termination parameter as an {@link Optional} of {@link EndpointTlsTermination}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder tlsTermination(final Optional<EndpointTlsTermination> tlsTermination) {
            this.tlsTermination = Objects.requireNonNull(tlsTermination, "tlsTermination is required");
            return this;
        }
        
        /**
         * webhook validation module configuration or <code>null</code>
         *
         * @param webhookValidation the value of the webhook_validation parameter as a {@link EndpointWebhookValidation}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder webhookValidation(final EndpointWebhookValidation webhookValidation) {
            this.webhookValidation = Optional.ofNullable(webhookValidation);
            return this;
        }

        /**
         * webhook validation module configuration or <code>null</code>
         *
         * @param webhookValidation the value of the webhook_validation parameter as an {@link Optional} of {@link EndpointWebhookValidation}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder webhookValidation(final Optional<EndpointWebhookValidation> webhookValidation) {
            this.webhookValidation = Objects.requireNonNull(webhookValidation, "webhookValidation is required");
            return this;
        }
        
        /**
         * oauth module configuration or <code>null</code>
         *
         * @param oauth the value of the oauth parameter as a {@link EndpointOAuth}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder oauth(final EndpointOAuth oauth) {
            this.oauth = Optional.ofNullable(oauth);
            return this;
        }

        /**
         * oauth module configuration or <code>null</code>
         *
         * @param oauth the value of the oauth parameter as an {@link Optional} of {@link EndpointOAuth}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder oauth(final Optional<EndpointOAuth> oauth) {
            this.oauth = Objects.requireNonNull(oauth, "oauth is required");
            return this;
        }
        
        /**
         * logging module configuration or <code>null</code>
         *
         * @param logging the value of the logging parameter as a {@link EndpointLoggingMutate}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder logging(final EndpointLoggingMutate logging) {
            this.logging = Optional.ofNullable(logging);
            return this;
        }

        /**
         * logging module configuration or <code>null</code>
         *
         * @param logging the value of the logging parameter as an {@link Optional} of {@link EndpointLoggingMutate}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder logging(final Optional<EndpointLoggingMutate> logging) {
            this.logging = Objects.requireNonNull(logging, "logging is required");
            return this;
        }
        
        /**
         * saml module configuration or <code>null</code>
         *
         * @param saml the value of the saml parameter as a {@link EndpointSamlMutate}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder saml(final EndpointSamlMutate saml) {
            this.saml = Optional.ofNullable(saml);
            return this;
        }

        /**
         * saml module configuration or <code>null</code>
         *
         * @param saml the value of the saml parameter as an {@link Optional} of {@link EndpointSamlMutate}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder saml(final Optional<EndpointSamlMutate> saml) {
            this.saml = Objects.requireNonNull(saml, "saml is required");
            return this;
        }
        
        /**
         * oidc module configuration or <code>null</code>
         *
         * @param oidc the value of the oidc parameter as a {@link EndpointOidc}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder oidc(final EndpointOidc oidc) {
            this.oidc = Optional.ofNullable(oidc);
            return this;
        }

        /**
         * oidc module configuration or <code>null</code>
         *
         * @param oidc the value of the oidc parameter as an {@link Optional} of {@link EndpointOidc}
         * @return the call builder instance
         */
        public EndpointConfigurationsCreateCallBuilder oidc(final Optional<EndpointOidc> oidc) {
            this.oidc = Objects.requireNonNull(oidc, "oidc is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EndpointConfiguration}
         */
        public CompletionStage<EndpointConfiguration> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/endpoint_configurations",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("type", Optional.of(this.type)),
                    new AbstractMap.SimpleEntry<>("description", Optional.of(this.description)),
                    new AbstractMap.SimpleEntry<>("metadata", Optional.of(this.metadata)),
                    new AbstractMap.SimpleEntry<>("circuit_breaker", this.circuitBreaker.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("compression", this.compression.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("request_headers", this.requestHeaders.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("response_headers", this.responseHeaders.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("ip_policy", this.ipPolicy.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("mutual_tls", this.mutualTls.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("tls_termination", this.tlsTermination.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("webhook_validation", this.webhookValidation.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("oauth", this.oauth.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("logging", this.logging.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("saml", this.saml.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("oidc", this.oidc.map(Function.identity()))
                ),
                Optional.of(EndpointConfiguration.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EndpointConfiguration}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EndpointConfiguration blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create a new endpoint configuration
     *
     * @return a call builder for this API call
     */
    public EndpointConfigurationsCreateCallBuilder create(
    ) {
        return new EndpointConfigurationsCreateCallBuilder(
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Delete API call.
     */
    public class EndpointConfigurationsDeleteCallBuilder {
        private final String id;

        private EndpointConfigurationsDeleteCallBuilder(
            final String id
        ) {
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
                "/endpoint_configurations/" + this.id,
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
     * Delete an endpoint configuration. This operation will fail if the endpoint
     * configuration is still referenced by any reserved domain or reserved address.
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public EndpointConfigurationsDeleteCallBuilder delete(
        final String id
    ) {
        return new EndpointConfigurationsDeleteCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Get API call.
     */
    public class EndpointConfigurationsGetCallBuilder {
        private final String id;

        private EndpointConfigurationsGetCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EndpointConfiguration}
         */
        public CompletionStage<EndpointConfiguration> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/endpoint_configurations/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(EndpointConfiguration.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EndpointConfiguration}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EndpointConfiguration blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Returns detailed information about an endpoint configuration
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public EndpointConfigurationsGetCallBuilder get(
        final String id
    ) {
        return new EndpointConfigurationsGetCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent List API call.
     */
    public class EndpointConfigurationsListCallBuilder {
        private Optional<String> beforeId = Optional.empty();
        private Optional<String> limit = Optional.empty();

        private EndpointConfigurationsListCallBuilder(
        ) {
        }
        
        /**
         * Sets the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as a {@link String}
         * @return the call builder instance
         */
        public EndpointConfigurationsListCallBuilder beforeId(final String beforeId) {
            this.beforeId = Optional.ofNullable(beforeId);
            return this;
        }

        /**
         * Sets (or unsets) the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public EndpointConfigurationsListCallBuilder beforeId(final Optional<String> beforeId) {
            this.beforeId = Objects.requireNonNull(beforeId, "beforeId is required");
            return this;
        }
        
        /**
         * Sets the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as a {@link String}
         * @return the call builder instance
         */
        public EndpointConfigurationsListCallBuilder limit(final String limit) {
            this.limit = Optional.ofNullable(limit);
            return this;
        }

        /**
         * Sets (or unsets) the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public EndpointConfigurationsListCallBuilder limit(final Optional<String> limit) {
            this.limit = Objects.requireNonNull(limit, "limit is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of a {@link Page} of {@link EndpointConfigurationList}
         */
        public CompletionStage<Page<EndpointConfigurationList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/endpoint_configurations",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(EndpointConfigurationList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link EndpointConfigurationList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<EndpointConfigurationList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Returns a list of all endpoint configurations on this account
     *
     * @return a call builder for this API call
     */
    public EndpointConfigurationsListCallBuilder list(
    ) {
        return new EndpointConfigurationsListCallBuilder(
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Update API call.
     */
    public class EndpointConfigurationsUpdateCallBuilder {
        private final String id;
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private Optional<EndpointCircuitBreaker> circuitBreaker = Optional.empty();
        private Optional<EndpointCompression> compression = Optional.empty();
        private Optional<EndpointRequestHeaders> requestHeaders = Optional.empty();
        private Optional<EndpointResponseHeaders> responseHeaders = Optional.empty();
        private Optional<EndpointIpPolicyMutate> ipPolicy = Optional.empty();
        private Optional<EndpointMutualTlsMutate> mutualTls = Optional.empty();
        private Optional<EndpointTlsTermination> tlsTermination = Optional.empty();
        private Optional<EndpointWebhookValidation> webhookValidation = Optional.empty();
        private Optional<EndpointOAuth> oauth = Optional.empty();
        private Optional<EndpointLoggingMutate> logging = Optional.empty();
        private Optional<EndpointSamlMutate> saml = Optional.empty();
        private Optional<EndpointOidc> oidc = Optional.empty();

        private EndpointConfigurationsUpdateCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * human-readable description of what this endpoint configuration will be do when
         * applied or what traffic it will be applied to. Optional, max 255 bytes
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder description(final String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        /**
         * human-readable description of what this endpoint configuration will be do when
         * applied or what traffic it will be applied to. Optional, max 255 bytes
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this endpoint configuration.
         * Optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.ofNullable(metadata);
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this endpoint configuration.
         * Optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * circuit breaker module configuration or <code>null</code>
         *
         * @param circuitBreaker the value of the circuit_breaker parameter as a {@link EndpointCircuitBreaker}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder circuitBreaker(final EndpointCircuitBreaker circuitBreaker) {
            this.circuitBreaker = Optional.ofNullable(circuitBreaker);
            return this;
        }

        /**
         * circuit breaker module configuration or <code>null</code>
         *
         * @param circuitBreaker the value of the circuit_breaker parameter as an {@link Optional} of {@link EndpointCircuitBreaker}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder circuitBreaker(final Optional<EndpointCircuitBreaker> circuitBreaker) {
            this.circuitBreaker = Objects.requireNonNull(circuitBreaker, "circuitBreaker is required");
            return this;
        }
        
        /**
         * compression module configuration or <code>null</code>
         *
         * @param compression the value of the compression parameter as a {@link EndpointCompression}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder compression(final EndpointCompression compression) {
            this.compression = Optional.ofNullable(compression);
            return this;
        }

        /**
         * compression module configuration or <code>null</code>
         *
         * @param compression the value of the compression parameter as an {@link Optional} of {@link EndpointCompression}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder compression(final Optional<EndpointCompression> compression) {
            this.compression = Objects.requireNonNull(compression, "compression is required");
            return this;
        }
        
        /**
         * request headers module configuration or <code>null</code>
         *
         * @param requestHeaders the value of the request_headers parameter as a {@link EndpointRequestHeaders}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder requestHeaders(final EndpointRequestHeaders requestHeaders) {
            this.requestHeaders = Optional.ofNullable(requestHeaders);
            return this;
        }

        /**
         * request headers module configuration or <code>null</code>
         *
         * @param requestHeaders the value of the request_headers parameter as an {@link Optional} of {@link EndpointRequestHeaders}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder requestHeaders(final Optional<EndpointRequestHeaders> requestHeaders) {
            this.requestHeaders = Objects.requireNonNull(requestHeaders, "requestHeaders is required");
            return this;
        }
        
        /**
         * response headers module configuration or <code>null</code>
         *
         * @param responseHeaders the value of the response_headers parameter as a {@link EndpointResponseHeaders}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder responseHeaders(final EndpointResponseHeaders responseHeaders) {
            this.responseHeaders = Optional.ofNullable(responseHeaders);
            return this;
        }

        /**
         * response headers module configuration or <code>null</code>
         *
         * @param responseHeaders the value of the response_headers parameter as an {@link Optional} of {@link EndpointResponseHeaders}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder responseHeaders(final Optional<EndpointResponseHeaders> responseHeaders) {
            this.responseHeaders = Objects.requireNonNull(responseHeaders, "responseHeaders is required");
            return this;
        }
        
        /**
         * ip policy module configuration or <code>null</code>
         *
         * @param ipPolicy the value of the ip_policy parameter as a {@link EndpointIpPolicyMutate}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder ipPolicy(final EndpointIpPolicyMutate ipPolicy) {
            this.ipPolicy = Optional.ofNullable(ipPolicy);
            return this;
        }

        /**
         * ip policy module configuration or <code>null</code>
         *
         * @param ipPolicy the value of the ip_policy parameter as an {@link Optional} of {@link EndpointIpPolicyMutate}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder ipPolicy(final Optional<EndpointIpPolicyMutate> ipPolicy) {
            this.ipPolicy = Objects.requireNonNull(ipPolicy, "ipPolicy is required");
            return this;
        }
        
        /**
         * mutual TLS module configuration or <code>null</code>
         *
         * @param mutualTls the value of the mutual_tls parameter as a {@link EndpointMutualTlsMutate}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder mutualTls(final EndpointMutualTlsMutate mutualTls) {
            this.mutualTls = Optional.ofNullable(mutualTls);
            return this;
        }

        /**
         * mutual TLS module configuration or <code>null</code>
         *
         * @param mutualTls the value of the mutual_tls parameter as an {@link Optional} of {@link EndpointMutualTlsMutate}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder mutualTls(final Optional<EndpointMutualTlsMutate> mutualTls) {
            this.mutualTls = Objects.requireNonNull(mutualTls, "mutualTls is required");
            return this;
        }
        
        /**
         * TLS termination module configuration or <code>null</code>
         *
         * @param tlsTermination the value of the tls_termination parameter as a {@link EndpointTlsTermination}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder tlsTermination(final EndpointTlsTermination tlsTermination) {
            this.tlsTermination = Optional.ofNullable(tlsTermination);
            return this;
        }

        /**
         * TLS termination module configuration or <code>null</code>
         *
         * @param tlsTermination the value of the tls_termination parameter as an {@link Optional} of {@link EndpointTlsTermination}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder tlsTermination(final Optional<EndpointTlsTermination> tlsTermination) {
            this.tlsTermination = Objects.requireNonNull(tlsTermination, "tlsTermination is required");
            return this;
        }
        
        /**
         * webhook validation module configuration or <code>null</code>
         *
         * @param webhookValidation the value of the webhook_validation parameter as a {@link EndpointWebhookValidation}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder webhookValidation(final EndpointWebhookValidation webhookValidation) {
            this.webhookValidation = Optional.ofNullable(webhookValidation);
            return this;
        }

        /**
         * webhook validation module configuration or <code>null</code>
         *
         * @param webhookValidation the value of the webhook_validation parameter as an {@link Optional} of {@link EndpointWebhookValidation}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder webhookValidation(final Optional<EndpointWebhookValidation> webhookValidation) {
            this.webhookValidation = Objects.requireNonNull(webhookValidation, "webhookValidation is required");
            return this;
        }
        
        /**
         * oauth module configuration or <code>null</code>
         *
         * @param oauth the value of the oauth parameter as a {@link EndpointOAuth}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder oauth(final EndpointOAuth oauth) {
            this.oauth = Optional.ofNullable(oauth);
            return this;
        }

        /**
         * oauth module configuration or <code>null</code>
         *
         * @param oauth the value of the oauth parameter as an {@link Optional} of {@link EndpointOAuth}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder oauth(final Optional<EndpointOAuth> oauth) {
            this.oauth = Objects.requireNonNull(oauth, "oauth is required");
            return this;
        }
        
        /**
         * logging module configuration or <code>null</code>
         *
         * @param logging the value of the logging parameter as a {@link EndpointLoggingMutate}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder logging(final EndpointLoggingMutate logging) {
            this.logging = Optional.ofNullable(logging);
            return this;
        }

        /**
         * logging module configuration or <code>null</code>
         *
         * @param logging the value of the logging parameter as an {@link Optional} of {@link EndpointLoggingMutate}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder logging(final Optional<EndpointLoggingMutate> logging) {
            this.logging = Objects.requireNonNull(logging, "logging is required");
            return this;
        }
        
        /**
         * saml module configuration or <code>null</code>
         *
         * @param saml the value of the saml parameter as a {@link EndpointSamlMutate}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder saml(final EndpointSamlMutate saml) {
            this.saml = Optional.ofNullable(saml);
            return this;
        }

        /**
         * saml module configuration or <code>null</code>
         *
         * @param saml the value of the saml parameter as an {@link Optional} of {@link EndpointSamlMutate}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder saml(final Optional<EndpointSamlMutate> saml) {
            this.saml = Objects.requireNonNull(saml, "saml is required");
            return this;
        }
        
        /**
         * oidc module configuration or <code>null</code>
         *
         * @param oidc the value of the oidc parameter as a {@link EndpointOidc}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder oidc(final EndpointOidc oidc) {
            this.oidc = Optional.ofNullable(oidc);
            return this;
        }

        /**
         * oidc module configuration or <code>null</code>
         *
         * @param oidc the value of the oidc parameter as an {@link Optional} of {@link EndpointOidc}
         * @return the call builder instance
         */
        public EndpointConfigurationsUpdateCallBuilder oidc(final Optional<EndpointOidc> oidc) {
            this.oidc = Objects.requireNonNull(oidc, "oidc is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EndpointConfiguration}
         */
        public CompletionStage<EndpointConfiguration> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/endpoint_configurations/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("circuit_breaker", this.circuitBreaker.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("compression", this.compression.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("request_headers", this.requestHeaders.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("response_headers", this.responseHeaders.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("ip_policy", this.ipPolicy.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("mutual_tls", this.mutualTls.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("tls_termination", this.tlsTermination.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("webhook_validation", this.webhookValidation.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("oauth", this.oauth.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("logging", this.logging.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("saml", this.saml.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("oidc", this.oidc.map(Function.identity()))
                ),
                Optional.of(EndpointConfiguration.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EndpointConfiguration}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EndpointConfiguration blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Updates an endpoint configuration. If a module is not specified in the update,
     * it will not be modified. However, each module configuration that is specified
     * will completely replace the existing value. There is no way to delete an
     * existing module via this API, instead use the delete module API.
     *
     * @param id unique identifier of this endpoint configuration
     * @return a call builder for this API call
     */
    public EndpointConfigurationsUpdateCallBuilder update(
        final String id
    ) {
        return new EndpointConfigurationsUpdateCallBuilder(
            id
        );
    }
}
