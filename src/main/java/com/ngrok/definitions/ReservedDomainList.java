/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link ReservedDomainList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReservedDomainList implements Pageable {
    @JsonProperty("reserved_domains")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<ReservedDomain> reservedDomains;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link ReservedDomainList}.
     *
     * @param reservedDomains the list of all reserved domains on this account
     * @param uri URI of the reserved domain list API resource
     * @param nextPageUri URI of the next page, or null if there is no next page
     */
    @JsonCreator
    public ReservedDomainList(
        @JsonProperty("reserved_domains") final java.util.List<ReservedDomain> reservedDomains,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.reservedDomains = reservedDomains != null ? reservedDomains : java.util.Collections.emptyList();
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * the list of all reserved domains on this account
     *
     * @return the value of the property as a {@link java.util.List} of {@link ReservedDomain}
     */
    public java.util.List<ReservedDomain> getReservedDomains() {
        return this.reservedDomains;
    }

    /**
     * URI of the reserved domain list API resource
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
        
        final ReservedDomainList other = (ReservedDomainList) o;
        return
            this.reservedDomains.equals(other.reservedDomains)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.reservedDomains,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "ReservedDomainList{" +
            "reservedDomains='" + this.reservedDomains +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
