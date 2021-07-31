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
 * An API client for {@link EndpointCompressionModule}.
 */
public class EndpointCompressionModule {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for EndpointCompressionModule.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public EndpointCompressionModule(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Replace API call.
     */
    public class EndpointCompressionModuleReplaceCallBuilder {
        private final String id;
        private EndpointCompression module = null;

        private EndpointCompressionModuleReplaceCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Sets the <code>module</code> parameter.
         *
         * @param module the value of the module parameter as a {@link EndpointCompression}
         * @return the call builder instance
         */
        public EndpointCompressionModuleReplaceCallBuilder module(final EndpointCompression module) {
            this.module = Objects.requireNonNull(module, "module is required");
            return this;
        }

        /**
         * Sets (or unsets) the <code>module</code> parameter.
         *
         * @param module the value of the module parameter as an {@link Optional} of {@link EndpointCompression}
         * @return the call builder instance
         */
        public EndpointCompressionModuleReplaceCallBuilder module(final Optional<EndpointCompression> module) {
            this.module = Objects.requireNonNull(module, "module is required").orElse(null);
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EndpointCompression}
         */
        public CompletionStage<EndpointCompression> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PUT,
                "/endpoint_configurations/" + this.id + "/compression",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("module", Optional.of(this.module))
                ),
                Optional.of(EndpointCompression.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EndpointCompression}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EndpointCompression blockingCall() throws InterruptedException {
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
    public EndpointCompressionModuleReplaceCallBuilder replace(
        final String id
    ) {
        return new EndpointCompressionModuleReplaceCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Get API call.
     */
    public class EndpointCompressionModuleGetCallBuilder {
        private final String id;

        private EndpointCompressionModuleGetCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EndpointCompression}
         */
        public CompletionStage<EndpointCompression> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/endpoint_configurations/" + this.id + "/compression",
                Stream.empty(),
                Stream.empty(),
                Optional.of(EndpointCompression.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EndpointCompression}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EndpointCompression blockingCall() throws InterruptedException {
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
    public EndpointCompressionModuleGetCallBuilder get(
        final String id
    ) {
        return new EndpointCompressionModuleGetCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Delete API call.
     */
    public class EndpointCompressionModuleDeleteCallBuilder {
        private final String id;

        private EndpointCompressionModuleDeleteCallBuilder(
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
                "/endpoint_configurations/" + this.id + "/compression",
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
    public EndpointCompressionModuleDeleteCallBuilder delete(
        final String id
    ) {
        return new EndpointCompressionModuleDeleteCallBuilder(
            id
        );
    }
}
