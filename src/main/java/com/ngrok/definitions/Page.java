package com.ngrok.definitions;

import com.ngrok.NgrokApiClient;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Wrapper class that holds a single page of a {@link Pageable} response.
 */
public class Page<T extends Pageable> {
    private final NgrokApiClient apiClient;
    private final T page;

    /**
     * Create a new page.
     *
     * @param apiClient the API client used to fetch the page
     * @param page the page itself
     */
    public Page(final NgrokApiClient apiClient, final T page) {
        this.apiClient = apiClient;
        this.page = page;
    }

    /**
     * Returns the current response page.
     *
     * @return a page
     */
    public T getPage() {
        return page;
    }

    /**
     * Fetches the next page of responses, if any.
     *
     * @return a future encapsulating a possible next page
     */
    @SuppressWarnings("unchecked")
    public CompletionStage<Optional<Page<T>>> next() {
        return page.getNextPageUri()
            .map(nextPageUri -> apiClient.sendRequest(nextPageUri, (Class<T>) this.page.getClass())
                .thenApply(nextPage -> Optional.of(new Page<>(this.apiClient, nextPage)))
            )
            .orElseGet(() -> CompletableFuture.completedFuture(Optional.empty()));
    }
}
