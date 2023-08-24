/* Code generated for API Clients. DO NOT EDIT. */

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
 * SSH Credentials are SSH public keys that can be used to start SSH tunnels
 *  via the ngrok SSH tunnel gateway.
 *
 * See also <a href="https://ngrok.com/docs/api#api-ssh-credentials">https://ngrok.com/docs/api#api-ssh-credentials</a>.
 */
public class SshCredentials {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for SshCredentials.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public SshCredentials(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class CreateCallBuilder {
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private java.util.List<String> acl = java.util.Collections.emptyList();
        private final String publicKey;
        private Optional<String> ownerId = Optional.empty();

        private CreateCallBuilder(
            final String publicKey
        ) {
            this.publicKey = Objects.requireNonNull(publicKey, "publicKey is required");
        }
        
        /**
         * human-readable description of who or what will use the ssh credential to
         * authenticate. Optional, max 255 bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final String description) {
            this.description = Optional.of(Objects.requireNonNull(description, "description is required"));
            return this;
        }

        /**
         * human-readable description of who or what will use the ssh credential to
         * authenticate. Optional, max 255 bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this ssh credential. Optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.of(Objects.requireNonNull(metadata, "metadata is required"));
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this ssh credential. Optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * optional list of ACL rules. If unspecified, the credential will have no
         * restrictions. The only allowed ACL rule at this time is the <code>bind</code>
         * rule. The <code>bind</code> rule allows the caller to restrict what domains,
         * addresses, and labels the token is allowed to bind. For example, to allow the
         * token to open a tunnel on example.ngrok.io your ACL would include the rule
         * <code>bind:example.ngrok.io</code>. Bind rules for domains may specify a leading
         * wildcard to match multiple domains with a common suffix. For example, you may
         * specify a rule of <code>bind:*.example.com</code> which will allow
         * <code>x.example.com</code>, <code>y.example.com</code>,
         * <code>*.example.com</code>, etc. Bind rules for labels may specify a wildcard
         * key and/or value to match multiple labels. For example, you may specify a rule
         * of <code>bind:*=example</code> which will allow <code>x=example</code>,
         * <code>y=example</code>, etc. A rule of <code>&#39;*&#39;</code> is equivalent to
         * no acl at all and will explicitly permit all actions.
         *
         * @param acl the value of the acl parameter as a {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder acl(final java.util.List<String> acl) {
            this.acl = Objects.requireNonNull(acl, "acl is required");
            return this;
        }

        /**
         * optional list of ACL rules. If unspecified, the credential will have no
         * restrictions. The only allowed ACL rule at this time is the <code>bind</code>
         * rule. The <code>bind</code> rule allows the caller to restrict what domains,
         * addresses, and labels the token is allowed to bind. For example, to allow the
         * token to open a tunnel on example.ngrok.io your ACL would include the rule
         * <code>bind:example.ngrok.io</code>. Bind rules for domains may specify a leading
         * wildcard to match multiple domains with a common suffix. For example, you may
         * specify a rule of <code>bind:*.example.com</code> which will allow
         * <code>x.example.com</code>, <code>y.example.com</code>,
         * <code>*.example.com</code>, etc. Bind rules for labels may specify a wildcard
         * key and/or value to match multiple labels. For example, you may specify a rule
         * of <code>bind:*=example</code> which will allow <code>x=example</code>,
         * <code>y=example</code>, etc. A rule of <code>&#39;*&#39;</code> is equivalent to
         * no acl at all and will explicitly permit all actions.
         *
         * @param acl the value of the acl parameter as an {@link Optional} of {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder acl(final Optional<java.util.List<String>> acl) {
            this.acl = Objects.requireNonNull(acl, "acl is required").orElse(java.util.Collections.emptyList());
            return this;
        }
        
        /**
         * If supplied at credential creation, ownership will be assigned to the specified
         * User or Bot. Only admins may specify an owner other than themselves. Defaults to
         * the authenticated User or Bot.
         *
         * @param ownerId the value of the owner_id parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder ownerId(final String ownerId) {
            this.ownerId = Optional.of(Objects.requireNonNull(ownerId, "ownerId is required"));
            return this;
        }

        /**
         * If supplied at credential creation, ownership will be assigned to the specified
         * User or Bot. Only admins may specify an owner other than themselves. Defaults to
         * the authenticated User or Bot.
         *
         * @param ownerId the value of the owner_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder ownerId(final Optional<String> ownerId) {
            this.ownerId = Objects.requireNonNull(ownerId, "ownerId is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link SshCredential}
         */
        public CompletionStage<SshCredential> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/ssh_credentials",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("acl", Optional.of(this.acl).filter(acl -> !acl.isEmpty()).map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("public_key", Optional.of(this.publicKey)),
                    new AbstractMap.SimpleEntry<>("owner_id", this.ownerId.map(Function.identity()))
                ),
                Optional.of(SshCredential.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link SshCredential}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public SshCredential blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create a new ssh_credential from an uploaded public SSH key. This ssh credential
     * can be used to start new tunnels via ngrok&#39;s SSH gateway.
     *
     * See also <a href="https://ngrok.com/docs/api#api-ssh-credentials-create">https://ngrok.com/docs/api#api-ssh-credentials-create</a>.
     *
     * @param publicKey the PEM-encoded public key of the SSH keypair that will be used to authenticate
     * @return a call builder for this API call
     */
    public CreateCallBuilder create(
        final String publicKey
    ) {
        return new CreateCallBuilder(
            publicKey
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
                "/ssh_credentials/" + this.id,
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
     * Delete an ssh_credential by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-ssh-credentials-delete">https://ngrok.com/docs/api#api-ssh-credentials-delete</a>.
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
         * @return a {@link CompletionStage} of {@link SshCredential}
         */
        public CompletionStage<SshCredential> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/ssh_credentials/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(SshCredential.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link SshCredential}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public SshCredential blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get detailed information about an ssh_credential
     *
     * See also <a href="https://ngrok.com/docs/api#api-ssh-credentials-get">https://ngrok.com/docs/api#api-ssh-credentials-get</a>.
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
         * @return a {@link CompletionStage} of a {@link Page} of {@link SshCredentialList}
         */
        public CompletionStage<Page<SshCredentialList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/ssh_credentials",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(SshCredentialList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link SshCredentialList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<SshCredentialList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List all ssh credentials on this account
     *
     * See also <a href="https://ngrok.com/docs/api#api-ssh-credentials-list">https://ngrok.com/docs/api#api-ssh-credentials-list</a>.
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
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private Optional<java.util.List<String>> acl = Optional.empty();

        private UpdateCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * human-readable description of who or what will use the ssh credential to
         * authenticate. Optional, max 255 bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final String description) {
            this.description = Optional.of(Objects.requireNonNull(description, "description is required"));
            return this;
        }

        /**
         * human-readable description of who or what will use the ssh credential to
         * authenticate. Optional, max 255 bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this ssh credential. Optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.of(Objects.requireNonNull(metadata, "metadata is required"));
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this ssh credential. Optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * optional list of ACL rules. If unspecified, the credential will have no
         * restrictions. The only allowed ACL rule at this time is the <code>bind</code>
         * rule. The <code>bind</code> rule allows the caller to restrict what domains,
         * addresses, and labels the token is allowed to bind. For example, to allow the
         * token to open a tunnel on example.ngrok.io your ACL would include the rule
         * <code>bind:example.ngrok.io</code>. Bind rules for domains may specify a leading
         * wildcard to match multiple domains with a common suffix. For example, you may
         * specify a rule of <code>bind:*.example.com</code> which will allow
         * <code>x.example.com</code>, <code>y.example.com</code>,
         * <code>*.example.com</code>, etc. Bind rules for labels may specify a wildcard
         * key and/or value to match multiple labels. For example, you may specify a rule
         * of <code>bind:*=example</code> which will allow <code>x=example</code>,
         * <code>y=example</code>, etc. A rule of <code>&#39;*&#39;</code> is equivalent to
         * no acl at all and will explicitly permit all actions.
         *
         * @param acl the value of the acl parameter as a {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder acl(final java.util.List<String> acl) {
            this.acl = Optional.of(Objects.requireNonNull(acl, "acl is required"));
            return this;
        }

        /**
         * optional list of ACL rules. If unspecified, the credential will have no
         * restrictions. The only allowed ACL rule at this time is the <code>bind</code>
         * rule. The <code>bind</code> rule allows the caller to restrict what domains,
         * addresses, and labels the token is allowed to bind. For example, to allow the
         * token to open a tunnel on example.ngrok.io your ACL would include the rule
         * <code>bind:example.ngrok.io</code>. Bind rules for domains may specify a leading
         * wildcard to match multiple domains with a common suffix. For example, you may
         * specify a rule of <code>bind:*.example.com</code> which will allow
         * <code>x.example.com</code>, <code>y.example.com</code>,
         * <code>*.example.com</code>, etc. Bind rules for labels may specify a wildcard
         * key and/or value to match multiple labels. For example, you may specify a rule
         * of <code>bind:*=example</code> which will allow <code>x=example</code>,
         * <code>y=example</code>, etc. A rule of <code>&#39;*&#39;</code> is equivalent to
         * no acl at all and will explicitly permit all actions.
         *
         * @param acl the value of the acl parameter as an {@link Optional} of {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder acl(final Optional<java.util.List<String>> acl) {
            this.acl = Objects.requireNonNull(acl, "acl is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link SshCredential}
         */
        public CompletionStage<SshCredential> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/ssh_credentials/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("acl", Optional.of(this.acl).filter(acl -> !acl.isEmpty()).map(Function.identity()))
                ),
                Optional.of(SshCredential.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link SshCredential}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public SshCredential blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update attributes of an ssh_credential by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-ssh-credentials-update">https://ngrok.com/docs/api#api-ssh-credentials-update</a>.
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
