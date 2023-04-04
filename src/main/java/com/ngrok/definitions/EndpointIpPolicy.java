package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointIpPolicy} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointIpPolicy {
    @JsonProperty("enabled")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Boolean> enabled;
    @JsonProperty("ip_policies")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<Ref> ipPolicies;

    /**
     * Creates a new instance of {@link EndpointIpPolicy}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param ipPolicies list of all IP policies that will be used to check if a source IP is allowed access to the endpoint
     */
    @JsonCreator
    public EndpointIpPolicy(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("ip_policies") final java.util.List<Ref> ipPolicies
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
        this.ipPolicies = ipPolicies != null ? ipPolicies : java.util.Collections.emptyList();
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
     * @return the value of the property as a {@link java.util.List} of {@link Ref}
     */
    public java.util.List<Ref> getIpPolicies() {
        return this.ipPolicies;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointIpPolicy other = (EndpointIpPolicy) o;
        return
            this.enabled.equals(other.enabled)&&
            this.ipPolicies.equals(other.ipPolicies);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.enabled,
            this.ipPolicies
        );
    }

    @Override
    public String toString() {
        return "EndpointIpPolicy{" +
            "enabled='" + this.enabled.map(Object::toString).orElse("(null)") +
            "', ipPolicies='" + this.ipPolicies +
            "'}";
    }
}
