package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link SshCredentialList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SshCredentialList implements Pageable {
    @JsonProperty("ssh_credentials")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<SshCredential> sshCredentials;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link SshCredentialList}.
     *
     * @param sshCredentials the list of all ssh credentials on this account
     * @param uri URI of the ssh credential list API resource
     * @param nextPageUri URI of the next page, or null if there is no next page
     */
    @JsonCreator
    public SshCredentialList(
        @JsonProperty("ssh_credentials") final java.util.List<SshCredential> sshCredentials,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.sshCredentials = Objects.requireNonNull(sshCredentials, "sshCredentials is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * the list of all ssh credentials on this account
     *
     * @return the value of the property as a {@link java.util.List<SshCredential>}
     */
    public java.util.List<SshCredential> getSshCredentials() {
        return this.sshCredentials;
    }

    /**
     * URI of the ssh credential list API resource
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
        
        final SshCredentialList other = (SshCredentialList) o;
        return
            this.sshCredentials.equals(other.sshCredentials)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.sshCredentials,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "SshCredentialList{" +
            "sshCredentials='" + this.sshCredentials +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
