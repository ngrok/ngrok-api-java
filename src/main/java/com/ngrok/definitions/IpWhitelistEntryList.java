package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link IpWhitelistEntryList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IpWhitelistEntryList implements Pageable {
    @JsonProperty("whitelist")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<IpWhitelistEntry> whitelist;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link IpWhitelistEntryList}.
     *
     * @param whitelist the list of all IP whitelist entries on this account
     * @param uri URI of the IP whitelist API resource
     * @param nextPageUri URI of the next page, or null if there is no next page
     */
    @JsonCreator
    public IpWhitelistEntryList(
        @JsonProperty("whitelist") final java.util.List<IpWhitelistEntry> whitelist,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.whitelist = Objects.requireNonNull(whitelist, "whitelist is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * the list of all IP whitelist entries on this account
     *
     * @return the value of the property as a {@link java.util.List<IpWhitelistEntry>}
     */
    public java.util.List<IpWhitelistEntry> getWhitelist() {
        return this.whitelist;
    }

    /**
     * URI of the IP whitelist API resource
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
        
        final IpWhitelistEntryList other = (IpWhitelistEntryList) o;
        return
            this.whitelist.equals(other.whitelist)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.whitelist,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "IpWhitelistEntryList{" +
            "whitelist='" + this.whitelist +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
