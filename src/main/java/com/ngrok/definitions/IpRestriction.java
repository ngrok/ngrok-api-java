/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link IpRestriction} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IpRestriction {
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
    @JsonProperty("enforced")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final boolean enforced;
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String type;
    @JsonProperty("ip_policies")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<Ref> ipPolicies;

    /**
     * Creates a new instance of {@link IpRestriction}.
     *
     * @param id unique identifier for this IP restriction
     * @param uri URI of the IP restriction API resource
     * @param createdAt timestamp when the IP restriction was created, RFC 3339 format
     * @param description human-readable description of this IP restriction. optional, max 255 bytes.
     * @param metadata arbitrary user-defined machine-readable data of this IP restriction. optional, max 4096 bytes.
     * @param enforced true if the IP restriction will be enforced. if false, only warnings will be issued
     * @param type the type of IP restriction. this defines what traffic will be restricted with the attached policies. four values are currently supported: <code>dashboard</code>, <code>api</code>, <code>agent</code>, and <code>endpoints</code>
     * @param ipPolicies the set of IP policies that are used to enforce the restriction
     */
    @JsonCreator
    public IpRestriction(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("description") final Optional<String> description,
        @JsonProperty("metadata") final Optional<String> metadata,
        @JsonProperty("enforced") final Boolean enforced,
        @JsonProperty("type") final String type,
        @JsonProperty("ip_policies") final java.util.List<Ref> ipPolicies
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.description = description != null ? description : Optional.empty();
        this.metadata = metadata != null ? metadata : Optional.empty();
        this.enforced = Objects.requireNonNull(enforced, "enforced is required");
        this.type = Objects.requireNonNull(type, "type is required");
        this.ipPolicies = ipPolicies != null ? ipPolicies : java.util.Collections.emptyList();
    }

    /**
     * unique identifier for this IP restriction
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of the IP restriction API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * timestamp when the IP restriction was created, RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * human-readable description of this IP restriction. optional, max 255 bytes.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getDescription() {
        return this.description;
    }

    /**
     * arbitrary user-defined machine-readable data of this IP restriction. optional,
     * max 4096 bytes.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getMetadata() {
        return this.metadata;
    }

    /**
     * true if the IP restriction will be enforced. if false, only warnings will be
     * issued
     *
     * @return the value of the property as a {@link boolean}
     */
    public boolean getEnforced() {
        return this.enforced;
    }

    /**
     * the type of IP restriction. this defines what traffic will be restricted with
     * the attached policies. four values are currently supported:
     * <code>dashboard</code>, <code>api</code>, <code>agent</code>, and
     * <code>endpoints</code>
     *
     * @return the value of the property as a {@link String}
     */
    public String getType() {
        return this.type;
    }

    /**
     * the set of IP policies that are used to enforce the restriction
     *
     * @return the value of the property as a {@link java.util.List} of {@link Ref}
     */
    public java.util.List<Ref> getIpPolicies() {
        return this.ipPolicies;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final IpRestriction other = (IpRestriction) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.createdAt.equals(other.createdAt)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.enforced == other.enforced&&
            this.type.equals(other.type)&&
            this.ipPolicies.equals(other.ipPolicies);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.createdAt,
            this.description,
            this.metadata,
            this.enforced,
            this.type,
            this.ipPolicies
        );
    }

    @Override
    public String toString() {
        return "IpRestriction{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', createdAt='" + this.createdAt +
            "', description='" + this.description.orElse("(null)") +
            "', metadata='" + this.metadata.orElse("(null)") +
            "', enforced='" + this.enforced +
            "', type='" + this.type +
            "', ipPolicies='" + this.ipPolicies +
            "'}";
    }
}
