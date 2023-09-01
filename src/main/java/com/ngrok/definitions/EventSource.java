/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EventSource} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventSource {
    @JsonProperty("type")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String type;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;

    /**
     * Creates a new instance of {@link EventSource}.
     *
     * @param type Type of event for which an event subscription will trigger
     * @param uri URI of the Event Source API resource.
     */
    @JsonCreator
    public EventSource(
        @JsonProperty("type") final String type,
        @JsonProperty("uri") final java.net.URI uri
    ) {
        this.type = Objects.requireNonNull(type, "type is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
    }

    /**
     * Type of event for which an event subscription will trigger
     *
     * @return the value of the property as a {@link String}
     */
    public String getType() {
        return this.type;
    }

    /**
     * URI of the Event Source API resource.
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
        
        final EventSource other = (EventSource) o;
        return
            this.type.equals(other.type)&&
            this.uri.equals(other.uri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.type,
            this.uri
        );
    }

    @Override
    public String toString() {
        return "EventSource{" +
            "type='" + this.type +
            "', uri='" + this.uri +
            "'}";
    }
}
