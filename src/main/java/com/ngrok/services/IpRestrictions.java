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
 * An IP restriction is a restriction placed on the CIDRs that are allowed to
 *  initate traffic to a specific aspect of your ngrok account. An IP
 *  restriction has a type which defines the ingress it applies to. IP
 *  restrictions can be used to enforce the source IPs that can make API
 *  requests, log in to the dashboard, start ngrok agents, and connect to your
 *  public-facing endpoints.
 */
public class IpRestrictions {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for IpRestrictions.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public IpRestrictions(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class IpRestrictionsCreateCallBuilder {
        private String description = "";
        private String metadata = "";
        private boolean enforced = false;
        private final String type;
        private final java.util.List<String> ipPolicyIds;

        private IpRestrictionsCreateCallBuilder(
            final String type,
            final java.util.List<String> ipPolicyIds
        ) {
            this.type = Objects.requireNonNull(type, "type is required");
            this.ipPolicyIds = Objects.requireNonNull(ipPolicyIds, "ipPolicyIds is required");
        }
        
        /**
         * human-readable description of this IP restriction. optional, max 255 bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public IpRestrictionsCreateCallBuilder description(final String description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }

        /**
         * human-readable description of this IP restriction. optional, max 255 bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public IpRestrictionsCreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required").orElse("");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this IP restriction. optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public IpRestrictionsCreateCallBuilder metadata(final String metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this IP restriction. optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public IpRestrictionsCreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required").orElse("");
            return this;
        }
        
        /**
         * true if the IP restriction will be enforced. if false, only warnings will be
         * issued
         *
         * @param enforced the value of the enforced parameter as a {@link boolean}
         * @return the call builder instance
         */
        public IpRestrictionsCreateCallBuilder enforced(final boolean enforced) {
            this.enforced = Objects.requireNonNull(enforced, "enforced is required");
            return this;
        }

        /**
         * true if the IP restriction will be enforced. if false, only warnings will be
         * issued
         *
         * @param enforced the value of the enforced parameter as an {@link Optional} of {@link boolean}
         * @return the call builder instance
         */
        public IpRestrictionsCreateCallBuilder enforced(final Optional<Boolean> enforced) {
            this.enforced = Objects.requireNonNull(enforced, "enforced is required").orElse(false);
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link IpRestriction}
         */
        public CompletionStage<IpRestriction> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/ip_restrictions",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", Optional.of(this.description)),
                    new AbstractMap.SimpleEntry<>("metadata", Optional.of(this.metadata)),
                    new AbstractMap.SimpleEntry<>("enforced", Optional.of(this.enforced)),
                    new AbstractMap.SimpleEntry<>("type", Optional.of(this.type)),
                    new AbstractMap.SimpleEntry<>("ip_policy_ids", Optional.of(this.ipPolicyIds))
                ),
                Optional.of(IpRestriction.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link IpRestriction}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public IpRestriction blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create a new IP restriction
     *
     * @param type the type of IP restriction. this defines what traffic will be restricted with the attached policies. four values are currently supported: <code>dashboard</code>, <code>api</code>, <code>agent</code>, and <code>endpoints</code>
     * @param ipPolicyIds the set of IP policy identifiers that are used to enforce the restriction
     * @return a call builder for this API call
     */
    public IpRestrictionsCreateCallBuilder create(
        final String type,
        final java.util.List<String> ipPolicyIds
    ) {
        return new IpRestrictionsCreateCallBuilder(
            type,
            ipPolicyIds
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Delete API call.
     */
    public class IpRestrictionsDeleteCallBuilder {
        private final String id;

        private IpRestrictionsDeleteCallBuilder(
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
                "/ip_restrictions/" + this.id,
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
     * Delete an IP restriction
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public IpRestrictionsDeleteCallBuilder delete(
        final String id
    ) {
        return new IpRestrictionsDeleteCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Get API call.
     */
    public class IpRestrictionsGetCallBuilder {
        private final String id;

        private IpRestrictionsGetCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link IpRestriction}
         */
        public CompletionStage<IpRestriction> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/ip_restrictions/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(IpRestriction.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link IpRestriction}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public IpRestriction blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get detailed information about an IP restriction
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public IpRestrictionsGetCallBuilder get(
        final String id
    ) {
        return new IpRestrictionsGetCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent List API call.
     */
    public class IpRestrictionsListCallBuilder {
        private Optional<String> beforeId = Optional.empty();
        private Optional<String> limit = Optional.empty();

        private IpRestrictionsListCallBuilder(
        ) {
        }
        
        /**
         * Sets the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as a {@link String}
         * @return the call builder instance
         */
        public IpRestrictionsListCallBuilder beforeId(final String beforeId) {
            this.beforeId = Optional.ofNullable(beforeId);
            return this;
        }

        /**
         * Sets (or unsets) the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public IpRestrictionsListCallBuilder beforeId(final Optional<String> beforeId) {
            this.beforeId = Objects.requireNonNull(beforeId, "beforeId is required");
            return this;
        }
        
        /**
         * Sets the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as a {@link String}
         * @return the call builder instance
         */
        public IpRestrictionsListCallBuilder limit(final String limit) {
            this.limit = Optional.ofNullable(limit);
            return this;
        }

        /**
         * Sets (or unsets) the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public IpRestrictionsListCallBuilder limit(final Optional<String> limit) {
            this.limit = Objects.requireNonNull(limit, "limit is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of a {@link Page} of {@link IpRestrictionList}
         */
        public CompletionStage<Page<IpRestrictionList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/ip_restrictions",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(IpRestrictionList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link IpRestrictionList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<IpRestrictionList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List all IP restrictions on this account
     *
     * @return a call builder for this API call
     */
    public IpRestrictionsListCallBuilder list(
    ) {
        return new IpRestrictionsListCallBuilder(
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Update API call.
     */
    public class IpRestrictionsUpdateCallBuilder {
        private final String id;
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private Optional<Boolean> enforced = Optional.empty();
        private java.util.List<String> ipPolicyIds = null;

        private IpRestrictionsUpdateCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * human-readable description of this IP restriction. optional, max 255 bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public IpRestrictionsUpdateCallBuilder description(final String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        /**
         * human-readable description of this IP restriction. optional, max 255 bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public IpRestrictionsUpdateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this IP restriction. optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public IpRestrictionsUpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.ofNullable(metadata);
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this IP restriction. optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public IpRestrictionsUpdateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * true if the IP restriction will be enforced. if false, only warnings will be
         * issued
         *
         * @param enforced the value of the enforced parameter as a {@link boolean}
         * @return the call builder instance
         */
        public IpRestrictionsUpdateCallBuilder enforced(final boolean enforced) {
            this.enforced = Optional.ofNullable(enforced);
            return this;
        }

        /**
         * true if the IP restriction will be enforced. if false, only warnings will be
         * issued
         *
         * @param enforced the value of the enforced parameter as an {@link Optional} of {@link boolean}
         * @return the call builder instance
         */
        public IpRestrictionsUpdateCallBuilder enforced(final Optional<Boolean> enforced) {
            this.enforced = Objects.requireNonNull(enforced, "enforced is required");
            return this;
        }
        
        /**
         * the set of IP policy identifiers that are used to enforce the restriction
         *
         * @param ipPolicyIds the value of the ip_policy_ids parameter as a {@link java.util.List<String>}
         * @return the call builder instance
         */
        public IpRestrictionsUpdateCallBuilder ipPolicyIds(final java.util.List<String> ipPolicyIds) {
            this.ipPolicyIds = Objects.requireNonNull(ipPolicyIds, "ipPolicyIds is required");
            return this;
        }

        /**
         * the set of IP policy identifiers that are used to enforce the restriction
         *
         * @param ipPolicyIds the value of the ip_policy_ids parameter as an {@link Optional} of {@link java.util.List<String>}
         * @return the call builder instance
         */
        public IpRestrictionsUpdateCallBuilder ipPolicyIds(final Optional<java.util.List<String>> ipPolicyIds) {
            this.ipPolicyIds = Objects.requireNonNull(ipPolicyIds, "ipPolicyIds is required").orElse(null);
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link IpRestriction}
         */
        public CompletionStage<IpRestriction> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/ip_restrictions/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("enforced", this.enforced.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("ip_policy_ids", Optional.of(this.ipPolicyIds))
                ),
                Optional.of(IpRestriction.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link IpRestriction}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public IpRestriction blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update attributes of an IP restriction by ID
     *
     * @param id the value of the <code>id</code> parameter as a {@link String}
     * @return a call builder for this API call
     */
    public IpRestrictionsUpdateCallBuilder update(
        final String id
    ) {
        return new IpRestrictionsUpdateCallBuilder(
            id
        );
    }
}
