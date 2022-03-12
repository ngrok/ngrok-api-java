package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointTlsTerminationAtEdge} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointTlsTerminationAtEdge {
    /**
     * Builder class for {@link EndpointTlsTerminationAtEdge}.
     */
    public static class Builder {
        private Optional<Boolean> enabled = Optional.empty();
        private Optional<String> minVersion = Optional.empty();

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
         * The minimum TLS version used for termination and advertised to the client during
         * the TLS handshake. if unspecified, ngrok will choose an industry-safe default.
         * This value must be null if <code>terminate_at</code> is set to
         * <code>upstream</code>.
		 *
		 * @param minVersion the value of the <code>min_version</code> parameter as a {@link String}
		 * @return this builder instance
		 */
        public Builder minVersion(final String minVersion) {
            this.minVersion = Optional.of(Objects.requireNonNull(minVersion, "minVersion is required"));
            return this;
        }

        /**
         * The minimum TLS version used for termination and advertised to the client during
         * the TLS handshake. if unspecified, ngrok will choose an industry-safe default.
         * This value must be null if <code>terminate_at</code> is set to
         * <code>upstream</code>.
		 *
		 * @param minVersion the value of the <code>min_version</code> parameter as a {@link String}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder minVersion(final Optional<String> minVersion) {
            this.minVersion = Objects.requireNonNull(minVersion, "minVersion is required");
            return this;
        }

        /**
         * Constructs the {@link EndpointTlsTerminationAtEdge} instance.
         *
         * @return a new {@link EndpointTlsTerminationAtEdge}
         */
        public EndpointTlsTerminationAtEdge build() {
            return new EndpointTlsTerminationAtEdge(
                this.enabled,
                this.minVersion
            );
        }
    }

    /**
     * Creates a new builder for the {@link EndpointTlsTerminationAtEdge} type.
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
    @JsonProperty("min_version")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> minVersion;

    /**
     * Creates a new instance of {@link EndpointTlsTerminationAtEdge}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param minVersion The minimum TLS version used for termination and advertised to the client during the TLS handshake. if unspecified, ngrok will choose an industry-safe default. This value must be null if <code>terminate_at</code> is set to <code>upstream</code>.
     */
    @JsonCreator
    private EndpointTlsTerminationAtEdge(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("min_version") final Optional<String> minVersion
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
        this.minVersion = minVersion != null ? minVersion : Optional.empty();
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
     * The minimum TLS version used for termination and advertised to the client during
     * the TLS handshake. if unspecified, ngrok will choose an industry-safe default.
     * This value must be null if <code>terminate_at</code> is set to
     * <code>upstream</code>.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getMinVersion() {
        return this.minVersion;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointTlsTerminationAtEdge other = (EndpointTlsTerminationAtEdge) o;
        return
            this.enabled.equals(other.enabled)&&
            this.minVersion.equals(other.minVersion);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.enabled,
            this.minVersion
        );
    }

    @Override
    public String toString() {
        return "EndpointTlsTerminationAtEdge{" +
            "enabled='" + this.enabled.map(Object::toString).orElse("(null)") +
            "', minVersion='" + this.minVersion.orElse("(null)") +
            "'}";
    }
}
