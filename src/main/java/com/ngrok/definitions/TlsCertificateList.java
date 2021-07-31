package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link TlsCertificateList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TlsCertificateList implements Pageable {
    @JsonProperty("tls_certificates")
    private final java.util.List<TlsCertificate> tlsCertificates;
    @JsonProperty("uri")
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link TlsCertificateList}.
     *
     * @param tlsCertificates the list of all TLS certificates on this account
     * @param uri URI of the TLS certificates list API resource
     * @param nextPageUri URI of the next page, or null if there is no next page
     */
    @JsonCreator
    public TlsCertificateList(
        @JsonProperty("tls_certificates") final java.util.List<TlsCertificate> tlsCertificates,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.tlsCertificates = Objects.requireNonNull(tlsCertificates, "tlsCertificates is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * the list of all TLS certificates on this account
     *
     * @return the value of the property as a {@link java.util.List<TlsCertificate>}
     */
    public java.util.List<TlsCertificate> getTlsCertificates() {
        return this.tlsCertificates;
    }

    /**
     * URI of the TLS certificates list API resource
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
        
        final TlsCertificateList other = (TlsCertificateList) o;
        return
            this.tlsCertificates.equals(other.tlsCertificates)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.tlsCertificates,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "TlsCertificateList{" +
            "tlsCertificates='" + this.tlsCertificates +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
