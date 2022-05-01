package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link TunnelList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TunnelList implements Pageable {
    @JsonProperty("tunnels")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<Tunnel> tunnels;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link TunnelList}.
     *
     * @param tunnels the list of all online tunnels on this account
     * @param uri URI of the tunnels list API resource
     * @param nextPageUri URI of the next page, or null if there is no next page
     */
    @JsonCreator
    public TunnelList(
        @JsonProperty("tunnels") final java.util.List<Tunnel> tunnels,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.tunnels = tunnels != null ? tunnels : java.util.Collections.emptyList();
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * the list of all online tunnels on this account
     *
     * @return the value of the property as a {@link java.util.List} of {@link Tunnel}
     */
    public java.util.List<Tunnel> getTunnels() {
        return this.tunnels;
    }

    /**
     * URI of the tunnels list API resource
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
        
        final TunnelList other = (TunnelList) o;
        return
            this.tunnels.equals(other.tunnels)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.tunnels,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "TunnelList{" +
            "tunnels='" + this.tunnels +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
