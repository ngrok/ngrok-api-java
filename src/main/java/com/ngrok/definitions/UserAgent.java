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
    private final String browserName;
    @JsonProperty("browser_version")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String browserVersion;
    @JsonProperty("device_type")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String deviceType;
    @JsonProperty("os_name")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String osName;
    @JsonProperty("os_version")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final String osVersion;

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
        @JsonProperty("browser_name") final String browserName,
        @JsonProperty("browser_version") final String browserVersion,
        @JsonProperty("device_type") final String deviceType,
        @JsonProperty("os_name") final String osName,
        @JsonProperty("os_version") final String osVersion
    ) {
        this.raw = Objects.requireNonNull(raw, "raw is required");
        this.browserName = Objects.requireNonNull(browserName, "browserName is required");
        this.browserVersion = Objects.requireNonNull(browserVersion, "browserVersion is required");
        this.deviceType = Objects.requireNonNull(deviceType, "deviceType is required");
        this.osName = Objects.requireNonNull(osName, "osName is required");
        this.osVersion = Objects.requireNonNull(osVersion, "osVersion is required");
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
     * @return the value of the property as a {@link String}
     */
    public String getBrowserName() {
        return this.browserName;
    }

    /**
     * browser version (e.g. 102)
     *
     * @return the value of the property as a {@link String}
     */
    public String getBrowserVersion() {
        return this.browserVersion;
    }

    /**
     * type of device (e.g. Desktop)
     *
     * @return the value of the property as a {@link String}
     */
    public String getDeviceType() {
        return this.deviceType;
    }

    /**
     * operating system name (e.g. MacOS)
     *
     * @return the value of the property as a {@link String}
     */
    public String getOsName() {
        return this.osName;
    }

    /**
     * operating system version (e.g. 10.15.7)
     *
     * @return the value of the property as a {@link String}
     */
    public String getOsVersion() {
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
            "', browserName='" + this.browserName +
            "', browserVersion='" + this.browserVersion +
            "', deviceType='" + this.deviceType +
            "', osName='" + this.osName +
            "', osVersion='" + this.osVersion +
            "'}";
    }
}
