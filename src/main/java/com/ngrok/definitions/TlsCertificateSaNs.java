package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link TlsCertificateSaNs} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TlsCertificateSaNs {
    @JsonProperty("dns_names")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> dnsNames;
    @JsonProperty("ips")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> ips;

    /**
     * Creates a new instance of {@link TlsCertificateSaNs}.
     *
     * @param dnsNames set of additional domains (including wildcards) this TLS certificate is valid for
     * @param ips set of IP addresses this TLS certificate is also valid for
     */
    @JsonCreator
    public TlsCertificateSaNs(
        @JsonProperty("dns_names") final java.util.List<String> dnsNames,
        @JsonProperty("ips") final java.util.List<String> ips
    ) {
        this.dnsNames = dnsNames != null ? dnsNames : java.util.Collections.emptyList();
        this.ips = ips != null ? ips : java.util.Collections.emptyList();
    }

    /**
     * set of additional domains (including wildcards) this TLS certificate is valid
     * for
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getDnsNames() {
        return this.dnsNames;
    }

    /**
     * set of IP addresses this TLS certificate is also valid for
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getIps() {
        return this.ips;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final TlsCertificateSaNs other = (TlsCertificateSaNs) o;
        return
            this.dnsNames.equals(other.dnsNames)&&
            this.ips.equals(other.ips);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.dnsNames,
            this.ips
        );
    }

    @Override
    public String toString() {
        return "TlsCertificateSaNs{" +
            "dnsNames='" + this.dnsNames +
            "', ips='" + this.ips +
            "'}";
    }
}
