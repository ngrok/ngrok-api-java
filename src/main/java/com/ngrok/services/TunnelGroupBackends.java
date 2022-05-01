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
 * A Tunnel Group Backend balances traffic among all online tunnels that match
 *  a label selector.
 *
 * See also <a href="https://ngrok.com/docs/api#api-tunnel-group-backends">https://ngrok.com/docs/api#api-tunnel-group-backends</a>.
 */
public class TunnelGroupBackends {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for TunnelGroupBackends.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public TunnelGroupBackends(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class CreateCallBuilder {
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private java.util.Map<String, String> labels = java.util.Collections.emptyMap();

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
         * labels to watch for tunnels on, e.g. app-&gt;foo, dc-&gt;bar
         *
         * @param labels the value of the labels parameter as a {@link java.util.Map} of {@link String} to {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder labels(final java.util.Map<String, String> labels) {
            this.labels = Objects.requireNonNull(labels, "labels is required");
            return this;
        }

        /**
         * labels to watch for tunnels on, e.g. app-&gt;foo, dc-&gt;bar
         *
         * @param labels the value of the labels parameter as an {@link Optional} of {@link java.util.Map} of {@link String} to {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder labels(final Optional<java.util.Map<String, String>> labels) {
            this.labels = Objects.requireNonNull(labels, "labels is required").orElse(java.util.Collections.emptyMap());
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link TunnelGroupBackend}
         */
        public CompletionStage<TunnelGroupBackend> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/backends/tunnel_group",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("labels", Optional.of(this.labels).filter(labels -> !labels.isEmpty()).map(Function.identity()))
                ),
                Optional.of(TunnelGroupBackend.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link TunnelGroupBackend}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public TunnelGroupBackend blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create a new TunnelGroup backend
     *
     * See also <a href="https://ngrok.com/docs/api#api-tunnel-group-backends-create">https://ngrok.com/docs/api#api-tunnel-group-backends-create</a>.
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
                "/backends/tunnel_group/" + this.id,
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
     * Delete a TunnelGroup backend by ID.
     *
     * See also <a href="https://ngrok.com/docs/api#api-tunnel-group-backends-delete">https://ngrok.com/docs/api#api-tunnel-group-backends-delete</a>.
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
         * @return a {@link CompletionStage} of {@link TunnelGroupBackend}
         */
        public CompletionStage<TunnelGroupBackend> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/backends/tunnel_group/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(TunnelGroupBackend.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link TunnelGroupBackend}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public TunnelGroupBackend blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get detailed information about a TunnelGroup backend by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-tunnel-group-backends-get">https://ngrok.com/docs/api#api-tunnel-group-backends-get</a>.
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
         * @return a {@link CompletionStage} of a {@link Page} of {@link TunnelGroupBackendList}
         */
        public CompletionStage<Page<TunnelGroupBackendList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/backends/tunnel_group",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(TunnelGroupBackendList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link TunnelGroupBackendList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<TunnelGroupBackendList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List all TunnelGroup backends on this account
     *
     * See also <a href="https://ngrok.com/docs/api#api-tunnel-group-backends-list">https://ngrok.com/docs/api#api-tunnel-group-backends-list</a>.
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
        private java.util.Map<String, String> labels = java.util.Collections.emptyMap();

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
         * labels to watch for tunnels on, e.g. app-&gt;foo, dc-&gt;bar
         *
         * @param labels the value of the labels parameter as a {@link java.util.Map} of {@link String} to {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder labels(final java.util.Map<String, String> labels) {
            this.labels = Objects.requireNonNull(labels, "labels is required");
            return this;
        }

        /**
         * labels to watch for tunnels on, e.g. app-&gt;foo, dc-&gt;bar
         *
         * @param labels the value of the labels parameter as an {@link Optional} of {@link java.util.Map} of {@link String} to {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder labels(final Optional<java.util.Map<String, String>> labels) {
            this.labels = Objects.requireNonNull(labels, "labels is required").orElse(java.util.Collections.emptyMap());
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link TunnelGroupBackend}
         */
        public CompletionStage<TunnelGroupBackend> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/backends/tunnel_group/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("labels", Optional.of(this.labels).filter(labels -> !labels.isEmpty()).map(Function.identity()))
                ),
                Optional.of(TunnelGroupBackend.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link TunnelGroupBackend}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public TunnelGroupBackend blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update TunnelGroup backend by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-tunnel-group-backends-update">https://ngrok.com/docs/api#api-tunnel-group-backends-update</a>.
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
