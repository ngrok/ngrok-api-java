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
 * Reserved Addresses are TCP addresses that can be used to listen for traffic.
 *  TCP address hostnames and ports are assigned by ngrok, they cannot be
 *  chosen.
 */
public class ReservedAddrs {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for ReservedAddrs.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public ReservedAddrs(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class ReservedAddrsCreateCallBuilder {
        private String description = "";
        private String metadata = "";
        private String region = "";
        private String endpointConfigurationId = "";

        private ReservedAddrsCreateCallBuilder(
        ) {
        }
        
        /**
         * human-readable description of what this reserved address will be used for
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public ReservedAddrsCreateCallBuilder description(final String description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }

        /**
         * human-readable description of what this reserved address will be used for
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ReservedAddrsCreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required").orElse("");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this reserved address. Optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public ReservedAddrsCreateCallBuilder metadata(final String metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this reserved address. Optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ReservedAddrsCreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required").orElse("");
            return this;
        }
        
        /**
         * reserve the address in this geographic ngrok datacenter. Optional, default is
         * us. (au, eu, ap, us, jp, in, sa)
         *
         * @param region the value of the region parameter as a {@link String}
         * @return the call builder instance
         */
        public ReservedAddrsCreateCallBuilder region(final String region) {
            this.region = Objects.requireNonNull(region, "region is required");
            return this;
        }

        /**
         * reserve the address in this geographic ngrok datacenter. Optional, default is
         * us. (au, eu, ap, us, jp, in, sa)
         *
         * @param region the value of the region parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ReservedAddrsCreateCallBuilder region(final Optional<String> region) {
            this.region = Objects.requireNonNull(region, "region is required").orElse("");
            return this;
        }
        
        /**
         * ID of an endpoint configuration of type tcp that will be used to handle inbound
         * traffic to this address
         *
         * @param endpointConfigurationId the value of the endpoint_configuration_id parameter as a {@link String}
         * @return the call builder instance
         */
        public ReservedAddrsCreateCallBuilder endpointConfigurationId(final String endpointConfigurationId) {
            this.endpointConfigurationId = Objects.requireNonNull(endpointConfigurationId, "endpointConfigurationId is required");
            return this;
        }

        /**
         * ID of an endpoint configuration of type tcp that will be used to handle inbound
         * traffic to this address
         *
         * @param endpointConfigurationId the value of the endpoint_configuration_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ReservedAddrsCreateCallBuilder endpointConfigurationId(final Optional<String> endpointConfigurationId) {
            this.endpointConfigurationId = Objects.requireNonNull(endpointConfigurationId, "endpointConfigurationId is required").orElse("");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link ReservedAddr}
         */
        public CompletionStage<ReservedAddr> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/reserved_addrs",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", Optional.of(this.description)),
                    new AbstractMap.SimpleEntry<>("metadata", Optional.of(this.metadata)),
                    new AbstractMap.SimpleEntry<>("region", Optional.of(this.region)),
                    new AbstractMap.SimpleEntry<>("endpoint_configuration_id", Optional.of(this.endpointConfigurationId))
                ),
                Optional.of(ReservedAddr.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link ReservedAddr}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public ReservedAddr blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create a new reserved address.
     *
     * @return a call builder for this API call
     */
    public ReservedAddrsCreateCallBuilder create(
    ) {
        return new ReservedAddrsCreateCallBuilder(
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Delete API call.
     */
    public class ReservedAddrsDeleteCallBuilder {
        private final String id;

        private ReservedAddrsDeleteCallBuilder(
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
                "/reserved_addrs/" + this.id,
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
     * Delete a reserved address.
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public ReservedAddrsDeleteCallBuilder delete(
        final String id
    ) {
        return new ReservedAddrsDeleteCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Get API call.
     */
    public class ReservedAddrsGetCallBuilder {
        private final String id;

        private ReservedAddrsGetCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link ReservedAddr}
         */
        public CompletionStage<ReservedAddr> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/reserved_addrs/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(ReservedAddr.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link ReservedAddr}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public ReservedAddr blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get the details of a reserved address.
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public ReservedAddrsGetCallBuilder get(
        final String id
    ) {
        return new ReservedAddrsGetCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent List API call.
     */
    public class ReservedAddrsListCallBuilder {
        private Optional<String> beforeId = Optional.empty();
        private Optional<String> limit = Optional.empty();

        private ReservedAddrsListCallBuilder(
        ) {
        }
        
        /**
         * Sets the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as a {@link String}
         * @return the call builder instance
         */
        public ReservedAddrsListCallBuilder beforeId(final String beforeId) {
            this.beforeId = Optional.ofNullable(beforeId);
            return this;
        }

        /**
         * Sets (or unsets) the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ReservedAddrsListCallBuilder beforeId(final Optional<String> beforeId) {
            this.beforeId = Objects.requireNonNull(beforeId, "beforeId is required");
            return this;
        }
        
        /**
         * Sets the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as a {@link String}
         * @return the call builder instance
         */
        public ReservedAddrsListCallBuilder limit(final String limit) {
            this.limit = Optional.ofNullable(limit);
            return this;
        }

        /**
         * Sets (or unsets) the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ReservedAddrsListCallBuilder limit(final Optional<String> limit) {
            this.limit = Objects.requireNonNull(limit, "limit is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of a {@link Page} of {@link ReservedAddrList}
         */
        public CompletionStage<Page<ReservedAddrList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/reserved_addrs",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(ReservedAddrList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link ReservedAddrList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<ReservedAddrList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List all reserved addresses on this account.
     *
     * @return a call builder for this API call
     */
    public ReservedAddrsListCallBuilder list(
    ) {
        return new ReservedAddrsListCallBuilder(
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Update API call.
     */
    public class ReservedAddrsUpdateCallBuilder {
        private final String id;
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private Optional<String> endpointConfigurationId = Optional.empty();

        private ReservedAddrsUpdateCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * human-readable description of what this reserved address will be used for
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public ReservedAddrsUpdateCallBuilder description(final String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        /**
         * human-readable description of what this reserved address will be used for
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ReservedAddrsUpdateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this reserved address. Optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public ReservedAddrsUpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.ofNullable(metadata);
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this reserved address. Optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ReservedAddrsUpdateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * ID of an endpoint configuration of type tcp that will be used to handle inbound
         * traffic to this address
         *
         * @param endpointConfigurationId the value of the endpoint_configuration_id parameter as a {@link String}
         * @return the call builder instance
         */
        public ReservedAddrsUpdateCallBuilder endpointConfigurationId(final String endpointConfigurationId) {
            this.endpointConfigurationId = Optional.ofNullable(endpointConfigurationId);
            return this;
        }

        /**
         * ID of an endpoint configuration of type tcp that will be used to handle inbound
         * traffic to this address
         *
         * @param endpointConfigurationId the value of the endpoint_configuration_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ReservedAddrsUpdateCallBuilder endpointConfigurationId(final Optional<String> endpointConfigurationId) {
            this.endpointConfigurationId = Objects.requireNonNull(endpointConfigurationId, "endpointConfigurationId is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link ReservedAddr}
         */
        public CompletionStage<ReservedAddr> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/reserved_addrs/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("endpoint_configuration_id", this.endpointConfigurationId.map(Function.identity()))
                ),
                Optional.of(ReservedAddr.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link ReservedAddr}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public ReservedAddr blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update the attributes of a reserved address.
     *
     * @param id the value of the <code>id</code> parameter as a {@link String}
     * @return a call builder for this API call
     */
    public ReservedAddrsUpdateCallBuilder update(
        final String id
    ) {
        return new ReservedAddrsUpdateCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent DeleteEndpointConfig API call.
     */
    public class ReservedAddrsDeleteEndpointConfigCallBuilder {
        private final String id;

        private ReservedAddrsDeleteEndpointConfigCallBuilder(
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
                "/reserved_addrs/" + this.id + "/endpoint_configuration",
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
     * Detach the endpoint configuration attached to a reserved address.
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public ReservedAddrsDeleteEndpointConfigCallBuilder deleteEndpointConfig(
        final String id
    ) {
        return new ReservedAddrsDeleteEndpointConfigCallBuilder(
            id
        );
    }
}
