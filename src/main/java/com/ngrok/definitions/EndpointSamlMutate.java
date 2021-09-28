package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointSamlMutate} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointSamlMutate {
    /**
     * Builder class for {@link EndpointSamlMutate}.
     */
    public static class Builder {
        private Optional<Boolean> enabled = Optional.empty();
        private Optional<Boolean> optionsPassthrough = Optional.empty();
        private Optional<String> cookiePrefix = Optional.empty();
        private Optional<Long> inactivityTimeout = Optional.empty();
        private Optional<java.time.Duration> maximumDuration = Optional.empty();
        private Optional<String> idpMetadata = Optional.empty();
        private Optional<Boolean> forceAuthn = Optional.empty();
        private Optional<Boolean> allowIdpInitiated = Optional.empty();
        private Optional<java.util.List<String>> authorizedGroups = Optional.empty();
        private Optional<String> nameidFormat = Optional.empty();

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
         * The full XML IdP EntityDescriptor. Your IdP may provide this to you as a a file
         * to download or as a URL.
		 *
		 * @param idpMetadata the value of the <code>idp_metadata</code> parameter as a {@link String}
		 * @return this builder instance
		 */
        public Builder idpMetadata(final String idpMetadata) {
            this.idpMetadata = Optional.of(Objects.requireNonNull(idpMetadata, "idpMetadata is required"));
            return this;
        }

        /**
         * The full XML IdP EntityDescriptor. Your IdP may provide this to you as a a file
         * to download or as a URL.
		 *
		 * @param idpMetadata the value of the <code>idp_metadata</code> parameter as a {@link String}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder idpMetadata(final Optional<String> idpMetadata) {
            this.idpMetadata = Objects.requireNonNull(idpMetadata, "idpMetadata is required");
            return this;
        }

        /**
         * If true, indicates that whenever we redirect a user to the IdP for
         * authentication that the IdP must prompt the user for authentication credentials
         * even if the user already has a valid session with the IdP.
		 *
		 * @param forceAuthn the value of the <code>force_authn</code> parameter as a {@link boolean}
		 * @return this builder instance
		 */
        public Builder forceAuthn(final boolean forceAuthn) {
            this.forceAuthn = Optional.of(Objects.requireNonNull(forceAuthn, "forceAuthn is required"));
            return this;
        }

        /**
         * If true, indicates that whenever we redirect a user to the IdP for
         * authentication that the IdP must prompt the user for authentication credentials
         * even if the user already has a valid session with the IdP.
		 *
		 * @param forceAuthn the value of the <code>force_authn</code> parameter as a {@link boolean}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder forceAuthn(final Optional<Boolean> forceAuthn) {
            this.forceAuthn = Objects.requireNonNull(forceAuthn, "forceAuthn is required");
            return this;
        }

        /**
         * If true, the IdP may initiate a login directly (e.g. the user does not need to
         * visit the endpoint first and then be redirected). The IdP should set the
         * <code>RelayState</code> parameter to the target URL of the resource they want
         * the user to be redirected to after the SAML login assertion has been processed.
		 *
		 * @param allowIdpInitiated the value of the <code>allow_idp_initiated</code> parameter as a {@link boolean}
		 * @return this builder instance
		 */
        public Builder allowIdpInitiated(final boolean allowIdpInitiated) {
            this.allowIdpInitiated = Optional.of(Objects.requireNonNull(allowIdpInitiated, "allowIdpInitiated is required"));
            return this;
        }

        /**
         * If true, the IdP may initiate a login directly (e.g. the user does not need to
         * visit the endpoint first and then be redirected). The IdP should set the
         * <code>RelayState</code> parameter to the target URL of the resource they want
         * the user to be redirected to after the SAML login assertion has been processed.
		 *
		 * @param allowIdpInitiated the value of the <code>allow_idp_initiated</code> parameter as a {@link boolean}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder allowIdpInitiated(final Optional<Boolean> allowIdpInitiated) {
            this.allowIdpInitiated = Objects.requireNonNull(allowIdpInitiated, "allowIdpInitiated is required");
            return this;
        }

        /**
         * If present, only users who are a member of one of the listed groups may access
         * the target endpoint.
		 *
		 * @param authorizedGroups the value of the <code>authorized_groups</code> parameter as a {@link java.util.List<String>}
		 * @return this builder instance
		 */
        public Builder authorizedGroups(final java.util.List<String> authorizedGroups) {
            this.authorizedGroups = Optional.of(Objects.requireNonNull(authorizedGroups, "authorizedGroups is required"));
            return this;
        }

        /**
         * If present, only users who are a member of one of the listed groups may access
         * the target endpoint.
		 *
		 * @param authorizedGroups the value of the <code>authorized_groups</code> parameter as a {@link java.util.List<String>}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder authorizedGroups(final Optional<java.util.List<String>> authorizedGroups) {
            this.authorizedGroups = Objects.requireNonNull(authorizedGroups, "authorizedGroups is required");
            return this;
        }

        /**
         * Defines the name identifier format the SP expects the IdP to use in its
         * assertions to identify subjects. If unspecified, a default value of
         * <code>urn:oasis:names:tc:SAML:2.0:nameid-format:persistent</code> will be used.
         * A subset of the allowed values enumerated by the SAML specification are
         * supported.
		 *
		 * @param nameidFormat the value of the <code>nameid_format</code> parameter as a {@link String}
		 * @return this builder instance
		 */
        public Builder nameidFormat(final String nameidFormat) {
            this.nameidFormat = Optional.of(Objects.requireNonNull(nameidFormat, "nameidFormat is required"));
            return this;
        }

        /**
         * Defines the name identifier format the SP expects the IdP to use in its
         * assertions to identify subjects. If unspecified, a default value of
         * <code>urn:oasis:names:tc:SAML:2.0:nameid-format:persistent</code> will be used.
         * A subset of the allowed values enumerated by the SAML specification are
         * supported.
		 *
		 * @param nameidFormat the value of the <code>nameid_format</code> parameter as a {@link String}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder nameidFormat(final Optional<String> nameidFormat) {
            this.nameidFormat = Objects.requireNonNull(nameidFormat, "nameidFormat is required");
            return this;
        }

        /**
         * Constructs the {@link EndpointSamlMutate} instance.
         *
         * @return a new {@link EndpointSamlMutate}
         */
        public EndpointSamlMutate build() {
            return new EndpointSamlMutate(
                this.enabled,
                this.optionsPassthrough.orElse(false),
                this.cookiePrefix.orElse(""),
                this.inactivityTimeout.orElse(0L),
                this.maximumDuration.orElse(java.time.Duration.ZERO),
                this.idpMetadata.orElse(""),
                this.forceAuthn.orElse(false),
                this.allowIdpInitiated,
                this.authorizedGroups.orElse(java.util.Collections.emptyList()),
                this.nameidFormat.orElse("")
            );
        }
    }

    /**
     * Creates a new builder for the {@link EndpointSamlMutate} type.
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
    @JsonProperty("idp_metadata")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String idpMetadata;
    @JsonProperty("force_authn")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final boolean forceAuthn;
    @JsonProperty("allow_idp_initiated")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Boolean> allowIdpInitiated;
    @JsonProperty("authorized_groups")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> authorizedGroups;
    @JsonProperty("nameid_format")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String nameidFormat;

    /**
     * Creates a new instance of {@link EndpointSamlMutate}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param optionsPassthrough Do not enforce authentication on HTTP OPTIONS requests. necessary if you are supporting CORS.
     * @param cookiePrefix the prefix of the session cookie that ngrok sets on the http client to cache authentication. default is 'ngrok.'
     * @param inactivityTimeout Integer number of seconds of inactivity after which if the user has not accessed the endpoint, their session will time out and they will be forced to reauthenticate.
     * @param maximumDuration Integer number of seconds of the maximum duration of an authenticated session. After this period is exceeded, a user must reauthenticate.
     * @param idpMetadata The full XML IdP EntityDescriptor. Your IdP may provide this to you as a a file to download or as a URL.
     * @param forceAuthn If true, indicates that whenever we redirect a user to the IdP for authentication that the IdP must prompt the user for authentication credentials even if the user already has a valid session with the IdP.
     * @param allowIdpInitiated If true, the IdP may initiate a login directly (e.g. the user does not need to visit the endpoint first and then be redirected). The IdP should set the <code>RelayState</code> parameter to the target URL of the resource they want the user to be redirected to after the SAML login assertion has been processed.
     * @param authorizedGroups If present, only users who are a member of one of the listed groups may access the target endpoint.
     * @param nameidFormat Defines the name identifier format the SP expects the IdP to use in its assertions to identify subjects. If unspecified, a default value of <code>urn:oasis:names:tc:SAML:2.0:nameid-format:persistent</code> will be used. A subset of the allowed values enumerated by the SAML specification are supported.
     */
    @JsonCreator
    private EndpointSamlMutate(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("options_passthrough") final Boolean optionsPassthrough,
        @JsonProperty("cookie_prefix") final String cookiePrefix,
        @JsonProperty("inactivity_timeout") final Long inactivityTimeout,
        @JsonProperty("maximum_duration") final java.time.Duration maximumDuration,
        @JsonProperty("idp_metadata") final String idpMetadata,
        @JsonProperty("force_authn") final Boolean forceAuthn,
        @JsonProperty("allow_idp_initiated") final Optional<Boolean> allowIdpInitiated,
        @JsonProperty("authorized_groups") final java.util.List<String> authorizedGroups,
        @JsonProperty("nameid_format") final String nameidFormat
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
        this.optionsPassthrough = Objects.requireNonNull(optionsPassthrough, "optionsPassthrough is required");
        this.cookiePrefix = Objects.requireNonNull(cookiePrefix, "cookiePrefix is required");
        this.inactivityTimeout = Objects.requireNonNull(inactivityTimeout, "inactivityTimeout is required");
        this.maximumDuration = Objects.requireNonNull(maximumDuration, "maximumDuration is required");
        this.idpMetadata = Objects.requireNonNull(idpMetadata, "idpMetadata is required");
        this.forceAuthn = Objects.requireNonNull(forceAuthn, "forceAuthn is required");
        this.allowIdpInitiated = allowIdpInitiated != null ? allowIdpInitiated : Optional.empty();
        this.authorizedGroups = Objects.requireNonNull(authorizedGroups, "authorizedGroups is required");
        this.nameidFormat = Objects.requireNonNull(nameidFormat, "nameidFormat is required");
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
     * The full XML IdP EntityDescriptor. Your IdP may provide this to you as a a file
     * to download or as a URL.
     *
     * @return the value of the property as a {@link String}
     */
    public String getIdpMetadata() {
        return this.idpMetadata;
    }

    /**
     * If true, indicates that whenever we redirect a user to the IdP for
     * authentication that the IdP must prompt the user for authentication credentials
     * even if the user already has a valid session with the IdP.
     *
     * @return the value of the property as a {@link boolean}
     */
    public boolean getForceAuthn() {
        return this.forceAuthn;
    }

    /**
     * If true, the IdP may initiate a login directly (e.g. the user does not need to
     * visit the endpoint first and then be redirected). The IdP should set the
     * <code>RelayState</code> parameter to the target URL of the resource they want
     * the user to be redirected to after the SAML login assertion has been processed.
     *
     * @return the value of the property as a {@link boolean} wrapped in an {@link Optional}
     */
    public Optional<Boolean> getAllowIdpInitiated() {
        return this.allowIdpInitiated;
    }

    /**
     * If present, only users who are a member of one of the listed groups may access
     * the target endpoint.
     *
     * @return the value of the property as a {@link java.util.List<String>}
     */
    public java.util.List<String> getAuthorizedGroups() {
        return this.authorizedGroups;
    }

    /**
     * Defines the name identifier format the SP expects the IdP to use in its
     * assertions to identify subjects. If unspecified, a default value of
     * <code>urn:oasis:names:tc:SAML:2.0:nameid-format:persistent</code> will be used.
     * A subset of the allowed values enumerated by the SAML specification are
     * supported.
     *
     * @return the value of the property as a {@link String}
     */
    public String getNameidFormat() {
        return this.nameidFormat;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointSamlMutate other = (EndpointSamlMutate) o;
        return
            this.enabled.equals(other.enabled)&&
            this.optionsPassthrough == other.optionsPassthrough&&
            this.cookiePrefix.equals(other.cookiePrefix)&&
            this.inactivityTimeout == other.inactivityTimeout&&
            this.maximumDuration == other.maximumDuration&&
            this.idpMetadata.equals(other.idpMetadata)&&
            this.forceAuthn == other.forceAuthn&&
            this.allowIdpInitiated.equals(other.allowIdpInitiated)&&
            this.authorizedGroups.equals(other.authorizedGroups)&&
            this.nameidFormat.equals(other.nameidFormat);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.enabled,
            this.optionsPassthrough,
            this.cookiePrefix,
            this.inactivityTimeout,
            this.maximumDuration,
            this.idpMetadata,
            this.forceAuthn,
            this.allowIdpInitiated,
            this.authorizedGroups,
            this.nameidFormat
        );
    }

    @Override
    public String toString() {
        return "EndpointSamlMutate{" +
            "enabled='" + this.enabled.map(Object::toString).orElse("(null)") +
            "', optionsPassthrough='" + this.optionsPassthrough +
            "', cookiePrefix='" + this.cookiePrefix +
            "', inactivityTimeout='" + this.inactivityTimeout +
            "', maximumDuration='" + this.maximumDuration +
            "', idpMetadata='" + this.idpMetadata +
            "', forceAuthn='" + this.forceAuthn +
            "', allowIdpInitiated='" + this.allowIdpInitiated.map(Object::toString).orElse("(null)") +
            "', authorizedGroups='" + this.authorizedGroups +
            "', nameidFormat='" + this.nameidFormat +
            "'}";
    }
}
