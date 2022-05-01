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
    private final String description;
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String metadata;
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
     */
    @JsonCreator
    public AgentIngress(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("description") final String description,
        @JsonProperty("metadata") final String metadata,
        @JsonProperty("domain") final String domain,
        @JsonProperty("ns_targets") final java.util.List<String> nsTargets,
        @JsonProperty("region_domains") final java.util.List<String> regionDomains,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.description = Objects.requireNonNull(description, "description is required");
        this.metadata = Objects.requireNonNull(metadata, "metadata is required");
        this.domain = Objects.requireNonNull(domain, "domain is required");
        this.nsTargets = nsTargets != null ? nsTargets : java.util.Collections.emptyList();
        this.regionDomains = regionDomains != null ? regionDomains : java.util.Collections.emptyList();
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
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
     * @return the value of the property as a {@link String}
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * arbitrary user-defined machine-readable data of this Agent Ingress. optional,
     * max 4096 bytes
     *
     * @return the value of the property as a {@link String}
     */
    public String getMetadata() {
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
            this.createdAt.equals(other.createdAt);
        
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
            this.createdAt
        );
    }

    @Override
    public String toString() {
        return "AgentIngress{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', description='" + this.description +
            "', metadata='" + this.metadata +
            "', domain='" + this.domain +
            "', nsTargets='" + this.nsTargets +
            "', regionDomains='" + this.regionDomains +
            "', createdAt='" + this.createdAt +
            "'}";
    }
}
