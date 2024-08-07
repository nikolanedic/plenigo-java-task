package com.plenigo.java_test.services.PlenigoSDK.Entities;

import java.util.Date;

public class VoucherPurchaseData {
    private long voucherTemplateId;  // required
    private String voucherCode;
    private Date voucherEndDate;  // required

    public long getVoucherTemplateId() {
        return voucherTemplateId;
    }

    public void setVoucherTemplateId(long voucherTemplateId) {
        this.voucherTemplateId = voucherTemplateId;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public Date getVoucherEndDate() {
        return voucherEndDate;
    }

    public void setVoucherEndDate(Date voucherEndDate) {
        this.voucherEndDate = voucherEndDate;
    }
}
