package com.wildspirit.shipstation.orders;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class OrderAdvancedOptions {
    public final long warehouseId;
    public final boolean nonMachinable;
    public final boolean saturdayDelivery;
    public final boolean containsAlcohol;
    public final boolean mergedOrSplit;
    public final List<Long> mergedIds;
    public final long parentId;
    public final long storeId;
    public final String source;

    public OrderAdvancedOptions(
            @JsonProperty("warehouseId") long warehouseId,
            @JsonProperty("nonMachinable") boolean nonMachinable,
            @JsonProperty("saturdayDelivery") boolean saturdayDelivery,
            @JsonProperty("containsAlcohol") boolean containsAlcohol,
            @JsonProperty("mergedOrSplit") boolean mergedOrSplit,
            @JsonProperty("mergedIds") List<Long> mergedIds,
            @JsonProperty("parentId") long parentId,
            @JsonProperty("storeId") long storeId,
            @JsonProperty("source") String source) {
        this.warehouseId = warehouseId;
        this.nonMachinable = nonMachinable;
        this.saturdayDelivery = saturdayDelivery;
        this.containsAlcohol = containsAlcohol;
        this.mergedOrSplit = mergedOrSplit;
        this.mergedIds = mergedIds;
        this.parentId = parentId;
        this.storeId = storeId;
        this.source = source;
    }
}
