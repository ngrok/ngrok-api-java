package com.ngrok;

import java.net.URI;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.stream.Stream;

/**
 * API client interface.
 *
 * Concrete implementations can be written and passed to {@link Ngrok} on construction
 * in order to make HTTP requests or test business logic.
 *
 * @see DefaultNgrokApiClient
 */
public interface NgrokApiClient {
    /**
     * HTTP request methods
     */
    enum HttpMethod {
        /** HTTP GET */
        GET,
        /** HTTP POST */
        POST,
        /** HTTP PUT */
        PUT,
        /** HTTP PATCH */
        PATCH,
        /** HTTP DELETE */
        DELETE
    }

    /**
     * The default base URI for the public ngrok API server
     */
    URI DEFAULT_BASE_URI = URI.create("https://api.ngrok.com");

    /**
     * Sends a GET request directly to the specified URI.
     *
     * @param uri a URI to send the request to
     * @param responseClass the type of a Jackson-annotated POJO representing the HTTP response body
     * @param <O> the return type for the API response
     * @return a future encapsulating the response type
     */
    <O> CompletionStage<O> sendRequest(URI uri, Class<O> responseClass);

    /**
     * Sends a request to the ngrok API.
     *
     * @param method the HTTP method to use
     * @param endpoint the endpoint (under the base URI) to send the request to
     * @param queryParams any query parameters to send along with the request (parameters with an empty
     *                    value will not be sent)
     * @param bodyParams any JSON body parameters to send along withthe request (parameters with an empty
     *                   value will not be sent). If this stream is empty, no body should be sent.
     * @param responseClass an optional type for a Jackson-annotated POJO representing the HTTP response body
     * @param <O> the return type for the API response
     * @return a future encapsulating the response type (will be {@link Void} for empty responses)
     */
    <O> CompletionStage<O> sendRequest(HttpMethod method,
                                       String endpoint,
                                       Stream<Map.Entry<String, Optional<Object>>> queryParams,
                                       Stream<Map.Entry<String, Optional<Object>>> bodyParams,
                                       Optional<Class<O>> responseClass);
}
