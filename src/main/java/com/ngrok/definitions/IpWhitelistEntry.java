package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link IpWhitelistEntry} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IpWhitelistEntry {
    @JsonProperty("id")
    private final String id;
    @JsonProperty("uri")
    private final java.net.URI uri;
    @JsonProperty("created_at")
    private final java.time.OffsetDateTime createdAt;
    @JsonProperty("description")
    private final String description;
    @JsonProperty("metadata")
    private final String metadata;
    @JsonProperty("ip_net")
    private final String ipNet;

    /**
     * Creates a new instance of {@link IpWhitelistEntry}.
     *
     * @param id unique identifier for this IP whitelist entry
     * @param uri URI of the IP whitelist entry API resource
     * @param createdAt timestamp when the IP whitelist entry was created, RFC 3339 format
     * @param description human-readable description of the source IPs for this IP whitelist entry. optional, max 255 bytes.
     * @param metadata arbitrary user-defined machine-readable data of this IP whitelist entry. optional, max 4096 bytes.
     * @param ipNet an IP address or IP network range in CIDR notation (e.g. 10.1.1.1 or 10.1.0.0/16) of addresses that will be whitelisted to communicate with your tunnel endpoints
     */
    @JsonCreator
    public IpWhitelistEntry(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("description") final String description,
        @JsonProperty("metadata") final String metadata,
        @JsonProperty("ip_net") final String ipNet
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.description = Objects.requireNonNull(description, "description is required");
        this.metadata = Objects.requireNonNull(metadata, "metadata is required");
        this.ipNet = Objects.requireNonNull(ipNet, "ipNet is required");
    }

    /**
     * unique identifier for this IP whitelist entry
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of the IP whitelist entry API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * timestamp when the IP whitelist entry was created, RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * human-readable description of the source IPs for this IP whitelist entry.
     * optional, max 255 bytes.
     *
     * @return the value of the property as a {@link String}
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * arbitrary user-defined machine-readable data of this IP whitelist entry.
     * optional, max 4096 bytes.
     *
     * @return the value of the property as a {@link String}
     */
    public String getMetadata() {
        return this.metadata;
    }

    /**
     * an IP address or IP network range in CIDR notation (e.g. 10.1.1.1 or
     * 10.1.0.0/16) of addresses that will be whitelisted to communicate with your
     * tunnel endpoints
     *
     * @return the value of the property as a {@link String}
     */
    public String getIpNet() {
        return this.ipNet;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final IpWhitelistEntry other = (IpWhitelistEntry) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.createdAt.equals(other.createdAt)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.ipNet.equals(other.ipNet);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.createdAt,
            this.description,
            this.metadata,
            this.ipNet
        );
    }

    @Override
    public String toString() {
        return "IpWhitelistEntry{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', createdAt='" + this.createdAt +
            "', description='" + this.description +
            "', metadata='" + this.metadata +
            "', ipNet='" + this.ipNet +
            "'}";
    }
}
