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
 * An SSH Certificate Authority is a pair of an SSH Certificate and its private
 *  key that can be used to sign other SSH host and user certificates.
 */
public class SshCertificateAuthorities {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for SshCertificateAuthorities.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public SshCertificateAuthorities(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class SshCertificateAuthoritiesCreateCallBuilder {
        private String description = "";
        private String metadata = "";
        private String privateKeyType = "";
        private String ellipticCurve = "";
        private long keySize = 0L;

        private SshCertificateAuthoritiesCreateCallBuilder(
        ) {
        }
        
        /**
         * human-readable description of this SSH Certificate Authority. optional, max 255
         * bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public SshCertificateAuthoritiesCreateCallBuilder description(final String description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }

        /**
         * human-readable description of this SSH Certificate Authority. optional, max 255
         * bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public SshCertificateAuthoritiesCreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required").orElse("");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this SSH Certificate Authority.
         * optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public SshCertificateAuthoritiesCreateCallBuilder metadata(final String metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this SSH Certificate Authority.
         * optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public SshCertificateAuthoritiesCreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required").orElse("");
            return this;
        }
        
        /**
         * the type of private key to generate. one of <code>rsa</code>,
         * <code>ecdsa</code>, <code>ed25519</code>
         *
         * @param privateKeyType the value of the private_key_type parameter as a {@link String}
         * @return the call builder instance
         */
        public SshCertificateAuthoritiesCreateCallBuilder privateKeyType(final String privateKeyType) {
            this.privateKeyType = Objects.requireNonNull(privateKeyType, "privateKeyType is required");
            return this;
        }

        /**
         * the type of private key to generate. one of <code>rsa</code>,
         * <code>ecdsa</code>, <code>ed25519</code>
         *
         * @param privateKeyType the value of the private_key_type parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public SshCertificateAuthoritiesCreateCallBuilder privateKeyType(final Optional<String> privateKeyType) {
            this.privateKeyType = Objects.requireNonNull(privateKeyType, "privateKeyType is required").orElse("");
            return this;
        }
        
        /**
         * the type of elliptic curve to use when creating an ECDSA key
         *
         * @param ellipticCurve the value of the elliptic_curve parameter as a {@link String}
         * @return the call builder instance
         */
        public SshCertificateAuthoritiesCreateCallBuilder ellipticCurve(final String ellipticCurve) {
            this.ellipticCurve = Objects.requireNonNull(ellipticCurve, "ellipticCurve is required");
            return this;
        }

        /**
         * the type of elliptic curve to use when creating an ECDSA key
         *
         * @param ellipticCurve the value of the elliptic_curve parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public SshCertificateAuthoritiesCreateCallBuilder ellipticCurve(final Optional<String> ellipticCurve) {
            this.ellipticCurve = Objects.requireNonNull(ellipticCurve, "ellipticCurve is required").orElse("");
            return this;
        }
        
        /**
         * the key size to use when creating an RSA key. one of <code>2048</code> or
         * <code>4096</code>
         *
         * @param keySize the value of the key_size parameter as a {@link long}
         * @return the call builder instance
         */
        public SshCertificateAuthoritiesCreateCallBuilder keySize(final long keySize) {
            this.keySize = Objects.requireNonNull(keySize, "keySize is required");
            return this;
        }

        /**
         * the key size to use when creating an RSA key. one of <code>2048</code> or
         * <code>4096</code>
         *
         * @param keySize the value of the key_size parameter as an {@link Optional} of {@link long}
         * @return the call builder instance
         */
        public SshCertificateAuthoritiesCreateCallBuilder keySize(final Optional<Long> keySize) {
            this.keySize = Objects.requireNonNull(keySize, "keySize is required").orElse(0L);
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link SshCertificateAuthority}
         */
        public CompletionStage<SshCertificateAuthority> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/ssh_certificate_authorities",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", Optional.of(this.description)),
                    new AbstractMap.SimpleEntry<>("metadata", Optional.of(this.metadata)),
                    new AbstractMap.SimpleEntry<>("private_key_type", Optional.of(this.privateKeyType)),
                    new AbstractMap.SimpleEntry<>("elliptic_curve", Optional.of(this.ellipticCurve)),
                    new AbstractMap.SimpleEntry<>("key_size", Optional.of(this.keySize))
                ),
                Optional.of(SshCertificateAuthority.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link SshCertificateAuthority}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public SshCertificateAuthority blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create a new SSH Certificate Authority
     *
     * @return a call builder for this API call
     */
    public SshCertificateAuthoritiesCreateCallBuilder create(
    ) {
        return new SshCertificateAuthoritiesCreateCallBuilder(
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Delete API call.
     */
    public class SshCertificateAuthoritiesDeleteCallBuilder {
        private final String id;

        private SshCertificateAuthoritiesDeleteCallBuilder(
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
                "/ssh_certificate_authorities/" + this.id,
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
     * Delete an SSH Certificate Authority
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public SshCertificateAuthoritiesDeleteCallBuilder delete(
        final String id
    ) {
        return new SshCertificateAuthoritiesDeleteCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Get API call.
     */
    public class SshCertificateAuthoritiesGetCallBuilder {
        private final String id;

        private SshCertificateAuthoritiesGetCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link SshCertificateAuthority}
         */
        public CompletionStage<SshCertificateAuthority> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/ssh_certificate_authorities/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(SshCertificateAuthority.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link SshCertificateAuthority}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public SshCertificateAuthority blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get detailed information about an SSH Certficate Authority
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public SshCertificateAuthoritiesGetCallBuilder get(
        final String id
    ) {
        return new SshCertificateAuthoritiesGetCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent List API call.
     */
    public class SshCertificateAuthoritiesListCallBuilder {
        private Optional<String> beforeId = Optional.empty();
        private Optional<String> limit = Optional.empty();

        private SshCertificateAuthoritiesListCallBuilder(
        ) {
        }
        
        /**
         * Sets the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as a {@link String}
         * @return the call builder instance
         */
        public SshCertificateAuthoritiesListCallBuilder beforeId(final String beforeId) {
            this.beforeId = Optional.ofNullable(beforeId);
            return this;
        }

        /**
         * Sets (or unsets) the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public SshCertificateAuthoritiesListCallBuilder beforeId(final Optional<String> beforeId) {
            this.beforeId = Objects.requireNonNull(beforeId, "beforeId is required");
            return this;
        }
        
        /**
         * Sets the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as a {@link String}
         * @return the call builder instance
         */
        public SshCertificateAuthoritiesListCallBuilder limit(final String limit) {
            this.limit = Optional.ofNullable(limit);
            return this;
        }

        /**
         * Sets (or unsets) the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public SshCertificateAuthoritiesListCallBuilder limit(final Optional<String> limit) {
            this.limit = Objects.requireNonNull(limit, "limit is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of a {@link Page} of {@link SshCertificateAuthorityList}
         */
        public CompletionStage<Page<SshCertificateAuthorityList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/ssh_certificate_authorities",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(SshCertificateAuthorityList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link SshCertificateAuthorityList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<SshCertificateAuthorityList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List all SSH Certificate Authorities on this account
     *
     * @return a call builder for this API call
     */
    public SshCertificateAuthoritiesListCallBuilder list(
    ) {
        return new SshCertificateAuthoritiesListCallBuilder(
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Update API call.
     */
    public class SshCertificateAuthoritiesUpdateCallBuilder {
        private final String id;
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();

        private SshCertificateAuthoritiesUpdateCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * human-readable description of this SSH Certificate Authority. optional, max 255
         * bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public SshCertificateAuthoritiesUpdateCallBuilder description(final String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        /**
         * human-readable description of this SSH Certificate Authority. optional, max 255
         * bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public SshCertificateAuthoritiesUpdateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this SSH Certificate Authority.
         * optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public SshCertificateAuthoritiesUpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.ofNullable(metadata);
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this SSH Certificate Authority.
         * optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public SshCertificateAuthoritiesUpdateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link SshCertificateAuthority}
         */
        public CompletionStage<SshCertificateAuthority> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/ssh_certificate_authorities/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity()))
                ),
                Optional.of(SshCertificateAuthority.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link SshCertificateAuthority}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public SshCertificateAuthority blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update an SSH Certificate Authority
     *
     * @param id the value of the <code>id</code> parameter as a {@link String}
     * @return a call builder for this API call
     */
    public SshCertificateAuthoritiesUpdateCallBuilder update(
        final String id
    ) {
        return new SshCertificateAuthoritiesUpdateCallBuilder(
            id
        );
    }
}
