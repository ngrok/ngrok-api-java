/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link ApplicationSessionList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApplicationSessionList implements Pageable {
    @JsonProperty("application_sessions")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<ApplicationSession> applicationSessions;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link ApplicationSessionList}.
     *
     * @param applicationSessions list of all application sessions on this account
     * @param uri URI of the application session list API resource
     * @param nextPageUri URI of the next page, or null if there is no next page
     */
    @JsonCreator
    public ApplicationSessionList(
        @JsonProperty("application_sessions") final java.util.List<ApplicationSession> applicationSessions,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.applicationSessions = applicationSessions != null ? applicationSessions : java.util.Collections.emptyList();
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * list of all application sessions on this account
     *
     * @return the value of the property as a {@link java.util.List} of {@link ApplicationSession}
     */
    public java.util.List<ApplicationSession> getApplicationSessions() {
        return this.applicationSessions;
    }

    /**
     * URI of the application session list API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * URI of the next page, or null if there is no next page
     *
     * @return the value of the property as a {@link java.net.URI} wrapped in an {@link Optional}
     */
    public Optional<java.net.URI> getNextPageUri() {
        return this.nextPageUri;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final ApplicationSessionList other = (ApplicationSessionList) o;
        return
            this.applicationSessions.equals(other.applicationSessions)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.applicationSessions,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "ApplicationSessionList{" +
            "applicationSessions='" + this.applicationSessions +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
