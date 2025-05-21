/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link KubernetesOperatorBindingUpdate} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class KubernetesOperatorBindingUpdate {
    /**
     * Builder class for {@link KubernetesOperatorBindingUpdate}.
     */
    public static class Builder {
        private Optional<java.util.List<String>> endpointSelectors = Optional.empty();
        private Optional<String> csr = Optional.empty();
        private Optional<String> ingressEndpoint = Optional.empty();

        private Builder(
        ) {
        }

        /**
         * the list of cel expressions that filter the k8s bound endpoints for this
         * operator
         *
         * @param endpointSelectors the value of the <code>endpoint_selectors</code> parameter as a {@link java.util.List} of {@link String}
         * @return this builder instance
         */
        public Builder endpointSelectors(final java.util.List<String> endpointSelectors) {
            this.endpointSelectors = Optional.of(Objects.requireNonNull(endpointSelectors, "endpointSelectors is required"));
            return this;
        }

        /**
         * the list of cel expressions that filter the k8s bound endpoints for this
         * operator
         *
         * @param endpointSelectors the value of the <code>endpoint_selectors</code> parameter as a {@link java.util.List} of {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder endpointSelectors(final Optional<java.util.List<String>> endpointSelectors) {
            this.endpointSelectors = Objects.requireNonNull(endpointSelectors, "endpointSelectors is required");
            return this;
        }

        /**
         * CSR is supplied during initial creation to enable creating a mutual TLS secured
         * connection between ngrok and the operator. This is an internal implementation
         * detail and subject to change.
         *
         * @param csr the value of the <code>csr</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder csr(final String csr) {
            this.csr = Optional.of(Objects.requireNonNull(csr, "csr is required"));
            return this;
        }

        /**
         * CSR is supplied during initial creation to enable creating a mutual TLS secured
         * connection between ngrok and the operator. This is an internal implementation
         * detail and subject to change.
         *
         * @param csr the value of the <code>csr</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder csr(final Optional<String> csr) {
            this.csr = Objects.requireNonNull(csr, "csr is required");
            return this;
        }

        /**
         * the public ingress endpoint for this Kubernetes Operator
         *
         * @param ingressEndpoint the value of the <code>ingress_endpoint</code> parameter as a {@link String}
         * @return this builder instance
         */
        public Builder ingressEndpoint(final String ingressEndpoint) {
            this.ingressEndpoint = Optional.of(Objects.requireNonNull(ingressEndpoint, "ingressEndpoint is required"));
            return this;
        }

        /**
         * the public ingress endpoint for this Kubernetes Operator
         *
         * @param ingressEndpoint the value of the <code>ingress_endpoint</code> parameter as a {@link String}, wrapped in an {@link Optional}
         * @return this builder instance
         */
        public Builder ingressEndpoint(final Optional<String> ingressEndpoint) {
            this.ingressEndpoint = Objects.requireNonNull(ingressEndpoint, "ingressEndpoint is required");
            return this;
        }

        /**
         * Constructs the {@link KubernetesOperatorBindingUpdate} instance.
         *
         * @return a new {@link KubernetesOperatorBindingUpdate}
         */
        public KubernetesOperatorBindingUpdate build() {
            return new KubernetesOperatorBindingUpdate(
                this.endpointSelectors,
                this.csr,
                this.ingressEndpoint
            );
        }
    }

    /**
     * Creates a new builder for the {@link KubernetesOperatorBindingUpdate} type.
     *
     * @return a new {@link Builder}
     */
    public static Builder newBuilder(
    ) {
        return new Builder (
        );
    }

    @JsonProperty("endpoint_selectors")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<java.util.List<String>> endpointSelectors;
    @JsonProperty("csr")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> csr;
    @JsonProperty("ingress_endpoint")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> ingressEndpoint;

    /**
     * Creates a new instance of {@link KubernetesOperatorBindingUpdate}.
     *
     * @param endpointSelectors the list of cel expressions that filter the k8s bound endpoints for this operator
     * @param csr CSR is supplied during initial creation to enable creating a mutual TLS secured connection between ngrok and the operator. This is an internal implementation detail and subject to change.
     * @param ingressEndpoint the public ingress endpoint for this Kubernetes Operator
     */
    @JsonCreator
    private KubernetesOperatorBindingUpdate(
        @JsonProperty("endpoint_selectors") final Optional<java.util.List<String>> endpointSelectors,
        @JsonProperty("csr") final Optional<String> csr,
        @JsonProperty("ingress_endpoint") final Optional<String> ingressEndpoint
    ) {
        this.endpointSelectors = endpointSelectors != null ? endpointSelectors : Optional.empty();
        this.csr = csr != null ? csr : Optional.empty();
        this.ingressEndpoint = ingressEndpoint != null ? ingressEndpoint : Optional.empty();
    }

    /**
     * the list of cel expressions that filter the k8s bound endpoints for this
     * operator
     *
     * @return the value of the property as a {@link java.util.List} of {@link String} wrapped in an {@link Optional}
     */
    public Optional<java.util.List<String>> getEndpointSelectors() {
        return this.endpointSelectors;
    }

    /**
     * CSR is supplied during initial creation to enable creating a mutual TLS secured
     * connection between ngrok and the operator. This is an internal implementation
     * detail and subject to change.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getCsr() {
        return this.csr;
    }

    /**
     * the public ingress endpoint for this Kubernetes Operator
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getIngressEndpoint() {
        return this.ingressEndpoint;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final KubernetesOperatorBindingUpdate other = (KubernetesOperatorBindingUpdate) o;
        return
            this.endpointSelectors.equals(other.endpointSelectors)&&
            this.csr.equals(other.csr)&&
            this.ingressEndpoint.equals(other.ingressEndpoint);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.endpointSelectors,
            this.csr,
            this.ingressEndpoint
        );
    }

    @Override
    public String toString() {
        return "KubernetesOperatorBindingUpdate{" +
            "endpointSelectors='" + this.endpointSelectors.map(Object::toString).orElse("(null)") +
            "', csr='" + this.csr.orElse("(null)") +
            "', ingressEndpoint='" + this.ingressEndpoint.orElse("(null)") +
            "'}";
    }
}
