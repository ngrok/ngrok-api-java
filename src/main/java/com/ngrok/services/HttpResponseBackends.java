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
 * An API client for {@link HttpResponseBackends}.
 *
 * See also <a href="https://ngrok.com/docs/api#api-http-response-backends">https://ngrok.com/docs/api#api-http-response-backends</a>.
 */
public class HttpResponseBackends {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for HttpResponseBackends.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public HttpResponseBackends(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class CreateCallBuilder {
        private String description = "";
        private String metadata = "";
        private String body = "";
        private java.util.Map<String, String> headers = java.util.Collections.emptyMap();
        private Optional<Integer> statusCode = Optional.empty();

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
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }

        /**
         * human-readable description of this backend. Optional
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required").orElse("");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this backend. Optional
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final String metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this backend. Optional
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required").orElse("");
            return this;
        }
        
        /**
         * body to return as fixed content
         *
         * @param body the value of the body parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder body(final String body) {
            this.body = Objects.requireNonNull(body, "body is required");
            return this;
        }

        /**
         * body to return as fixed content
         *
         * @param body the value of the body parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder body(final Optional<String> body) {
            this.body = Objects.requireNonNull(body, "body is required").orElse("");
            return this;
        }
        
        /**
         * headers to return
         *
         * @param headers the value of the headers parameter as a {@link java.util.Map<String, String>}
         * @return the call builder instance
         */
        public CreateCallBuilder headers(final java.util.Map<String, String> headers) {
            this.headers = Objects.requireNonNull(headers, "headers is required");
            return this;
        }

        /**
         * headers to return
         *
         * @param headers the value of the headers parameter as an {@link Optional} of {@link java.util.Map<String, String>}
         * @return the call builder instance
         */
        public CreateCallBuilder headers(final Optional<java.util.Map<String, String>> headers) {
            this.headers = Objects.requireNonNull(headers, "headers is required").orElse(java.util.Collections.emptyMap());
            return this;
        }
        
        /**
         * status code to return
         *
         * @param statusCode the value of the status_code parameter as a {@link int}
         * @return the call builder instance
         */
        public CreateCallBuilder statusCode(final int statusCode) {
            this.statusCode = Optional.ofNullable(statusCode);
            return this;
        }

        /**
         * status code to return
         *
         * @param statusCode the value of the status_code parameter as an {@link Optional} of {@link int}
         * @return the call builder instance
         */
        public CreateCallBuilder statusCode(final Optional<Integer> statusCode) {
            this.statusCode = Objects.requireNonNull(statusCode, "statusCode is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link HttpResponseBackend}
         */
        public CompletionStage<HttpResponseBackend> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/backends/http_response",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", Optional.of(this.description)),
                    new AbstractMap.SimpleEntry<>("metadata", Optional.of(this.metadata)),
                    new AbstractMap.SimpleEntry<>("body", Optional.of(this.body)),
                    new AbstractMap.SimpleEntry<>("headers", Optional.of(this.headers)),
                    new AbstractMap.SimpleEntry<>("status_code", this.statusCode.map(Function.identity()))
                ),
                Optional.of(HttpResponseBackend.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link HttpResponseBackend}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public HttpResponseBackend blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Creates a call builder for the Create API operation.
     *
     * See also <a href="https://ngrok.com/docs/api#api-http-response-backends-create">https://ngrok.com/docs/api#api-http-response-backends-create</a>.
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
                "/backends/http_response/" + this.id,
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
     * Creates a call builder for the Delete API operation.
     *
     * See also <a href="https://ngrok.com/docs/api#api-http-response-backends-delete">https://ngrok.com/docs/api#api-http-response-backends-delete</a>.
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
         * @return a {@link CompletionStage} of {@link HttpResponseBackend}
         */
        public CompletionStage<HttpResponseBackend> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/backends/http_response/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(HttpResponseBackend.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link HttpResponseBackend}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public HttpResponseBackend blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Creates a call builder for the Get API operation.
     *
     * See also <a href="https://ngrok.com/docs/api#api-http-response-backends-get">https://ngrok.com/docs/api#api-http-response-backends-get</a>.
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
         * @return a {@link CompletionStage} of a {@link Page} of {@link HttpResponseBackendList}
         */
        public CompletionStage<Page<HttpResponseBackendList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/backends/http_response",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(HttpResponseBackendList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link HttpResponseBackendList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<HttpResponseBackendList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Creates a call builder for the List API operation.
     *
     * See also <a href="https://ngrok.com/docs/api#api-http-response-backends-list">https://ngrok.com/docs/api#api-http-response-backends-list</a>.
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
        private Optional<String> body = Optional.empty();
        private Optional<java.util.Map<String, String>> headers = Optional.empty();
        private Optional<Integer> statusCode = Optional.empty();

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
            this.description = Optional.ofNullable(description);
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
            this.metadata = Optional.ofNullable(metadata);
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
         * body to return as fixed content
         *
         * @param body the value of the body parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder body(final String body) {
            this.body = Optional.ofNullable(body);
            return this;
        }

        /**
         * body to return as fixed content
         *
         * @param body the value of the body parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder body(final Optional<String> body) {
            this.body = Objects.requireNonNull(body, "body is required");
            return this;
        }
        
        /**
         * headers to return
         *
         * @param headers the value of the headers parameter as a {@link java.util.Map<String, String>}
         * @return the call builder instance
         */
        public UpdateCallBuilder headers(final java.util.Map<String, String> headers) {
            this.headers = Optional.ofNullable(headers);
            return this;
        }

        /**
         * headers to return
         *
         * @param headers the value of the headers parameter as an {@link Optional} of {@link java.util.Map<String, String>}
         * @return the call builder instance
         */
        public UpdateCallBuilder headers(final Optional<java.util.Map<String, String>> headers) {
            this.headers = Objects.requireNonNull(headers, "headers is required");
            return this;
        }
        
        /**
         * status code to return
         *
         * @param statusCode the value of the status_code parameter as a {@link int}
         * @return the call builder instance
         */
        public UpdateCallBuilder statusCode(final int statusCode) {
            this.statusCode = Optional.ofNullable(statusCode);
            return this;
        }

        /**
         * status code to return
         *
         * @param statusCode the value of the status_code parameter as an {@link Optional} of {@link int}
         * @return the call builder instance
         */
        public UpdateCallBuilder statusCode(final Optional<Integer> statusCode) {
            this.statusCode = Objects.requireNonNull(statusCode, "statusCode is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link HttpResponseBackend}
         */
        public CompletionStage<HttpResponseBackend> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/backends/http_response/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("body", this.body.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("headers", this.headers.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("status_code", this.statusCode.map(Function.identity()))
                ),
                Optional.of(HttpResponseBackend.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link HttpResponseBackend}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public HttpResponseBackend blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Creates a call builder for the Update API operation.
     *
     * See also <a href="https://ngrok.com/docs/api#api-http-response-backends-update">https://ngrok.com/docs/api#api-http-response-backends-update</a>.
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
