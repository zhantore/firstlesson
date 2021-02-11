package com.example.firstlesson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.firstlesson.adapter.WeatherAdapter;
import com.example.firstlesson.entity.WeatherData;
import com.example.firstlesson.interfaces.WeatherAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        rv = findViewById(R.id.weatherRV);
//        WeatherAPI weatherAPI = new Retrofit.Builder()
//                .baseUrl("https://api.openweathermap.org/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(WeatherAPI.class);

        Retrofit wApi = new Retrofit.Builder().baseUrl("https://api.openweathermap.org/").addConverterFactory(GsonConverterFactory.create()).build();
        WeatherAPI weatherAPI = wApi.create(WeatherAPI.class);

        weatherAPI.getWeatherData("43.200576",
                                "76.892289",
                                "metric",
                                "hourly,daily",
                                "(your AppId)")
                .enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                WeatherAdapter adapter = new WeatherAdapter(getApplicationContext(), response.body());
                rv.setAdapter(adapter);
                rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {

            }
        });
    }
}