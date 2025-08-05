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
 * Secrets is an api service for securely storing and managing sensitive data such
 * as secrets, credentials, and tokens.
 *
 * See also <a href="https://ngrok.com/docs/api#api-secrets">https://ngrok.com/docs/api#api-secrets</a>.
 */
public class Secrets {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for Secrets.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public Secrets(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class CreateCallBuilder {
        private Optional<String> name = Optional.empty();
        private Optional<String> value = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private Optional<String> description = Optional.empty();
        private final String vaultId;

        private CreateCallBuilder(
            final String vaultId
        ) {
            this.vaultId = Objects.requireNonNull(vaultId, "vaultId is required");
        }
        
        /**
         * Name of secret
         *
         * @param name the value of the name parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder name(final String name) {
            this.name = Optional.of(Objects.requireNonNull(name, "name is required"));
            return this;
        }

        /**
         * Name of secret
         *
         * @param name the value of the name parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder name(final Optional<String> name) {
            this.name = Objects.requireNonNull(name, "name is required");
            return this;
        }
        
        /**
         * Value of secret
         *
         * @param value the value of the value parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder value(final String value) {
            this.value = Optional.of(Objects.requireNonNull(value, "value is required"));
            return this;
        }

        /**
         * Value of secret
         *
         * @param value the value of the value parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder value(final Optional<String> value) {
            this.value = Objects.requireNonNull(value, "value is required");
            return this;
        }
        
        /**
         * Arbitrary user-defined metadata for this Secret
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.of(Objects.requireNonNull(metadata, "metadata is required"));
            return this;
        }

        /**
         * Arbitrary user-defined metadata for this Secret
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * description of Secret
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final String description) {
            this.description = Optional.of(Objects.requireNonNull(description, "description is required"));
            return this;
        }

        /**
         * description of Secret
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link Secret}
         */
        public CompletionStage<Secret> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/vault_secrets",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("name", this.name.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("value", this.value.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("vault_id", Optional.of(this.vaultId))
                ),
                Optional.of(Secret.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link Secret}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Secret blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create a new Secret
     *
     * See also <a href="https://ngrok.com/docs/api#api-secrets-create">https://ngrok.com/docs/api#api-secrets-create</a>.
     *
     * @param vaultId unique identifier of the referenced vault
     * @return a call builder for this API call
     */
    public CreateCallBuilder create(
        final String vaultId
    ) {
        return new CreateCallBuilder(
            vaultId
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Update API call.
     */
    public class UpdateCallBuilder {
        private final String id;
        private Optional<String> name = Optional.empty();
        private Optional<String> value = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private Optional<String> description = Optional.empty();

        private UpdateCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Name of secret
         *
         * @param name the value of the name parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder name(final String name) {
            this.name = Optional.of(Objects.requireNonNull(name, "name is required"));
            return this;
        }

        /**
         * Name of secret
         *
         * @param name the value of the name parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder name(final Optional<String> name) {
            this.name = Objects.requireNonNull(name, "name is required");
            return this;
        }
        
        /**
         * Value of secret
         *
         * @param value the value of the value parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder value(final String value) {
            this.value = Optional.of(Objects.requireNonNull(value, "value is required"));
            return this;
        }

        /**
         * Value of secret
         *
         * @param value the value of the value parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder value(final Optional<String> value) {
            this.value = Objects.requireNonNull(value, "value is required");
            return this;
        }
        
        /**
         * Arbitrary user-defined metadata for this Secret
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.of(Objects.requireNonNull(metadata, "metadata is required"));
            return this;
        }

        /**
         * Arbitrary user-defined metadata for this Secret
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * description of Secret
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final String description) {
            this.description = Optional.of(Objects.requireNonNull(description, "description is required"));
            return this;
        }

        /**
         * description of Secret
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link Secret}
         */
        public CompletionStage<Secret> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/vault_secrets/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("name", this.name.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("value", this.value.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity()))
                ),
                Optional.of(Secret.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link Secret}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Secret blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update an existing Secret by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-secrets-update">https://ngrok.com/docs/api#api-secrets-update</a>.
     *
     * @param id identifier for Secret
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
                "/vault_secrets/" + this.id,
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
     * Delete a Secret
     *
     * See also <a href="https://ngrok.com/docs/api#api-secrets-delete">https://ngrok.com/docs/api#api-secrets-delete</a>.
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
         * @return a {@link CompletionStage} of {@link Secret}
         */
        public CompletionStage<Secret> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/vault_secrets/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(Secret.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link Secret}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Secret blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get a Secret by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-secrets-get">https://ngrok.com/docs/api#api-secrets-get</a>.
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
         * @return a {@link CompletionStage} of a {@link Page} of {@link SecretList}
         */
        public CompletionStage<Page<SecretList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/vault_secrets",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(SecretList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link SecretList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<SecretList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List all Secrets owned by account
     *
     * See also <a href="https://ngrok.com/docs/api#api-secrets-list">https://ngrok.com/docs/api#api-secrets-list</a>.
     *
     * @return a call builder for this API call
     */
    public ListCallBuilder list(
    ) {
        return new ListCallBuilder(
        );
    }
}
