package com.plenigo.java_test.services.PlenigoSDK.Entities;

import java.util.Date;

public class OrderItem {
    private int position;
    private String productId;
    private String plenigoOfferId;
    private String plenigoProductId;
    private String plenigoStepId;
    private String accessRightUniqueId;
    private String title;
    private String internalTitle;
    private String taxType;
    private double price;
    private double tax;
    private String taxCountry;
    private int quantity;
    private int discountPercentage;
    private String costCenter;
    private String purchaseNumber;
    private String voucherCode;
    private String deliveryCustomerId;
    private OrderAddress deliveryAddress;
    private long subscriptionItemId;
    private boolean externalBilling;
    private String taxState;
    private long purchasedAddonId;
    private Date validityEndDate;
    private VoucherPurchaseData voucherPurchase;

    public VoucherUsageData getVoucherusage() {
        return voucherusage;
    }

    public void setVoucherusage(VoucherUsageData voucherusage) {
        this.voucherusage = voucherusage;
    }

    public VoucherPurchaseData getVoucherPurchase() {
        return voucherPurchase;
    }

    public void setVoucherPurchase(VoucherPurchaseData voucherPurchase) {
        this.voucherPurchase = voucherPurchase;
    }

    public Date getValidityEndDate() {
        return validityEndDate;
    }

    public void setValidityEndDate(Date validityEndDate) {
        this.validityEndDate = validityEndDate;
    }

    public long getPurchasedAddonId() {
        return purchasedAddonId;
    }

    public void setPurchasedAddonId(long purchasedAddonId) {
        this.purchasedAddonId = purchasedAddonId;
    }

    public String getTaxState() {
        return taxState;
    }

    public void setTaxState(String taxState) {
        this.taxState = taxState;
    }

    public boolean isExternalBilling() {
        return externalBilling;
    }

    public void setExternalBilling(boolean externalBilling) {
        this.externalBilling = externalBilling;
    }

    public long getSubscriptionItemId() {
        return subscriptionItemId;
    }

    public void setSubscriptionItemId(long subscriptionItemId) {
        this.subscriptionItemId = subscriptionItemId;
    }

    public OrderAddress getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(OrderAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getDeliveryCustomerId() {
        return deliveryCustomerId;
    }

    public void setDeliveryCustomerId(String deliveryCustomerId) {
        this.deliveryCustomerId = deliveryCustomerId;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public String getPurchaseNumber() {
        return purchaseNumber;
    }

    public void setPurchaseNumber(String purchaseNumber) {
        this.purchaseNumber = purchaseNumber;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTaxCountry() {
        return taxCountry;
    }

    public void setTaxCountry(String taxCountry) {
        this.taxCountry = taxCountry;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getInternalTitle() {
        return internalTitle;
    }

    public void setInternalTitle(String internalTitle) {
        this.internalTitle = internalTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAccessRightUniqueId() {
        return accessRightUniqueId;
    }

    public void setAccessRightUniqueId(String accessRightUniqueId) {
        this.accessRightUniqueId = accessRightUniqueId;
    }

    public String getPlenigoStepId() {
        return plenigoStepId;
    }

    public void setPlenigoStepId(String plenigoStepId) {
        this.plenigoStepId = plenigoStepId;
    }

    public String getPlenigoProductId() {
        return plenigoProductId;
    }

    public void setPlenigoProductId(String plenigoProductId) {
        this.plenigoProductId = plenigoProductId;
    }

    public String getPlenigoOfferId() {
        return plenigoOfferId;
    }

    public void setPlenigoOfferId(String plenigoOfferId) {
        this.plenigoOfferId = plenigoOfferId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    private VoucherUsageData voucherusage;


}

