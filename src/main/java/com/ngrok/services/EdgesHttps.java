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
 * An API client for {@link EdgesHttps}.
 *
 * See also <a href="https://ngrok.com/docs/api#api-edges-https">https://ngrok.com/docs/api#api-edges-https</a>.
 */
public class EdgesHttps {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for EdgesHttps.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public EdgesHttps(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class CreateCallBuilder {
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private Optional<java.util.List<String>> hostports = Optional.empty();
        private Optional<EndpointMutualTlsMutate> mutualTls = Optional.empty();
        private Optional<EndpointTlsTerminationAtEdge> tlsTermination = Optional.empty();

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
         * arbitrary user-defined machine-readable data of this edge; optional, max 4096
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
         * arbitrary user-defined machine-readable data of this edge; optional, max 4096
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
         * hostports served by this edge
         *
         * @param hostports the value of the hostports parameter as a {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder hostports(final java.util.List<String> hostports) {
            this.hostports = Optional.of(Objects.requireNonNull(hostports, "hostports is required"));
            return this;
        }

        /**
         * hostports served by this edge
         *
         * @param hostports the value of the hostports parameter as an {@link Optional} of {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder hostports(final Optional<java.util.List<String>> hostports) {
            this.hostports = Objects.requireNonNull(hostports, "hostports is required");
            return this;
        }
        
        /**
         * edge modules
         *
         * @param mutualTls the value of the mutual_tls parameter as a {@link EndpointMutualTlsMutate}
         * @return the call builder instance
         */
        public CreateCallBuilder mutualTls(final EndpointMutualTlsMutate mutualTls) {
            this.mutualTls = Optional.of(Objects.requireNonNull(mutualTls, "mutualTls is required"));
            return this;
        }

        /**
         * edge modules
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
         * @param tlsTermination the value of the tls_termination parameter as a {@link EndpointTlsTerminationAtEdge}
         * @return the call builder instance
         */
        public CreateCallBuilder tlsTermination(final EndpointTlsTerminationAtEdge tlsTermination) {
            this.tlsTermination = Optional.of(Objects.requireNonNull(tlsTermination, "tlsTermination is required"));
            return this;
        }

        /**
         * Sets (or unsets) the <code>tls_termination</code> parameter.
         *
         * @param tlsTermination the value of the tls_termination parameter as an {@link Optional} of {@link EndpointTlsTerminationAtEdge}
         * @return the call builder instance
         */
        public CreateCallBuilder tlsTermination(final Optional<EndpointTlsTerminationAtEdge> tlsTermination) {
            this.tlsTermination = Objects.requireNonNull(tlsTermination, "tlsTermination is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link HttpsEdge}
         */
        public CompletionStage<HttpsEdge> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/edges/https",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("hostports", Optional.of(this.hostports).filter(hostports -> !hostports.isEmpty()).map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("mutual_tls", this.mutualTls.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("tls_termination", this.tlsTermination.map(Function.identity()))
                ),
                Optional.of(HttpsEdge.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link HttpsEdge}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public HttpsEdge blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create an HTTPS Edge
     *
     * See also <a href="https://ngrok.com/docs/api#api-edges-https-create">https://ngrok.com/docs/api#api-edges-https-create</a>.
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
         * @return a {@link CompletionStage} of {@link HttpsEdge}
         */
        public CompletionStage<HttpsEdge> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/edges/https/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(HttpsEdge.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link HttpsEdge}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public HttpsEdge blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get an HTTPS Edge by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-edges-https-get">https://ngrok.com/docs/api#api-edges-https-get</a>.
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
         * @return a {@link CompletionStage} of a {@link Page} of {@link HttpsEdgeList}
         */
        public CompletionStage<Page<HttpsEdgeList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/edges/https",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(HttpsEdgeList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link HttpsEdgeList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<HttpsEdgeList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Returns a list of all HTTPS Edges on this account
     *
     * See also <a href="https://ngrok.com/docs/api#api-edges-https-list">https://ngrok.com/docs/api#api-edges-https-list</a>.
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
        private Optional<EndpointMutualTlsMutate> mutualTls = Optional.empty();
        private Optional<EndpointTlsTerminationAtEdge> tlsTermination = Optional.empty();

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
         * arbitrary user-defined machine-readable data of this edge; optional, max 4096
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
         * arbitrary user-defined machine-readable data of this edge; optional, max 4096
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
         * @param hostports the value of the hostports parameter as a {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder hostports(final java.util.List<String> hostports) {
            this.hostports = Optional.of(Objects.requireNonNull(hostports, "hostports is required"));
            return this;
        }

        /**
         * hostports served by this edge
         *
         * @param hostports the value of the hostports parameter as an {@link Optional} of {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder hostports(final Optional<java.util.List<String>> hostports) {
            this.hostports = Objects.requireNonNull(hostports, "hostports is required");
            return this;
        }
        
        /**
         * edge modules
         *
         * @param mutualTls the value of the mutual_tls parameter as a {@link EndpointMutualTlsMutate}
         * @return the call builder instance
         */
        public UpdateCallBuilder mutualTls(final EndpointMutualTlsMutate mutualTls) {
            this.mutualTls = Optional.of(Objects.requireNonNull(mutualTls, "mutualTls is required"));
            return this;
        }

        /**
         * edge modules
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
         * @param tlsTermination the value of the tls_termination parameter as a {@link EndpointTlsTerminationAtEdge}
         * @return the call builder instance
         */
        public UpdateCallBuilder tlsTermination(final EndpointTlsTerminationAtEdge tlsTermination) {
            this.tlsTermination = Optional.of(Objects.requireNonNull(tlsTermination, "tlsTermination is required"));
            return this;
        }

        /**
         * Sets (or unsets) the <code>tls_termination</code> parameter.
         *
         * @param tlsTermination the value of the tls_termination parameter as an {@link Optional} of {@link EndpointTlsTerminationAtEdge}
         * @return the call builder instance
         */
        public UpdateCallBuilder tlsTermination(final Optional<EndpointTlsTerminationAtEdge> tlsTermination) {
            this.tlsTermination = Objects.requireNonNull(tlsTermination, "tlsTermination is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link HttpsEdge}
         */
        public CompletionStage<HttpsEdge> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/edges/https/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("hostports", Optional.of(this.hostports).filter(hostports -> !hostports.isEmpty()).map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("mutual_tls", this.mutualTls.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("tls_termination", this.tlsTermination.map(Function.identity()))
                ),
                Optional.of(HttpsEdge.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link HttpsEdge}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public HttpsEdge blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Updates an HTTPS Edge by ID. If a module is not specified in the update, it will
     * not be modified. However, each module configuration that is specified will
     * completely replace the existing value. There is no way to delete an existing
     * module via this API, instead use the delete module API.
     *
     * See also <a href="https://ngrok.com/docs/api#api-edges-https-update">https://ngrok.com/docs/api#api-edges-https-update</a>.
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
                "/edges/https/" + this.id,
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
     * Delete an HTTPS Edge by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-edges-https-delete">https://ngrok.com/docs/api#api-edges-https-delete</a>.
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
