package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link SshHostCertificate} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SshHostCertificate {
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String id;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime createdAt;
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String description;
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String metadata;
    @JsonProperty("public_key")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String publicKey;
    @JsonProperty("key_type")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String keyType;
    @JsonProperty("ssh_certificate_authority_id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String sshCertificateAuthorityId;
    @JsonProperty("principals")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> principals;
    @JsonProperty("valid_after")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime validAfter;
    @JsonProperty("valid_until")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime validUntil;
    @JsonProperty("certificate")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String certificate;

    /**
     * Creates a new instance of {@link SshHostCertificate}.
     *
     * @param id unique identifier for this SSH Host Certificate
     * @param uri URI of the SSH Host Certificate API resource
     * @param createdAt timestamp when the SSH Host Certificate API resource was created, RFC 3339 format
     * @param description human-readable description of this SSH Host Certificate. optional, max 255 bytes.
     * @param metadata arbitrary user-defined machine-readable data of this SSH Host Certificate. optional, max 4096 bytes.
     * @param publicKey a public key in OpenSSH Authorized Keys format that this certificate signs
     * @param keyType the key type of the <code>public_key</code>, one of <code>rsa</code>, <code>ecdsa</code> or <code>ed25519</code>
     * @param sshCertificateAuthorityId the ssh certificate authority that is used to sign this ssh host certificate
     * @param principals the list of principals included in the ssh host certificate. This is the list of hostnames and/or IP addresses that are authorized to serve SSH traffic with this certificate. Dangerously, if no principals are specified, this certificate is considered valid for all hosts.
     * @param validAfter the time when the ssh host certificate becomes valid, in RFC 3339 format.
     * @param validUntil the time after which the ssh host certificate becomes invalid, in RFC 3339 format. the OpenSSH certificates RFC calls this <code>valid_before</code>.
     * @param certificate the signed SSH certificate in OpenSSH Authorized Keys format. this value should be placed in a <code>-cert.pub</code> certificate file on disk that should be referenced in your <code>sshd_config</code> configuration file with a <code>HostCertificate</code> directive
     */
    @JsonCreator
    public SshHostCertificate(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("description") final String description,
        @JsonProperty("metadata") final String metadata,
        @JsonProperty("public_key") final String publicKey,
        @JsonProperty("key_type") final String keyType,
        @JsonProperty("ssh_certificate_authority_id") final String sshCertificateAuthorityId,
        @JsonProperty("principals") final java.util.List<String> principals,
        @JsonProperty("valid_after") final java.time.OffsetDateTime validAfter,
        @JsonProperty("valid_until") final java.time.OffsetDateTime validUntil,
        @JsonProperty("certificate") final String certificate
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.description = Objects.requireNonNull(description, "description is required");
        this.metadata = Objects.requireNonNull(metadata, "metadata is required");
        this.publicKey = Objects.requireNonNull(publicKey, "publicKey is required");
        this.keyType = Objects.requireNonNull(keyType, "keyType is required");
        this.sshCertificateAuthorityId = Objects.requireNonNull(sshCertificateAuthorityId, "sshCertificateAuthorityId is required");
        this.principals = principals != null ? principals : java.util.Collections.emptyList();
        this.validAfter = Objects.requireNonNull(validAfter, "validAfter is required");
        this.validUntil = Objects.requireNonNull(validUntil, "validUntil is required");
        this.certificate = Objects.requireNonNull(certificate, "certificate is required");
    }

    /**
     * unique identifier for this SSH Host Certificate
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of the SSH Host Certificate API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * timestamp when the SSH Host Certificate API resource was created, RFC 3339
     * format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * human-readable description of this SSH Host Certificate. optional, max 255
     * bytes.
     *
     * @return the value of the property as a {@link String}
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * arbitrary user-defined machine-readable data of this SSH Host Certificate.
     * optional, max 4096 bytes.
     *
     * @return the value of the property as a {@link String}
     */
    public String getMetadata() {
        return this.metadata;
    }

    /**
     * a public key in OpenSSH Authorized Keys format that this certificate signs
     *
     * @return the value of the property as a {@link String}
     */
    public String getPublicKey() {
        return this.publicKey;
    }

    /**
     * the key type of the <code>public_key</code>, one of <code>rsa</code>,
     * <code>ecdsa</code> or <code>ed25519</code>
     *
     * @return the value of the property as a {@link String}
     */
    public String getKeyType() {
        return this.keyType;
    }

    /**
     * the ssh certificate authority that is used to sign this ssh host certificate
     *
     * @return the value of the property as a {@link String}
     */
    public String getSshCertificateAuthorityId() {
        return this.sshCertificateAuthorityId;
    }

    /**
     * the list of principals included in the ssh host certificate. This is the list of
     * hostnames and/or IP addresses that are authorized to serve SSH traffic with this
     * certificate. Dangerously, if no principals are specified, this certificate is
     * considered valid for all hosts.
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getPrincipals() {
        return this.principals;
    }

    /**
     * the time when the ssh host certificate becomes valid, in RFC 3339 format.
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getValidAfter() {
        return this.validAfter;
    }

    /**
     * the time after which the ssh host certificate becomes invalid, in RFC 3339
     * format. the OpenSSH certificates RFC calls this <code>valid_before</code>.
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getValidUntil() {
        return this.validUntil;
    }

    /**
     * the signed SSH certificate in OpenSSH Authorized Keys format. this value should
     * be placed in a <code>-cert.pub</code> certificate file on disk that should be
     * referenced in your <code>sshd_config</code> configuration file with a
     * <code>HostCertificate</code> directive
     *
     * @return the value of the property as a {@link String}
     */
    public String getCertificate() {
        return this.certificate;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final SshHostCertificate other = (SshHostCertificate) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.createdAt.equals(other.createdAt)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.publicKey.equals(other.publicKey)&&
            this.keyType.equals(other.keyType)&&
            this.sshCertificateAuthorityId.equals(other.sshCertificateAuthorityId)&&
            this.principals.equals(other.principals)&&
            this.validAfter.equals(other.validAfter)&&
            this.validUntil.equals(other.validUntil)&&
            this.certificate.equals(other.certificate);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.createdAt,
            this.description,
            this.metadata,
            this.publicKey,
            this.keyType,
            this.sshCertificateAuthorityId,
            this.principals,
            this.validAfter,
            this.validUntil,
            this.certificate
        );
    }

    @Override
    public String toString() {
        return "SshHostCertificate{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', createdAt='" + this.createdAt +
            "', description='" + this.description +
            "', metadata='" + this.metadata +
            "', publicKey='" + this.publicKey +
            "', keyType='" + this.keyType +
            "', sshCertificateAuthorityId='" + this.sshCertificateAuthorityId +
            "', principals='" + this.principals +
            "', validAfter='" + this.validAfter +
            "', validUntil='" + this.validUntil +
            "', certificate='" + this.certificate +
            "'}";
    }
}
