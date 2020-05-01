package com.wildspirit.shipstation.orders;

public enum OrderStatus {
    AWAITING_PAYMENT,
    AWAITING_SHIPMENT,
    PENDING_FULFILLMENT,
    SHIPPED,
    ON_HOLD,
    CANCELLED
}
