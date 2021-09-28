package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EndpointResponseHeaders} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EndpointResponseHeaders {
    /**
     * Builder class for {@link EndpointResponseHeaders}.
     */
    public static class Builder {
        private Optional<Boolean> enabled = Optional.empty();
        private Optional<java.util.Map<String, String>> add = Optional.empty();
        private Optional<java.util.List<String>> remove = Optional.empty();

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
         * a map of header key to header value that will be injected into the HTTP Response
         * returned to the HTTP client
		 *
		 * @param add the value of the <code>add</code> parameter as a {@link java.util.Map<String, String>}
		 * @return this builder instance
		 */
        public Builder add(final java.util.Map<String, String> add) {
            this.add = Optional.of(Objects.requireNonNull(add, "add is required"));
            return this;
        }

        /**
         * a map of header key to header value that will be injected into the HTTP Response
         * returned to the HTTP client
		 *
		 * @param add the value of the <code>add</code> parameter as a {@link java.util.Map<String, String>}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder add(final Optional<java.util.Map<String, String>> add) {
            this.add = Objects.requireNonNull(add, "add is required");
            return this;
        }

        /**
         * a list of header names that will be removed from the HTTP Response returned to
         * the HTTP client
		 *
		 * @param remove the value of the <code>remove</code> parameter as a {@link java.util.List<String>}
		 * @return this builder instance
		 */
        public Builder remove(final java.util.List<String> remove) {
            this.remove = Optional.of(Objects.requireNonNull(remove, "remove is required"));
            return this;
        }

        /**
         * a list of header names that will be removed from the HTTP Response returned to
         * the HTTP client
		 *
		 * @param remove the value of the <code>remove</code> parameter as a {@link java.util.List<String>}, wrapped in an {@link Optional}
		 * @return this builder instance
		 */
        public Builder remove(final Optional<java.util.List<String>> remove) {
            this.remove = Objects.requireNonNull(remove, "remove is required");
            return this;
        }

        /**
         * Constructs the {@link EndpointResponseHeaders} instance.
         *
         * @return a new {@link EndpointResponseHeaders}
         */
        public EndpointResponseHeaders build() {
            return new EndpointResponseHeaders(
                this.enabled,
                this.add.orElse(java.util.Collections.emptyMap()),
                this.remove.orElse(java.util.Collections.emptyList())
            );
        }
    }

    /**
     * Creates a new builder for the {@link EndpointResponseHeaders} type.
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
    @JsonProperty("add")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.Map<String, String> add;
    @JsonProperty("remove")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> remove;

    /**
     * Creates a new instance of {@link EndpointResponseHeaders}.
     *
     * @param enabled <code>true</code> if the module will be applied to traffic, <code>false</code> to disable. default <code>true</code> if unspecified
     * @param add a map of header key to header value that will be injected into the HTTP Response returned to the HTTP client
     * @param remove a list of header names that will be removed from the HTTP Response returned to the HTTP client
     */
    @JsonCreator
    private EndpointResponseHeaders(
        @JsonProperty("enabled") final Optional<Boolean> enabled,
        @JsonProperty("add") final java.util.Map<String, String> add,
        @JsonProperty("remove") final java.util.List<String> remove
    ) {
        this.enabled = enabled != null ? enabled : Optional.empty();
        this.add = Objects.requireNonNull(add, "add is required");
        this.remove = Objects.requireNonNull(remove, "remove is required");
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
     * a map of header key to header value that will be injected into the HTTP Response
     * returned to the HTTP client
     *
     * @return the value of the property as a {@link java.util.Map<String, String>}
     */
    public java.util.Map<String, String> getAdd() {
        return this.add;
    }

    /**
     * a list of header names that will be removed from the HTTP Response returned to
     * the HTTP client
     *
     * @return the value of the property as a {@link java.util.List<String>}
     */
    public java.util.List<String> getRemove() {
        return this.remove;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EndpointResponseHeaders other = (EndpointResponseHeaders) o;
        return
            this.enabled.equals(other.enabled)&&
            this.add.equals(other.add)&&
            this.remove.equals(other.remove);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.enabled,
            this.add,
            this.remove
        );
    }

    @Override
    public String toString() {
        return "EndpointResponseHeaders{" +
            "enabled='" + this.enabled.map(Object::toString).orElse("(null)") +
            "', add='" + this.add +
            "', remove='" + this.remove +
            "'}";
    }
}
