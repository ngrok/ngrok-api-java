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
 * Endpoints provides an API for querying the endpoint objects
 *  which define what tunnel or edge is used to serve a hostport.
 *  Only active endpoints associated with a tunnel or backend are returned.
 *
 * See also <a href="https://ngrok.com/docs/api#api-endpoints">https://ngrok.com/docs/api#api-endpoints</a>.
 */
public class Endpoints {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for Endpoints.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public Endpoints(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class CreateCallBuilder {
        private final String url;
        private final String type;
        private final String trafficPolicy;
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private Optional<java.util.List<String>> bindings = Optional.empty();
        private Optional<Boolean> poolingEnabled = Optional.empty();

        private CreateCallBuilder(
            final String url,
            final String type,
            final String trafficPolicy
        ) {
            this.url = Objects.requireNonNull(url, "url is required");
            this.type = Objects.requireNonNull(type, "type is required");
            this.trafficPolicy = Objects.requireNonNull(trafficPolicy, "trafficPolicy is required");
        }
        
        /**
         * user-supplied description of the associated tunnel
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final String description) {
            this.description = Optional.of(Objects.requireNonNull(description, "description is required"));
            return this;
        }

        /**
         * user-supplied description of the associated tunnel
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * user-supplied metadata of the associated tunnel or edge object
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.of(Objects.requireNonNull(metadata, "metadata is required"));
            return this;
        }

        /**
         * user-supplied metadata of the associated tunnel or edge object
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * the bindings associated with this endpoint
         *
         * @param bindings the value of the bindings parameter as a {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder bindings(final java.util.List<String> bindings) {
            this.bindings = Optional.of(Objects.requireNonNull(bindings, "bindings is required"));
            return this;
        }

        /**
         * the bindings associated with this endpoint
         *
         * @param bindings the value of the bindings parameter as an {@link Optional} of {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder bindings(final Optional<java.util.List<String>> bindings) {
            this.bindings = Objects.requireNonNull(bindings, "bindings is required");
            return this;
        }
        
        /**
         * Sets the <code>pooling_enabled</code> parameter.
         *
         * @param poolingEnabled the value of the pooling_enabled parameter as a {@link boolean}
         * @return the call builder instance
         */
        public CreateCallBuilder poolingEnabled(final boolean poolingEnabled) {
            this.poolingEnabled = Optional.of(Objects.requireNonNull(poolingEnabled, "poolingEnabled is required"));
            return this;
        }

        /**
         * Sets (or unsets) the <code>pooling_enabled</code> parameter.
         *
         * @param poolingEnabled the value of the pooling_enabled parameter as an {@link Optional} of {@link boolean}
         * @return the call builder instance
         */
        public CreateCallBuilder poolingEnabled(final Optional<Boolean> poolingEnabled) {
            this.poolingEnabled = Objects.requireNonNull(poolingEnabled, "poolingEnabled is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link Endpoint}
         */
        public CompletionStage<Endpoint> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/endpoints",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("url", Optional.of(this.url)),
                    new AbstractMap.SimpleEntry<>("type", Optional.of(this.type)),
                    new AbstractMap.SimpleEntry<>("traffic_policy", Optional.of(this.trafficPolicy)),
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("bindings", Optional.of(this.bindings).filter(bindings -> !bindings.isEmpty()).map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("pooling_enabled", this.poolingEnabled.map(Function.identity()))
                ),
                Optional.of(Endpoint.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link Endpoint}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Endpoint blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create an endpoint, currently available only for cloud endpoints
     *
     * See also <a href="https://ngrok.com/docs/api#api-endpoints-create">https://ngrok.com/docs/api#api-endpoints-create</a>.
     *
     * @param url the url of the endpoint
     * @param type Type of endpoint. Only &#39;cloud&#39; is currently supported (represents a cloud endpoint). Defaults to &#39;cloud&#39; if not specified.
     * @param trafficPolicy The traffic policy attached to this endpoint
     * @return a call builder for this API call
     */
    public CreateCallBuilder create(
        final String url,
        final String type,
        final String trafficPolicy
    ) {
        return new CreateCallBuilder(
            url,
            type,
            trafficPolicy
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent List API call.
     */
    public class ListCallBuilder {
        private Optional<String> beforeId = Optional.empty();
        private Optional<String> limit = Optional.empty();
        private Optional<java.util.List<String>> id = Optional.empty();
        private Optional<java.util.List<String>> url = Optional.empty();
        private Optional<String> filter = Optional.empty();

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
         * Sets the <code>id</code> parameter.
         *
         * @param id the value of the id parameter as a {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder id(final java.util.List<String> id) {
            this.id = Optional.of(Objects.requireNonNull(id, "id is required"));
            return this;
        }

        /**
         * Sets (or unsets) the <code>id</code> parameter.
         *
         * @param id the value of the id parameter as an {@link Optional} of {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder id(final Optional<java.util.List<String>> id) {
            this.id = Objects.requireNonNull(id, "id is required");
            return this;
        }
        
        /**
         * Sets the <code>url</code> parameter.
         *
         * @param url the value of the url parameter as a {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder url(final java.util.List<String> url) {
            this.url = Optional.of(Objects.requireNonNull(url, "url is required"));
            return this;
        }

        /**
         * Sets (or unsets) the <code>url</code> parameter.
         *
         * @param url the value of the url parameter as an {@link Optional} of {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder url(final Optional<java.util.List<String>> url) {
            this.url = Objects.requireNonNull(url, "url is required");
            return this;
        }
        
        /**
         * Sets the <code>filter</code> parameter.
         *
         * @param filter the value of the filter parameter as a {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder filter(final String filter) {
            this.filter = Optional.of(Objects.requireNonNull(filter, "filter is required"));
            return this;
        }

        /**
         * Sets (or unsets) the <code>filter</code> parameter.
         *
         * @param filter the value of the filter parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder filter(final Optional<String> filter) {
            this.filter = Objects.requireNonNull(filter, "filter is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of a {@link Page} of {@link EndpointList}
         */
        public CompletionStage<Page<EndpointList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/endpoints",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("id", Optional.of(this.id).filter(id -> !id.isEmpty()).map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("url", Optional.of(this.url).filter(url -> !url.isEmpty()).map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("filter", this.filter.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(EndpointList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link EndpointList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<EndpointList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List all active endpoints on the account
     *
     * See also <a href="https://ngrok.com/docs/api#api-endpoints-list">https://ngrok.com/docs/api#api-endpoints-list</a>.
     *
     * @return a call builder for this API call
     */
    public ListCallBuilder list(
    ) {
        return new ListCallBuilder(
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
         * @return a {@link CompletionStage} of {@link Endpoint}
         */
        public CompletionStage<Endpoint> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/endpoints/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(Endpoint.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link Endpoint}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Endpoint blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get the status of an endpoint by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-endpoints-get">https://ngrok.com/docs/api#api-endpoints-get</a>.
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
     * A builder object encapsulating state for an unsent Update API call.
     */
    public class UpdateCallBuilder {
        private final String id;
        private Optional<String> url = Optional.empty();
        private Optional<String> trafficPolicy = Optional.empty();
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private Optional<java.util.List<String>> bindings = Optional.empty();
        private Optional<Boolean> poolingEnabled = Optional.empty();

        private UpdateCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * the url of the endpoint
         *
         * @param url the value of the url parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder url(final String url) {
            this.url = Optional.of(Objects.requireNonNull(url, "url is required"));
            return this;
        }

        /**
         * the url of the endpoint
         *
         * @param url the value of the url parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder url(final Optional<String> url) {
            this.url = Objects.requireNonNull(url, "url is required");
            return this;
        }
        
        /**
         * The traffic policy attached to this endpoint
         *
         * @param trafficPolicy the value of the traffic_policy parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder trafficPolicy(final String trafficPolicy) {
            this.trafficPolicy = Optional.of(Objects.requireNonNull(trafficPolicy, "trafficPolicy is required"));
            return this;
        }

        /**
         * The traffic policy attached to this endpoint
         *
         * @param trafficPolicy the value of the traffic_policy parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder trafficPolicy(final Optional<String> trafficPolicy) {
            this.trafficPolicy = Objects.requireNonNull(trafficPolicy, "trafficPolicy is required");
            return this;
        }
        
        /**
         * user-supplied description of the associated tunnel
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final String description) {
            this.description = Optional.of(Objects.requireNonNull(description, "description is required"));
            return this;
        }

        /**
         * user-supplied description of the associated tunnel
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * user-supplied metadata of the associated tunnel or edge object
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.of(Objects.requireNonNull(metadata, "metadata is required"));
            return this;
        }

        /**
         * user-supplied metadata of the associated tunnel or edge object
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * the bindings associated with this endpoint
         *
         * @param bindings the value of the bindings parameter as a {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder bindings(final java.util.List<String> bindings) {
            this.bindings = Optional.of(Objects.requireNonNull(bindings, "bindings is required"));
            return this;
        }

        /**
         * the bindings associated with this endpoint
         *
         * @param bindings the value of the bindings parameter as an {@link Optional} of {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder bindings(final Optional<java.util.List<String>> bindings) {
            this.bindings = Objects.requireNonNull(bindings, "bindings is required");
            return this;
        }
        
        /**
         * Sets the <code>pooling_enabled</code> parameter.
         *
         * @param poolingEnabled the value of the pooling_enabled parameter as a {@link boolean}
         * @return the call builder instance
         */
        public UpdateCallBuilder poolingEnabled(final boolean poolingEnabled) {
            this.poolingEnabled = Optional.of(Objects.requireNonNull(poolingEnabled, "poolingEnabled is required"));
            return this;
        }

        /**
         * Sets (or unsets) the <code>pooling_enabled</code> parameter.
         *
         * @param poolingEnabled the value of the pooling_enabled parameter as an {@link Optional} of {@link boolean}
         * @return the call builder instance
         */
        public UpdateCallBuilder poolingEnabled(final Optional<Boolean> poolingEnabled) {
            this.poolingEnabled = Objects.requireNonNull(poolingEnabled, "poolingEnabled is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link Endpoint}
         */
        public CompletionStage<Endpoint> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/endpoints/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("url", this.url.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("traffic_policy", this.trafficPolicy.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("bindings", Optional.of(this.bindings).filter(bindings -> !bindings.isEmpty()).map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("pooling_enabled", this.poolingEnabled.map(Function.identity()))
                ),
                Optional.of(Endpoint.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link Endpoint}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Endpoint blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update an Endpoint by ID, currently available only for cloud endpoints
     *
     * See also <a href="https://ngrok.com/docs/api#api-endpoints-update">https://ngrok.com/docs/api#api-endpoints-update</a>.
     *
     * @param id unique endpoint resource identifier
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
                "/endpoints/" + this.id,
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
     * Delete an Endpoint by ID, currently available only for cloud endpoints
     *
     * See also <a href="https://ngrok.com/docs/api#api-endpoints-delete">https://ngrok.com/docs/api#api-endpoints-delete</a>.
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
