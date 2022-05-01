package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointMutualTlsMutate} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointMutualTlsMutate {
    /**
     * Builder class for {@link EndpointMutualTlsMutate}.
     */
    public static class Builder {
        private Optional<Boolean> enabled = Optional.empty();
        private java.util.List<String> certificateAuthorityIds = java.util.Collections.emptyList();

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
         * list of certificate authorities that will be used to validate the TLS client
         * certificate presented by the initiator of the TLS connection
         *
         * @param certificateAuthorityIds the value of the <code>certificate_authority_ids</code> parameter as a {@link java.util.List} of {@link String}
         * @return this builder instance
         */
        public Builder certificateAuthorityIds(final java.util.List<String> certificateAuthorityIds) {
            this.certificateAuthorityIds = Objects.requireNonNull(certificateAuthorityIds, "certificateAuthorityIds is required");
            return this;
        }

        /**
         * list of certificate authorities that will be used to validate the TLS client
         * certificate presented by the initiator of the TLS connection
         *
         * @param certificateAuthorityIds the value of the <code>certificate_authority_ids</code> parameter as a {@link java.util.List} of {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder certificateAuthorityIds(final Optional<java.util.List<String>> certificateAuthorityIds) {
            this.certificateAuthorityIds = Objects.requireNonNull(certificateAuthorityIds, "certificateAuthorityIds is required").orElse(java.util.Collections.emptyList());
            return this;
        }

        /**
         * Constructs the {@link EndpointMutualTlsMutate} instance.
         *
         * @return a new {@link EndpointMutualTlsMutate}
         */
        public EndpointMutualTlsMutate build() {
            return new EndpointMutualTlsMutate(
                this.enabled,
                this.certificateAuthorityIds
            );
        }
    }

    /**
     * Creates a new builder for the {@link EndpointMutualTlsMutate} type.
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
    @JsonProperty("certificate_authority_ids")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> certificateAuthorityIds;

    /**
     * Creates a new instance of {@link EndpointMutualTlsMutate}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param certificateAuthorityIds list of certificate authorities that will be used to validate the TLS client certificate presented by the initiator of the TLS connection
     */
    @JsonCreator
    private EndpointMutualTlsMutate(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("certificate_authority_ids") final java.util.List<String> certificateAuthorityIds
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
        this.certificateAuthorityIds = certificateAuthorityIds != null ? certificateAuthorityIds : java.util.Collections.emptyList();
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
     * certificate presented by the initiator of the TLS connection
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
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
