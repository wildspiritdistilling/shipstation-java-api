package com.wildspirit.shipstation.orders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wildspirit.shipstation.common.AbstractApi;
import io.mikael.urlbuilder.UrlBuilder;
import okhttp3.OkHttpClient;

import java.util.stream.Stream;

public class OrdersApi extends AbstractApi {

    public OrdersApi(OkHttpClient http, String authorization, ObjectMapper mapper) {
        super(http, authorization, mapper);
    }

    public Stream<Order> all(GetOrdersRequest req) {
        UrlBuilder url = withEndpoint().withPath("/orders");
        if (req.createDateEnd != null) {
            url.addParameter("createDateEnd", ISO8601.format(req.createDateEnd));
        }
        GetOrdersResponse getOrdersResponse = httpGet(url.toString(), GetOrdersResponse.class);
        return getOrdersResponse.orders.stream();
    }
}
