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
 * Certificate Authorities are x509 certificates that are used to sign other
 *  x509 certificates. Attach a Certificate Authority to the Mutual TLS module
 *  to verify that the TLS certificate presented by a client has been signed by
 *  this CA. Certificate Authorities  are used only for mTLS validation only and
 *  thus a private key is not included in the resource.
 *
 * See also <a href="https://ngrok.com/docs/api#api-certificate-authorities">https://ngrok.com/docs/api#api-certificate-authorities</a>.
 */
public class CertificateAuthorities {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for CertificateAuthorities.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public CertificateAuthorities(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class CreateCallBuilder {
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private final String caPem;

        private CreateCallBuilder(
            final String caPem
        ) {
            this.caPem = Objects.requireNonNull(caPem, "caPem is required");
        }
        
        /**
         * human-readable description of this Certificate Authority. optional, max 255
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
         * human-readable description of this Certificate Authority. optional, max 255
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
         * arbitrary user-defined machine-readable data of this Certificate Authority.
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
         * arbitrary user-defined machine-readable data of this Certificate Authority.
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
         * @return a {@link CompletionStage} of {@link CertificateAuthority}
         */
        public CompletionStage<CertificateAuthority> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/certificate_authorities",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("ca_pem", Optional.of(this.caPem))
                ),
                Optional.of(CertificateAuthority.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link CertificateAuthority}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public CertificateAuthority blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Upload a new Certificate Authority
     *
     * See also <a href="https://ngrok.com/docs/api#api-certificate-authorities-create">https://ngrok.com/docs/api#api-certificate-authorities-create</a>.
     *
     * @param caPem raw PEM of the Certificate Authority
     * @return a call builder for this API call
     */
    public CreateCallBuilder create(
        final String caPem
    ) {
        return new CreateCallBuilder(
            caPem
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
                "/certificate_authorities/" + this.id,
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
     * Delete a Certificate Authority
     *
     * See also <a href="https://ngrok.com/docs/api#api-certificate-authorities-delete">https://ngrok.com/docs/api#api-certificate-authorities-delete</a>.
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
         * @return a {@link CompletionStage} of {@link CertificateAuthority}
         */
        public CompletionStage<CertificateAuthority> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/certificate_authorities/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(CertificateAuthority.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link CertificateAuthority}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public CertificateAuthority blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get detailed information about a certificate authority
     *
     * See also <a href="https://ngrok.com/docs/api#api-certificate-authorities-get">https://ngrok.com/docs/api#api-certificate-authorities-get</a>.
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
        private Optional<String> filter = Optional.empty();

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
         * Sets the <code>filter</code> parameter.
         *
         * @param filter the value of the filter parameter as a {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder filter(final String filter) {
            this.filter = Optional.of(Objects.requireNonNull(filter, "filter is required"));
            return this;
        }

        /**
         * Sets (or unsets) the <code>filter</code> parameter.
         *
         * @param filter the value of the filter parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder filter(final Optional<String> filter) {
            this.filter = Objects.requireNonNull(filter, "filter is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of a {@link Page} of {@link CertificateAuthorityList}
         */
        public CompletionStage<Page<CertificateAuthorityList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/certificate_authorities",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("filter", this.filter.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(CertificateAuthorityList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link CertificateAuthorityList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<CertificateAuthorityList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List all Certificate Authority on this account
     *
     * See also <a href="https://ngrok.com/docs/api#api-certificate-authorities-list">https://ngrok.com/docs/api#api-certificate-authorities-list</a>.
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
         * human-readable description of this Certificate Authority. optional, max 255
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
         * human-readable description of this Certificate Authority. optional, max 255
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
         * arbitrary user-defined machine-readable data of this Certificate Authority.
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
         * arbitrary user-defined machine-readable data of this Certificate Authority.
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
         * @return a {@link CompletionStage} of {@link CertificateAuthority}
         */
        public CompletionStage<CertificateAuthority> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/certificate_authorities/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity()))
                ),
                Optional.of(CertificateAuthority.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link CertificateAuthority}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public CertificateAuthority blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update attributes of a Certificate Authority by ID
     *
     * See also <a href="https://ngrok.com/docs/api#api-certificate-authorities-update">https://ngrok.com/docs/api#api-certificate-authorities-update</a>.
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
