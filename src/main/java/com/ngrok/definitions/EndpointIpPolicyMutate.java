package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointIpPolicyMutate} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointIpPolicyMutate {
    @JsonProperty("enabled")
    private final Optional<Boolean> enabled;
    @JsonProperty("ip_policy_ids")
    private final java.util.List<String> ipPolicyIds;

    /**
     * Creates a new instance of {@link EndpointIpPolicyMutate}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param ipPolicyIds list of all IP policies that will be used to check if a source IP is allowed access to the endpoint
     */
    @JsonCreator
    public EndpointIpPolicyMutate(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("ip_policy_ids") final java.util.List<String> ipPolicyIds
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
        this.ipPolicyIds = Objects.requireNonNull(ipPolicyIds, "ipPolicyIds is required");
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
     * @return the value of the property as a {@link java.util.List<String>}
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
