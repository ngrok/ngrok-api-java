/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointTrafficPolicy} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointTrafficPolicy {
    /**
     * Builder class for {@link EndpointTrafficPolicy}.
     */
    public static class Builder {
        private Optional<Boolean> enabled = Optional.empty();
        private Optional<String> value = Optional.empty();

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
         * the traffic policy that should be applied to the traffic on your endpoint.
         *
         * @param value the value of the <code>value</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder value(final String value) {
            this.value = Optional.of(Objects.requireNonNull(value, "value is required"));
            return this;
        }

        /**
         * the traffic policy that should be applied to the traffic on your endpoint.
         *
         * @param value the value of the <code>value</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder value(final Optional<String> value) {
            this.value = Objects.requireNonNull(value, "value is required");
            return this;
        }

        /**
         * Constructs the {@link EndpointTrafficPolicy} instance.
         *
         * @return a new {@link EndpointTrafficPolicy}
         */
        public EndpointTrafficPolicy build() {
            return new EndpointTrafficPolicy(
                this.enabled,
                this.value.orElse("")
            );
        }
    }

    /**
     * Creates a new builder for the {@link EndpointTrafficPolicy} type.
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
    @JsonProperty("value")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String value;

    /**
     * Creates a new instance of {@link EndpointTrafficPolicy}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param value the traffic policy that should be applied to the traffic on your endpoint.
     */
    @JsonCreator
    private EndpointTrafficPolicy(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("value") final String value
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
        this.value = Objects.requireNonNull(value, "value is required");
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
     * the traffic policy that should be applied to the traffic on your endpoint.
     *
     * @return the value of the property as a {@link String}
     */
    public String getValue() {
        return this.value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointTrafficPolicy other = (EndpointTrafficPolicy) o;
        return
            this.enabled.equals(other.enabled)&&
            this.value.equals(other.value);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.enabled,
            this.value
        );
    }

    @Override
    public String toString() {
        return "EndpointTrafficPolicy{" +
            "enabled='" + this.enabled.map(Object::toString).orElse("(null)") +
            "', value='" + this.value +
            "'}";
    }
}
