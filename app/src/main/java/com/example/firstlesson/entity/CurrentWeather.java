package com.example.firstlesson.entity;

import com.google.gson.annotations.SerializedName;

public class CurrentWeather {
    @SerializedName("temp")
    public String temp;
    @SerializedName("humidity")
    public String humidity;
}
