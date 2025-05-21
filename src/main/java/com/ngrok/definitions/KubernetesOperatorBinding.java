/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link KubernetesOperatorBinding} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class KubernetesOperatorBinding {
    @JsonProperty("endpoint_selectors")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> endpointSelectors;
    @JsonProperty("cert")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final KubernetesOperatorCert cert;
    @JsonProperty("ingress_endpoint")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> ingressEndpoint;

    /**
     * Creates a new instance of {@link KubernetesOperatorBinding}.
     *
     * @param endpointSelectors the list of cel expressions that filter the k8s bound endpoints for this operator
     * @param cert the binding certificate information
     * @param ingressEndpoint the public ingress endpoint for this Kubernetes Operator
     */
    @JsonCreator
    public KubernetesOperatorBinding(
        @JsonProperty("endpoint_selectors") final java.util.List<String> endpointSelectors,
        @JsonProperty("cert") final KubernetesOperatorCert cert,
        @JsonProperty("ingress_endpoint") final Optional<String> ingressEndpoint
    ) {
        this.endpointSelectors = endpointSelectors != null ? endpointSelectors : java.util.Collections.emptyList();
        this.cert = Objects.requireNonNull(cert, "cert is required");
        this.ingressEndpoint = ingressEndpoint != null ? ingressEndpoint : Optional.empty();
    }

    /**
     * the list of cel expressions that filter the k8s bound endpoints for this
     * operator
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getEndpointSelectors() {
        return this.endpointSelectors;
    }

    /**
     * the binding certificate information
     *
     * @return the value of the property as a {@link KubernetesOperatorCert}
     */
    public KubernetesOperatorCert getCert() {
        return this.cert;
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
        
        final KubernetesOperatorBinding other = (KubernetesOperatorBinding) o;
        return
            this.endpointSelectors.equals(other.endpointSelectors)&&
            this.cert.equals(other.cert)&&
            this.ingressEndpoint.equals(other.ingressEndpoint);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.endpointSelectors,
            this.cert,
            this.ingressEndpoint
        );
    }

    @Override
    public String toString() {
        return "KubernetesOperatorBinding{" +
            "endpointSelectors='" + this.endpointSelectors +
            "', cert='" + this.cert +
            "', ingressEndpoint='" + this.ingressEndpoint.orElse("(null)") +
            "'}";
    }
}
