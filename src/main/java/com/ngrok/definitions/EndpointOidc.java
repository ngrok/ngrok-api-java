package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointOidc} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointOidc {
    /**
     * Builder class for {@link EndpointOidc}.
     */
    public static class Builder {
        private Optional<Boolean> enabled = Optional.empty();
        private Optional<Boolean> optionsPassthrough = Optional.empty();
        private Optional<String> cookiePrefix = Optional.empty();
        private Optional<Long> inactivityTimeout = Optional.empty();
        private Optional<java.time.Duration> maximumDuration = Optional.empty();
        private Optional<String> issuer = Optional.empty();
        private Optional<String> clientId = Optional.empty();
        private Optional<String> clientSecret = Optional.empty();
        private java.util.List<String> scopes = java.util.Collections.emptyList();

        private Builder(
        ) {
        }

        /**
         * <code>true</code> if the module will be applied to traffic, <code>false</code>
         * to disable. default <code>true</code> if unspecified
         *
         * @param enabled the value of the <code>enabled</code> parameter as a {@link boolean}
         * @return this builder instance
         */
        public Builder enabled(final boolean enabled) {
            this.enabled = Optional.of(Objects.requireNonNull(enabled, "enabled is required"));
            return this;
        }

        /**
         * <code>true</code> if the module will be applied to traffic, <code>false</code>
         * to disable. default <code>true</code> if unspecified
         *
         * @param enabled the value of the <code>enabled</code> parameter as a {@link boolean}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder enabled(final Optional<Boolean> enabled) {
            this.enabled = Objects.requireNonNull(enabled, "enabled is required");
            return this;
        }

        /**
         * Do not enforce authentication on HTTP OPTIONS requests. necessary if you are
         * supporting CORS.
         *
         * @param optionsPassthrough the value of the <code>options_passthrough</code> parameter as a {@link boolean}
         * @return this builder instance
         */
        public Builder optionsPassthrough(final boolean optionsPassthrough) {
            this.optionsPassthrough = Optional.of(Objects.requireNonNull(optionsPassthrough, "optionsPassthrough is required"));
            return this;
        }

        /**
         * Do not enforce authentication on HTTP OPTIONS requests. necessary if you are
         * supporting CORS.
         *
         * @param optionsPassthrough the value of the <code>options_passthrough</code> parameter as a {@link boolean}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder optionsPassthrough(final Optional<Boolean> optionsPassthrough) {
            this.optionsPassthrough = Objects.requireNonNull(optionsPassthrough, "optionsPassthrough is required");
            return this;
        }

        /**
         * the prefix of the session cookie that ngrok sets on the http client to cache
         * authentication. default is &#39;ngrok.&#39;
         *
         * @param cookiePrefix the value of the <code>cookie_prefix</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder cookiePrefix(final String cookiePrefix) {
            this.cookiePrefix = Optional.of(Objects.requireNonNull(cookiePrefix, "cookiePrefix is required"));
            return this;
        }

        /**
         * the prefix of the session cookie that ngrok sets on the http client to cache
         * authentication. default is &#39;ngrok.&#39;
         *
         * @param cookiePrefix the value of the <code>cookie_prefix</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder cookiePrefix(final Optional<String> cookiePrefix) {
            this.cookiePrefix = Objects.requireNonNull(cookiePrefix, "cookiePrefix is required");
            return this;
        }

        /**
         * Integer number of seconds of inactivity after which if the user has not accessed
         * the endpoint, their session will time out and they will be forced to
         * reauthenticate.
         *
         * @param inactivityTimeout the value of the <code>inactivity_timeout</code> parameter as a {@link long}
         * @return this builder instance
         */
        public Builder inactivityTimeout(final long inactivityTimeout) {
            this.inactivityTimeout = Optional.of(Objects.requireNonNull(inactivityTimeout, "inactivityTimeout is required"));
            return this;
        }

        /**
         * Integer number of seconds of inactivity after which if the user has not accessed
         * the endpoint, their session will time out and they will be forced to
         * reauthenticate.
         *
         * @param inactivityTimeout the value of the <code>inactivity_timeout</code> parameter as a {@link long}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder inactivityTimeout(final Optional<Long> inactivityTimeout) {
            this.inactivityTimeout = Objects.requireNonNull(inactivityTimeout, "inactivityTimeout is required");
            return this;
        }

        /**
         * Integer number of seconds of the maximum duration of an authenticated session.
         * After this period is exceeded, a user must reauthenticate.
         *
         * @param maximumDuration the value of the <code>maximum_duration</code> parameter as a {@link java.time.Duration}
         * @return this builder instance
         */
        public Builder maximumDuration(final java.time.Duration maximumDuration) {
            this.maximumDuration = Optional.of(Objects.requireNonNull(maximumDuration, "maximumDuration is required"));
            return this;
        }

        /**
         * Integer number of seconds of the maximum duration of an authenticated session.
         * After this period is exceeded, a user must reauthenticate.
         *
         * @param maximumDuration the value of the <code>maximum_duration</code> parameter as a {@link java.time.Duration}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder maximumDuration(final Optional<java.time.Duration> maximumDuration) {
            this.maximumDuration = Objects.requireNonNull(maximumDuration, "maximumDuration is required");
            return this;
        }

        /**
         * URL of the OIDC &#34;OpenID provider&#34;. This is the base URL used for
         * discovery.
         *
         * @param issuer the value of the <code>issuer</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder issuer(final String issuer) {
            this.issuer = Optional.of(Objects.requireNonNull(issuer, "issuer is required"));
            return this;
        }

        /**
         * URL of the OIDC &#34;OpenID provider&#34;. This is the base URL used for
         * discovery.
         *
         * @param issuer the value of the <code>issuer</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder issuer(final Optional<String> issuer) {
            this.issuer = Objects.requireNonNull(issuer, "issuer is required");
            return this;
        }

        /**
         * The OIDC app&#39;s client ID and OIDC audience.
         *
         * @param clientId the value of the <code>client_id</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder clientId(final String clientId) {
            this.clientId = Optional.of(Objects.requireNonNull(clientId, "clientId is required"));
            return this;
        }

        /**
         * The OIDC app&#39;s client ID and OIDC audience.
         *
         * @param clientId the value of the <code>client_id</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder clientId(final Optional<String> clientId) {
            this.clientId = Objects.requireNonNull(clientId, "clientId is required");
            return this;
        }

        /**
         * The OIDC app&#39;s client secret.
         *
         * @param clientSecret the value of the <code>client_secret</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder clientSecret(final String clientSecret) {
            this.clientSecret = Optional.of(Objects.requireNonNull(clientSecret, "clientSecret is required"));
            return this;
        }

        /**
         * The OIDC app&#39;s client secret.
         *
         * @param clientSecret the value of the <code>client_secret</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder clientSecret(final Optional<String> clientSecret) {
            this.clientSecret = Objects.requireNonNull(clientSecret, "clientSecret is required");
            return this;
        }

        /**
         * The set of scopes to request from the OIDC identity provider.
         *
         * @param scopes the value of the <code>scopes</code> parameter as a {@link java.util.List} of {@link String}
         * @return this builder instance
         */
        public Builder scopes(final java.util.List<String> scopes) {
            this.scopes = Objects.requireNonNull(scopes, "scopes is required");
            return this;
        }

        /**
         * The set of scopes to request from the OIDC identity provider.
         *
         * @param scopes the value of the <code>scopes</code> parameter as a {@link java.util.List} of {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder scopes(final Optional<java.util.List<String>> scopes) {
            this.scopes = Objects.requireNonNull(scopes, "scopes is required").orElse(java.util.Collections.emptyList());
            return this;
        }

        /**
         * Constructs the {@link EndpointOidc} instance.
         *
         * @return a new {@link EndpointOidc}
         */
        public EndpointOidc build() {
            return new EndpointOidc(
                this.enabled,
                this.optionsPassthrough.orElse(false),
                this.cookiePrefix.orElse(""),
                this.inactivityTimeout.orElse(0L),
                this.maximumDuration.orElse(java.time.Duration.ZERO),
                this.issuer.orElse(""),
                this.clientId.orElse(""),
                this.clientSecret.orElse(""),
                this.scopes
            );
        }
    }

    /**
     * Creates a new builder for the {@link EndpointOidc} type.
     *
     * @return a new {@link Builder}
     */
    public static Builder newBuilder(
    ) {
        return new Builder (
        );
    }

    @JsonProperty("enabled")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Boolean> enabled;
    @JsonProperty("options_passthrough")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final boolean optionsPassthrough;
    @JsonProperty("cookie_prefix")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String cookiePrefix;
    @JsonProperty("inactivity_timeout")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final long inactivityTimeout;
    @JsonProperty("maximum_duration")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.Duration maximumDuration;
    @JsonProperty("issuer")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String issuer;
    @JsonProperty("client_id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String clientId;
    @JsonProperty("client_secret")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String clientSecret;
    @JsonProperty("scopes")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> scopes;

    /**
     * Creates a new instance of {@link EndpointOidc}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param optionsPassthrough Do not enforce authentication on HTTP OPTIONS requests. necessary if you are supporting CORS.
     * @param cookiePrefix the prefix of the session cookie that ngrok sets on the http client to cache authentication. default is &#39;ngrok.&#39;
     * @param inactivityTimeout Integer number of seconds of inactivity after which if the user has not accessed the endpoint, their session will time out and they will be forced to reauthenticate.
     * @param maximumDuration Integer number of seconds of the maximum duration of an authenticated session. After this period is exceeded, a user must reauthenticate.
     * @param issuer URL of the OIDC &#34;OpenID provider&#34;. This is the base URL used for discovery.
     * @param clientId The OIDC app&#39;s client ID and OIDC audience.
     * @param clientSecret The OIDC app&#39;s client secret.
     * @param scopes The set of scopes to request from the OIDC identity provider.
     */
    @JsonCreator
    private EndpointOidc(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("options_passthrough") final Boolean optionsPassthrough,
        @JsonProperty("cookie_prefix") final String cookiePrefix,
        @JsonProperty("inactivity_timeout") final Long inactivityTimeout,
        @JsonProperty("maximum_duration") final java.time.Duration maximumDuration,
        @JsonProperty("issuer") final String issuer,
        @JsonProperty("client_id") final String clientId,
        @JsonProperty("client_secret") final String clientSecret,
        @JsonProperty("scopes") final java.util.List<String> scopes
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
        this.optionsPassthrough = Objects.requireNonNull(optionsPassthrough, "optionsPassthrough is required");
        this.cookiePrefix = Objects.requireNonNull(cookiePrefix, "cookiePrefix is required");
        this.inactivityTimeout = Objects.requireNonNull(inactivityTimeout, "inactivityTimeout is required");
        this.maximumDuration = Objects.requireNonNull(maximumDuration, "maximumDuration is required");
        this.issuer = Objects.requireNonNull(issuer, "issuer is required");
        this.clientId = Objects.requireNonNull(clientId, "clientId is required");
        this.clientSecret = Objects.requireNonNull(clientSecret, "clientSecret is required");
        this.scopes = scopes != null ? scopes : java.util.Collections.emptyList();
    }

    /**
     * <code>true</code> if the module will be applied to traffic, <code>false</code>
     * to disable. default <code>true</code> if unspecified
     *
     * @return the value of the property as a {@link boolean} wrapped in an {@link Optional}
     */
    public Optional<Boolean> getEnabled() {
        return this.enabled;
    }

    /**
     * Do not enforce authentication on HTTP OPTIONS requests. necessary if you are
     * supporting CORS.
     *
     * @return the value of the property as a {@link boolean}
     */
    public boolean getOptionsPassthrough() {
        return this.optionsPassthrough;
    }

    /**
     * the prefix of the session cookie that ngrok sets on the http client to cache
     * authentication. default is &#39;ngrok.&#39;
     *
     * @return the value of the property as a {@link String}
     */
    public String getCookiePrefix() {
        return this.cookiePrefix;
    }

    /**
     * Integer number of seconds of inactivity after which if the user has not accessed
     * the endpoint, their session will time out and they will be forced to
     * reauthenticate.
     *
     * @return the value of the property as a {@link long}
     */
    public long getInactivityTimeout() {
        return this.inactivityTimeout;
    }

    /**
     * Integer number of seconds of the maximum duration of an authenticated session.
     * After this period is exceeded, a user must reauthenticate.
     *
     * @return the value of the property as a {@link java.time.Duration}
     */
    public java.time.Duration getMaximumDuration() {
        return this.maximumDuration;
    }

    /**
     * URL of the OIDC &#34;OpenID provider&#34;. This is the base URL used for
     * discovery.
     *
     * @return the value of the property as a {@link String}
     */
    public String getIssuer() {
        return this.issuer;
    }

    /**
     * The OIDC app&#39;s client ID and OIDC audience.
     *
     * @return the value of the property as a {@link String}
     */
    public String getClientId() {
        return this.clientId;
    }

    /**
     * The OIDC app&#39;s client secret.
     *
     * @return the value of the property as a {@link String}
     */
    public String getClientSecret() {
        return this.clientSecret;
    }

    /**
     * The set of scopes to request from the OIDC identity provider.
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getScopes() {
        return this.scopes;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointOidc other = (EndpointOidc) o;
        return
            this.enabled.equals(other.enabled)&&
            this.optionsPassthrough == other.optionsPassthrough&&
            this.cookiePrefix.equals(other.cookiePrefix)&&
            this.inactivityTimeout == other.inactivityTimeout&&
            this.maximumDuration == other.maximumDuration&&
            this.issuer.equals(other.issuer)&&
            this.clientId.equals(other.clientId)&&
            this.clientSecret.equals(other.clientSecret)&&
            this.scopes.equals(other.scopes);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.enabled,
            this.optionsPassthrough,
            this.cookiePrefix,
            this.inactivityTimeout,
            this.maximumDuration,
            this.issuer,
            this.clientId,
            this.clientSecret,
            this.scopes
        );
    }

    @Override
    public String toString() {
        return "EndpointOidc{" +
            "enabled='" + this.enabled.map(Object::toString).orElse("(null)") +
            "', optionsPassthrough='" + this.optionsPassthrough +
            "', cookiePrefix='" + this.cookiePrefix +
            "', inactivityTimeout='" + this.inactivityTimeout +
            "', maximumDuration='" + this.maximumDuration +
            "', issuer='" + this.issuer +
            "', clientId='" + this.clientId +
            "', clientSecret='" + this.clientSecret +
            "', scopes='" + this.scopes +
            "'}";
    }
}
