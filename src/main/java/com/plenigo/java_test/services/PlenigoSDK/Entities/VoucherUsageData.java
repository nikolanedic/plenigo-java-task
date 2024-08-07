package com.plenigo.java_test.services.PlenigoSDK.Entities;

import java.util.Date;

public class VoucherUsageData {
    private int purchaseOrderItemPosition;
    private Date createdDate;
    private Date changedDate;
    private String createdBy;
    private String createdByType;
    private String changedBy;
    private String changedByType;

    private long purchaseOrderId;

    public String getChangedByType() {
        return changedByType;
    }

    public void setChangedByType(String changedByType) {
        this.changedByType = changedByType;
    }

    public String getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy;
    }

    public String getCreatedByType() {
        return createdByType;
    }

    public void setCreatedByType(String createdByType) {
        this.createdByType = createdByType;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(Date changedDate) {
        this.changedDate = changedDate;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getPurchaseOrderItemPosition() {
        return purchaseOrderItemPosition;
    }

    public void setPurchaseOrderItemPosition(int purchaseOrderItemPosition) {
        this.purchaseOrderItemPosition = purchaseOrderItemPosition;
    }

    public long getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(long purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }
}
