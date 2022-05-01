package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link SshUserCertificateList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SshUserCertificateList implements Pageable {
    @JsonProperty("ssh_user_certificates")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<SshUserCertificate> sshUserCertificates;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link SshUserCertificateList}.
     *
     * @param sshUserCertificates the list of all ssh user certificates on this account
     * @param uri URI of the ssh user certificates list API resource
     * @param nextPageUri URI of the next page, or null if there is no next page
     */
    @JsonCreator
    public SshUserCertificateList(
        @JsonProperty("ssh_user_certificates") final java.util.List<SshUserCertificate> sshUserCertificates,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.sshUserCertificates = sshUserCertificates != null ? sshUserCertificates : java.util.Collections.emptyList();
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * the list of all ssh user certificates on this account
     *
     * @return the value of the property as a {@link java.util.List} of {@link SshUserCertificate}
     */
    public java.util.List<SshUserCertificate> getSshUserCertificates() {
        return this.sshUserCertificates;
    }

    /**
     * URI of the ssh user certificates list API resource
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
        
        final SshUserCertificateList other = (SshUserCertificateList) o;
        return
            this.sshUserCertificates.equals(other.sshUserCertificates)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.sshUserCertificates,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "SshUserCertificateList{" +
            "sshUserCertificates='" + this.sshUserCertificates +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
