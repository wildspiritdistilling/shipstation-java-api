package com.wildspirit.shipstation.orders;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public final class GetOrdersResponse {
    public final List<Order> orders;
    public final int total;
    public final int page;
    public final int pages;

    public GetOrdersResponse(
            @JsonProperty("orders") List<Order> orders,
            @JsonProperty("total") int total,
            @JsonProperty("page") int page,
            @JsonProperty("pages") int pages
    ) {
        this.orders = orders;
        this.total = total;
        this.page = page;
        this.pages = pages;
    }
}
