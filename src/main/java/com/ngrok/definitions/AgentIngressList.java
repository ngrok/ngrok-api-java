package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link AgentIngressList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AgentIngressList implements Pageable {
    @JsonProperty("ingresses")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<AgentIngress> ingresses;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link AgentIngressList}.
     *
     * @param ingresses the list of Agent Ingresses owned by this account
     * @param uri URI of the Agent Ingress list API resource
     * @param nextPageUri URI of the next page, or null if there is no next page
     */
    @JsonCreator
    public AgentIngressList(
        @JsonProperty("ingresses") final java.util.List<AgentIngress> ingresses,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.ingresses = Objects.requireNonNull(ingresses, "ingresses is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * the list of Agent Ingresses owned by this account
     *
     * @return the value of the property as a {@link java.util.List<AgentIngress>}
     */
    public java.util.List<AgentIngress> getIngresses() {
        return this.ingresses;
    }

    /**
     * URI of the Agent Ingress list API resource
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
        
        final AgentIngressList other = (AgentIngressList) o;
        return
            this.ingresses.equals(other.ingresses)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.ingresses,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "AgentIngressList{" +
            "ingresses='" + this.ingresses +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
