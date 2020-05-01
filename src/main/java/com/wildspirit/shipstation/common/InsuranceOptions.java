package com.wildspirit.shipstation.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class InsuranceOptions {
    public final String provider;
    public final boolean insureShipment;
    public final double insuredValue;

    public InsuranceOptions(
            @JsonProperty("provider") String provider,
            @JsonProperty("insureShipment") boolean insureShipment,
            @JsonProperty("insuredValue") double insuredValue
    ) {
        this.provider = provider;
        this.insureShipment = insureShipment;
        this.insuredValue = insuredValue;
    }
}
