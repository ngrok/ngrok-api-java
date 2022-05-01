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
 * A Failover backend defines failover behavior within a list of referenced
 *  backends. Traffic is sent to the first backend in the list. If that backend
 *  is offline or no connection can be established, ngrok attempts to connect to
 *  the next backend in the list until one is successful.
 *
 * See also <a href="https://ngrok.com/docs/api#api-failover-backends">https://ngrok.com/docs/api#api-failover-backends</a>.
 */
public class FailoverBackends {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for FailoverBackends.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public FailoverBackends(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class CreateCallBuilder {
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private java.util.List<String> backends = java.util.Collections.emptyList();

        private CreateCallBuilder(
        ) {
        }
        
        /**
         * human-readable description of this backend. Optional
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final String description) {
            this.description = Optional.of(Objects.requireNonNull(description, "description is required"));
            return this;
        }

        /**
         * human-readable description of this backend. Optional
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this backend. Optional
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.of(Objects.requireNonNull(metadata, "metadata is required"));
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this backend. Optional
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * the ids of the child backends in order
         *
         * @param backends the value of the backends parameter as a {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder backends(final java.util.List<String> backends) {
            this.backends = Objects.requireNonNull(backends, "backends is required");
            return this;
        }

        /**
         * the ids of the child backends in order
         *
         * @param backends the value of the backends parameter as an {@link Optional} of {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder backends(final Optional<java.util.List<String>> backends) {
            this.backends = Objects.requireNonNull(backends, "backends is required").orElse(java.util.Collections.emptyList());
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link FailoverBackend}
         */
        public CompletionStage<FailoverBackend> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/backends/failover",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("backends", Optional.of(this.backends).filter(backends -> !backends.isEmpty()).map(Function.identity()))
                ),
                Optional.of(FailoverBackend.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link FailoverBackend}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public FailoverBackend blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create a new Failover backend
     *
     * See also <a href="https://ngrok.com/docs/api#api-failover-backends-create">https://ngrok.com/docs/api#api-failover-backends-create</a>.
     *
     * @return a call builder for this API call
     */
    public CreateCallBuilder create(
    ) {
        return new CreateCallBuilder(
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
                "/backends/failover/" + this.id,
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
     * Delete a Failover backend by ID.
     *
     * See also <a href="https://ngrok.com/docs/api#api-failover-backends-delete">https://ngrok.com/docs/api#api-failover-backends-delete</a>.
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
         * @return a {@link CompletionStage} of {@link FailoverBackend}
         */
        public CompletionStage<FailoverBackend> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/backends/failover/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(FailoverBackend.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link FailoverBackend}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public FailoverBackend blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get detailed information about a Failover backend by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-failover-backends-get">https://ngrok.com/docs/api#api-failover-backends-get</a>.
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
         * @return a {@link CompletionStage} of a {@link Page} of {@link FailoverBackendList}
         */
        public CompletionStage<Page<FailoverBackendList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/backends/failover",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(FailoverBackendList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link FailoverBackendList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<FailoverBackendList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List all Failover backends on this account
     *
     * See also <a href="https://ngrok.com/docs/api#api-failover-backends-list">https://ngrok.com/docs/api#api-failover-backends-list</a>.
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
        private java.util.List<String> backends = java.util.Collections.emptyList();

        private UpdateCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * human-readable description of this backend. Optional
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final String description) {
            this.description = Optional.of(Objects.requireNonNull(description, "description is required"));
            return this;
        }

        /**
         * human-readable description of this backend. Optional
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this backend. Optional
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.of(Objects.requireNonNull(metadata, "metadata is required"));
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this backend. Optional
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * the ids of the child backends in order
         *
         * @param backends the value of the backends parameter as a {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder backends(final java.util.List<String> backends) {
            this.backends = Objects.requireNonNull(backends, "backends is required");
            return this;
        }

        /**
         * the ids of the child backends in order
         *
         * @param backends the value of the backends parameter as an {@link Optional} of {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder backends(final Optional<java.util.List<String>> backends) {
            this.backends = Objects.requireNonNull(backends, "backends is required").orElse(java.util.Collections.emptyList());
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link FailoverBackend}
         */
        public CompletionStage<FailoverBackend> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/backends/failover/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("backends", Optional.of(this.backends).filter(backends -> !backends.isEmpty()).map(Function.identity()))
                ),
                Optional.of(FailoverBackend.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link FailoverBackend}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public FailoverBackend blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update Failover backend by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-failover-backends-update">https://ngrok.com/docs/api#api-failover-backends-update</a>.
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
