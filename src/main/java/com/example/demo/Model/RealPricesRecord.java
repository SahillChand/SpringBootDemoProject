package com.example.demo.Model;

import java.sql.Timestamp;

public class RealPricesRecord {

    private Timestamp date;
    private String weight_unit;
    private double ask;
    private double mid;
    private double bid;
    private double value;
    private double performance;

    public RealPricesRecord() {
    }

    public RealPricesRecord(Timestamp date, String weight_unit, double ask, double mid, double bid, double value, double performance) {
        this.date = date;
        this.weight_unit = weight_unit;
        this.ask = ask;
        this.mid = mid;
        this.bid = bid;
        this.value = value;
        this.performance = performance;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getWeight_unit() {
        return weight_unit;
    }

    public void setWeight_unit(String weight_unit) {
        this.weight_unit = weight_unit;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public double getMid() {
        return mid;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getPerformance() {
        return performance;
    }

    public void setPerformance(double performance) {
        this.performance = performance;
    }
}
