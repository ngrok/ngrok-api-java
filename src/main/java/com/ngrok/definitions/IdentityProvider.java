/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link IdentityProvider} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IdentityProvider {
    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String name;
    @JsonProperty("url")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String url;

    /**
     * Creates a new instance of {@link IdentityProvider}.
     *
     * @param name name of the identity provider (e.g. Google)
     * @param url URL of the identity provider (e.g. <a href="https://accounts.google.com">https://accounts.google.com</a>)
     */
    @JsonCreator
    public IdentityProvider(
        @JsonProperty("name") final String name,
        @JsonProperty("url") final String url
    ) {
        this.name = Objects.requireNonNull(name, "name is required");
        this.url = Objects.requireNonNull(url, "url is required");
    }

    /**
     * name of the identity provider (e.g. Google)
     *
     * @return the value of the property as a {@link String}
     */
    public String getName() {
        return this.name;
    }

    /**
     * URL of the identity provider (e.g. <a
     * href="https://accounts.google.com">https://accounts.google.com</a>)
     *
     * @return the value of the property as a {@link String}
     */
    public String getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final IdentityProvider other = (IdentityProvider) o;
        return
            this.name.equals(other.name)&&
            this.url.equals(other.url);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.name,
            this.url
        );
    }

    @Override
    public String toString() {
        return "IdentityProvider{" +
            "name='" + this.name +
            "', url='" + this.url +
            "'}";
    }
}
