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
 * An API client for {@link TcpEdgeIpRestrictionModule}.
 *
 * See also <a href="https://ngrok.com/docs/api#api-tcp-edge-ip-restriction-module">https://ngrok.com/docs/api#api-tcp-edge-ip-restriction-module</a>.
 */
public class TcpEdgeIpRestrictionModule {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for TcpEdgeIpRestrictionModule.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public TcpEdgeIpRestrictionModule(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Replace API call.
     */
    public class ReplaceCallBuilder {
        private final String id;
        private Optional<EndpointIpPolicyMutate> module = Optional.empty();

        private ReplaceCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Sets the <code>module</code> parameter.
         *
         * @param module the value of the module parameter as a {@link EndpointIpPolicyMutate}
         * @return the call builder instance
         */
        public ReplaceCallBuilder module(final EndpointIpPolicyMutate module) {
            this.module = Optional.of(Objects.requireNonNull(module, "module is required"));
            return this;
        }

        /**
         * Sets (or unsets) the <code>module</code> parameter.
         *
         * @param module the value of the module parameter as an {@link Optional} of {@link EndpointIpPolicyMutate}
         * @return the call builder instance
         */
        public ReplaceCallBuilder module(final Optional<EndpointIpPolicyMutate> module) {
            this.module = Objects.requireNonNull(module, "module is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EndpointIpPolicy}
         */
        public CompletionStage<EndpointIpPolicy> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PUT,
                "/edges/tcp/" + this.id + "/ip_restriction",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("module", this.module.map(Function.identity()))
                ),
                Optional.of(EndpointIpPolicy.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EndpointIpPolicy}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EndpointIpPolicy blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Creates a call builder for the Replace API operation.
     *
     * See also <a href="https://ngrok.com/docs/api#api-tcp-edge-ip-restriction-module-replace">https://ngrok.com/docs/api#api-tcp-edge-ip-restriction-module-replace</a>.
     *
     * @param id the value of the <code>id</code> parameter as a {@link String}
     * @return a call builder for this API call
     */
    public ReplaceCallBuilder replace(
        final String id
    ) {
        return new ReplaceCallBuilder(
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
         * @return a {@link CompletionStage} of {@link EndpointIpPolicy}
         */
        public CompletionStage<EndpointIpPolicy> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/edges/tcp/" + this.id + "/ip_restriction",
                Stream.empty(),
                Stream.empty(),
                Optional.of(EndpointIpPolicy.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EndpointIpPolicy}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EndpointIpPolicy blockingCall() throws InterruptedException {
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
     * See also <a href="https://ngrok.com/docs/api#api-tcp-edge-ip-restriction-module-get">https://ngrok.com/docs/api#api-tcp-edge-ip-restriction-module-get</a>.
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
                "/edges/tcp/" + this.id + "/ip_restriction",
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
     * See also <a href="https://ngrok.com/docs/api#api-tcp-edge-ip-restriction-module-delete">https://ngrok.com/docs/api#api-tcp-edge-ip-restriction-module-delete</a>.
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
