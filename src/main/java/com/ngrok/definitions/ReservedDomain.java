/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link ReservedDomain} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservedDomain {
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String id;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime createdAt;
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> description;
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> metadata;
    @JsonProperty("domain")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String domain;
    @JsonProperty("region")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String region;
    @JsonProperty("cname_target")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> cnameTarget;
    @JsonProperty("certificate")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Ref> certificate;
    @JsonProperty("certificate_management_policy")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<ReservedDomainCertPolicy> certificateManagementPolicy;
    @JsonProperty("certificate_management_status")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<ReservedDomainCertStatus> certificateManagementStatus;
    @JsonProperty("acme_challenge_cname_target")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> acmeChallengeCnameTarget;

    /**
     * Creates a new instance of {@link ReservedDomain}.
     *
     * @param id unique reserved domain resource identifier
     * @param uri URI of the reserved domain API resource
     * @param createdAt timestamp when the reserved domain was created, RFC 3339 format
     * @param description human-readable description of what this reserved domain will be used for
     * @param metadata arbitrary user-defined machine-readable data of this reserved domain. Optional, max 4096 bytes.
     * @param domain hostname of the reserved domain
     * @param region deprecated: With the launch of the ngrok Global Network domains traffic is now handled globally. This field applied only to endpoints. Note that agents may still connect to specific regions. Optional, null by default. (au, eu, ap, us, jp, in, sa)
     * @param cnameTarget DNS CNAME target for a custom hostname, or null if the reserved domain is a subdomain of an ngrok owned domain (e.g. *.ngrok.app)
     * @param certificate object referencing the TLS certificate used for connections to this domain. This can be either a user-uploaded certificate, the most recently issued automatic one, or null otherwise.
     * @param certificateManagementPolicy configuration for automatic management of TLS certificates for this domain, or null if automatic management is disabled
     * @param certificateManagementStatus status of the automatic certificate management for this domain, or null if automatic management is disabled
     * @param acmeChallengeCnameTarget DNS CNAME target for the host _acme-challenge.example.com, where example.com is your reserved domain name. This is required to issue certificates for wildcard, non-ngrok reserved domains. Must be null for non-wildcard domains and ngrok subdomains.
     */
    @JsonCreator
    public ReservedDomain(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("description") final Optional<String> description,
        @JsonProperty("metadata") final Optional<String> metadata,
        @JsonProperty("domain") final String domain,
        @JsonProperty("region") final String region,
        @JsonProperty("cname_target") final Optional<String> cnameTarget,
        @JsonProperty("certificate") final Optional<Ref> certificate,
        @JsonProperty("certificate_management_policy") final Optional<ReservedDomainCertPolicy> certificateManagementPolicy,
        @JsonProperty("certificate_management_status") final Optional<ReservedDomainCertStatus> certificateManagementStatus,
        @JsonProperty("acme_challenge_cname_target") final Optional<String> acmeChallengeCnameTarget
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.description = description != null ? description : Optional.empty();
        this.metadata = metadata != null ? metadata : Optional.empty();
        this.domain = Objects.requireNonNull(domain, "domain is required");
        this.region = Objects.requireNonNull(region, "region is required");
        this.cnameTarget = cnameTarget != null ? cnameTarget : Optional.empty();
        this.certificate = certificate != null ? certificate : Optional.empty();
        this.certificateManagementPolicy = certificateManagementPolicy != null ? certificateManagementPolicy : Optional.empty();
        this.certificateManagementStatus = certificateManagementStatus != null ? certificateManagementStatus : Optional.empty();
        this.acmeChallengeCnameTarget = acmeChallengeCnameTarget != null ? acmeChallengeCnameTarget : Optional.empty();
    }

    /**
     * unique reserved domain resource identifier
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of the reserved domain API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * timestamp when the reserved domain was created, RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * human-readable description of what this reserved domain will be used for
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getDescription() {
        return this.description;
    }

    /**
     * arbitrary user-defined machine-readable data of this reserved domain. Optional,
     * max 4096 bytes.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getMetadata() {
        return this.metadata;
    }

    /**
     * hostname of the reserved domain
     *
     * @return the value of the property as a {@link String}
     */
    public String getDomain() {
        return this.domain;
    }

    /**
     * deprecated: With the launch of the ngrok Global Network domains traffic is now
     * handled globally. This field applied only to endpoints. Note that agents may
     * still connect to specific regions. Optional, null by default. (au, eu, ap, us,
     * jp, in, sa)
     *
     * @return the value of the property as a {@link String}
     */
    public String getRegion() {
        return this.region;
    }

    /**
     * DNS CNAME target for a custom hostname, or null if the reserved domain is a
     * subdomain of an ngrok owned domain (e.g. *.ngrok.app)
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getCnameTarget() {
        return this.cnameTarget;
    }

    /**
     * object referencing the TLS certificate used for connections to this domain. This
     * can be either a user-uploaded certificate, the most recently issued automatic
     * one, or null otherwise.
     *
     * @return the value of the property as a {@link Ref} wrapped in an {@link Optional}
     */
    public Optional<Ref> getCertificate() {
        return this.certificate;
    }

    /**
     * configuration for automatic management of TLS certificates for this domain, or
     * null if automatic management is disabled
     *
     * @return the value of the property as a {@link ReservedDomainCertPolicy} wrapped in an {@link Optional}
     */
    public Optional<ReservedDomainCertPolicy> getCertificateManagementPolicy() {
        return this.certificateManagementPolicy;
    }

    /**
     * status of the automatic certificate management for this domain, or null if
     * automatic management is disabled
     *
     * @return the value of the property as a {@link ReservedDomainCertStatus} wrapped in an {@link Optional}
     */
    public Optional<ReservedDomainCertStatus> getCertificateManagementStatus() {
        return this.certificateManagementStatus;
    }

    /**
     * DNS CNAME target for the host _acme-challenge.example.com, where example.com is
     * your reserved domain name. This is required to issue certificates for wildcard,
     * non-ngrok reserved domains. Must be null for non-wildcard domains and ngrok
     * subdomains.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getAcmeChallengeCnameTarget() {
        return this.acmeChallengeCnameTarget;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final ReservedDomain other = (ReservedDomain) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.createdAt.equals(other.createdAt)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.domain.equals(other.domain)&&
            this.region.equals(other.region)&&
            this.cnameTarget.equals(other.cnameTarget)&&
            this.certificate.equals(other.certificate)&&
            this.certificateManagementPolicy.equals(other.certificateManagementPolicy)&&
            this.certificateManagementStatus.equals(other.certificateManagementStatus)&&
            this.acmeChallengeCnameTarget.equals(other.acmeChallengeCnameTarget);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.createdAt,
            this.description,
            this.metadata,
            this.domain,
            this.region,
            this.cnameTarget,
            this.certificate,
            this.certificateManagementPolicy,
            this.certificateManagementStatus,
            this.acmeChallengeCnameTarget
        );
    }

    @Override
    public String toString() {
        return "ReservedDomain{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', createdAt='" + this.createdAt +
            "', description='" + this.description.orElse("(null)") +
            "', metadata='" + this.metadata.orElse("(null)") +
            "', domain='" + this.domain +
            "', region='" + this.region +
            "', cnameTarget='" + this.cnameTarget.orElse("(null)") +
            "', certificate='" + this.certificate.map(Object::toString).orElse("(null)") +
            "', certificateManagementPolicy='" + this.certificateManagementPolicy.map(Object::toString).orElse("(null)") +
            "', certificateManagementStatus='" + this.certificateManagementStatus.map(Object::toString).orElse("(null)") +
            "', acmeChallengeCnameTarget='" + this.acmeChallengeCnameTarget.orElse("(null)") +
            "'}";
    }
}
