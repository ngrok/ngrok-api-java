package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link AwsRole} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AwsRole {
    /**
     * Builder class for {@link AwsRole}.
     */
    public static class Builder {
        private final String roleArn;

        private Builder(
            final String roleArn
        ) {
            this.roleArn = Objects.requireNonNull(roleArn, "roleArn is required");
        }

        /**
         * Constructs the {@link AwsRole} instance.
         *
         * @return a new {@link AwsRole}
         */
        public AwsRole build() {
            return new AwsRole(
                this.roleArn
            );
        }
    }

    /**
     * Creates a new builder for the {@link AwsRole} type.
     *
     * @param roleArn An ARN that specifies the role that ngrok should use to deliver to the configured target.
     * @return a new {@link Builder}
     */
    public static Builder newBuilder(
        final String roleArn
    ) {
        return new Builder (
            roleArn
        );
    }

    @JsonProperty("role_arn")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String roleArn;

    /**
     * Creates a new instance of {@link AwsRole}.
     *
     * @param roleArn An ARN that specifies the role that ngrok should use to deliver to the configured target.
     */
    @JsonCreator
    private AwsRole(
        @JsonProperty("role_arn") final String roleArn
    ) {
        this.roleArn = Objects.requireNonNull(roleArn, "roleArn is required");
    }

    /**
     * An ARN that specifies the role that ngrok should use to deliver to the
     * configured target.
     *
     * @return the value of the property as a {@link String}
     */
    public String getRoleArn() {
        return this.roleArn;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final AwsRole other = (AwsRole) o;
        return
            this.roleArn.equals(other.roleArn);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.roleArn
        );
    }

    @Override
    public String toString() {
        return "AwsRole{" +
            "roleArn='" + this.roleArn +
            "'}";
    }
}
