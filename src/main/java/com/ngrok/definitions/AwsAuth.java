/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link AwsAuth} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AwsAuth {
    /**
     * Builder class for {@link AwsAuth}.
     */
    public static class Builder {
        private Optional<AwsRole> role = Optional.empty();
        private Optional<AwsCredentials> creds = Optional.empty();

        private Builder(
        ) {
        }

        /**
         * A role for ngrok to assume on your behalf to deposit events into your AWS
         * account.
         *
         * @param role the value of the <code>role</code> parameter as a {@link AwsRole}
         * @return this builder instance
         */
        public Builder role(final AwsRole role) {
            this.role = Optional.of(Objects.requireNonNull(role, "role is required"));
            return this;
        }

        /**
         * A role for ngrok to assume on your behalf to deposit events into your AWS
         * account.
         *
         * @param role the value of the <code>role</code> parameter as a {@link AwsRole}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder role(final Optional<AwsRole> role) {
            this.role = Objects.requireNonNull(role, "role is required");
            return this;
        }

        /**
         * Credentials to your AWS account if you prefer ngrok to sign in with long-term
         * access keys.
         *
         * @param creds the value of the <code>creds</code> parameter as a {@link AwsCredentials}
         * @return this builder instance
         */
        public Builder creds(final AwsCredentials creds) {
            this.creds = Optional.of(Objects.requireNonNull(creds, "creds is required"));
            return this;
        }

        /**
         * Credentials to your AWS account if you prefer ngrok to sign in with long-term
         * access keys.
         *
         * @param creds the value of the <code>creds</code> parameter as a {@link AwsCredentials}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder creds(final Optional<AwsCredentials> creds) {
            this.creds = Objects.requireNonNull(creds, "creds is required");
            return this;
        }

        /**
         * Constructs the {@link AwsAuth} instance.
         *
         * @return a new {@link AwsAuth}
         */
        public AwsAuth build() {
            return new AwsAuth(
                this.role,
                this.creds
            );
        }
    }

    /**
     * Creates a new builder for the {@link AwsAuth} type.
     *
     * @return a new {@link Builder}
     */
    public static Builder newBuilder(
    ) {
        return new Builder (
        );
    }

    @JsonProperty("role")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<AwsRole> role;
    @JsonProperty("creds")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<AwsCredentials> creds;

    /**
     * Creates a new instance of {@link AwsAuth}.
     *
     * @param role A role for ngrok to assume on your behalf to deposit events into your AWS account.
     * @param creds Credentials to your AWS account if you prefer ngrok to sign in with long-term access keys.
     */
    @JsonCreator
    private AwsAuth(
        @JsonProperty("role") final Optional<AwsRole> role,
        @JsonProperty("creds") final Optional<AwsCredentials> creds
    ) {
        this.role = role != null ? role : Optional.empty();
        this.creds = creds != null ? creds : Optional.empty();
    }

    /**
     * A role for ngrok to assume on your behalf to deposit events into your AWS
     * account.
     *
     * @return the value of the property as a {@link AwsRole} wrapped in an {@link Optional}
     */
    public Optional<AwsRole> getRole() {
        return this.role;
    }

    /**
     * Credentials to your AWS account if you prefer ngrok to sign in with long-term
     * access keys.
     *
     * @return the value of the property as a {@link AwsCredentials} wrapped in an {@link Optional}
     */
    public Optional<AwsCredentials> getCreds() {
        return this.creds;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final AwsAuth other = (AwsAuth) o;
        return
            this.role.equals(other.role)&&
            this.creds.equals(other.creds);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.role,
            this.creds
        );
    }

    @Override
    public String toString() {
        return "AwsAuth{" +
            "role='" + this.role.map(Object::toString).orElse("(null)") +
            "', creds='" + this.creds.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
