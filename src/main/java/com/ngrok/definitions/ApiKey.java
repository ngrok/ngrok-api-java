package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link ApiKey} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiKey {
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
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime createdAt;
    @JsonProperty("token")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> token;
    @JsonProperty("owner_id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> ownerId;

    /**
     * Creates a new instance of {@link ApiKey}.
     *
     * @param id unique API key resource identifier
     * @param uri URI to the API resource of this API key
     * @param description human-readable description of what uses the API key to authenticate. optional, max 255 bytes.
     * @param metadata arbitrary user-defined data of this API key. optional, max 4096 bytes
     * @param createdAt timestamp when the api key was created, RFC 3339 format
     * @param token the bearer token that can be placed into the Authorization header to authenticate request to the ngrok API. <strong>This value is only available one time, on the API response from key creation. Otherwise it is null.</strong>
     * @param ownerId If supplied at credential creation, ownership will be assigned to the specified User or Bot. Only admins may specify an owner other than themselves. Defaults to the authenticated User or Bot.
     */
    @JsonCreator
    public ApiKey(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("description") final String description,
        @JsonProperty("metadata") final String metadata,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("token") final Optional<String> token,
        @JsonProperty("owner_id") final Optional<String> ownerId
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.description = Objects.requireNonNull(description, "description is required");
        this.metadata = Objects.requireNonNull(metadata, "metadata is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.token = token != null ? token : Optional.empty();
        this.ownerId = ownerId != null ? ownerId : Optional.empty();
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
     * URI to the API resource of this API key
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * human-readable description of what uses the API key to authenticate. optional,
     * max 255 bytes.
     *
     * @return the value of the property as a {@link String}
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * arbitrary user-defined data of this API key. optional, max 4096 bytes
     *
     * @return the value of the property as a {@link String}
     */
    public String getMetadata() {
        return this.metadata;
    }

    /**
     * timestamp when the api key was created, RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * the bearer token that can be placed into the Authorization header to
     * authenticate request to the ngrok API. <strong>This value is only available one
     * time, on the API response from key creation. Otherwise it is null.</strong>
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getToken() {
        return this.token;
    }

    /**
     * If supplied at credential creation, ownership will be assigned to the specified
     * User or Bot. Only admins may specify an owner other than themselves. Defaults to
     * the authenticated User or Bot.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getOwnerId() {
        return this.ownerId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final ApiKey other = (ApiKey) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.createdAt.equals(other.createdAt)&&
            this.token.equals(other.token)&&
            this.ownerId.equals(other.ownerId);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.description,
            this.metadata,
            this.createdAt,
            this.token,
            this.ownerId
        );
    }

    @Override
    public String toString() {
        return "ApiKey{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', description='" + this.description +
            "', metadata='" + this.metadata +
            "', createdAt='" + this.createdAt +
            "', token='" + this.token.orElse("(null)") +
            "', ownerId='" + this.ownerId.orElse("(null)") +
            "'}";
    }
}
