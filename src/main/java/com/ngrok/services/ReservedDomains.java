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
 * Reserved Domains are hostnames that you can listen for traffic on. Domains
 *  can be used to listen for http, https or tls traffic. You may use a domain
 *  that you own by creating a CNAME record specified in the returned resource.
 *  This CNAME record points traffic for that domain to ngrok&#39;s edge servers.
 *
 * See also <a href="https://ngrok.com/docs/api#api-reserved-domains">https://ngrok.com/docs/api#api-reserved-domains</a>.
 */
public class ReservedDomains {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for ReservedDomains.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public ReservedDomains(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class CreateCallBuilder {
        private Optional<String> domain = Optional.empty();
        private Optional<String> region = Optional.empty();
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private Optional<String> certificateId = Optional.empty();
        private Optional<ReservedDomainCertPolicy> certificateManagementPolicy = Optional.empty();

        private CreateCallBuilder(
        ) {
        }
        
        /**
         * hostname of the reserved domain
         *
         * @param domain the value of the domain parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder domain(final String domain) {
            this.domain = Optional.of(Objects.requireNonNull(domain, "domain is required"));
            return this;
        }

        /**
         * hostname of the reserved domain
         *
         * @param domain the value of the domain parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder domain(final Optional<String> domain) {
            this.domain = Objects.requireNonNull(domain, "domain is required");
            return this;
        }
        
        /**
         * deprecated: With the launch of the ngrok Global Network domains traffic is now
         * handled globally. This field applied only to endpoints. Note that agents may
         * still connect to specific regions. Optional, null by default. (au, eu, ap, us,
         * jp, in, sa)
         *
         * @param region the value of the region parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder region(final String region) {
            this.region = Optional.of(Objects.requireNonNull(region, "region is required"));
            return this;
        }

        /**
         * deprecated: With the launch of the ngrok Global Network domains traffic is now
         * handled globally. This field applied only to endpoints. Note that agents may
         * still connect to specific regions. Optional, null by default. (au, eu, ap, us,
         * jp, in, sa)
         *
         * @param region the value of the region parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder region(final Optional<String> region) {
            this.region = Objects.requireNonNull(region, "region is required");
            return this;
        }
        
        /**
         * human-readable description of what this reserved domain will be used for
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final String description) {
            this.description = Optional.of(Objects.requireNonNull(description, "description is required"));
            return this;
        }

        /**
         * human-readable description of what this reserved domain will be used for
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this reserved domain. Optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.of(Objects.requireNonNull(metadata, "metadata is required"));
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this reserved domain. Optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * ID of a user-uploaded TLS certificate to use for connections to targeting this
         * domain. Optional, mutually exclusive with
         * <code>certificate_management_policy</code>.
         *
         * @param certificateId the value of the certificate_id parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder certificateId(final String certificateId) {
            this.certificateId = Optional.of(Objects.requireNonNull(certificateId, "certificateId is required"));
            return this;
        }

        /**
         * ID of a user-uploaded TLS certificate to use for connections to targeting this
         * domain. Optional, mutually exclusive with
         * <code>certificate_management_policy</code>.
         *
         * @param certificateId the value of the certificate_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder certificateId(final Optional<String> certificateId) {
            this.certificateId = Objects.requireNonNull(certificateId, "certificateId is required");
            return this;
        }
        
        /**
         * configuration for automatic management of TLS certificates for this domain, or
         * null if automatic management is disabled. Optional, mutually exclusive with
         * <code>certificate_id</code>.
         *
         * @param certificateManagementPolicy the value of the certificate_management_policy parameter as a {@link ReservedDomainCertPolicy}
         * @return the call builder instance
         */
        public CreateCallBuilder certificateManagementPolicy(final ReservedDomainCertPolicy certificateManagementPolicy) {
            this.certificateManagementPolicy = Optional.of(Objects.requireNonNull(certificateManagementPolicy, "certificateManagementPolicy is required"));
            return this;
        }

        /**
         * configuration for automatic management of TLS certificates for this domain, or
         * null if automatic management is disabled. Optional, mutually exclusive with
         * <code>certificate_id</code>.
         *
         * @param certificateManagementPolicy the value of the certificate_management_policy parameter as an {@link Optional} of {@link ReservedDomainCertPolicy}
         * @return the call builder instance
         */
        public CreateCallBuilder certificateManagementPolicy(final Optional<ReservedDomainCertPolicy> certificateManagementPolicy) {
            this.certificateManagementPolicy = Objects.requireNonNull(certificateManagementPolicy, "certificateManagementPolicy is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link ReservedDomain}
         */
        public CompletionStage<ReservedDomain> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/reserved_domains",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("domain", this.domain.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("region", this.region.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("certificate_id", this.certificateId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("certificate_management_policy", this.certificateManagementPolicy.map(Function.identity()))
                ),
                Optional.of(ReservedDomain.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link ReservedDomain}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public ReservedDomain blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create a new reserved domain.
     *
     * See also <a href="https://ngrok.com/docs/api#api-reserved-domains-create">https://ngrok.com/docs/api#api-reserved-domains-create</a>.
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
                "/reserved_domains/" + this.id,
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
     * Delete a reserved domain.
     *
     * See also <a href="https://ngrok.com/docs/api#api-reserved-domains-delete">https://ngrok.com/docs/api#api-reserved-domains-delete</a>.
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
         * @return a {@link CompletionStage} of {@link ReservedDomain}
         */
        public CompletionStage<ReservedDomain> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/reserved_domains/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(ReservedDomain.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link ReservedDomain}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public ReservedDomain blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get the details of a reserved domain.
     *
     * See also <a href="https://ngrok.com/docs/api#api-reserved-domains-get">https://ngrok.com/docs/api#api-reserved-domains-get</a>.
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
         * @return a {@link CompletionStage} of a {@link Page} of {@link ReservedDomainList}
         */
        public CompletionStage<Page<ReservedDomainList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/reserved_domains",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(ReservedDomainList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link ReservedDomainList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<ReservedDomainList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List all reserved domains on this account.
     *
     * See also <a href="https://ngrok.com/docs/api#api-reserved-domains-list">https://ngrok.com/docs/api#api-reserved-domains-list</a>.
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
        private Optional<String> certificateId = Optional.empty();
        private Optional<ReservedDomainCertPolicy> certificateManagementPolicy = Optional.empty();

        private UpdateCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * human-readable description of what this reserved domain will be used for
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final String description) {
            this.description = Optional.of(Objects.requireNonNull(description, "description is required"));
            return this;
        }

        /**
         * human-readable description of what this reserved domain will be used for
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this reserved domain. Optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.of(Objects.requireNonNull(metadata, "metadata is required"));
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this reserved domain. Optional,
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
         * ID of a user-uploaded TLS certificate to use for connections to targeting this
         * domain. Optional, mutually exclusive with
         * <code>certificate_management_policy</code>.
         *
         * @param certificateId the value of the certificate_id parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder certificateId(final String certificateId) {
            this.certificateId = Optional.of(Objects.requireNonNull(certificateId, "certificateId is required"));
            return this;
        }

        /**
         * ID of a user-uploaded TLS certificate to use for connections to targeting this
         * domain. Optional, mutually exclusive with
         * <code>certificate_management_policy</code>.
         *
         * @param certificateId the value of the certificate_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder certificateId(final Optional<String> certificateId) {
            this.certificateId = Objects.requireNonNull(certificateId, "certificateId is required");
            return this;
        }
        
        /**
         * configuration for automatic management of TLS certificates for this domain, or
         * null if automatic management is disabled. Optional, mutually exclusive with
         * <code>certificate_id</code>.
         *
         * @param certificateManagementPolicy the value of the certificate_management_policy parameter as a {@link ReservedDomainCertPolicy}
         * @return the call builder instance
         */
        public UpdateCallBuilder certificateManagementPolicy(final ReservedDomainCertPolicy certificateManagementPolicy) {
            this.certificateManagementPolicy = Optional.of(Objects.requireNonNull(certificateManagementPolicy, "certificateManagementPolicy is required"));
            return this;
        }

        /**
         * configuration for automatic management of TLS certificates for this domain, or
         * null if automatic management is disabled. Optional, mutually exclusive with
         * <code>certificate_id</code>.
         *
         * @param certificateManagementPolicy the value of the certificate_management_policy parameter as an {@link Optional} of {@link ReservedDomainCertPolicy}
         * @return the call builder instance
         */
        public UpdateCallBuilder certificateManagementPolicy(final Optional<ReservedDomainCertPolicy> certificateManagementPolicy) {
            this.certificateManagementPolicy = Objects.requireNonNull(certificateManagementPolicy, "certificateManagementPolicy is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link ReservedDomain}
         */
        public CompletionStage<ReservedDomain> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/reserved_domains/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("certificate_id", this.certificateId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("certificate_management_policy", this.certificateManagementPolicy.map(Function.identity()))
                ),
                Optional.of(ReservedDomain.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link ReservedDomain}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public ReservedDomain blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update the attributes of a reserved domain.
     *
     * See also <a href="https://ngrok.com/docs/api#api-reserved-domains-update">https://ngrok.com/docs/api#api-reserved-domains-update</a>.
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
    
    /**
     * A builder object encapsulating state for an unsent DeleteCertificateManagementPolicy API call.
     */
    public class DeleteCertificateManagementPolicyCallBuilder {
        private final String id;

        private DeleteCertificateManagementPolicyCallBuilder(
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
                "/reserved_domains/" + this.id + "/certificate_management_policy",
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
     * Detach the certificate management policy attached to a reserved domain.
     *
     * See also <a href="https://ngrok.com/docs/api#api-reserved-domains-delete-certificate-management-policy">https://ngrok.com/docs/api#api-reserved-domains-delete-certificate-management-policy</a>.
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public DeleteCertificateManagementPolicyCallBuilder deleteCertificateManagementPolicy(
        final String id
    ) {
        return new DeleteCertificateManagementPolicyCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent DeleteCertificate API call.
     */
    public class DeleteCertificateCallBuilder {
        private final String id;

        private DeleteCertificateCallBuilder(
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
                "/reserved_domains/" + this.id + "/certificate",
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
     * Detach the certificate attached to a reserved domain.
     *
     * See also <a href="https://ngrok.com/docs/api#api-reserved-domains-delete-certificate">https://ngrok.com/docs/api#api-reserved-domains-delete-certificate</a>.
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public DeleteCertificateCallBuilder deleteCertificate(
        final String id
    ) {
        return new DeleteCertificateCallBuilder(
            id
        );
    }
}
