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
    public static ApiKey API_KEY = new ApiKey(
        "abcdef123456",
        URI.create("https://api.ngrok.com/api_keys/abcdef123456"),
        "this is a great API key",
        "this API key is quite meta",
        OffsetDateTime.parse("2021-06-08T21:09:00-07:00"),
        Optional.of("qwertyuiop")
    );

    public static ApiKey API_KEY_NO_TOKEN = new ApiKey(
        API_KEY.getId(),
        API_KEY.getUri(),
        API_KEY.getDescription(),
        API_KEY.getMetadata(),
        API_KEY.getCreatedAt(),
        Optional.empty()
    );

    public static final Map<String, Object> API_KEY_JSON_FIELDS = Stream.of(
        entry("id", API_KEY.getId()),
        entry("uri", API_KEY.getUri()),
        entry("description", API_KEY.getDescription()),
        entry("metadata", API_KEY.getMetadata()),
        entry("created_at", API_KEY.getCreatedAt()),
        entry("token", API_KEY.getToken().orElseThrow(() -> new AssertionError("Bad data in API_KEY")))
    ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


    public static void assertApiKeyFields(final ApiKey apiKey, final String expectedDescription, boolean shouldHaveToken) {
        assertThat(apiKey).isNotNull();

        if (USE_LIVE_API) {
            assertThat(apiKey.getId()).isNotBlank();
            assertThat(apiKey.getUri().getHost()).isEqualTo(NgrokApiClient.DEFAULT_BASE_URI.getHost());
            assertThat(apiKey.getCreatedAt()).isAfter(OffsetDateTime.now().minus(Duration.ofMinutes(20)));
        } else {
            assertThat(apiKey.getId()).isEqualTo(API_KEY.getId());
            assertThat(apiKey.getUri()).isEqualTo(API_KEY.getUri());
            assertThat(apiKey.getCreatedAt()).isEqualTo(API_KEY.getCreatedAt());
        }

        assertThat(apiKey.getDescription()).isEqualTo(expectedDescription);
        assertThat(apiKey.getMetadata()).isEqualTo(API_KEY.getMetadata());

        if (shouldHaveToken) {
            if (USE_LIVE_API) {
                assertThat(apiKey.getToken()).isNotEmpty();
                assertThat(apiKey.getToken().get()).isNotBlank();
            } else {
                assertThat(apiKey.getToken()).isEqualTo(API_KEY.getToken());
            }
        } else {
            assertThat(apiKey.getToken()).isEmpty();
        }
    }

    public static void assertApiKeyFields(final ApiKey apiKey) {
        assertApiKeyFields(apiKey, API_KEY.getDescription(), true);
    }

    public static void assertApiKeyFieldsNoToken(final ApiKey apiKey) {
        assertApiKeyFields( apiKey, API_KEY.getDescription(), false);
    }
}
