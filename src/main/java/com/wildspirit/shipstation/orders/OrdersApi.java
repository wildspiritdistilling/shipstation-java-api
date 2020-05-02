package com.wildspirit.shipstation.orders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wildspirit.shipstation.common.AbstractApi;
import io.mikael.urlbuilder.UrlBuilder;
import okhttp3.OkHttpClient;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class OrdersApi extends AbstractApi {

    public OrdersApi(OkHttpClient http, String authorization, ObjectMapper mapper) {
        super(http, authorization, mapper);
    }

    public Stream<Order> all(GetOrdersRequest req) {
        UrlBuilder url = withEndpoint().withPath("/orders");
        if (req.customerName != null) {
            url.addParameter("customerName", req.customerName);
        }
        if (req.itemKeyword != null) {
            url.addParameter("itemKeyword", req.itemKeyword);
        }
        if (req.orderNumber != null) {
            url.addParameter("orderNumber", req.orderNumber);
        }
        if (req.orderStatus != null) {
            url.addParameter("orderStatus", req.orderStatus.name().toLowerCase());
        }
        if (req.storeId != null) {
            url.addParameter("storeId", req.storeId.toString());
        }
        if (req.sortBy != null) {
            url.addParameter("sortBy", req.sortBy.toString());
        }
        if (req.sortDir != null) {
            url.addParameter("sortDir", req.sortDir.name().toLowerCase());
        }
        if (req.createDateStart != null) {
            url.addParameter("createDateStart", ISO8601.format(req.createDateStart));
        }
        if (req.createDateEnd != null) {
            url.addParameter("createDateEnd", ISO8601.format(req.createDateEnd));
        }
        if (req.modifyDateStart != null) {
            url.addParameter("modifyDateStart", ISO8601.format(req.modifyDateStart));
        }
        if (req.modifyDateEnd != null) {
            url.addParameter("modifyDateEnd", ISO8601.format(req.modifyDateEnd));
        }
        if (req.orderDateStart != null) {
            url.addParameter("orderDateStart", ISO8601.format(req.orderDateStart));
        }
        if (req.orderDateEnd != null) {
            url.addParameter("orderDateEnd", ISO8601.format(req.orderDateEnd));
        }
        if (req.paymentDateStart != null) {
            url.addParameter("paymentDateStart", ISO8601.format(req.paymentDateStart));
        }
        if (req.paymentDateEnd != null) {
            url.addParameter("paymentDateEnd", ISO8601.format(req.paymentDateEnd));
        }
        url.addParameter("pageSize", "100");

        Iterator<Order> iterator = new Iterator<Order>() {

            int page = 1;
            GetOrdersResponse rsp = fetchPage();
            Iterator<Order> inner = rsp.orders.iterator();

            @Override
            public boolean hasNext() {
                if (inner.hasNext()) {
                    return true;
                } else if (page < rsp.pages) {
                    page++;
                    rsp = fetchPage();
                    inner = rsp.orders.iterator();
                    return inner.hasNext();
                } else {
                    return false;
                }
            }

            @Override
            public Order next() {
                return inner.next();
            }

            GetOrdersResponse fetchPage() {
                UrlBuilder nextPageUrl = url.addParameter("page", Integer.toString(page));
                return httpGet(nextPageUrl.toString(), GetOrdersResponse.class);
            }
        };

        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED | Spliterator.NONNULL), false);
    }
}
