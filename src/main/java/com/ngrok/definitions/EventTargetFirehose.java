package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EventTargetFirehose} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventTargetFirehose {
    /**
     * Builder class for {@link EventTargetFirehose}.
     */
    public static class Builder {
        private Optional<AwsAuth> auth = Optional.empty();
        private Optional<String> deliveryStreamArn = Optional.empty();

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
         * An Amazon Resource Name specifying the Firehose delivery stream to deposit
         * events into.
         *
         * @param deliveryStreamArn the value of the <code>delivery_stream_arn</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder deliveryStreamArn(final String deliveryStreamArn) {
            this.deliveryStreamArn = Optional.of(Objects.requireNonNull(deliveryStreamArn, "deliveryStreamArn is required"));
            return this;
        }

        /**
         * An Amazon Resource Name specifying the Firehose delivery stream to deposit
         * events into.
         *
         * @param deliveryStreamArn the value of the <code>delivery_stream_arn</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder deliveryStreamArn(final Optional<String> deliveryStreamArn) {
            this.deliveryStreamArn = Objects.requireNonNull(deliveryStreamArn, "deliveryStreamArn is required");
            return this;
        }

        /**
         * Constructs the {@link EventTargetFirehose} instance.
         *
         * @return a new {@link EventTargetFirehose}
         */
        public EventTargetFirehose build() {
            return new EventTargetFirehose(
                this.auth.orElse(null),
                this.deliveryStreamArn.orElse("")
            );
        }
    }

    /**
     * Creates a new builder for the {@link EventTargetFirehose} type.
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
    @JsonProperty("delivery_stream_arn")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String deliveryStreamArn;

    /**
     * Creates a new instance of {@link EventTargetFirehose}.
     *
     * @param auth Configuration for how to authenticate into your AWS account. Exactly one of <code>role</code> or <code>creds</code> should be configured.
     * @param deliveryStreamArn An Amazon Resource Name specifying the Firehose delivery stream to deposit events into.
     */
    @JsonCreator
    private EventTargetFirehose(
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
