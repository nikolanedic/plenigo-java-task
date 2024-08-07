package com.plenigo.java_test.services.PlenigoSDK.Entities;

import java.util.Date;

public class Invoice implements EntityInterface{
    private String invoiceId;
    private Date invoiceDate;

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getId()
    {
        return this.invoiceId;
    }
}
