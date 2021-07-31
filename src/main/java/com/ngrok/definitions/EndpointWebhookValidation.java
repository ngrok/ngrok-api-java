package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointWebhookValidation} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointWebhookValidation {
    @JsonProperty("enabled")
    private final Optional<Boolean> enabled;
    @JsonProperty("provider")
    private final String provider;
    @JsonProperty("secret")
    private final String secret;

    /**
     * Creates a new instance of {@link EndpointWebhookValidation}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param provider a string indicating which webhook provider will be sending webhooks to this endpoint. Value must be one of the supported providers: <code>SLACK</code>, <code>SNS</code>, <code>STRIPE</code>, <code>GITHUB</code>, <code>TWILIO</code>, <code>SHOPIFY</code>, <code>GITLAB</code>, <code>INTERCOM</code>.
     * @param secret a string secret used to validate requests from the given provider. All providers except AWS SNS require a secret
     */
    @JsonCreator
    public EndpointWebhookValidation(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("provider") final String provider,
        @JsonProperty("secret") final String secret
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
        this.provider = Objects.requireNonNull(provider, "provider is required");
        this.secret = Objects.requireNonNull(secret, "secret is required");
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
     * a string indicating which webhook provider will be sending webhooks to this
     * endpoint. Value must be one of the supported providers: <code>SLACK</code>,
     * <code>SNS</code>, <code>STRIPE</code>, <code>GITHUB</code>, <code>TWILIO</code>,
     * <code>SHOPIFY</code>, <code>GITLAB</code>, <code>INTERCOM</code>.
     *
     * @return the value of the property as a {@link String}
     */
    public String getProvider() {
        return this.provider;
    }

    /**
     * a string secret used to validate requests from the given provider. All providers
     * except AWS SNS require a secret
     *
     * @return the value of the property as a {@link String}
     */
    public String getSecret() {
        return this.secret;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointWebhookValidation other = (EndpointWebhookValidation) o;
        return
            this.enabled.equals(other.enabled)&&
            this.provider.equals(other.provider)&&
            this.secret.equals(other.secret);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.enabled,
            this.provider,
            this.secret
        );
    }

    @Override
    public String toString() {
        return "EndpointWebhookValidation{" +
            "enabled='" + this.enabled.map(Object::toString).orElse("(null)") +
            "', provider='" + this.provider +
            "', secret='" + this.secret +
            "'}";
    }
}
