package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointMutualTls} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointMutualTls {
    @JsonProperty("enabled")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Boolean> enabled;
    @JsonProperty("certificate_authorities")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<Ref> certificateAuthorities;

    /**
     * Creates a new instance of {@link EndpointMutualTls}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param certificateAuthorities PEM-encoded CA certificates that will be used to validate. Multiple CAs may be provided by concatenating them together.
     */
    @JsonCreator
    public EndpointMutualTls(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("certificate_authorities") final java.util.List<Ref> certificateAuthorities
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
        this.certificateAuthorities = certificateAuthorities != null ? certificateAuthorities : java.util.Collections.emptyList();
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
     * PEM-encoded CA certificates that will be used to validate. Multiple CAs may be
     * provided by concatenating them together.
     *
     * @return the value of the property as a {@link java.util.List} of {@link Ref}
     */
    public java.util.List<Ref> getCertificateAuthorities() {
        return this.certificateAuthorities;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointMutualTls other = (EndpointMutualTls) o;
        return
            this.enabled.equals(other.enabled)&&
            this.certificateAuthorities.equals(other.certificateAuthorities);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.enabled,
            this.certificateAuthorities
        );
    }

    @Override
    public String toString() {
        return "EndpointMutualTls{" +
            "enabled='" + this.enabled.map(Object::toString).orElse("(null)") +
            "', certificateAuthorities='" + this.certificateAuthorities +
            "'}";
    }
}
