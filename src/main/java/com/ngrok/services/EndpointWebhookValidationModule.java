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
 * An API client for {@link EndpointWebhookValidationModule}.
 */
public class EndpointWebhookValidationModule {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for EndpointWebhookValidationModule.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public EndpointWebhookValidationModule(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Replace API call.
     */
    public class EndpointWebhookValidationModuleReplaceCallBuilder {
        private final String id;
        private EndpointWebhookValidation module = null;

        private EndpointWebhookValidationModuleReplaceCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Sets the <code>module</code> parameter.
         *
         * @param module the value of the module parameter as a {@link EndpointWebhookValidation}
         * @return the call builder instance
         */
        public EndpointWebhookValidationModuleReplaceCallBuilder module(final EndpointWebhookValidation module) {
            this.module = Objects.requireNonNull(module, "module is required");
            return this;
        }

        /**
         * Sets (or unsets) the <code>module</code> parameter.
         *
         * @param module the value of the module parameter as an {@link Optional} of {@link EndpointWebhookValidation}
         * @return the call builder instance
         */
        public EndpointWebhookValidationModuleReplaceCallBuilder module(final Optional<EndpointWebhookValidation> module) {
            this.module = Objects.requireNonNull(module, "module is required").orElse(null);
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EndpointWebhookValidation}
         */
        public CompletionStage<EndpointWebhookValidation> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PUT,
                "/endpoint_configurations/" + this.id + "/webhook_validation",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("module", Optional.of(this.module))
                ),
                Optional.of(EndpointWebhookValidation.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EndpointWebhookValidation}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EndpointWebhookValidation blockingCall() throws InterruptedException {
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
    public EndpointWebhookValidationModuleReplaceCallBuilder replace(
        final String id
    ) {
        return new EndpointWebhookValidationModuleReplaceCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Get API call.
     */
    public class EndpointWebhookValidationModuleGetCallBuilder {
        private final String id;

        private EndpointWebhookValidationModuleGetCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EndpointWebhookValidation}
         */
        public CompletionStage<EndpointWebhookValidation> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/endpoint_configurations/" + this.id + "/webhook_validation",
                Stream.empty(),
                Stream.empty(),
                Optional.of(EndpointWebhookValidation.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EndpointWebhookValidation}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EndpointWebhookValidation blockingCall() throws InterruptedException {
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
    public EndpointWebhookValidationModuleGetCallBuilder get(
        final String id
    ) {
        return new EndpointWebhookValidationModuleGetCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Delete API call.
     */
    public class EndpointWebhookValidationModuleDeleteCallBuilder {
        private final String id;

        private EndpointWebhookValidationModuleDeleteCallBuilder(
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
                "/endpoint_configurations/" + this.id + "/webhook_validation",
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
    public EndpointWebhookValidationModuleDeleteCallBuilder delete(
        final String id
    ) {
        return new EndpointWebhookValidationModuleDeleteCallBuilder(
            id
        );
    }
}
