package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link SshCredential} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SshCredential {
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
    @JsonProperty("acl")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> acl;
    @JsonProperty("owner_id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> ownerId;

    /**
     * Creates a new instance of {@link SshCredential}.
     *
     * @param id unique ssh credential resource identifier
     * @param uri URI of the ssh credential API resource
     * @param createdAt timestamp when the ssh credential was created, RFC 3339 format
     * @param description human-readable description of who or what will use the ssh credential to authenticate. Optional, max 255 bytes.
     * @param metadata arbitrary user-defined machine-readable data of this ssh credential. Optional, max 4096 bytes.
     * @param publicKey the PEM-encoded public key of the SSH keypair that will be used to authenticate
     * @param acl optional list of ACL rules. If unspecified, the credential will have no restrictions. The only allowed ACL rule at this time is the <code>bind</code> rule. The <code>bind</code> rule allows the caller to restrict what domains, addresses, and labels the token is allowed to bind. For example, to allow the token to open a tunnel on example.ngrok.io your ACL would include the rule <code>bind:example.ngrok.io</code>. Bind rules for domains may specify a leading wildcard to match multiple domains with a common suffix. For example, you may specify a rule of <code>bind:*.example.com</code> which will allow <code>x.example.com</code>, <code>y.example.com</code>, <code>*.example.com</code>, etc. Bind rules for labels may specify a wildcard key and/or value to match multiple labels. For example, you may specify a rule of <code>bind:*=example</code> which will allow <code>x=example</code>, <code>y=example</code>, etc. A rule of <code>&#39;*&#39;</code> is equivalent to no acl at all and will explicitly permit all actions.
     * @param ownerId If supplied at credential creation, ownership will be assigned to the specified User or Bot. Only admins may specify an owner other than themselves. Defaults to the authenticated User or Bot.
     */
    @JsonCreator
    public SshCredential(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("description") final String description,
        @JsonProperty("metadata") final String metadata,
        @JsonProperty("public_key") final String publicKey,
        @JsonProperty("acl") final java.util.List<String> acl,
        @JsonProperty("owner_id") final Optional<String> ownerId
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.description = Objects.requireNonNull(description, "description is required");
        this.metadata = Objects.requireNonNull(metadata, "metadata is required");
        this.publicKey = Objects.requireNonNull(publicKey, "publicKey is required");
        this.acl = acl != null ? acl : java.util.Collections.emptyList();
        this.ownerId = ownerId != null ? ownerId : Optional.empty();
    }

    /**
     * unique ssh credential resource identifier
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of the ssh credential API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * timestamp when the ssh credential was created, RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * human-readable description of who or what will use the ssh credential to
     * authenticate. Optional, max 255 bytes.
     *
     * @return the value of the property as a {@link String}
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * arbitrary user-defined machine-readable data of this ssh credential. Optional,
     * max 4096 bytes.
     *
     * @return the value of the property as a {@link String}
     */
    public String getMetadata() {
        return this.metadata;
    }

    /**
     * the PEM-encoded public key of the SSH keypair that will be used to authenticate
     *
     * @return the value of the property as a {@link String}
     */
    public String getPublicKey() {
        return this.publicKey;
    }

    /**
     * optional list of ACL rules. If unspecified, the credential will have no
     * restrictions. The only allowed ACL rule at this time is the <code>bind</code>
     * rule. The <code>bind</code> rule allows the caller to restrict what domains,
     * addresses, and labels the token is allowed to bind. For example, to allow the
     * token to open a tunnel on example.ngrok.io your ACL would include the rule
     * <code>bind:example.ngrok.io</code>. Bind rules for domains may specify a leading
     * wildcard to match multiple domains with a common suffix. For example, you may
     * specify a rule of <code>bind:*.example.com</code> which will allow
     * <code>x.example.com</code>, <code>y.example.com</code>,
     * <code>*.example.com</code>, etc. Bind rules for labels may specify a wildcard
     * key and/or value to match multiple labels. For example, you may specify a rule
     * of <code>bind:*=example</code> which will allow <code>x=example</code>,
     * <code>y=example</code>, etc. A rule of <code>&#39;*&#39;</code> is equivalent to
     * no acl at all and will explicitly permit all actions.
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getAcl() {
        return this.acl;
    }

    /**
     * If supplied at credential creation, ownership will be assigned to the specified
     * User or Bot. Only admins may specify an owner other than themselves. Defaults to
     * the authenticated User or Bot.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getOwnerId() {
        return this.ownerId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final SshCredential other = (SshCredential) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.createdAt.equals(other.createdAt)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.publicKey.equals(other.publicKey)&&
            this.acl.equals(other.acl)&&
            this.ownerId.equals(other.ownerId);
        
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
            this.acl,
            this.ownerId
        );
    }

    @Override
    public String toString() {
        return "SshCredential{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', createdAt='" + this.createdAt +
            "', description='" + this.description +
            "', metadata='" + this.metadata +
            "', publicKey='" + this.publicKey +
            "', acl='" + this.acl +
            "', ownerId='" + this.ownerId.orElse("(null)") +
            "'}";
    }
}
