package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EventTargetFirehose} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventTargetFirehose {
    @JsonProperty("auth")
    private final AwsAuth auth;
    @JsonProperty("delivery_stream_arn")
    private final String deliveryStreamArn;

    /**
     * Creates a new instance of {@link EventTargetFirehose}.
     *
     * @param auth Configuration for how to authenticate into your AWS account. Exactly one of <code>role</code> or <code>creds</code> should be configured.
     * @param deliveryStreamArn An Amazon Resource Name specifying the Firehose delivery stream to deposit events into.
     */
    @JsonCreator
    public EventTargetFirehose(
        @JsonProperty("auth") final AwsAuth auth,
        @JsonProperty("delivery_stream_arn") final String deliveryStreamArn
    ) {
        this.auth = Objects.requireNonNull(auth, "auth is required");
        this.deliveryStreamArn = Objects.requireNonNull(deliveryStreamArn, "deliveryStreamArn is required");
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
     * An Amazon Resource Name specifying the Firehose delivery stream to deposit
     * events into.
     *
     * @return the value of the property as a {@link String}
     */
    public String getDeliveryStreamArn() {
        return this.deliveryStreamArn;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EventTargetFirehose other = (EventTargetFirehose) o;
        return
            this.auth.equals(other.auth)&&
            this.deliveryStreamArn.equals(other.deliveryStreamArn);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.auth,
            this.deliveryStreamArn
        );
    }

    @Override
    public String toString() {
        return "EventTargetFirehose{" +
            "auth='" + this.auth +
            "', deliveryStreamArn='" + this.deliveryStreamArn +
            "'}";
    }
}
