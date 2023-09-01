/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link SshCertificateAuthority} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SshCertificateAuthority {
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
    @JsonProperty("public_key")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String publicKey;
    @JsonProperty("key_type")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String keyType;

    /**
     * Creates a new instance of {@link SshCertificateAuthority}.
     *
     * @param id unique identifier for this SSH Certificate Authority
     * @param uri URI of the SSH Certificate Authority API resource
     * @param createdAt timestamp when the SSH Certificate Authority API resource was created, RFC 3339 format
     * @param description human-readable description of this SSH Certificate Authority. optional, max 255 bytes.
     * @param metadata arbitrary user-defined machine-readable data of this SSH Certificate Authority. optional, max 4096 bytes.
     * @param publicKey raw public key for this SSH Certificate Authority
     * @param keyType the type of private key for this SSH Certificate Authority
     */
    @JsonCreator
    public SshCertificateAuthority(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("description") final Optional<String> description,
        @JsonProperty("metadata") final Optional<String> metadata,
        @JsonProperty("public_key") final String publicKey,
        @JsonProperty("key_type") final String keyType
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.description = description != null ? description : Optional.empty();
        this.metadata = metadata != null ? metadata : Optional.empty();
        this.publicKey = Objects.requireNonNull(publicKey, "publicKey is required");
        this.keyType = Objects.requireNonNull(keyType, "keyType is required");
    }

    /**
     * unique identifier for this SSH Certificate Authority
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of the SSH Certificate Authority API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * timestamp when the SSH Certificate Authority API resource was created, RFC 3339
     * format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * human-readable description of this SSH Certificate Authority. optional, max 255
     * bytes.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getDescription() {
        return this.description;
    }

    /**
     * arbitrary user-defined machine-readable data of this SSH Certificate Authority.
     * optional, max 4096 bytes.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getMetadata() {
        return this.metadata;
    }

    /**
     * raw public key for this SSH Certificate Authority
     *
     * @return the value of the property as a {@link String}
     */
    public String getPublicKey() {
        return this.publicKey;
    }

    /**
     * the type of private key for this SSH Certificate Authority
     *
     * @return the value of the property as a {@link String}
     */
    public String getKeyType() {
        return this.keyType;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final SshCertificateAuthority other = (SshCertificateAuthority) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.createdAt.equals(other.createdAt)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.publicKey.equals(other.publicKey)&&
            this.keyType.equals(other.keyType);
        
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
            this.keyType
        );
    }

    @Override
    public String toString() {
        return "SshCertificateAuthority{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', createdAt='" + this.createdAt +
            "', description='" + this.description.orElse("(null)") +
            "', metadata='" + this.metadata.orElse("(null)") +
            "', publicKey='" + this.publicKey +
            "', keyType='" + this.keyType +
            "'}";
    }
}
