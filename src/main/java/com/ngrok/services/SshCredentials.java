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
    public class SshCredentialsCreateCallBuilder {
        private String description = "";
        private String metadata = "";
        private java.util.List<String> acl = null;
        private final String publicKey;

        private SshCredentialsCreateCallBuilder(
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
        public SshCredentialsCreateCallBuilder description(final String description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }

        /**
         * human-readable description of who or what will use the ssh credential to
         * authenticate. Optional, max 255 bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public SshCredentialsCreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required").orElse("");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this ssh credential. Optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public SshCredentialsCreateCallBuilder metadata(final String metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this ssh credential. Optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public SshCredentialsCreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required").orElse("");
            return this;
        }
        
        /**
         * optional list of ACL rules. If unspecified, the credential will have no
         * restrictions. The only allowed ACL rule at this time is the <code>bind</code>
         * rule. The <code>bind</code> rule allows the caller to restrict what domains and
         * addresses the token is allowed to bind. For example, to allow the token to open
         * a tunnel on example.ngrok.io your ACL would include the rule
         * <code>bind:example.ngrok.io</code>. Bind rules may specify a leading wildcard to
         * match multiple domains with a common suffix. For example, you may specify a rule
         * of <code>bind:*.example.com</code> which will allow <code>x.example.com</code>,
         * <code>y.example.com</code>, <code>*.example.com</code>, etc. A rule of
         * <code>'*'</code> is equivalent to no acl at all and will explicitly permit all
         * actions.
         *
         * @param acl the value of the acl parameter as a {@link java.util.List<String>}
         * @return the call builder instance
         */
        public SshCredentialsCreateCallBuilder acl(final java.util.List<String> acl) {
            this.acl = Objects.requireNonNull(acl, "acl is required");
            return this;
        }

        /**
         * optional list of ACL rules. If unspecified, the credential will have no
         * restrictions. The only allowed ACL rule at this time is the <code>bind</code>
         * rule. The <code>bind</code> rule allows the caller to restrict what domains and
         * addresses the token is allowed to bind. For example, to allow the token to open
         * a tunnel on example.ngrok.io your ACL would include the rule
         * <code>bind:example.ngrok.io</code>. Bind rules may specify a leading wildcard to
         * match multiple domains with a common suffix. For example, you may specify a rule
         * of <code>bind:*.example.com</code> which will allow <code>x.example.com</code>,
         * <code>y.example.com</code>, <code>*.example.com</code>, etc. A rule of
         * <code>'*'</code> is equivalent to no acl at all and will explicitly permit all
         * actions.
         *
         * @param acl the value of the acl parameter as an {@link Optional} of {@link java.util.List<String>}
         * @return the call builder instance
         */
        public SshCredentialsCreateCallBuilder acl(final Optional<java.util.List<String>> acl) {
            this.acl = Objects.requireNonNull(acl, "acl is required").orElse(null);
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
                    new AbstractMap.SimpleEntry<>("description", Optional.of(this.description)),
                    new AbstractMap.SimpleEntry<>("metadata", Optional.of(this.metadata)),
                    new AbstractMap.SimpleEntry<>("acl", Optional.of(this.acl)),
                    new AbstractMap.SimpleEntry<>("public_key", Optional.of(this.publicKey))
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
     * can be used to start new tunnels via ngrok's SSH gateway.
     *
     * @param publicKey the PEM-encoded public key of the SSH keypair that will be used to authenticate
     * @return a call builder for this API call
     */
    public SshCredentialsCreateCallBuilder create(
        final String publicKey
    ) {
        return new SshCredentialsCreateCallBuilder(
            publicKey
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Delete API call.
     */
    public class SshCredentialsDeleteCallBuilder {
        private final String id;

        private SshCredentialsDeleteCallBuilder(
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
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public SshCredentialsDeleteCallBuilder delete(
        final String id
    ) {
        return new SshCredentialsDeleteCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Get API call.
     */
    public class SshCredentialsGetCallBuilder {
        private final String id;

        private SshCredentialsGetCallBuilder(
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
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public SshCredentialsGetCallBuilder get(
        final String id
    ) {
        return new SshCredentialsGetCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent List API call.
     */
    public class SshCredentialsListCallBuilder {
        private Optional<String> beforeId = Optional.empty();
        private Optional<String> limit = Optional.empty();

        private SshCredentialsListCallBuilder(
        ) {
        }
        
        /**
         * Sets the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as a {@link String}
         * @return the call builder instance
         */
        public SshCredentialsListCallBuilder beforeId(final String beforeId) {
            this.beforeId = Optional.ofNullable(beforeId);
            return this;
        }

        /**
         * Sets (or unsets) the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public SshCredentialsListCallBuilder beforeId(final Optional<String> beforeId) {
            this.beforeId = Objects.requireNonNull(beforeId, "beforeId is required");
            return this;
        }
        
        /**
         * Sets the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as a {@link String}
         * @return the call builder instance
         */
        public SshCredentialsListCallBuilder limit(final String limit) {
            this.limit = Optional.ofNullable(limit);
            return this;
        }

        /**
         * Sets (or unsets) the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public SshCredentialsListCallBuilder limit(final Optional<String> limit) {
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
     * @return a call builder for this API call
     */
    public SshCredentialsListCallBuilder list(
    ) {
        return new SshCredentialsListCallBuilder(
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Update API call.
     */
    public class SshCredentialsUpdateCallBuilder {
        private final String id;
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private Optional<java.util.List<String>> acl = Optional.empty();

        private SshCredentialsUpdateCallBuilder(
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
        public SshCredentialsUpdateCallBuilder description(final String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        /**
         * human-readable description of who or what will use the ssh credential to
         * authenticate. Optional, max 255 bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public SshCredentialsUpdateCallBuilder description(final Optional<String> description) {
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
        public SshCredentialsUpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.ofNullable(metadata);
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this ssh credential. Optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public SshCredentialsUpdateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * optional list of ACL rules. If unspecified, the credential will have no
         * restrictions. The only allowed ACL rule at this time is the <code>bind</code>
         * rule. The <code>bind</code> rule allows the caller to restrict what domains and
         * addresses the token is allowed to bind. For example, to allow the token to open
         * a tunnel on example.ngrok.io your ACL would include the rule
         * <code>bind:example.ngrok.io</code>. Bind rules may specify a leading wildcard to
         * match multiple domains with a common suffix. For example, you may specify a rule
         * of <code>bind:*.example.com</code> which will allow <code>x.example.com</code>,
         * <code>y.example.com</code>, <code>*.example.com</code>, etc. A rule of
         * <code>'*'</code> is equivalent to no acl at all and will explicitly permit all
         * actions.
         *
         * @param acl the value of the acl parameter as a {@link java.util.List<String>}
         * @return the call builder instance
         */
        public SshCredentialsUpdateCallBuilder acl(final java.util.List<String> acl) {
            this.acl = Optional.ofNullable(acl);
            return this;
        }

        /**
         * optional list of ACL rules. If unspecified, the credential will have no
         * restrictions. The only allowed ACL rule at this time is the <code>bind</code>
         * rule. The <code>bind</code> rule allows the caller to restrict what domains and
         * addresses the token is allowed to bind. For example, to allow the token to open
         * a tunnel on example.ngrok.io your ACL would include the rule
         * <code>bind:example.ngrok.io</code>. Bind rules may specify a leading wildcard to
         * match multiple domains with a common suffix. For example, you may specify a rule
         * of <code>bind:*.example.com</code> which will allow <code>x.example.com</code>,
         * <code>y.example.com</code>, <code>*.example.com</code>, etc. A rule of
         * <code>'*'</code> is equivalent to no acl at all and will explicitly permit all
         * actions.
         *
         * @param acl the value of the acl parameter as an {@link Optional} of {@link java.util.List<String>}
         * @return the call builder instance
         */
        public SshCredentialsUpdateCallBuilder acl(final Optional<java.util.List<String>> acl) {
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
                    new AbstractMap.SimpleEntry<>("acl", this.acl.map(Function.identity()))
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
     * @param id the value of the <code>id</code> parameter as a {@link String}
     * @return a call builder for this API call
     */
    public SshCredentialsUpdateCallBuilder update(
        final String id
    ) {
        return new SshCredentialsUpdateCallBuilder(
            id
        );
    }
}
