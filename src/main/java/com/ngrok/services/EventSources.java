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
 * An API client for {@link EventSources}.
 *
 * See also <a href="https://ngrok.com/docs/api#api-event-sources">https://ngrok.com/docs/api#api-event-sources</a>.
 */
public class EventSources {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for EventSources.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public EventSources(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class CreateCallBuilder {
        private final String subscriptionId;
        private String type = "";

        private CreateCallBuilder(
            final String subscriptionId
        ) {
            this.subscriptionId = Objects.requireNonNull(subscriptionId, "subscriptionId is required");
        }
        
        /**
         * Type of event for which an event subscription will trigger
         *
         * @param type the value of the type parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder type(final String type) {
            this.type = Objects.requireNonNull(type, "type is required");
            return this;
        }

        /**
         * Type of event for which an event subscription will trigger
         *
         * @param type the value of the type parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder type(final Optional<String> type) {
            this.type = Objects.requireNonNull(type, "type is required").orElse("");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EventSource}
         */
        public CompletionStage<EventSource> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/event_subscriptions/" + this.subscriptionId + "/sources",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("type", Optional.of(this.type))
                ),
                Optional.of(EventSource.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EventSource}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EventSource blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Add an additional type for which this event subscription will trigger
     *
     * See also <a href="https://ngrok.com/docs/api#api-event-sources-create">https://ngrok.com/docs/api#api-event-sources-create</a>.
     *
     * @param subscriptionId The unique identifier for the Event Subscription that this Event Source is attached to.
     * @return a call builder for this API call
     */
    public CreateCallBuilder create(
        final String subscriptionId
    ) {
        return new CreateCallBuilder(
            subscriptionId
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Delete API call.
     */
    public class DeleteCallBuilder {
        private final String subscriptionId;
        private final String type;

        private DeleteCallBuilder(
            final String subscriptionId,
            final String type
        ) {
            this.subscriptionId = Objects.requireNonNull(subscriptionId, "subscriptionId is required");
            this.type = Objects.requireNonNull(type, "type is required");
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link Void}
         */
        public CompletionStage<Void> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.DELETE,
                "/event_subscriptions/" + this.subscriptionId + "/sources/" + this.type,
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
     * Remove a type for which this event subscription will trigger
     *
     * See also <a href="https://ngrok.com/docs/api#api-event-sources-delete">https://ngrok.com/docs/api#api-event-sources-delete</a>.
     *
     * @param subscriptionId The unique identifier for the Event Subscription that this Event Source is attached to.
     * @param type Type of event for which an event subscription will trigger
     * @return a call builder for this API call
     */
    public DeleteCallBuilder delete(
        final String subscriptionId,
        final String type
    ) {
        return new DeleteCallBuilder(
            subscriptionId,
            type
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Get API call.
     */
    public class GetCallBuilder {
        private final String subscriptionId;
        private final String type;

        private GetCallBuilder(
            final String subscriptionId,
            final String type
        ) {
            this.subscriptionId = Objects.requireNonNull(subscriptionId, "subscriptionId is required");
            this.type = Objects.requireNonNull(type, "type is required");
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EventSource}
         */
        public CompletionStage<EventSource> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/event_subscriptions/" + this.subscriptionId + "/sources/" + this.type,
                Stream.empty(),
                Stream.empty(),
                Optional.of(EventSource.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EventSource}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EventSource blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get the details for a given type that triggers for the given event subscription
     *
     * See also <a href="https://ngrok.com/docs/api#api-event-sources-get">https://ngrok.com/docs/api#api-event-sources-get</a>.
     *
     * @param subscriptionId The unique identifier for the Event Subscription that this Event Source is attached to.
     * @param type Type of event for which an event subscription will trigger
     * @return a call builder for this API call
     */
    public GetCallBuilder get(
        final String subscriptionId,
        final String type
    ) {
        return new GetCallBuilder(
            subscriptionId,
            type
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent List API call.
     */
    public class ListCallBuilder {
        private final String subscriptionId;

        private ListCallBuilder(
            final String subscriptionId
        ) {
            this.subscriptionId = Objects.requireNonNull(subscriptionId, "subscriptionId is required");
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EventSourceList}
         */
        public CompletionStage<EventSourceList> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/event_subscriptions/" + this.subscriptionId + "/sources",
                Stream.empty(),
                Stream.empty(),
                Optional.of(EventSourceList.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EventSourceList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EventSourceList blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List the types for which this event subscription will trigger
     *
     * See also <a href="https://ngrok.com/docs/api#api-event-sources-list">https://ngrok.com/docs/api#api-event-sources-list</a>.
     *
     * @param subscriptionId The unique identifier for the Event Subscription that this Event Source is attached to.
     * @return a call builder for this API call
     */
    public ListCallBuilder list(
        final String subscriptionId
    ) {
        return new ListCallBuilder(
            subscriptionId
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Update API call.
     */
    public class UpdateCallBuilder {
        private final String subscriptionId;
        private final String type;

        private UpdateCallBuilder(
            final String subscriptionId,
            final String type
        ) {
            this.subscriptionId = Objects.requireNonNull(subscriptionId, "subscriptionId is required");
            this.type = Objects.requireNonNull(type, "type is required");
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EventSource}
         */
        public CompletionStage<EventSource> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/event_subscriptions/" + this.subscriptionId + "/sources/" + this.type,
                Stream.empty(),
                Stream.empty(),
                Optional.of(EventSource.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EventSource}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EventSource blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update the type for which this event subscription will trigger
     *
     * See also <a href="https://ngrok.com/docs/api#api-event-sources-update">https://ngrok.com/docs/api#api-event-sources-update</a>.
     *
     * @param subscriptionId The unique identifier for the Event Subscription that this Event Source is attached to.
     * @param type Type of event for which an event subscription will trigger
     * @return a call builder for this API call
     */
    public UpdateCallBuilder update(
        final String subscriptionId,
        final String type
    ) {
        return new UpdateCallBuilder(
            subscriptionId,
            type
        );
    }
}
