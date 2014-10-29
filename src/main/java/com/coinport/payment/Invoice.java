package com.coinport.payment;

public class Invoice {
    private String id;
    private String url;
    private String status;
    private double price;
    private String currency;
    private double btcPrice;
    private long invoiceTime;
    private long expirationTime;
    private long invalidTime;
    private long updateTime;
    private long currentTime;
    private String paymentAddress;
    private double displayPrice;
    private String displayCurrency;
    private String btcShouldPay;
    private String merchantName;
    private double rate;
    private String posData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBtcPrice() {
        return btcPrice;
    }

    public void setBtcPrice(double btcPrice) {
        this.btcPrice = btcPrice;
    }

    public long getInvoiceTime() {
        return invoiceTime;
    }

    public void setInvoiceTime(long invoiceTime) {
        this.invoiceTime = invoiceTime;
    }

    public long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public String getPostData() {
        return posData;
    }

    public void setPosData(String posData) {
        this.posData = posData;
    }

    public long getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(long invalidTime) {
        this.invalidTime = invalidTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getPaymentAddress() {
        return paymentAddress;
    }

    public void setPaymentAddress(String paymentAddress) {
        this.paymentAddress = paymentAddress;
    }

    public double getDisplayPrice() {
        return displayPrice;
    }

    public void setDisplayPrice(double displayPrice) {
        this.displayPrice = displayPrice;
    }

    public String getDisplayCurrency() {
        return displayCurrency;
    }

    public void setDisplayCurrency(String displayCurrency) {
        this.displayCurrency = displayCurrency;
    }

    public String getBtcShouldPay() {
        return btcShouldPay;
    }

    public void setBtcShouldPay(String btcShouldPay) {
        this.btcShouldPay = btcShouldPay;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getPosData() {
        return posData;
    }

    @Override
    public String toString() {
        return getId() + ", " + getUrl() + ", " + getStatus() + ", " + getPrice() + ", " + getCurrency() + ", " + getBtcPrice() + ", " + getInvoiceTime() + ", " + getExpirationTime() + ", " + getCurrentTime() + ", " + getPostData();
    }
}
