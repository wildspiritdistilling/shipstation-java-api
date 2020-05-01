package com.wildspirit.shipstation.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Weight {
    public final double value;
    public final String units;

    public Weight(@JsonProperty("value") double value, @JsonProperty("units") String units) {
        this.value = value;
        this.units = units;
    }
}
