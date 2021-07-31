package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EventSourceList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventSourceList {
    @JsonProperty("sources")
    private final java.util.List<EventSource> sources;
    @JsonProperty("uri")
    private final java.net.URI uri;

    /**
     * Creates a new instance of {@link EventSourceList}.
     *
     * @param sources The list of all Event Sources for an Event Subscription
     * @param uri URI of the next page, or null if there is no next page.
     */
    @JsonCreator
    public EventSourceList(
        @JsonProperty("sources") final java.util.List<EventSource> sources,
        @JsonProperty("uri") final java.net.URI uri
    ) {
        this.sources = Objects.requireNonNull(sources, "sources is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
    }

    /**
     * The list of all Event Sources for an Event Subscription
     *
     * @return the value of the property as a {@link java.util.List<EventSource>}
     */
    public java.util.List<EventSource> getSources() {
        return this.sources;
    }

    /**
     * URI of the next page, or null if there is no next page.
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EventSourceList other = (EventSourceList) o;
        return
            this.sources.equals(other.sources)&&
            this.uri.equals(other.uri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.sources,
            this.uri
        );
    }

    @Override
    public String toString() {
        return "EventSourceList{" +
            "sources='" + this.sources +
            "', uri='" + this.uri +
            "'}";
    }
}
