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
 * An SSH Certificate Authority is a pair of an SSH Certificate and its private
 *  key that can be used to sign other SSH host and user certificates.
 *
 * See also <a href="https://ngrok.com/docs/api#api-ssh-certificate-authorities">https://ngrok.com/docs/api#api-ssh-certificate-authorities</a>.
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
    public class CreateCallBuilder {
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private Optional<String> privateKeyType = Optional.empty();
        private Optional<String> ellipticCurve = Optional.empty();
        private Optional<Long> keySize = Optional.empty();

        private CreateCallBuilder(
        ) {
        }
        
        /**
         * human-readable description of this SSH Certificate Authority. optional, max 255
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
         * human-readable description of this SSH Certificate Authority. optional, max 255
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
         * arbitrary user-defined machine-readable data of this SSH Certificate Authority.
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
         * arbitrary user-defined machine-readable data of this SSH Certificate Authority.
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
         * the type of private key to generate. one of <code>rsa</code>,
         * <code>ecdsa</code>, <code>ed25519</code>
         *
         * @param privateKeyType the value of the private_key_type parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder privateKeyType(final String privateKeyType) {
            this.privateKeyType = Optional.of(Objects.requireNonNull(privateKeyType, "privateKeyType is required"));
            return this;
        }

        /**
         * the type of private key to generate. one of <code>rsa</code>,
         * <code>ecdsa</code>, <code>ed25519</code>
         *
         * @param privateKeyType the value of the private_key_type parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder privateKeyType(final Optional<String> privateKeyType) {
            this.privateKeyType = Objects.requireNonNull(privateKeyType, "privateKeyType is required");
            return this;
        }
        
        /**
         * the type of elliptic curve to use when creating an ECDSA key
         *
         * @param ellipticCurve the value of the elliptic_curve parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder ellipticCurve(final String ellipticCurve) {
            this.ellipticCurve = Optional.of(Objects.requireNonNull(ellipticCurve, "ellipticCurve is required"));
            return this;
        }

        /**
         * the type of elliptic curve to use when creating an ECDSA key
         *
         * @param ellipticCurve the value of the elliptic_curve parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder ellipticCurve(final Optional<String> ellipticCurve) {
            this.ellipticCurve = Objects.requireNonNull(ellipticCurve, "ellipticCurve is required");
            return this;
        }
        
        /**
         * the key size to use when creating an RSA key. one of <code>2048</code> or
         * <code>4096</code>
         *
         * @param keySize the value of the key_size parameter as a {@link long}
         * @return the call builder instance
         */
        public CreateCallBuilder keySize(final long keySize) {
            this.keySize = Optional.of(Objects.requireNonNull(keySize, "keySize is required"));
            return this;
        }

        /**
         * the key size to use when creating an RSA key. one of <code>2048</code> or
         * <code>4096</code>
         *
         * @param keySize the value of the key_size parameter as an {@link Optional} of {@link long}
         * @return the call builder instance
         */
        public CreateCallBuilder keySize(final Optional<Long> keySize) {
            this.keySize = Objects.requireNonNull(keySize, "keySize is required");
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
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("private_key_type", this.privateKeyType.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("elliptic_curve", this.ellipticCurve.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("key_size", this.keySize.map(Function.identity()))
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
     * See also <a href="https://ngrok.com/docs/api#api-ssh-certificate-authorities-create">https://ngrok.com/docs/api#api-ssh-certificate-authorities-create</a>.
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
     * See also <a href="https://ngrok.com/docs/api#api-ssh-certificate-authorities-delete">https://ngrok.com/docs/api#api-ssh-certificate-authorities-delete</a>.
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
     * See also <a href="https://ngrok.com/docs/api#api-ssh-certificate-authorities-get">https://ngrok.com/docs/api#api-ssh-certificate-authorities-get</a>.
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
     * See also <a href="https://ngrok.com/docs/api#api-ssh-certificate-authorities-list">https://ngrok.com/docs/api#api-ssh-certificate-authorities-list</a>.
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
         * human-readable description of this SSH Certificate Authority. optional, max 255
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
         * human-readable description of this SSH Certificate Authority. optional, max 255
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
         * arbitrary user-defined machine-readable data of this SSH Certificate Authority.
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
         * arbitrary user-defined machine-readable data of this SSH Certificate Authority.
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
     * See also <a href="https://ngrok.com/docs/api#api-ssh-certificate-authorities-update">https://ngrok.com/docs/api#api-ssh-certificate-authorities-update</a>.
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
