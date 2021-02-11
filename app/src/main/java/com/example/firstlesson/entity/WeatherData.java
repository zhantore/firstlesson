package com.example.firstlesson.entity;

import com.google.gson.annotations.SerializedName;

public class WeatherData {
    @SerializedName("timezone")
    public String timezone;

    @SerializedName("current")
    public CurrentWeather current;
}
