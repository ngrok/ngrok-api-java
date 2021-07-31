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
 * An API client for {@link EndpointRequestHeadersModule}.
 */
public class EndpointRequestHeadersModule {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for EndpointRequestHeadersModule.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public EndpointRequestHeadersModule(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Replace API call.
     */
    public class EndpointRequestHeadersModuleReplaceCallBuilder {
        private final String id;
        private EndpointRequestHeaders module = null;

        private EndpointRequestHeadersModuleReplaceCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Sets the <code>module</code> parameter.
         *
         * @param module the value of the module parameter as a {@link EndpointRequestHeaders}
         * @return the call builder instance
         */
        public EndpointRequestHeadersModuleReplaceCallBuilder module(final EndpointRequestHeaders module) {
            this.module = Objects.requireNonNull(module, "module is required");
            return this;
        }

        /**
         * Sets (or unsets) the <code>module</code> parameter.
         *
         * @param module the value of the module parameter as an {@link Optional} of {@link EndpointRequestHeaders}
         * @return the call builder instance
         */
        public EndpointRequestHeadersModuleReplaceCallBuilder module(final Optional<EndpointRequestHeaders> module) {
            this.module = Objects.requireNonNull(module, "module is required").orElse(null);
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EndpointRequestHeaders}
         */
        public CompletionStage<EndpointRequestHeaders> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PUT,
                "/endpoint_configurations/" + this.id + "/request_headers",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("module", Optional.of(this.module))
                ),
                Optional.of(EndpointRequestHeaders.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EndpointRequestHeaders}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EndpointRequestHeaders blockingCall() throws InterruptedException {
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
     * @param id the value of the <code>id</code> parameter as a {@link String}
     * @return a call builder for this API call
     */
    public EndpointRequestHeadersModuleReplaceCallBuilder replace(
        final String id
    ) {
        return new EndpointRequestHeadersModuleReplaceCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Get API call.
     */
    public class EndpointRequestHeadersModuleGetCallBuilder {
        private final String id;

        private EndpointRequestHeadersModuleGetCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EndpointRequestHeaders}
         */
        public CompletionStage<EndpointRequestHeaders> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/endpoint_configurations/" + this.id + "/request_headers",
                Stream.empty(),
                Stream.empty(),
                Optional.of(EndpointRequestHeaders.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EndpointRequestHeaders}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EndpointRequestHeaders blockingCall() throws InterruptedException {
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
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public EndpointRequestHeadersModuleGetCallBuilder get(
        final String id
    ) {
        return new EndpointRequestHeadersModuleGetCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Delete API call.
     */
    public class EndpointRequestHeadersModuleDeleteCallBuilder {
        private final String id;

        private EndpointRequestHeadersModuleDeleteCallBuilder(
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
                "/endpoint_configurations/" + this.id + "/request_headers",
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
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public EndpointRequestHeadersModuleDeleteCallBuilder delete(
        final String id
    ) {
        return new EndpointRequestHeadersModuleDeleteCallBuilder(
            id
        );
    }
}
