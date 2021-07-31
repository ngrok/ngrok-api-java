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
 * An API client for {@link EndpointCircuitBreakerModule}.
 */
public class EndpointCircuitBreakerModule {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for EndpointCircuitBreakerModule.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public EndpointCircuitBreakerModule(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Replace API call.
     */
    public class EndpointCircuitBreakerModuleReplaceCallBuilder {
        private final String id;
        private EndpointCircuitBreaker module = null;

        private EndpointCircuitBreakerModuleReplaceCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Sets the <code>module</code> parameter.
         *
         * @param module the value of the module parameter as a {@link EndpointCircuitBreaker}
         * @return the call builder instance
         */
        public EndpointCircuitBreakerModuleReplaceCallBuilder module(final EndpointCircuitBreaker module) {
            this.module = Objects.requireNonNull(module, "module is required");
            return this;
        }

        /**
         * Sets (or unsets) the <code>module</code> parameter.
         *
         * @param module the value of the module parameter as an {@link Optional} of {@link EndpointCircuitBreaker}
         * @return the call builder instance
         */
        public EndpointCircuitBreakerModuleReplaceCallBuilder module(final Optional<EndpointCircuitBreaker> module) {
            this.module = Objects.requireNonNull(module, "module is required").orElse(null);
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EndpointCircuitBreaker}
         */
        public CompletionStage<EndpointCircuitBreaker> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PUT,
                "/endpoint_configurations/" + this.id + "/circuit_breaker",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("module", Optional.of(this.module))
                ),
                Optional.of(EndpointCircuitBreaker.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EndpointCircuitBreaker}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EndpointCircuitBreaker blockingCall() throws InterruptedException {
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
    public EndpointCircuitBreakerModuleReplaceCallBuilder replace(
        final String id
    ) {
        return new EndpointCircuitBreakerModuleReplaceCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Get API call.
     */
    public class EndpointCircuitBreakerModuleGetCallBuilder {
        private final String id;

        private EndpointCircuitBreakerModuleGetCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EndpointCircuitBreaker}
         */
        public CompletionStage<EndpointCircuitBreaker> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/endpoint_configurations/" + this.id + "/circuit_breaker",
                Stream.empty(),
                Stream.empty(),
                Optional.of(EndpointCircuitBreaker.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EndpointCircuitBreaker}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EndpointCircuitBreaker blockingCall() throws InterruptedException {
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
    public EndpointCircuitBreakerModuleGetCallBuilder get(
        final String id
    ) {
        return new EndpointCircuitBreakerModuleGetCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Delete API call.
     */
    public class EndpointCircuitBreakerModuleDeleteCallBuilder {
        private final String id;

        private EndpointCircuitBreakerModuleDeleteCallBuilder(
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
                "/endpoint_configurations/" + this.id + "/circuit_breaker",
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
    public EndpointCircuitBreakerModuleDeleteCallBuilder delete(
        final String id
    ) {
        return new EndpointCircuitBreakerModuleDeleteCallBuilder(
            id
        );
    }
}
