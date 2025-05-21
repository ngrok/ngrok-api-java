/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link KubernetesOperator} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class KubernetesOperator {
    @JsonProperty("id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String id;
    @JsonProperty("uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.net.URI uri;
    @JsonProperty("created_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime createdAt;
    @JsonProperty("updated_at")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.time.OffsetDateTime updatedAt;
    @JsonProperty("description")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> description;
    @JsonProperty("metadata")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> metadata;
    @JsonProperty("principal")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Ref principal;
    @JsonProperty("enabled_features")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final java.util.List<String> enabledFeatures;
    @JsonProperty("region")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> region;
    @JsonProperty("deployment")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final KubernetesOperatorDeployment deployment;
    @JsonProperty("binding")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<KubernetesOperatorBinding> binding;

    /**
     * Creates a new instance of {@link KubernetesOperator}.
     *
     * @param id unique identifier for this Kubernetes Operator
     * @param uri URI of this Kubernetes Operator API resource
     * @param createdAt timestamp when the Kubernetes Operator was created. RFC 3339 format
     * @param updatedAt timestamp when the Kubernetes Operator was last updated. RFC 3339 format
     * @param description human-readable description of this Kubernetes Operator. optional, max 255 bytes.
     * @param metadata arbitrary user-defined machine-readable data of this Kubernetes Operator. optional, max 4096 bytes.
     * @param principal the principal who created this Kubernetes Operator
     * @param enabledFeatures features enabled for this Kubernetes Operator. a subset of &#34;bindings&#34;, &#34;ingress&#34;, and &#34;gateway&#34;
     * @param region the ngrok region in which the ingress for this operator is served. defaults to &#34;global&#34;
     * @param deployment information about the deployment of this Kubernetes Operator
     * @param binding information about the Bindings feature of this Kubernetes Operator, if enabled
     */
    @JsonCreator
    public KubernetesOperator(
        @JsonProperty("id") final String id,
        @JsonProperty("uri") final java.net.URI uri,
        @JsonProperty("created_at") final java.time.OffsetDateTime createdAt,
        @JsonProperty("updated_at") final java.time.OffsetDateTime updatedAt,
        @JsonProperty("description") final Optional<String> description,
        @JsonProperty("metadata") final Optional<String> metadata,
        @JsonProperty("principal") final Ref principal,
        @JsonProperty("enabled_features") final java.util.List<String> enabledFeatures,
        @JsonProperty("region") final Optional<String> region,
        @JsonProperty("deployment") final KubernetesOperatorDeployment deployment,
        @JsonProperty("binding") final Optional<KubernetesOperatorBinding> binding
    ) {
        this.id = Objects.requireNonNull(id, "id is required");
        this.uri = Objects.requireNonNull(uri, "uri is required");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt is required");
        this.updatedAt = Objects.requireNonNull(updatedAt, "updatedAt is required");
        this.description = description != null ? description : Optional.empty();
        this.metadata = metadata != null ? metadata : Optional.empty();
        this.principal = Objects.requireNonNull(principal, "principal is required");
        this.enabledFeatures = enabledFeatures != null ? enabledFeatures : java.util.Collections.emptyList();
        this.region = region != null ? region : Optional.empty();
        this.deployment = Objects.requireNonNull(deployment, "deployment is required");
        this.binding = binding != null ? binding : Optional.empty();
    }

    /**
     * unique identifier for this Kubernetes Operator
     *
     * @return the value of the property as a {@link String}
     */
    public String getId() {
        return this.id;
    }

    /**
     * URI of this Kubernetes Operator API resource
     *
     * @return the value of the property as a {@link java.net.URI}
     */
    public java.net.URI getUri() {
        return this.uri;
    }

    /**
     * timestamp when the Kubernetes Operator was created. RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * timestamp when the Kubernetes Operator was last updated. RFC 3339 format
     *
     * @return the value of the property as a {@link java.time.OffsetDateTime}
     */
    public java.time.OffsetDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * human-readable description of this Kubernetes Operator. optional, max 255 bytes.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getDescription() {
        return this.description;
    }

    /**
     * arbitrary user-defined machine-readable data of this Kubernetes Operator.
     * optional, max 4096 bytes.
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getMetadata() {
        return this.metadata;
    }

    /**
     * the principal who created this Kubernetes Operator
     *
     * @return the value of the property as a {@link Ref}
     */
    public Ref getPrincipal() {
        return this.principal;
    }

    /**
     * features enabled for this Kubernetes Operator. a subset of &#34;bindings&#34;,
     * &#34;ingress&#34;, and &#34;gateway&#34;
     *
     * @return the value of the property as a {@link java.util.List} of {@link String}
     */
    public java.util.List<String> getEnabledFeatures() {
        return this.enabledFeatures;
    }

    /**
     * the ngrok region in which the ingress for this operator is served. defaults to
     * &#34;global&#34;
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getRegion() {
        return this.region;
    }

    /**
     * information about the deployment of this Kubernetes Operator
     *
     * @return the value of the property as a {@link KubernetesOperatorDeployment}
     */
    public KubernetesOperatorDeployment getDeployment() {
        return this.deployment;
    }

    /**
     * information about the Bindings feature of this Kubernetes Operator, if enabled
     *
     * @return the value of the property as a {@link KubernetesOperatorBinding} wrapped in an {@link Optional}
     */
    public Optional<KubernetesOperatorBinding> getBinding() {
        return this.binding;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final KubernetesOperator other = (KubernetesOperator) o;
        return
            this.id.equals(other.id)&&
            this.uri.equals(other.uri)&&
            this.createdAt.equals(other.createdAt)&&
            this.updatedAt.equals(other.updatedAt)&&
            this.description.equals(other.description)&&
            this.metadata.equals(other.metadata)&&
            this.principal.equals(other.principal)&&
            this.enabledFeatures.equals(other.enabledFeatures)&&
            this.region.equals(other.region)&&
            this.deployment.equals(other.deployment)&&
            this.binding.equals(other.binding);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.id,
            this.uri,
            this.createdAt,
            this.updatedAt,
            this.description,
            this.metadata,
            this.principal,
            this.enabledFeatures,
            this.region,
            this.deployment,
            this.binding
        );
    }

    @Override
    public String toString() {
        return "KubernetesOperator{" +
            "id='" + this.id +
            "', uri='" + this.uri +
            "', createdAt='" + this.createdAt +
            "', updatedAt='" + this.updatedAt +
            "', description='" + this.description.orElse("(null)") +
            "', metadata='" + this.metadata.orElse("(null)") +
            "', principal='" + this.principal +
            "', enabledFeatures='" + this.enabledFeatures +
            "', region='" + this.region.orElse("(null)") +
            "', deployment='" + this.deployment +
            "', binding='" + this.binding.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
