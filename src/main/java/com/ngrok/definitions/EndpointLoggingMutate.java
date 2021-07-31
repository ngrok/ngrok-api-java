package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointLoggingMutate} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointLoggingMutate {
    @JsonProperty("enabled")
    private final Optional<Boolean> enabled;
    @JsonProperty("event_stream_ids")
    private final java.util.List<String> eventStreamIds;

    /**
     * Creates a new instance of {@link EndpointLoggingMutate}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param eventStreamIds list of all EventStreams that will be used to configure and export this endpoint's logs
     */
    @JsonCreator
    public EndpointLoggingMutate(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("event_stream_ids") final java.util.List<String> eventStreamIds
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
        this.eventStreamIds = Objects.requireNonNull(eventStreamIds, "eventStreamIds is required");
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
     * list of all EventStreams that will be used to configure and export this
     * endpoint's logs
     *
     * @return the value of the property as a {@link java.util.List<String>}
     */
    public java.util.List<String> getEventStreamIds() {
        return this.eventStreamIds;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointLoggingMutate other = (EndpointLoggingMutate) o;
        return
            this.enabled.equals(other.enabled)&&
            this.eventStreamIds.equals(other.eventStreamIds);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.enabled,
            this.eventStreamIds
        );
    }

    @Override
    public String toString() {
        return "EndpointLoggingMutate{" +
            "enabled='" + this.enabled.map(Object::toString).orElse("(null)") +
            "', eventStreamIds='" + this.eventStreamIds +
            "'}";
    }
}
