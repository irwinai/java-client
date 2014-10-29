package com.coinport.payment;

import java.util.HashMap;
import java.util.Map;

public class InvoiceParams {

    private String posData;
    private String notificationURL;
    private String transactionSpeed;
    private boolean fullNotifications;
    private String notificationEmail;
    private String redirectURL;
    private String orderId;
    private String itemDesc;
    private String itemCode;
    private boolean physical;

    private String buyerName;
    private String buyerputress1;
    private String buyerputress2;
    private String buyerCity;
    private String buyerState;
    private String buyerZip;
    private String buyerCountry;
    private String buyerEmail;
    private String buyerPhone;

    public InvoiceParams() {
        this.physical = false;
        this.fullNotifications = false;
    }


    public String getPosData() {
        return posData;
    }


    public void setPosData(String posData) {
        this.posData = posData;
    }


    public String getNotificationURL() {
        return notificationURL;
    }


    public void setNotificationURL(String notificationURL) {
        this.notificationURL = notificationURL;
    }


    public String getTransactionSpeed() {
        return transactionSpeed;
    }


    public void setTransactionSpeed(String transactionSpeed) {
        this.transactionSpeed = transactionSpeed;
    }


    public boolean isFullNotifications() {
        return fullNotifications;
    }


    public void setFullNotifications(boolean fullNotifications) {
        this.fullNotifications = fullNotifications;
    }


    public String getNotificationEmail() {
        return notificationEmail;
    }


    public void setNotificationEmail(String notificationEmail) {
        this.notificationEmail = notificationEmail;
    }


    public String getRedirectURL() {
        return redirectURL;
    }


    public void setRedirectURL(String redirectURL) {
        this.redirectURL = redirectURL;
    }


    public String getOrderId() {
        return orderId;
    }


    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }


    public String getItemDesc() {
        return itemDesc;
    }


    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }


    public String getItemCode() {
        return itemCode;
    }


    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }


    public boolean isPhysical() {
        return physical;
    }


    public void setPhysical(boolean physical) {
        this.physical = physical;
    }


    public String getBuyerName() {
        return buyerName;
    }


    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }


    public String getBuyerputress1() {
        return buyerputress1;
    }


    public void setBuyerputress1(String buyerputress1) {
        this.buyerputress1 = buyerputress1;
    }


    public String getBuyerputress2() {
        return buyerputress2;
    }


    public void setBuyerputress2(String buyerputress2) {
        this.buyerputress2 = buyerputress2;
    }


    public String getBuyerCity() {
        return buyerCity;
    }


    public void setBuyerCity(String buyerCity) {
        this.buyerCity = buyerCity;
    }


    public String getBuyerState() {
        return buyerState;
    }


    public void setBuyerState(String buyerState) {
        this.buyerState = buyerState;
    }


    public String getBuyerZip() {
        return buyerZip;
    }


    public void setBuyerZip(String buyerZip) {
        this.buyerZip = buyerZip;
    }


    public String getBuyerCountry() {
        return buyerCountry;
    }


    public void setBuyerCountry(String buyerCountry) {
        this.buyerCountry = buyerCountry;
    }


    public String getBuyerEmail() {
        return buyerEmail;
    }


    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }


    public String getBuyerPhone() {
        return buyerPhone;
    }


    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }


    public Map<String, String> getParams() {
        Map<String, String> params = new HashMap<String, String>();

        params.put("physical", String.valueOf(this.physical));
        params.put("fullNotifications", String.valueOf(this.fullNotifications));

        if (this.notificationURL != null) {
            params.put("notificationURL", this.notificationURL);
        }
        if (this.transactionSpeed != null) {
            params.put("transactionSpeed", this.transactionSpeed);
        }
        if (this.posData != null) {
            params.put("posData", this.posData);
        }
        if (this.notificationEmail != null) {
            params.put("notificationEmail", this.notificationEmail);
        }
        if (this.redirectURL != null) {
            params.put("redirectURL", this.redirectURL);
        }
        if (this.orderId != null) {
            params.put("orderID", this.orderId);
        }
        if (this.itemDesc != null) {
            params.put("itemDesc", this.itemDesc);
        }
        if (this.itemCode != null) {
            params.put("itemCode", this.itemCode);
        }
        if (this.buyerName != null) {
            params.put("buyerName", this.buyerName);
        }
        if (this.buyerputress1 != null) {
            params.put("buyerputress1", this.buyerputress1);
        }
        if (this.buyerputress2 != null) {
            params.put("buyerputress2", this.buyerputress2);
        }
        if (this.buyerCity != null) {
            params.put("buyerCity", this.buyerCity);
        }
        if (this.buyerState != null) {
            params.put("buyerState", this.buyerState);
        }
        if (this.buyerZip != null) {
            params.put("buyerZip", this.buyerZip);
        }
        if (this.buyerCountry != null) {
            params.put("buyerCountry", this.buyerCountry);
        }
        if (this.buyerEmail != null) {
            params.put("buyerEmail", this.buyerEmail);
        }
        if (this.buyerPhone != null) {
            params.put("buyerPhone", this.buyerPhone);
        }
        return params;
    }

}
