package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link AbuseReportHostname} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AbuseReportHostname {
    @JsonProperty("hostname")
    private final String hostname;
    @JsonProperty("status")
    private final String status;

    /**
     * Creates a new instance of {@link AbuseReportHostname}.
     *
     * @param hostname the hostname ngrok has parsed out of one of the reported URLs in this abuse report
     * @param status indicates what action ngrok has taken against the hostname. one of <code>PENDING</code>, <code>BANNED</code>, <code>UNBANNED</code>, or <code>IGNORE</code>
     */
    @JsonCreator
    public AbuseReportHostname(
        @JsonProperty("hostname") final String hostname,
        @JsonProperty("status") final String status
    ) {
        this.hostname = Objects.requireNonNull(hostname, "hostname is required");
        this.status = Objects.requireNonNull(status, "status is required");
    }

    /**
     * the hostname ngrok has parsed out of one of the reported URLs in this abuse
     * report
     *
     * @return the value of the property as a {@link String}
     */
    public String getHostname() {
        return this.hostname;
    }

    /**
     * indicates what action ngrok has taken against the hostname. one of
     * <code>PENDING</code>, <code>BANNED</code>, <code>UNBANNED</code>, or
     * <code>IGNORE</code>
     *
     * @return the value of the property as a {@link String}
     */
    public String getStatus() {
        return this.status;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final AbuseReportHostname other = (AbuseReportHostname) o;
        return
            this.hostname.equals(other.hostname)&&
            this.status.equals(other.status);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.hostname,
            this.status
        );
    }

    @Override
    public String toString() {
        return "AbuseReportHostname{" +
            "hostname='" + this.hostname +
            "', status='" + this.status +
            "'}";
    }
}
