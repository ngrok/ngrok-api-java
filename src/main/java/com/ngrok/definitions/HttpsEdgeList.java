package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link HttpsEdgeList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HttpsEdgeList implements Pageable {
    @JsonProperty("https_edges")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<HttpsEdge> httpsEdges;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link HttpsEdgeList}.
     *
     * @param httpsEdges the list of all HTTPS Edges on this account
     * @param uri URI of the HTTPS Edge list API resource
     * @param nextPageUri URI of the next page, or null if there is no next page
     */
    @JsonCreator
    public HttpsEdgeList(
        @JsonProperty("https_edges") final java.util.List<HttpsEdge> httpsEdges,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.httpsEdges = httpsEdges != null ? httpsEdges : java.util.Collections.emptyList();
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * the list of all HTTPS Edges on this account
     *
     * @return the value of the property as a {@link java.util.List} of {@link HttpsEdge}
     */
    public java.util.List<HttpsEdge> getHttpsEdges() {
        return this.httpsEdges;
    }

    /**
     * URI of the HTTPS Edge list API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * URI of the next page, or null if there is no next page
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
        
        final HttpsEdgeList other = (HttpsEdgeList) o;
        return
            this.httpsEdges.equals(other.httpsEdges)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.httpsEdges,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "HttpsEdgeList{" +
            "httpsEdges='" + this.httpsEdges +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
