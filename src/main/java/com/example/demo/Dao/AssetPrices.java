package com.example.demo.Dao;

import java.sql.Time;
import java.sql.Timestamp;

public class AssetPrices {
    private String asset;
    private Double ask;
    private Double bid;
    private String weight_unit;
    private Timestamp last_updated;

    public AssetPrices() {
    }

    public AssetPrices(String asset, Double ask, Double bid,  String weight_unit, Timestamp last_updated) {
        this.asset = asset;
        this.ask = ask;
        this.bid = bid;
        this.last_updated = last_updated;
        this.weight_unit = weight_unit;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public String getWeight_unit() {
        return weight_unit;
    }

    public void setWeight_unit(String weight_unit) {
        this.weight_unit = weight_unit;
    }

    public Timestamp getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(Timestamp last_updated) {
        this.last_updated = last_updated;
    }
}
