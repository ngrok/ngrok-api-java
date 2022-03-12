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
 * An API client for {@link EdgeRouteWebhookVerificationModule}.
 *
 * See also <a href="https://ngrok.com/docs/api#api-edge-route-webhook-verification-module">https://ngrok.com/docs/api#api-edge-route-webhook-verification-module</a>.
 */
public class EdgeRouteWebhookVerificationModule {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for EdgeRouteWebhookVerificationModule.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public EdgeRouteWebhookVerificationModule(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Replace API call.
     */
    public class ReplaceCallBuilder {
        private final String edgeId;
        private final String id;
        private EndpointWebhookValidation module = null;

        private ReplaceCallBuilder(
            final String edgeId,
            final String id
        ) {
            this.edgeId = Objects.requireNonNull(edgeId, "edgeId is required");
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Sets the <code>module</code> parameter.
         *
         * @param module the value of the module parameter as a {@link EndpointWebhookValidation}
         * @return the call builder instance
         */
        public ReplaceCallBuilder module(final EndpointWebhookValidation module) {
            this.module = Objects.requireNonNull(module, "module is required");
            return this;
        }

        /**
         * Sets (or unsets) the <code>module</code> parameter.
         *
         * @param module the value of the module parameter as an {@link Optional} of {@link EndpointWebhookValidation}
         * @return the call builder instance
         */
        public ReplaceCallBuilder module(final Optional<EndpointWebhookValidation> module) {
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
                "/edges/https/" + this.edgeId + "/routes/" + this.id + "/webhook_verification",
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
     * See also <a href="https://ngrok.com/docs/api#api-edge-route-webhook-verification-module-replace">https://ngrok.com/docs/api#api-edge-route-webhook-verification-module-replace</a>.
     *
     * @param edgeId the value of the <code>edge_id</code> parameter as a {@link String}
     * @param id the value of the <code>id</code> parameter as a {@link String}
     * @return a call builder for this API call
     */
    public ReplaceCallBuilder replace(
        final String edgeId,
        final String id
    ) {
        return new ReplaceCallBuilder(
            edgeId,
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Get API call.
     */
    public class GetCallBuilder {
        private final String edgeId;
        private final String id;

        private GetCallBuilder(
            final String edgeId,
            final String id
        ) {
            this.edgeId = Objects.requireNonNull(edgeId, "edgeId is required");
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
                "/edges/https/" + this.edgeId + "/routes/" + this.id + "/webhook_verification",
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
     * See also <a href="https://ngrok.com/docs/api#api-edge-route-webhook-verification-module-get">https://ngrok.com/docs/api#api-edge-route-webhook-verification-module-get</a>.
     *
     * @param edgeId unique identifier of this edge
     * @param id unique identifier of this edge route
     * @return a call builder for this API call
     */
    public GetCallBuilder get(
        final String edgeId,
        final String id
    ) {
        return new GetCallBuilder(
            edgeId,
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Delete API call.
     */
    public class DeleteCallBuilder {
        private final String edgeId;
        private final String id;

        private DeleteCallBuilder(
            final String edgeId,
            final String id
        ) {
            this.edgeId = Objects.requireNonNull(edgeId, "edgeId is required");
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
                "/edges/https/" + this.edgeId + "/routes/" + this.id + "/webhook_verification",
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
     * See also <a href="https://ngrok.com/docs/api#api-edge-route-webhook-verification-module-delete">https://ngrok.com/docs/api#api-edge-route-webhook-verification-module-delete</a>.
     *
     * @param edgeId unique identifier of this edge
     * @param id unique identifier of this edge route
     * @return a call builder for this API call
     */
    public DeleteCallBuilder delete(
        final String edgeId,
        final String id
    ) {
        return new DeleteCallBuilder(
            edgeId,
            id
        );
    }
}
