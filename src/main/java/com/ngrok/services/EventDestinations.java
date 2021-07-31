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
 * An API client for {@link EventDestinations}.
 */
public class EventDestinations {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for EventDestinations.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public EventDestinations(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class EventDestinationsCreateCallBuilder {
        private String metadata = "";
        private String description = "";
        private String format = "";
        private EventTarget target = null;

        private EventDestinationsCreateCallBuilder(
        ) {
        }
        
        /**
         * Arbitrary user-defined machine-readable data of this Event Destination.
         * Optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public EventDestinationsCreateCallBuilder metadata(final String metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }

        /**
         * Arbitrary user-defined machine-readable data of this Event Destination.
         * Optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public EventDestinationsCreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required").orElse("");
            return this;
        }
        
        /**
         * Human-readable description of the Event Destination. Optional, max 255 bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public EventDestinationsCreateCallBuilder description(final String description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }

        /**
         * Human-readable description of the Event Destination. Optional, max 255 bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public EventDestinationsCreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required").orElse("");
            return this;
        }
        
        /**
         * The output format you would like to serialize events into when sending to their
         * target. Currently the only accepted value is <code>JSON</code>.
         *
         * @param format the value of the format parameter as a {@link String}
         * @return the call builder instance
         */
        public EventDestinationsCreateCallBuilder format(final String format) {
            this.format = Objects.requireNonNull(format, "format is required");
            return this;
        }

        /**
         * The output format you would like to serialize events into when sending to their
         * target. Currently the only accepted value is <code>JSON</code>.
         *
         * @param format the value of the format parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public EventDestinationsCreateCallBuilder format(final Optional<String> format) {
            this.format = Objects.requireNonNull(format, "format is required").orElse("");
            return this;
        }
        
        /**
         * An object that encapsulates where and how to send your events. An event
         * destination must contain exactly one of the following objects, leaving the rest
         * null: <code>kinesis</code>, <code>firehose</code>, <code>cloudwatch_logs</code>,
         * or <code>s3</code>.
         *
         * @param target the value of the target parameter as a {@link EventTarget}
         * @return the call builder instance
         */
        public EventDestinationsCreateCallBuilder target(final EventTarget target) {
            this.target = Objects.requireNonNull(target, "target is required");
            return this;
        }

        /**
         * An object that encapsulates where and how to send your events. An event
         * destination must contain exactly one of the following objects, leaving the rest
         * null: <code>kinesis</code>, <code>firehose</code>, <code>cloudwatch_logs</code>,
         * or <code>s3</code>.
         *
         * @param target the value of the target parameter as an {@link Optional} of {@link EventTarget}
         * @return the call builder instance
         */
        public EventDestinationsCreateCallBuilder target(final Optional<EventTarget> target) {
            this.target = Objects.requireNonNull(target, "target is required").orElse(null);
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EventDestination}
         */
        public CompletionStage<EventDestination> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/event_destinations",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("metadata", Optional.of(this.metadata)),
                    new AbstractMap.SimpleEntry<>("description", Optional.of(this.description)),
                    new AbstractMap.SimpleEntry<>("format", Optional.of(this.format)),
                    new AbstractMap.SimpleEntry<>("target", Optional.of(this.target))
                ),
                Optional.of(EventDestination.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EventDestination}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EventDestination blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create a new Event Destination. It will not apply to anything until it is
     * associated with an Event Stream, and that Event Stream is associated with an
     * Endpoint Config.
     *
     * @return a call builder for this API call
     */
    public EventDestinationsCreateCallBuilder create(
    ) {
        return new EventDestinationsCreateCallBuilder(
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Delete API call.
     */
    public class EventDestinationsDeleteCallBuilder {
        private final String id;

        private EventDestinationsDeleteCallBuilder(
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
                "/event_destinations/" + this.id,
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
     * Delete an Event Destination. If the Event Destination is still referenced by an
     * Event Stream, this will throw an error until that Event Stream has removed that
     * reference.
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public EventDestinationsDeleteCallBuilder delete(
        final String id
    ) {
        return new EventDestinationsDeleteCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Get API call.
     */
    public class EventDestinationsGetCallBuilder {
        private final String id;

        private EventDestinationsGetCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EventDestination}
         */
        public CompletionStage<EventDestination> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/event_destinations/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(EventDestination.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EventDestination}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EventDestination blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get detailed information about an Event Destination by ID.
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public EventDestinationsGetCallBuilder get(
        final String id
    ) {
        return new EventDestinationsGetCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent List API call.
     */
    public class EventDestinationsListCallBuilder {
        private Optional<String> beforeId = Optional.empty();
        private Optional<String> limit = Optional.empty();

        private EventDestinationsListCallBuilder(
        ) {
        }
        
        /**
         * Sets the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as a {@link String}
         * @return the call builder instance
         */
        public EventDestinationsListCallBuilder beforeId(final String beforeId) {
            this.beforeId = Optional.ofNullable(beforeId);
            return this;
        }

        /**
         * Sets (or unsets) the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public EventDestinationsListCallBuilder beforeId(final Optional<String> beforeId) {
            this.beforeId = Objects.requireNonNull(beforeId, "beforeId is required");
            return this;
        }
        
        /**
         * Sets the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as a {@link String}
         * @return the call builder instance
         */
        public EventDestinationsListCallBuilder limit(final String limit) {
            this.limit = Optional.ofNullable(limit);
            return this;
        }

        /**
         * Sets (or unsets) the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public EventDestinationsListCallBuilder limit(final Optional<String> limit) {
            this.limit = Objects.requireNonNull(limit, "limit is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of a {@link Page} of {@link EventDestinationList}
         */
        public CompletionStage<Page<EventDestinationList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/event_destinations",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(EventDestinationList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link EventDestinationList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<EventDestinationList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List all Event Destinations on this account.
     *
     * @return a call builder for this API call
     */
    public EventDestinationsListCallBuilder list(
    ) {
        return new EventDestinationsListCallBuilder(
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Update API call.
     */
    public class EventDestinationsUpdateCallBuilder {
        private final String id;
        private Optional<String> metadata = Optional.empty();
        private Optional<String> description = Optional.empty();
        private Optional<String> format = Optional.empty();
        private Optional<EventTarget> target = Optional.empty();

        private EventDestinationsUpdateCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Arbitrary user-defined machine-readable data of this Event Destination.
         * Optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public EventDestinationsUpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.ofNullable(metadata);
            return this;
        }

        /**
         * Arbitrary user-defined machine-readable data of this Event Destination.
         * Optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public EventDestinationsUpdateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * Human-readable description of the Event Destination. Optional, max 255 bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public EventDestinationsUpdateCallBuilder description(final String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        /**
         * Human-readable description of the Event Destination. Optional, max 255 bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public EventDestinationsUpdateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * The output format you would like to serialize events into when sending to their
         * target. Currently the only accepted value is <code>JSON</code>.
         *
         * @param format the value of the format parameter as a {@link String}
         * @return the call builder instance
         */
        public EventDestinationsUpdateCallBuilder format(final String format) {
            this.format = Optional.ofNullable(format);
            return this;
        }

        /**
         * The output format you would like to serialize events into when sending to their
         * target. Currently the only accepted value is <code>JSON</code>.
         *
         * @param format the value of the format parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public EventDestinationsUpdateCallBuilder format(final Optional<String> format) {
            this.format = Objects.requireNonNull(format, "format is required");
            return this;
        }
        
        /**
         * An object that encapsulates where and how to send your events. An event
         * destination must contain exactly one of the following objects, leaving the rest
         * null: <code>kinesis</code>, <code>firehose</code>, <code>cloudwatch_logs</code>,
         * or <code>s3</code>.
         *
         * @param target the value of the target parameter as a {@link EventTarget}
         * @return the call builder instance
         */
        public EventDestinationsUpdateCallBuilder target(final EventTarget target) {
            this.target = Optional.ofNullable(target);
            return this;
        }

        /**
         * An object that encapsulates where and how to send your events. An event
         * destination must contain exactly one of the following objects, leaving the rest
         * null: <code>kinesis</code>, <code>firehose</code>, <code>cloudwatch_logs</code>,
         * or <code>s3</code>.
         *
         * @param target the value of the target parameter as an {@link Optional} of {@link EventTarget}
         * @return the call builder instance
         */
        public EventDestinationsUpdateCallBuilder target(final Optional<EventTarget> target) {
            this.target = Objects.requireNonNull(target, "target is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link EventDestination}
         */
        public CompletionStage<EventDestination> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/event_destinations/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("format", this.format.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("target", this.target.map(Function.identity()))
                ),
                Optional.of(EventDestination.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link EventDestination}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public EventDestination blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update attributes of an Event Destination.
     *
     * @param id Unique identifier for this Event Destination.
     * @return a call builder for this API call
     */
    public EventDestinationsUpdateCallBuilder update(
        final String id
    ) {
        return new EventDestinationsUpdateCallBuilder(
            id
        );
    }
}
