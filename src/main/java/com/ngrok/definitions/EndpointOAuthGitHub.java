/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointOAuthGitHub} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointOAuthGitHub {
    /**
     * Builder class for {@link EndpointOAuthGitHub}.
     */
    public static class Builder {
        private Optional<String> clientId = Optional.empty();
        private Optional<String> clientSecret = Optional.empty();
        private Optional<java.util.List<String>> scopes = Optional.empty();
        private Optional<java.util.List<String>> emailAddresses = Optional.empty();
        private Optional<java.util.List<String>> emailDomains = Optional.empty();
        private Optional<java.util.List<String>> teams = Optional.empty();
        private Optional<java.util.List<String>> organizations = Optional.empty();

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
            this.scopes = Optional.of(Objects.requireNonNull(scopes, "scopes is required"));
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
            this.scopes = Objects.requireNonNull(scopes, "scopes is required");
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
            this.emailAddresses = Optional.of(Objects.requireNonNull(emailAddresses, "emailAddresses is required"));
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
            this.emailAddresses = Objects.requireNonNull(emailAddresses, "emailAddresses is required");
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
            this.emailDomains = Optional.of(Objects.requireNonNull(emailDomains, "emailDomains is required"));
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
            this.emailDomains = Objects.requireNonNull(emailDomains, "emailDomains is required");
            return this;
        }

        /**
         * a list of github teams identifiers. users will be allowed access to the endpoint
         * if they are a member of any of these teams. identifiers should be in the
         * &#39;slug&#39; format qualified with the org name, e.g.
         * <code>org-name/team-name</code>
         *
         * @param teams the value of the <code>teams</code> parameter as a {@link java.util.List} of {@link String}
         * @return this builder instance
         */
        public Builder teams(final java.util.List<String> teams) {
            this.teams = Optional.of(Objects.requireNonNull(teams, "teams is required"));
            return this;
        }

        /**
         * a list of github teams identifiers. users will be allowed access to the endpoint
         * if they are a member of any of these teams. identifiers should be in the
         * &#39;slug&#39; format qualified with the org name, e.g.
         * <code>org-name/team-name</code>
         *
         * @param teams the value of the <code>teams</code> parameter as a {@link java.util.List} of {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder teams(final Optional<java.util.List<String>> teams) {
            this.teams = Objects.requireNonNull(teams, "teams is required");
            return this;
        }

        /**
         * a list of github org identifiers. users who are members of any of the listed
         * organizations will be allowed access. identifiers should be the
         * organization&#39;s &#39;slug&#39;
         *
         * @param organizations the value of the <code>organizations</code> parameter as a {@link java.util.List} of {@link String}
         * @return this builder instance
         */
        public Builder organizations(final java.util.List<String> organizations) {
            this.organizations = Optional.of(Objects.requireNonNull(organizations, "organizations is required"));
            return this;
        }

        /**
         * a list of github org identifiers. users who are members of any of the listed
         * organizations will be allowed access. identifiers should be the
         * organization&#39;s &#39;slug&#39;
         *
         * @param organizations the value of the <code>organizations</code> parameter as a {@link java.util.List} of {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder organizations(final Optional<java.util.List<String>> organizations) {
            this.organizations = Objects.requireNonNull(organizations, "organizations is required");
            return this;
        }

        /**
         * Constructs the {@link EndpointOAuthGitHub} instance.
         *
         * @return a new {@link EndpointOAuthGitHub}
         */
        public EndpointOAuthGitHub build() {
            return new EndpointOAuthGitHub(
                this.clientId,
                this.clientSecret,
                this.scopes,
                this.emailAddresses,
                this.emailDomains,
                this.teams,
                this.organizations
            );
        }
    }

    /**
     * Creates a new builder for the {@link EndpointOAuthGitHub} type.
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
    private final Optional<java.util.List<String>> scopes;
    @JsonProperty("email_addresses")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.util.List<String>> emailAddresses;
    @JsonProperty("email_domains")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.util.List<String>> emailDomains;
    @JsonProperty("teams")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.util.List<String>> teams;
    @JsonProperty("organizations")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.util.List<String>> organizations;

    /**
     * Creates a new instance of {@link EndpointOAuthGitHub}.
     *
     * @param clientId the OAuth app client ID. retrieve it from the identity provider&#39;s dashboard where you created your own OAuth app. optional. if unspecified, ngrok will use its own managed oauth application which has additional restrictions. see the OAuth module docs for more details. if present, client_secret must be present as well.
     * @param clientSecret the OAuth app client secret. retrieve if from the identity provider&#39;s dashboard where you created your own OAuth app. optional, see all of the caveats in the docs for <code>client_id</code>.
     * @param scopes a list of provider-specific OAuth scopes with the permissions your OAuth app would like to ask for. these may not be set if you are using the ngrok-managed oauth app (i.e. you must pass both <code>client_id</code> and <code>client_secret</code> to set scopes)
     * @param emailAddresses a list of email addresses of users authenticated by identity provider who are allowed access to the endpoint
     * @param emailDomains a list of email domains of users authenticated by identity provider who are allowed access to the endpoint
     * @param teams a list of github teams identifiers. users will be allowed access to the endpoint if they are a member of any of these teams. identifiers should be in the &#39;slug&#39; format qualified with the org name, e.g. <code>org-name/team-name</code>
     * @param organizations a list of github org identifiers. users who are members of any of the listed organizations will be allowed access. identifiers should be the organization&#39;s &#39;slug&#39;
     */
    @JsonCreator
    private EndpointOAuthGitHub(
        @JsonProperty("client_id") final Optional<String> clientId,
        @JsonProperty("client_secret") final Optional<String> clientSecret,
        @JsonProperty("scopes") final Optional<java.util.List<String>> scopes,
        @JsonProperty("email_addresses") final Optional<java.util.List<String>> emailAddresses,
        @JsonProperty("email_domains") final Optional<java.util.List<String>> emailDomains,
        @JsonProperty("teams") final Optional<java.util.List<String>> teams,
        @JsonProperty("organizations") final Optional<java.util.List<String>> organizations
    ) {
        this.clientId = clientId != null ? clientId : Optional.empty();
        this.clientSecret = clientSecret != null ? clientSecret : Optional.empty();
        this.scopes = scopes != null ? scopes : Optional.empty();
        this.emailAddresses = emailAddresses != null ? emailAddresses : Optional.empty();
        this.emailDomains = emailDomains != null ? emailDomains : Optional.empty();
        this.teams = teams != null ? teams : Optional.empty();
        this.organizations = organizations != null ? organizations : Optional.empty();
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
     * @return the value of the property as a {@link java.util.List} of {@link String} wrapped in an {@link Optional}
     */
    public Optional<java.util.List<String>> getScopes() {
        return this.scopes;
    }

    /**
     * a list of email addresses of users authenticated by identity provider who are
     * allowed access to the endpoint
     *
     * @return the value of the property as a {@link java.util.List} of {@link String} wrapped in an {@link Optional}
     */
    public Optional<java.util.List<String>> getEmailAddresses() {
        return this.emailAddresses;
    }

    /**
     * a list of email domains of users authenticated by identity provider who are
     * allowed access to the endpoint
     *
     * @return the value of the property as a {@link java.util.List} of {@link String} wrapped in an {@link Optional}
     */
    public Optional<java.util.List<String>> getEmailDomains() {
        return this.emailDomains;
    }

    /**
     * a list of github teams identifiers. users will be allowed access to the endpoint
     * if they are a member of any of these teams. identifiers should be in the
     * &#39;slug&#39; format qualified with the org name, e.g.
     * <code>org-name/team-name</code>
     *
     * @return the value of the property as a {@link java.util.List} of {@link String} wrapped in an {@link Optional}
     */
    public Optional<java.util.List<String>> getTeams() {
        return this.teams;
    }

    /**
     * a list of github org identifiers. users who are members of any of the listed
     * organizations will be allowed access. identifiers should be the
     * organization&#39;s &#39;slug&#39;
     *
     * @return the value of the property as a {@link java.util.List} of {@link String} wrapped in an {@link Optional}
     */
    public Optional<java.util.List<String>> getOrganizations() {
        return this.organizations;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointOAuthGitHub other = (EndpointOAuthGitHub) o;
        return
            this.clientId.equals(other.clientId)&&
            this.clientSecret.equals(other.clientSecret)&&
            this.scopes.equals(other.scopes)&&
            this.emailAddresses.equals(other.emailAddresses)&&
            this.emailDomains.equals(other.emailDomains)&&
            this.teams.equals(other.teams)&&
            this.organizations.equals(other.organizations);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.clientId,
            this.clientSecret,
            this.scopes,
            this.emailAddresses,
            this.emailDomains,
            this.teams,
            this.organizations
        );
    }

    @Override
    public String toString() {
        return "EndpointOAuthGitHub{" +
            "clientId='" + this.clientId.orElse("(null)") +
            "', clientSecret='" + this.clientSecret.orElse("(null)") +
            "', scopes='" + this.scopes.map(Object::toString).orElse("(null)") +
            "', emailAddresses='" + this.emailAddresses.map(Object::toString).orElse("(null)") +
            "', emailDomains='" + this.emailDomains.map(Object::toString).orElse("(null)") +
            "', teams='" + this.teams.map(Object::toString).orElse("(null)") +
            "', organizations='" + this.organizations.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
