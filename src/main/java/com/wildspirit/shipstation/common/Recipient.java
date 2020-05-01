package com.wildspirit.shipstation.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class Recipient {
    public final String name;
    public final String company;
    public final String street1;
    public final String street2;
    public final String street3;
    public final String city;
    public final String state;
    public final String postalCode;
    public final String country;
    public final String phone;
    public final String residential;
    public final String addressVerified;

    public Recipient(
            @JsonProperty("name") String name,
            @JsonProperty("company") String company,
            @JsonProperty("street1") String street1,
            @JsonProperty("street2") String street2,
            @JsonProperty("street3") String street3,
            @JsonProperty("city") String city,
            @JsonProperty("state") String state,
            @JsonProperty("postalCode") String postalCode,
            @JsonProperty("country") String country,
            @JsonProperty("phone") String phone,
            @JsonProperty("residential") String residential,
            @JsonProperty("addressVerified") String addressVerified) {
        this.name = name;
        this.company = company;
        this.street1 = street1;
        this.street2 = street2;
        this.street3 = street3;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
        this.residential = residential;
        this.addressVerified = addressVerified;
    }
}
