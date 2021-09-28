package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointLogging} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointLogging {
    @JsonProperty("enabled")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Boolean> enabled;
    @JsonProperty("event_streams")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<Ref> eventStreams;

    /**
     * Creates a new instance of {@link EndpointLogging}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param eventStreams list of all EventStreams that will be used to configure and export this endpoint's logs
     */
    @JsonCreator
    public EndpointLogging(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("event_streams") final java.util.List<Ref> eventStreams
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
        this.eventStreams = Objects.requireNonNull(eventStreams, "eventStreams is required");
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
     * @return the value of the property as a {@link java.util.List<Ref>}
     */
    public java.util.List<Ref> getEventStreams() {
        return this.eventStreams;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointLogging other = (EndpointLogging) o;
        return
            this.enabled.equals(other.enabled)&&
            this.eventStreams.equals(other.eventStreams);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.enabled,
            this.eventStreams
        );
    }

    @Override
    public String toString() {
        return "EndpointLogging{" +
            "enabled='" + this.enabled.map(Object::toString).orElse("(null)") +
            "', eventStreams='" + this.eventStreams +
            "'}";
    }
}
