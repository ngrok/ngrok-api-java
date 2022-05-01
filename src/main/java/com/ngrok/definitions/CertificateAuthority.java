package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link CertificateAuthority} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CertificateAuthority {
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
    @JsonProperty("ca_pem")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String caPem;
    @JsonProperty("subject_common_name")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String subjectCommonName;
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

    /**
     * Creates a new instance of {@link CertificateAuthority}.
     *
     * @param id unique identifier for this Certificate Authority
     * @param uri URI of the Certificate Authority API resource
     * @param createdAt timestamp when the Certificate Authority was created, RFC 3339 format
     * @param description human-readable description of this Certificate Authority. optional, max 255 bytes.
     * @param metadata arbitrary user-defined machine-readable data of this Certificate Authority. optional, max 4096 bytes.
     * @param caPem raw PEM of the Certificate Authority
     * @param subjectCommonName subject common name of the Certificate Authority
     * @param notBefore timestamp when this Certificate Authority becomes valid, RFC 3339 format
     * @param notAfter timestamp when this Certificate Authority becomes invalid, RFC 3339 format
     * @param keyUsages set of actions the private key of this Certificate Authority can be used for
     * @param extendedKeyUsages extended set of actions the private key of this Certificate Authority can be used for
     */
    @JsonCreator
    public CertificateAuthority(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("description") final String description,
        @JsonProperty("metadata") final String metadata,
        @JsonProperty("ca_pem") final String caPem,
        @JsonProperty("subject_common_name") final String subjectCommonName,
        @JsonProperty("not_before") final java.time.OffsetDateTime notBefore,
        @JsonProperty("not_after") final java.time.OffsetDateTime notAfter,
        @JsonProperty("key_usages") final java.util.List<String> keyUsages,
        @JsonProperty("extended_key_usages") final java.util.List<String> extendedKeyUsages
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.description = Objects.requireNonNull(description, "description is required");
        this.metadata = Objects.requireNonNull(metadata, "metadata is required");
        this.caPem = Objects.requireNonNull(caPem, "caPem is required");
        this.subjectCommonName = Objects.requireNonNull(subjectCommonName, "subjectCommonName is required");
        this.notBefore = Objects.requireNonNull(notBefore, "notBefore is required");
        this.notAfter = Objects.requireNonNull(notAfter, "notAfter is required");
        this.keyUsages = keyUsages != null ? keyUsages : java.util.Collections.emptyList();
        this.extendedKeyUsages = extendedKeyUsages != null ? extendedKeyUsages : java.util.Collections.emptyList();
    }

    /**
     * unique identifier for this Certificate Authority
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of the Certificate Authority API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * timestamp when the Certificate Authority was created, RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * human-readable description of this Certificate Authority. optional, max 255
     * bytes.
     *
     * @return the value of the property as a {@link String}
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * arbitrary user-defined machine-readable data of this Certificate Authority.
     * optional, max 4096 bytes.
     *
     * @return the value of the property as a {@link String}
     */
    public String getMetadata() {
        return this.metadata;
    }

    /**
     * raw PEM of the Certificate Authority
     *
     * @return the value of the property as a {@link String}
     */
    public String getCaPem() {
        return this.caPem;
    }

    /**
     * subject common name of the Certificate Authority
     *
     * @return the value of the property as a {@link String}
     */
    public String getSubjectCommonName() {
        return this.subjectCommonName;
    }

    /**
     * timestamp when this Certificate Authority becomes valid, RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getNotBefore() {
        return this.notBefore;
    }

    /**
     * timestamp when this Certificate Authority becomes invalid, RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getNotAfter() {
        return this.notAfter;
    }

    /**
     * set of actions the private key of this Certificate Authority can be used for
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getKeyUsages() {
        return this.keyUsages;
    }

    /**
     * extended set of actions the private key of this Certificate Authority can be
     * used for
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getExtendedKeyUsages() {
        return this.extendedKeyUsages;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final CertificateAuthority other = (CertificateAuthority) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.createdAt.equals(other.createdAt)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.caPem.equals(other.caPem)&&
            this.subjectCommonName.equals(other.subjectCommonName)&&
            this.notBefore.equals(other.notBefore)&&
            this.notAfter.equals(other.notAfter)&&
            this.keyUsages.equals(other.keyUsages)&&
            this.extendedKeyUsages.equals(other.extendedKeyUsages);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.createdAt,
            this.description,
            this.metadata,
            this.caPem,
            this.subjectCommonName,
            this.notBefore,
            this.notAfter,
            this.keyUsages,
            this.extendedKeyUsages
        );
    }

    @Override
    public String toString() {
        return "CertificateAuthority{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', createdAt='" + this.createdAt +
            "', description='" + this.description +
            "', metadata='" + this.metadata +
            "', caPem='" + this.caPem +
            "', subjectCommonName='" + this.subjectCommonName +
            "', notBefore='" + this.notBefore +
            "', notAfter='" + this.notAfter +
            "', keyUsages='" + this.keyUsages +
            "', extendedKeyUsages='" + this.extendedKeyUsages +
            "'}";
    }
}
