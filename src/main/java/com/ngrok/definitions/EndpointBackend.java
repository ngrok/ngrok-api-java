package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointBackend} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointBackend {
    @JsonProperty("enabled")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Boolean> enabled;
    @JsonProperty("backend")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Ref backend;

    /**
     * Creates a new instance of {@link EndpointBackend}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param backend backend to be used to back this endpoint
     */
    @JsonCreator
    public EndpointBackend(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("backend") final Ref backend
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
        this.backend = Objects.requireNonNull(backend, "backend is required");
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
     * backend to be used to back this endpoint
     *
     * @return the value of the property as a {@link Ref}
     */
    public Ref getBackend() {
        return this.backend;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointBackend other = (EndpointBackend) o;
        return
            this.enabled.equals(other.enabled)&&
            this.backend.equals(other.backend);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.enabled,
            this.backend
        );
    }

    @Override
    public String toString() {
        return "EndpointBackend{" +
            "enabled='" + this.enabled.map(Object::toString).orElse("(null)") +
            "', backend='" + this.backend +
            "'}";
    }
}
