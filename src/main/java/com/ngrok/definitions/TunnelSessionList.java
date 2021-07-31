package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link TunnelSessionList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TunnelSessionList implements Pageable {
    @JsonProperty("tunnel_sessions")
    private final java.util.List<TunnelSession> tunnelSessions;
    @JsonProperty("uri")
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link TunnelSessionList}.
     *
     * @param tunnelSessions list of all tunnel sessions on this account
     * @param uri URI to the API resource of the tunnel session list
     * @param nextPageUri URI of the next page, or null if there is no next page
     */
    @JsonCreator
    public TunnelSessionList(
        @JsonProperty("tunnel_sessions") final java.util.List<TunnelSession> tunnelSessions,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.tunnelSessions = Objects.requireNonNull(tunnelSessions, "tunnelSessions is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * list of all tunnel sessions on this account
     *
     * @return the value of the property as a {@link java.util.List<TunnelSession>}
     */
    public java.util.List<TunnelSession> getTunnelSessions() {
        return this.tunnelSessions;
    }

    /**
     * URI to the API resource of the tunnel session list
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
        
        final TunnelSessionList other = (TunnelSessionList) o;
        return
            this.tunnelSessions.equals(other.tunnelSessions)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.tunnelSessions,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "TunnelSessionList{" +
            "tunnelSessions='" + this.tunnelSessions +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
