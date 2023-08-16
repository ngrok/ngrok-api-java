/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link SshCertificateAuthorityList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SshCertificateAuthorityList implements Pageable {
    @JsonProperty("ssh_certificate_authorities")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<SshCertificateAuthority> sshCertificateAuthorities;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link SshCertificateAuthorityList}.
     *
     * @param sshCertificateAuthorities the list of all certificate authorities on this account
     * @param uri URI of the certificates authorities list API resource
     * @param nextPageUri URI of the next page, or null if there is no next page
     */
    @JsonCreator
    public SshCertificateAuthorityList(
        @JsonProperty("ssh_certificate_authorities") final java.util.List<SshCertificateAuthority> sshCertificateAuthorities,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.sshCertificateAuthorities = sshCertificateAuthorities != null ? sshCertificateAuthorities : java.util.Collections.emptyList();
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * the list of all certificate authorities on this account
     *
     * @return the value of the property as a {@link java.util.List} of {@link SshCertificateAuthority}
     */
    public java.util.List<SshCertificateAuthority> getSshCertificateAuthorities() {
        return this.sshCertificateAuthorities;
    }

    /**
     * URI of the certificates authorities list API resource
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
        
        final SshCertificateAuthorityList other = (SshCertificateAuthorityList) o;
        return
            this.sshCertificateAuthorities.equals(other.sshCertificateAuthorities)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.sshCertificateAuthorities,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "SshCertificateAuthorityList{" +
            "sshCertificateAuthorities='" + this.sshCertificateAuthorities +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
