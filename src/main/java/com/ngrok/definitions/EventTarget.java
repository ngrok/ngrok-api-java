package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EventTarget} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventTarget {
    /**
     * Builder class for {@link EventTarget}.
     */
    public static class Builder {
        private Optional<EventTargetFirehose> firehose = Optional.empty();
        private Optional<EventTargetKinesis> kinesis = Optional.empty();
        private Optional<EventTargetCloudwatchLogs> cloudwatchLogs = Optional.empty();

        private Builder(
        ) {
        }

        /**
         * Configuration used to send events to Amazon Kinesis Data Firehose.
		 *
		 * @param firehose the value of the <code>firehose</code> parameter as a {@link EventTargetFirehose}
		 * @return this builder instance
		 */
        public Builder firehose(final EventTargetFirehose firehose) {
            this.firehose = Optional.of(Objects.requireNonNull(firehose, "firehose is required"));
            return this;
        }

        /**
         * Configuration used to send events to Amazon Kinesis Data Firehose.
		 *
		 * @param firehose the value of the <code>firehose</code> parameter as a {@link EventTargetFirehose}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder firehose(final Optional<EventTargetFirehose> firehose) {
            this.firehose = Objects.requireNonNull(firehose, "firehose is required");
            return this;
        }

        /**
         * Configuration used to send events to Amazon Kinesis.
		 *
		 * @param kinesis the value of the <code>kinesis</code> parameter as a {@link EventTargetKinesis}
		 * @return this builder instance
		 */
        public Builder kinesis(final EventTargetKinesis kinesis) {
            this.kinesis = Optional.of(Objects.requireNonNull(kinesis, "kinesis is required"));
            return this;
        }

        /**
         * Configuration used to send events to Amazon Kinesis.
		 *
		 * @param kinesis the value of the <code>kinesis</code> parameter as a {@link EventTargetKinesis}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder kinesis(final Optional<EventTargetKinesis> kinesis) {
            this.kinesis = Objects.requireNonNull(kinesis, "kinesis is required");
            return this;
        }

        /**
         * Configuration used to send events to Amazon CloudWatch Logs.
		 *
		 * @param cloudwatchLogs the value of the <code>cloudwatch_logs</code> parameter as a {@link EventTargetCloudwatchLogs}
		 * @return this builder instance
		 */
        public Builder cloudwatchLogs(final EventTargetCloudwatchLogs cloudwatchLogs) {
            this.cloudwatchLogs = Optional.of(Objects.requireNonNull(cloudwatchLogs, "cloudwatchLogs is required"));
            return this;
        }

        /**
         * Configuration used to send events to Amazon CloudWatch Logs.
		 *
		 * @param cloudwatchLogs the value of the <code>cloudwatch_logs</code> parameter as a {@link EventTargetCloudwatchLogs}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder cloudwatchLogs(final Optional<EventTargetCloudwatchLogs> cloudwatchLogs) {
            this.cloudwatchLogs = Objects.requireNonNull(cloudwatchLogs, "cloudwatchLogs is required");
            return this;
        }

        /**
         * Constructs the {@link EventTarget} instance.
         *
         * @return a new {@link EventTarget}
         */
        public EventTarget build() {
            return new EventTarget(
                this.firehose,
                this.kinesis,
                this.cloudwatchLogs
            );
        }
    }

    /**
     * Creates a new builder for the {@link EventTarget} type.
     *
     * @return a new {@link Builder}
     */
    public static Builder newBuilder(
    ) {
        return new Builder (
        );
    }

    @JsonProperty("firehose")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EventTargetFirehose> firehose;
    @JsonProperty("kinesis")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EventTargetKinesis> kinesis;
    @JsonProperty("cloudwatch_logs")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<EventTargetCloudwatchLogs> cloudwatchLogs;

    /**
     * Creates a new instance of {@link EventTarget}.
     *
     * @param firehose Configuration used to send events to Amazon Kinesis Data Firehose.
     * @param kinesis Configuration used to send events to Amazon Kinesis.
     * @param cloudwatchLogs Configuration used to send events to Amazon CloudWatch Logs.
     */
    @JsonCreator
    private EventTarget(
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
