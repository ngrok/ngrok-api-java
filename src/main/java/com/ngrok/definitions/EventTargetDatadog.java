/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EventTargetDatadog} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventTargetDatadog {
    /**
     * Builder class for {@link EventTargetDatadog}.
     */
    public static class Builder {
        private Optional<String> apiKey = Optional.empty();
        private Optional<String> ddtags = Optional.empty();
        private Optional<String> service = Optional.empty();
        private Optional<String> ddsite = Optional.empty();

        private Builder(
        ) {
        }

        /**
         * Datadog API key to use.
         *
         * @param apiKey the value of the <code>api_key</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder apiKey(final String apiKey) {
            this.apiKey = Optional.of(Objects.requireNonNull(apiKey, "apiKey is required"));
            return this;
        }

        /**
         * Datadog API key to use.
         *
         * @param apiKey the value of the <code>api_key</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder apiKey(final Optional<String> apiKey) {
            this.apiKey = Objects.requireNonNull(apiKey, "apiKey is required");
            return this;
        }

        /**
         * Tags to send with the event.
         *
         * @param ddtags the value of the <code>ddtags</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder ddtags(final String ddtags) {
            this.ddtags = Optional.of(Objects.requireNonNull(ddtags, "ddtags is required"));
            return this;
        }

        /**
         * Tags to send with the event.
         *
         * @param ddtags the value of the <code>ddtags</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder ddtags(final Optional<String> ddtags) {
            this.ddtags = Objects.requireNonNull(ddtags, "ddtags is required");
            return this;
        }

        /**
         * Service name to send with the event.
         *
         * @param service the value of the <code>service</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder service(final String service) {
            this.service = Optional.of(Objects.requireNonNull(service, "service is required"));
            return this;
        }

        /**
         * Service name to send with the event.
         *
         * @param service the value of the <code>service</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder service(final Optional<String> service) {
            this.service = Objects.requireNonNull(service, "service is required");
            return this;
        }

        /**
         * Datadog site to send event to.
         *
         * @param ddsite the value of the <code>ddsite</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder ddsite(final String ddsite) {
            this.ddsite = Optional.of(Objects.requireNonNull(ddsite, "ddsite is required"));
            return this;
        }

        /**
         * Datadog site to send event to.
         *
         * @param ddsite the value of the <code>ddsite</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder ddsite(final Optional<String> ddsite) {
            this.ddsite = Objects.requireNonNull(ddsite, "ddsite is required");
            return this;
        }

        /**
         * Constructs the {@link EventTargetDatadog} instance.
         *
         * @return a new {@link EventTargetDatadog}
         */
        public EventTargetDatadog build() {
            return new EventTargetDatadog(
                this.apiKey,
                this.ddtags,
                this.service,
                this.ddsite
            );
        }
    }

    /**
     * Creates a new builder for the {@link EventTargetDatadog} type.
     *
     * @return a new {@link Builder}
     */
    public static Builder newBuilder(
    ) {
        return new Builder (
        );
    }

    @JsonProperty("api_key")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> apiKey;
    @JsonProperty("ddtags")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> ddtags;
    @JsonProperty("service")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> service;
    @JsonProperty("ddsite")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> ddsite;

    /**
     * Creates a new instance of {@link EventTargetDatadog}.
     *
     * @param apiKey Datadog API key to use.
     * @param ddtags Tags to send with the event.
     * @param service Service name to send with the event.
     * @param ddsite Datadog site to send event to.
     */
    @JsonCreator
    private EventTargetDatadog(
        @JsonProperty("api_key") final Optional<String> apiKey,
        @JsonProperty("ddtags") final Optional<String> ddtags,
        @JsonProperty("service") final Optional<String> service,
        @JsonProperty("ddsite") final Optional<String> ddsite
    ) {
        this.apiKey = apiKey != null ? apiKey : Optional.empty();
        this.ddtags = ddtags != null ? ddtags : Optional.empty();
        this.service = service != null ? service : Optional.empty();
        this.ddsite = ddsite != null ? ddsite : Optional.empty();
    }

    /**
     * Datadog API key to use.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getApiKey() {
        return this.apiKey;
    }

    /**
     * Tags to send with the event.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getDdtags() {
        return this.ddtags;
    }

    /**
     * Service name to send with the event.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getService() {
        return this.service;
    }

    /**
     * Datadog site to send event to.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getDdsite() {
        return this.ddsite;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EventTargetDatadog other = (EventTargetDatadog) o;
        return
            this.apiKey.equals(other.apiKey)&&
            this.ddtags.equals(other.ddtags)&&
            this.service.equals(other.service)&&
            this.ddsite.equals(other.ddsite);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.apiKey,
            this.ddtags,
            this.service,
            this.ddsite
        );
    }

    @Override
    public String toString() {
        return "EventTargetDatadog{" +
            "apiKey='" + this.apiKey.orElse("(null)") +
            "', ddtags='" + this.ddtags.orElse("(null)") +
            "', service='" + this.service.orElse("(null)") +
            "', ddsite='" + this.ddsite.orElse("(null)") +
            "'}";
    }
}
