package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointConfigurationList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointConfigurationList implements Pageable {
    @JsonProperty("endpoint_configurations")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<EndpointConfiguration> endpointConfigurations;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link EndpointConfigurationList}.
     *
     * @param endpointConfigurations the list of all endpoint configurations on this account
     * @param uri URI of the endpoint configurations list API resource
     * @param nextPageUri URI of the next page, or null if there is no next page
     */
    @JsonCreator
    public EndpointConfigurationList(
        @JsonProperty("endpoint_configurations") final java.util.List<EndpointConfiguration> endpointConfigurations,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.endpointConfigurations = Objects.requireNonNull(endpointConfigurations, "endpointConfigurations is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * the list of all endpoint configurations on this account
     *
     * @return the value of the property as a {@link java.util.List<EndpointConfiguration>}
     */
    public java.util.List<EndpointConfiguration> getEndpointConfigurations() {
        return this.endpointConfigurations;
    }

    /**
     * URI of the endpoint configurations list API resource
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
        
        final EndpointConfigurationList other = (EndpointConfigurationList) o;
        return
            this.endpointConfigurations.equals(other.endpointConfigurations)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.endpointConfigurations,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "EndpointConfigurationList{" +
            "endpointConfigurations='" + this.endpointConfigurations +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
