/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link TunnelGroupBackend} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TunnelGroupBackend {
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
    @JsonProperty("labels")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.Map<String, String> labels;
    @JsonProperty("tunnels")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<Ref> tunnels;

    /**
     * Creates a new instance of {@link TunnelGroupBackend}.
     *
     * @param id unique identifier for this TunnelGroup backend
     * @param uri URI of the TunnelGroupBackend API resource
     * @param createdAt timestamp when the backend was created, RFC 3339 format
     * @param description human-readable description of this backend. Optional
     * @param metadata arbitrary user-defined machine-readable data of this backend. Optional
     * @param labels labels to watch for tunnels on, e.g. app-&gt;foo, dc-&gt;bar
     * @param tunnels tunnels matching this backend
     */
    @JsonCreator
    public TunnelGroupBackend(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("description") final Optional<String> description,
        @JsonProperty("metadata") final Optional<String> metadata,
        @JsonProperty("labels") final java.util.Map<String, String> labels,
        @JsonProperty("tunnels") final java.util.List<Ref> tunnels
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.description = description != null ? description : Optional.empty();
        this.metadata = metadata != null ? metadata : Optional.empty();
        this.labels = labels != null ? labels : java.util.Collections.emptyMap();
        this.tunnels = tunnels != null ? tunnels : java.util.Collections.emptyList();
    }

    /**
     * unique identifier for this TunnelGroup backend
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of the TunnelGroupBackend API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * timestamp when the backend was created, RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * human-readable description of this backend. Optional
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getDescription() {
        return this.description;
    }

    /**
     * arbitrary user-defined machine-readable data of this backend. Optional
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getMetadata() {
        return this.metadata;
    }

    /**
     * labels to watch for tunnels on, e.g. app-&gt;foo, dc-&gt;bar
     *
     * @return the value of the property as a {@link java.util.Map} of {@link String} to {@link String}
     */
    public java.util.Map<String, String> getLabels() {
        return this.labels;
    }

    /**
     * tunnels matching this backend
     *
     * @return the value of the property as a {@link java.util.List} of {@link Ref}
     */
    public java.util.List<Ref> getTunnels() {
        return this.tunnels;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final TunnelGroupBackend other = (TunnelGroupBackend) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.createdAt.equals(other.createdAt)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.labels.equals(other.labels)&&
            this.tunnels.equals(other.tunnels);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.createdAt,
            this.description,
            this.metadata,
            this.labels,
            this.tunnels
        );
    }

    @Override
    public String toString() {
        return "TunnelGroupBackend{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', createdAt='" + this.createdAt +
            "', description='" + this.description.orElse("(null)") +
            "', metadata='" + this.metadata.orElse("(null)") +
            "', labels='" + this.labels +
            "', tunnels='" + this.tunnels +
            "'}";
    }
}
