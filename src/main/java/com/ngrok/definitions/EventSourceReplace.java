package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EventSourceReplace} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventSourceReplace {
    /**
     * Builder class for {@link EventSourceReplace}.
     */
    public static class Builder {
        private Optional<String> type = Optional.empty();

        private Builder(
        ) {
        }

        /**
         * Type of event for which an event subscription will trigger
		 *
		 * @param type the value of the <code>type</code> parameter as a {@link String}
		 * @return this builder instance
		 */
        public Builder type(final String type) {
            this.type = Optional.of(Objects.requireNonNull(type, "type is required"));
            return this;
        }

        /**
         * Type of event for which an event subscription will trigger
		 *
		 * @param type the value of the <code>type</code> parameter as a {@link String}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder type(final Optional<String> type) {
            this.type = Objects.requireNonNull(type, "type is required");
            return this;
        }

        /**
         * Constructs the {@link EventSourceReplace} instance.
         *
         * @return a new {@link EventSourceReplace}
         */
        public EventSourceReplace build() {
            return new EventSourceReplace(
                this.type.orElse("")
            );
        }
    }

    /**
     * Creates a new builder for the {@link EventSourceReplace} type.
     *
     * @return a new {@link Builder}
     */
    public static Builder newBuilder(
    ) {
        return new Builder (
        );
    }

    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String type;

    /**
     * Creates a new instance of {@link EventSourceReplace}.
     *
     * @param type Type of event for which an event subscription will trigger
     */
    @JsonCreator
    private EventSourceReplace(
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
