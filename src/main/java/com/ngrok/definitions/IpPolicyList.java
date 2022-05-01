package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link IpPolicyList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IpPolicyList implements Pageable {
    @JsonProperty("ip_policies")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<IpPolicy> ipPolicies;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link IpPolicyList}.
     *
     * @param ipPolicies the list of all IP policies on this account
     * @param uri URI of the IP policy list API resource
     * @param nextPageUri URI of the next page, or null if there is no next page
     */
    @JsonCreator
    public IpPolicyList(
        @JsonProperty("ip_policies") final java.util.List<IpPolicy> ipPolicies,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.ipPolicies = ipPolicies != null ? ipPolicies : java.util.Collections.emptyList();
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * the list of all IP policies on this account
     *
     * @return the value of the property as a {@link java.util.List} of {@link IpPolicy}
     */
    public java.util.List<IpPolicy> getIpPolicies() {
        return this.ipPolicies;
    }

    /**
     * URI of the IP policy list API resource
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
        
        final IpPolicyList other = (IpPolicyList) o;
        return
            this.ipPolicies.equals(other.ipPolicies)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.ipPolicies,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "IpPolicyList{" +
            "ipPolicies='" + this.ipPolicies +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
