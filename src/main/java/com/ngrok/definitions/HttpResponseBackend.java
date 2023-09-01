/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link HttpResponseBackend} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HttpResponseBackend {
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
    @JsonProperty("body")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String body;
    @JsonProperty("headers")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.Map<String, String> headers;
    @JsonProperty("status_code")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final int statusCode;

    /**
     * Creates a new instance of {@link HttpResponseBackend}.
     *
     * @param id the value of the <code>id</code> parameter as a {@link String}
     * @param uri URI of the HTTPResponseBackend API resource
     * @param createdAt timestamp when the backend was created, RFC 3339 format
     * @param description human-readable description of this backend. Optional
     * @param metadata arbitrary user-defined machine-readable data of this backend. Optional
     * @param body body to return as fixed content
     * @param headers headers to return
     * @param statusCode status code to return
     */
    @JsonCreator
    public HttpResponseBackend(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("description") final Optional<String> description,
        @JsonProperty("metadata") final Optional<String> metadata,
        @JsonProperty("body") final String body,
        @JsonProperty("headers") final java.util.Map<String, String> headers,
        @JsonProperty("status_code") final Integer statusCode
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.description = description != null ? description : Optional.empty();
        this.metadata = metadata != null ? metadata : Optional.empty();
        this.body = Objects.requireNonNull(body, "body is required");
        this.headers = headers != null ? headers : java.util.Collections.emptyMap();
        this.statusCode = Objects.requireNonNull(statusCode, "statusCode is required");
    }

    /**
     * Fetches the value of the <code>id</code> property.
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of the HTTPResponseBackend API resource
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
     * body to return as fixed content
     *
     * @return the value of the property as a {@link String}
     */
    public String getBody() {
        return this.body;
    }

    /**
     * headers to return
     *
     * @return the value of the property as a {@link java.util.Map} of {@link String} to {@link String}
     */
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    /**
     * status code to return
     *
     * @return the value of the property as a {@link int}
     */
    public int getStatusCode() {
        return this.statusCode;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final HttpResponseBackend other = (HttpResponseBackend) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.createdAt.equals(other.createdAt)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.body.equals(other.body)&&
            this.headers.equals(other.headers)&&
            this.statusCode == other.statusCode;
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.createdAt,
            this.description,
            this.metadata,
            this.body,
            this.headers,
            this.statusCode
        );
    }

    @Override
    public String toString() {
        return "HttpResponseBackend{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', createdAt='" + this.createdAt +
            "', description='" + this.description.orElse("(null)") +
            "', metadata='" + this.metadata.orElse("(null)") +
            "', body='" + this.body +
            "', headers='" + this.headers +
            "', statusCode='" + this.statusCode +
            "'}";
    }
}
