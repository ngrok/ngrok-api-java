/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link ApplicationUser} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationUser {
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String id;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("identity_provider")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final IdentityProvider identityProvider;
    @JsonProperty("provider_user_id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String providerUserId;
    @JsonProperty("username")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> username;
    @JsonProperty("email")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> email;
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> name;
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.time.OffsetDateTime> createdAt;
    @JsonProperty("last_active")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.time.OffsetDateTime> lastActive;
    @JsonProperty("last_login")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.time.OffsetDateTime> lastLogin;

    /**
     * Creates a new instance of {@link ApplicationUser}.
     *
     * @param id unique application user resource identifier
     * @param uri URI of the application user API resource
     * @param identityProvider identity provider that the user authenticated with
     * @param providerUserId unique user identifier
     * @param username user username
     * @param email user email
     * @param name user common name
     * @param createdAt timestamp when the user was created in RFC 3339 format
     * @param lastActive timestamp when the user was last active in RFC 3339 format
     * @param lastLogin timestamp when the user last signed-in in RFC 3339 format
     */
    @JsonCreator
    public ApplicationUser(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("identity_provider") final IdentityProvider identityProvider,
        @JsonProperty("provider_user_id") final String providerUserId,
        @JsonProperty("username") final Optional<String> username,
        @JsonProperty("email") final Optional<String> email,
        @JsonProperty("name") final Optional<String> name,
        @JsonProperty("created_at") final Optional<java.time.OffsetDateTime> createdAt,
        @JsonProperty("last_active") final Optional<java.time.OffsetDateTime> lastActive,
        @JsonProperty("last_login") final Optional<java.time.OffsetDateTime> lastLogin
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.identityProvider = Objects.requireNonNull(identityProvider, "identityProvider is required");
        this.providerUserId = Objects.requireNonNull(providerUserId, "providerUserId is required");
        this.username = username != null ? username : Optional.empty();
        this.email = email != null ? email : Optional.empty();
        this.name = name != null ? name : Optional.empty();
        this.createdAt = createdAt != null ? createdAt : Optional.empty();
        this.lastActive = lastActive != null ? lastActive : Optional.empty();
        this.lastLogin = lastLogin != null ? lastLogin : Optional.empty();
    }

    /**
     * unique application user resource identifier
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of the application user API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * identity provider that the user authenticated with
     *
     * @return the value of the property as a {@link IdentityProvider}
     */
    public IdentityProvider getIdentityProvider() {
        return this.identityProvider;
    }

    /**
     * unique user identifier
     *
     * @return the value of the property as a {@link String}
     */
    public String getProviderUserId() {
        return this.providerUserId;
    }

    /**
     * user username
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getUsername() {
        return this.username;
    }

    /**
     * user email
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getEmail() {
        return this.email;
    }

    /**
     * user common name
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getName() {
        return this.name;
    }

    /**
     * timestamp when the user was created in RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime} wrapped in an {@link Optional}
     */
    public Optional<java.time.OffsetDateTime> getCreatedAt() {
        return this.createdAt;
    }

    /**
     * timestamp when the user was last active in RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime} wrapped in an {@link Optional}
     */
    public Optional<java.time.OffsetDateTime> getLastActive() {
        return this.lastActive;
    }

    /**
     * timestamp when the user last signed-in in RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime} wrapped in an {@link Optional}
     */
    public Optional<java.time.OffsetDateTime> getLastLogin() {
        return this.lastLogin;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final ApplicationUser other = (ApplicationUser) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.identityProvider.equals(other.identityProvider)&&
            this.providerUserId.equals(other.providerUserId)&&
            this.username.equals(other.username)&&
            this.email.equals(other.email)&&
            this.name.equals(other.name)&&
            this.createdAt.equals(other.createdAt)&&
            this.lastActive.equals(other.lastActive)&&
            this.lastLogin.equals(other.lastLogin);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.identityProvider,
            this.providerUserId,
            this.username,
            this.email,
            this.name,
            this.createdAt,
            this.lastActive,
            this.lastLogin
        );
    }

    @Override
    public String toString() {
        return "ApplicationUser{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', identityProvider='" + this.identityProvider +
            "', providerUserId='" + this.providerUserId +
            "', username='" + this.username.orElse("(null)") +
            "', email='" + this.email.orElse("(null)") +
            "', name='" + this.name.orElse("(null)") +
            "', createdAt='" + this.createdAt.map(Object::toString).orElse("(null)") +
            "', lastActive='" + this.lastActive.map(Object::toString).orElse("(null)") +
            "', lastLogin='" + this.lastLogin.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
