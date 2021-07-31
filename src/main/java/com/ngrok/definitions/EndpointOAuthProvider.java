package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointOAuthProvider} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointOAuthProvider {
    @JsonProperty("github")
    private final Optional<EndpointOAuthGitHub> github;
    @JsonProperty("facebook")
    private final Optional<EndpointOAuthFacebook> facebook;
    @JsonProperty("microsoft")
    private final Optional<EndpointOAuthMicrosoft> microsoft;
    @JsonProperty("google")
    private final Optional<EndpointOAuthGoogle> google;

    /**
     * Creates a new instance of {@link EndpointOAuthProvider}.
     *
     * @param github configuration for using github as the identity provider
     * @param facebook configuration for using facebook as the identity provider
     * @param microsoft configuration for using microsoft as the identity provider
     * @param google configuration for using google as the identity provider
     */
    @JsonCreator
    public EndpointOAuthProvider(
        @JsonProperty("github") final Optional<EndpointOAuthGitHub> github,
        @JsonProperty("facebook") final Optional<EndpointOAuthFacebook> facebook,
        @JsonProperty("microsoft") final Optional<EndpointOAuthMicrosoft> microsoft,
        @JsonProperty("google") final Optional<EndpointOAuthGoogle> google
    ) {
        this.github = github != null ? github : Optional.empty();
        this.facebook = facebook != null ? facebook : Optional.empty();
        this.microsoft = microsoft != null ? microsoft : Optional.empty();
        this.google = google != null ? google : Optional.empty();
    }

    /**
     * configuration for using github as the identity provider
     *
     * @return the value of the property as a {@link EndpointOAuthGitHub} wrapped in an {@link Optional}
     */
    public Optional<EndpointOAuthGitHub> getGithub() {
        return this.github;
    }

    /**
     * configuration for using facebook as the identity provider
     *
     * @return the value of the property as a {@link EndpointOAuthFacebook} wrapped in an {@link Optional}
     */
    public Optional<EndpointOAuthFacebook> getFacebook() {
        return this.facebook;
    }

    /**
     * configuration for using microsoft as the identity provider
     *
     * @return the value of the property as a {@link EndpointOAuthMicrosoft} wrapped in an {@link Optional}
     */
    public Optional<EndpointOAuthMicrosoft> getMicrosoft() {
        return this.microsoft;
    }

    /**
     * configuration for using google as the identity provider
     *
     * @return the value of the property as a {@link EndpointOAuthGoogle} wrapped in an {@link Optional}
     */
    public Optional<EndpointOAuthGoogle> getGoogle() {
        return this.google;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointOAuthProvider other = (EndpointOAuthProvider) o;
        return
            this.github.equals(other.github)&&
            this.facebook.equals(other.facebook)&&
            this.microsoft.equals(other.microsoft)&&
            this.google.equals(other.google);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.github,
            this.facebook,
            this.microsoft,
            this.google
        );
    }

    @Override
    public String toString() {
        return "EndpointOAuthProvider{" +
            "github='" + this.github.map(Object::toString).orElse("(null)") +
            "', facebook='" + this.facebook.map(Object::toString).orElse("(null)") +
            "', microsoft='" + this.microsoft.map(Object::toString).orElse("(null)") +
            "', google='" + this.google.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
