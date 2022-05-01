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
 * Tunnel Sessions represent instances of ngrok agents or SSH reverse tunnel
 *  sessions that are running and connected to the ngrok service. Each tunnel
 *  session can include one or more Tunnels.
 *
 * See also <a href="https://ngrok.com/docs/api#api-tunnel-sessions">https://ngrok.com/docs/api#api-tunnel-sessions</a>.
 */
public class TunnelSessions {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for TunnelSessions.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public TunnelSessions(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
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
         * @return a {@link CompletionStage} of a {@link Page} of {@link TunnelSessionList}
         */
        public CompletionStage<Page<TunnelSessionList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/tunnel_sessions",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(TunnelSessionList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link TunnelSessionList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<TunnelSessionList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List all online tunnel sessions running on this account.
     *
     * See also <a href="https://ngrok.com/docs/api#api-tunnel-sessions-list">https://ngrok.com/docs/api#api-tunnel-sessions-list</a>.
     *
     * @return a call builder for this API call
     */
    public ListCallBuilder list(
    ) {
        return new ListCallBuilder(
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
         * @return a {@link CompletionStage} of {@link TunnelSession}
         */
        public CompletionStage<TunnelSession> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/tunnel_sessions/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(TunnelSession.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link TunnelSession}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public TunnelSession blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get the detailed status of a tunnel session by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-tunnel-sessions-get">https://ngrok.com/docs/api#api-tunnel-sessions-get</a>.
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
     * A builder object encapsulating state for an unsent Restart API call.
     */
    public class RestartCallBuilder {
        private final String id;

        private RestartCallBuilder(
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
                NgrokApiClient.HttpMethod.POST,
                "/tunnel_sessions/" + this.id + "/restart",
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
     * Issues a command instructing the ngrok agent to restart. The agent restarts
     * itself by calling exec() on platforms that support it. This operation is notably
     * not supported on Windows. When an agent restarts, it reconnects with a new
     * tunnel session ID.
     *
     * See also <a href="https://ngrok.com/docs/api#api-tunnel-sessions-restart">https://ngrok.com/docs/api#api-tunnel-sessions-restart</a>.
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public RestartCallBuilder restart(
        final String id
    ) {
        return new RestartCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Stop API call.
     */
    public class StopCallBuilder {
        private final String id;

        private StopCallBuilder(
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
                NgrokApiClient.HttpMethod.POST,
                "/tunnel_sessions/" + this.id + "/stop",
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
     * Issues a command instructing the ngrok agent that started this tunnel session to
     * exit.
     *
     * See also <a href="https://ngrok.com/docs/api#api-tunnel-sessions-stop">https://ngrok.com/docs/api#api-tunnel-sessions-stop</a>.
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public StopCallBuilder stop(
        final String id
    ) {
        return new StopCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Update API call.
     */
    public class UpdateCallBuilder {
        private final String id;

        private UpdateCallBuilder(
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
                NgrokApiClient.HttpMethod.POST,
                "/tunnel_sessions/" + this.id + "/update",
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
     * Issues a command instructing the ngrok agent to update itself to the latest
     * version. After this call completes successfully, the ngrok agent will be in the
     * update process. A caller should wait some amount of time to allow the update to
     * complete (at least 10 seconds) before making a call to the Restart endpoint to
     * request that the agent restart itself to start using the new code. This call
     * will never update an ngrok agent to a new major version which could cause
     * breaking compatibility issues. If you wish to update to a new major version,
     * that must be done manually. Still, please be aware that updating your ngrok
     * agent could break your integration. This call will fail in any of the following
     * circumstances: there is no update available the ngrok agent&#39;s configuration
     * disabled update checks the agent is currently in process of updating the agent
     * has already successfully updated but has not yet been restarted
     *
     * See also <a href="https://ngrok.com/docs/api#api-tunnel-sessions-update">https://ngrok.com/docs/api#api-tunnel-sessions-update</a>.
     *
     * @param id the value of the <code>id</code> parameter as a {@link String}
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
