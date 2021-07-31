package com.ngrok;

import com.ngrok.definitions.ApiKey;

import java.net.URI;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class ApiKeyTestBase extends TestBase {
    public static final Map<String, Object> API_KEY_JSON_FIELDS = Stream.of(
        entry("id", "abcdef123456"),
        entry("uri", URI.create("https://api.ngrok.com/api_keys/abcdef123456")),
        entry("description", "this is a great API key"),
        entry("metadata", "this API key is quite meta"),
        entry("created_at", OffsetDateTime.parse("2021-06-08T21:09:00-07:00")),
        entry("token", "qwertyuiop")
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    public static ApiKey API_KEY_NO_TOKEN = new ApiKey(
        (String) API_KEY_JSON_FIELDS.get("id"),
        (URI) API_KEY_JSON_FIELDS.get("uri"),
        (String) API_KEY_JSON_FIELDS.get("description"),
        (String) API_KEY_JSON_FIELDS.get("metadata"),
        (OffsetDateTime) API_KEY_JSON_FIELDS.get("created_at"),
        Optional.empty()
    );
    public static ApiKey API_KEY = new ApiKey(
        (String) API_KEY_JSON_FIELDS.get("id"),
        (URI) API_KEY_JSON_FIELDS.get("uri"),
        (String) API_KEY_JSON_FIELDS.get("description"),
        (String) API_KEY_JSON_FIELDS.get("metadata"),
        (OffsetDateTime) API_KEY_JSON_FIELDS.get("created_at"),
        Optional.of((String) API_KEY_JSON_FIELDS.get("token"))
    );

    public static void assertApiKeyFields(final boolean useLiveApi, final ApiKey apiKey, final String expectedDescription, boolean shouldHaveToken) {
        assertThat(apiKey).isNotNull();

        if (useLiveApi) {
            assertThat(apiKey.getId()).isNotBlank();
            assertThat(apiKey.getUri().getHost()).isEqualTo(NgrokApiClient.DEFAULT_BASE_URI.getHost());
            assertThat(apiKey.getCreatedAt()).isAfter(OffsetDateTime.now().minus(Duration.ofMinutes(20)));
        } else {
            assertThat(apiKey.getId()).isEqualTo(API_KEY_JSON_FIELDS.get("id"));
            assertThat(apiKey.getUri()).isEqualTo(API_KEY_JSON_FIELDS.get("uri"));
            assertThat(apiKey.getCreatedAt()).isEqualTo(API_KEY_JSON_FIELDS.get("created_at"));
        }

        assertThat(apiKey.getDescription()).isEqualTo(expectedDescription);
        assertThat(apiKey.getMetadata()).isEqualTo(API_KEY_JSON_FIELDS.get("metadata"));

        if (shouldHaveToken) {
            if (useLiveApi) {
                assertThat(apiKey.getToken()).isNotEmpty();
                assertThat(apiKey.getToken().get()).isNotBlank();
            } else {
                assertThat(apiKey.getToken()).contains((String) API_KEY_JSON_FIELDS.get("token"));
            }
        } else {
            assertThat(apiKey.getToken()).isEmpty();
        }
    }

    public static void assertApiKeyFields(final boolean useLiveApi, final ApiKey apiKey) {
        assertApiKeyFields(useLiveApi, apiKey, (String) API_KEY_JSON_FIELDS.get("description"), true);
    }

    public static void assertApiKeyFieldsNoToken(final boolean useLiveApi, final ApiKey apiKey) {
        assertApiKeyFields(useLiveApi, apiKey, (String) API_KEY_JSON_FIELDS.get("description"), false);
    }
}
