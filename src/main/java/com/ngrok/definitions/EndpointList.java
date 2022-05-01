package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointList implements Pageable {
    @JsonProperty("endpoints")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<Endpoint> endpoints;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link EndpointList}.
     *
     * @param endpoints the list of all active endpoints on this account
     * @param uri URI of the endpoints list API resource
     * @param nextPageUri URI of the next page, or null if there is no next page
     */
    @JsonCreator
    public EndpointList(
        @JsonProperty("endpoints") final java.util.List<Endpoint> endpoints,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.endpoints = endpoints != null ? endpoints : java.util.Collections.emptyList();
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * the list of all active endpoints on this account
     *
     * @return the value of the property as a {@link java.util.List} of {@link Endpoint}
     */
    public java.util.List<Endpoint> getEndpoints() {
        return this.endpoints;
    }

    /**
     * URI of the endpoints list API resource
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
        
        final EndpointList other = (EndpointList) o;
        return
            this.endpoints.equals(other.endpoints)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.endpoints,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "EndpointList{" +
            "endpoints='" + this.endpoints +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
