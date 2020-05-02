package com.wildspirit.shipstation.orders;

import com.wildspirit.shipstation.common.SortDirection;

import java.util.Date;

public final class GetOrdersRequest {
    public final String customerName;
    public final String itemKeyword;
    public final Date createDateStart;
    public final Date createDateEnd;
    public final Date modifyDateStart;
    public final Date modifyDateEnd;
    public final Date orderDateStart;
    public final Date orderDateEnd;
    public final String orderNumber;
    public final OrderStatus orderStatus;
    public final Date paymentDateStart;
    public final Date paymentDateEnd;
    public final Integer storeId;
    public final Integer sortBy;
    public final SortDirection sortDir;

    public GetOrdersRequest(String customerName, String itemKeyword, Date createDateStart, Date createDateEnd, Date modifyDateStart, Date modifyDateEnd, Date orderDateStart, Date orderDateEnd, String orderNumber, OrderStatus orderStatus, Date paymentDateStart, Date paymentDateEnd, Integer storeId, Integer sortBy, SortDirection sortDir) {
        this.customerName = customerName;
        this.itemKeyword = itemKeyword;
        this.createDateStart = createDateStart;
        this.createDateEnd = createDateEnd;
        this.modifyDateStart = modifyDateStart;
        this.modifyDateEnd = modifyDateEnd;
        this.orderDateStart = orderDateStart;
        this.orderDateEnd = orderDateEnd;
        this.orderNumber = orderNumber;
        this.orderStatus = orderStatus;
        this.paymentDateStart = paymentDateStart;
        this.paymentDateEnd = paymentDateEnd;
        this.storeId = storeId;
        this.sortBy = sortBy;
        this.sortDir = sortDir;
    }


    public static class Builder {
        private String customerName;
        private String itemKeyword;
        private Date createDateStart;
        private Date createDateEnd;
        private Date modifyDateStart;
        private Date modifyDateEnd;
        private Date orderDateStart;
        private Date orderDateEnd;
        private String orderNumber;
        private OrderStatus orderStatus;
        private Date paymentDateStart;
        private Date paymentDateEnd;
        private int storeId;
        private int sortBy;
        private SortDirection sortDir;
        private int pageSize;

        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder setItemKeyword(String itemKeyword) {
            this.itemKeyword = itemKeyword;
            return this;
        }

        public Builder setCreateDateStart(Date createDateStart) {
            this.createDateStart = createDateStart;
            return this;
        }

        public Builder setCreateDateEnd(Date createDateEnd) {
            this.createDateEnd = createDateEnd;
            return this;
        }

        public Builder setModifyDateStart(Date modifyDateStart) {
            this.modifyDateStart = modifyDateStart;
            return this;
        }

        public Builder setModifyDateEnd(Date modifyDateEnd) {
            this.modifyDateEnd = modifyDateEnd;
            return this;
        }

        public Builder setOrderDateStart(Date orderDateStart) {
            this.orderDateStart = orderDateStart;
            return this;
        }

        public Builder setOrderDateEnd(Date orderDateEnd) {
            this.orderDateEnd = orderDateEnd;
            return this;
        }

        public Builder setOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
            return this;
        }

        public Builder setOrderStatus(OrderStatus orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public Builder setPaymentDateStart(Date paymentDateStart) {
            this.paymentDateStart = paymentDateStart;
            return this;
        }

        public Builder setPaymentDateEnd(Date paymentDateEnd) {
            this.paymentDateEnd = paymentDateEnd;
            return this;
        }

        public Builder setStoreId(int storeId) {
            this.storeId = storeId;
            return this;
        }

        public Builder setSortBy(int sortBy) {
            this.sortBy = sortBy;
            return this;
        }

        public Builder setSortDir(SortDirection sortDir) {
            this.sortDir = sortDir;
            return this;
        }

        public Builder setPageSize(int pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public GetOrdersRequest build() {
            return new GetOrdersRequest(customerName, itemKeyword, createDateStart, createDateEnd, modifyDateStart, modifyDateEnd, orderDateStart, orderDateEnd, orderNumber, orderStatus, paymentDateStart, paymentDateEnd, storeId, sortBy, sortDir);
        }
    }
}
