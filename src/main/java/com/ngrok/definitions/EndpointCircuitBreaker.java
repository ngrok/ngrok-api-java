package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointCircuitBreaker} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointCircuitBreaker {
    /**
     * Builder class for {@link EndpointCircuitBreaker}.
     */
    public static class Builder {
        private Optional<Boolean> enabled = Optional.empty();
        private Optional<java.time.Duration> trippedDuration = Optional.empty();
        private Optional<Long> rollingWindow = Optional.empty();
        private Optional<Long> numBuckets = Optional.empty();
        private Optional<Long> volumeThreshold = Optional.empty();
        private Optional<Double> errorThresholdPercentage = Optional.empty();

        private Builder(
        ) {
        }

        /**
         * <code>true</code> if the module will be applied to traffic, <code>false</code>
         * to disable. default <code>true</code> if unspecified
		 *
		 * @param enabled the value of the <code>enabled</code> parameter as a {@link boolean}
		 * @return this builder instance
		 */
        public Builder enabled(final boolean enabled) {
            this.enabled = Optional.of(Objects.requireNonNull(enabled, "enabled is required"));
            return this;
        }

        /**
         * <code>true</code> if the module will be applied to traffic, <code>false</code>
         * to disable. default <code>true</code> if unspecified
		 *
		 * @param enabled the value of the <code>enabled</code> parameter as a {@link boolean}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder enabled(final Optional<Boolean> enabled) {
            this.enabled = Objects.requireNonNull(enabled, "enabled is required");
            return this;
        }

        /**
         * Integer number of seconds after which the circuit is tripped to wait before
         * re-evaluating upstream health
		 *
		 * @param trippedDuration the value of the <code>tripped_duration</code> parameter as a {@link java.time.Duration}
		 * @return this builder instance
		 */
        public Builder trippedDuration(final java.time.Duration trippedDuration) {
            this.trippedDuration = Optional.of(Objects.requireNonNull(trippedDuration, "trippedDuration is required"));
            return this;
        }

        /**
         * Integer number of seconds after which the circuit is tripped to wait before
         * re-evaluating upstream health
		 *
		 * @param trippedDuration the value of the <code>tripped_duration</code> parameter as a {@link java.time.Duration}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder trippedDuration(final Optional<java.time.Duration> trippedDuration) {
            this.trippedDuration = Objects.requireNonNull(trippedDuration, "trippedDuration is required");
            return this;
        }

        /**
         * Integer number of seconds in the statistical rolling window that metrics are
         * retained for.
		 *
		 * @param rollingWindow the value of the <code>rolling_window</code> parameter as a {@link long}
		 * @return this builder instance
		 */
        public Builder rollingWindow(final long rollingWindow) {
            this.rollingWindow = Optional.of(Objects.requireNonNull(rollingWindow, "rollingWindow is required"));
            return this;
        }

        /**
         * Integer number of seconds in the statistical rolling window that metrics are
         * retained for.
		 *
		 * @param rollingWindow the value of the <code>rolling_window</code> parameter as a {@link long}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder rollingWindow(final Optional<Long> rollingWindow) {
            this.rollingWindow = Objects.requireNonNull(rollingWindow, "rollingWindow is required");
            return this;
        }

        /**
         * Integer number of buckets into which metrics are retained. Max 128.
		 *
		 * @param numBuckets the value of the <code>num_buckets</code> parameter as a {@link long}
		 * @return this builder instance
		 */
        public Builder numBuckets(final long numBuckets) {
            this.numBuckets = Optional.of(Objects.requireNonNull(numBuckets, "numBuckets is required"));
            return this;
        }

        /**
         * Integer number of buckets into which metrics are retained. Max 128.
		 *
		 * @param numBuckets the value of the <code>num_buckets</code> parameter as a {@link long}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder numBuckets(final Optional<Long> numBuckets) {
            this.numBuckets = Objects.requireNonNull(numBuckets, "numBuckets is required");
            return this;
        }

        /**
         * Integer number of requests in a rolling window that will trip the circuit.
         * Helpful if traffic volume is low.
		 *
		 * @param volumeThreshold the value of the <code>volume_threshold</code> parameter as a {@link long}
		 * @return this builder instance
		 */
        public Builder volumeThreshold(final long volumeThreshold) {
            this.volumeThreshold = Optional.of(Objects.requireNonNull(volumeThreshold, "volumeThreshold is required"));
            return this;
        }

        /**
         * Integer number of requests in a rolling window that will trip the circuit.
         * Helpful if traffic volume is low.
		 *
		 * @param volumeThreshold the value of the <code>volume_threshold</code> parameter as a {@link long}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder volumeThreshold(final Optional<Long> volumeThreshold) {
            this.volumeThreshold = Objects.requireNonNull(volumeThreshold, "volumeThreshold is required");
            return this;
        }

        /**
         * Error threshold percentage should be between 0 - 1.0, not 0-100.0
		 *
		 * @param errorThresholdPercentage the value of the <code>error_threshold_percentage</code> parameter as a {@link double}
		 * @return this builder instance
		 */
        public Builder errorThresholdPercentage(final double errorThresholdPercentage) {
            this.errorThresholdPercentage = Optional.of(Objects.requireNonNull(errorThresholdPercentage, "errorThresholdPercentage is required"));
            return this;
        }

        /**
         * Error threshold percentage should be between 0 - 1.0, not 0-100.0
		 *
		 * @param errorThresholdPercentage the value of the <code>error_threshold_percentage</code> parameter as a {@link double}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder errorThresholdPercentage(final Optional<Double> errorThresholdPercentage) {
            this.errorThresholdPercentage = Objects.requireNonNull(errorThresholdPercentage, "errorThresholdPercentage is required");
            return this;
        }

        /**
         * Constructs the {@link EndpointCircuitBreaker} instance.
         *
         * @return a new {@link EndpointCircuitBreaker}
         */
        public EndpointCircuitBreaker build() {
            return new EndpointCircuitBreaker(
                this.enabled,
                this.trippedDuration.orElse(java.time.Duration.ZERO),
                this.rollingWindow.orElse(0L),
                this.numBuckets.orElse(0L),
                this.volumeThreshold.orElse(0L),
                this.errorThresholdPercentage.orElse(0.0d)
            );
        }
    }

    /**
     * Creates a new builder for the {@link EndpointCircuitBreaker} type.
     *
     * @return a new {@link Builder}
     */
    public static Builder newBuilder(
    ) {
        return new Builder (
        );
    }

    @JsonProperty("enabled")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Boolean> enabled;
    @JsonProperty("tripped_duration")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.Duration trippedDuration;
    @JsonProperty("rolling_window")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final long rollingWindow;
    @JsonProperty("num_buckets")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final long numBuckets;
    @JsonProperty("volume_threshold")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final long volumeThreshold;
    @JsonProperty("error_threshold_percentage")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final double errorThresholdPercentage;

    /**
     * Creates a new instance of {@link EndpointCircuitBreaker}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param trippedDuration Integer number of seconds after which the circuit is tripped to wait before re-evaluating upstream health
     * @param rollingWindow Integer number of seconds in the statistical rolling window that metrics are retained for.
     * @param numBuckets Integer number of buckets into which metrics are retained. Max 128.
     * @param volumeThreshold Integer number of requests in a rolling window that will trip the circuit. Helpful if traffic volume is low.
     * @param errorThresholdPercentage Error threshold percentage should be between 0 - 1.0, not 0-100.0
     */
    @JsonCreator
    private EndpointCircuitBreaker(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("tripped_duration") final java.time.Duration trippedDuration,
        @JsonProperty("rolling_window") final Long rollingWindow,
        @JsonProperty("num_buckets") final Long numBuckets,
        @JsonProperty("volume_threshold") final Long volumeThreshold,
        @JsonProperty("error_threshold_percentage") final Double errorThresholdPercentage
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
        this.trippedDuration = Objects.requireNonNull(trippedDuration, "trippedDuration is required");
        this.rollingWindow = Objects.requireNonNull(rollingWindow, "rollingWindow is required");
        this.numBuckets = Objects.requireNonNull(numBuckets, "numBuckets is required");
        this.volumeThreshold = Objects.requireNonNull(volumeThreshold, "volumeThreshold is required");
        this.errorThresholdPercentage = Objects.requireNonNull(errorThresholdPercentage, "errorThresholdPercentage is required");
    }

    /**
     * <code>true</code> if the module will be applied to traffic, <code>false</code>
     * to disable. default <code>true</code> if unspecified
     *
     * @return the value of the property as a {@link boolean} wrapped in an {@link Optional}
     */
    public Optional<Boolean> getEnabled() {
        return this.enabled;
    }

    /**
     * Integer number of seconds after which the circuit is tripped to wait before
     * re-evaluating upstream health
     *
     * @return the value of the property as a {@link java.time.Duration}
     */
    public java.time.Duration getTrippedDuration() {
        return this.trippedDuration;
    }

    /**
     * Integer number of seconds in the statistical rolling window that metrics are
     * retained for.
     *
     * @return the value of the property as a {@link long}
     */
    public long getRollingWindow() {
        return this.rollingWindow;
    }

    /**
     * Integer number of buckets into which metrics are retained. Max 128.
     *
     * @return the value of the property as a {@link long}
     */
    public long getNumBuckets() {
        return this.numBuckets;
    }

    /**
     * Integer number of requests in a rolling window that will trip the circuit.
     * Helpful if traffic volume is low.
     *
     * @return the value of the property as a {@link long}
     */
    public long getVolumeThreshold() {
        return this.volumeThreshold;
    }

    /**
     * Error threshold percentage should be between 0 - 1.0, not 0-100.0
     *
     * @return the value of the property as a {@link double}
     */
    public double getErrorThresholdPercentage() {
        return this.errorThresholdPercentage;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointCircuitBreaker other = (EndpointCircuitBreaker) o;
        return
            this.enabled.equals(other.enabled)&&
            this.trippedDuration == other.trippedDuration&&
            this.rollingWindow == other.rollingWindow&&
            this.numBuckets == other.numBuckets&&
            this.volumeThreshold == other.volumeThreshold&&
            this.errorThresholdPercentage == other.errorThresholdPercentage;
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.enabled,
            this.trippedDuration,
            this.rollingWindow,
            this.numBuckets,
            this.volumeThreshold,
            this.errorThresholdPercentage
        );
    }

    @Override
    public String toString() {
        return "EndpointCircuitBreaker{" +
            "enabled='" + this.enabled.map(Object::toString).orElse("(null)") +
            "', trippedDuration='" + this.trippedDuration +
            "', rollingWindow='" + this.rollingWindow +
            "', numBuckets='" + this.numBuckets +
            "', volumeThreshold='" + this.volumeThreshold +
            "', errorThresholdPercentage='" + this.errorThresholdPercentage +
            "'}";
    }
}
