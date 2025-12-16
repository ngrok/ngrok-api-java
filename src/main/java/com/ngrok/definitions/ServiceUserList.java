/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link ServiceUserList} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceUserList implements Pageable {
    @JsonProperty("service_users")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<ServiceUser> serviceUsers;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("next_page_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.net.URI> nextPageUri;

    /**
     * Creates a new instance of {@link ServiceUserList}.
     *
     * @param serviceUsers the list of all service users on this account
     * @param uri URI of the service users list API resource
     * @param nextPageUri URI of the next page, or null if there is no next page
     */
    @JsonCreator
    public ServiceUserList(
        @JsonProperty("service_users") final java.util.List<ServiceUser> serviceUsers,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("next_page_uri") final Optional<java.net.URI> nextPageUri
    ) {
        this.serviceUsers = serviceUsers != null ? serviceUsers : java.util.Collections.emptyList();
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.nextPageUri = nextPageUri != null ? nextPageUri : Optional.empty();
    }

    /**
     * the list of all service users on this account
     *
     * @return the value of the property as a {@link java.util.List} of {@link ServiceUser}
     */
    public java.util.List<ServiceUser> getServiceUsers() {
        return this.serviceUsers;
    }

    /**
     * URI of the service users list API resource
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
        
        final ServiceUserList other = (ServiceUserList) o;
        return
            this.serviceUsers.equals(other.serviceUsers)&&
            this.uri.equals(other.uri)&&
            this.nextPageUri.equals(other.nextPageUri);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.serviceUsers,
            this.uri,
            this.nextPageUri
        );
    }

    @Override
    public String toString() {
        return "ServiceUserList{" +
            "serviceUsers='" + this.serviceUsers +
            "', uri='" + this.uri +
            "', nextPageUri='" + this.nextPageUri.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
