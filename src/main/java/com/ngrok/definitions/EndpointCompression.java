package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointCompression} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointCompression {
    @JsonProperty("enabled")
    private final Optional<Boolean> enabled;

    /**
     * Creates a new instance of {@link EndpointCompression}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     */
    @JsonCreator
    public EndpointCompression(
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
