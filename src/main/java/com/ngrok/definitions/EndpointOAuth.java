package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointOAuth} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointOAuth {
    /**
     * Builder class for {@link EndpointOAuth}.
     */
    public static class Builder {
        private Optional<Boolean> enabled = Optional.empty();
        private Optional<EndpointOAuthProvider> provider = Optional.empty();
        private Optional<Boolean> optionsPassthrough = Optional.empty();
        private Optional<String> cookiePrefix = Optional.empty();
        private Optional<Long> inactivityTimeout = Optional.empty();
        private Optional<java.time.Duration> maximumDuration = Optional.empty();
        private Optional<Long> authCheckInterval = Optional.empty();

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
         * an object which defines the identity provider to use for authentication and
         * configuration for who may access the endpoint
		 *
		 * @param provider the value of the <code>provider</code> parameter as a {@link EndpointOAuthProvider}
		 * @return this builder instance
		 */
        public Builder provider(final EndpointOAuthProvider provider) {
            this.provider = Optional.of(Objects.requireNonNull(provider, "provider is required"));
            return this;
        }

        /**
         * an object which defines the identity provider to use for authentication and
         * configuration for who may access the endpoint
		 *
		 * @param provider the value of the <code>provider</code> parameter as a {@link EndpointOAuthProvider}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder provider(final Optional<EndpointOAuthProvider> provider) {
            this.provider = Objects.requireNonNull(provider, "provider is required");
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
         * authentication. default is 'ngrok.'
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
         * authentication. default is 'ngrok.'
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
         * Integer number of seconds after which ngrok guarantees it will refresh user
         * state from the identity provider and recheck whether the user is still
         * authorized to access the endpoint. This is the preferred tunable to use to
         * enforce a minimum amount of time after which a revoked user will no longer be
         * able to access the resource.
		 *
		 * @param authCheckInterval the value of the <code>auth_check_interval</code> parameter as a {@link long}
		 * @return this builder instance
		 */
        public Builder authCheckInterval(final long authCheckInterval) {
            this.authCheckInterval = Optional.of(Objects.requireNonNull(authCheckInterval, "authCheckInterval is required"));
            return this;
        }

        /**
         * Integer number of seconds after which ngrok guarantees it will refresh user
         * state from the identity provider and recheck whether the user is still
         * authorized to access the endpoint. This is the preferred tunable to use to
         * enforce a minimum amount of time after which a revoked user will no longer be
         * able to access the resource.
		 *
		 * @param authCheckInterval the value of the <code>auth_check_interval</code> parameter as a {@link long}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder authCheckInterval(final Optional<Long> authCheckInterval) {
            this.authCheckInterval = Objects.requireNonNull(authCheckInterval, "authCheckInterval is required");
            return this;
        }

        /**
         * Constructs the {@link EndpointOAuth} instance.
         *
         * @return a new {@link EndpointOAuth}
         */
        public EndpointOAuth build() {
            return new EndpointOAuth(
                this.enabled,
                this.provider.orElse(null),
                this.optionsPassthrough.orElse(false),
                this.cookiePrefix.orElse(""),
                this.inactivityTimeout.orElse(0L),
                this.maximumDuration.orElse(java.time.Duration.ZERO),
                this.authCheckInterval.orElse(0L)
            );
        }
    }

    /**
     * Creates a new builder for the {@link EndpointOAuth} type.
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
    @JsonProperty("provider")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final EndpointOAuthProvider provider;
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
    @JsonProperty("auth_check_interval")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final long authCheckInterval;

    /**
     * Creates a new instance of {@link EndpointOAuth}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param provider an object which defines the identity provider to use for authentication and configuration for who may access the endpoint
     * @param optionsPassthrough Do not enforce authentication on HTTP OPTIONS requests. necessary if you are supporting CORS.
     * @param cookiePrefix the prefix of the session cookie that ngrok sets on the http client to cache authentication. default is 'ngrok.'
     * @param inactivityTimeout Integer number of seconds of inactivity after which if the user has not accessed the endpoint, their session will time out and they will be forced to reauthenticate.
     * @param maximumDuration Integer number of seconds of the maximum duration of an authenticated session. After this period is exceeded, a user must reauthenticate.
     * @param authCheckInterval Integer number of seconds after which ngrok guarantees it will refresh user state from the identity provider and recheck whether the user is still authorized to access the endpoint. This is the preferred tunable to use to enforce a minimum amount of time after which a revoked user will no longer be able to access the resource.
     */
    @JsonCreator
    private EndpointOAuth(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("provider") final EndpointOAuthProvider provider,
        @JsonProperty("options_passthrough") final Boolean optionsPassthrough,
        @JsonProperty("cookie_prefix") final String cookiePrefix,
        @JsonProperty("inactivity_timeout") final Long inactivityTimeout,
        @JsonProperty("maximum_duration") final java.time.Duration maximumDuration,
        @JsonProperty("auth_check_interval") final Long authCheckInterval
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
        this.provider = Objects.requireNonNull(provider, "provider is required");
        this.optionsPassthrough = Objects.requireNonNull(optionsPassthrough, "optionsPassthrough is required");
        this.cookiePrefix = Objects.requireNonNull(cookiePrefix, "cookiePrefix is required");
        this.inactivityTimeout = Objects.requireNonNull(inactivityTimeout, "inactivityTimeout is required");
        this.maximumDuration = Objects.requireNonNull(maximumDuration, "maximumDuration is required");
        this.authCheckInterval = Objects.requireNonNull(authCheckInterval, "authCheckInterval is required");
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
     * an object which defines the identity provider to use for authentication and
     * configuration for who may access the endpoint
     *
     * @return the value of the property as a {@link EndpointOAuthProvider}
     */
    public EndpointOAuthProvider getProvider() {
        return this.provider;
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
     * authentication. default is 'ngrok.'
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
     * Integer number of seconds after which ngrok guarantees it will refresh user
     * state from the identity provider and recheck whether the user is still
     * authorized to access the endpoint. This is the preferred tunable to use to
     * enforce a minimum amount of time after which a revoked user will no longer be
     * able to access the resource.
     *
     * @return the value of the property as a {@link long}
     */
    public long getAuthCheckInterval() {
        return this.authCheckInterval;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointOAuth other = (EndpointOAuth) o;
        return
            this.enabled.equals(other.enabled)&&
            this.provider.equals(other.provider)&&
            this.optionsPassthrough == other.optionsPassthrough&&
            this.cookiePrefix.equals(other.cookiePrefix)&&
            this.inactivityTimeout == other.inactivityTimeout&&
            this.maximumDuration == other.maximumDuration&&
            this.authCheckInterval == other.authCheckInterval;
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.enabled,
            this.provider,
            this.optionsPassthrough,
            this.cookiePrefix,
            this.inactivityTimeout,
            this.maximumDuration,
            this.authCheckInterval
        );
    }

    @Override
    public String toString() {
        return "EndpointOAuth{" +
            "enabled='" + this.enabled.map(Object::toString).orElse("(null)") +
            "', provider='" + this.provider +
            "', optionsPassthrough='" + this.optionsPassthrough +
            "', cookiePrefix='" + this.cookiePrefix +
            "', inactivityTimeout='" + this.inactivityTimeout +
            "', maximumDuration='" + this.maximumDuration +
            "', authCheckInterval='" + this.authCheckInterval +
            "'}";
    }
}
