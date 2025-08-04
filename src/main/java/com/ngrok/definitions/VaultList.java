/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link VaultList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VaultList implements Pageable {
    @JsonProperty("vaults")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<Vault> vaults;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link VaultList}.
     *
     * @param vaults The list of Vaults for this account
     * @param uri the value of the <code>uri</code> parameter as a {@link java.net.URI}
     * @param nextPageUri URI of the next page of results, or null if there is no next page
     */
    @JsonCreator
    public VaultList(
        @JsonProperty("vaults") final java.util.List<Vault> vaults,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.vaults = vaults != null ? vaults : java.util.Collections.emptyList();
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * The list of Vaults for this account
     *
     * @return the value of the property as a {@link java.util.List} of {@link Vault}
     */
    public java.util.List<Vault> getVaults() {
        return this.vaults;
    }

    /**
     * Fetches the value of the <code>uri</code> property.
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * URI of the next page of results, or null if there is no next page
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
        
        final VaultList other = (VaultList) o;
        return
            this.vaults.equals(other.vaults)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.vaults,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "VaultList{" +
            "vaults='" + this.vaults +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
