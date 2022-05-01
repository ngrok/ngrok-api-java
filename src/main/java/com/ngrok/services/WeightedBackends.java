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
 * A Weighted Backend balances traffic among the referenced backends. Traffic
 *  is assigned proportionally to each based on its weight. The percentage of
 *  traffic is calculated by dividing a backend&#39;s weight by the sum of all
 *  weights.
 *
 * See also <a href="https://ngrok.com/docs/api#api-weighted-backends">https://ngrok.com/docs/api#api-weighted-backends</a>.
 */
public class WeightedBackends {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for WeightedBackends.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public WeightedBackends(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class CreateCallBuilder {
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private java.util.Map<String, Long> backends = java.util.Collections.emptyMap();

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
         * the ids of the child backends to their weights [0-10000]
         *
         * @param backends the value of the backends parameter as a {@link java.util.Map} of {@link String} to {@link Long}
         * @return the call builder instance
         */
        public CreateCallBuilder backends(final java.util.Map<String, Long> backends) {
            this.backends = Objects.requireNonNull(backends, "backends is required");
            return this;
        }

        /**
         * the ids of the child backends to their weights [0-10000]
         *
         * @param backends the value of the backends parameter as an {@link Optional} of {@link java.util.Map} of {@link String} to {@link Long}
         * @return the call builder instance
         */
        public CreateCallBuilder backends(final Optional<java.util.Map<String, Long>> backends) {
            this.backends = Objects.requireNonNull(backends, "backends is required").orElse(java.util.Collections.emptyMap());
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link WeightedBackend}
         */
        public CompletionStage<WeightedBackend> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/backends/weighted",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("backends", Optional.of(this.backends).filter(backends -> !backends.isEmpty()).map(Function.identity()))
                ),
                Optional.of(WeightedBackend.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link WeightedBackend}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public WeightedBackend blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create a new Weighted backend
     *
     * See also <a href="https://ngrok.com/docs/api#api-weighted-backends-create">https://ngrok.com/docs/api#api-weighted-backends-create</a>.
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
                "/backends/weighted/" + this.id,
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
     * Delete a Weighted backend by ID.
     *
     * See also <a href="https://ngrok.com/docs/api#api-weighted-backends-delete">https://ngrok.com/docs/api#api-weighted-backends-delete</a>.
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
         * @return a {@link CompletionStage} of {@link WeightedBackend}
         */
        public CompletionStage<WeightedBackend> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/backends/weighted/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(WeightedBackend.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link WeightedBackend}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public WeightedBackend blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get detailed information about a Weighted backend by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-weighted-backends-get">https://ngrok.com/docs/api#api-weighted-backends-get</a>.
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
         * @return a {@link CompletionStage} of a {@link Page} of {@link WeightedBackendList}
         */
        public CompletionStage<Page<WeightedBackendList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/backends/weighted",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(WeightedBackendList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link WeightedBackendList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<WeightedBackendList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List all Weighted backends on this account
     *
     * See also <a href="https://ngrok.com/docs/api#api-weighted-backends-list">https://ngrok.com/docs/api#api-weighted-backends-list</a>.
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
        private java.util.Map<String, Long> backends = java.util.Collections.emptyMap();

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
         * the ids of the child backends to their weights [0-10000]
         *
         * @param backends the value of the backends parameter as a {@link java.util.Map} of {@link String} to {@link Long}
         * @return the call builder instance
         */
        public UpdateCallBuilder backends(final java.util.Map<String, Long> backends) {
            this.backends = Objects.requireNonNull(backends, "backends is required");
            return this;
        }

        /**
         * the ids of the child backends to their weights [0-10000]
         *
         * @param backends the value of the backends parameter as an {@link Optional} of {@link java.util.Map} of {@link String} to {@link Long}
         * @return the call builder instance
         */
        public UpdateCallBuilder backends(final Optional<java.util.Map<String, Long>> backends) {
            this.backends = Objects.requireNonNull(backends, "backends is required").orElse(java.util.Collections.emptyMap());
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link WeightedBackend}
         */
        public CompletionStage<WeightedBackend> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/backends/weighted/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("backends", Optional.of(this.backends).filter(backends -> !backends.isEmpty()).map(Function.identity()))
                ),
                Optional.of(WeightedBackend.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link WeightedBackend}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public WeightedBackend blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update Weighted backend by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-weighted-backends-update">https://ngrok.com/docs/api#api-weighted-backends-update</a>.
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
