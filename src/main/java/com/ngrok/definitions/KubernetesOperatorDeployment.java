/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link KubernetesOperatorDeployment} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class KubernetesOperatorDeployment {
    /**
     * Builder class for {@link KubernetesOperatorDeployment}.
     */
    public static class Builder {
        private Optional<String> name = Optional.empty();
        private Optional<String> namespace = Optional.empty();
        private Optional<String> version = Optional.empty();
        private Optional<String> clusterName = Optional.empty();

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
         * the namespace this Kubernetes Operator is deployed to
         *
         * @param namespace the value of the <code>namespace</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder namespace(final String namespace) {
            this.namespace = Optional.of(Objects.requireNonNull(namespace, "namespace is required"));
            return this;
        }

        /**
         * the namespace this Kubernetes Operator is deployed to
         *
         * @param namespace the value of the <code>namespace</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder namespace(final Optional<String> namespace) {
            this.namespace = Objects.requireNonNull(namespace, "namespace is required");
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
         * user-given name for the cluster the Kubernetes Operator is deployed to
         *
         * @param clusterName the value of the <code>cluster_name</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder clusterName(final String clusterName) {
            this.clusterName = Optional.of(Objects.requireNonNull(clusterName, "clusterName is required"));
            return this;
        }

        /**
         * user-given name for the cluster the Kubernetes Operator is deployed to
         *
         * @param clusterName the value of the <code>cluster_name</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder clusterName(final Optional<String> clusterName) {
            this.clusterName = Objects.requireNonNull(clusterName, "clusterName is required");
            return this;
        }

        /**
         * Constructs the {@link KubernetesOperatorDeployment} instance.
         *
         * @return a new {@link KubernetesOperatorDeployment}
         */
        public KubernetesOperatorDeployment build() {
            return new KubernetesOperatorDeployment(
                this.name.orElse(""),
                this.namespace.orElse(""),
                this.version.orElse(""),
                this.clusterName.orElse("")
            );
        }
    }

    /**
     * Creates a new builder for the {@link KubernetesOperatorDeployment} type.
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
    private final String name;
    @JsonProperty("namespace")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String namespace;
    @JsonProperty("version")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String version;
    @JsonProperty("cluster_name")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String clusterName;

    /**
     * Creates a new instance of {@link KubernetesOperatorDeployment}.
     *
     * @param name the deployment name
     * @param namespace the namespace this Kubernetes Operator is deployed to
     * @param version the version of this Kubernetes Operator
     * @param clusterName user-given name for the cluster the Kubernetes Operator is deployed to
     */
    @JsonCreator
    private KubernetesOperatorDeployment(
        @JsonProperty("name") final String name,
        @JsonProperty("namespace") final String namespace,
        @JsonProperty("version") final String version,
        @JsonProperty("cluster_name") final String clusterName
    ) {
        this.name = Objects.requireNonNull(name, "name is required");
        this.namespace = Objects.requireNonNull(namespace, "namespace is required");
        this.version = Objects.requireNonNull(version, "version is required");
        this.clusterName = Objects.requireNonNull(clusterName, "clusterName is required");
    }

    /**
     * the deployment name
     *
     * @return the value of the property as a {@link String}
     */
    public String getName() {
        return this.name;
    }

    /**
     * the namespace this Kubernetes Operator is deployed to
     *
     * @return the value of the property as a {@link String}
     */
    public String getNamespace() {
        return this.namespace;
    }

    /**
     * the version of this Kubernetes Operator
     *
     * @return the value of the property as a {@link String}
     */
    public String getVersion() {
        return this.version;
    }

    /**
     * user-given name for the cluster the Kubernetes Operator is deployed to
     *
     * @return the value of the property as a {@link String}
     */
    public String getClusterName() {
        return this.clusterName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final KubernetesOperatorDeployment other = (KubernetesOperatorDeployment) o;
        return
            this.name.equals(other.name)&&
            this.namespace.equals(other.namespace)&&
            this.version.equals(other.version)&&
            this.clusterName.equals(other.clusterName);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.name,
            this.namespace,
            this.version,
            this.clusterName
        );
    }

    @Override
    public String toString() {
        return "KubernetesOperatorDeployment{" +
            "name='" + this.name +
            "', namespace='" + this.namespace +
            "', version='" + this.version +
            "', clusterName='" + this.clusterName +
            "'}";
    }
}
