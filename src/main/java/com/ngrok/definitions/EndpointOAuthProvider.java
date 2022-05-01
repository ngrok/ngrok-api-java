package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointOAuthProvider} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointOAuthProvider {
    /**
     * Builder class for {@link EndpointOAuthProvider}.
     */
    public static class Builder {
        private Optional<EndpointOAuthGitHub> github = Optional.empty();
        private Optional<EndpointOAuthFacebook> facebook = Optional.empty();
        private Optional<EndpointOAuthMicrosoft> microsoft = Optional.empty();
        private Optional<EndpointOAuthGoogle> google = Optional.empty();

        private Builder(
        ) {
        }

        /**
         * configuration for using github as the identity provider
         *
         * @param github the value of the <code>github</code> parameter as a {@link EndpointOAuthGitHub}
         * @return this builder instance
         */
        public Builder github(final EndpointOAuthGitHub github) {
            this.github = Optional.of(Objects.requireNonNull(github, "github is required"));
            return this;
        }

        /**
         * configuration for using github as the identity provider
         *
         * @param github the value of the <code>github</code> parameter as a {@link EndpointOAuthGitHub}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder github(final Optional<EndpointOAuthGitHub> github) {
            this.github = Objects.requireNonNull(github, "github is required");
            return this;
        }

        /**
         * configuration for using facebook as the identity provider
         *
         * @param facebook the value of the <code>facebook</code> parameter as a {@link EndpointOAuthFacebook}
         * @return this builder instance
         */
        public Builder facebook(final EndpointOAuthFacebook facebook) {
            this.facebook = Optional.of(Objects.requireNonNull(facebook, "facebook is required"));
            return this;
        }

        /**
         * configuration for using facebook as the identity provider
         *
         * @param facebook the value of the <code>facebook</code> parameter as a {@link EndpointOAuthFacebook}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder facebook(final Optional<EndpointOAuthFacebook> facebook) {
            this.facebook = Objects.requireNonNull(facebook, "facebook is required");
            return this;
        }

        /**
         * configuration for using microsoft as the identity provider
         *
         * @param microsoft the value of the <code>microsoft</code> parameter as a {@link EndpointOAuthMicrosoft}
         * @return this builder instance
         */
        public Builder microsoft(final EndpointOAuthMicrosoft microsoft) {
            this.microsoft = Optional.of(Objects.requireNonNull(microsoft, "microsoft is required"));
            return this;
        }

        /**
         * configuration for using microsoft as the identity provider
         *
         * @param microsoft the value of the <code>microsoft</code> parameter as a {@link EndpointOAuthMicrosoft}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder microsoft(final Optional<EndpointOAuthMicrosoft> microsoft) {
            this.microsoft = Objects.requireNonNull(microsoft, "microsoft is required");
            return this;
        }

        /**
         * configuration for using google as the identity provider
         *
         * @param google the value of the <code>google</code> parameter as a {@link EndpointOAuthGoogle}
         * @return this builder instance
         */
        public Builder google(final EndpointOAuthGoogle google) {
            this.google = Optional.of(Objects.requireNonNull(google, "google is required"));
            return this;
        }

        /**
         * configuration for using google as the identity provider
         *
         * @param google the value of the <code>google</code> parameter as a {@link EndpointOAuthGoogle}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder google(final Optional<EndpointOAuthGoogle> google) {
            this.google = Objects.requireNonNull(google, "google is required");
            return this;
        }

        /**
         * Constructs the {@link EndpointOAuthProvider} instance.
         *
         * @return a new {@link EndpointOAuthProvider}
         */
        public EndpointOAuthProvider build() {
            return new EndpointOAuthProvider(
                this.github,
                this.facebook,
                this.microsoft,
                this.google
            );
        }
    }

    /**
     * Creates a new builder for the {@link EndpointOAuthProvider} type.
     *
     * @return a new {@link Builder}
     */
    public static Builder newBuilder(
    ) {
        return new Builder (
        );
    }

    @JsonProperty("github")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointOAuthGitHub> github;
    @JsonProperty("facebook")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointOAuthFacebook> facebook;
    @JsonProperty("microsoft")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointOAuthMicrosoft> microsoft;
    @JsonProperty("google")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
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
    private EndpointOAuthProvider(
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
