package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EventTargetCloudwatchLogs} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventTargetCloudwatchLogs {
    @JsonProperty("auth")
    private final AwsAuth auth;
    @JsonProperty("log_group_arn")
    private final String logGroupArn;

    /**
     * Creates a new instance of {@link EventTargetCloudwatchLogs}.
     *
     * @param auth Configuration for how to authenticate into your AWS account. Exactly one of <code>role</code> or <code>creds</code> should be configured.
     * @param logGroupArn An Amazon Resource Name specifying the CloudWatch Logs group to deposit events into.
     */
    @JsonCreator
    public EventTargetCloudwatchLogs(
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
