/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.services;

import com.ngrok.NgrokApiClient;
import com.ngrok.definitions.*;

import java.util.AbstractMap;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * KubernetesOperators is used by the Kubernetes Operator to register and
 *  manage its own resource, as well as for users to see active kubernetes
 *  clusters.
 *
 * See also <a href="https://ngrok.com/docs/api#api-kubernetes-operators">https://ngrok.com/docs/api#api-kubernetes-operators</a>.
 */
public class KubernetesOperators {
    private final NgrokApiClient apiClient;

    /**
     * Creates a new sub-client for KubernetesOperators.
     *
     * @param apiClient an instance of {@link com.ngrok.NgrokApiClient}
     */
    public KubernetesOperators(final NgrokApiClient apiClient) {
        this.apiClient = Objects.requireNonNull(apiClient, "apiClient is required");
    }
    
    /**
     * A builder object encapsulating state for an unsent Create API call.
     */
    public class CreateCallBuilder {
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private java.util.List<String> enabledFeatures = java.util.Collections.emptyList();
        private Optional<String> region = Optional.empty();
        private Optional<KubernetesOperatorDeployment> deployment = Optional.empty();
        private Optional<KubernetesOperatorBindingCreate> binding = Optional.empty();

        private CreateCallBuilder(
        ) {
        }
        
        /**
         * human-readable description of this Kubernetes Operator. optional, max 255 bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final String description) {
            this.description = Optional.of(Objects.requireNonNull(description, "description is required"));
            return this;
        }

        /**
         * human-readable description of this Kubernetes Operator. optional, max 255 bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this Kubernetes Operator.
         * optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.of(Objects.requireNonNull(metadata, "metadata is required"));
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this Kubernetes Operator.
         * optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * features enabled for this Kubernetes Operator. a subset of &#34;bindings&#34;,
         * &#34;ingress&#34;, and &#34;gateway&#34;
         *
         * @param enabledFeatures the value of the enabled_features parameter as a {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder enabledFeatures(final java.util.List<String> enabledFeatures) {
            this.enabledFeatures = Objects.requireNonNull(enabledFeatures, "enabledFeatures is required");
            return this;
        }

        /**
         * features enabled for this Kubernetes Operator. a subset of &#34;bindings&#34;,
         * &#34;ingress&#34;, and &#34;gateway&#34;
         *
         * @param enabledFeatures the value of the enabled_features parameter as an {@link Optional} of {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder enabledFeatures(final Optional<java.util.List<String>> enabledFeatures) {
            this.enabledFeatures = Objects.requireNonNull(enabledFeatures, "enabledFeatures is required").orElse(java.util.Collections.emptyList());
            return this;
        }
        
        /**
         * the ngrok region in which the ingress for this operator is served. defaults to
         * &#34;global&#34;
         *
         * @param region the value of the region parameter as a {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder region(final String region) {
            this.region = Optional.of(Objects.requireNonNull(region, "region is required"));
            return this;
        }

        /**
         * the ngrok region in which the ingress for this operator is served. defaults to
         * &#34;global&#34;
         *
         * @param region the value of the region parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public CreateCallBuilder region(final Optional<String> region) {
            this.region = Objects.requireNonNull(region, "region is required");
            return this;
        }
        
        /**
         * information about the deployment of this Kubernetes Operator
         *
         * @param deployment the value of the deployment parameter as a {@link KubernetesOperatorDeployment}
         * @return the call builder instance
         */
        public CreateCallBuilder deployment(final KubernetesOperatorDeployment deployment) {
            this.deployment = Optional.of(Objects.requireNonNull(deployment, "deployment is required"));
            return this;
        }

        /**
         * information about the deployment of this Kubernetes Operator
         *
         * @param deployment the value of the deployment parameter as an {@link Optional} of {@link KubernetesOperatorDeployment}
         * @return the call builder instance
         */
        public CreateCallBuilder deployment(final Optional<KubernetesOperatorDeployment> deployment) {
            this.deployment = Objects.requireNonNull(deployment, "deployment is required");
            return this;
        }
        
        /**
         * configuration for the Bindings feature of this Kubernetes Operator. set only if
         * enabling the &#34;bindings&#34; feature
         *
         * @param binding the value of the binding parameter as a {@link KubernetesOperatorBindingCreate}
         * @return the call builder instance
         */
        public CreateCallBuilder binding(final KubernetesOperatorBindingCreate binding) {
            this.binding = Optional.of(Objects.requireNonNull(binding, "binding is required"));
            return this;
        }

        /**
         * configuration for the Bindings feature of this Kubernetes Operator. set only if
         * enabling the &#34;bindings&#34; feature
         *
         * @param binding the value of the binding parameter as an {@link Optional} of {@link KubernetesOperatorBindingCreate}
         * @return the call builder instance
         */
        public CreateCallBuilder binding(final Optional<KubernetesOperatorBindingCreate> binding) {
            this.binding = Objects.requireNonNull(binding, "binding is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link KubernetesOperator}
         */
        public CompletionStage<KubernetesOperator> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.POST,
                "/kubernetes_operators",
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("enabled_features", Optional.of(this.enabledFeatures).filter(enabledFeatures -> !enabledFeatures.isEmpty()).map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("region", this.region.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("deployment", this.deployment.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("binding", this.binding.map(Function.identity()))
                ),
                Optional.of(KubernetesOperator.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link KubernetesOperator}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public KubernetesOperator blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Create a new Kubernetes Operator
     *
     * See also <a href="https://ngrok.com/docs/api#api-kubernetes-operators-create">https://ngrok.com/docs/api#api-kubernetes-operators-create</a>.
     *
     * @return a call builder for this API call
     */
    public CreateCallBuilder create(
    ) {
        return new CreateCallBuilder(
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Update API call.
     */
    public class UpdateCallBuilder {
        private final String id;
        private Optional<String> description = Optional.empty();
        private Optional<String> metadata = Optional.empty();
        private Optional<java.util.List<String>> enabledFeatures = Optional.empty();
        private Optional<String> region = Optional.empty();
        private Optional<KubernetesOperatorBindingUpdate> binding = Optional.empty();
        private Optional<KubernetesOperatorDeploymentUpdate> deployment = Optional.empty();

        private UpdateCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * human-readable description of this Kubernetes Operator. optional, max 255 bytes.
         *
         * @param description the value of the description parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final String description) {
            this.description = Optional.of(Objects.requireNonNull(description, "description is required"));
            return this;
        }

        /**
         * human-readable description of this Kubernetes Operator. optional, max 255 bytes.
         *
         * @param description the value of the description parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder description(final Optional<String> description) {
            this.description = Objects.requireNonNull(description, "description is required");
            return this;
        }
        
        /**
         * arbitrary user-defined machine-readable data of this Kubernetes Operator.
         * optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final String metadata) {
            this.metadata = Optional.of(Objects.requireNonNull(metadata, "metadata is required"));
            return this;
        }

        /**
         * arbitrary user-defined machine-readable data of this Kubernetes Operator.
         * optional, max 4096 bytes.
         *
         * @param metadata the value of the metadata parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder metadata(final Optional<String> metadata) {
            this.metadata = Objects.requireNonNull(metadata, "metadata is required");
            return this;
        }
        
        /**
         * features enabled for this Kubernetes Operator. a subset of &#34;bindings&#34;,
         * &#34;ingress&#34;, and &#34;gateway&#34;
         *
         * @param enabledFeatures the value of the enabled_features parameter as a {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder enabledFeatures(final java.util.List<String> enabledFeatures) {
            this.enabledFeatures = Optional.of(Objects.requireNonNull(enabledFeatures, "enabledFeatures is required"));
            return this;
        }

        /**
         * features enabled for this Kubernetes Operator. a subset of &#34;bindings&#34;,
         * &#34;ingress&#34;, and &#34;gateway&#34;
         *
         * @param enabledFeatures the value of the enabled_features parameter as an {@link Optional} of {@link java.util.List} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder enabledFeatures(final Optional<java.util.List<String>> enabledFeatures) {
            this.enabledFeatures = Objects.requireNonNull(enabledFeatures, "enabledFeatures is required");
            return this;
        }
        
        /**
         * the ngrok region in which the ingress for this operator is served. defaults to
         * &#34;global&#34;
         *
         * @param region the value of the region parameter as a {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder region(final String region) {
            this.region = Optional.of(Objects.requireNonNull(region, "region is required"));
            return this;
        }

        /**
         * the ngrok region in which the ingress for this operator is served. defaults to
         * &#34;global&#34;
         *
         * @param region the value of the region parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public UpdateCallBuilder region(final Optional<String> region) {
            this.region = Objects.requireNonNull(region, "region is required");
            return this;
        }
        
        /**
         * configuration for the Bindings feature of this Kubernetes Operator. set only if
         * enabling the &#34;bindings&#34; feature
         *
         * @param binding the value of the binding parameter as a {@link KubernetesOperatorBindingUpdate}
         * @return the call builder instance
         */
        public UpdateCallBuilder binding(final KubernetesOperatorBindingUpdate binding) {
            this.binding = Optional.of(Objects.requireNonNull(binding, "binding is required"));
            return this;
        }

        /**
         * configuration for the Bindings feature of this Kubernetes Operator. set only if
         * enabling the &#34;bindings&#34; feature
         *
         * @param binding the value of the binding parameter as an {@link Optional} of {@link KubernetesOperatorBindingUpdate}
         * @return the call builder instance
         */
        public UpdateCallBuilder binding(final Optional<KubernetesOperatorBindingUpdate> binding) {
            this.binding = Objects.requireNonNull(binding, "binding is required");
            return this;
        }
        
        /**
         * configuration for the Deployment info
         *
         * @param deployment the value of the deployment parameter as a {@link KubernetesOperatorDeploymentUpdate}
         * @return the call builder instance
         */
        public UpdateCallBuilder deployment(final KubernetesOperatorDeploymentUpdate deployment) {
            this.deployment = Optional.of(Objects.requireNonNull(deployment, "deployment is required"));
            return this;
        }

        /**
         * configuration for the Deployment info
         *
         * @param deployment the value of the deployment parameter as an {@link Optional} of {@link KubernetesOperatorDeploymentUpdate}
         * @return the call builder instance
         */
        public UpdateCallBuilder deployment(final Optional<KubernetesOperatorDeploymentUpdate> deployment) {
            this.deployment = Objects.requireNonNull(deployment, "deployment is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link KubernetesOperator}
         */
        public CompletionStage<KubernetesOperator> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.PATCH,
                "/kubernetes_operators/" + this.id,
                Stream.empty(),
                Stream.of(
                    new AbstractMap.SimpleEntry<>("description", this.description.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("metadata", this.metadata.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("enabled_features", Optional.of(this.enabledFeatures).filter(enabledFeatures -> !enabledFeatures.isEmpty()).map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("region", this.region.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("binding", this.binding.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("deployment", this.deployment.map(Function.identity()))
                ),
                Optional.of(KubernetesOperator.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link KubernetesOperator}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public KubernetesOperator blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Update an existing Kubernetes operator by ID.
     *
     * See also <a href="https://ngrok.com/docs/api#api-kubernetes-operators-update">https://ngrok.com/docs/api#api-kubernetes-operators-update</a>.
     *
     * @param id unique identifier for this Kubernetes Operator
     * @return a call builder for this API call
     */
    public UpdateCallBuilder update(
        final String id
    ) {
        return new UpdateCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Delete API call.
     */
    public class DeleteCallBuilder {
        private final String id;

        private DeleteCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link Void}
         */
        public CompletionStage<Void> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.DELETE,
                "/kubernetes_operators/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.empty()
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public void blockingCall() throws InterruptedException {
            try {
                call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Delete a Kubernetes Operator
     *
     * See also <a href="https://ngrok.com/docs/api#api-kubernetes-operators-delete">https://ngrok.com/docs/api#api-kubernetes-operators-delete</a>.
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public DeleteCallBuilder delete(
        final String id
    ) {
        return new DeleteCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent Get API call.
     */
    public class GetCallBuilder {
        private final String id;

        private GetCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of {@link KubernetesOperator}
         */
        public CompletionStage<KubernetesOperator> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/kubernetes_operators/" + this.id,
                Stream.empty(),
                Stream.empty(),
                Optional.of(KubernetesOperator.class)
            );
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return {@link KubernetesOperator}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public KubernetesOperator blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * Get of a Kubernetes Operator
     *
     * See also <a href="https://ngrok.com/docs/api#api-kubernetes-operators-get">https://ngrok.com/docs/api#api-kubernetes-operators-get</a>.
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public GetCallBuilder get(
        final String id
    ) {
        return new GetCallBuilder(
            id
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent List API call.
     */
    public class ListCallBuilder {
        private Optional<String> beforeId = Optional.empty();
        private Optional<String> limit = Optional.empty();

        private ListCallBuilder(
        ) {
        }
        
        /**
         * Sets the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as a {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder beforeId(final String beforeId) {
            this.beforeId = Optional.of(Objects.requireNonNull(beforeId, "beforeId is required"));
            return this;
        }

        /**
         * Sets (or unsets) the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder beforeId(final Optional<String> beforeId) {
            this.beforeId = Objects.requireNonNull(beforeId, "beforeId is required");
            return this;
        }
        
        /**
         * Sets the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as a {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder limit(final String limit) {
            this.limit = Optional.of(Objects.requireNonNull(limit, "limit is required"));
            return this;
        }

        /**
         * Sets (or unsets) the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public ListCallBuilder limit(final Optional<String> limit) {
            this.limit = Objects.requireNonNull(limit, "limit is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of a {@link Page} of {@link KubernetesOperatorList}
         */
        public CompletionStage<Page<KubernetesOperatorList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/kubernetes_operators",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(KubernetesOperatorList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link KubernetesOperatorList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<KubernetesOperatorList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List all Kubernetes Operators owned by this account
     *
     * See also <a href="https://ngrok.com/docs/api#api-kubernetes-operators-list">https://ngrok.com/docs/api#api-kubernetes-operators-list</a>.
     *
     * @return a call builder for this API call
     */
    public ListCallBuilder list(
    ) {
        return new ListCallBuilder(
        );
    }
    
    /**
     * A builder object encapsulating state for an unsent GetBoundEndpoints API call.
     */
    public class GetBoundEndpointsCallBuilder {
        private final String id;
        private Optional<String> beforeId = Optional.empty();
        private Optional<String> limit = Optional.empty();

        private GetBoundEndpointsCallBuilder(
            final String id
        ) {
            this.id = Objects.requireNonNull(id, "id is required");
        }
        
        /**
         * Sets the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as a {@link String}
         * @return the call builder instance
         */
        public GetBoundEndpointsCallBuilder beforeId(final String beforeId) {
            this.beforeId = Optional.of(Objects.requireNonNull(beforeId, "beforeId is required"));
            return this;
        }

        /**
         * Sets (or unsets) the <code>before_id</code> parameter.
         *
         * @param beforeId the value of the before_id parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public GetBoundEndpointsCallBuilder beforeId(final Optional<String> beforeId) {
            this.beforeId = Objects.requireNonNull(beforeId, "beforeId is required");
            return this;
        }
        
        /**
         * Sets the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as a {@link String}
         * @return the call builder instance
         */
        public GetBoundEndpointsCallBuilder limit(final String limit) {
            this.limit = Optional.of(Objects.requireNonNull(limit, "limit is required"));
            return this;
        }

        /**
         * Sets (or unsets) the <code>limit</code> parameter.
         *
         * @param limit the value of the limit parameter as an {@link Optional} of {@link String}
         * @return the call builder instance
         */
        public GetBoundEndpointsCallBuilder limit(final Optional<String> limit) {
            this.limit = Objects.requireNonNull(limit, "limit is required");
            return this;
        }
        
        /**
         * Initiates the API call asynchronously.
         *
         * @return a {@link CompletionStage} of a {@link Page} of {@link EndpointList}
         */
        public CompletionStage<Page<EndpointList>> call() {
            return apiClient.sendRequest(
                NgrokApiClient.HttpMethod.GET,
                "/kubernetes_operators/" + this.id + "/bound_endpoints",
                Stream.of(
                    new AbstractMap.SimpleEntry<>("before_id", this.beforeId.map(Function.identity())),
                    new AbstractMap.SimpleEntry<>("limit", this.limit.map(Function.identity()))
                ),
                Stream.empty(),
                Optional.of(EndpointList.class)
            ).thenApply(list -> new Page<>(apiClient, list));
        }

        /**
         * Initiates the API call and blocks until it returns.
         *
         * @return a {@link Page} of {@link EndpointList}
         * @throws InterruptedException if the thread was interrupted during the call
         */
        public Page<EndpointList> blockingCall() throws InterruptedException {
            try {
                return call().toCompletableFuture().get();
            } catch (final ExecutionException e) {
                throw e.getCause() instanceof RuntimeException ? (RuntimeException) e.getCause() : new RuntimeException(e.getCause().getMessage(), e.getCause());
            }
        }
    }

    /**
     * List Endpoints bound to a Kubernetes Operator
     *
     * See also <a href="https://ngrok.com/docs/api#api-kubernetes-operators-get-bound-endpoints">https://ngrok.com/docs/api#api-kubernetes-operators-get-bound-endpoints</a>.
     *
     * @param id a resource identifier
     * @return a call builder for this API call
     */
    public GetBoundEndpointsCallBuilder getBoundEndpoints(
        final String id
    ) {
        return new GetBoundEndpointsCallBuilder(
            id
        );
    }
}
