/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointUserAgentFilter} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointUserAgentFilter {
    /**
     * Builder class for {@link EndpointUserAgentFilter}.
     */
    public static class Builder {
        private Optional<Boolean> enabled = Optional.empty();
        private java.util.List<String> allow = java.util.Collections.emptyList();
        private java.util.List<String> deny = java.util.Collections.emptyList();

        private Builder(
        ) {
        }

        /**
         * Sets the enabled property
         *
         * @param enabled the value of the <code>enabled</code> parameter as a {@link boolean}
         * @return this builder instance
         */
        public Builder enabled(final boolean enabled) {
            this.enabled = Optional.of(Objects.requireNonNull(enabled, "enabled is required"));
            return this;
        }

        /**
         * Sets the enabled property
         *
         * @param enabled the value of the <code>enabled</code> parameter as a {@link boolean}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder enabled(final Optional<Boolean> enabled) {
            this.enabled = Objects.requireNonNull(enabled, "enabled is required");
            return this;
        }

        /**
         * Sets the allow property
         *
         * @param allow the value of the <code>allow</code> parameter as a {@link java.util.List} of {@link String}
         * @return this builder instance
         */
        public Builder allow(final java.util.List<String> allow) {
            this.allow = Objects.requireNonNull(allow, "allow is required");
            return this;
        }

        /**
         * Sets the allow property
         *
         * @param allow the value of the <code>allow</code> parameter as a {@link java.util.List} of {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder allow(final Optional<java.util.List<String>> allow) {
            this.allow = Objects.requireNonNull(allow, "allow is required").orElse(java.util.Collections.emptyList());
            return this;
        }

        /**
         * Sets the deny property
         *
         * @param deny the value of the <code>deny</code> parameter as a {@link java.util.List} of {@link String}
         * @return this builder instance
         */
        public Builder deny(final java.util.List<String> deny) {
            this.deny = Objects.requireNonNull(deny, "deny is required");
            return this;
        }

        /**
         * Sets the deny property
         *
         * @param deny the value of the <code>deny</code> parameter as a {@link java.util.List} of {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder deny(final Optional<java.util.List<String>> deny) {
            this.deny = Objects.requireNonNull(deny, "deny is required").orElse(java.util.Collections.emptyList());
            return this;
        }

        /**
         * Constructs the {@link EndpointUserAgentFilter} instance.
         *
         * @return a new {@link EndpointUserAgentFilter}
         */
        public EndpointUserAgentFilter build() {
            return new EndpointUserAgentFilter(
                this.enabled,
                this.allow,
                this.deny
            );
        }
    }

    /**
     * Creates a new builder for the {@link EndpointUserAgentFilter} type.
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
    @JsonProperty("allow")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> allow;
    @JsonProperty("deny")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> deny;

    /**
     * Creates a new instance of {@link EndpointUserAgentFilter}.
     *
     * @param enabled the value of the <code>enabled</code> parameter as a {@link boolean}
     * @param allow the value of the <code>allow</code> parameter as a {@link java.util.List} of {@link String}
     * @param deny the value of the <code>deny</code> parameter as a {@link java.util.List} of {@link String}
     */
    @JsonCreator
    private EndpointUserAgentFilter(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("allow") final java.util.List<String> allow,
        @JsonProperty("deny") final java.util.List<String> deny
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
        this.allow = allow != null ? allow : java.util.Collections.emptyList();
        this.deny = deny != null ? deny : java.util.Collections.emptyList();
    }

    /**
     * Fetches the value of the <code>enabled</code> property.
     *
     * @return the value of the property as a {@link boolean} wrapped in an {@link Optional}
     */
    public Optional<Boolean> getEnabled() {
        return this.enabled;
    }

    /**
     * Fetches the value of the <code>allow</code> property.
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getAllow() {
        return this.allow;
    }

    /**
     * Fetches the value of the <code>deny</code> property.
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getDeny() {
        return this.deny;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointUserAgentFilter other = (EndpointUserAgentFilter) o;
        return
            this.enabled.equals(other.enabled)&&
            this.allow.equals(other.allow)&&
            this.deny.equals(other.deny);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.enabled,
            this.allow,
            this.deny
        );
    }

    @Override
    public String toString() {
        return "EndpointUserAgentFilter{" +
            "enabled='" + this.enabled.map(Object::toString).orElse("(null)") +
            "', allow='" + this.allow +
            "', deny='" + this.deny +
            "'}";
    }
}
