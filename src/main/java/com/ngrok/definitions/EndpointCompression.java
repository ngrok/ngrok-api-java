package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointCompression} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointCompression {
    /**
     * Builder class for {@link EndpointCompression}.
     */
    public static class Builder {
        private Optional<Boolean> enabled = Optional.empty();

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
         * Constructs the {@link EndpointCompression} instance.
         *
         * @return a new {@link EndpointCompression}
         */
        public EndpointCompression build() {
            return new EndpointCompression(
                this.enabled
            );
        }
    }

    /**
     * Creates a new builder for the {@link EndpointCompression} type.
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

    /**
     * Creates a new instance of {@link EndpointCompression}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     */
    @JsonCreator
    private EndpointCompression(
        @JsonProperty("enabled") final Optional<Boolean> enabled
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
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

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointCompression other = (EndpointCompression) o;
        return
            this.enabled.equals(other.enabled);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.enabled
        );
    }

    @Override
    public String toString() {
        return "EndpointCompression{" +
            "enabled='" + this.enabled.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
