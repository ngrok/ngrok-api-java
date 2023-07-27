/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link AbuseReport} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AbuseReport {
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String id;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime createdAt;
    @JsonProperty("urls")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<java.net.URI> urls;
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> metadata;
    @JsonProperty("status")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String status;
    @JsonProperty("hostnames")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<AbuseReportHostname> hostnames;

    /**
     * Creates a new instance of {@link AbuseReport}.
     *
     * @param id ID of the abuse report
     * @param uri URI of the abuse report API resource
     * @param createdAt timestamp that the abuse report record was created in RFC 3339 format
     * @param urls a list of URLs containing suspected abusive content
     * @param metadata arbitrary user-defined data about this abuse report. Optional, max 4096 bytes.
     * @param status Indicates whether ngrok has processed the abuse report. one of <code>PENDING</code>, <code>PROCESSED</code>, or <code>PARTIALLY_PROCESSED</code>
     * @param hostnames an array of hostname statuses related to the report
     */
    @JsonCreator
    public AbuseReport(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("urls") final java.util.List<java.net.URI> urls,
        @JsonProperty("metadata") final Optional<String> metadata,
        @JsonProperty("status") final String status,
        @JsonProperty("hostnames") final java.util.List<AbuseReportHostname> hostnames
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.urls = urls != null ? urls : java.util.Collections.emptyList();
        this.metadata = metadata != null ? metadata : Optional.empty();
        this.status = Objects.requireNonNull(status, "status is required");
        this.hostnames = hostnames != null ? hostnames : java.util.Collections.emptyList();
    }

    /**
     * ID of the abuse report
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of the abuse report API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * timestamp that the abuse report record was created in RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * a list of URLs containing suspected abusive content
     *
     * @return the value of the property as a {@link java.util.List} of {@link java.net.URI}
     */
    public java.util.List<java.net.URI> getUrls() {
        return this.urls;
    }

    /**
     * arbitrary user-defined data about this abuse report. Optional, max 4096 bytes.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getMetadata() {
        return this.metadata;
    }

    /**
     * Indicates whether ngrok has processed the abuse report. one of
     * <code>PENDING</code>, <code>PROCESSED</code>, or
     * <code>PARTIALLY_PROCESSED</code>
     *
     * @return the value of the property as a {@link String}
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * an array of hostname statuses related to the report
     *
     * @return the value of the property as a {@link java.util.List} of {@link AbuseReportHostname}
     */
    public java.util.List<AbuseReportHostname> getHostnames() {
        return this.hostnames;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final AbuseReport other = (AbuseReport) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.createdAt.equals(other.createdAt)&&
            this.urls.equals(other.urls)&&
            this.metadata.equals(other.metadata)&&
            this.status.equals(other.status)&&
            this.hostnames.equals(other.hostnames);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.createdAt,
            this.urls,
            this.metadata,
            this.status,
            this.hostnames
        );
    }

    @Override
    public String toString() {
        return "AbuseReport{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', createdAt='" + this.createdAt +
            "', urls='" + this.urls +
            "', metadata='" + this.metadata.orElse("(null)") +
            "', status='" + this.status +
            "', hostnames='" + this.hostnames +
            "'}";
    }
}
