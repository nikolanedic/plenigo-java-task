package com.plenigo.java_test.services.PlenigoSDK.Entities;

public class GiftInfo {
    private boolean notifyGiftee;
    private String donorText;
    private String gifteeEmail;

    public String getGifteeEmail() {
        return gifteeEmail;
    }

    public void setGifteeEmail(String gifteeEmail) {
        this.gifteeEmail = gifteeEmail;
    }

    public String getDonorText() {
        return donorText;
    }

    public void setDonorText(String donorText) {
        this.donorText = donorText;
    }

    public boolean isNotifyGiftee() {
        return notifyGiftee;
    }

    public void setNotifyGiftee(boolean notifyGiftee) {
        this.notifyGiftee = notifyGiftee;
    }
}
