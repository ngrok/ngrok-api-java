/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link StaticBackendTls} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class StaticBackendTls {
    /**
     * Builder class for {@link StaticBackendTls}.
     */
    public static class Builder {
        private Optional<Boolean> enabled = Optional.empty();

        private Builder(
        ) {
        }

        /**
         * if TLS is checked
         *
         * @param enabled the value of the <code>enabled</code> parameter as a {@link boolean}
         * @return this builder instance
         */
        public Builder enabled(final boolean enabled) {
            this.enabled = Optional.of(Objects.requireNonNull(enabled, "enabled is required"));
            return this;
        }

        /**
         * if TLS is checked
         *
         * @param enabled the value of the <code>enabled</code> parameter as a {@link boolean}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder enabled(final Optional<Boolean> enabled) {
            this.enabled = Objects.requireNonNull(enabled, "enabled is required");
            return this;
        }

        /**
         * Constructs the {@link StaticBackendTls} instance.
         *
         * @return a new {@link StaticBackendTls}
         */
        public StaticBackendTls build() {
            return new StaticBackendTls(
                this.enabled.orElse(false)
            );
        }
    }

    /**
     * Creates a new builder for the {@link StaticBackendTls} type.
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
    private final boolean enabled;

    /**
     * Creates a new instance of {@link StaticBackendTls}.
     *
     * @param enabled if TLS is checked
     */
    @JsonCreator
    private StaticBackendTls(
        @JsonProperty("enabled") final Boolean enabled
    ) {
        this.enabled = Objects.requireNonNull(enabled, "enabled is required");
    }

    /**
     * if TLS is checked
     *
     * @return the value of the property as a {@link boolean}
     */
    public boolean getEnabled() {
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
        
        final StaticBackendTls other = (StaticBackendTls) o;
        return
            this.enabled == other.enabled;
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.enabled
        );
    }

    @Override
    public String toString() {
        return "StaticBackendTls{" +
            "enabled='" + this.enabled +
            "'}";
    }
}
