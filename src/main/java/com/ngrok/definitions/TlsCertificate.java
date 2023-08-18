/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link TlsCertificate} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TlsCertificate {
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
    private final Optional<String> description;
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> metadata;
    @JsonProperty("certificate_pem")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String certificatePem;
    @JsonProperty("subject_common_name")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String subjectCommonName;
    @JsonProperty("subject_alternative_names")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final TlsCertificateSaNs subjectAlternativeNames;
    @JsonProperty("issued_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.time.OffsetDateTime> issuedAt;
    @JsonProperty("not_before")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime notBefore;
    @JsonProperty("not_after")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime notAfter;
    @JsonProperty("key_usages")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> keyUsages;
    @JsonProperty("extended_key_usages")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> extendedKeyUsages;
    @JsonProperty("private_key_type")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String privateKeyType;
    @JsonProperty("issuer_common_name")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String issuerCommonName;
    @JsonProperty("serial_number")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String serialNumber;
    @JsonProperty("subject_organization")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String subjectOrganization;
    @JsonProperty("subject_organizational_unit")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String subjectOrganizationalUnit;
    @JsonProperty("subject_locality")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String subjectLocality;
    @JsonProperty("subject_province")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String subjectProvince;
    @JsonProperty("subject_country")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String subjectCountry;

    /**
     * Creates a new instance of {@link TlsCertificate}.
     *
     * @param id unique identifier for this TLS certificate
     * @param uri URI of the TLS certificate API resource
     * @param createdAt timestamp when the TLS certificate was created, RFC 3339 format
     * @param description human-readable description of this TLS certificate. optional, max 255 bytes.
     * @param metadata arbitrary user-defined machine-readable data of this TLS certificate. optional, max 4096 bytes.
     * @param certificatePem chain of PEM-encoded certificates, leaf first. See <a href="https://ngrok.com/docs/cloud-edge/endpoints#certificate-chains">Certificate Bundles</a>.
     * @param subjectCommonName subject common name from the leaf of this TLS certificate
     * @param subjectAlternativeNames subject alternative names (SANs) from the leaf of this TLS certificate
     * @param issuedAt timestamp (in RFC 3339 format) when this TLS certificate was issued automatically, or null if this certificate was user-uploaded
     * @param notBefore timestamp when this TLS certificate becomes valid, RFC 3339 format
     * @param notAfter timestamp when this TLS certificate becomes invalid, RFC 3339 format
     * @param keyUsages set of actions the private key of this TLS certificate can be used for
     * @param extendedKeyUsages extended set of actions the private key of this TLS certificate can be used for
     * @param privateKeyType type of the private key of this TLS certificate. One of rsa, ecdsa, or ed25519.
     * @param issuerCommonName issuer common name from the leaf of this TLS certificate
     * @param serialNumber serial number of the leaf of this TLS certificate
     * @param subjectOrganization subject organization from the leaf of this TLS certificate
     * @param subjectOrganizationalUnit subject organizational unit from the leaf of this TLS certificate
     * @param subjectLocality subject locality from the leaf of this TLS certificate
     * @param subjectProvince subject province from the leaf of this TLS certificate
     * @param subjectCountry subject country from the leaf of this TLS certificate
     */
    @JsonCreator
    public TlsCertificate(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("description") final Optional<String> description,
        @JsonProperty("metadata") final Optional<String> metadata,
        @JsonProperty("certificate_pem") final String certificatePem,
        @JsonProperty("subject_common_name") final String subjectCommonName,
        @JsonProperty("subject_alternative_names") final TlsCertificateSaNs subjectAlternativeNames,
        @JsonProperty("issued_at") final Optional<java.time.OffsetDateTime> issuedAt,
        @JsonProperty("not_before") final java.time.OffsetDateTime notBefore,
        @JsonProperty("not_after") final java.time.OffsetDateTime notAfter,
        @JsonProperty("key_usages") final java.util.List<String> keyUsages,
        @JsonProperty("extended_key_usages") final java.util.List<String> extendedKeyUsages,
        @JsonProperty("private_key_type") final String privateKeyType,
        @JsonProperty("issuer_common_name") final String issuerCommonName,
        @JsonProperty("serial_number") final String serialNumber,
        @JsonProperty("subject_organization") final String subjectOrganization,
        @JsonProperty("subject_organizational_unit") final String subjectOrganizationalUnit,
        @JsonProperty("subject_locality") final String subjectLocality,
        @JsonProperty("subject_province") final String subjectProvince,
        @JsonProperty("subject_country") final String subjectCountry
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.description = description != null ? description : Optional.empty();
        this.metadata = metadata != null ? metadata : Optional.empty();
        this.certificatePem = Objects.requireNonNull(certificatePem, "certificatePem is required");
        this.subjectCommonName = Objects.requireNonNull(subjectCommonName, "subjectCommonName is required");
        this.subjectAlternativeNames = Objects.requireNonNull(subjectAlternativeNames, "subjectAlternativeNames is required");
        this.issuedAt = issuedAt != null ? issuedAt : Optional.empty();
        this.notBefore = Objects.requireNonNull(notBefore, "notBefore is required");
        this.notAfter = Objects.requireNonNull(notAfter, "notAfter is required");
        this.keyUsages = keyUsages != null ? keyUsages : java.util.Collections.emptyList();
        this.extendedKeyUsages = extendedKeyUsages != null ? extendedKeyUsages : java.util.Collections.emptyList();
        this.privateKeyType = Objects.requireNonNull(privateKeyType, "privateKeyType is required");
        this.issuerCommonName = Objects.requireNonNull(issuerCommonName, "issuerCommonName is required");
        this.serialNumber = Objects.requireNonNull(serialNumber, "serialNumber is required");
        this.subjectOrganization = Objects.requireNonNull(subjectOrganization, "subjectOrganization is required");
        this.subjectOrganizationalUnit = Objects.requireNonNull(subjectOrganizationalUnit, "subjectOrganizationalUnit is required");
        this.subjectLocality = Objects.requireNonNull(subjectLocality, "subjectLocality is required");
        this.subjectProvince = Objects.requireNonNull(subjectProvince, "subjectProvince is required");
        this.subjectCountry = Objects.requireNonNull(subjectCountry, "subjectCountry is required");
    }

    /**
     * unique identifier for this TLS certificate
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of the TLS certificate API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * timestamp when the TLS certificate was created, RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * human-readable description of this TLS certificate. optional, max 255 bytes.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getDescription() {
        return this.description;
    }

    /**
     * arbitrary user-defined machine-readable data of this TLS certificate. optional,
     * max 4096 bytes.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getMetadata() {
        return this.metadata;
    }

    /**
     * chain of PEM-encoded certificates, leaf first. See <a
     * href="https://ngrok.com/docs/cloud-edge/endpoints#certificate-chains">Certificate
     * Bundles</a>.
     *
     * @return the value of the property as a {@link String}
     */
    public String getCertificatePem() {
        return this.certificatePem;
    }

    /**
     * subject common name from the leaf of this TLS certificate
     *
     * @return the value of the property as a {@link String}
     */
    public String getSubjectCommonName() {
        return this.subjectCommonName;
    }

    /**
     * subject alternative names (SANs) from the leaf of this TLS certificate
     *
     * @return the value of the property as a {@link TlsCertificateSaNs}
     */
    public TlsCertificateSaNs getSubjectAlternativeNames() {
        return this.subjectAlternativeNames;
    }

    /**
     * timestamp (in RFC 3339 format) when this TLS certificate was issued
     * automatically, or null if this certificate was user-uploaded
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime} wrapped in an {@link Optional}
     */
    public Optional<java.time.OffsetDateTime> getIssuedAt() {
        return this.issuedAt;
    }

    /**
     * timestamp when this TLS certificate becomes valid, RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getNotBefore() {
        return this.notBefore;
    }

    /**
     * timestamp when this TLS certificate becomes invalid, RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getNotAfter() {
        return this.notAfter;
    }

    /**
     * set of actions the private key of this TLS certificate can be used for
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getKeyUsages() {
        return this.keyUsages;
    }

    /**
     * extended set of actions the private key of this TLS certificate can be used for
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getExtendedKeyUsages() {
        return this.extendedKeyUsages;
    }

    /**
     * type of the private key of this TLS certificate. One of rsa, ecdsa, or ed25519.
     *
     * @return the value of the property as a {@link String}
     */
    public String getPrivateKeyType() {
        return this.privateKeyType;
    }

    /**
     * issuer common name from the leaf of this TLS certificate
     *
     * @return the value of the property as a {@link String}
     */
    public String getIssuerCommonName() {
        return this.issuerCommonName;
    }

    /**
     * serial number of the leaf of this TLS certificate
     *
     * @return the value of the property as a {@link String}
     */
    public String getSerialNumber() {
        return this.serialNumber;
    }

    /**
     * subject organization from the leaf of this TLS certificate
     *
     * @return the value of the property as a {@link String}
     */
    public String getSubjectOrganization() {
        return this.subjectOrganization;
    }

    /**
     * subject organizational unit from the leaf of this TLS certificate
     *
     * @return the value of the property as a {@link String}
     */
    public String getSubjectOrganizationalUnit() {
        return this.subjectOrganizationalUnit;
    }

    /**
     * subject locality from the leaf of this TLS certificate
     *
     * @return the value of the property as a {@link String}
     */
    public String getSubjectLocality() {
        return this.subjectLocality;
    }

    /**
     * subject province from the leaf of this TLS certificate
     *
     * @return the value of the property as a {@link String}
     */
    public String getSubjectProvince() {
        return this.subjectProvince;
    }

    /**
     * subject country from the leaf of this TLS certificate
     *
     * @return the value of the property as a {@link String}
     */
    public String getSubjectCountry() {
        return this.subjectCountry;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final TlsCertificate other = (TlsCertificate) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.createdAt.equals(other.createdAt)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.certificatePem.equals(other.certificatePem)&&
            this.subjectCommonName.equals(other.subjectCommonName)&&
            this.subjectAlternativeNames.equals(other.subjectAlternativeNames)&&
            this.issuedAt.equals(other.issuedAt)&&
            this.notBefore.equals(other.notBefore)&&
            this.notAfter.equals(other.notAfter)&&
            this.keyUsages.equals(other.keyUsages)&&
            this.extendedKeyUsages.equals(other.extendedKeyUsages)&&
            this.privateKeyType.equals(other.privateKeyType)&&
            this.issuerCommonName.equals(other.issuerCommonName)&&
            this.serialNumber.equals(other.serialNumber)&&
            this.subjectOrganization.equals(other.subjectOrganization)&&
            this.subjectOrganizationalUnit.equals(other.subjectOrganizationalUnit)&&
            this.subjectLocality.equals(other.subjectLocality)&&
            this.subjectProvince.equals(other.subjectProvince)&&
            this.subjectCountry.equals(other.subjectCountry);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.createdAt,
            this.description,
            this.metadata,
            this.certificatePem,
            this.subjectCommonName,
            this.subjectAlternativeNames,
            this.issuedAt,
            this.notBefore,
            this.notAfter,
            this.keyUsages,
            this.extendedKeyUsages,
            this.privateKeyType,
            this.issuerCommonName,
            this.serialNumber,
            this.subjectOrganization,
            this.subjectOrganizationalUnit,
            this.subjectLocality,
            this.subjectProvince,
            this.subjectCountry
        );
    }

    @Override
    public String toString() {
        return "TlsCertificate{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', createdAt='" + this.createdAt +
            "', description='" + this.description.orElse("(null)") +
            "', metadata='" + this.metadata.orElse("(null)") +
            "', certificatePem='" + this.certificatePem +
            "', subjectCommonName='" + this.subjectCommonName +
            "', subjectAlternativeNames='" + this.subjectAlternativeNames +
            "', issuedAt='" + this.issuedAt.map(Object::toString).orElse("(null)") +
            "', notBefore='" + this.notBefore +
            "', notAfter='" + this.notAfter +
            "', keyUsages='" + this.keyUsages +
            "', extendedKeyUsages='" + this.extendedKeyUsages +
            "', privateKeyType='" + this.privateKeyType +
            "', issuerCommonName='" + this.issuerCommonName +
            "', serialNumber='" + this.serialNumber +
            "', subjectOrganization='" + this.subjectOrganization +
            "', subjectOrganizationalUnit='" + this.subjectOrganizationalUnit +
            "', subjectLocality='" + this.subjectLocality +
            "', subjectProvince='" + this.subjectProvince +
            "', subjectCountry='" + this.subjectCountry +
            "'}";
    }
}
