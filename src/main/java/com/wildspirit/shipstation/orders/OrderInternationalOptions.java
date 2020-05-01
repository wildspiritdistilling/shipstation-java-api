package com.wildspirit.shipstation.orders;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class OrderInternationalOptions {
    public final String contents;
    public final String nonDelivery;
    public final List<CustomsItem> customsItems;

    public OrderInternationalOptions(
            @JsonProperty("contents") String contents,
            @JsonProperty("nonDelivery") String nonDelivery,
            @JsonProperty("customsItems") List<CustomsItem> customsItems) {
        this.contents = contents;
        this.nonDelivery = nonDelivery;
        this.customsItems = customsItems;
    }

    public static final class CustomsItem {
        public final long customsItemId;
        public final String description;
        public final int quantity;
        public final int value;
        public final String harmonizedTariffCode;
        public final String countryOfOrigin;

        public CustomsItem(
                @JsonProperty("customsItemId") long customsItemId,
                @JsonProperty("description") String description,
                @JsonProperty("quantity") int quantity,
                @JsonProperty("value") int value,
                @JsonProperty("harmonizedTariffCode") String harmonizedTariffCode,
                @JsonProperty("countryOfOrigin") String countryOfOrigin
        ) {
            this.customsItemId = customsItemId;
            this.description = description;
            this.quantity = quantity;
            this.value = value;
            this.harmonizedTariffCode = harmonizedTariffCode;
            this.countryOfOrigin = countryOfOrigin;
        }
    }
}
