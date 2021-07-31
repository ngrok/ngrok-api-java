package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link AwsCredentials} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AwsCredentials {
    @JsonProperty("aws_access_key_id")
    private final String awsAccessKeyId;
    @JsonProperty("aws_secret_access_key")
    private final Optional<String> awsSecretAccessKey;

    /**
     * Creates a new instance of {@link AwsCredentials}.
     *
     * @param awsAccessKeyId The ID portion of an AWS access key.
     * @param awsSecretAccessKey The secret portion of an AWS access key.
     */
    @JsonCreator
    public AwsCredentials(
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
