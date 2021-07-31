package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link Ref} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ref {
    @JsonProperty("id")
    private final String id;
    @JsonProperty("uri")
    private final java.net.URI uri;

    /**
     * Creates a new instance of {@link Ref}.
     *
     * @param id a resource identifier
     * @param uri a uri for locating a resource
     */
    @JsonCreator
    public Ref(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
    }

    /**
     * a resource identifier
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * a uri for locating a resource
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
        
        final Ref other = (Ref) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri
        );
    }

    @Override
    public String toString() {
        return "Ref{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "'}";
    }
}
