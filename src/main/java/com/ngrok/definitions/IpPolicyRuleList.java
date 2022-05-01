package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link IpPolicyRuleList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IpPolicyRuleList implements Pageable {
    @JsonProperty("ip_policy_rules")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<IpPolicyRule> ipPolicyRules;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link IpPolicyRuleList}.
     *
     * @param ipPolicyRules the list of all IP policy rules on this account
     * @param uri URI of the IP policy rule list API resource
     * @param nextPageUri URI of the next page, or null if there is no next page
     */
    @JsonCreator
    public IpPolicyRuleList(
        @JsonProperty("ip_policy_rules") final java.util.List<IpPolicyRule> ipPolicyRules,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.ipPolicyRules = ipPolicyRules != null ? ipPolicyRules : java.util.Collections.emptyList();
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * the list of all IP policy rules on this account
     *
     * @return the value of the property as a {@link java.util.List} of {@link IpPolicyRule}
     */
    public java.util.List<IpPolicyRule> getIpPolicyRules() {
        return this.ipPolicyRules;
    }

    /**
     * URI of the IP policy rule list API resource
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
        
        final IpPolicyRuleList other = (IpPolicyRuleList) o;
        return
            this.ipPolicyRules.equals(other.ipPolicyRules)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.ipPolicyRules,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "IpPolicyRuleList{" +
            "ipPolicyRules='" + this.ipPolicyRules +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
