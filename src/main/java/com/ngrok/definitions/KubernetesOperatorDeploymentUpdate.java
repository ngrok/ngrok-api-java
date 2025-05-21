/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link KubernetesOperatorDeploymentUpdate} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class KubernetesOperatorDeploymentUpdate {
    /**
     * Builder class for {@link KubernetesOperatorDeploymentUpdate}.
     */
    public static class Builder {
        private Optional<String> name = Optional.empty();
        private Optional<String> version = Optional.empty();

        private Builder(
        ) {
        }

        /**
         * the deployment name
         *
         * @param name the value of the <code>name</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder name(final String name) {
            this.name = Optional.of(Objects.requireNonNull(name, "name is required"));
            return this;
        }

        /**
         * the deployment name
         *
         * @param name the value of the <code>name</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder name(final Optional<String> name) {
            this.name = Objects.requireNonNull(name, "name is required");
            return this;
        }

        /**
         * the version of this Kubernetes Operator
         *
         * @param version the value of the <code>version</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder version(final String version) {
            this.version = Optional.of(Objects.requireNonNull(version, "version is required"));
            return this;
        }

        /**
         * the version of this Kubernetes Operator
         *
         * @param version the value of the <code>version</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder version(final Optional<String> version) {
            this.version = Objects.requireNonNull(version, "version is required");
            return this;
        }

        /**
         * Constructs the {@link KubernetesOperatorDeploymentUpdate} instance.
         *
         * @return a new {@link KubernetesOperatorDeploymentUpdate}
         */
        public KubernetesOperatorDeploymentUpdate build() {
            return new KubernetesOperatorDeploymentUpdate(
                this.name,
                this.version
            );
        }
    }

    /**
     * Creates a new builder for the {@link KubernetesOperatorDeploymentUpdate} type.
     *
     * @return a new {@link Builder}
     */
    public static Builder newBuilder(
    ) {
        return new Builder (
        );
    }

    @JsonProperty("name")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> name;
    @JsonProperty("version")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> version;

    /**
     * Creates a new instance of {@link KubernetesOperatorDeploymentUpdate}.
     *
     * @param name the deployment name
     * @param version the version of this Kubernetes Operator
     */
    @JsonCreator
    private KubernetesOperatorDeploymentUpdate(
        @JsonProperty("name") final Optional<String> name,
        @JsonProperty("version") final Optional<String> version
    ) {
        this.name = name != null ? name : Optional.empty();
        this.version = version != null ? version : Optional.empty();
    }

    /**
     * the deployment name
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getName() {
        return this.name;
    }

    /**
     * the version of this Kubernetes Operator
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getVersion() {
        return this.version;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final KubernetesOperatorDeploymentUpdate other = (KubernetesOperatorDeploymentUpdate) o;
        return
            this.name.equals(other.name)&&
            this.version.equals(other.version);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.name,
            this.version
        );
    }

    @Override
    public String toString() {
        return "KubernetesOperatorDeploymentUpdate{" +
            "name='" + this.name.orElse("(null)") +
            "', version='" + this.version.orElse("(null)") +
            "'}";
    }
}
