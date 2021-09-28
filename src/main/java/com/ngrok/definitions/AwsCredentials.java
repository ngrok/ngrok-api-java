package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link AwsCredentials} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AwsCredentials {
    /**
     * Builder class for {@link AwsCredentials}.
     */
    public static class Builder {
        private final String awsAccessKeyId;
        private final String awsSecretAccessKey;

        private Builder(
            final String awsAccessKeyId,
            final String awsSecretAccessKey
        ) {
            this.awsAccessKeyId = Objects.requireNonNull(awsAccessKeyId, "awsAccessKeyId is required");
            this.awsSecretAccessKey = Objects.requireNonNull(awsSecretAccessKey, "awsSecretAccessKey is required");
        }

        /**
         * Constructs the {@link AwsCredentials} instance.
         *
         * @return a new {@link AwsCredentials}
         */
        public AwsCredentials build() {
            return new AwsCredentials(
                this.awsAccessKeyId,
                Optional.of(this.awsSecretAccessKey)
            );
        }
    }

    /**
     * Creates a new builder for the {@link AwsCredentials} type.
     *
     * @param awsAccessKeyId The ID portion of an AWS access key.
     * @param awsSecretAccessKey The secret portion of an AWS access key.
     * @return a new {@link Builder}
     */
    public static Builder newBuilder(
        final String awsAccessKeyId,
        final String awsSecretAccessKey
    ) {
        return new Builder (
            awsAccessKeyId,
            awsSecretAccessKey
        );
    }

    @JsonProperty("aws_access_key_id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String awsAccessKeyId;
    @JsonProperty("aws_secret_access_key")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> awsSecretAccessKey;

    /**
     * Creates a new instance of {@link AwsCredentials}.
     *
     * @param awsAccessKeyId The ID portion of an AWS access key.
     * @param awsSecretAccessKey The secret portion of an AWS access key.
     */
    @JsonCreator
    private AwsCredentials(
        @JsonProperty("aws_access_key_id") final String awsAccessKeyId,
        @JsonProperty("aws_secret_access_key") final Optional<String> awsSecretAccessKey
    ) {
        this.awsAccessKeyId = Objects.requireNonNull(awsAccessKeyId, "awsAccessKeyId is required");
        this.awsSecretAccessKey = awsSecretAccessKey != null ? awsSecretAccessKey : Optional.empty();
    }

    /**
     * The ID portion of an AWS access key.
     *
     * @return the value of the property as a {@link String}
     */
    public String getAwsAccessKeyId() {
        return this.awsAccessKeyId;
    }

    /**
     * The secret portion of an AWS access key.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getAwsSecretAccessKey() {
        return this.awsSecretAccessKey;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final AwsCredentials other = (AwsCredentials) o;
        return
            this.awsAccessKeyId.equals(other.awsAccessKeyId)&&
            this.awsSecretAccessKey.equals(other.awsSecretAccessKey);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.awsAccessKeyId,
            this.awsSecretAccessKey
        );
    }

    @Override
    public String toString() {
        return "AwsCredentials{" +
            "awsAccessKeyId='" + this.awsAccessKeyId +
            "', awsSecretAccessKey='" + this.awsSecretAccessKey.orElse("(null)") +
            "'}";
    }
}
