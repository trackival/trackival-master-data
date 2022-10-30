package com.trackival.mdm.coordinate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CoordinateResult {
    private double latitude;
    private double longitude;
    private String type;
    private String name;
    private String number;
    @JsonProperty("postal_code")
    private String postalCode;
    private String street;
    private int confidence;
    private String region;
    @JsonProperty("region_code")
    private String regionCode;
    private String county;
    private String locality;
    @JsonProperty("administrative_area")
    private String administrativeArea;
    private String neighbourhood;
    private String country;
    @JsonProperty("country_code")
    private String countryCode;
    private String continent;
    private String label;
}
