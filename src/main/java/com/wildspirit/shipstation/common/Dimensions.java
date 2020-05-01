package com.wildspirit.shipstation.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class Dimensions {
    public final String units;
    public final double length;
    public final double width;
    public final double height;

    public Dimensions(
            @JsonProperty("units") String units,
            @JsonProperty("length") double length,
            @JsonProperty("width") double width,
            @JsonProperty("height") double height) {
        this.units = units;
        this.length = length;
        this.width = width;
        this.height = height;
    }
}
