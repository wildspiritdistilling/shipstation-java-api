package com.wildspirit.shipstation.orders;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wildspirit.shipstation.common.Recipient;
import com.wildspirit.shipstation.common.Dimensions;
import com.wildspirit.shipstation.common.InsuranceOptions;
import com.wildspirit.shipstation.common.Weight;

import java.util.Date;
import java.util.List;

public final class Order {
    public final int orderId;
    public final String orderNumber;
    public final String orderKey;
    public final Date orderDate;
    public final Date createDate;
    public final Date modifyDate;
    public final Date paymentDate;
    public final Date shipByDate;
    public final OrderStatus orderStatus;
    public final long customerId;
    public final String customerUsername;
    public final String customerEmail;
    public final Recipient billTo;
    public final Recipient shipTo;
    public final List<OrderItem> items;
    public final double orderTotal;
    public final double amountPaid;
    public final double shippingAmount;
    public final String customerNotes;
    public final String internalNodes;
    public final boolean gift;
    public final String giftMessage;
    public final String paymentMethod;
    public final String requestedShippingService;
    public final String carrierCode;
    public final String serviceCode;
    public final String packageCode;
    public final String confirmation;
    public final Date shipDate;
    public final Date holdUntilDate;
    public final Weight weight;
    public final Dimensions dimensions;
    public final InsuranceOptions insuranceOptions;
    public final OrderInternationalOptions internationalOptions;
    public final OrderAdvancedOptions advancedOptions;
    public final String userId;
    public final List<Long> tagIds;
    public final boolean externallyFulfilled;
    public final String externallyFulfilledBy;

    public Order(
            @JsonProperty("orderId") int orderId,
            @JsonProperty("orderNumber") String orderNumber,
            @JsonProperty("orderKey") String orderKey,
            @JsonProperty("orderDate") Date orderDate,
            @JsonProperty("createDate") Date createDate,
            @JsonProperty("modifyDate") Date modifyDate,
            @JsonProperty("paymentDate") Date paymentDate,
            @JsonProperty("shipByDate") Date shipByDate,
            @JsonProperty("orderStatus") OrderStatus orderStatus,
            @JsonProperty("customerId") long customerId,
            @JsonProperty("customerUsername") String customerUsername,
            @JsonProperty("customerEmail") String customerEmail,
            @JsonProperty("billTo") Recipient billTo,
            @JsonProperty("shipTo") Recipient shipTo,
            @JsonProperty("items") List<OrderItem> items,
            @JsonProperty("orderTotal") double orderTotal,
            @JsonProperty("amountPaid") double amountPaid,
            @JsonProperty("shippingAmount") double shippingAmount,
            @JsonProperty("customerNotes") String customerNotes,
            @JsonProperty("internalNodes") String internalNodes,
            @JsonProperty("gift") boolean gift,
            @JsonProperty("giftMessage") String giftMessage,
            @JsonProperty("paymentMethod") String paymentMethod,
            @JsonProperty("requestedShippingService") String requestedShippingService,
            @JsonProperty("carrierCode") String carrierCode,
            @JsonProperty("serviceCoe") String serviceCode,
            @JsonProperty("packageCode") String packageCode,
            @JsonProperty("confirmation") String confirmation,
            @JsonProperty("shipDate") Date shipDate,
            @JsonProperty("holdUntilDate") Date holdUntilDate,
            @JsonProperty("weight") Weight weight,
            @JsonProperty("dimensions") Dimensions dimensions,
            @JsonProperty("insuranceOptions") InsuranceOptions insuranceOptions,
            @JsonProperty("internationalOptions") OrderInternationalOptions internationalOptions,
            @JsonProperty("advancedOptions") OrderAdvancedOptions advancedOptions,
            @JsonProperty("userId") String userId,
            @JsonProperty("tagIds") List<Long> tagIds,
            @JsonProperty("externallyFulfilled") boolean externallyFulfilled,
            @JsonProperty("externallyFulfilledBy") String externallyFulfilledBy
    ) {
        this.orderId = orderId;
        this.orderNumber = orderNumber;
        this.orderKey = orderKey;
        this.orderDate = orderDate;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
        this.paymentDate = paymentDate;
        this.shipByDate = shipByDate;
        this.orderStatus = orderStatus;
        this.customerId = customerId;
        this.customerUsername = customerUsername;
        this.customerEmail = customerEmail;
        this.billTo = billTo;
        this.shipTo = shipTo;
        this.items = items;
        this.orderTotal = orderTotal;
        this.amountPaid = amountPaid;
        this.shippingAmount = shippingAmount;
        this.customerNotes = customerNotes;
        this.internalNodes = internalNodes;
        this.gift = gift;
        this.giftMessage = giftMessage;
        this.paymentMethod = paymentMethod;
        this.requestedShippingService = requestedShippingService;
        this.carrierCode = carrierCode;
        this.serviceCode = serviceCode;
        this.packageCode = packageCode;
        this.confirmation = confirmation;
        this.shipDate = shipDate;
        this.holdUntilDate = holdUntilDate;
        this.weight = weight;
        this.dimensions = dimensions;
        this.insuranceOptions = insuranceOptions;
        this.internationalOptions = internationalOptions;
        this.advancedOptions = advancedOptions;
        this.userId = userId;
        this.tagIds = tagIds;
        this.externallyFulfilled = externallyFulfilled;
        this.externallyFulfilledBy = externallyFulfilledBy;
    }
}
