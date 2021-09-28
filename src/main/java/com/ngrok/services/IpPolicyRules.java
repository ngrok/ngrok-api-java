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
 * IP Policy Rules are the IPv4 or IPv6 CIDRs entries that
 *  make up an IP Policy.
 *
 * See also <a href="https://ngrok.com/docs/api#api-ip-policy-rules">https://ngrok.com/docs/api#api-ip-policy-rules</a>.
 */
public class IpPolicyRules {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for IpPolicyRules.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public IpPolicyRules(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class CreateCallBuilder {
        private String description = "";
        private String metadata = "";
        private final String cidr;
        private final String ipPolicyId;

        private CreateCallBuilder(
            final String cidr,
            final String ipPolicyId
        ) {
            this.cidr = Objects.requireNonNull(cidr, "cidr is required");
            this.ipPolicyId = Objects.requireNonNull(ipPolicyId, "ipPolicyId is required");
        }
        
        /**
         * human-readable description of the source IPs of this IP rule. optional, max 255
         * bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final String description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }

        /**
         * human-readable description of the source IPs of this IP rule. optional, max 255
         * bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required").orElse("");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this IP policy rule. optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final String metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this IP policy rule. optional,
         * max 4096 bytes.
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
         * @return a {@link CompletionStage} of {@link IpPolicyRule}
         */
        public CompletionStage<IpPolicyRule> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/ip_policy_rules",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", Optional.of(this.description)),
                    new AbstractMap.SimpleEntry<>("metadata", Optional.of(this.metadata)),
                    new AbstractMap.SimpleEntry<>("cidr", Optional.of(this.cidr)),
                    new AbstractMap.SimpleEntry<>("ip_policy_id", Optional.of(this.ipPolicyId))
                ),
                Optional.of(IpPolicyRule.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link IpPolicyRule}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public IpPolicyRule blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create a new IP policy rule attached to an IP Policy.
     *
     * See also <a href="https://ngrok.com/docs/api#api-ip-policy-rules-create">https://ngrok.com/docs/api#api-ip-policy-rules-create</a>.
     *
     * @param cidr an IP or IP range specified in CIDR notation. IPv4 and IPv6 are both supported.
     * @param ipPolicyId ID of the IP policy this IP policy rule will be attached to
     * @return a call builder for this API call
     */
    public CreateCallBuilder create(
        final String cidr,
        final String ipPolicyId
    ) {
        return new CreateCallBuilder(
            cidr,
            ipPolicyId
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
                "/ip_policy_rules/" + this.id,
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
     * Delete an IP policy rule.
     *
     * See also <a href="https://ngrok.com/docs/api#api-ip-policy-rules-delete">https://ngrok.com/docs/api#api-ip-policy-rules-delete</a>.
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
         * @return a {@link CompletionStage} of {@link IpPolicyRule}
         */
        public CompletionStage<IpPolicyRule> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/ip_policy_rules/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(IpPolicyRule.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link IpPolicyRule}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public IpPolicyRule blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get detailed information about an IP policy rule by ID.
     *
     * See also <a href="https://ngrok.com/docs/api#api-ip-policy-rules-get">https://ngrok.com/docs/api#api-ip-policy-rules-get</a>.
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
         * @return a {@link CompletionStage} of a {@link Page} of {@link IpPolicyRuleList}
         */
        public CompletionStage<Page<IpPolicyRuleList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/ip_policy_rules",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(IpPolicyRuleList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link IpPolicyRuleList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<IpPolicyRuleList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List all IP policy rules on this account
     *
     * See also <a href="https://ngrok.com/docs/api#api-ip-policy-rules-list">https://ngrok.com/docs/api#api-ip-policy-rules-list</a>.
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
        private Optional<String> cidr = Optional.empty();

        private UpdateCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * human-readable description of the source IPs of this IP rule. optional, max 255
         * bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        /**
         * human-readable description of the source IPs of this IP rule. optional, max 255
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
         * arbitrary user-defined machine-readable data of this IP policy rule. optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.ofNullable(metadata);
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this IP policy rule. optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * an IP or IP range specified in CIDR notation. IPv4 and IPv6 are both supported.
         *
         * @param cidr the value of the cidr parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder cidr(final String cidr) {
            this.cidr = Optional.ofNullable(cidr);
            return this;
        }

        /**
         * an IP or IP range specified in CIDR notation. IPv4 and IPv6 are both supported.
         *
         * @param cidr the value of the cidr parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder cidr(final Optional<String> cidr) {
            this.cidr = Objects.requireNonNull(cidr, "cidr is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link IpPolicyRule}
         */
        public CompletionStage<IpPolicyRule> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/ip_policy_rules/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("cidr", this.cidr.map(Function.identity()))
                ),
                Optional.of(IpPolicyRule.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link IpPolicyRule}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public IpPolicyRule blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update attributes of an IP policy rule by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-ip-policy-rules-update">https://ngrok.com/docs/api#api-ip-policy-rules-update</a>.
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
