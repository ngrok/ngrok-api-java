package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link CertificateAuthorityList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CertificateAuthorityList implements Pageable {
    @JsonProperty("certificate_authorities")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<CertificateAuthority> certificateAuthorities;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link CertificateAuthorityList}.
     *
     * @param certificateAuthorities the list of all certificate authorities on this account
     * @param uri URI of the certificates authorities list API resource
     * @param nextPageUri URI of the next page, or null if there is no next page
     */
    @JsonCreator
    public CertificateAuthorityList(
        @JsonProperty("certificate_authorities") final java.util.List<CertificateAuthority> certificateAuthorities,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.certificateAuthorities = certificateAuthorities != null ? certificateAuthorities : java.util.Collections.emptyList();
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * the list of all certificate authorities on this account
     *
     * @return the value of the property as a {@link java.util.List} of {@link CertificateAuthority}
     */
    public java.util.List<CertificateAuthority> getCertificateAuthorities() {
        return this.certificateAuthorities;
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
        
        final CertificateAuthorityList other = (CertificateAuthorityList) o;
        return
            this.certificateAuthorities.equals(other.certificateAuthorities)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.certificateAuthorities,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "CertificateAuthorityList{" +
            "certificateAuthorities='" + this.certificateAuthorities +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
