/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointAction} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointAction {
    /**
     * Builder class for {@link EndpointAction}.
     */
    public static class Builder {
        private Optional<String> type = Optional.empty();
        private Optional<java.lang.Object> config = Optional.empty();

        private Builder(
        ) {
        }

        /**
         * the type of action on the policy rule.
         *
         * @param type the value of the <code>type</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder type(final String type) {
            this.type = Optional.of(Objects.requireNonNull(type, "type is required"));
            return this;
        }

        /**
         * the type of action on the policy rule.
         *
         * @param type the value of the <code>type</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder type(final Optional<String> type) {
            this.type = Objects.requireNonNull(type, "type is required");
            return this;
        }

        /**
         * the configuration for the action on the policy rule.
         *
         * @param config the value of the <code>config</code> parameter as a {@link java.lang.Object}
         * @return this builder instance
         */
        public Builder config(final java.lang.Object config) {
            this.config = Optional.of(Objects.requireNonNull(config, "config is required"));
            return this;
        }

        /**
         * the configuration for the action on the policy rule.
         *
         * @param config the value of the <code>config</code> parameter as a {@link java.lang.Object}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder config(final Optional<java.lang.Object> config) {
            this.config = Objects.requireNonNull(config, "config is required");
            return this;
        }

        /**
         * Constructs the {@link EndpointAction} instance.
         *
         * @return a new {@link EndpointAction}
         */
        public EndpointAction build() {
            return new EndpointAction(
                this.type.orElse(""),
                this.config.orElse(null)
            );
        }
    }

    /**
     * Creates a new builder for the {@link EndpointAction} type.
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
    @JsonProperty("config")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.lang.Object config;

    /**
     * Creates a new instance of {@link EndpointAction}.
     *
     * @param type the type of action on the policy rule.
     * @param config the configuration for the action on the policy rule.
     */
    @JsonCreator
    private EndpointAction(
        @JsonProperty("type") final String type,
        @JsonProperty("config") final java.lang.Object config
    ) {
        this.type = Objects.requireNonNull(type, "type is required");
        this.config = Objects.requireNonNull(config, "config is required");
    }

    /**
     * the type of action on the policy rule.
     *
     * @return the value of the property as a {@link String}
     */
    public String getType() {
        return this.type;
    }

    /**
     * the configuration for the action on the policy rule.
     *
     * @return the value of the property as a {@link java.lang.Object}
     */
    public java.lang.Object getConfig() {
        return this.config;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointAction other = (EndpointAction) o;
        return
            this.type.equals(other.type)&&
            this.config.equals(other.config);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.type,
            this.config
        );
    }

    @Override
    public String toString() {
        return "EndpointAction{" +
            "type='" + this.type +
            "', config='" + this.config +
            "'}";
    }
}
