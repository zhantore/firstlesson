package com.example.firstlesson.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.firstlesson.R;
import com.example.firstlesson.entity.WeatherData;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.MyViewHolder> {
    WeatherData weatherData;
    Context context;
    public WeatherAdapter(Context c, WeatherData weatherData) {
        this.weatherData = weatherData;
        this.context = c;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView timezone;
        TextView temp;
        TextView humidity;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            timezone = itemView.findViewById(R.id.timezoneTV);
            temp = itemView.findViewById(R.id.tempTV);
            humidity = itemView.findViewById(R.id.humidityTV);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.weather_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.timezone.setText("Город - " + weatherData.timezone);
        holder.temp.setText("Температура - " + weatherData.current.temp + " °C");
        holder.humidity.setText("Влажность - " + weatherData.current.humidity + " %");
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
