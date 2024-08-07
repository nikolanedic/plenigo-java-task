package com.plenigo.java_test.services.PlenigoSDK.Entities;

import java.util.Date;

public class Customer implements EntityInterface{
    private String customerId;
    private String email;
    private Date createdDate;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId()
    {
        return this.customerId;
    }
}
