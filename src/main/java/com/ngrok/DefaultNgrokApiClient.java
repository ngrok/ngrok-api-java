/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.linecorp.armeria.client.ClientFactory;
import com.linecorp.armeria.client.WebClient;
import com.linecorp.armeria.client.WebClientRequestPreparation;
import com.linecorp.armeria.common.*;
import com.ngrok.definitions.NgrokApiError;

import java.net.URI;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

/**
 * Default implementation of {@link NgrokApiClient} based on the Armeria HTTP client.
 */
public class DefaultNgrokApiClient implements NgrokApiClient {
    private static String JAVA_VERSION = System.getProperty("java.version");

    /**
     * Builder class for the default API client.
     */
    public static class Builder {
        private final String apiKey;

        private Optional<WebClient> httpClient = Optional.empty();
        private Optional<URI> baseUri = Optional.empty();
        private Optional<ObjectMapper> objectMapper = Optional.empty();

        private Builder(final String apiKey) {
            this.apiKey = requireNonNull(apiKey, "apiKey is required");
        }

        /**
         * Sets the HTTP client to use to make requests.
         *
         * @param httpClient a HTTP client
         * @return the client builder
         */
        public DefaultNgrokApiClient.Builder httpClient(final WebClient httpClient) {
            this.httpClient = Optional.ofNullable(httpClient);
            return this;
        }

        /**
         * Sets the HTTP client to use to make requests.
         *
         * @param httpClient an optional HTTP client
         * @return the client builder
         */
        public DefaultNgrokApiClient.Builder httpClient(final Optional<WebClient> httpClient) {
            this.httpClient = requireNonNull(httpClient, "httpClient is required");
            return this;
        }

        /**
         * Sets the API base URI.
         *
         * @param baseUri a URI
         * @return the client builder
         * @see NgrokApiClient#DEFAULT_BASE_URI
         */
        public DefaultNgrokApiClient.Builder baseUri(final URI baseUri) {
            this.baseUri = Optional.ofNullable(baseUri);
            return this;
        }

        /**
         * Sets the API base URI.
         *
         * @param baseUri an optional URI
         * @return the client builder
         * @see NgrokApiClient#DEFAULT_BASE_URI
         */
        public DefaultNgrokApiClient.Builder baseUri(final Optional<URI> baseUri) {
            this.baseUri = requireNonNull(baseUri, "baseUri is required");
            return this;
        }

        /**
         * Sets the Jackson object mapper to use to serialize request bodies and deserialize response bodies.
         *
         * Be sure to pass something that can handle {@link Optional} and {@link java.time.OffsetDateTime}.
         *
         * @param objectMapper an object mapper
         * @return the client builder
         * @see Jdk8Module
         * @see JavaTimeModule
         */
        public DefaultNgrokApiClient.Builder objectMapper(final ObjectMapper objectMapper) {
            this.objectMapper = Optional.ofNullable(objectMapper);
            return this;
        }

        /**
         * Sets the Jackson object mapper to use to serialize request bodies and deserialize response bodies.
         *
         * Be sure to pass something that can handle {@link Optional} and {@link java.time.OffsetDateTime}.
         *
         * @param objectMapper an object mapper
         * @return the client builder
         * @see Jdk8Module
         * @see JavaTimeModule
         */
        public DefaultNgrokApiClient.Builder objectMapper(final Optional<ObjectMapper> objectMapper) {
            this.objectMapper = requireNonNull(objectMapper, "objectMapper is required");
            return this;
        }

        /**
         * Builds the ngrok API client instance.
         *
         * @return an api client
         */
        public DefaultNgrokApiClient build() {
            return new DefaultNgrokApiClient(
                this.apiKey,
                this.httpClient.orElseGet(DefaultNgrokApiClient::newDefaultHttpClient),
                this.baseUri.orElse(NgrokApiClient.DEFAULT_BASE_URI),
                this.objectMapper.orElseGet(() ->
                    new ObjectMapper()
                        .registerModule(new Jdk8Module())
                        .registerModule(new JavaTimeModule())
                )
            );
        }
    }

    /**
     * Creates a new ngrok API client builder.
     *
     * @param apiKey API key used to access the ngrok API
     * @return a client builder
     */
    public static DefaultNgrokApiClient.Builder newBuilder(final String apiKey) {
        return new DefaultNgrokApiClient.Builder(apiKey);
    }

    /**
     * Creates a new default Armeria {@link WebClient}.
     *
     * @return a http client
     */
    public static WebClient newDefaultHttpClient() {
        final ClientFactory factory = ClientFactory.builder()
            .connectTimeout(Duration.ofSeconds(4))
            .idleTimeout(Duration.ofMinutes(2))
            .useHttp1Pipelining(false)
            .build();
        return WebClient.builder()
            .factory(factory)
            .responseTimeout(Duration.ofSeconds(30))
            .writeTimeout(Duration.ofSeconds(1))
            .build();
    }

    private static com.linecorp.armeria.common.HttpMethod armeriaMethodFromNgrokMethod(final HttpMethod method) {
        switch (method) {
            case GET: return com.linecorp.armeria.common.HttpMethod.GET;
            case POST: return com.linecorp.armeria.common.HttpMethod.POST;
            case PUT: return com.linecorp.armeria.common.HttpMethod.PUT;
            case PATCH: return com.linecorp.armeria.common.HttpMethod.PATCH;
            case DELETE: return com.linecorp.armeria.common.HttpMethod.DELETE;
        }
        throw new AssertionError("Impossible NgrokApiClient.HttpMethod: " + method);
    }

    private static String queryParamToString(final Object value) {
        if (value instanceof String) {
            return (String) value;
        } else if (value instanceof OffsetDateTime) {
            return ((OffsetDateTime) value).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        } else if (value instanceof Duration) {
            return String.valueOf(((Duration) value).getSeconds());
        } else {
            return value.toString();
        }
    }

    private static <T> CompletionStage<T> failedFuture(final Throwable t) {
        final CompletableFuture<T> failed = new CompletableFuture<>();
        failed.completeExceptionally(t);
        return failed;
    }

    private static <T> CompletionStage<T> couldThrow(final Callable<T> f, final Optional<AggregatedHttpResponse> response) {
        try {
            return CompletableFuture.completedFuture(f.call());
        } catch (final Exception e) {
            return failedFuture(response.<Exception>map(r -> {
                final Optional<String> responseBody = Optional.of(r.content()).filter(c -> !c.isEmpty()).map(HttpData::toStringUtf8);
                try {
                    return new NgrokApiError(r.status().code(), responseBody, e);
                } catch (final Exception e1) {
                    return new NgrokApiError(HttpStatus.SERVICE_UNAVAILABLE.code(), responseBody, e);
                }
            }).orElse(e));
        }
    }

    private static <T> CompletionStage<T> couldThrow(final Callable<T> f, final AggregatedHttpResponse response) {
        return couldThrow(f, Optional.of(response));
    }

    private static <T> CompletionStage<T> couldThrow(final Callable<T> f) {
        return couldThrow(f, Optional.empty());
    }

    private final String apiKey;
    private final WebClient httpClient;
    private final URI baseUri;
    private final ObjectMapper objectMapper;

    private DefaultNgrokApiClient(final String apiKey, final WebClient httpClient, final URI baseUri, final ObjectMapper objectMapper) {
        this.apiKey = apiKey;
        this.httpClient = httpClient;
        this.baseUri = baseUri;
        this.objectMapper = objectMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <O> CompletionStage<O> sendRequest(final URI uri, final Class<O> responseClass) {
        final WebClientRequestPreparation request = this.httpClient.prepare().get(uri.toString());
        return sendRequest(request, Optional.empty(), Optional.of(responseClass));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public <O> CompletionStage<O> sendRequest(final NgrokApiClient.HttpMethod method,
                                              final String endpoint,
                                              final Stream<Map.Entry<String, Optional<Object>>> queryParams,
                                              final Stream<Map.Entry<String, Optional<Object>>> bodyParamsStream,
                                              final Optional<Class<O>> responseClass)
    {
        final WebClientRequestPreparation request = this.httpClient.prepare()
            .method(armeriaMethodFromNgrokMethod(method))
            .path(this.baseUri.toString() + endpoint)
            .queryParams(
                queryParams.flatMap(entry -> entry.getValue()
                    .map(value -> Stream.of(new AbstractMap.SimpleEntry<>(entry.getKey(), queryParamToString(value))))
                    .orElse(Stream.empty())
                ).collect(Collectors.toList())
            );

        final List<Map.Entry<String, Optional<Object>>> bodyParams = bodyParamsStream.collect(Collectors.toList());
        final Optional<JsonNode> body;
        if (bodyParams.isEmpty()) {
            body = Optional.empty();
        } else {
            body = Optional.of(this.objectMapper.convertValue(
                bodyParams.stream().flatMap(entry -> entry.getValue()
                    .map(value -> Stream.of(new AbstractMap.SimpleEntry<>(entry.getKey(), value)))
                    .orElse(Stream.empty())
                ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)),
                JsonNode.class
            ));
        }

        return sendRequest(request, body, responseClass);
    }

    private <O> CompletionStage<O> sendRequest(final WebClientRequestPreparation request,
                                               final Optional<JsonNode> maybeBody,
                                               final Optional<Class<O>> responseClass)
    {
        request
            .header(HttpHeaderNames.USER_AGENT, "ngrok-api-java/" + Version.CLIENT_VERSION + "/" + JAVA_VERSION)
            .header("ngrok-version", Version.API_VERSION)
            .header(HttpHeaderNames.AUTHORIZATION, "Bearer " + this.apiKey);
        return maybeBody
            .map(body -> couldThrow(() -> Optional.of(this.objectMapper.writeValueAsBytes(body))))
            .orElseGet(() ->CompletableFuture.completedFuture(Optional.empty()))
            .thenApply(maybeBodyBytes -> maybeBodyBytes.map(bodyBytes -> request.content(MediaType.JSON, bodyBytes)).orElse(request))
            .thenCompose(req -> req.execute().aggregate())
            .thenCompose(response -> Optional
                .of(response.content())
                .filter(c -> !c.isEmpty())
                .map(responseBody -> {
                    if (response.status().isSuccess()) {
                        return responseClass
                            .map(cls -> couldThrow(() -> this.objectMapper.readValue(responseBody.toStringUtf8(), cls), response))
                            .orElseGet(() -> CompletableFuture.completedFuture(null));
                    } else {
                        return couldThrow(() -> this.objectMapper.readValue(responseBody.toStringUtf8(), NgrokApiError.class), response)
                            .thenCompose(DefaultNgrokApiClient::<O>failedFuture);
                    }
                })
                .orElseGet(() -> {
                    if (response.status().isSuccess()) {
                        return responseClass
                            .map(cls -> couldThrow(() -> this.objectMapper.readValue("{}", cls), response))
                            .orElseGet(() -> CompletableFuture.completedFuture(null));
                    } else {
                        return failedFuture(new NgrokApiError(response.status().code()));
                    }
                })
            );
    }
}
