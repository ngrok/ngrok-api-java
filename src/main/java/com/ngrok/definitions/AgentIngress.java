/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link AgentIngress} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgentIngress {
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String id;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> description;
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> metadata;
    @JsonProperty("domain")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String domain;
    @JsonProperty("ns_targets")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> nsTargets;
    @JsonProperty("region_domains")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> regionDomains;
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime createdAt;
    @JsonProperty("certificate_management_policy")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<AgentIngressCertPolicy> certificateManagementPolicy;
    @JsonProperty("certificate_management_status")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<AgentIngressCertStatus> certificateManagementStatus;

    /**
     * Creates a new instance of {@link AgentIngress}.
     *
     * @param id unique Agent Ingress resource identifier
     * @param uri URI to the API resource of this Agent ingress
     * @param description human-readable description of the use of this Agent Ingress. optional, max 255 bytes.
     * @param metadata arbitrary user-defined machine-readable data of this Agent Ingress. optional, max 4096 bytes
     * @param domain the domain that you own to be used as the base domain name to generate regional agent ingress domains.
     * @param nsTargets a list of target values to use as the values of NS records for the domain property these values will delegate control over the domain to ngrok
     * @param regionDomains a list of regional agent ingress domains that are subdomains of the value of domain this value may increase over time as ngrok adds more regions
     * @param createdAt timestamp when the Agent Ingress was created, RFC 3339 format
     * @param certificateManagementPolicy configuration for automatic management of TLS certificates for this domain, or null if automatic management is disabled
     * @param certificateManagementStatus status of the automatic certificate management for this domain, or null if automatic management is disabled
     */
    @JsonCreator
    public AgentIngress(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("description") final Optional<String> description,
        @JsonProperty("metadata") final Optional<String> metadata,
        @JsonProperty("domain") final String domain,
        @JsonProperty("ns_targets") final java.util.List<String> nsTargets,
        @JsonProperty("region_domains") final java.util.List<String> regionDomains,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("certificate_management_policy") final Optional<AgentIngressCertPolicy> certificateManagementPolicy,
        @JsonProperty("certificate_management_status") final Optional<AgentIngressCertStatus> certificateManagementStatus
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.description = description != null ? description : Optional.empty();
        this.metadata = metadata != null ? metadata : Optional.empty();
        this.domain = Objects.requireNonNull(domain, "domain is required");
        this.nsTargets = nsTargets != null ? nsTargets : java.util.Collections.emptyList();
        this.regionDomains = regionDomains != null ? regionDomains : java.util.Collections.emptyList();
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.certificateManagementPolicy = certificateManagementPolicy != null ? certificateManagementPolicy : Optional.empty();
        this.certificateManagementStatus = certificateManagementStatus != null ? certificateManagementStatus : Optional.empty();
    }

    /**
     * unique Agent Ingress resource identifier
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI to the API resource of this Agent ingress
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * human-readable description of the use of this Agent Ingress. optional, max 255
     * bytes.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getDescription() {
        return this.description;
    }

    /**
     * arbitrary user-defined machine-readable data of this Agent Ingress. optional,
     * max 4096 bytes
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getMetadata() {
        return this.metadata;
    }

    /**
     * the domain that you own to be used as the base domain name to generate regional
     * agent ingress domains.
     *
     * @return the value of the property as a {@link String}
     */
    public String getDomain() {
        return this.domain;
    }

    /**
     * a list of target values to use as the values of NS records for the domain
     * property these values will delegate control over the domain to ngrok
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getNsTargets() {
        return this.nsTargets;
    }

    /**
     * a list of regional agent ingress domains that are subdomains of the value of
     * domain this value may increase over time as ngrok adds more regions
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getRegionDomains() {
        return this.regionDomains;
    }

    /**
     * timestamp when the Agent Ingress was created, RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * configuration for automatic management of TLS certificates for this domain, or
     * null if automatic management is disabled
     *
     * @return the value of the property as a {@link AgentIngressCertPolicy} wrapped in an {@link Optional}
     */
    public Optional<AgentIngressCertPolicy> getCertificateManagementPolicy() {
        return this.certificateManagementPolicy;
    }

    /**
     * status of the automatic certificate management for this domain, or null if
     * automatic management is disabled
     *
     * @return the value of the property as a {@link AgentIngressCertStatus} wrapped in an {@link Optional}
     */
    public Optional<AgentIngressCertStatus> getCertificateManagementStatus() {
        return this.certificateManagementStatus;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final AgentIngress other = (AgentIngress) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.domain.equals(other.domain)&&
            this.nsTargets.equals(other.nsTargets)&&
            this.regionDomains.equals(other.regionDomains)&&
            this.createdAt.equals(other.createdAt)&&
            this.certificateManagementPolicy.equals(other.certificateManagementPolicy)&&
            this.certificateManagementStatus.equals(other.certificateManagementStatus);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.description,
            this.metadata,
            this.domain,
            this.nsTargets,
            this.regionDomains,
            this.createdAt,
            this.certificateManagementPolicy,
            this.certificateManagementStatus
        );
    }

    @Override
    public String toString() {
        return "AgentIngress{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', description='" + this.description.orElse("(null)") +
            "', metadata='" + this.metadata.orElse("(null)") +
            "', domain='" + this.domain +
            "', nsTargets='" + this.nsTargets +
            "', regionDomains='" + this.regionDomains +
            "', createdAt='" + this.createdAt +
            "', certificateManagementPolicy='" + this.certificateManagementPolicy.map(Object::toString).orElse("(null)") +
            "', certificateManagementStatus='" + this.certificateManagementStatus.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
