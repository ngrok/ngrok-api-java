package com.ngrok;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.AbstractMap;
import java.util.Map;
import java.util.Optional;

public abstract class TestBase {
    public static final boolean USE_LIVE_API = Optional.ofNullable(System.getenv("TEST_NO_MOCK"))
        .map(Boolean::valueOf)
        .orElse(false);

    public static final ObjectMapper MAPPER = new ObjectMapper()
        .registerModule(new Jdk8Module())
        .registerModule(new JavaTimeModule());

    public static <K, V> Map.Entry<K, V> entry(final K key, final V value) {
        return new AbstractMap.SimpleEntry<>(key, value);
    }

    public static String jsonStrForField(final Map<String, Object> fields, final String key) throws JsonProcessingException {
        return "\"" + key + "\":" + MAPPER.writeValueAsString(fields.get(key));
    }

}
