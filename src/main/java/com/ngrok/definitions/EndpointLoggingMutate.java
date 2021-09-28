package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointLoggingMutate} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointLoggingMutate {
    /**
     * Builder class for {@link EndpointLoggingMutate}.
     */
    public static class Builder {
        private Optional<Boolean> enabled = Optional.empty();
        private Optional<java.util.List<String>> eventStreamIds = Optional.empty();

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
         * list of all EventStreams that will be used to configure and export this
         * endpoint's logs
		 *
		 * @param eventStreamIds the value of the <code>event_stream_ids</code> parameter as a {@link java.util.List<String>}
		 * @return this builder instance
		 */
        public Builder eventStreamIds(final java.util.List<String> eventStreamIds) {
            this.eventStreamIds = Optional.of(Objects.requireNonNull(eventStreamIds, "eventStreamIds is required"));
            return this;
        }

        /**
         * list of all EventStreams that will be used to configure and export this
         * endpoint's logs
		 *
		 * @param eventStreamIds the value of the <code>event_stream_ids</code> parameter as a {@link java.util.List<String>}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder eventStreamIds(final Optional<java.util.List<String>> eventStreamIds) {
            this.eventStreamIds = Objects.requireNonNull(eventStreamIds, "eventStreamIds is required");
            return this;
        }

        /**
         * Constructs the {@link EndpointLoggingMutate} instance.
         *
         * @return a new {@link EndpointLoggingMutate}
         */
        public EndpointLoggingMutate build() {
            return new EndpointLoggingMutate(
                this.enabled,
                this.eventStreamIds.orElse(java.util.Collections.emptyList())
            );
        }
    }

    /**
     * Creates a new builder for the {@link EndpointLoggingMutate} type.
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
    @JsonProperty("event_stream_ids")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> eventStreamIds;

    /**
     * Creates a new instance of {@link EndpointLoggingMutate}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param eventStreamIds list of all EventStreams that will be used to configure and export this endpoint's logs
     */
    @JsonCreator
    private EndpointLoggingMutate(
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
