/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointIpPolicyMutate} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointIpPolicyMutate {
    /**
     * Builder class for {@link EndpointIpPolicyMutate}.
     */
    public static class Builder {
        private Optional<Boolean> enabled = Optional.empty();
        private java.util.List<String> ipPolicyIds = java.util.Collections.emptyList();

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
         * list of all IP policies that will be used to check if a source IP is allowed
         * access to the endpoint
         *
         * @param ipPolicyIds the value of the <code>ip_policy_ids</code> parameter as a {@link java.util.List} of {@link String}
         * @return this builder instance
         */
        public Builder ipPolicyIds(final java.util.List<String> ipPolicyIds) {
            this.ipPolicyIds = Objects.requireNonNull(ipPolicyIds, "ipPolicyIds is required");
            return this;
        }

        /**
         * list of all IP policies that will be used to check if a source IP is allowed
         * access to the endpoint
         *
         * @param ipPolicyIds the value of the <code>ip_policy_ids</code> parameter as a {@link java.util.List} of {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder ipPolicyIds(final Optional<java.util.List<String>> ipPolicyIds) {
            this.ipPolicyIds = Objects.requireNonNull(ipPolicyIds, "ipPolicyIds is required").orElse(java.util.Collections.emptyList());
            return this;
        }

        /**
         * Constructs the {@link EndpointIpPolicyMutate} instance.
         *
         * @return a new {@link EndpointIpPolicyMutate}
         */
        public EndpointIpPolicyMutate build() {
            return new EndpointIpPolicyMutate(
                this.enabled,
                this.ipPolicyIds
            );
        }
    }

    /**
     * Creates a new builder for the {@link EndpointIpPolicyMutate} type.
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
    @JsonProperty("ip_policy_ids")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> ipPolicyIds;

    /**
     * Creates a new instance of {@link EndpointIpPolicyMutate}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param ipPolicyIds list of all IP policies that will be used to check if a source IP is allowed access to the endpoint
     */
    @JsonCreator
    private EndpointIpPolicyMutate(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("ip_policy_ids") final java.util.List<String> ipPolicyIds
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
        this.ipPolicyIds = ipPolicyIds != null ? ipPolicyIds : java.util.Collections.emptyList();
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
     * list of all IP policies that will be used to check if a source IP is allowed
     * access to the endpoint
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getIpPolicyIds() {
        return this.ipPolicyIds;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointIpPolicyMutate other = (EndpointIpPolicyMutate) o;
        return
            this.enabled.equals(other.enabled)&&
            this.ipPolicyIds.equals(other.ipPolicyIds);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.enabled,
            this.ipPolicyIds
        );
    }

    @Override
    public String toString() {
        return "EndpointIpPolicyMutate{" +
            "enabled='" + this.enabled.map(Object::toString).orElse("(null)") +
            "', ipPolicyIds='" + this.ipPolicyIds +
            "'}";
    }
}
