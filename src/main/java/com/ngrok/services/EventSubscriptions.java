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
 * An API client for {@link EventSubscriptions}.
 */
public class EventSubscriptions {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for EventSubscriptions.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public EventSubscriptions(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class EventSubscriptionsCreateCallBuilder {
        private String metadata = "";
        private String description = "";
        private java.util.List<EventSourceReplace> sources = null;
        private java.util.List<String> destinationIds = null;

        private EventSubscriptionsCreateCallBuilder(
        ) {
        }
        
        /**
         * Arbitrary customer supplied information intended to be machine readable.
         * Optional, max 4096 chars.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public EventSubscriptionsCreateCallBuilder metadata(final String metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }

        /**
         * Arbitrary customer supplied information intended to be machine readable.
         * Optional, max 4096 chars.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public EventSubscriptionsCreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required").orElse("");
            return this;
        }
        
        /**
         * Arbitrary customer supplied information intended to be human readable. Optional,
         * max 255 chars.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public EventSubscriptionsCreateCallBuilder description(final String description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }

        /**
         * Arbitrary customer supplied information intended to be human readable. Optional,
         * max 255 chars.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public EventSubscriptionsCreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required").orElse("");
            return this;
        }
        
        /**
         * Sources containing the types for which this event subscription will trigger
         *
         * @param sources the value of the sources parameter as a {@link java.util.List<EventSourceReplace>}
         * @return the call builder instance
         */
        public EventSubscriptionsCreateCallBuilder sources(final java.util.List<EventSourceReplace> sources) {
            this.sources = Objects.requireNonNull(sources, "sources is required");
            return this;
        }

        /**
         * Sources containing the types for which this event subscription will trigger
         *
         * @param sources the value of the sources parameter as an {@link Optional} of {@link java.util.List<EventSourceReplace>}
         * @return the call builder instance
         */
        public EventSubscriptionsCreateCallBuilder sources(final Optional<java.util.List<EventSourceReplace>> sources) {
            this.sources = Objects.requireNonNull(sources, "sources is required").orElse(null);
            return this;
        }
        
        /**
         * A list of Event Destination IDs which should be used for this Event Stream.
         * Event Streams are required to have at least one Event Destination.
         *
         * @param destinationIds the value of the destination_ids parameter as a {@link java.util.List<String>}
         * @return the call builder instance
         */
        public EventSubscriptionsCreateCallBuilder destinationIds(final java.util.List<String> destinationIds) {
            this.destinationIds = Objects.requireNonNull(destinationIds, "destinationIds is required");
            return this;
        }

        /**
         * A list of Event Destination IDs which should be used for this Event Stream.
         * Event Streams are required to have at least one Event Destination.
         *
         * @param destinationIds the value of the destination_ids parameter as an {@link Optional} of {@link java.util.List<String>}
         * @return the call builder instance
         */
        public EventSubscriptionsCreateCallBuilder destinationIds(final Optional<java.util.List<String>> destinationIds) {
            this.destinationIds = Objects.requireNonNull(destinationIds, "destinationIds is required").orElse(null);
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EventSubscription}
         */
        public CompletionStage<EventSubscription> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/event_subscriptions",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("metadata", Optional.of(this.metadata)),
                    new AbstractMap.SimpleEntry<>("description", Optional.of(this.description)),
                    new AbstractMap.SimpleEntry<>("sources", Optional.of(this.sources)),
                    new AbstractMap.SimpleEntry<>("destination_ids", Optional.of(this.destinationIds))
                ),
                Optional.of(EventSubscription.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EventSubscription}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EventSubscription blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create an Event Subscription.
     *
     * @return a call builder for this API call
     */
    public EventSubscriptionsCreateCallBuilder create(
    ) {
        return new EventSubscriptionsCreateCallBuilder(
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Delete API call.
     */
    public class EventSubscriptionsDeleteCallBuilder {
        private final String id;

        private EventSubscriptionsDeleteCallBuilder(
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
                "/event_subscriptions/" + this.id,
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
     * Delete an Event Subscription.
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public EventSubscriptionsDeleteCallBuilder delete(
        final String id
    ) {
        return new EventSubscriptionsDeleteCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Get API call.
     */
    public class EventSubscriptionsGetCallBuilder {
        private final String id;

        private EventSubscriptionsGetCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EventSubscription}
         */
        public CompletionStage<EventSubscription> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/event_subscriptions/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(EventSubscription.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EventSubscription}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EventSubscription blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get an Event Subscription by ID.
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public EventSubscriptionsGetCallBuilder get(
        final String id
    ) {
        return new EventSubscriptionsGetCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent List API call.
     */
    public class EventSubscriptionsListCallBuilder {
        private Optional<String> beforeId = Optional.empty();
        private Optional<String> limit = Optional.empty();

        private EventSubscriptionsListCallBuilder(
        ) {
        }
        
        /**
         * Sets the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as a {@link String}
         * @return the call builder instance
         */
        public EventSubscriptionsListCallBuilder beforeId(final String beforeId) {
            this.beforeId = Optional.ofNullable(beforeId);
            return this;
        }

        /**
         * Sets (or unsets) the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public EventSubscriptionsListCallBuilder beforeId(final Optional<String> beforeId) {
            this.beforeId = Objects.requireNonNull(beforeId, "beforeId is required");
            return this;
        }
        
        /**
         * Sets the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as a {@link String}
         * @return the call builder instance
         */
        public EventSubscriptionsListCallBuilder limit(final String limit) {
            this.limit = Optional.ofNullable(limit);
            return this;
        }

        /**
         * Sets (or unsets) the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public EventSubscriptionsListCallBuilder limit(final Optional<String> limit) {
            this.limit = Objects.requireNonNull(limit, "limit is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of a {@link Page} of {@link EventSubscriptionList}
         */
        public CompletionStage<Page<EventSubscriptionList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/event_subscriptions",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(EventSubscriptionList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link EventSubscriptionList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<EventSubscriptionList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List this Account's Event Subscriptions.
     *
     * @return a call builder for this API call
     */
    public EventSubscriptionsListCallBuilder list(
    ) {
        return new EventSubscriptionsListCallBuilder(
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Update API call.
     */
    public class EventSubscriptionsUpdateCallBuilder {
        private final String id;
        private Optional<String> metadata = Optional.empty();
        private Optional<String> description = Optional.empty();
        private Optional<java.util.List<EventSourceReplace>> sources = Optional.empty();
        private Optional<java.util.List<String>> destinationIds = Optional.empty();

        private EventSubscriptionsUpdateCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Arbitrary customer supplied information intended to be machine readable.
         * Optional, max 4096 chars.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public EventSubscriptionsUpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.ofNullable(metadata);
            return this;
        }

        /**
         * Arbitrary customer supplied information intended to be machine readable.
         * Optional, max 4096 chars.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public EventSubscriptionsUpdateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * Arbitrary customer supplied information intended to be human readable. Optional,
         * max 255 chars.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public EventSubscriptionsUpdateCallBuilder description(final String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        /**
         * Arbitrary customer supplied information intended to be human readable. Optional,
         * max 255 chars.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public EventSubscriptionsUpdateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * Sources containing the types for which this event subscription will trigger
         *
         * @param sources the value of the sources parameter as a {@link java.util.List<EventSourceReplace>}
         * @return the call builder instance
         */
        public EventSubscriptionsUpdateCallBuilder sources(final java.util.List<EventSourceReplace> sources) {
            this.sources = Optional.ofNullable(sources);
            return this;
        }

        /**
         * Sources containing the types for which this event subscription will trigger
         *
         * @param sources the value of the sources parameter as an {@link Optional} of {@link java.util.List<EventSourceReplace>}
         * @return the call builder instance
         */
        public EventSubscriptionsUpdateCallBuilder sources(final Optional<java.util.List<EventSourceReplace>> sources) {
            this.sources = Objects.requireNonNull(sources, "sources is required");
            return this;
        }
        
        /**
         * A list of Event Destination IDs which should be used for this Event Stream.
         * Event Streams are required to have at least one Event Destination.
         *
         * @param destinationIds the value of the destination_ids parameter as a {@link java.util.List<String>}
         * @return the call builder instance
         */
        public EventSubscriptionsUpdateCallBuilder destinationIds(final java.util.List<String> destinationIds) {
            this.destinationIds = Optional.ofNullable(destinationIds);
            return this;
        }

        /**
         * A list of Event Destination IDs which should be used for this Event Stream.
         * Event Streams are required to have at least one Event Destination.
         *
         * @param destinationIds the value of the destination_ids parameter as an {@link Optional} of {@link java.util.List<String>}
         * @return the call builder instance
         */
        public EventSubscriptionsUpdateCallBuilder destinationIds(final Optional<java.util.List<String>> destinationIds) {
            this.destinationIds = Objects.requireNonNull(destinationIds, "destinationIds is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EventSubscription}
         */
        public CompletionStage<EventSubscription> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/event_subscriptions/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("sources", this.sources.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("destination_ids", this.destinationIds.map(Function.identity()))
                ),
                Optional.of(EventSubscription.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EventSubscription}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EventSubscription blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update an Event Subscription.
     *
     * @param id Unique identifier for this Event Subscription.
     * @return a call builder for this API call
     */
    public EventSubscriptionsUpdateCallBuilder update(
        final String id
    ) {
        return new EventSubscriptionsUpdateCallBuilder(
            id
        );
    }
}
