package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link HttpResponseBackendList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HttpResponseBackendList implements Pageable {
    @JsonProperty("backends")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<HttpResponseBackend> backends;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link HttpResponseBackendList}.
     *
     * @param backends the value of the <code>backends</code> parameter as a {@link java.util.List} of {@link HttpResponseBackend}
     * @param uri the value of the <code>uri</code> parameter as a {@link java.net.URI}
     * @param nextPageUri the value of the <code>next_page_uri</code> parameter as a {@link java.net.URI}
     */
    @JsonCreator
    public HttpResponseBackendList(
        @JsonProperty("backends") final java.util.List<HttpResponseBackend> backends,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.backends = backends != null ? backends : java.util.Collections.emptyList();
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * Fetches the value of the <code>backends</code> property.
     *
     * @return the value of the property as a {@link java.util.List} of {@link HttpResponseBackend}
     */
    public java.util.List<HttpResponseBackend> getBackends() {
        return this.backends;
    }

    /**
     * Fetches the value of the <code>uri</code> property.
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * Fetches the value of the <code>nextPageUri</code> property.
     *
     * @return the value of the property as a {@link java.net.URI} wrapped in an {@link Optional}
     */
    public Optional<java.net.URI> getNextPageUri() {
        return this.nextPageUri;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final HttpResponseBackendList other = (HttpResponseBackendList) o;
        return
            this.backends.equals(other.backends)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.backends,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "HttpResponseBackendList{" +
            "backends='" + this.backends +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
