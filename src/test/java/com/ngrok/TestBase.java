/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.net.URI;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Optional;

public abstract class TestBase {
    public static final String FAKE_API_SECRET ="s3kr1t";

    public static final String USER_AGENT = "ngrok-api-java/" + Version.CLIENT_VERSION + "/" + System.getProperty("java.version");

    public static final boolean USE_LIVE_API = Optional.ofNullable(System.getenv("TEST_NO_MOCK"))
        .map(Boolean::valueOf)
        .orElse(false);

    public static final ObjectMapper MAPPER = new ObjectMapper()
        .registerModule(new Jdk8Module())
        .registerModule(new JavaTimeModule());

    public static Ngrok ngrok(final URI mockBaseUri) {
        final NgrokApiClient apiClient = DefaultNgrokApiClient
            .newBuilder(USE_LIVE_API ? System.getenv("NGROK_API_KEY") : FAKE_API_SECRET)
            .baseUri(USE_LIVE_API ? NgrokApiClient.DEFAULT_BASE_URI : mockBaseUri)
            .build();
        return new Ngrok(apiClient);
    }

    public static <K, V> Map.Entry<K, V> entry(final K key, final V value) {
        return new AbstractMap.SimpleEntry<>(key, value);
    }

    public static String jsonStrForField(final Map<String, Object> fields, final String key) throws JsonProcessingException {
        return "\"" + key + "\":" + MAPPER.writeValueAsString(fields.get(key));
    }
}
