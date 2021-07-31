package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link CredentialList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CredentialList implements Pageable {
    @JsonProperty("credentials")
    private final java.util.List<Credential> credentials;
    @JsonProperty("uri")
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link CredentialList}.
     *
     * @param credentials the list of all tunnel credentials on this account
     * @param uri URI of the tunnel credential list API resource
     * @param nextPageUri URI of the next page, or null if there is no next page
     */
    @JsonCreator
    public CredentialList(
        @JsonProperty("credentials") final java.util.List<Credential> credentials,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.credentials = Objects.requireNonNull(credentials, "credentials is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * the list of all tunnel credentials on this account
     *
     * @return the value of the property as a {@link java.util.List<Credential>}
     */
    public java.util.List<Credential> getCredentials() {
        return this.credentials;
    }

    /**
     * URI of the tunnel credential list API resource
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
        
        final CredentialList other = (CredentialList) o;
        return
            this.credentials.equals(other.credentials)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.credentials,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "CredentialList{" +
            "credentials='" + this.credentials +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
