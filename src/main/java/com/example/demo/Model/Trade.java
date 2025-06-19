package com.example.demo.Model;


public class Trade {

    private String asset;
    private String weight_unit;
    private Double amount;
    private String currency;

    public Trade() {
    }

    public Trade(String asset, Double amount, String weight_unit, String currency) {
        this.asset = asset;
        this.amount = amount;
        this.weight_unit = weight_unit;
        this.currency = currency;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getWeight_unit() {
        return weight_unit;
    }

    public void setWeight_unit(String weight_unit) {
        this.weight_unit = weight_unit;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
