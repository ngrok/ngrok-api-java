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
 *  This CNAME record points traffic for that domain to ngrok's edge servers.
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
    public class ReservedDomainsCreateCallBuilder {
        private final String name;
        private String region = "";
        private String description = "";
        private String metadata = "";
        private Optional<String> httpEndpointConfigurationId = Optional.empty();
        private Optional<String> httpsEndpointConfigurationId = Optional.empty();
        private Optional<String> certificateId = Optional.empty();
        private Optional<ReservedDomainCertPolicy> certificateManagementPolicy = Optional.empty();

        private ReservedDomainsCreateCallBuilder(
            final String name
        ) {
            this.name = Objects.requireNonNull(name, "name is required");
        }
        
        /**
         * reserve the domain in this geographic ngrok datacenter. Optional, default is us.
         * (au, eu, ap, us, jp, in, sa)
         *
         * @param region the value of the region parameter as a {@link String}
         * @return the call builder instance
         */
        public ReservedDomainsCreateCallBuilder region(final String region) {
            this.region = Objects.requireNonNull(region, "region is required");
            return this;
        }

        /**
         * reserve the domain in this geographic ngrok datacenter. Optional, default is us.
         * (au, eu, ap, us, jp, in, sa)
         *
         * @param region the value of the region parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ReservedDomainsCreateCallBuilder region(final Optional<String> region) {
            this.region = Objects.requireNonNull(region, "region is required").orElse("");
            return this;
        }
        
        /**
         * human-readable description of what this reserved domain will be used for
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public ReservedDomainsCreateCallBuilder description(final String description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }

        /**
         * human-readable description of what this reserved domain will be used for
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ReservedDomainsCreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required").orElse("");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this reserved domain. Optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public ReservedDomainsCreateCallBuilder metadata(final String metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this reserved domain. Optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ReservedDomainsCreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required").orElse("");
            return this;
        }
        
        /**
         * ID of an endpoint configuration of type http that will be used to handle inbound
         * http traffic to this domain
         *
         * @param httpEndpointConfigurationId the value of the http_endpoint_configuration_id parameter as a {@link String}
         * @return the call builder instance
         */
        public ReservedDomainsCreateCallBuilder httpEndpointConfigurationId(final String httpEndpointConfigurationId) {
            this.httpEndpointConfigurationId = Optional.ofNullable(httpEndpointConfigurationId);
            return this;
        }

        /**
         * ID of an endpoint configuration of type http that will be used to handle inbound
         * http traffic to this domain
         *
         * @param httpEndpointConfigurationId the value of the http_endpoint_configuration_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ReservedDomainsCreateCallBuilder httpEndpointConfigurationId(final Optional<String> httpEndpointConfigurationId) {
            this.httpEndpointConfigurationId = Objects.requireNonNull(httpEndpointConfigurationId, "httpEndpointConfigurationId is required");
            return this;
        }
        
        /**
         * ID of an endpoint configuration of type https that will be used to handle
         * inbound https traffic to this domain
         *
         * @param httpsEndpointConfigurationId the value of the https_endpoint_configuration_id parameter as a {@link String}
         * @return the call builder instance
         */
        public ReservedDomainsCreateCallBuilder httpsEndpointConfigurationId(final String httpsEndpointConfigurationId) {
            this.httpsEndpointConfigurationId = Optional.ofNullable(httpsEndpointConfigurationId);
            return this;
        }

        /**
         * ID of an endpoint configuration of type https that will be used to handle
         * inbound https traffic to this domain
         *
         * @param httpsEndpointConfigurationId the value of the https_endpoint_configuration_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ReservedDomainsCreateCallBuilder httpsEndpointConfigurationId(final Optional<String> httpsEndpointConfigurationId) {
            this.httpsEndpointConfigurationId = Objects.requireNonNull(httpsEndpointConfigurationId, "httpsEndpointConfigurationId is required");
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
        public ReservedDomainsCreateCallBuilder certificateId(final String certificateId) {
            this.certificateId = Optional.ofNullable(certificateId);
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
        public ReservedDomainsCreateCallBuilder certificateId(final Optional<String> certificateId) {
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
        public ReservedDomainsCreateCallBuilder certificateManagementPolicy(final ReservedDomainCertPolicy certificateManagementPolicy) {
            this.certificateManagementPolicy = Optional.ofNullable(certificateManagementPolicy);
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
        public ReservedDomainsCreateCallBuilder certificateManagementPolicy(final Optional<ReservedDomainCertPolicy> certificateManagementPolicy) {
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
                    new AbstractMap.SimpleEntry<>("name", Optional.of(this.name)),
                    new AbstractMap.SimpleEntry<>("region", Optional.of(this.region)),
                    new AbstractMap.SimpleEntry<>("description", Optional.of(this.description)),
                    new AbstractMap.SimpleEntry<>("metadata", Optional.of(this.metadata)),
                    new AbstractMap.SimpleEntry<>("http_endpoint_configuration_id", this.httpEndpointConfigurationId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("https_endpoint_configuration_id", this.httpsEndpointConfigurationId.map(Function.identity())),
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
     * @param name the domain name to reserve. It may be a full domain name like app.example.com. If the name does not contain a '.' it will reserve that subdomain on ngrok.io.
     * @return a call builder for this API call
     */
    public ReservedDomainsCreateCallBuilder create(
        final String name
    ) {
        return new ReservedDomainsCreateCallBuilder(
            name
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Delete API call.
     */
    public class ReservedDomainsDeleteCallBuilder {
        private final String id;

        private ReservedDomainsDeleteCallBuilder(
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
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public ReservedDomainsDeleteCallBuilder delete(
        final String id
    ) {
        return new ReservedDomainsDeleteCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Get API call.
     */
    public class ReservedDomainsGetCallBuilder {
        private final String id;

        private ReservedDomainsGetCallBuilder(
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
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public ReservedDomainsGetCallBuilder get(
        final String id
    ) {
        return new ReservedDomainsGetCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent List API call.
     */
    public class ReservedDomainsListCallBuilder {
        private Optional<String> beforeId = Optional.empty();
        private Optional<String> limit = Optional.empty();

        private ReservedDomainsListCallBuilder(
        ) {
        }
        
        /**
         * Sets the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as a {@link String}
         * @return the call builder instance
         */
        public ReservedDomainsListCallBuilder beforeId(final String beforeId) {
            this.beforeId = Optional.ofNullable(beforeId);
            return this;
        }

        /**
         * Sets (or unsets) the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ReservedDomainsListCallBuilder beforeId(final Optional<String> beforeId) {
            this.beforeId = Objects.requireNonNull(beforeId, "beforeId is required");
            return this;
        }
        
        /**
         * Sets the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as a {@link String}
         * @return the call builder instance
         */
        public ReservedDomainsListCallBuilder limit(final String limit) {
            this.limit = Optional.ofNullable(limit);
            return this;
        }

        /**
         * Sets (or unsets) the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ReservedDomainsListCallBuilder limit(final Optional<String> limit) {
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
     * @return a call builder for this API call
     */
    public ReservedDomainsListCallBuilder list(
    ) {
        return new ReservedDomainsListCallBuilder(
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Update API call.
     */
    public class ReservedDomainsUpdateCallBuilder {
        private final String id;
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private Optional<String> httpEndpointConfigurationId = Optional.empty();
        private Optional<String> httpsEndpointConfigurationId = Optional.empty();
        private Optional<String> certificateId = Optional.empty();
        private Optional<ReservedDomainCertPolicy> certificateManagementPolicy = Optional.empty();

        private ReservedDomainsUpdateCallBuilder(
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
        public ReservedDomainsUpdateCallBuilder description(final String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        /**
         * human-readable description of what this reserved domain will be used for
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ReservedDomainsUpdateCallBuilder description(final Optional<String> description) {
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
        public ReservedDomainsUpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.ofNullable(metadata);
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this reserved domain. Optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ReservedDomainsUpdateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * ID of an endpoint configuration of type http that will be used to handle inbound
         * http traffic to this domain
         *
         * @param httpEndpointConfigurationId the value of the http_endpoint_configuration_id parameter as a {@link String}
         * @return the call builder instance
         */
        public ReservedDomainsUpdateCallBuilder httpEndpointConfigurationId(final String httpEndpointConfigurationId) {
            this.httpEndpointConfigurationId = Optional.ofNullable(httpEndpointConfigurationId);
            return this;
        }

        /**
         * ID of an endpoint configuration of type http that will be used to handle inbound
         * http traffic to this domain
         *
         * @param httpEndpointConfigurationId the value of the http_endpoint_configuration_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ReservedDomainsUpdateCallBuilder httpEndpointConfigurationId(final Optional<String> httpEndpointConfigurationId) {
            this.httpEndpointConfigurationId = Objects.requireNonNull(httpEndpointConfigurationId, "httpEndpointConfigurationId is required");
            return this;
        }
        
        /**
         * ID of an endpoint configuration of type https that will be used to handle
         * inbound https traffic to this domain
         *
         * @param httpsEndpointConfigurationId the value of the https_endpoint_configuration_id parameter as a {@link String}
         * @return the call builder instance
         */
        public ReservedDomainsUpdateCallBuilder httpsEndpointConfigurationId(final String httpsEndpointConfigurationId) {
            this.httpsEndpointConfigurationId = Optional.ofNullable(httpsEndpointConfigurationId);
            return this;
        }

        /**
         * ID of an endpoint configuration of type https that will be used to handle
         * inbound https traffic to this domain
         *
         * @param httpsEndpointConfigurationId the value of the https_endpoint_configuration_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ReservedDomainsUpdateCallBuilder httpsEndpointConfigurationId(final Optional<String> httpsEndpointConfigurationId) {
            this.httpsEndpointConfigurationId = Objects.requireNonNull(httpsEndpointConfigurationId, "httpsEndpointConfigurationId is required");
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
        public ReservedDomainsUpdateCallBuilder certificateId(final String certificateId) {
            this.certificateId = Optional.ofNullable(certificateId);
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
        public ReservedDomainsUpdateCallBuilder certificateId(final Optional<String> certificateId) {
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
        public ReservedDomainsUpdateCallBuilder certificateManagementPolicy(final ReservedDomainCertPolicy certificateManagementPolicy) {
            this.certificateManagementPolicy = Optional.ofNullable(certificateManagementPolicy);
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
        public ReservedDomainsUpdateCallBuilder certificateManagementPolicy(final Optional<ReservedDomainCertPolicy> certificateManagementPolicy) {
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
                    new AbstractMap.SimpleEntry<>("http_endpoint_configuration_id", this.httpEndpointConfigurationId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("https_endpoint_configuration_id", this.httpsEndpointConfigurationId.map(Function.identity())),
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
     * @param id the value of the <code>id</code> parameter as a {@link String}
     * @return a call builder for this API call
     */
    public ReservedDomainsUpdateCallBuilder update(
        final String id
    ) {
        return new ReservedDomainsUpdateCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent DeleteCertificateManagementPolicy API call.
     */
    public class ReservedDomainsDeleteCertificateManagementPolicyCallBuilder {
        private final String id;

        private ReservedDomainsDeleteCertificateManagementPolicyCallBuilder(
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
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public ReservedDomainsDeleteCertificateManagementPolicyCallBuilder deleteCertificateManagementPolicy(
        final String id
    ) {
        return new ReservedDomainsDeleteCertificateManagementPolicyCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent DeleteCertificate API call.
     */
    public class ReservedDomainsDeleteCertificateCallBuilder {
        private final String id;

        private ReservedDomainsDeleteCertificateCallBuilder(
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
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public ReservedDomainsDeleteCertificateCallBuilder deleteCertificate(
        final String id
    ) {
        return new ReservedDomainsDeleteCertificateCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent DeleteHttpEndpointConfig API call.
     */
    public class ReservedDomainsDeleteHttpEndpointConfigCallBuilder {
        private final String id;

        private ReservedDomainsDeleteHttpEndpointConfigCallBuilder(
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
                "/reserved_domains/" + this.id + "/http_endpoint_configuration",
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
     * Detach the http endpoint configuration attached to a reserved domain.
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public ReservedDomainsDeleteHttpEndpointConfigCallBuilder deleteHttpEndpointConfig(
        final String id
    ) {
        return new ReservedDomainsDeleteHttpEndpointConfigCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent DeleteHttpsEndpointConfig API call.
     */
    public class ReservedDomainsDeleteHttpsEndpointConfigCallBuilder {
        private final String id;

        private ReservedDomainsDeleteHttpsEndpointConfigCallBuilder(
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
                "/reserved_domains/" + this.id + "/https_endpoint_configuration",
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
     * Detach the https endpoint configuration attached to a reserved domain.
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public ReservedDomainsDeleteHttpsEndpointConfigCallBuilder deleteHttpsEndpointConfig(
        final String id
    ) {
        return new ReservedDomainsDeleteHttpsEndpointConfigCallBuilder(
            id
        );
    }
}
