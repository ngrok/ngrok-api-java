package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link ApplicationSession} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationSession {
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String id;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("public_url")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI publicUrl;
    @JsonProperty("browser_session")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final BrowserSession browserSession;
    @JsonProperty("application_user")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Ref> applicationUser;
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime createdAt;
    @JsonProperty("last_active")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime lastActive;
    @JsonProperty("expires_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime expiresAt;
    @JsonProperty("endpoint")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Ref> endpoint;
    @JsonProperty("edge")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Ref> edge;
    @JsonProperty("route")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Ref> route;

    /**
     * Creates a new instance of {@link ApplicationSession}.
     *
     * @param id unique application session resource identifier
     * @param uri URI of the application session API resource
     * @param publicUrl URL of the hostport served by this endpoint
     * @param browserSession browser session details of the application session
     * @param applicationUser application user this session is associated with
     * @param createdAt timestamp when the user was created in RFC 3339 format
     * @param lastActive timestamp when the user was last active in RFC 3339 format
     * @param expiresAt timestamp when session expires in RFC 3339 format
     * @param endpoint ephemeral endpoint this session is associated with
     * @param edge edge this session is associated with, null if the endpoint is agent-initiated
     * @param route route this session is associated with, null if the endpoint is agent-initiated
     */
    @JsonCreator
    public ApplicationSession(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("public_url") final java.net.URI publicUrl,
        @JsonProperty("browser_session") final BrowserSession browserSession,
        @JsonProperty("application_user") final Optional<Ref> applicationUser,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("last_active") final java.time.OffsetDateTime lastActive,
        @JsonProperty("expires_at") final java.time.OffsetDateTime expiresAt,
        @JsonProperty("endpoint") final Optional<Ref> endpoint,
        @JsonProperty("edge") final Optional<Ref> edge,
        @JsonProperty("route") final Optional<Ref> route
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.publicUrl = Objects.requireNonNull(publicUrl, "publicUrl is required");
        this.browserSession = Objects.requireNonNull(browserSession, "browserSession is required");
        this.applicationUser = applicationUser != null ? applicationUser : Optional.empty();
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.lastActive = Objects.requireNonNull(lastActive, "lastActive is required");
        this.expiresAt = Objects.requireNonNull(expiresAt, "expiresAt is required");
        this.endpoint = endpoint != null ? endpoint : Optional.empty();
        this.edge = edge != null ? edge : Optional.empty();
        this.route = route != null ? route : Optional.empty();
    }

    /**
     * unique application session resource identifier
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of the application session API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * URL of the hostport served by this endpoint
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getPublicUrl() {
        return this.publicUrl;
    }

    /**
     * browser session details of the application session
     *
     * @return the value of the property as a {@link BrowserSession}
     */
    public BrowserSession getBrowserSession() {
        return this.browserSession;
    }

    /**
     * application user this session is associated with
     *
     * @return the value of the property as a {@link Ref} wrapped in an {@link Optional}
     */
    public Optional<Ref> getApplicationUser() {
        return this.applicationUser;
    }

    /**
     * timestamp when the user was created in RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * timestamp when the user was last active in RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getLastActive() {
        return this.lastActive;
    }

    /**
     * timestamp when session expires in RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getExpiresAt() {
        return this.expiresAt;
    }

    /**
     * ephemeral endpoint this session is associated with
     *
     * @return the value of the property as a {@link Ref} wrapped in an {@link Optional}
     */
    public Optional<Ref> getEndpoint() {
        return this.endpoint;
    }

    /**
     * edge this session is associated with, null if the endpoint is agent-initiated
     *
     * @return the value of the property as a {@link Ref} wrapped in an {@link Optional}
     */
    public Optional<Ref> getEdge() {
        return this.edge;
    }

    /**
     * route this session is associated with, null if the endpoint is agent-initiated
     *
     * @return the value of the property as a {@link Ref} wrapped in an {@link Optional}
     */
    public Optional<Ref> getRoute() {
        return this.route;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final ApplicationSession other = (ApplicationSession) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.publicUrl.equals(other.publicUrl)&&
            this.browserSession.equals(other.browserSession)&&
            this.applicationUser.equals(other.applicationUser)&&
            this.createdAt.equals(other.createdAt)&&
            this.lastActive.equals(other.lastActive)&&
            this.expiresAt.equals(other.expiresAt)&&
            this.endpoint.equals(other.endpoint)&&
            this.edge.equals(other.edge)&&
            this.route.equals(other.route);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.publicUrl,
            this.browserSession,
            this.applicationUser,
            this.createdAt,
            this.lastActive,
            this.expiresAt,
            this.endpoint,
            this.edge,
            this.route
        );
    }

    @Override
    public String toString() {
        return "ApplicationSession{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', publicUrl='" + this.publicUrl +
            "', browserSession='" + this.browserSession +
            "', applicationUser='" + this.applicationUser.map(Object::toString).orElse("(null)") +
            "', createdAt='" + this.createdAt +
            "', lastActive='" + this.lastActive +
            "', expiresAt='" + this.expiresAt +
            "', endpoint='" + this.endpoint.map(Object::toString).orElse("(null)") +
            "', edge='" + this.edge.map(Object::toString).orElse("(null)") +
            "', route='" + this.route.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
