/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link SshHostCertificateList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SshHostCertificateList implements Pageable {
    @JsonProperty("ssh_host_certificates")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<SshHostCertificate> sshHostCertificates;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link SshHostCertificateList}.
     *
     * @param sshHostCertificates the list of all ssh host certificates on this account
     * @param uri URI of the ssh host certificates list API resource
     * @param nextPageUri URI of the next page, or null if there is no next page
     */
    @JsonCreator
    public SshHostCertificateList(
        @JsonProperty("ssh_host_certificates") final java.util.List<SshHostCertificate> sshHostCertificates,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.sshHostCertificates = sshHostCertificates != null ? sshHostCertificates : java.util.Collections.emptyList();
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * the list of all ssh host certificates on this account
     *
     * @return the value of the property as a {@link java.util.List} of {@link SshHostCertificate}
     */
    public java.util.List<SshHostCertificate> getSshHostCertificates() {
        return this.sshHostCertificates;
    }

    /**
     * URI of the ssh host certificates list API resource
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
        
        final SshHostCertificateList other = (SshHostCertificateList) o;
        return
            this.sshHostCertificates.equals(other.sshHostCertificates)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.sshHostCertificates,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "SshHostCertificateList{" +
            "sshHostCertificates='" + this.sshHostCertificates +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
