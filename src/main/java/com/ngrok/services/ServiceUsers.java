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
 * An API client for {@link ServiceUsers}.
 *
 * See also <a href="https://ngrok.com/docs/api#api-service-users">https://ngrok.com/docs/api#api-service-users</a>.
 */
public class ServiceUsers {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for ServiceUsers.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public ServiceUsers(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class CreateCallBuilder {
        private Optional<String> name = Optional.empty();
        private Optional<Boolean> active = Optional.empty();

        private CreateCallBuilder(
        ) {
        }
        
        /**
         * human-readable name used to identify the service
         *
         * @param name the value of the name parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder name(final String name) {
            this.name = Optional.of(Objects.requireNonNull(name, "name is required"));
            return this;
        }

        /**
         * human-readable name used to identify the service
         *
         * @param name the value of the name parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder name(final Optional<String> name) {
            this.name = Objects.requireNonNull(name, "name is required");
            return this;
        }
        
        /**
         * whether or not the service is active
         *
         * @param active the value of the active parameter as a {@link boolean}
         * @return the call builder instance
         */
        public CreateCallBuilder active(final boolean active) {
            this.active = Optional.of(Objects.requireNonNull(active, "active is required"));
            return this;
        }

        /**
         * whether or not the service is active
         *
         * @param active the value of the active parameter as an {@link Optional} of {@link boolean}
         * @return the call builder instance
         */
        public CreateCallBuilder active(final Optional<Boolean> active) {
            this.active = Objects.requireNonNull(active, "active is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link ServiceUser}
         */
        public CompletionStage<ServiceUser> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/service_users",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("name", this.name.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("active", this.active.map(Function.identity()))
                ),
                Optional.of(ServiceUser.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link ServiceUser}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public ServiceUser blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create a new service user
     *
     * See also <a href="https://ngrok.com/docs/api#api-service-users-create">https://ngrok.com/docs/api#api-service-users-create</a>.
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
                "/service_users/" + this.id,
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
     * Delete a service user by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-service-users-delete">https://ngrok.com/docs/api#api-service-users-delete</a>.
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
         * @return a {@link CompletionStage} of {@link ServiceUser}
         */
        public CompletionStage<ServiceUser> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/service_users/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(ServiceUser.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link ServiceUser}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public ServiceUser blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get the details of a Bot User by ID.
     *
     * See also <a href="https://ngrok.com/docs/api#api-service-users-get">https://ngrok.com/docs/api#api-service-users-get</a>.
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
         * @return a {@link CompletionStage} of a {@link Page} of {@link ServiceUserList}
         */
        public CompletionStage<Page<ServiceUserList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/service_users",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("filter", this.filter.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(ServiceUserList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link ServiceUserList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<ServiceUserList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List all service users in this account.
     *
     * See also <a href="https://ngrok.com/docs/api#api-service-users-list">https://ngrok.com/docs/api#api-service-users-list</a>.
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
        private Optional<String> name = Optional.empty();
        private Optional<Boolean> active = Optional.empty();

        private UpdateCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * human-readable name used to identify the service
         *
         * @param name the value of the name parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder name(final String name) {
            this.name = Optional.of(Objects.requireNonNull(name, "name is required"));
            return this;
        }

        /**
         * human-readable name used to identify the service
         *
         * @param name the value of the name parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder name(final Optional<String> name) {
            this.name = Objects.requireNonNull(name, "name is required");
            return this;
        }
        
        /**
         * whether or not the service is active
         *
         * @param active the value of the active parameter as a {@link boolean}
         * @return the call builder instance
         */
        public UpdateCallBuilder active(final boolean active) {
            this.active = Optional.of(Objects.requireNonNull(active, "active is required"));
            return this;
        }

        /**
         * whether or not the service is active
         *
         * @param active the value of the active parameter as an {@link Optional} of {@link boolean}
         * @return the call builder instance
         */
        public UpdateCallBuilder active(final Optional<Boolean> active) {
            this.active = Objects.requireNonNull(active, "active is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link ServiceUser}
         */
        public CompletionStage<ServiceUser> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/service_users/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("name", this.name.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("active", this.active.map(Function.identity()))
                ),
                Optional.of(ServiceUser.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link ServiceUser}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public ServiceUser blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update attributes of a service user by ID.
     *
     * See also <a href="https://ngrok.com/docs/api#api-service-users-update">https://ngrok.com/docs/api#api-service-users-update</a>.
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
