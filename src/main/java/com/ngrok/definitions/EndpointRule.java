/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointRule} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointRule {
    /**
     * Builder class for {@link EndpointRule}.
     */
    public static class Builder {
        private java.util.List<String> expressions = java.util.Collections.emptyList();
        private java.util.List<EndpointAction> actions = java.util.Collections.emptyList();
        private Optional<String> name = Optional.empty();

        private Builder(
        ) {
        }

        /**
         * cel expressions that filter traffic the policy rule applies to.
         *
         * @param expressions the value of the <code>expressions</code> parameter as a {@link java.util.List} of {@link String}
         * @return this builder instance
         */
        public Builder expressions(final java.util.List<String> expressions) {
            this.expressions = Objects.requireNonNull(expressions, "expressions is required");
            return this;
        }

        /**
         * cel expressions that filter traffic the policy rule applies to.
         *
         * @param expressions the value of the <code>expressions</code> parameter as a {@link java.util.List} of {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder expressions(final Optional<java.util.List<String>> expressions) {
            this.expressions = Objects.requireNonNull(expressions, "expressions is required").orElse(java.util.Collections.emptyList());
            return this;
        }

        /**
         * the set of actions on a policy rule.
         *
         * @param actions the value of the <code>actions</code> parameter as a {@link java.util.List} of {@link EndpointAction}
         * @return this builder instance
         */
        public Builder actions(final java.util.List<EndpointAction> actions) {
            this.actions = Objects.requireNonNull(actions, "actions is required");
            return this;
        }

        /**
         * the set of actions on a policy rule.
         *
         * @param actions the value of the <code>actions</code> parameter as a {@link java.util.List} of {@link EndpointAction}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder actions(final Optional<java.util.List<EndpointAction>> actions) {
            this.actions = Objects.requireNonNull(actions, "actions is required").orElse(java.util.Collections.emptyList());
            return this;
        }

        /**
         * the name of the rule that is part of the traffic policy.
         *
         * @param name the value of the <code>name</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder name(final String name) {
            this.name = Optional.of(Objects.requireNonNull(name, "name is required"));
            return this;
        }

        /**
         * the name of the rule that is part of the traffic policy.
         *
         * @param name the value of the <code>name</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder name(final Optional<String> name) {
            this.name = Objects.requireNonNull(name, "name is required");
            return this;
        }

        /**
         * Constructs the {@link EndpointRule} instance.
         *
         * @return a new {@link EndpointRule}
         */
        public EndpointRule build() {
            return new EndpointRule(
                this.expressions,
                this.actions,
                this.name.orElse("")
            );
        }
    }

    /**
     * Creates a new builder for the {@link EndpointRule} type.
     *
     * @return a new {@link Builder}
     */
    public static Builder newBuilder(
    ) {
        return new Builder (
        );
    }

    @JsonProperty("expressions")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> expressions;
    @JsonProperty("actions")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<EndpointAction> actions;
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String name;

    /**
     * Creates a new instance of {@link EndpointRule}.
     *
     * @param expressions cel expressions that filter traffic the policy rule applies to.
     * @param actions the set of actions on a policy rule.
     * @param name the name of the rule that is part of the traffic policy.
     */
    @JsonCreator
    private EndpointRule(
        @JsonProperty("expressions") final java.util.List<String> expressions,
        @JsonProperty("actions") final java.util.List<EndpointAction> actions,
        @JsonProperty("name") final String name
    ) {
        this.expressions = expressions != null ? expressions : java.util.Collections.emptyList();
        this.actions = actions != null ? actions : java.util.Collections.emptyList();
        this.name = Objects.requireNonNull(name, "name is required");
    }

    /**
     * cel expressions that filter traffic the policy rule applies to.
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getExpressions() {
        return this.expressions;
    }

    /**
     * the set of actions on a policy rule.
     *
     * @return the value of the property as a {@link java.util.List} of {@link EndpointAction}
     */
    public java.util.List<EndpointAction> getActions() {
        return this.actions;
    }

    /**
     * the name of the rule that is part of the traffic policy.
     *
     * @return the value of the property as a {@link String}
     */
    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointRule other = (EndpointRule) o;
        return
            this.expressions.equals(other.expressions)&&
            this.actions.equals(other.actions)&&
            this.name.equals(other.name);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.expressions,
            this.actions,
            this.name
        );
    }

    @Override
    public String toString() {
        return "EndpointRule{" +
            "expressions='" + this.expressions +
            "', actions='" + this.actions +
            "', name='" + this.name +
            "'}";
    }
}
