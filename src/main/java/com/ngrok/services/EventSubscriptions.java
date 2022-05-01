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
 *
 * See also <a href="https://ngrok.com/docs/api#api-event-subscriptions">https://ngrok.com/docs/api#api-event-subscriptions</a>.
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
    public class CreateCallBuilder {
        private Optional<String> metadata = Optional.empty();
        private Optional<String> description = Optional.empty();
        private java.util.List<EventSourceReplace> sources = java.util.Collections.emptyList();
        private java.util.List<String> destinationIds = java.util.Collections.emptyList();

        private CreateCallBuilder(
        ) {
        }
        
        /**
         * Arbitrary customer supplied information intended to be machine readable.
         * Optional, max 4096 chars.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.of(Objects.requireNonNull(metadata, "metadata is required"));
            return this;
        }

        /**
         * Arbitrary customer supplied information intended to be machine readable.
         * Optional, max 4096 chars.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final Optional<String> metadata) {
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
        public CreateCallBuilder description(final String description) {
            this.description = Optional.of(Objects.requireNonNull(description, "description is required"));
            return this;
        }

        /**
         * Arbitrary customer supplied information intended to be human readable. Optional,
         * max 255 chars.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * Sources containing the types for which this event subscription will trigger
         *
         * @param sources the value of the sources parameter as a {@link java.util.List} of {@link EventSourceReplace}
         * @return the call builder instance
         */
        public CreateCallBuilder sources(final java.util.List<EventSourceReplace> sources) {
            this.sources = Objects.requireNonNull(sources, "sources is required");
            return this;
        }

        /**
         * Sources containing the types for which this event subscription will trigger
         *
         * @param sources the value of the sources parameter as an {@link Optional} of {@link java.util.List} of {@link EventSourceReplace}
         * @return the call builder instance
         */
        public CreateCallBuilder sources(final Optional<java.util.List<EventSourceReplace>> sources) {
            this.sources = Objects.requireNonNull(sources, "sources is required").orElse(java.util.Collections.emptyList());
            return this;
        }
        
        /**
         * A list of Event Destination IDs which should be used for this Event
         * Subscription.
         *
         * @param destinationIds the value of the destination_ids parameter as a {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder destinationIds(final java.util.List<String> destinationIds) {
            this.destinationIds = Objects.requireNonNull(destinationIds, "destinationIds is required");
            return this;
        }

        /**
         * A list of Event Destination IDs which should be used for this Event
         * Subscription.
         *
         * @param destinationIds the value of the destination_ids parameter as an {@link Optional} of {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder destinationIds(final Optional<java.util.List<String>> destinationIds) {
            this.destinationIds = Objects.requireNonNull(destinationIds, "destinationIds is required").orElse(java.util.Collections.emptyList());
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
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("sources", Optional.of(this.sources).filter(sources -> !sources.isEmpty()).map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("destination_ids", Optional.of(this.destinationIds).filter(destinationIds -> !destinationIds.isEmpty()).map(Function.identity()))
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
     * See also <a href="https://ngrok.com/docs/api#api-event-subscriptions-create">https://ngrok.com/docs/api#api-event-subscriptions-create</a>.
     *
     * @return a call builder for this API call
     */
    public CreateCallBuilder create(
    ) {
        return new CreateCallBuilder(
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
     * See also <a href="https://ngrok.com/docs/api#api-event-subscriptions-delete">https://ngrok.com/docs/api#api-event-subscriptions-delete</a>.
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
     * See also <a href="https://ngrok.com/docs/api#api-event-subscriptions-get">https://ngrok.com/docs/api#api-event-subscriptions-get</a>.
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
     * A builder object encapsulating state for an unsent List API call.
     */
    public class ListCallBuilder {
        private Optional<String> beforeId = Optional.empty();
        private Optional<String> limit = Optional.empty();

        private ListCallBuilder(
        ) {
        }
        
        /**
         * Sets the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as a {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder beforeId(final String beforeId) {
            this.beforeId = Optional.of(Objects.requireNonNull(beforeId, "beforeId is required"));
            return this;
        }

        /**
         * Sets (or unsets) the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder beforeId(final Optional<String> beforeId) {
            this.beforeId = Objects.requireNonNull(beforeId, "beforeId is required");
            return this;
        }
        
        /**
         * Sets the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as a {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder limit(final String limit) {
            this.limit = Optional.of(Objects.requireNonNull(limit, "limit is required"));
            return this;
        }

        /**
         * Sets (or unsets) the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder limit(final Optional<String> limit) {
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
     * List this Account&#39;s Event Subscriptions.
     *
     * See also <a href="https://ngrok.com/docs/api#api-event-subscriptions-list">https://ngrok.com/docs/api#api-event-subscriptions-list</a>.
     *
     * @return a call builder for this API call
     */
    public ListCallBuilder list(
    ) {
        return new ListCallBuilder(
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Update API call.
     */
    public class UpdateCallBuilder {
        private final String id;
        private Optional<String> metadata = Optional.empty();
        private Optional<String> description = Optional.empty();
        private java.util.List<EventSourceReplace> sources = java.util.Collections.emptyList();
        private java.util.List<String> destinationIds = java.util.Collections.emptyList();

        private UpdateCallBuilder(
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
        public UpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.of(Objects.requireNonNull(metadata, "metadata is required"));
            return this;
        }

        /**
         * Arbitrary customer supplied information intended to be machine readable.
         * Optional, max 4096 chars.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final Optional<String> metadata) {
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
        public UpdateCallBuilder description(final String description) {
            this.description = Optional.of(Objects.requireNonNull(description, "description is required"));
            return this;
        }

        /**
         * Arbitrary customer supplied information intended to be human readable. Optional,
         * max 255 chars.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * Sources containing the types for which this event subscription will trigger
         *
         * @param sources the value of the sources parameter as a {@link java.util.List} of {@link EventSourceReplace}
         * @return the call builder instance
         */
        public UpdateCallBuilder sources(final java.util.List<EventSourceReplace> sources) {
            this.sources = Objects.requireNonNull(sources, "sources is required");
            return this;
        }

        /**
         * Sources containing the types for which this event subscription will trigger
         *
         * @param sources the value of the sources parameter as an {@link Optional} of {@link java.util.List} of {@link EventSourceReplace}
         * @return the call builder instance
         */
        public UpdateCallBuilder sources(final Optional<java.util.List<EventSourceReplace>> sources) {
            this.sources = Objects.requireNonNull(sources, "sources is required").orElse(java.util.Collections.emptyList());
            return this;
        }
        
        /**
         * A list of Event Destination IDs which should be used for this Event
         * Subscription.
         *
         * @param destinationIds the value of the destination_ids parameter as a {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder destinationIds(final java.util.List<String> destinationIds) {
            this.destinationIds = Objects.requireNonNull(destinationIds, "destinationIds is required");
            return this;
        }

        /**
         * A list of Event Destination IDs which should be used for this Event
         * Subscription.
         *
         * @param destinationIds the value of the destination_ids parameter as an {@link Optional} of {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder destinationIds(final Optional<java.util.List<String>> destinationIds) {
            this.destinationIds = Objects.requireNonNull(destinationIds, "destinationIds is required").orElse(java.util.Collections.emptyList());
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
                    new AbstractMap.SimpleEntry<>("sources", Optional.of(this.sources).filter(sources -> !sources.isEmpty()).map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("destination_ids", Optional.of(this.destinationIds).filter(destinationIds -> !destinationIds.isEmpty()).map(Function.identity()))
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
     * See also <a href="https://ngrok.com/docs/api#api-event-subscriptions-update">https://ngrok.com/docs/api#api-event-subscriptions-update</a>.
     *
     * @param id Unique identifier for this Event Subscription.
     * @return a call builder for this API call
     */
    public UpdateCallBuilder update(
        final String id
    ) {
        return new UpdateCallBuilder(
            id
        );
    }
}
