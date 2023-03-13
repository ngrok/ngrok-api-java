package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointOAuthAmazon} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointOAuthAmazon {
    /**
     * Builder class for {@link EndpointOAuthAmazon}.
     */
    public static class Builder {
        private Optional<String> clientId = Optional.empty();
        private Optional<String> clientSecret = Optional.empty();
        private java.util.List<String> scopes = java.util.Collections.emptyList();
        private java.util.List<String> emailAddresses = java.util.Collections.emptyList();
        private java.util.List<String> emailDomains = java.util.Collections.emptyList();

        private Builder(
        ) {
        }

        /**
         * Sets the client_id property
         *
         * @param clientId the value of the <code>client_id</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder clientId(final String clientId) {
            this.clientId = Optional.of(Objects.requireNonNull(clientId, "clientId is required"));
            return this;
        }

        /**
         * Sets the client_id property
         *
         * @param clientId the value of the <code>client_id</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder clientId(final Optional<String> clientId) {
            this.clientId = Objects.requireNonNull(clientId, "clientId is required");
            return this;
        }

        /**
         * Sets the client_secret property
         *
         * @param clientSecret the value of the <code>client_secret</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder clientSecret(final String clientSecret) {
            this.clientSecret = Optional.of(Objects.requireNonNull(clientSecret, "clientSecret is required"));
            return this;
        }

        /**
         * Sets the client_secret property
         *
         * @param clientSecret the value of the <code>client_secret</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder clientSecret(final Optional<String> clientSecret) {
            this.clientSecret = Objects.requireNonNull(clientSecret, "clientSecret is required");
            return this;
        }

        /**
         * Sets the scopes property
         *
         * @param scopes the value of the <code>scopes</code> parameter as a {@link java.util.List} of {@link String}
         * @return this builder instance
         */
        public Builder scopes(final java.util.List<String> scopes) {
            this.scopes = Objects.requireNonNull(scopes, "scopes is required");
            return this;
        }

        /**
         * Sets the scopes property
         *
         * @param scopes the value of the <code>scopes</code> parameter as a {@link java.util.List} of {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder scopes(final Optional<java.util.List<String>> scopes) {
            this.scopes = Objects.requireNonNull(scopes, "scopes is required").orElse(java.util.Collections.emptyList());
            return this;
        }

        /**
         * Sets the email_addresses property
         *
         * @param emailAddresses the value of the <code>email_addresses</code> parameter as a {@link java.util.List} of {@link String}
         * @return this builder instance
         */
        public Builder emailAddresses(final java.util.List<String> emailAddresses) {
            this.emailAddresses = Objects.requireNonNull(emailAddresses, "emailAddresses is required");
            return this;
        }

        /**
         * Sets the email_addresses property
         *
         * @param emailAddresses the value of the <code>email_addresses</code> parameter as a {@link java.util.List} of {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder emailAddresses(final Optional<java.util.List<String>> emailAddresses) {
            this.emailAddresses = Objects.requireNonNull(emailAddresses, "emailAddresses is required").orElse(java.util.Collections.emptyList());
            return this;
        }

        /**
         * Sets the email_domains property
         *
         * @param emailDomains the value of the <code>email_domains</code> parameter as a {@link java.util.List} of {@link String}
         * @return this builder instance
         */
        public Builder emailDomains(final java.util.List<String> emailDomains) {
            this.emailDomains = Objects.requireNonNull(emailDomains, "emailDomains is required");
            return this;
        }

        /**
         * Sets the email_domains property
         *
         * @param emailDomains the value of the <code>email_domains</code> parameter as a {@link java.util.List} of {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder emailDomains(final Optional<java.util.List<String>> emailDomains) {
            this.emailDomains = Objects.requireNonNull(emailDomains, "emailDomains is required").orElse(java.util.Collections.emptyList());
            return this;
        }

        /**
         * Constructs the {@link EndpointOAuthAmazon} instance.
         *
         * @return a new {@link EndpointOAuthAmazon}
         */
        public EndpointOAuthAmazon build() {
            return new EndpointOAuthAmazon(
                this.clientId,
                this.clientSecret,
                this.scopes,
                this.emailAddresses,
                this.emailDomains
            );
        }
    }

    /**
     * Creates a new builder for the {@link EndpointOAuthAmazon} type.
     *
     * @return a new {@link Builder}
     */
    public static Builder newBuilder(
    ) {
        return new Builder (
        );
    }

    @JsonProperty("client_id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> clientId;
    @JsonProperty("client_secret")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> clientSecret;
    @JsonProperty("scopes")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> scopes;
    @JsonProperty("email_addresses")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> emailAddresses;
    @JsonProperty("email_domains")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> emailDomains;

    /**
     * Creates a new instance of {@link EndpointOAuthAmazon}.
     *
     * @param clientId the value of the <code>client_id</code> parameter as a {@link String}
     * @param clientSecret the value of the <code>client_secret</code> parameter as a {@link String}
     * @param scopes the value of the <code>scopes</code> parameter as a {@link java.util.List} of {@link String}
     * @param emailAddresses the value of the <code>email_addresses</code> parameter as a {@link java.util.List} of {@link String}
     * @param emailDomains the value of the <code>email_domains</code> parameter as a {@link java.util.List} of {@link String}
     */
    @JsonCreator
    private EndpointOAuthAmazon(
        @JsonProperty("client_id") final Optional<String> clientId,
        @JsonProperty("client_secret") final Optional<String> clientSecret,
        @JsonProperty("scopes") final java.util.List<String> scopes,
        @JsonProperty("email_addresses") final java.util.List<String> emailAddresses,
        @JsonProperty("email_domains") final java.util.List<String> emailDomains
    ) {
        this.clientId = clientId != null ? clientId : Optional.empty();
        this.clientSecret = clientSecret != null ? clientSecret : Optional.empty();
        this.scopes = scopes != null ? scopes : java.util.Collections.emptyList();
        this.emailAddresses = emailAddresses != null ? emailAddresses : java.util.Collections.emptyList();
        this.emailDomains = emailDomains != null ? emailDomains : java.util.Collections.emptyList();
    }

    /**
     * Fetches the value of the <code>clientId</code> property.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getClientId() {
        return this.clientId;
    }

    /**
     * Fetches the value of the <code>clientSecret</code> property.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getClientSecret() {
        return this.clientSecret;
    }

    /**
     * Fetches the value of the <code>scopes</code> property.
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getScopes() {
        return this.scopes;
    }

    /**
     * Fetches the value of the <code>emailAddresses</code> property.
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getEmailAddresses() {
        return this.emailAddresses;
    }

    /**
     * Fetches the value of the <code>emailDomains</code> property.
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getEmailDomains() {
        return this.emailDomains;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointOAuthAmazon other = (EndpointOAuthAmazon) o;
        return
            this.clientId.equals(other.clientId)&&
            this.clientSecret.equals(other.clientSecret)&&
            this.scopes.equals(other.scopes)&&
            this.emailAddresses.equals(other.emailAddresses)&&
            this.emailDomains.equals(other.emailDomains);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.clientId,
            this.clientSecret,
            this.scopes,
            this.emailAddresses,
            this.emailDomains
        );
    }

    @Override
    public String toString() {
        return "EndpointOAuthAmazon{" +
            "clientId='" + this.clientId.orElse("(null)") +
            "', clientSecret='" + this.clientSecret.orElse("(null)") +
            "', scopes='" + this.scopes +
            "', emailAddresses='" + this.emailAddresses +
            "', emailDomains='" + this.emailDomains +
            "'}";
    }
}
