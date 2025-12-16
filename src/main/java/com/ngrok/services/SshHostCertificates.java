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
 * SSH Host Certificates along with the corresponding private key allows an SSH
 *  server to assert its authenticity to connecting SSH clients who trust the
 *  SSH Certificate Authority that was used to sign the certificate.
 *
 * See also <a href="https://ngrok.com/docs/api#api-ssh-host-certificates">https://ngrok.com/docs/api#api-ssh-host-certificates</a>.
 */
public class SshHostCertificates {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for SshHostCertificates.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public SshHostCertificates(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class CreateCallBuilder {
        private final String sshCertificateAuthorityId;
        private final String publicKey;
        private java.util.List<String> principals = java.util.Collections.emptyList();
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
         * the list of principals included in the ssh host certificate. This is the list of
         * hostnames and/or IP addresses that are authorized to serve SSH traffic with this
         * certificate. Dangerously, if no principals are specified, this certificate is
         * considered valid for all hosts.
         *
         * @param principals the value of the principals parameter as a {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder principals(final java.util.List<String> principals) {
            this.principals = Objects.requireNonNull(principals, "principals is required");
            return this;
        }

        /**
         * the list of principals included in the ssh host certificate. This is the list of
         * hostnames and/or IP addresses that are authorized to serve SSH traffic with this
         * certificate. Dangerously, if no principals are specified, this certificate is
         * considered valid for all hosts.
         *
         * @param principals the value of the principals parameter as an {@link Optional} of {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder principals(final Optional<java.util.List<String>> principals) {
            this.principals = Objects.requireNonNull(principals, "principals is required").orElse(java.util.Collections.emptyList());
            return this;
        }
        
        /**
         * The time when the host certificate becomes valid, in RFC 3339 format. Defaults
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
         * The time when the host certificate becomes valid, in RFC 3339 format. Defaults
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
         * unspecified, a default value of one year in the future will be used. The OpenSSH
         * certificates RFC calls this <code>valid_before</code>.
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
         * unspecified, a default value of one year in the future will be used. The OpenSSH
         * certificates RFC calls this <code>valid_before</code>.
         *
         * @param validUntil the value of the valid_until parameter as an {@link Optional} of {@link java.time.OffsetDateTime}
         * @return the call builder instance
         */
        public CreateCallBuilder validUntil(final Optional<java.time.OffsetDateTime> validUntil) {
            this.validUntil = Objects.requireNonNull(validUntil, "validUntil is required");
            return this;
        }
        
        /**
         * human-readable description of this SSH Host Certificate. optional, max 255
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
         * human-readable description of this SSH Host Certificate. optional, max 255
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
         * arbitrary user-defined machine-readable data of this SSH Host Certificate.
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
         * arbitrary user-defined machine-readable data of this SSH Host Certificate.
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
         * @return a {@link CompletionStage} of {@link SshHostCertificate}
         */
        public CompletionStage<SshHostCertificate> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/ssh_host_certificates",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("ssh_certificate_authority_id", Optional.of(this.sshCertificateAuthorityId)),
                    new AbstractMap.SimpleEntry<>("public_key", Optional.of(this.publicKey)),
                    new AbstractMap.SimpleEntry<>("principals", Optional.of(this.principals).filter(principals -> !principals.isEmpty()).map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("valid_after", this.validAfter.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("valid_until", this.validUntil.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity()))
                ),
                Optional.of(SshHostCertificate.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link SshHostCertificate}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public SshHostCertificate blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create a new SSH Host Certificate
     *
     * See also <a href="https://ngrok.com/docs/api#api-ssh-host-certificates-create">https://ngrok.com/docs/api#api-ssh-host-certificates-create</a>.
     *
     * @param sshCertificateAuthorityId the ssh certificate authority that is used to sign this ssh host certificate
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
                "/ssh_host_certificates/" + this.id,
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
     * Delete an SSH Host Certificate
     *
     * See also <a href="https://ngrok.com/docs/api#api-ssh-host-certificates-delete">https://ngrok.com/docs/api#api-ssh-host-certificates-delete</a>.
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
         * @return a {@link CompletionStage} of {@link SshHostCertificate}
         */
        public CompletionStage<SshHostCertificate> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/ssh_host_certificates/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(SshHostCertificate.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link SshHostCertificate}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public SshHostCertificate blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get detailed information about an SSH Host Certificate
     *
     * See also <a href="https://ngrok.com/docs/api#api-ssh-host-certificates-get">https://ngrok.com/docs/api#api-ssh-host-certificates-get</a>.
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
         * @return a {@link CompletionStage} of a {@link Page} of {@link SshHostCertificateList}
         */
        public CompletionStage<Page<SshHostCertificateList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/ssh_host_certificates",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(SshHostCertificateList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link SshHostCertificateList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<SshHostCertificateList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List all SSH Host Certificates issued on this account
     *
     * See also <a href="https://ngrok.com/docs/api#api-ssh-host-certificates-list">https://ngrok.com/docs/api#api-ssh-host-certificates-list</a>.
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
         * human-readable description of this SSH Host Certificate. optional, max 255
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
         * human-readable description of this SSH Host Certificate. optional, max 255
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
         * arbitrary user-defined machine-readable data of this SSH Host Certificate.
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
         * arbitrary user-defined machine-readable data of this SSH Host Certificate.
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
         * @return a {@link CompletionStage} of {@link SshHostCertificate}
         */
        public CompletionStage<SshHostCertificate> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/ssh_host_certificates/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity()))
                ),
                Optional.of(SshHostCertificate.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link SshHostCertificate}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public SshHostCertificate blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update an SSH Host Certificate
     *
     * See also <a href="https://ngrok.com/docs/api#api-ssh-host-certificates-update">https://ngrok.com/docs/api#api-ssh-host-certificates-update</a>.
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
