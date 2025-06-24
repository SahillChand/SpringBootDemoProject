package com.example.demo.utils;

public class UrlBuilder {

    public String urlBuilder(String metal,String currency,String weight_unit){
        return "https://goldbroker.com/api/spot-price?metal="+metal+"&currency="+currency+"&weight_unit="+weight_unit;
    }
}
