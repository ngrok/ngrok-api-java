package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EventTarget} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventTarget {
    @JsonProperty("firehose")
    private final Optional<EventTargetFirehose> firehose;
    @JsonProperty("kinesis")
    private final Optional<EventTargetKinesis> kinesis;
    @JsonProperty("cloudwatch_logs")
    private final Optional<EventTargetCloudwatchLogs> cloudwatchLogs;

    /**
     * Creates a new instance of {@link EventTarget}.
     *
     * @param firehose Configuration used to send events to Amazon Kinesis Data Firehose.
     * @param kinesis Configuration used to send events to Amazon Kinesis.
     * @param cloudwatchLogs Configuration used to send events to Amazon CloudWatch Logs.
     */
    @JsonCreator
    public EventTarget(
        @JsonProperty("firehose") final Optional<EventTargetFirehose> firehose,
        @JsonProperty("kinesis") final Optional<EventTargetKinesis> kinesis,
        @JsonProperty("cloudwatch_logs") final Optional<EventTargetCloudwatchLogs> cloudwatchLogs
    ) {
        this.firehose = firehose != null ? firehose : Optional.empty();
        this.kinesis = kinesis != null ? kinesis : Optional.empty();
        this.cloudwatchLogs = cloudwatchLogs != null ? cloudwatchLogs : Optional.empty();
    }

    /**
     * Configuration used to send events to Amazon Kinesis Data Firehose.
     *
     * @return the value of the property as a {@link EventTargetFirehose} wrapped in an {@link Optional}
     */
    public Optional<EventTargetFirehose> getFirehose() {
        return this.firehose;
    }

    /**
     * Configuration used to send events to Amazon Kinesis.
     *
     * @return the value of the property as a {@link EventTargetKinesis} wrapped in an {@link Optional}
     */
    public Optional<EventTargetKinesis> getKinesis() {
        return this.kinesis;
    }

    /**
     * Configuration used to send events to Amazon CloudWatch Logs.
     *
     * @return the value of the property as a {@link EventTargetCloudwatchLogs} wrapped in an {@link Optional}
     */
    public Optional<EventTargetCloudwatchLogs> getCloudwatchLogs() {
        return this.cloudwatchLogs;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EventTarget other = (EventTarget) o;
        return
            this.firehose.equals(other.firehose)&&
            this.kinesis.equals(other.kinesis)&&
            this.cloudwatchLogs.equals(other.cloudwatchLogs);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.firehose,
            this.kinesis,
            this.cloudwatchLogs
        );
    }

    @Override
    public String toString() {
        return "EventTarget{" +
            "firehose='" + this.firehose.map(Object::toString).orElse("(null)") +
            "', kinesis='" + this.kinesis.map(Object::toString).orElse("(null)") +
            "', cloudwatchLogs='" + this.cloudwatchLogs.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
