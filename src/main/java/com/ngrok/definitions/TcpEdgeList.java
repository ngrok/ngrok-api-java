package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link TcpEdgeList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TcpEdgeList implements Pageable {
    @JsonProperty("tcp_edges")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<TcpEdge> tcpEdges;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link TcpEdgeList}.
     *
     * @param tcpEdges the list of all TCP Edges on this account
     * @param uri URI of the TCP Edge list API resource
     * @param nextPageUri URI of the next page, or null if there is no next page
     */
    @JsonCreator
    public TcpEdgeList(
        @JsonProperty("tcp_edges") final java.util.List<TcpEdge> tcpEdges,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.tcpEdges = Objects.requireNonNull(tcpEdges, "tcpEdges is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * the list of all TCP Edges on this account
     *
     * @return the value of the property as a {@link java.util.List<TcpEdge>}
     */
    public java.util.List<TcpEdge> getTcpEdges() {
        return this.tcpEdges;
    }

    /**
     * URI of the TCP Edge list API resource
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
        
        final TcpEdgeList other = (TcpEdgeList) o;
        return
            this.tcpEdges.equals(other.tcpEdges)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.tcpEdges,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "TcpEdgeList{" +
            "tcpEdges='" + this.tcpEdges +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
