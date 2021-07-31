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
 * Abuse Reports allow you to submit take-down requests for URLs hosted by
 *  ngrok that violate ngrok's terms of service.
 */
public class AbuseReports {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for AbuseReports.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public AbuseReports(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class AbuseReportsCreateCallBuilder {
        private final java.util.List<java.net.URI> urls;
        private String metadata = "";

        private AbuseReportsCreateCallBuilder(
            final java.util.List<java.net.URI> urls
        ) {
            this.urls = Objects.requireNonNull(urls, "urls is required");
        }
        
        /**
         * arbitrary user-defined data about this abuse report. Optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public AbuseReportsCreateCallBuilder metadata(final String metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }

        /**
         * arbitrary user-defined data about this abuse report. Optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public AbuseReportsCreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required").orElse("");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link AbuseReport}
         */
        public CompletionStage<AbuseReport> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/abuse_reports",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("urls", Optional.of(this.urls)),
                    new AbstractMap.SimpleEntry<>("metadata", Optional.of(this.metadata))
                ),
                Optional.of(AbuseReport.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link AbuseReport}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public AbuseReport blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Creates a new abuse report which will be reviewed by our system and abuse
     * response team. This API is only available to authorized accounts. Contact
     * abuse@ngrok.com to request access
     *
     * @param urls a list of URLs containing suspected abusive content
     * @return a call builder for this API call
     */
    public AbuseReportsCreateCallBuilder create(
        final java.util.List<java.net.URI> urls
    ) {
        return new AbuseReportsCreateCallBuilder(
            urls
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Get API call.
     */
    public class AbuseReportsGetCallBuilder {
        private final String id;

        private AbuseReportsGetCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link AbuseReport}
         */
        public CompletionStage<AbuseReport> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/abuse_reports/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(AbuseReport.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link AbuseReport}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public AbuseReport blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get the detailed status of abuse report by ID.
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public AbuseReportsGetCallBuilder get(
        final String id
    ) {
        return new AbuseReportsGetCallBuilder(
            id
        );
    }
}
