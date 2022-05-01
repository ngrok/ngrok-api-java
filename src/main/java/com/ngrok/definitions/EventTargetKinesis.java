package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EventTargetKinesis} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventTargetKinesis {
    /**
     * Builder class for {@link EventTargetKinesis}.
     */
    public static class Builder {
        private Optional<AwsAuth> auth = Optional.empty();
        private Optional<String> streamArn = Optional.empty();

        private Builder(
        ) {
        }

        /**
         * Configuration for how to authenticate into your AWS account. Exactly one of
         * <code>role</code> or <code>creds</code> should be configured.
         *
         * @param auth the value of the <code>auth</code> parameter as a {@link AwsAuth}
         * @return this builder instance
         */
        public Builder auth(final AwsAuth auth) {
            this.auth = Optional.of(Objects.requireNonNull(auth, "auth is required"));
            return this;
        }

        /**
         * Configuration for how to authenticate into your AWS account. Exactly one of
         * <code>role</code> or <code>creds</code> should be configured.
         *
         * @param auth the value of the <code>auth</code> parameter as a {@link AwsAuth}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder auth(final Optional<AwsAuth> auth) {
            this.auth = Objects.requireNonNull(auth, "auth is required");
            return this;
        }

        /**
         * An Amazon Resource Name specifying the Kinesis stream to deposit events into.
         *
         * @param streamArn the value of the <code>stream_arn</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder streamArn(final String streamArn) {
            this.streamArn = Optional.of(Objects.requireNonNull(streamArn, "streamArn is required"));
            return this;
        }

        /**
         * An Amazon Resource Name specifying the Kinesis stream to deposit events into.
         *
         * @param streamArn the value of the <code>stream_arn</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder streamArn(final Optional<String> streamArn) {
            this.streamArn = Objects.requireNonNull(streamArn, "streamArn is required");
            return this;
        }

        /**
         * Constructs the {@link EventTargetKinesis} instance.
         *
         * @return a new {@link EventTargetKinesis}
         */
        public EventTargetKinesis build() {
            return new EventTargetKinesis(
                this.auth.orElse(null),
                this.streamArn.orElse("")
            );
        }
    }

    /**
     * Creates a new builder for the {@link EventTargetKinesis} type.
     *
     * @return a new {@link Builder}
     */
    public static Builder newBuilder(
    ) {
        return new Builder (
        );
    }

    @JsonProperty("auth")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final AwsAuth auth;
    @JsonProperty("stream_arn")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String streamArn;

    /**
     * Creates a new instance of {@link EventTargetKinesis}.
     *
     * @param auth Configuration for how to authenticate into your AWS account. Exactly one of <code>role</code> or <code>creds</code> should be configured.
     * @param streamArn An Amazon Resource Name specifying the Kinesis stream to deposit events into.
     */
    @JsonCreator
    private EventTargetKinesis(
        @JsonProperty("auth") final AwsAuth auth,
        @JsonProperty("stream_arn") final String streamArn
    ) {
        this.auth = Objects.requireNonNull(auth, "auth is required");
        this.streamArn = Objects.requireNonNull(streamArn, "streamArn is required");
    }

    /**
     * Configuration for how to authenticate into your AWS account. Exactly one of
     * <code>role</code> or <code>creds</code> should be configured.
     *
     * @return the value of the property as a {@link AwsAuth}
     */
    public AwsAuth getAuth() {
        return this.auth;
    }

    /**
     * An Amazon Resource Name specifying the Kinesis stream to deposit events into.
     *
     * @return the value of the property as a {@link String}
     */
    public String getStreamArn() {
        return this.streamArn;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EventTargetKinesis other = (EventTargetKinesis) o;
        return
            this.auth.equals(other.auth)&&
            this.streamArn.equals(other.streamArn);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.auth,
            this.streamArn
        );
    }

    @Override
    public String toString() {
        return "EventTargetKinesis{" +
            "auth='" + this.auth +
            "', streamArn='" + this.streamArn +
            "'}";
    }
}
