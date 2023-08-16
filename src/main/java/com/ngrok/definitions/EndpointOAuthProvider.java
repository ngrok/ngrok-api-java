/* Code generated for API Clients. DO NOT EDIT. */

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
        private Optional<EndpointOAuthLinkedIn> linkedin = Optional.empty();
        private Optional<EndpointOAuthGitLab> gitlab = Optional.empty();
        private Optional<EndpointOAuthTwitch> twitch = Optional.empty();
        private Optional<EndpointOAuthAmazon> amazon = Optional.empty();

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
         * configuration for using linkedin as the identity provider
         *
         * @param linkedin the value of the <code>linkedin</code> parameter as a {@link EndpointOAuthLinkedIn}
         * @return this builder instance
         */
        public Builder linkedin(final EndpointOAuthLinkedIn linkedin) {
            this.linkedin = Optional.of(Objects.requireNonNull(linkedin, "linkedin is required"));
            return this;
        }

        /**
         * configuration for using linkedin as the identity provider
         *
         * @param linkedin the value of the <code>linkedin</code> parameter as a {@link EndpointOAuthLinkedIn}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder linkedin(final Optional<EndpointOAuthLinkedIn> linkedin) {
            this.linkedin = Objects.requireNonNull(linkedin, "linkedin is required");
            return this;
        }

        /**
         * configuration for using gitlab as the identity provider
         *
         * @param gitlab the value of the <code>gitlab</code> parameter as a {@link EndpointOAuthGitLab}
         * @return this builder instance
         */
        public Builder gitlab(final EndpointOAuthGitLab gitlab) {
            this.gitlab = Optional.of(Objects.requireNonNull(gitlab, "gitlab is required"));
            return this;
        }

        /**
         * configuration for using gitlab as the identity provider
         *
         * @param gitlab the value of the <code>gitlab</code> parameter as a {@link EndpointOAuthGitLab}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder gitlab(final Optional<EndpointOAuthGitLab> gitlab) {
            this.gitlab = Objects.requireNonNull(gitlab, "gitlab is required");
            return this;
        }

        /**
         * configuration for using twitch as the identity provider
         *
         * @param twitch the value of the <code>twitch</code> parameter as a {@link EndpointOAuthTwitch}
         * @return this builder instance
         */
        public Builder twitch(final EndpointOAuthTwitch twitch) {
            this.twitch = Optional.of(Objects.requireNonNull(twitch, "twitch is required"));
            return this;
        }

        /**
         * configuration for using twitch as the identity provider
         *
         * @param twitch the value of the <code>twitch</code> parameter as a {@link EndpointOAuthTwitch}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder twitch(final Optional<EndpointOAuthTwitch> twitch) {
            this.twitch = Objects.requireNonNull(twitch, "twitch is required");
            return this;
        }

        /**
         * configuration for using amazon as the identity provider
         *
         * @param amazon the value of the <code>amazon</code> parameter as a {@link EndpointOAuthAmazon}
         * @return this builder instance
         */
        public Builder amazon(final EndpointOAuthAmazon amazon) {
            this.amazon = Optional.of(Objects.requireNonNull(amazon, "amazon is required"));
            return this;
        }

        /**
         * configuration for using amazon as the identity provider
         *
         * @param amazon the value of the <code>amazon</code> parameter as a {@link EndpointOAuthAmazon}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder amazon(final Optional<EndpointOAuthAmazon> amazon) {
            this.amazon = Objects.requireNonNull(amazon, "amazon is required");
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
                this.google,
                this.linkedin,
                this.gitlab,
                this.twitch,
                this.amazon
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
    @JsonProperty("linkedin")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointOAuthLinkedIn> linkedin;
    @JsonProperty("gitlab")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointOAuthGitLab> gitlab;
    @JsonProperty("twitch")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointOAuthTwitch> twitch;
    @JsonProperty("amazon")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EndpointOAuthAmazon> amazon;

    /**
     * Creates a new instance of {@link EndpointOAuthProvider}.
     *
     * @param github configuration for using github as the identity provider
     * @param facebook configuration for using facebook as the identity provider
     * @param microsoft configuration for using microsoft as the identity provider
     * @param google configuration for using google as the identity provider
     * @param linkedin configuration for using linkedin as the identity provider
     * @param gitlab configuration for using gitlab as the identity provider
     * @param twitch configuration for using twitch as the identity provider
     * @param amazon configuration for using amazon as the identity provider
     */
    @JsonCreator
    private EndpointOAuthProvider(
        @JsonProperty("github") final Optional<EndpointOAuthGitHub> github,
        @JsonProperty("facebook") final Optional<EndpointOAuthFacebook> facebook,
        @JsonProperty("microsoft") final Optional<EndpointOAuthMicrosoft> microsoft,
        @JsonProperty("google") final Optional<EndpointOAuthGoogle> google,
        @JsonProperty("linkedin") final Optional<EndpointOAuthLinkedIn> linkedin,
        @JsonProperty("gitlab") final Optional<EndpointOAuthGitLab> gitlab,
        @JsonProperty("twitch") final Optional<EndpointOAuthTwitch> twitch,
        @JsonProperty("amazon") final Optional<EndpointOAuthAmazon> amazon
    ) {
        this.github = github != null ? github : Optional.empty();
        this.facebook = facebook != null ? facebook : Optional.empty();
        this.microsoft = microsoft != null ? microsoft : Optional.empty();
        this.google = google != null ? google : Optional.empty();
        this.linkedin = linkedin != null ? linkedin : Optional.empty();
        this.gitlab = gitlab != null ? gitlab : Optional.empty();
        this.twitch = twitch != null ? twitch : Optional.empty();
        this.amazon = amazon != null ? amazon : Optional.empty();
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

    /**
     * configuration for using linkedin as the identity provider
     *
     * @return the value of the property as a {@link EndpointOAuthLinkedIn} wrapped in an {@link Optional}
     */
    public Optional<EndpointOAuthLinkedIn> getLinkedin() {
        return this.linkedin;
    }

    /**
     * configuration for using gitlab as the identity provider
     *
     * @return the value of the property as a {@link EndpointOAuthGitLab} wrapped in an {@link Optional}
     */
    public Optional<EndpointOAuthGitLab> getGitlab() {
        return this.gitlab;
    }

    /**
     * configuration for using twitch as the identity provider
     *
     * @return the value of the property as a {@link EndpointOAuthTwitch} wrapped in an {@link Optional}
     */
    public Optional<EndpointOAuthTwitch> getTwitch() {
        return this.twitch;
    }

    /**
     * configuration for using amazon as the identity provider
     *
     * @return the value of the property as a {@link EndpointOAuthAmazon} wrapped in an {@link Optional}
     */
    public Optional<EndpointOAuthAmazon> getAmazon() {
        return this.amazon;
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
            this.google.equals(other.google)&&
            this.linkedin.equals(other.linkedin)&&
            this.gitlab.equals(other.gitlab)&&
            this.twitch.equals(other.twitch)&&
            this.amazon.equals(other.amazon);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.github,
            this.facebook,
            this.microsoft,
            this.google,
            this.linkedin,
            this.gitlab,
            this.twitch,
            this.amazon
        );
    }

    @Override
    public String toString() {
        return "EndpointOAuthProvider{" +
            "github='" + this.github.map(Object::toString).orElse("(null)") +
            "', facebook='" + this.facebook.map(Object::toString).orElse("(null)") +
            "', microsoft='" + this.microsoft.map(Object::toString).orElse("(null)") +
            "', google='" + this.google.map(Object::toString).orElse("(null)") +
            "', linkedin='" + this.linkedin.map(Object::toString).orElse("(null)") +
            "', gitlab='" + this.gitlab.map(Object::toString).orElse("(null)") +
            "', twitch='" + this.twitch.map(Object::toString).orElse("(null)") +
            "', amazon='" + this.amazon.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
