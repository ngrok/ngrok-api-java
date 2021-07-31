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
    public class SshHostCertificatesCreateCallBuilder {
        private final String sshCertificateAuthorityId;
        private final String publicKey;
        private java.util.List<String> principals = null;
        private java.time.OffsetDateTime validAfter = null;
        private java.time.OffsetDateTime validUntil = null;
        private String description = "";
        private String metadata = "";

        private SshHostCertificatesCreateCallBuilder(
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
         * @param principals the value of the principals parameter as a {@link java.util.List<String>}
         * @return the call builder instance
         */
        public SshHostCertificatesCreateCallBuilder principals(final java.util.List<String> principals) {
            this.principals = Objects.requireNonNull(principals, "principals is required");
            return this;
        }

        /**
         * the list of principals included in the ssh host certificate. This is the list of
         * hostnames and/or IP addresses that are authorized to serve SSH traffic with this
         * certificate. Dangerously, if no principals are specified, this certificate is
         * considered valid for all hosts.
         *
         * @param principals the value of the principals parameter as an {@link Optional} of {@link java.util.List<String>}
         * @return the call builder instance
         */
        public SshHostCertificatesCreateCallBuilder principals(final Optional<java.util.List<String>> principals) {
            this.principals = Objects.requireNonNull(principals, "principals is required").orElse(null);
            return this;
        }
        
        /**
         * The time when the host certificate becomes valid, in RFC 3339 format. Defaults
         * to the current time if unspecified.
         *
         * @param validAfter the value of the valid_after parameter as a {@link java.time.OffsetDateTime}
         * @return the call builder instance
         */
        public SshHostCertificatesCreateCallBuilder validAfter(final java.time.OffsetDateTime validAfter) {
            this.validAfter = Objects.requireNonNull(validAfter, "validAfter is required");
            return this;
        }

        /**
         * The time when the host certificate becomes valid, in RFC 3339 format. Defaults
         * to the current time if unspecified.
         *
         * @param validAfter the value of the valid_after parameter as an {@link Optional} of {@link java.time.OffsetDateTime}
         * @return the call builder instance
         */
        public SshHostCertificatesCreateCallBuilder validAfter(final Optional<java.time.OffsetDateTime> validAfter) {
            this.validAfter = Objects.requireNonNull(validAfter, "validAfter is required").orElse(null);
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
        public SshHostCertificatesCreateCallBuilder validUntil(final java.time.OffsetDateTime validUntil) {
            this.validUntil = Objects.requireNonNull(validUntil, "validUntil is required");
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
        public SshHostCertificatesCreateCallBuilder validUntil(final Optional<java.time.OffsetDateTime> validUntil) {
            this.validUntil = Objects.requireNonNull(validUntil, "validUntil is required").orElse(null);
            return this;
        }
        
        /**
         * human-readable description of this SSH Host Certificate. optional, max 255
         * bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public SshHostCertificatesCreateCallBuilder description(final String description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }

        /**
         * human-readable description of this SSH Host Certificate. optional, max 255
         * bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public SshHostCertificatesCreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required").orElse("");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this SSH Host Certificate.
         * optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public SshHostCertificatesCreateCallBuilder metadata(final String metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this SSH Host Certificate.
         * optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public SshHostCertificatesCreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required").orElse("");
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
                    new AbstractMap.SimpleEntry<>("principals", Optional.of(this.principals)),
                    new AbstractMap.SimpleEntry<>("valid_after", Optional.of(this.validAfter)),
                    new AbstractMap.SimpleEntry<>("valid_until", Optional.of(this.validUntil)),
                    new AbstractMap.SimpleEntry<>("description", Optional.of(this.description)),
                    new AbstractMap.SimpleEntry<>("metadata", Optional.of(this.metadata))
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
     * @param sshCertificateAuthorityId the ssh certificate authority that is used to sign this ssh host certificate
     * @param publicKey a public key in OpenSSH Authorized Keys format that this certificate signs
     * @return a call builder for this API call
     */
    public SshHostCertificatesCreateCallBuilder create(
        final String sshCertificateAuthorityId,
        final String publicKey
    ) {
        return new SshHostCertificatesCreateCallBuilder(
            sshCertificateAuthorityId,
            publicKey
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Delete API call.
     */
    public class SshHostCertificatesDeleteCallBuilder {
        private final String id;

        private SshHostCertificatesDeleteCallBuilder(
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
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public SshHostCertificatesDeleteCallBuilder delete(
        final String id
    ) {
        return new SshHostCertificatesDeleteCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Get API call.
     */
    public class SshHostCertificatesGetCallBuilder {
        private final String id;

        private SshHostCertificatesGetCallBuilder(
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
     * Get detailed information about an SSH Host Certficate
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public SshHostCertificatesGetCallBuilder get(
        final String id
    ) {
        return new SshHostCertificatesGetCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent List API call.
     */
    public class SshHostCertificatesListCallBuilder {
        private Optional<String> beforeId = Optional.empty();
        private Optional<String> limit = Optional.empty();

        private SshHostCertificatesListCallBuilder(
        ) {
        }
        
        /**
         * Sets the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as a {@link String}
         * @return the call builder instance
         */
        public SshHostCertificatesListCallBuilder beforeId(final String beforeId) {
            this.beforeId = Optional.ofNullable(beforeId);
            return this;
        }

        /**
         * Sets (or unsets) the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public SshHostCertificatesListCallBuilder beforeId(final Optional<String> beforeId) {
            this.beforeId = Objects.requireNonNull(beforeId, "beforeId is required");
            return this;
        }
        
        /**
         * Sets the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as a {@link String}
         * @return the call builder instance
         */
        public SshHostCertificatesListCallBuilder limit(final String limit) {
            this.limit = Optional.ofNullable(limit);
            return this;
        }

        /**
         * Sets (or unsets) the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public SshHostCertificatesListCallBuilder limit(final Optional<String> limit) {
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
     * @return a call builder for this API call
     */
    public SshHostCertificatesListCallBuilder list(
    ) {
        return new SshHostCertificatesListCallBuilder(
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Update API call.
     */
    public class SshHostCertificatesUpdateCallBuilder {
        private final String id;
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();

        private SshHostCertificatesUpdateCallBuilder(
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
        public SshHostCertificatesUpdateCallBuilder description(final String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        /**
         * human-readable description of this SSH Host Certificate. optional, max 255
         * bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public SshHostCertificatesUpdateCallBuilder description(final Optional<String> description) {
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
        public SshHostCertificatesUpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.ofNullable(metadata);
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this SSH Host Certificate.
         * optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public SshHostCertificatesUpdateCallBuilder metadata(final Optional<String> metadata) {
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
     * @param id the value of the <code>id</code> parameter as a {@link String}
     * @return a call builder for this API call
     */
    public SshHostCertificatesUpdateCallBuilder update(
        final String id
    ) {
        return new SshHostCertificatesUpdateCallBuilder(
            id
        );
    }
}
