package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointMutualTlsMutate} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointMutualTlsMutate {
    @JsonProperty("enabled")
    private final Optional<Boolean> enabled;
    @JsonProperty("certificate_authority_ids")
    private final java.util.List<String> certificateAuthorityIds;

    /**
     * Creates a new instance of {@link EndpointMutualTlsMutate}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param certificateAuthorityIds list of certificate authorities that will be used to validate the TLS client certificate presnted by the initiatiator of the TLS connection
     */
    @JsonCreator
    public EndpointMutualTlsMutate(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("certificate_authority_ids") final java.util.List<String> certificateAuthorityIds
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
        this.certificateAuthorityIds = Objects.requireNonNull(certificateAuthorityIds, "certificateAuthorityIds is required");
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
     * list of certificate authorities that will be used to validate the TLS client
     * certificate presnted by the initiatiator of the TLS connection
     *
     * @return the value of the property as a {@link java.util.List<String>}
     */
    public java.util.List<String> getCertificateAuthorityIds() {
        return this.certificateAuthorityIds;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointMutualTlsMutate other = (EndpointMutualTlsMutate) o;
        return
            this.enabled.equals(other.enabled)&&
            this.certificateAuthorityIds.equals(other.certificateAuthorityIds);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.enabled,
            this.certificateAuthorityIds
        );
    }

    @Override
    public String toString() {
        return "EndpointMutualTlsMutate{" +
            "enabled='" + this.enabled.map(Object::toString).orElse("(null)") +
            "', certificateAuthorityIds='" + this.certificateAuthorityIds +
            "'}";
    }
}
