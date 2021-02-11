package com.example.firstlesson.interfaces;

import com.example.firstlesson.entity.WeatherData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherAPI {
    @GET("/data/2.5/onecall")
    Call<WeatherData> getWeatherData(@Query("lat") String lat,
                              @Query("lon") String lon,
                              @Query("units") String units,
                              @Query("exclude") String exclude,
                              @Query("appid") String appId
    );
}
