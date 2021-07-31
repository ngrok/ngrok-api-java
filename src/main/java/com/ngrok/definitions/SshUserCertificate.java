package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link SshUserCertificate} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SshUserCertificate {
    @JsonProperty("id")
    private final String id;
    @JsonProperty("uri")
    private final java.net.URI uri;
    @JsonProperty("created_at")
    private final java.time.OffsetDateTime createdAt;
    @JsonProperty("description")
    private final String description;
    @JsonProperty("metadata")
    private final String metadata;
    @JsonProperty("public_key")
    private final String publicKey;
    @JsonProperty("key_type")
    private final String keyType;
    @JsonProperty("ssh_certificate_authority_id")
    private final String sshCertificateAuthorityId;
    @JsonProperty("principals")
    private final java.util.List<String> principals;
    @JsonProperty("critical_options")
    private final java.util.Map<String, String> criticalOptions;
    @JsonProperty("extensions")
    private final java.util.Map<String, String> extensions;
    @JsonProperty("valid_after")
    private final java.time.OffsetDateTime validAfter;
    @JsonProperty("valid_until")
    private final java.time.OffsetDateTime validUntil;
    @JsonProperty("certificate")
    private final String certificate;

    /**
     * Creates a new instance of {@link SshUserCertificate}.
     *
     * @param id unique identifier for this SSH User Certificate
     * @param uri URI of the SSH User Certificate API resource
     * @param createdAt timestamp when the SSH User Certificate API resource was created, RFC 3339 format
     * @param description human-readable description of this SSH User Certificate. optional, max 255 bytes.
     * @param metadata arbitrary user-defined machine-readable data of this SSH User Certificate. optional, max 4096 bytes.
     * @param publicKey a public key in OpenSSH Authorized Keys format that this certificate signs
     * @param keyType the key type of the <code>public_key</code>, one of <code>rsa</code>, <code>ecdsa</code> or <code>ed25519</code>
     * @param sshCertificateAuthorityId the ssh certificate authority that is used to sign this ssh user certificate
     * @param principals the list of principals included in the ssh user certificate. This is the list of usernames that the certificate holder may sign in as on a machine authorizinig the signing certificate authority. Dangerously, if no principals are specified, this certificate may be used to log in as any user.
     * @param criticalOptions A map of critical options included in the certificate. Only two critical options are currently defined by OpenSSH: <code>force-command</code> and <code>source-address</code>. See <a href="https://github.com/openssh/openssh-portable/blob/master/PROTOCOL.certkeys">the OpenSSH certificate protocol spec</a> for additional details.
     * @param extensions A map of extensions included in the certificate. Extensions are additional metadata that can be interpreted by the SSH server for any purpose. These can be used to permit or deny the ability to open a terminal, do port forwarding, x11 forwarding, and more. If unspecified, the certificate will include limited permissions with the following extension map: <code>{"permit-pty": "", "permit-user-rc": ""}</code> OpenSSH understands a number of predefined extensions. See <a href="https://github.com/openssh/openssh-portable/blob/master/PROTOCOL.certkeys">the OpenSSH certificate protocol spec</a> for additional details.
     * @param validAfter the time when the ssh host certificate becomes valid, in RFC 3339 format.
     * @param validUntil the time after which the ssh host certificate becomes invalid, in RFC 3339 format. the OpenSSH certificates RFC calls this <code>valid_before</code>.
     * @param certificate the signed SSH certificate in OpenSSH Authorized Keys Format. this value should be placed in a <code>-cert.pub</code> certificate file on disk that should be referenced in your <code>sshd_config</code> configuration file with a <code>HostCertificate</code> directive
     */
    @JsonCreator
    public SshUserCertificate(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("description") final String description,
        @JsonProperty("metadata") final String metadata,
        @JsonProperty("public_key") final String publicKey,
        @JsonProperty("key_type") final String keyType,
        @JsonProperty("ssh_certificate_authority_id") final String sshCertificateAuthorityId,
        @JsonProperty("principals") final java.util.List<String> principals,
        @JsonProperty("critical_options") final java.util.Map<String, String> criticalOptions,
        @JsonProperty("extensions") final java.util.Map<String, String> extensions,
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
        this.principals = Objects.requireNonNull(principals, "principals is required");
        this.criticalOptions = Objects.requireNonNull(criticalOptions, "criticalOptions is required");
        this.extensions = Objects.requireNonNull(extensions, "extensions is required");
        this.validAfter = Objects.requireNonNull(validAfter, "validAfter is required");
        this.validUntil = Objects.requireNonNull(validUntil, "validUntil is required");
        this.certificate = Objects.requireNonNull(certificate, "certificate is required");
    }

    /**
     * unique identifier for this SSH User Certificate
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of the SSH User Certificate API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * timestamp when the SSH User Certificate API resource was created, RFC 3339
     * format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * human-readable description of this SSH User Certificate. optional, max 255
     * bytes.
     *
     * @return the value of the property as a {@link String}
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * arbitrary user-defined machine-readable data of this SSH User Certificate.
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
     * the ssh certificate authority that is used to sign this ssh user certificate
     *
     * @return the value of the property as a {@link String}
     */
    public String getSshCertificateAuthorityId() {
        return this.sshCertificateAuthorityId;
    }

    /**
     * the list of principals included in the ssh user certificate. This is the list of
     * usernames that the certificate holder may sign in as on a machine authorizinig
     * the signing certificate authority. Dangerously, if no principals are specified,
     * this certificate may be used to log in as any user.
     *
     * @return the value of the property as a {@link java.util.List<String>}
     */
    public java.util.List<String> getPrincipals() {
        return this.principals;
    }

    /**
     * A map of critical options included in the certificate. Only two critical options
     * are currently defined by OpenSSH: <code>force-command</code> and
     * <code>source-address</code>. See <a
     * href="https://github.com/openssh/openssh-portable/blob/master/PROTOCOL.certkeys">the
     * OpenSSH certificate protocol spec</a> for additional details.
     *
     * @return the value of the property as a {@link java.util.Map<String, String>}
     */
    public java.util.Map<String, String> getCriticalOptions() {
        return this.criticalOptions;
    }

    /**
     * A map of extensions included in the certificate. Extensions are additional
     * metadata that can be interpreted by the SSH server for any purpose. These can be
     * used to permit or deny the ability to open a terminal, do port forwarding, x11
     * forwarding, and more. If unspecified, the certificate will include limited
     * permissions with the following extension map: <code>{"permit-pty": "",
     * "permit-user-rc": ""}</code> OpenSSH understands a number of predefined
     * extensions. See <a
     * href="https://github.com/openssh/openssh-portable/blob/master/PROTOCOL.certkeys">the
     * OpenSSH certificate protocol spec</a> for additional details.
     *
     * @return the value of the property as a {@link java.util.Map<String, String>}
     */
    public java.util.Map<String, String> getExtensions() {
        return this.extensions;
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
     * the signed SSH certificate in OpenSSH Authorized Keys Format. this value should
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
        
        final SshUserCertificate other = (SshUserCertificate) o;
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
            this.criticalOptions.equals(other.criticalOptions)&&
            this.extensions.equals(other.extensions)&&
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
            this.criticalOptions,
            this.extensions,
            this.validAfter,
            this.validUntil,
            this.certificate
        );
    }

    @Override
    public String toString() {
        return "SshUserCertificate{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', createdAt='" + this.createdAt +
            "', description='" + this.description +
            "', metadata='" + this.metadata +
            "', publicKey='" + this.publicKey +
            "', keyType='" + this.keyType +
            "', sshCertificateAuthorityId='" + this.sshCertificateAuthorityId +
            "', principals='" + this.principals +
            "', criticalOptions='" + this.criticalOptions +
            "', extensions='" + this.extensions +
            "', validAfter='" + this.validAfter +
            "', validUntil='" + this.validUntil +
            "', certificate='" + this.certificate +
            "'}";
    }
}
