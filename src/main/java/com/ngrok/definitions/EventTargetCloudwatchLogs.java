package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EventTargetCloudwatchLogs} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventTargetCloudwatchLogs {
    /**
     * Builder class for {@link EventTargetCloudwatchLogs}.
     */
    public static class Builder {
        private Optional<AwsAuth> auth = Optional.empty();
        private Optional<String> logGroupArn = Optional.empty();

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
         * An Amazon Resource Name specifying the CloudWatch Logs group to deposit events
         * into.
         *
         * @param logGroupArn the value of the <code>log_group_arn</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder logGroupArn(final String logGroupArn) {
            this.logGroupArn = Optional.of(Objects.requireNonNull(logGroupArn, "logGroupArn is required"));
            return this;
        }

        /**
         * An Amazon Resource Name specifying the CloudWatch Logs group to deposit events
         * into.
         *
         * @param logGroupArn the value of the <code>log_group_arn</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder logGroupArn(final Optional<String> logGroupArn) {
            this.logGroupArn = Objects.requireNonNull(logGroupArn, "logGroupArn is required");
            return this;
        }

        /**
         * Constructs the {@link EventTargetCloudwatchLogs} instance.
         *
         * @return a new {@link EventTargetCloudwatchLogs}
         */
        public EventTargetCloudwatchLogs build() {
            return new EventTargetCloudwatchLogs(
                this.auth.orElse(null),
                this.logGroupArn.orElse("")
            );
        }
    }

    /**
     * Creates a new builder for the {@link EventTargetCloudwatchLogs} type.
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
    @JsonProperty("log_group_arn")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String logGroupArn;

    /**
     * Creates a new instance of {@link EventTargetCloudwatchLogs}.
     *
     * @param auth Configuration for how to authenticate into your AWS account. Exactly one of <code>role</code> or <code>creds</code> should be configured.
     * @param logGroupArn An Amazon Resource Name specifying the CloudWatch Logs group to deposit events into.
     */
    @JsonCreator
    private EventTargetCloudwatchLogs(
        @JsonProperty("auth") final AwsAuth auth,
        @JsonProperty("log_group_arn") final String logGroupArn
    ) {
        this.auth = Objects.requireNonNull(auth, "auth is required");
        this.logGroupArn = Objects.requireNonNull(logGroupArn, "logGroupArn is required");
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
     * An Amazon Resource Name specifying the CloudWatch Logs group to deposit events
     * into.
     *
     * @return the value of the property as a {@link String}
     */
    public String getLogGroupArn() {
        return this.logGroupArn;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EventTargetCloudwatchLogs other = (EventTargetCloudwatchLogs) o;
        return
            this.auth.equals(other.auth)&&
            this.logGroupArn.equals(other.logGroupArn);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.auth,
            this.logGroupArn
        );
    }

    @Override
    public String toString() {
        return "EventTargetCloudwatchLogs{" +
            "auth='" + this.auth +
            "', logGroupArn='" + this.logGroupArn +
            "'}";
    }
}
