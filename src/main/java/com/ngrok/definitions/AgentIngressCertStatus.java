/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link AgentIngressCertStatus} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgentIngressCertStatus {
    @JsonProperty("renews_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.time.OffsetDateTime> renewsAt;
    @JsonProperty("provisioning_job")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<AgentIngressCertJob> provisioningJob;

    /**
     * Creates a new instance of {@link AgentIngressCertStatus}.
     *
     * @param renewsAt timestamp when the next renewal will be requested, RFC 3339 format
     * @param provisioningJob status of the certificate provisioning job, or null if the certificiate isn&#39;t being provisioned or renewed
     */
    @JsonCreator
    public AgentIngressCertStatus(
        @JsonProperty("renews_at") final Optional<java.time.OffsetDateTime> renewsAt,
        @JsonProperty("provisioning_job") final Optional<AgentIngressCertJob> provisioningJob
    ) {
        this.renewsAt = renewsAt != null ? renewsAt : Optional.empty();
        this.provisioningJob = provisioningJob != null ? provisioningJob : Optional.empty();
    }

    /**
     * timestamp when the next renewal will be requested, RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime} wrapped in an {@link Optional}
     */
    public Optional<java.time.OffsetDateTime> getRenewsAt() {
        return this.renewsAt;
    }

    /**
     * status of the certificate provisioning job, or null if the certificiate
     * isn&#39;t being provisioned or renewed
     *
     * @return the value of the property as a {@link AgentIngressCertJob} wrapped in an {@link Optional}
     */
    public Optional<AgentIngressCertJob> getProvisioningJob() {
        return this.provisioningJob;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final AgentIngressCertStatus other = (AgentIngressCertStatus) o;
        return
            this.renewsAt.equals(other.renewsAt)&&
            this.provisioningJob.equals(other.provisioningJob);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.renewsAt,
            this.provisioningJob
        );
    }

    @Override
    public String toString() {
        return "AgentIngressCertStatus{" +
            "renewsAt='" + this.renewsAt.map(Object::toString).orElse("(null)") +
            "', provisioningJob='" + this.provisioningJob.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
