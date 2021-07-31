package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointRequestHeaders} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointRequestHeaders {
    @JsonProperty("enabled")
    private final Optional<Boolean> enabled;
    @JsonProperty("add")
    private final java.util.Map<String, String> add;
    @JsonProperty("remove")
    private final java.util.List<String> remove;

    /**
     * Creates a new instance of {@link EndpointRequestHeaders}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param add a map of header key to header value that will be injected into the HTTP Request before being sent to the upstream application server
     * @param remove a list of header names that will be removed from the HTTP Request before being sent to the upstream application server
     */
    @JsonCreator
    public EndpointRequestHeaders(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("add") final java.util.Map<String, String> add,
        @JsonProperty("remove") final java.util.List<String> remove
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
        this.add = Objects.requireNonNull(add, "add is required");
        this.remove = Objects.requireNonNull(remove, "remove is required");
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
     * a map of header key to header value that will be injected into the HTTP Request
     * before being sent to the upstream application server
     *
     * @return the value of the property as a {@link java.util.Map<String, String>}
     */
    public java.util.Map<String, String> getAdd() {
        return this.add;
    }

    /**
     * a list of header names that will be removed from the HTTP Request before being
     * sent to the upstream application server
     *
     * @return the value of the property as a {@link java.util.List<String>}
     */
    public java.util.List<String> getRemove() {
        return this.remove;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointRequestHeaders other = (EndpointRequestHeaders) o;
        return
            this.enabled.equals(other.enabled)&&
            this.add.equals(other.add)&&
            this.remove.equals(other.remove);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.enabled,
            this.add,
            this.remove
        );
    }

    @Override
    public String toString() {
        return "EndpointRequestHeaders{" +
            "enabled='" + this.enabled.map(Object::toString).orElse("(null)") +
            "', add='" + this.add +
            "', remove='" + this.remove +
            "'}";
    }
}
