package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointTlsTermination} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointTlsTermination {
    @JsonProperty("enabled")
    private final Optional<Boolean> enabled;
    @JsonProperty("terminate_at")
    private final String terminateAt;
    @JsonProperty("min_version")
    private final Optional<String> minVersion;

    /**
     * Creates a new instance of {@link EndpointTlsTermination}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param terminateAt <code>edge</code> if the ngrok edge should terminate TLS traffic, <code>upstream</code> if TLS traffic should be passed through to the upstream ngrok agent / application server for termination. if <code>upstream</code> is chosen, most other modules will be disallowed because they rely on the ngrok edge being able to access the underlying traffic.
     * @param minVersion The minimum TLS version used for termination and advertised to the client during the TLS handshake. if unspecified, ngrok will choose an industry-safe default. This value must be null if <code>terminate_at</code> is set to <code>upstream</code>.
     */
    @JsonCreator
    public EndpointTlsTermination(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("terminate_at") final String terminateAt,
        @JsonProperty("min_version") final Optional<String> minVersion
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
        this.terminateAt = Objects.requireNonNull(terminateAt, "terminateAt is required");
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
     * <code>edge</code> if the ngrok edge should terminate TLS traffic,
     * <code>upstream</code> if TLS traffic should be passed through to the upstream
     * ngrok agent / application server for termination. if <code>upstream</code> is
     * chosen, most other modules will be disallowed because they rely on the ngrok
     * edge being able to access the underlying traffic.
     *
     * @return the value of the property as a {@link String}
     */
    public String getTerminateAt() {
        return this.terminateAt;
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
        
        final EndpointTlsTermination other = (EndpointTlsTermination) o;
        return
            this.enabled.equals(other.enabled)&&
            this.terminateAt.equals(other.terminateAt)&&
            this.minVersion.equals(other.minVersion);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.enabled,
            this.terminateAt,
            this.minVersion
        );
    }

    @Override
    public String toString() {
        return "EndpointTlsTermination{" +
            "enabled='" + this.enabled.map(Object::toString).orElse("(null)") +
            "', terminateAt='" + this.terminateAt +
            "', minVersion='" + this.minVersion.orElse("(null)") +
            "'}";
    }
}
