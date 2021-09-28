package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link ReservedDomainCertNsTarget} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservedDomainCertNsTarget {
    @JsonProperty("zone")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String zone;
    @JsonProperty("nameservers")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> nameservers;

    /**
     * Creates a new instance of {@link ReservedDomainCertNsTarget}.
     *
     * @param zone the zone that the nameservers need to be applied to
     * @param nameservers the nameservers the user must add
     */
    @JsonCreator
    public ReservedDomainCertNsTarget(
        @JsonProperty("zone") final String zone,
        @JsonProperty("nameservers") final java.util.List<String> nameservers
    ) {
        this.zone = Objects.requireNonNull(zone, "zone is required");
        this.nameservers = Objects.requireNonNull(nameservers, "nameservers is required");
    }

    /**
     * the zone that the nameservers need to be applied to
     *
     * @return the value of the property as a {@link String}
     */
    public String getZone() {
        return this.zone;
    }

    /**
     * the nameservers the user must add
     *
     * @return the value of the property as a {@link java.util.List<String>}
     */
    public java.util.List<String> getNameservers() {
        return this.nameservers;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final ReservedDomainCertNsTarget other = (ReservedDomainCertNsTarget) o;
        return
            this.zone.equals(other.zone)&&
            this.nameservers.equals(other.nameservers);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.zone,
            this.nameservers
        );
    }

    @Override
    public String toString() {
        return "ReservedDomainCertNsTarget{" +
            "zone='" + this.zone +
            "', nameservers='" + this.nameservers +
            "'}";
    }
}
