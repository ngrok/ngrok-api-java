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
 * An API client for {@link EdgesTls}.
 *
 * See also <a href="https://ngrok.com/docs/api#api-edges-tls">https://ngrok.com/docs/api#api-edges-tls</a>.
 */
public class EdgesTls {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for EdgesTls.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public EdgesTls(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class CreateCallBuilder {
        private String description = "";
        private String metadata = "";
        private Optional<java.util.List<String>> hostports = Optional.empty();
        private Optional<EndpointBackendMutate> backend = Optional.empty();
        private Optional<EndpointIpPolicyMutate> ipRestriction = Optional.empty();
        private Optional<EndpointMutualTlsMutate> mutualTls = Optional.empty();
        private Optional<EndpointTlsTermination> tlsTermination = Optional.empty();

        private CreateCallBuilder(
        ) {
        }
        
        /**
         * human-readable description of what this edge will be used for; optional, max 255
         * bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final String description) {
            this.description = Objects.requireNonNull(description, "description is required");
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
            this.description = Objects.requireNonNull(description, "description is required").orElse("");
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
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
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
            this.metadata = Objects.requireNonNull(metadata, "metadata is required").orElse("");
            return this;
        }
        
        /**
         * hostports served by this edge
         *
         * @param hostports the value of the hostports parameter as a {@link java.util.List<String>}
         * @return the call builder instance
         */
        public CreateCallBuilder hostports(final java.util.List<String> hostports) {
            this.hostports = Optional.ofNullable(hostports);
            return this;
        }

        /**
         * hostports served by this edge
         *
         * @param hostports the value of the hostports parameter as an {@link Optional} of {@link java.util.List<String>}
         * @return the call builder instance
         */
        public CreateCallBuilder hostports(final Optional<java.util.List<String>> hostports) {
            this.hostports = Objects.requireNonNull(hostports, "hostports is required");
            return this;
        }
        
        /**
         * edge modules
         *
         * @param backend the value of the backend parameter as a {@link EndpointBackendMutate}
         * @return the call builder instance
         */
        public CreateCallBuilder backend(final EndpointBackendMutate backend) {
            this.backend = Optional.ofNullable(backend);
            return this;
        }

        /**
         * edge modules
         *
         * @param backend the value of the backend parameter as an {@link Optional} of {@link EndpointBackendMutate}
         * @return the call builder instance
         */
        public CreateCallBuilder backend(final Optional<EndpointBackendMutate> backend) {
            this.backend = Objects.requireNonNull(backend, "backend is required");
            return this;
        }
        
        /**
         * Sets the <code>ip_restriction</code> parameter.
         *
         * @param ipRestriction the value of the ip_restriction parameter as a {@link EndpointIpPolicyMutate}
         * @return the call builder instance
         */
        public CreateCallBuilder ipRestriction(final EndpointIpPolicyMutate ipRestriction) {
            this.ipRestriction = Optional.ofNullable(ipRestriction);
            return this;
        }

        /**
         * Sets (or unsets) the <code>ip_restriction</code> parameter.
         *
         * @param ipRestriction the value of the ip_restriction parameter as an {@link Optional} of {@link EndpointIpPolicyMutate}
         * @return the call builder instance
         */
        public CreateCallBuilder ipRestriction(final Optional<EndpointIpPolicyMutate> ipRestriction) {
            this.ipRestriction = Objects.requireNonNull(ipRestriction, "ipRestriction is required");
            return this;
        }
        
        /**
         * Sets the <code>mutual_tls</code> parameter.
         *
         * @param mutualTls the value of the mutual_tls parameter as a {@link EndpointMutualTlsMutate}
         * @return the call builder instance
         */
        public CreateCallBuilder mutualTls(final EndpointMutualTlsMutate mutualTls) {
            this.mutualTls = Optional.ofNullable(mutualTls);
            return this;
        }

        /**
         * Sets (or unsets) the <code>mutual_tls</code> parameter.
         *
         * @param mutualTls the value of the mutual_tls parameter as an {@link Optional} of {@link EndpointMutualTlsMutate}
         * @return the call builder instance
         */
        public CreateCallBuilder mutualTls(final Optional<EndpointMutualTlsMutate> mutualTls) {
            this.mutualTls = Objects.requireNonNull(mutualTls, "mutualTls is required");
            return this;
        }
        
        /**
         * Sets the <code>tls_termination</code> parameter.
         *
         * @param tlsTermination the value of the tls_termination parameter as a {@link EndpointTlsTermination}
         * @return the call builder instance
         */
        public CreateCallBuilder tlsTermination(final EndpointTlsTermination tlsTermination) {
            this.tlsTermination = Optional.ofNullable(tlsTermination);
            return this;
        }

        /**
         * Sets (or unsets) the <code>tls_termination</code> parameter.
         *
         * @param tlsTermination the value of the tls_termination parameter as an {@link Optional} of {@link EndpointTlsTermination}
         * @return the call builder instance
         */
        public CreateCallBuilder tlsTermination(final Optional<EndpointTlsTermination> tlsTermination) {
            this.tlsTermination = Objects.requireNonNull(tlsTermination, "tlsTermination is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link TlsEdge}
         */
        public CompletionStage<TlsEdge> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/edges/tls",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", Optional.of(this.description)),
                    new AbstractMap.SimpleEntry<>("metadata", Optional.of(this.metadata)),
                    new AbstractMap.SimpleEntry<>("hostports", this.hostports.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("backend", this.backend.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("ip_restriction", this.ipRestriction.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("mutual_tls", this.mutualTls.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("tls_termination", this.tlsTermination.map(Function.identity()))
                ),
                Optional.of(TlsEdge.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link TlsEdge}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public TlsEdge blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create a TLS Edge
     *
     * See also <a href="https://ngrok.com/docs/api#api-edges-tls-create">https://ngrok.com/docs/api#api-edges-tls-create</a>.
     *
     * @return a call builder for this API call
     */
    public CreateCallBuilder create(
    ) {
        return new CreateCallBuilder(
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
         * @return a {@link CompletionStage} of {@link TlsEdge}
         */
        public CompletionStage<TlsEdge> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/edges/tls/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(TlsEdge.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link TlsEdge}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public TlsEdge blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get a TLS Edge by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-edges-tls-get">https://ngrok.com/docs/api#api-edges-tls-get</a>.
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
            this.beforeId = Optional.ofNullable(beforeId);
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
            this.limit = Optional.ofNullable(limit);
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
         * @return a {@link CompletionStage} of a {@link Page} of {@link TlsEdgeList}
         */
        public CompletionStage<Page<TlsEdgeList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/edges/tls",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(TlsEdgeList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link TlsEdgeList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<TlsEdgeList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Returns a list of all TLS Edges on this account
     *
     * See also <a href="https://ngrok.com/docs/api#api-edges-tls-list">https://ngrok.com/docs/api#api-edges-tls-list</a>.
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
        private Optional<java.util.List<String>> hostports = Optional.empty();
        private Optional<EndpointBackendMutate> backend = Optional.empty();
        private Optional<EndpointIpPolicyMutate> ipRestriction = Optional.empty();
        private Optional<EndpointMutualTlsMutate> mutualTls = Optional.empty();
        private Optional<EndpointTlsTermination> tlsTermination = Optional.empty();

        private UpdateCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * human-readable description of what this edge will be used for; optional, max 255
         * bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final String description) {
            this.description = Optional.ofNullable(description);
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
            this.metadata = Optional.ofNullable(metadata);
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
         * hostports served by this edge
         *
         * @param hostports the value of the hostports parameter as a {@link java.util.List<String>}
         * @return the call builder instance
         */
        public UpdateCallBuilder hostports(final java.util.List<String> hostports) {
            this.hostports = Optional.ofNullable(hostports);
            return this;
        }

        /**
         * hostports served by this edge
         *
         * @param hostports the value of the hostports parameter as an {@link Optional} of {@link java.util.List<String>}
         * @return the call builder instance
         */
        public UpdateCallBuilder hostports(final Optional<java.util.List<String>> hostports) {
            this.hostports = Objects.requireNonNull(hostports, "hostports is required");
            return this;
        }
        
        /**
         * edge modules
         *
         * @param backend the value of the backend parameter as a {@link EndpointBackendMutate}
         * @return the call builder instance
         */
        public UpdateCallBuilder backend(final EndpointBackendMutate backend) {
            this.backend = Optional.ofNullable(backend);
            return this;
        }

        /**
         * edge modules
         *
         * @param backend the value of the backend parameter as an {@link Optional} of {@link EndpointBackendMutate}
         * @return the call builder instance
         */
        public UpdateCallBuilder backend(final Optional<EndpointBackendMutate> backend) {
            this.backend = Objects.requireNonNull(backend, "backend is required");
            return this;
        }
        
        /**
         * Sets the <code>ip_restriction</code> parameter.
         *
         * @param ipRestriction the value of the ip_restriction parameter as a {@link EndpointIpPolicyMutate}
         * @return the call builder instance
         */
        public UpdateCallBuilder ipRestriction(final EndpointIpPolicyMutate ipRestriction) {
            this.ipRestriction = Optional.ofNullable(ipRestriction);
            return this;
        }

        /**
         * Sets (or unsets) the <code>ip_restriction</code> parameter.
         *
         * @param ipRestriction the value of the ip_restriction parameter as an {@link Optional} of {@link EndpointIpPolicyMutate}
         * @return the call builder instance
         */
        public UpdateCallBuilder ipRestriction(final Optional<EndpointIpPolicyMutate> ipRestriction) {
            this.ipRestriction = Objects.requireNonNull(ipRestriction, "ipRestriction is required");
            return this;
        }
        
        /**
         * Sets the <code>mutual_tls</code> parameter.
         *
         * @param mutualTls the value of the mutual_tls parameter as a {@link EndpointMutualTlsMutate}
         * @return the call builder instance
         */
        public UpdateCallBuilder mutualTls(final EndpointMutualTlsMutate mutualTls) {
            this.mutualTls = Optional.ofNullable(mutualTls);
            return this;
        }

        /**
         * Sets (or unsets) the <code>mutual_tls</code> parameter.
         *
         * @param mutualTls the value of the mutual_tls parameter as an {@link Optional} of {@link EndpointMutualTlsMutate}
         * @return the call builder instance
         */
        public UpdateCallBuilder mutualTls(final Optional<EndpointMutualTlsMutate> mutualTls) {
            this.mutualTls = Objects.requireNonNull(mutualTls, "mutualTls is required");
            return this;
        }
        
        /**
         * Sets the <code>tls_termination</code> parameter.
         *
         * @param tlsTermination the value of the tls_termination parameter as a {@link EndpointTlsTermination}
         * @return the call builder instance
         */
        public UpdateCallBuilder tlsTermination(final EndpointTlsTermination tlsTermination) {
            this.tlsTermination = Optional.ofNullable(tlsTermination);
            return this;
        }

        /**
         * Sets (or unsets) the <code>tls_termination</code> parameter.
         *
         * @param tlsTermination the value of the tls_termination parameter as an {@link Optional} of {@link EndpointTlsTermination}
         * @return the call builder instance
         */
        public UpdateCallBuilder tlsTermination(final Optional<EndpointTlsTermination> tlsTermination) {
            this.tlsTermination = Objects.requireNonNull(tlsTermination, "tlsTermination is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link TlsEdge}
         */
        public CompletionStage<TlsEdge> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/edges/tls/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("hostports", this.hostports.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("backend", this.backend.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("ip_restriction", this.ipRestriction.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("mutual_tls", this.mutualTls.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("tls_termination", this.tlsTermination.map(Function.identity()))
                ),
                Optional.of(TlsEdge.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link TlsEdge}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public TlsEdge blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Updates a TLS Edge by ID. If a module is not specified in the update, it will
     * not be modified. However, each module configuration that is specified will
     * completely replace the existing value. There is no way to delete an existing
     * module via this API, instead use the delete module API.
     *
     * See also <a href="https://ngrok.com/docs/api#api-edges-tls-update">https://ngrok.com/docs/api#api-edges-tls-update</a>.
     *
     * @param id unique identifier of this edge
     * @return a call builder for this API call
     */
    public UpdateCallBuilder update(
        final String id
    ) {
        return new UpdateCallBuilder(
            id
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
                "/edges/tls/" + this.id,
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
     * Delete a TLS Edge by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-edges-tls-delete">https://ngrok.com/docs/api#api-edges-tls-delete</a>.
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
}
