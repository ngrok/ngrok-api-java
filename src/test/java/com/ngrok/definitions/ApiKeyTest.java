package com.ngrok.definitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ngrok.ApiKeyTestBase;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApiKeyTest extends ApiKeyTestBase {
    @Test
    public void testApiKeySerialization() throws JsonProcessingException {
        final String jsonRep = MAPPER.writeValueAsString(API_KEY);
        assertThat(jsonRep).contains(
            jsonStrForField(API_KEY_JSON_FIELDS, "id"),
            jsonStrForField(API_KEY_JSON_FIELDS, "uri"),
            jsonStrForField(API_KEY_JSON_FIELDS, "description"),
            jsonStrForField(API_KEY_JSON_FIELDS, "metadata"),
            jsonStrForField(API_KEY_JSON_FIELDS, "created_at"),
            jsonStrForField(API_KEY_JSON_FIELDS, "token")
        );
    }

    @Test
    public void testApiKeySerializationOptionalField() throws JsonProcessingException {
        final String jsonRep = MAPPER.writeValueAsString(API_KEY_NO_TOKEN);
        assertThat(jsonRep).contains(
            jsonStrForField(API_KEY_JSON_FIELDS, "id"),
            jsonStrForField(API_KEY_JSON_FIELDS, "uri"),
            jsonStrForField(API_KEY_JSON_FIELDS, "description"),
            jsonStrForField(API_KEY_JSON_FIELDS, "metadata"),
            jsonStrForField(API_KEY_JSON_FIELDS, "created_at")
        );
    }

    @Test
    public void testApiKeyDeserialization() throws JsonProcessingException {
        final String jsonStr = "{" +
            String.join(",",
                jsonStrForField(API_KEY_JSON_FIELDS, "id"),
                jsonStrForField(API_KEY_JSON_FIELDS, "uri"),
                jsonStrForField(API_KEY_JSON_FIELDS, "description"),
                jsonStrForField(API_KEY_JSON_FIELDS, "metadata"),
                jsonStrForField(API_KEY_JSON_FIELDS, "created_at"),
                jsonStrForField(API_KEY_JSON_FIELDS, "token")
            ) +
            "}";

        final ApiKey apiKey = MAPPER.readValue(jsonStr, ApiKey.class);
        assertApiKeyFields(apiKey);
    }

    @Test
    public void testApiKeyDeserializationOptionalField() throws JsonProcessingException {
        final String jsonStr = "{" +
            String.join(",",
                jsonStrForField(API_KEY_JSON_FIELDS, "id"),
                jsonStrForField(API_KEY_JSON_FIELDS, "uri"),
                jsonStrForField(API_KEY_JSON_FIELDS, "description"),
                jsonStrForField(API_KEY_JSON_FIELDS, "metadata"),
                jsonStrForField(API_KEY_JSON_FIELDS, "created_at")
            ) +
            "}";

        final ApiKey apiKey = MAPPER.readValue(jsonStr, ApiKey.class);
        assertThat(apiKey.getId()).isEqualTo(API_KEY_JSON_FIELDS.get("id"));
        assertThat(apiKey.getUri()).isEqualTo(API_KEY_JSON_FIELDS.get("uri"));
        assertThat(apiKey.getDescription()).isEqualTo(API_KEY_JSON_FIELDS.get("description"));
        assertThat(apiKey.getMetadata()).isEqualTo(API_KEY_JSON_FIELDS.get("metadata"));
        assertThat(apiKey.getCreatedAt()).isEqualTo(API_KEY_JSON_FIELDS.get("created_at"));
        assertThat(apiKey.getToken()).isEmpty();
    }

    @Test
    public void testApiKeyDeserializationMissingRequiredField() throws JsonProcessingException {
        final String jsonStr = "{" +
            String.join(",",
                jsonStrForField(API_KEY_JSON_FIELDS, "id"),
                jsonStrForField(API_KEY_JSON_FIELDS, "uri"),
                jsonStrForField(API_KEY_JSON_FIELDS, "description"),
                jsonStrForField(API_KEY_JSON_FIELDS, "metadata")
            ) +
            "}";
        assertThrows(JsonProcessingException.class, () ->
            MAPPER.readValue(jsonStr, ApiKey.class)
        );
    }
}
