/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link UserAgent} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAgent {
    @JsonProperty("raw")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String raw;
    @JsonProperty("browser_name")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> browserName;
    @JsonProperty("browser_version")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> browserVersion;
    @JsonProperty("device_type")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> deviceType;
    @JsonProperty("os_name")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> osName;
    @JsonProperty("os_version")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> osVersion;

    /**
     * Creates a new instance of {@link UserAgent}.
     *
     * @param raw raw User-Agent request header
     * @param browserName browser name (e.g. Chrome)
     * @param browserVersion browser version (e.g. 102)
     * @param deviceType type of device (e.g. Desktop)
     * @param osName operating system name (e.g. MacOS)
     * @param osVersion operating system version (e.g. 10.15.7)
     */
    @JsonCreator
    public UserAgent(
        @JsonProperty("raw") final String raw,
        @JsonProperty("browser_name") final Optional<String> browserName,
        @JsonProperty("browser_version") final Optional<String> browserVersion,
        @JsonProperty("device_type") final Optional<String> deviceType,
        @JsonProperty("os_name") final Optional<String> osName,
        @JsonProperty("os_version") final Optional<String> osVersion
    ) {
        this.raw = Objects.requireNonNull(raw, "raw is required");
        this.browserName = browserName != null ? browserName : Optional.empty();
        this.browserVersion = browserVersion != null ? browserVersion : Optional.empty();
        this.deviceType = deviceType != null ? deviceType : Optional.empty();
        this.osName = osName != null ? osName : Optional.empty();
        this.osVersion = osVersion != null ? osVersion : Optional.empty();
    }

    /**
     * raw User-Agent request header
     *
     * @return the value of the property as a {@link String}
     */
    public String getRaw() {
        return this.raw;
    }

    /**
     * browser name (e.g. Chrome)
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getBrowserName() {
        return this.browserName;
    }

    /**
     * browser version (e.g. 102)
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getBrowserVersion() {
        return this.browserVersion;
    }

    /**
     * type of device (e.g. Desktop)
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getDeviceType() {
        return this.deviceType;
    }

    /**
     * operating system name (e.g. MacOS)
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getOsName() {
        return this.osName;
    }

    /**
     * operating system version (e.g. 10.15.7)
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getOsVersion() {
        return this.osVersion;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final UserAgent other = (UserAgent) o;
        return
            this.raw.equals(other.raw)&&
            this.browserName.equals(other.browserName)&&
            this.browserVersion.equals(other.browserVersion)&&
            this.deviceType.equals(other.deviceType)&&
            this.osName.equals(other.osName)&&
            this.osVersion.equals(other.osVersion);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.raw,
            this.browserName,
            this.browserVersion,
            this.deviceType,
            this.osName,
            this.osVersion
        );
    }

    @Override
    public String toString() {
        return "UserAgent{" +
            "raw='" + this.raw +
            "', browserName='" + this.browserName.orElse("(null)") +
            "', browserVersion='" + this.browserVersion.orElse("(null)") +
            "', deviceType='" + this.deviceType.orElse("(null)") +
            "', osName='" + this.osName.orElse("(null)") +
            "', osVersion='" + this.osVersion.orElse("(null)") +
            "'}";
    }
}
