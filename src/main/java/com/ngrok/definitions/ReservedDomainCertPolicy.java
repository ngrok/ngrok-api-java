package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link ReservedDomainCertPolicy} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservedDomainCertPolicy {
    @JsonProperty("authority")
    private final String authority;
    @JsonProperty("private_key_type")
    private final String privateKeyType;

    /**
     * Creates a new instance of {@link ReservedDomainCertPolicy}.
     *
     * @param authority certificate authority to request certificates from. The only supported value is letsencrypt.
     * @param privateKeyType type of private key to use when requesting certificates. Defaults to rsa, can be either rsa or ecdsa.
     */
    @JsonCreator
    public ReservedDomainCertPolicy(
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
