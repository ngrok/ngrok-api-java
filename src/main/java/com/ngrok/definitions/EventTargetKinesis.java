package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EventTargetKinesis} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventTargetKinesis {
    @JsonProperty("auth")
    private final AwsAuth auth;
    @JsonProperty("stream_arn")
    private final String streamArn;

    /**
     * Creates a new instance of {@link EventTargetKinesis}.
     *
     * @param auth Configuration for how to authenticate into your AWS account. Exactly one of <code>role</code> or <code>creds</code> should be configured.
     * @param streamArn An Amazon Resource Name specifying the Kinesis stream to deposit events into.
     */
    @JsonCreator
    public EventTargetKinesis(
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
