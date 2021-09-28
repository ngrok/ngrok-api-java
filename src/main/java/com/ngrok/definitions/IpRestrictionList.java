package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link IpRestrictionList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IpRestrictionList implements Pageable {
    @JsonProperty("ip_restrictions")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<IpRestriction> ipRestrictions;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link IpRestrictionList}.
     *
     * @param ipRestrictions the list of all IP restrictions on this account
     * @param uri URI of the IP resrtrictions list API resource
     * @param nextPageUri URI of the next page, or null if there is no next page
     */
    @JsonCreator
    public IpRestrictionList(
        @JsonProperty("ip_restrictions") final java.util.List<IpRestriction> ipRestrictions,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.ipRestrictions = Objects.requireNonNull(ipRestrictions, "ipRestrictions is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * the list of all IP restrictions on this account
     *
     * @return the value of the property as a {@link java.util.List<IpRestriction>}
     */
    public java.util.List<IpRestriction> getIpRestrictions() {
        return this.ipRestrictions;
    }

    /**
     * URI of the IP resrtrictions list API resource
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
        
        final IpRestrictionList other = (IpRestrictionList) o;
        return
            this.ipRestrictions.equals(other.ipRestrictions)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.ipRestrictions,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "IpRestrictionList{" +
            "ipRestrictions='" + this.ipRestrictions +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
