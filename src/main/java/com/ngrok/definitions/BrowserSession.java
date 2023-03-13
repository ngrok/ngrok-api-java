package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link BrowserSession} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BrowserSession {
    @JsonProperty("user_agent")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final UserAgent userAgent;
    @JsonProperty("ip_address")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String ipAddress;
    @JsonProperty("location")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Location> location;

    /**
     * Creates a new instance of {@link BrowserSession}.
     *
     * @param userAgent HTTP User-Agent data
     * @param ipAddress IP address
     * @param location IP geolocation data
     */
    @JsonCreator
    public BrowserSession(
        @JsonProperty("user_agent") final UserAgent userAgent,
        @JsonProperty("ip_address") final String ipAddress,
        @JsonProperty("location") final Optional<Location> location
    ) {
        this.userAgent = Objects.requireNonNull(userAgent, "userAgent is required");
        this.ipAddress = Objects.requireNonNull(ipAddress, "ipAddress is required");
        this.location = location != null ? location : Optional.empty();
    }

    /**
     * HTTP User-Agent data
     *
     * @return the value of the property as a {@link UserAgent}
     */
    public UserAgent getUserAgent() {
        return this.userAgent;
    }

    /**
     * IP address
     *
     * @return the value of the property as a {@link String}
     */
    public String getIpAddress() {
        return this.ipAddress;
    }

    /**
     * IP geolocation data
     *
     * @return the value of the property as a {@link Location} wrapped in an {@link Optional}
     */
    public Optional<Location> getLocation() {
        return this.location;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final BrowserSession other = (BrowserSession) o;
        return
            this.userAgent.equals(other.userAgent)&&
            this.ipAddress.equals(other.ipAddress)&&
            this.location.equals(other.location);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.userAgent,
            this.ipAddress,
            this.location
        );
    }

    @Override
    public String toString() {
        return "BrowserSession{" +
            "userAgent='" + this.userAgent +
            "', ipAddress='" + this.ipAddress +
            "', location='" + this.location.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
