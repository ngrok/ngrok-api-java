package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointBackendMutate} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointBackendMutate {
    /**
     * Builder class for {@link EndpointBackendMutate}.
     */
    public static class Builder {
        private Optional<Boolean> enabled = Optional.empty();
        private Optional<String> backendId = Optional.empty();

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
         * backend to be used to back this endpoint
         *
         * @param backendId the value of the <code>backend_id</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder backendId(final String backendId) {
            this.backendId = Optional.of(Objects.requireNonNull(backendId, "backendId is required"));
            return this;
        }

        /**
         * backend to be used to back this endpoint
         *
         * @param backendId the value of the <code>backend_id</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder backendId(final Optional<String> backendId) {
            this.backendId = Objects.requireNonNull(backendId, "backendId is required");
            return this;
        }

        /**
         * Constructs the {@link EndpointBackendMutate} instance.
         *
         * @return a new {@link EndpointBackendMutate}
         */
        public EndpointBackendMutate build() {
            return new EndpointBackendMutate(
                this.enabled,
                this.backendId.orElse("")
            );
        }
    }

    /**
     * Creates a new builder for the {@link EndpointBackendMutate} type.
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
    @JsonProperty("backend_id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String backendId;

    /**
     * Creates a new instance of {@link EndpointBackendMutate}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param backendId backend to be used to back this endpoint
     */
    @JsonCreator
    private EndpointBackendMutate(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("backend_id") final String backendId
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
        this.backendId = Objects.requireNonNull(backendId, "backendId is required");
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
     * backend to be used to back this endpoint
     *
     * @return the value of the property as a {@link String}
     */
    public String getBackendId() {
        return this.backendId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointBackendMutate other = (EndpointBackendMutate) o;
        return
            this.enabled.equals(other.enabled)&&
            this.backendId.equals(other.backendId);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.enabled,
            this.backendId
        );
    }

    @Override
    public String toString() {
        return "EndpointBackendMutate{" +
            "enabled='" + this.enabled.map(Object::toString).orElse("(null)") +
            "', backendId='" + this.backendId +
            "'}";
    }
}
