package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EventStreamList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventStreamList implements Pageable {
    @JsonProperty("event_streams")
    private final java.util.List<EventStream> eventStreams;
    @JsonProperty("uri")
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link EventStreamList}.
     *
     * @param eventStreams The list of all Event Streams on this account.
     * @param uri URI of the Event Stream list API resource.
     * @param nextPageUri URI of the next page, or null if there is no next page.
     */
    @JsonCreator
    public EventStreamList(
        @JsonProperty("event_streams") final java.util.List<EventStream> eventStreams,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.eventStreams = Objects.requireNonNull(eventStreams, "eventStreams is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * The list of all Event Streams on this account.
     *
     * @return the value of the property as a {@link java.util.List<EventStream>}
     */
    public java.util.List<EventStream> getEventStreams() {
        return this.eventStreams;
    }

    /**
     * URI of the Event Stream list API resource.
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * URI of the next page, or null if there is no next page.
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
        
        final EventStreamList other = (EventStreamList) o;
        return
            this.eventStreams.equals(other.eventStreams)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.eventStreams,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "EventStreamList{" +
            "eventStreams='" + this.eventStreams +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
