package com.example.demo.Model;

import java.sql.Timestamp;

public class RealPrices {

    private Timestamp date;
    private String weight_unit;
    private Double ask;
    private Double mid;
    private Double bid;
    private Double value;
    private Double performance;

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

    public Double getAsk() {
        return ask;
    }

    public void setAsk(Double ask) {
        this.ask = ask;
    }

    public Double getMid() {
        return mid;
    }

    public void setMid(Double mid) {
        this.mid = mid;
    }

    public Double getBid() {
        return bid;
    }

    public void setBid(Double bid) {
        this.bid = bid;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getPerformance() {
        return performance;
    }

    public void setPerformance(Double performance) {
        this.performance = performance;
    }

    public String toString(){
        return "date:"+this.date+"\n"+"weight_unit:"+this.weight_unit+"\n"+"ask:"+this.ask+"\n"+"mid:"+this.mid+"\n"+"bid:"+this.bid+"\n"+"value:"+this.value+"\n"+"performance:"+this.performance;
    }
}
