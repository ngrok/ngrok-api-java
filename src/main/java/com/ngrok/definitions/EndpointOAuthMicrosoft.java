/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointOAuthMicrosoft} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointOAuthMicrosoft {
    /**
     * Builder class for {@link EndpointOAuthMicrosoft}.
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
         * the OAuth app client ID. retrieve it from the identity provider&#39;s dashboard
         * where you created your own OAuth app. optional. if unspecified, ngrok will use
         * its own managed oauth application which has additional restrictions. see the
         * OAuth module docs for more details. if present, client_secret must be present as
         * well.
         *
         * @param clientId the value of the <code>client_id</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder clientId(final String clientId) {
            this.clientId = Optional.of(Objects.requireNonNull(clientId, "clientId is required"));
            return this;
        }

        /**
         * the OAuth app client ID. retrieve it from the identity provider&#39;s dashboard
         * where you created your own OAuth app. optional. if unspecified, ngrok will use
         * its own managed oauth application which has additional restrictions. see the
         * OAuth module docs for more details. if present, client_secret must be present as
         * well.
         *
         * @param clientId the value of the <code>client_id</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder clientId(final Optional<String> clientId) {
            this.clientId = Objects.requireNonNull(clientId, "clientId is required");
            return this;
        }

        /**
         * the OAuth app client secret. retrieve if from the identity provider&#39;s
         * dashboard where you created your own OAuth app. optional, see all of the caveats
         * in the docs for <code>client_id</code>.
         *
         * @param clientSecret the value of the <code>client_secret</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder clientSecret(final String clientSecret) {
            this.clientSecret = Optional.of(Objects.requireNonNull(clientSecret, "clientSecret is required"));
            return this;
        }

        /**
         * the OAuth app client secret. retrieve if from the identity provider&#39;s
         * dashboard where you created your own OAuth app. optional, see all of the caveats
         * in the docs for <code>client_id</code>.
         *
         * @param clientSecret the value of the <code>client_secret</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder clientSecret(final Optional<String> clientSecret) {
            this.clientSecret = Objects.requireNonNull(clientSecret, "clientSecret is required");
            return this;
        }

        /**
         * a list of provider-specific OAuth scopes with the permissions your OAuth app
         * would like to ask for. these may not be set if you are using the ngrok-managed
         * oauth app (i.e. you must pass both <code>client_id</code> and
         * <code>client_secret</code> to set scopes)
         *
         * @param scopes the value of the <code>scopes</code> parameter as a {@link java.util.List} of {@link String}
         * @return this builder instance
         */
        public Builder scopes(final java.util.List<String> scopes) {
            this.scopes = Objects.requireNonNull(scopes, "scopes is required");
            return this;
        }

        /**
         * a list of provider-specific OAuth scopes with the permissions your OAuth app
         * would like to ask for. these may not be set if you are using the ngrok-managed
         * oauth app (i.e. you must pass both <code>client_id</code> and
         * <code>client_secret</code> to set scopes)
         *
         * @param scopes the value of the <code>scopes</code> parameter as a {@link java.util.List} of {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder scopes(final Optional<java.util.List<String>> scopes) {
            this.scopes = Objects.requireNonNull(scopes, "scopes is required").orElse(java.util.Collections.emptyList());
            return this;
        }

        /**
         * a list of email addresses of users authenticated by identity provider who are
         * allowed access to the endpoint
         *
         * @param emailAddresses the value of the <code>email_addresses</code> parameter as a {@link java.util.List} of {@link String}
         * @return this builder instance
         */
        public Builder emailAddresses(final java.util.List<String> emailAddresses) {
            this.emailAddresses = Objects.requireNonNull(emailAddresses, "emailAddresses is required");
            return this;
        }

        /**
         * a list of email addresses of users authenticated by identity provider who are
         * allowed access to the endpoint
         *
         * @param emailAddresses the value of the <code>email_addresses</code> parameter as a {@link java.util.List} of {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder emailAddresses(final Optional<java.util.List<String>> emailAddresses) {
            this.emailAddresses = Objects.requireNonNull(emailAddresses, "emailAddresses is required").orElse(java.util.Collections.emptyList());
            return this;
        }

        /**
         * a list of email domains of users authenticated by identity provider who are
         * allowed access to the endpoint
         *
         * @param emailDomains the value of the <code>email_domains</code> parameter as a {@link java.util.List} of {@link String}
         * @return this builder instance
         */
        public Builder emailDomains(final java.util.List<String> emailDomains) {
            this.emailDomains = Objects.requireNonNull(emailDomains, "emailDomains is required");
            return this;
        }

        /**
         * a list of email domains of users authenticated by identity provider who are
         * allowed access to the endpoint
         *
         * @param emailDomains the value of the <code>email_domains</code> parameter as a {@link java.util.List} of {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder emailDomains(final Optional<java.util.List<String>> emailDomains) {
            this.emailDomains = Objects.requireNonNull(emailDomains, "emailDomains is required").orElse(java.util.Collections.emptyList());
            return this;
        }

        /**
         * Constructs the {@link EndpointOAuthMicrosoft} instance.
         *
         * @return a new {@link EndpointOAuthMicrosoft}
         */
        public EndpointOAuthMicrosoft build() {
            return new EndpointOAuthMicrosoft(
                this.clientId,
                this.clientSecret,
                this.scopes,
                this.emailAddresses,
                this.emailDomains
            );
        }
    }

    /**
     * Creates a new builder for the {@link EndpointOAuthMicrosoft} type.
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
     * Creates a new instance of {@link EndpointOAuthMicrosoft}.
     *
     * @param clientId the OAuth app client ID. retrieve it from the identity provider&#39;s dashboard where you created your own OAuth app. optional. if unspecified, ngrok will use its own managed oauth application which has additional restrictions. see the OAuth module docs for more details. if present, client_secret must be present as well.
     * @param clientSecret the OAuth app client secret. retrieve if from the identity provider&#39;s dashboard where you created your own OAuth app. optional, see all of the caveats in the docs for <code>client_id</code>.
     * @param scopes a list of provider-specific OAuth scopes with the permissions your OAuth app would like to ask for. these may not be set if you are using the ngrok-managed oauth app (i.e. you must pass both <code>client_id</code> and <code>client_secret</code> to set scopes)
     * @param emailAddresses a list of email addresses of users authenticated by identity provider who are allowed access to the endpoint
     * @param emailDomains a list of email domains of users authenticated by identity provider who are allowed access to the endpoint
     */
    @JsonCreator
    private EndpointOAuthMicrosoft(
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
     * the OAuth app client ID. retrieve it from the identity provider&#39;s dashboard
     * where you created your own OAuth app. optional. if unspecified, ngrok will use
     * its own managed oauth application which has additional restrictions. see the
     * OAuth module docs for more details. if present, client_secret must be present as
     * well.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getClientId() {
        return this.clientId;
    }

    /**
     * the OAuth app client secret. retrieve if from the identity provider&#39;s
     * dashboard where you created your own OAuth app. optional, see all of the caveats
     * in the docs for <code>client_id</code>.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getClientSecret() {
        return this.clientSecret;
    }

    /**
     * a list of provider-specific OAuth scopes with the permissions your OAuth app
     * would like to ask for. these may not be set if you are using the ngrok-managed
     * oauth app (i.e. you must pass both <code>client_id</code> and
     * <code>client_secret</code> to set scopes)
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getScopes() {
        return this.scopes;
    }

    /**
     * a list of email addresses of users authenticated by identity provider who are
     * allowed access to the endpoint
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getEmailAddresses() {
        return this.emailAddresses;
    }

    /**
     * a list of email domains of users authenticated by identity provider who are
     * allowed access to the endpoint
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
        
        final EndpointOAuthMicrosoft other = (EndpointOAuthMicrosoft) o;
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
        return "EndpointOAuthMicrosoft{" +
            "clientId='" + this.clientId.orElse("(null)") +
            "', clientSecret='" + this.clientSecret.orElse("(null)") +
            "', scopes='" + this.scopes +
            "', emailAddresses='" + this.emailAddresses +
            "', emailDomains='" + this.emailDomains +
            "'}";
    }
}
