package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EventSourceReplace} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventSourceReplace {
    @JsonProperty("type")
    private final String type;

    /**
     * Creates a new instance of {@link EventSourceReplace}.
     *
     * @param type Type of event for which an event subscription will trigger
     */
    @JsonCreator
    public EventSourceReplace(
        @JsonProperty("type") final String type
    ) {
        this.type = Objects.requireNonNull(type, "type is required");
    }

    /**
     * Type of event for which an event subscription will trigger
     *
     * @return the value of the property as a {@link String}
     */
    public String getType() {
        return this.type;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EventSourceReplace other = (EventSourceReplace) o;
        return
            this.type.equals(other.type);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.type
        );
    }

    @Override
    public String toString() {
        return "EventSourceReplace{" +
            "type='" + this.type +
            "'}";
    }
}
