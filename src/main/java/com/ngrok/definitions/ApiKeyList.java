package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link ApiKeyList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiKeyList implements Pageable {
    @JsonProperty("keys")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<ApiKey> keys;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link ApiKeyList}.
     *
     * @param keys the list of API keys for this account
     * @param uri URI of the API keys list API resource
     * @param nextPageUri URI of the next page, or null if there is no next page
     */
    @JsonCreator
    public ApiKeyList(
        @JsonProperty("keys") final java.util.List<ApiKey> keys,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.keys = keys != null ? keys : java.util.Collections.emptyList();
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * the list of API keys for this account
     *
     * @return the value of the property as a {@link java.util.List} of {@link ApiKey}
     */
    public java.util.List<ApiKey> getKeys() {
        return this.keys;
    }

    /**
     * URI of the API keys list API resource
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
        
        final ApiKeyList other = (ApiKeyList) o;
        return
            this.keys.equals(other.keys)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.keys,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "ApiKeyList{" +
            "keys='" + this.keys +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
