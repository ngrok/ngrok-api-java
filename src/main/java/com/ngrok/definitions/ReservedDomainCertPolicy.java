package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link ReservedDomainCertPolicy} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservedDomainCertPolicy {
    /**
     * Builder class for {@link ReservedDomainCertPolicy}.
     */
    public static class Builder {
        private Optional<String> authority = Optional.empty();
        private Optional<String> privateKeyType = Optional.empty();

        private Builder(
        ) {
        }

        /**
         * certificate authority to request certificates from. The only supported value is
         * letsencrypt.
		 *
		 * @param authority the value of the <code>authority</code> parameter as a {@link String}
		 * @return this builder instance
		 */
        public Builder authority(final String authority) {
            this.authority = Optional.of(Objects.requireNonNull(authority, "authority is required"));
            return this;
        }

        /**
         * certificate authority to request certificates from. The only supported value is
         * letsencrypt.
		 *
		 * @param authority the value of the <code>authority</code> parameter as a {@link String}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder authority(final Optional<String> authority) {
            this.authority = Objects.requireNonNull(authority, "authority is required");
            return this;
        }

        /**
         * type of private key to use when requesting certificates. Defaults to rsa, can be
         * either rsa or ecdsa.
		 *
		 * @param privateKeyType the value of the <code>private_key_type</code> parameter as a {@link String}
		 * @return this builder instance
		 */
        public Builder privateKeyType(final String privateKeyType) {
            this.privateKeyType = Optional.of(Objects.requireNonNull(privateKeyType, "privateKeyType is required"));
            return this;
        }

        /**
         * type of private key to use when requesting certificates. Defaults to rsa, can be
         * either rsa or ecdsa.
		 *
		 * @param privateKeyType the value of the <code>private_key_type</code> parameter as a {@link String}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder privateKeyType(final Optional<String> privateKeyType) {
            this.privateKeyType = Objects.requireNonNull(privateKeyType, "privateKeyType is required");
            return this;
        }

        /**
         * Constructs the {@link ReservedDomainCertPolicy} instance.
         *
         * @return a new {@link ReservedDomainCertPolicy}
         */
        public ReservedDomainCertPolicy build() {
            return new ReservedDomainCertPolicy(
                this.authority.orElse(""),
                this.privateKeyType.orElse("")
            );
        }
    }

    /**
     * Creates a new builder for the {@link ReservedDomainCertPolicy} type.
     *
     * @return a new {@link Builder}
     */
    public static Builder newBuilder(
    ) {
        return new Builder (
        );
    }

    @JsonProperty("authority")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String authority;
    @JsonProperty("private_key_type")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String privateKeyType;

    /**
     * Creates a new instance of {@link ReservedDomainCertPolicy}.
     *
     * @param authority certificate authority to request certificates from. The only supported value is letsencrypt.
     * @param privateKeyType type of private key to use when requesting certificates. Defaults to rsa, can be either rsa or ecdsa.
     */
    @JsonCreator
    private ReservedDomainCertPolicy(
        @JsonProperty("authority") final String authority,
        @JsonProperty("private_key_type") final String privateKeyType
    ) {
        this.authority = Objects.requireNonNull(authority, "authority is required");
        this.privateKeyType = Objects.requireNonNull(privateKeyType, "privateKeyType is required");
    }

    /**
     * certificate authority to request certificates from. The only supported value is
     * letsencrypt.
     *
     * @return the value of the property as a {@link String}
     */
    public String getAuthority() {
        return this.authority;
    }

    /**
     * type of private key to use when requesting certificates. Defaults to rsa, can be
     * either rsa or ecdsa.
     *
     * @return the value of the property as a {@link String}
     */
    public String getPrivateKeyType() {
        return this.privateKeyType;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final ReservedDomainCertPolicy other = (ReservedDomainCertPolicy) o;
        return
            this.authority.equals(other.authority)&&
            this.privateKeyType.equals(other.privateKeyType);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.authority,
            this.privateKeyType
        );
    }

    @Override
    public String toString() {
        return "ReservedDomainCertPolicy{" +
            "authority='" + this.authority +
            "', privateKeyType='" + this.privateKeyType +
            "'}";
    }
}
