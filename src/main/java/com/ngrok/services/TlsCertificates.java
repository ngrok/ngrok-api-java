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
 * TLS Certificates are pairs of x509 certificates and their matching private
 *  key that can be used to terminate TLS traffic. TLS certificates are unused
 *  until they are attached to a Domain. TLS Certificates may also be
 *  provisioned by ngrok automatically for domains on which you have enabled
 *  automated certificate provisioning.
 *
 * See also <a href="https://ngrok.com/docs/api#api-tls-certificates">https://ngrok.com/docs/api#api-tls-certificates</a>.
 */
public class TlsCertificates {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for TlsCertificates.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public TlsCertificates(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class CreateCallBuilder {
        private String description = "";
        private String metadata = "";
        private final String certificatePem;
        private final String privateKeyPem;

        private CreateCallBuilder(
            final String certificatePem,
            final String privateKeyPem
        ) {
            this.certificatePem = Objects.requireNonNull(certificatePem, "certificatePem is required");
            this.privateKeyPem = Objects.requireNonNull(privateKeyPem, "privateKeyPem is required");
        }
        
        /**
         * human-readable description of this TLS certificate. optional, max 255 bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final String description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }

        /**
         * human-readable description of this TLS certificate. optional, max 255 bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required").orElse("");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this TLS certificate. optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final String metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this TLS certificate. optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required").orElse("");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link TlsCertificate}
         */
        public CompletionStage<TlsCertificate> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/tls_certificates",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", Optional.of(this.description)),
                    new AbstractMap.SimpleEntry<>("metadata", Optional.of(this.metadata)),
                    new AbstractMap.SimpleEntry<>("certificate_pem", Optional.of(this.certificatePem)),
                    new AbstractMap.SimpleEntry<>("private_key_pem", Optional.of(this.privateKeyPem))
                ),
                Optional.of(TlsCertificate.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link TlsCertificate}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public TlsCertificate blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Upload a new TLS certificate
     *
     * See also <a href="https://ngrok.com/docs/api#api-tls-certificates-create">https://ngrok.com/docs/api#api-tls-certificates-create</a>.
     *
     * @param certificatePem chain of PEM-encoded certificates, leaf first. See <a href="https://ngrok.com/docs/api#tls-certificates-pem">Certificate Bundles</a>.
     * @param privateKeyPem private key for the TLS certificate, PEM-encoded. See <a href="https://ngrok.com/docs/ngrok-link#tls-certificates-key">Private Keys</a>.
     * @return a call builder for this API call
     */
    public CreateCallBuilder create(
        final String certificatePem,
        final String privateKeyPem
    ) {
        return new CreateCallBuilder(
            certificatePem,
            privateKeyPem
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
                "/tls_certificates/" + this.id,
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
     * Delete a TLS certificate
     *
     * See also <a href="https://ngrok.com/docs/api#api-tls-certificates-delete">https://ngrok.com/docs/api#api-tls-certificates-delete</a>.
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
         * @return a {@link CompletionStage} of {@link TlsCertificate}
         */
        public CompletionStage<TlsCertificate> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/tls_certificates/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(TlsCertificate.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link TlsCertificate}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public TlsCertificate blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get detailed information about a TLS certificate
     *
     * See also <a href="https://ngrok.com/docs/api#api-tls-certificates-get">https://ngrok.com/docs/api#api-tls-certificates-get</a>.
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
            this.beforeId = Optional.ofNullable(beforeId);
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
            this.limit = Optional.ofNullable(limit);
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
         * @return a {@link CompletionStage} of a {@link Page} of {@link TlsCertificateList}
         */
        public CompletionStage<Page<TlsCertificateList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/tls_certificates",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(TlsCertificateList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link TlsCertificateList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<TlsCertificateList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List all TLS certificates on this account
     *
     * See also <a href="https://ngrok.com/docs/api#api-tls-certificates-list">https://ngrok.com/docs/api#api-tls-certificates-list</a>.
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
         * human-readable description of this TLS certificate. optional, max 255 bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final String description) {
            this.description = Optional.ofNullable(description);
            return this;
        }

        /**
         * human-readable description of this TLS certificate. optional, max 255 bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this TLS certificate. optional,
         * max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.ofNullable(metadata);
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this TLS certificate. optional,
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
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link TlsCertificate}
         */
        public CompletionStage<TlsCertificate> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/tls_certificates/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity()))
                ),
                Optional.of(TlsCertificate.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link TlsCertificate}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public TlsCertificate blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update attributes of a TLS Certificate by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-tls-certificates-update">https://ngrok.com/docs/api#api-tls-certificates-update</a>.
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
