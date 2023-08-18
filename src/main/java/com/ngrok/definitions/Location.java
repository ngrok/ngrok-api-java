/* Code generated for API Clients. DO NOT EDIT. */

package com.ngrok.definitions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Optional;

/**
 * A class encapsulating the {@link Location} resource.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Location {
    @JsonProperty("country_code")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<String> countryCode;
    @JsonProperty("latitude")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Double> latitude;
    @JsonProperty("longitude")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Double> longitude;
    @JsonProperty("lat_long_radius_km")
    @JsonInclude(value = JsonInclude.Include.NON_ABSENT)
    private final Optional<Long> latLongRadiusKm;

    /**
     * Creates a new instance of {@link Location}.
     *
     * @param countryCode ISO country code
     * @param latitude geographical latitude
     * @param longitude geographical longitude
     * @param latLongRadiusKm accuracy radius of the geographical coordinates
     */
    @JsonCreator
    public Location(
        @JsonProperty("country_code") final Optional<String> countryCode,
        @JsonProperty("latitude") final Optional<Double> latitude,
        @JsonProperty("longitude") final Optional<Double> longitude,
        @JsonProperty("lat_long_radius_km") final Optional<Long> latLongRadiusKm
    ) {
        this.countryCode = countryCode != null ? countryCode : Optional.empty();
        this.latitude = latitude != null ? latitude : Optional.empty();
        this.longitude = longitude != null ? longitude : Optional.empty();
        this.latLongRadiusKm = latLongRadiusKm != null ? latLongRadiusKm : Optional.empty();
    }

    /**
     * ISO country code
     *
     * @return the value of the property as a {@link String} wrapped in an {@link Optional}
     */
    public Optional<String> getCountryCode() {
        return this.countryCode;
    }

    /**
     * geographical latitude
     *
     * @return the value of the property as a {@link double} wrapped in an {@link Optional}
     */
    public Optional<Double> getLatitude() {
        return this.latitude;
    }

    /**
     * geographical longitude
     *
     * @return the value of the property as a {@link double} wrapped in an {@link Optional}
     */
    public Optional<Double> getLongitude() {
        return this.longitude;
    }

    /**
     * accuracy radius of the geographical coordinates
     *
     * @return the value of the property as a {@link long} wrapped in an {@link Optional}
     */
    public Optional<Long> getLatLongRadiusKm() {
        return this.latLongRadiusKm;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        final Location other = (Location) o;
        return
            this.countryCode.equals(other.countryCode)&&
            this.latitude.equals(other.latitude)&&
            this.longitude.equals(other.longitude)&&
            this.latLongRadiusKm.equals(other.latLongRadiusKm);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            this.countryCode,
            this.latitude,
            this.longitude,
            this.latLongRadiusKm
        );
    }

    @Override
    public String toString() {
        return "Location{" +
            "countryCode='" + this.countryCode.orElse("(null)") +
            "', latitude='" + this.latitude.map(Object::toString).orElse("(null)") +
            "', longitude='" + this.longitude.map(Object::toString).orElse("(null)") +
            "', latLongRadiusKm='" + this.latLongRadiusKm.map(Object::toString).orElse("(null)") +
            "'}";
    }
}
