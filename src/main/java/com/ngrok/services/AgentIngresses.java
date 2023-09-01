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
 * An API client for {@link AgentIngresses}.
 *
 * See also <a href="https://ngrok.com/docs/api#api-agent-ingresses">https://ngrok.com/docs/api#api-agent-ingresses</a>.
 */
public class AgentIngresses {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for AgentIngresses.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public AgentIngresses(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class CreateCallBuilder {
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private final String domain;
        private Optional<AgentIngressCertPolicy> certificateManagementPolicy = Optional.empty();

        private CreateCallBuilder(
            final String domain
        ) {
            this.domain = Objects.requireNonNull(domain, "domain is required");
        }
        
        /**
         * human-readable description of the use of this Agent Ingress. optional, max 255
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
         * human-readable description of the use of this Agent Ingress. optional, max 255
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
         * arbitrary user-defined machine-readable data of this Agent Ingress. optional,
         * max 4096 bytes
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.of(Objects.requireNonNull(metadata, "metadata is required"));
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this Agent Ingress. optional,
         * max 4096 bytes
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * configuration for automatic management of TLS certificates for this domain, or
         * null if automatic management is disabled. Optional.
         *
         * @param certificateManagementPolicy the value of the certificate_management_policy parameter as a {@link AgentIngressCertPolicy}
         * @return the call builder instance
         */
        public CreateCallBuilder certificateManagementPolicy(final AgentIngressCertPolicy certificateManagementPolicy) {
            this.certificateManagementPolicy = Optional.of(Objects.requireNonNull(certificateManagementPolicy, "certificateManagementPolicy is required"));
            return this;
        }

        /**
         * configuration for automatic management of TLS certificates for this domain, or
         * null if automatic management is disabled. Optional.
         *
         * @param certificateManagementPolicy the value of the certificate_management_policy parameter as an {@link Optional} of {@link AgentIngressCertPolicy}
         * @return the call builder instance
         */
        public CreateCallBuilder certificateManagementPolicy(final Optional<AgentIngressCertPolicy> certificateManagementPolicy) {
            this.certificateManagementPolicy = Objects.requireNonNull(certificateManagementPolicy, "certificateManagementPolicy is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link AgentIngress}
         */
        public CompletionStage<AgentIngress> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/agent_ingresses",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("domain", Optional.of(this.domain)),
                    new AbstractMap.SimpleEntry<>("certificate_management_policy", this.certificateManagementPolicy.map(Function.identity()))
                ),
                Optional.of(AgentIngress.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link AgentIngress}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public AgentIngress blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create a new Agent Ingress. The ngrok agent can be configured to connect to
     * ngrok via the new set of addresses on the returned Agent Ingress.
     *
     * See also <a href="https://ngrok.com/docs/api#api-agent-ingresses-create">https://ngrok.com/docs/api#api-agent-ingresses-create</a>.
     *
     * @param domain the domain that you own to be used as the base domain name to generate regional agent ingress domains.
     * @return a call builder for this API call
     */
    public CreateCallBuilder create(
        final String domain
    ) {
        return new CreateCallBuilder(
            domain
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Delete API call.
     */
    public class DeleteCallBuilder {
        private final String id;

        private DeleteCallBuilder(
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
                "/agent_ingresses/" + this.id,
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
     * Delete an Agent Ingress by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-agent-ingresses-delete">https://ngrok.com/docs/api#api-agent-ingresses-delete</a>.
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public DeleteCallBuilder delete(
        final String id
    ) {
        return new DeleteCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Get API call.
     */
    public class GetCallBuilder {
        private final String id;

        private GetCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link AgentIngress}
         */
        public CompletionStage<AgentIngress> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/agent_ingresses/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(AgentIngress.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link AgentIngress}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public AgentIngress blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get the details of an Agent Ingress by ID.
     *
     * See also <a href="https://ngrok.com/docs/api#api-agent-ingresses-get">https://ngrok.com/docs/api#api-agent-ingresses-get</a>.
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public GetCallBuilder get(
        final String id
    ) {
        return new GetCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent List API call.
     */
    public class ListCallBuilder {
        private Optional<String> beforeId = Optional.empty();
        private Optional<String> limit = Optional.empty();

        private ListCallBuilder(
        ) {
        }
        
        /**
         * Sets the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as a {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder beforeId(final String beforeId) {
            this.beforeId = Optional.of(Objects.requireNonNull(beforeId, "beforeId is required"));
            return this;
        }

        /**
         * Sets (or unsets) the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder beforeId(final Optional<String> beforeId) {
            this.beforeId = Objects.requireNonNull(beforeId, "beforeId is required");
            return this;
        }
        
        /**
         * Sets the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as a {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder limit(final String limit) {
            this.limit = Optional.of(Objects.requireNonNull(limit, "limit is required"));
            return this;
        }

        /**
         * Sets (or unsets) the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder limit(final Optional<String> limit) {
            this.limit = Objects.requireNonNull(limit, "limit is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of a {@link Page} of {@link AgentIngressList}
         */
        public CompletionStage<Page<AgentIngressList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/agent_ingresses",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(AgentIngressList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link AgentIngressList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<AgentIngressList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List all Agent Ingresses owned by this account
     *
     * See also <a href="https://ngrok.com/docs/api#api-agent-ingresses-list">https://ngrok.com/docs/api#api-agent-ingresses-list</a>.
     *
     * @return a call builder for this API call
     */
    public ListCallBuilder list(
    ) {
        return new ListCallBuilder(
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Update API call.
     */
    public class UpdateCallBuilder {
        private final String id;
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private Optional<AgentIngressCertPolicy> certificateManagementPolicy = Optional.empty();

        private UpdateCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * human-readable description of the use of this Agent Ingress. optional, max 255
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
         * human-readable description of the use of this Agent Ingress. optional, max 255
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
         * arbitrary user-defined machine-readable data of this Agent Ingress. optional,
         * max 4096 bytes
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.of(Objects.requireNonNull(metadata, "metadata is required"));
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this Agent Ingress. optional,
         * max 4096 bytes
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * configuration for automatic management of TLS certificates for this domain, or
         * null if automatic management is disabled. Optional.
         *
         * @param certificateManagementPolicy the value of the certificate_management_policy parameter as a {@link AgentIngressCertPolicy}
         * @return the call builder instance
         */
        public UpdateCallBuilder certificateManagementPolicy(final AgentIngressCertPolicy certificateManagementPolicy) {
            this.certificateManagementPolicy = Optional.of(Objects.requireNonNull(certificateManagementPolicy, "certificateManagementPolicy is required"));
            return this;
        }

        /**
         * configuration for automatic management of TLS certificates for this domain, or
         * null if automatic management is disabled. Optional.
         *
         * @param certificateManagementPolicy the value of the certificate_management_policy parameter as an {@link Optional} of {@link AgentIngressCertPolicy}
         * @return the call builder instance
         */
        public UpdateCallBuilder certificateManagementPolicy(final Optional<AgentIngressCertPolicy> certificateManagementPolicy) {
            this.certificateManagementPolicy = Objects.requireNonNull(certificateManagementPolicy, "certificateManagementPolicy is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link AgentIngress}
         */
        public CompletionStage<AgentIngress> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/agent_ingresses/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("certificate_management_policy", this.certificateManagementPolicy.map(Function.identity()))
                ),
                Optional.of(AgentIngress.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link AgentIngress}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public AgentIngress blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update attributes of an Agent Ingress by ID.
     *
     * See also <a href="https://ngrok.com/docs/api#api-agent-ingresses-update">https://ngrok.com/docs/api#api-agent-ingresses-update</a>.
     *
     * @param id the value of the <code>id</code> parameter as a {@link String}
     * @return a call builder for this API call
     */
    public UpdateCallBuilder update(
        final String id
    ) {
        return new UpdateCallBuilder(
            id
        );
    }
}
