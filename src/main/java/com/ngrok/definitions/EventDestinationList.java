package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EventDestinationList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventDestinationList implements Pageable {
    @JsonProperty("event_destinations")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<EventDestination> eventDestinations;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link EventDestinationList}.
     *
     * @param eventDestinations The list of all Event Destinations on this account.
     * @param uri URI of the Event Destinations list API resource.
     * @param nextPageUri URI of the next page, or null if there is no next page.
     */
    @JsonCreator
    public EventDestinationList(
        @JsonProperty("event_destinations") final java.util.List<EventDestination> eventDestinations,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.eventDestinations = Objects.requireNonNull(eventDestinations, "eventDestinations is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * The list of all Event Destinations on this account.
     *
     * @return the value of the property as a {@link java.util.List<EventDestination>}
     */
    public java.util.List<EventDestination> getEventDestinations() {
        return this.eventDestinations;
    }

    /**
     * URI of the Event Destinations list API resource.
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
        
        final EventDestinationList other = (EventDestinationList) o;
        return
            this.eventDestinations.equals(other.eventDestinations)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.eventDestinations,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "EventDestinationList{" +
            "eventDestinations='" + this.eventDestinations +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
