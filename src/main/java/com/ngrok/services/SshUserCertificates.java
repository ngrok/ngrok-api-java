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
 * SSH User Certificates are presented by SSH clients when connecting to an SSH
 *  server to authenticate their connection. The SSH server must trust the SSH
 *  Certificate Authority used to sign the certificate.
 *
 * See also <a href="https://ngrok.com/docs/api#api-ssh-user-certificates">https://ngrok.com/docs/api#api-ssh-user-certificates</a>.
 */
public class SshUserCertificates {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for SshUserCertificates.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public SshUserCertificates(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class CreateCallBuilder {
        private final String sshCertificateAuthorityId;
        private final String publicKey;
        private java.util.List<String> principals = java.util.Collections.emptyList();
        private java.util.Map<String, String> criticalOptions = java.util.Collections.emptyMap();
        private java.util.Map<String, String> extensions = java.util.Collections.emptyMap();
        private Optional<java.time.OffsetDateTime> validAfter = Optional.empty();
        private Optional<java.time.OffsetDateTime> validUntil = Optional.empty();
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();

        private CreateCallBuilder(
            final String sshCertificateAuthorityId,
            final String publicKey
        ) {
            this.sshCertificateAuthorityId = Objects.requireNonNull(sshCertificateAuthorityId, "sshCertificateAuthorityId is required");
            this.publicKey = Objects.requireNonNull(publicKey, "publicKey is required");
        }
        
        /**
         * the list of principals included in the ssh user certificate. This is the list of
         * usernames that the certificate holder may sign in as on a machine authorizing
         * the signing certificate authority. Dangerously, if no principals are specified,
         * this certificate may be used to log in as any user.
         *
         * @param principals the value of the principals parameter as a {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder principals(final java.util.List<String> principals) {
            this.principals = Objects.requireNonNull(principals, "principals is required");
            return this;
        }

        /**
         * the list of principals included in the ssh user certificate. This is the list of
         * usernames that the certificate holder may sign in as on a machine authorizing
         * the signing certificate authority. Dangerously, if no principals are specified,
         * this certificate may be used to log in as any user.
         *
         * @param principals the value of the principals parameter as an {@link Optional} of {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder principals(final Optional<java.util.List<String>> principals) {
            this.principals = Objects.requireNonNull(principals, "principals is required").orElse(java.util.Collections.emptyList());
            return this;
        }
        
        /**
         * A map of critical options included in the certificate. Only two critical options
         * are currently defined by OpenSSH: <code>force-command</code> and
         * <code>source-address</code>. See <a
         * href="https://github.com/openssh/openssh-portable/blob/master/PROTOCOL.certkeys">the
         * OpenSSH certificate protocol spec</a> for additional details.
         *
         * @param criticalOptions the value of the critical_options parameter as a {@link java.util.Map} of {@link String} to {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder criticalOptions(final java.util.Map<String, String> criticalOptions) {
            this.criticalOptions = Objects.requireNonNull(criticalOptions, "criticalOptions is required");
            return this;
        }

        /**
         * A map of critical options included in the certificate. Only two critical options
         * are currently defined by OpenSSH: <code>force-command</code> and
         * <code>source-address</code>. See <a
         * href="https://github.com/openssh/openssh-portable/blob/master/PROTOCOL.certkeys">the
         * OpenSSH certificate protocol spec</a> for additional details.
         *
         * @param criticalOptions the value of the critical_options parameter as an {@link Optional} of {@link java.util.Map} of {@link String} to {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder criticalOptions(final Optional<java.util.Map<String, String>> criticalOptions) {
            this.criticalOptions = Objects.requireNonNull(criticalOptions, "criticalOptions is required").orElse(java.util.Collections.emptyMap());
            return this;
        }
        
        /**
         * A map of extensions included in the certificate. Extensions are additional
         * metadata that can be interpreted by the SSH server for any purpose. These can be
         * used to permit or deny the ability to open a terminal, do port forwarding, x11
         * forwarding, and more. If unspecified, the certificate will include limited
         * permissions with the following extension map: <code>{&#34;permit-pty&#34;:
         * &#34;&#34;, &#34;permit-user-rc&#34;: &#34;&#34;}</code> OpenSSH understands a
         * number of predefined extensions. See <a
         * href="https://github.com/openssh/openssh-portable/blob/master/PROTOCOL.certkeys">the
         * OpenSSH certificate protocol spec</a> for additional details.
         *
         * @param extensions the value of the extensions parameter as a {@link java.util.Map} of {@link String} to {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder extensions(final java.util.Map<String, String> extensions) {
            this.extensions = Objects.requireNonNull(extensions, "extensions is required");
            return this;
        }

        /**
         * A map of extensions included in the certificate. Extensions are additional
         * metadata that can be interpreted by the SSH server for any purpose. These can be
         * used to permit or deny the ability to open a terminal, do port forwarding, x11
         * forwarding, and more. If unspecified, the certificate will include limited
         * permissions with the following extension map: <code>{&#34;permit-pty&#34;:
         * &#34;&#34;, &#34;permit-user-rc&#34;: &#34;&#34;}</code> OpenSSH understands a
         * number of predefined extensions. See <a
         * href="https://github.com/openssh/openssh-portable/blob/master/PROTOCOL.certkeys">the
         * OpenSSH certificate protocol spec</a> for additional details.
         *
         * @param extensions the value of the extensions parameter as an {@link Optional} of {@link java.util.Map} of {@link String} to {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder extensions(final Optional<java.util.Map<String, String>> extensions) {
            this.extensions = Objects.requireNonNull(extensions, "extensions is required").orElse(java.util.Collections.emptyMap());
            return this;
        }
        
        /**
         * The time when the user certificate becomes valid, in RFC 3339 format. Defaults
         * to the current time if unspecified.
         *
         * @param validAfter the value of the valid_after parameter as a {@link java.time.OffsetDateTime}
         * @return the call builder instance
         */
        public CreateCallBuilder validAfter(final java.time.OffsetDateTime validAfter) {
            this.validAfter = Optional.of(Objects.requireNonNull(validAfter, "validAfter is required"));
            return this;
        }

        /**
         * The time when the user certificate becomes valid, in RFC 3339 format. Defaults
         * to the current time if unspecified.
         *
         * @param validAfter the value of the valid_after parameter as an {@link Optional} of {@link java.time.OffsetDateTime}
         * @return the call builder instance
         */
        public CreateCallBuilder validAfter(final Optional<java.time.OffsetDateTime> validAfter) {
            this.validAfter = Objects.requireNonNull(validAfter, "validAfter is required");
            return this;
        }
        
        /**
         * The time when this host certificate becomes invalid, in RFC 3339 format. If
         * unspecified, a default value of 24 hours will be used. The OpenSSH certificates
         * RFC calls this <code>valid_before</code>.
         *
         * @param validUntil the value of the valid_until parameter as a {@link java.time.OffsetDateTime}
         * @return the call builder instance
         */
        public CreateCallBuilder validUntil(final java.time.OffsetDateTime validUntil) {
            this.validUntil = Optional.of(Objects.requireNonNull(validUntil, "validUntil is required"));
            return this;
        }

        /**
         * The time when this host certificate becomes invalid, in RFC 3339 format. If
         * unspecified, a default value of 24 hours will be used. The OpenSSH certificates
         * RFC calls this <code>valid_before</code>.
         *
         * @param validUntil the value of the valid_until parameter as an {@link Optional} of {@link java.time.OffsetDateTime}
         * @return the call builder instance
         */
        public CreateCallBuilder validUntil(final Optional<java.time.OffsetDateTime> validUntil) {
            this.validUntil = Objects.requireNonNull(validUntil, "validUntil is required");
            return this;
        }
        
        /**
         * human-readable description of this SSH User Certificate. optional, max 255
         * bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final String description) {
            this.description = Optional.of(Objects.requireNonNull(description, "description is required"));
            return this;
        }

        /**
         * human-readable description of this SSH User Certificate. optional, max 255
         * bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this SSH User Certificate.
         * optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.of(Objects.requireNonNull(metadata, "metadata is required"));
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this SSH User Certificate.
         * optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link SshUserCertificate}
         */
        public CompletionStage<SshUserCertificate> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/ssh_user_certificates",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("ssh_certificate_authority_id", Optional.of(this.sshCertificateAuthorityId)),
                    new AbstractMap.SimpleEntry<>("public_key", Optional.of(this.publicKey)),
                    new AbstractMap.SimpleEntry<>("principals", Optional.of(this.principals).filter(principals -> !principals.isEmpty()).map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("critical_options", Optional.of(this.criticalOptions).filter(criticalOptions -> !criticalOptions.isEmpty()).map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("extensions", Optional.of(this.extensions).filter(extensions -> !extensions.isEmpty()).map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("valid_after", this.validAfter.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("valid_until", this.validUntil.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity()))
                ),
                Optional.of(SshUserCertificate.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link SshUserCertificate}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public SshUserCertificate blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create a new SSH User Certificate
     *
     * See also <a href="https://ngrok.com/docs/api#api-ssh-user-certificates-create">https://ngrok.com/docs/api#api-ssh-user-certificates-create</a>.
     *
     * @param sshCertificateAuthorityId the ssh certificate authority that is used to sign this ssh user certificate
     * @param publicKey a public key in OpenSSH Authorized Keys format that this certificate signs
     * @return a call builder for this API call
     */
    public CreateCallBuilder create(
        final String sshCertificateAuthorityId,
        final String publicKey
    ) {
        return new CreateCallBuilder(
            sshCertificateAuthorityId,
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
                "/ssh_user_certificates/" + this.id,
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
     * Delete an SSH User Certificate
     *
     * See also <a href="https://ngrok.com/docs/api#api-ssh-user-certificates-delete">https://ngrok.com/docs/api#api-ssh-user-certificates-delete</a>.
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
         * @return a {@link CompletionStage} of {@link SshUserCertificate}
         */
        public CompletionStage<SshUserCertificate> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/ssh_user_certificates/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(SshUserCertificate.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link SshUserCertificate}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public SshUserCertificate blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get detailed information about an SSH User Certficate
     *
     * See also <a href="https://ngrok.com/docs/api#api-ssh-user-certificates-get">https://ngrok.com/docs/api#api-ssh-user-certificates-get</a>.
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
         * @return a {@link CompletionStage} of a {@link Page} of {@link SshUserCertificateList}
         */
        public CompletionStage<Page<SshUserCertificateList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/ssh_user_certificates",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(SshUserCertificateList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link SshUserCertificateList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<SshUserCertificateList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List all SSH User Certificates issued on this account
     *
     * See also <a href="https://ngrok.com/docs/api#api-ssh-user-certificates-list">https://ngrok.com/docs/api#api-ssh-user-certificates-list</a>.
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

        private UpdateCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * human-readable description of this SSH User Certificate. optional, max 255
         * bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final String description) {
            this.description = Optional.of(Objects.requireNonNull(description, "description is required"));
            return this;
        }

        /**
         * human-readable description of this SSH User Certificate. optional, max 255
         * bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this SSH User Certificate.
         * optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.of(Objects.requireNonNull(metadata, "metadata is required"));
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this SSH User Certificate.
         * optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link SshUserCertificate}
         */
        public CompletionStage<SshUserCertificate> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/ssh_user_certificates/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity()))
                ),
                Optional.of(SshUserCertificate.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link SshUserCertificate}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public SshUserCertificate blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update an SSH User Certificate
     *
     * See also <a href="https://ngrok.com/docs/api#api-ssh-user-certificates-update">https://ngrok.com/docs/api#api-ssh-user-certificates-update</a>.
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
