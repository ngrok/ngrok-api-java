/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link Vault} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vault {
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String id;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime createdAt;
    @JsonProperty("updated_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime updatedAt;
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String name;
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> description;
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> metadata;
    @JsonProperty("created_by")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String createdBy;
    @JsonProperty("last_updated_by")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String lastUpdatedBy;

    /**
     * Creates a new instance of {@link Vault}.
     *
     * @param id identifier for Vault
     * @param uri URI of this Vault API resource
     * @param createdAt Timestamp when the Vault was created (RFC 3339 format)
     * @param updatedAt Timestamp when the Vault was last updated (RFC 3339 format)
     * @param name Name of vault
     * @param description description of Vault
     * @param metadata Arbitrary user-defined metadata for this Vault
     * @param createdBy Reference to who created this Vault
     * @param lastUpdatedBy Reference to who created this Vault
     */
    @JsonCreator
    public Vault(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("updated_at") final java.time.OffsetDateTime updatedAt,
        @JsonProperty("name") final String name,
        @JsonProperty("description") final Optional<String> description,
        @JsonProperty("metadata") final Optional<String> metadata,
        @JsonProperty("created_by") final String createdBy,
        @JsonProperty("last_updated_by") final String lastUpdatedBy
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.updatedAt = Objects.requireNonNull(updatedAt, "updatedAt is required");
        this.name = Objects.requireNonNull(name, "name is required");
        this.description = description != null ? description : Optional.empty();
        this.metadata = metadata != null ? metadata : Optional.empty();
        this.createdBy = Objects.requireNonNull(createdBy, "createdBy is required");
        this.lastUpdatedBy = Objects.requireNonNull(lastUpdatedBy, "lastUpdatedBy is required");
    }

    /**
     * identifier for Vault
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of this Vault API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * Timestamp when the Vault was created (RFC 3339 format)
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Timestamp when the Vault was last updated (RFC 3339 format)
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Name of vault
     *
     * @return the value of the property as a {@link String}
     */
    public String getName() {
        return this.name;
    }

    /**
     * description of Vault
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getDescription() {
        return this.description;
    }

    /**
     * Arbitrary user-defined metadata for this Vault
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getMetadata() {
        return this.metadata;
    }

    /**
     * Reference to who created this Vault
     *
     * @return the value of the property as a {@link String}
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * Reference to who created this Vault
     *
     * @return the value of the property as a {@link String}
     */
    public String getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final Vault other = (Vault) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.createdAt.equals(other.createdAt)&&
            this.updatedAt.equals(other.updatedAt)&&
            this.name.equals(other.name)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.createdBy.equals(other.createdBy)&&
            this.lastUpdatedBy.equals(other.lastUpdatedBy);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.createdAt,
            this.updatedAt,
            this.name,
            this.description,
            this.metadata,
            this.createdBy,
            this.lastUpdatedBy
        );
    }

    @Override
    public String toString() {
        return "Vault{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', createdAt='" + this.createdAt +
            "', updatedAt='" + this.updatedAt +
            "', name='" + this.name +
            "', description='" + this.description.orElse("(null)") +
            "', metadata='" + this.metadata.orElse("(null)") +
            "', createdBy='" + this.createdBy +
            "', lastUpdatedBy='" + this.lastUpdatedBy +
            "'}";
    }
}
