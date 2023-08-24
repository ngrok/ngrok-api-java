/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link AgentIngressCertJob} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgentIngressCertJob {
    @JsonProperty("error_code")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> errorCode;
    @JsonProperty("msg")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String msg;
    @JsonProperty("started_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime startedAt;
    @JsonProperty("retries_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.time.OffsetDateTime> retriesAt;

    /**
     * Creates a new instance of {@link AgentIngressCertJob}.
     *
     * @param errorCode if present, an error code indicating why provisioning is failing. It may be either a temporary condition (INTERNAL_ERROR), or a permanent one the user must correct (DNS_ERROR).
     * @param msg a message describing the current status or error
     * @param startedAt timestamp when the provisioning job started, RFC 3339 format
     * @param retriesAt timestamp when the provisioning job will be retried
     */
    @JsonCreator
    public AgentIngressCertJob(
        @JsonProperty("error_code") final Optional<String> errorCode,
        @JsonProperty("msg") final String msg,
        @JsonProperty("started_at") final java.time.OffsetDateTime startedAt,
        @JsonProperty("retries_at") final Optional<java.time.OffsetDateTime> retriesAt
    ) {
        this.errorCode = errorCode != null ? errorCode : Optional.empty();
        this.msg = Objects.requireNonNull(msg, "msg is required");
        this.startedAt = Objects.requireNonNull(startedAt, "startedAt is required");
        this.retriesAt = retriesAt != null ? retriesAt : Optional.empty();
    }

    /**
     * if present, an error code indicating why provisioning is failing. It may be
     * either a temporary condition (INTERNAL_ERROR), or a permanent one the user must
     * correct (DNS_ERROR).
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getErrorCode() {
        return this.errorCode;
    }

    /**
     * a message describing the current status or error
     *
     * @return the value of the property as a {@link String}
     */
    public String getMsg() {
        return this.msg;
    }

    /**
     * timestamp when the provisioning job started, RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getStartedAt() {
        return this.startedAt;
    }

    /**
     * timestamp when the provisioning job will be retried
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime} wrapped in an {@link Optional}
     */
    public Optional<java.time.OffsetDateTime> getRetriesAt() {
        return this.retriesAt;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final AgentIngressCertJob other = (AgentIngressCertJob) o;
        return
            this.errorCode.equals(other.errorCode)&&
            this.msg.equals(other.msg)&&
            this.startedAt.equals(other.startedAt)&&
            this.retriesAt.equals(other.retriesAt);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.errorCode,
            this.msg,
            this.startedAt,
            this.retriesAt
        );
    }

    @Override
    public String toString() {
        return "AgentIngressCertJob{" +
            "errorCode='" + this.errorCode.orElse("(null)") +
            "', msg='" + this.msg +
            "', startedAt='" + this.startedAt +
            "', retriesAt='" + this.retriesAt.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
