/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link EventTargetAzureLogsIngestion} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventTargetAzureLogsIngestion {
    /**
     * Builder class for {@link EventTargetAzureLogsIngestion}.
     */
    public static class Builder {
        private final String tenantId;
        private final String clientId;
        private final String clientSecret;
        private final String logsIngestionUri;
        private final String dataCollectionRuleId;
        private final String dataCollectionStreamName;

        private Builder(
            final String tenantId,
            final String clientId,
            final String clientSecret,
            final String logsIngestionUri,
            final String dataCollectionRuleId,
            final String dataCollectionStreamName
        ) {
            this.tenantId = Objects.requireNonNull(tenantId, "tenantId is required");
            this.clientId = Objects.requireNonNull(clientId, "clientId is required");
            this.clientSecret = Objects.requireNonNull(clientSecret, "clientSecret is required");
            this.logsIngestionUri = Objects.requireNonNull(logsIngestionUri, "logsIngestionUri is required");
            this.dataCollectionRuleId = Objects.requireNonNull(dataCollectionRuleId, "dataCollectionRuleId is required");
            this.dataCollectionStreamName = Objects.requireNonNull(dataCollectionStreamName, "dataCollectionStreamName is required");
        }

        /**
         * Constructs the {@link EventTargetAzureLogsIngestion} instance.
         *
         * @return a new {@link EventTargetAzureLogsIngestion}
         */
        public EventTargetAzureLogsIngestion build() {
            return new EventTargetAzureLogsIngestion(
                this.tenantId,
                this.clientId,
                this.clientSecret,
                this.logsIngestionUri,
                this.dataCollectionRuleId,
                this.dataCollectionStreamName
            );
        }
    }

    /**
     * Creates a new builder for the {@link EventTargetAzureLogsIngestion} type.
     *
     * @param tenantId Tenant ID for the Azure account
     * @param clientId Client ID for the application client
     * @param clientSecret Client Secret for the application client
     * @param logsIngestionUri Data collection endpoint logs ingestion URI
     * @param dataCollectionRuleId Data collection rule immutable ID
     * @param dataCollectionStreamName Data collection stream name to use as destination, located inside the DCR
     * @return a new {@link Builder}
     */
    public static Builder newBuilder(
        final String tenantId,
        final String clientId,
        final String clientSecret,
        final String logsIngestionUri,
        final String dataCollectionRuleId,
        final String dataCollectionStreamName
    ) {
        return new Builder (
            tenantId,
            clientId,
            clientSecret,
            logsIngestionUri,
            dataCollectionRuleId,
            dataCollectionStreamName
        );
    }

    @JsonProperty("tenant_id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String tenantId;
    @JsonProperty("client_id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String clientId;
    @JsonProperty("client_secret")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String clientSecret;
    @JsonProperty("logs_ingestion_uri")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String logsIngestionUri;
    @JsonProperty("data_collection_rule_id")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String dataCollectionRuleId;
    @JsonProperty("data_collection_stream_name")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String dataCollectionStreamName;

    /**
     * Creates a new instance of {@link EventTargetAzureLogsIngestion}.
     *
     * @param tenantId Tenant ID for the Azure account
     * @param clientId Client ID for the application client
     * @param clientSecret Client Secret for the application client
     * @param logsIngestionUri Data collection endpoint logs ingestion URI
     * @param dataCollectionRuleId Data collection rule immutable ID
     * @param dataCollectionStreamName Data collection stream name to use as destination, located inside the DCR
     */
    @JsonCreator
    private EventTargetAzureLogsIngestion(
        @JsonProperty("tenant_id") final String tenantId,
        @JsonProperty("client_id") final String clientId,
        @JsonProperty("client_secret") final String clientSecret,
        @JsonProperty("logs_ingestion_uri") final String logsIngestionUri,
        @JsonProperty("data_collection_rule_id") final String dataCollectionRuleId,
        @JsonProperty("data_collection_stream_name") final String dataCollectionStreamName
    ) {
        this.tenantId = Objects.requireNonNull(tenantId, "tenantId is required");
        this.clientId = Objects.requireNonNull(clientId, "clientId is required");
        this.clientSecret = Objects.requireNonNull(clientSecret, "clientSecret is required");
        this.logsIngestionUri = Objects.requireNonNull(logsIngestionUri, "logsIngestionUri is required");
        this.dataCollectionRuleId = Objects.requireNonNull(dataCollectionRuleId, "dataCollectionRuleId is required");
        this.dataCollectionStreamName = Objects.requireNonNull(dataCollectionStreamName, "dataCollectionStreamName is required");
    }

    /**
     * Tenant ID for the Azure account
     *
     * @return the value of the property as a {@link String}
     */
    public String getTenantId() {
        return this.tenantId;
    }

    /**
     * Client ID for the application client
     *
     * @return the value of the property as a {@link String}
     */
    public String getClientId() {
        return this.clientId;
    }

    /**
     * Client Secret for the application client
     *
     * @return the value of the property as a {@link String}
     */
    public String getClientSecret() {
        return this.clientSecret;
    }

    /**
     * Data collection endpoint logs ingestion URI
     *
     * @return the value of the property as a {@link String}
     */
    public String getLogsIngestionUri() {
        return this.logsIngestionUri;
    }

    /**
     * Data collection rule immutable ID
     *
     * @return the value of the property as a {@link String}
     */
    public String getDataCollectionRuleId() {
        return this.dataCollectionRuleId;
    }

    /**
     * Data collection stream name to use as destination, located inside the DCR
     *
     * @return the value of the property as a {@link String}
     */
    public String getDataCollectionStreamName() {
        return this.dataCollectionStreamName;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final EventTargetAzureLogsIngestion other = (EventTargetAzureLogsIngestion) o;
        return
            this.tenantId.equals(other.tenantId)&&
            this.clientId.equals(other.clientId)&&
            this.clientSecret.equals(other.clientSecret)&&
            this.logsIngestionUri.equals(other.logsIngestionUri)&&
            this.dataCollectionRuleId.equals(other.dataCollectionRuleId)&&
            this.dataCollectionStreamName.equals(other.dataCollectionStreamName);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.tenantId,
            this.clientId,
            this.clientSecret,
            this.logsIngestionUri,
            this.dataCollectionRuleId,
            this.dataCollectionStreamName
        );
    }

    @Override
    public String toString() {
        return "EventTargetAzureLogsIngestion{" +
            "tenantId='" + this.tenantId +
            "', clientId='" + this.clientId +
            "', clientSecret='" + this.clientSecret +
            "', logsIngestionUri='" + this.logsIngestionUri +
            "', dataCollectionRuleId='" + this.dataCollectionRuleId +
            "', dataCollectionStreamName='" + this.dataCollectionStreamName +
            "'}";
    }
}
