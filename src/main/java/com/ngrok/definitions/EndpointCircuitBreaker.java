package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointCircuitBreaker} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointCircuitBreaker {
    @JsonProperty("enabled")
    private final Optional<Boolean> enabled;
    @JsonProperty("tripped_duration")
    private final java.time.Duration trippedDuration;
    @JsonProperty("rolling_window")
    private final long rollingWindow;
    @JsonProperty("num_buckets")
    private final long numBuckets;
    @JsonProperty("volume_threshold")
    private final long volumeThreshold;
    @JsonProperty("error_threshold_percentage")
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
    public EndpointCircuitBreaker(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("tripped_duration") final java.time.Duration trippedDuration,
        @JsonProperty("rolling_window") final long rollingWindow,
        @JsonProperty("num_buckets") final long numBuckets,
        @JsonProperty("volume_threshold") final long volumeThreshold,
        @JsonProperty("error_threshold_percentage") final double errorThresholdPercentage
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
