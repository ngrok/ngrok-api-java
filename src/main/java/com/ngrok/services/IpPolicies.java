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
 * IP Policies are reusable groups of CIDR ranges with an <code>allow</code> or
 * <code>deny</code>
 *  action. They can be attached to endpoints via the Endpoint Configuration IP
 *  Policy module. They can also be used with IP Restrictions to control source
 *  IP ranges that can start tunnel sessions and connect to the API and dashboard.
 *
 * See also <a href="https://ngrok.com/docs/api#api-ip-policies">https://ngrok.com/docs/api#api-ip-policies</a>.
 */
public class IpPolicies {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for IpPolicies.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public IpPolicies(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class CreateCallBuilder {
        private String description = "";
        private String metadata = "";
        private final String action;

        private CreateCallBuilder(
            final String action
        ) {
            this.action = Objects.requireNonNull(action, "action is required");
        }
        
        /**
         * human-readable description of the source IPs of this IP policy. optional, max
         * 255 bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final String description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }

        /**
         * human-readable description of the source IPs of this IP policy. optional, max
         * 255 bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required").orElse("");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this IP policy. optional, max
         * 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final String metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this IP policy. optional, max
         * 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required").orElse("");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link IpPolicy}
         */
        public CompletionStage<IpPolicy> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/ip_policies",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", Optional.of(this.description)),
                    new AbstractMap.SimpleEntry<>("metadata", Optional.of(this.metadata)),
                    new AbstractMap.SimpleEntry<>("action", Optional.of(this.action))
                ),
                Optional.of(IpPolicy.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link IpPolicy}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public IpPolicy blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create a new IP policy. It will not apply to any traffic until you associate to
     * a traffic source via an endpoint configuration or IP restriction.
     *
     * See also <a href="https://ngrok.com/docs/api#api-ip-policies-create">https://ngrok.com/docs/api#api-ip-policies-create</a>.
     *
     * @param action the IP policy action. Supported values are <code>allow</code> or <code>deny</code>
     * @return a call builder for this API call
     */
    public CreateCallBuilder create(
        final String action
    ) {
        return new CreateCallBuilder(
            action
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
                "/ip_policies/" + this.id,
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
     * Delete an IP policy. If the IP policy is referenced by another object for the
     * purposes of traffic restriction it will be treated as if the IP policy remains
     * but has zero rules.
     *
     * See also <a href="https://ngrok.com/docs/api#api-ip-policies-delete">https://ngrok.com/docs/api#api-ip-policies-delete</a>.
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
         * @return a {@link CompletionStage} of {@link IpPolicy}
         */
        public CompletionStage<IpPolicy> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/ip_policies/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(IpPolicy.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link IpPolicy}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public IpPolicy blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get detailed information about an IP policy by ID.
     *
     * See also <a href="https://ngrok.com/docs/api#api-ip-policies-get">https://ngrok.com/docs/api#api-ip-policies-get</a>.
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
         * @return a {@link CompletionStage} of a {@link Page} of {@link IpPolicyList}
         */
        public CompletionStage<Page<IpPolicyList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/ip_policies",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(IpPolicyList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link IpPolicyList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<IpPolicyList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List all IP policies on this account
     *
     * See also <a href="https://ngrok.com/docs/api#api-ip-policies-list">https://ngrok.com/docs/api#api-ip-policies-list</a>.
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

        private UpdateCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * human-readable description of the source IPs of this IP policy. optional, max
         * 255 bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        /**
         * human-readable description of the source IPs of this IP policy. optional, max
         * 255 bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this IP policy. optional, max
         * 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.ofNullable(metadata);
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this IP policy. optional, max
         * 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link IpPolicy}
         */
        public CompletionStage<IpPolicy> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/ip_policies/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity()))
                ),
                Optional.of(IpPolicy.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link IpPolicy}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public IpPolicy blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update attributes of an IP policy by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-ip-policies-update">https://ngrok.com/docs/api#api-ip-policies-update</a>.
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
