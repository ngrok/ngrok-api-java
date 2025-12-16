/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link ServiceUser} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceUser {
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String id;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String name;
    @JsonProperty("active")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final boolean active;
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime createdAt;

    /**
     * Creates a new instance of {@link ServiceUser}.
     *
     * @param id unique API key resource identifier
     * @param uri URI to the API resource of this service user
     * @param name human-readable name used to identify the service
     * @param active whether or not the service is active
     * @param createdAt timestamp when the api key was created, RFC 3339 format
     */
    @JsonCreator
    public ServiceUser(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("name") final String name,
        @JsonProperty("active") final Boolean active,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.name = Objects.requireNonNull(name, "name is required");
        this.active = Objects.requireNonNull(active, "active is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
    }

    /**
     * unique API key resource identifier
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI to the API resource of this service user
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * human-readable name used to identify the service
     *
     * @return the value of the property as a {@link String}
     */
    public String getName() {
        return this.name;
    }

    /**
     * whether or not the service is active
     *
     * @return the value of the property as a {@link boolean}
     */
    public boolean getActive() {
        return this.active;
    }

    /**
     * timestamp when the api key was created, RFC 3339 format
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
        
        final ServiceUser other = (ServiceUser) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.name.equals(other.name)&&
            this.active == other.active&&
            this.createdAt.equals(other.createdAt);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.name,
            this.active,
            this.createdAt
        );
    }

    @Override
    public String toString() {
        return "ServiceUser{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', name='" + this.name +
            "', active='" + this.active +
            "', createdAt='" + this.createdAt +
            "'}";
    }
}
