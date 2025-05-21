/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link KubernetesOperatorCert} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class KubernetesOperatorCert {
    @JsonProperty("cert")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String cert;
    @JsonProperty("not_before")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime notBefore;
    @JsonProperty("not_after")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime notAfter;

    /**
     * Creates a new instance of {@link KubernetesOperatorCert}.
     *
     * @param cert the public client certificate generated for this Kubernetes Operator from the CSR supplied when enabling the Bindings feature
     * @param notBefore timestamp when the certificate becomes valid. RFC 3339 format
     * @param notAfter timestamp when the certificate becomes invalid. RFC 3339 format
     */
    @JsonCreator
    public KubernetesOperatorCert(
        @JsonProperty("cert") final String cert,
        @JsonProperty("not_before") final java.time.OffsetDateTime notBefore,
        @JsonProperty("not_after") final java.time.OffsetDateTime notAfter
    ) {
        this.cert = Objects.requireNonNull(cert, "cert is required");
        this.notBefore = Objects.requireNonNull(notBefore, "notBefore is required");
        this.notAfter = Objects.requireNonNull(notAfter, "notAfter is required");
    }

    /**
     * the public client certificate generated for this Kubernetes Operator from the
     * CSR supplied when enabling the Bindings feature
     *
     * @return the value of the property as a {@link String}
     */
    public String getCert() {
        return this.cert;
    }

    /**
     * timestamp when the certificate becomes valid. RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getNotBefore() {
        return this.notBefore;
    }

    /**
     * timestamp when the certificate becomes invalid. RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getNotAfter() {
        return this.notAfter;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final KubernetesOperatorCert other = (KubernetesOperatorCert) o;
        return
            this.cert.equals(other.cert)&&
            this.notBefore.equals(other.notBefore)&&
            this.notAfter.equals(other.notAfter);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.cert,
            this.notBefore,
            this.notAfter
        );
    }

    @Override
    public String toString() {
        return "KubernetesOperatorCert{" +
            "cert='" + this.cert +
            "', notBefore='" + this.notBefore +
            "', notAfter='" + this.notAfter +
            "'}";
    }
}
