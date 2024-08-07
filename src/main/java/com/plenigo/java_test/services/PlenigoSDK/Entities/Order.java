package com.plenigo.java_test.services.PlenigoSDK.Entities;

import java.util.Date;
import java.util.List;

public class Order implements EntityInterface {
    private long orderId;
    private String externalSystemId;
    private String status;
    private String type;
    private Date orderDate;
    private double accumulatedPrice;
    private String currency;
    private String paymentMethod;
    private long paymentMethodId;
    private PaymentMethodDetails paymentMethodDetails;
    private String purchaseOrderIndicator;
    private String invoiceCustomerId;
    private boolean analogInvoice;
    private boolean managedExternal;
    private boolean suppressInvoiceSending;
    private GiftInfo giftInfo;
    private OrderAddress invoiceAddress;
    private List<OrderItem> items;

    public String getExternalSystemId() {
        return externalSystemId;
    }

    public void setExternalSystemId(String externalSystemId) {
        this.externalSystemId = externalSystemId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getAccumulatedPrice() {
        return accumulatedPrice;
    }

    public void setAccumulatedPrice(double accumulatedPrice) {
        this.accumulatedPrice = accumulatedPrice;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public long getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(long paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public PaymentMethodDetails getPaymentMethodDetails() {
        return paymentMethodDetails;
    }

    public void setPaymentMethodDetails(PaymentMethodDetails paymentMethodDetails) {
        this.paymentMethodDetails = paymentMethodDetails;
    }

    public String getPurchaseOrderIndicator() {
        return purchaseOrderIndicator;
    }

    public void setPurchaseOrderIndicator(String purchaseOrderIndicator) {
        this.purchaseOrderIndicator = purchaseOrderIndicator;
    }

    public String getInvoiceCustomerId() {
        return invoiceCustomerId;
    }

    public void setInvoiceCustomerId(String invoiceCustomerId) {
        this.invoiceCustomerId = invoiceCustomerId;
    }

    public boolean isAnalogInvoice() {
        return analogInvoice;
    }

    public void setAnalogInvoice(boolean analogInvoice) {
        this.analogInvoice = analogInvoice;
    }

    public boolean isManagedExternal() {
        return managedExternal;
    }

    public void setManagedExternal(boolean managedExternal) {
        this.managedExternal = managedExternal;
    }

    public boolean isSuppressInvoiceSending() {
        return suppressInvoiceSending;
    }

    public void setSuppressInvoiceSending(boolean suppressInvoiceSending) {
        this.suppressInvoiceSending = suppressInvoiceSending;
    }

    public GiftInfo getGiftInfo() {
        return giftInfo;
    }

    public void setGiftInfo(GiftInfo giftInfo) {
        this.giftInfo = giftInfo;
    }

    public OrderAddress getInvoiceAddress() {
        return invoiceAddress;
    }

    public void setInvoiceAddress(OrderAddress invoiceAddress) {
        this.invoiceAddress = invoiceAddress;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getOrderId());
    }

    @Override
    public String getId() {
        return String.valueOf(this.orderId);
    }
}
