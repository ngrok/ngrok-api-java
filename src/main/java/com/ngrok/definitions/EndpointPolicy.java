/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointPolicy} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointPolicy {
    /**
     * Builder class for {@link EndpointPolicy}.
     */
    public static class Builder {
        private Optional<Boolean> enabled = Optional.empty();
        private java.util.List<EndpointRule> inbound = java.util.Collections.emptyList();
        private java.util.List<EndpointRule> outbound = java.util.Collections.emptyList();

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
         * the inbound rules of the traffic policy.
         *
         * @param inbound the value of the <code>inbound</code> parameter as a {@link java.util.List} of {@link EndpointRule}
         * @return this builder instance
         */
        public Builder inbound(final java.util.List<EndpointRule> inbound) {
            this.inbound = Objects.requireNonNull(inbound, "inbound is required");
            return this;
        }

        /**
         * the inbound rules of the traffic policy.
         *
         * @param inbound the value of the <code>inbound</code> parameter as a {@link java.util.List} of {@link EndpointRule}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder inbound(final Optional<java.util.List<EndpointRule>> inbound) {
            this.inbound = Objects.requireNonNull(inbound, "inbound is required").orElse(java.util.Collections.emptyList());
            return this;
        }

        /**
         * the outbound rules on the traffic policy.
         *
         * @param outbound the value of the <code>outbound</code> parameter as a {@link java.util.List} of {@link EndpointRule}
         * @return this builder instance
         */
        public Builder outbound(final java.util.List<EndpointRule> outbound) {
            this.outbound = Objects.requireNonNull(outbound, "outbound is required");
            return this;
        }

        /**
         * the outbound rules on the traffic policy.
         *
         * @param outbound the value of the <code>outbound</code> parameter as a {@link java.util.List} of {@link EndpointRule}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder outbound(final Optional<java.util.List<EndpointRule>> outbound) {
            this.outbound = Objects.requireNonNull(outbound, "outbound is required").orElse(java.util.Collections.emptyList());
            return this;
        }

        /**
         * Constructs the {@link EndpointPolicy} instance.
         *
         * @return a new {@link EndpointPolicy}
         */
        public EndpointPolicy build() {
            return new EndpointPolicy(
                this.enabled,
                this.inbound,
                this.outbound
            );
        }
    }

    /**
     * Creates a new builder for the {@link EndpointPolicy} type.
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
    @JsonProperty("inbound")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<EndpointRule> inbound;
    @JsonProperty("outbound")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<EndpointRule> outbound;

    /**
     * Creates a new instance of {@link EndpointPolicy}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param inbound the inbound rules of the traffic policy.
     * @param outbound the outbound rules on the traffic policy.
     */
    @JsonCreator
    private EndpointPolicy(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("inbound") final java.util.List<EndpointRule> inbound,
        @JsonProperty("outbound") final java.util.List<EndpointRule> outbound
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
        this.inbound = inbound != null ? inbound : java.util.Collections.emptyList();
        this.outbound = outbound != null ? outbound : java.util.Collections.emptyList();
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
     * the inbound rules of the traffic policy.
     *
     * @return the value of the property as a {@link java.util.List} of {@link EndpointRule}
     */
    public java.util.List<EndpointRule> getInbound() {
        return this.inbound;
    }

    /**
     * the outbound rules on the traffic policy.
     *
     * @return the value of the property as a {@link java.util.List} of {@link EndpointRule}
     */
    public java.util.List<EndpointRule> getOutbound() {
        return this.outbound;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointPolicy other = (EndpointPolicy) o;
        return
            this.enabled.equals(other.enabled)&&
            this.inbound.equals(other.inbound)&&
            this.outbound.equals(other.outbound);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.enabled,
            this.inbound,
            this.outbound
        );
    }

    @Override
    public String toString() {
        return "EndpointPolicy{" +
            "enabled='" + this.enabled.map(Object::toString).orElse("(null)") +
            "', inbound='" + this.inbound +
            "', outbound='" + this.outbound +
            "'}";
    }
}
