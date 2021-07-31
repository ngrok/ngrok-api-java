package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointOidc} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointOidc {
    @JsonProperty("enabled")
    private final Optional<Boolean> enabled;
    @JsonProperty("options_passthrough")
    private final boolean optionsPassthrough;
    @JsonProperty("cookie_prefix")
    private final String cookiePrefix;
    @JsonProperty("inactivity_timeout")
    private final long inactivityTimeout;
    @JsonProperty("maximum_duration")
    private final java.time.Duration maximumDuration;
    @JsonProperty("issuer")
    private final String issuer;
    @JsonProperty("client_id")
    private final String clientId;
    @JsonProperty("client_secret")
    private final String clientSecret;
    @JsonProperty("scopes")
    private final java.util.List<String> scopes;

    /**
     * Creates a new instance of {@link EndpointOidc}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param optionsPassthrough Do not enforce authentication on HTTP OPTIONS requests. necessary if you are supporting CORS.
     * @param cookiePrefix the prefix of the session cookie that ngrok sets on the http client to cache authentication. default is 'ngrok.'
     * @param inactivityTimeout Integer number of seconds of inactivity after which if the user has not accessed the endpoint, their session will time out and they will be forced to reauthenticate.
     * @param maximumDuration Integer number of seconds of the maximum duration of an authenticated session. After this period is exceeded, a user must reauthenticate.
     * @param issuer URL of the OIDC "OpenID provider". This is the base URL used for discovery.
     * @param clientId The OIDC app's client ID and OIDC audience.
     * @param clientSecret The OIDC app's client secret.
     * @param scopes The set of scopes to request from the OIDC identity provider.
     */
    @JsonCreator
    public EndpointOidc(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("options_passthrough") final boolean optionsPassthrough,
        @JsonProperty("cookie_prefix") final String cookiePrefix,
        @JsonProperty("inactivity_timeout") final long inactivityTimeout,
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
        this.scopes = Objects.requireNonNull(scopes, "scopes is required");
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
     * URL of the OIDC "OpenID provider". This is the base URL used for discovery.
     *
     * @return the value of the property as a {@link String}
     */
    public String getIssuer() {
        return this.issuer;
    }

    /**
     * The OIDC app's client ID and OIDC audience.
     *
     * @return the value of the property as a {@link String}
     */
    public String getClientId() {
        return this.clientId;
    }

    /**
     * The OIDC app's client secret.
     *
     * @return the value of the property as a {@link String}
     */
    public String getClientSecret() {
        return this.clientSecret;
    }

    /**
     * The set of scopes to request from the OIDC identity provider.
     *
     * @return the value of the property as a {@link java.util.List<String>}
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
