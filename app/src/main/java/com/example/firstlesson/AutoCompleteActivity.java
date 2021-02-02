package com.example.firstlesson;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AutoCompleteActivity extends AppCompatActivity {

    AutoCompleteTextView auto;
    MultiAutoCompleteTextView multiAuto;
    Spinner countries;
    RecyclerView cities;

    String[] cityNames = new String[]{
            "Almaty",
            "Astana",
            "Shymkent",
            "Karaganda",
            "Taraz",
            "Oskemen",
            "Petropavl",
            "Moskva",
            "Omsk",
            "Bishkek",
            "Almaty",
            "Astana",
            "Shymkent",
            "Karaganda",
            "Taraz",
            "Oskemen",
            "Petropavl",
            "Moskva",
            "Omsk",
            "Bishkek",
            "Almaty",
            "Astana",
            "Shymkent",
            "Karaganda",
            "Taraz",
            "Oskemen",
            "Petropavl",
            "Moskva",
            "Omsk",
            "Bishkek"
    };
    String[] countryList = new String[]{
            "Kazakhstan",
            "Russia",
            "Kyrgystan"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete);

        auto = findViewById(R.id.autoTextView);
        multiAuto = findViewById(R.id.multiTextView);
        countries = findViewById(R.id.spinner1);
        cities = findViewById(R.id.listView1);

        ArrayAdapter<String> countryAdapter = new ArrayAdapter<>(
                getApplicationContext(), R.layout.country_item, R.id.countryTv, countryList);
        ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(
                getApplicationContext(), R.layout.city_item, R.id.cityTv, cityNames);

        CityRecyclerAdapter recycleAdapter = new CityRecyclerAdapter(this, cityNames);

        countries.setAdapter(countryAdapter);
        cities.setAdapter(recycleAdapter);
        cities.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        auto.setAdapter(countryAdapter);
        multiAuto.setAdapter(cityAdapter);
        multiAuto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }

    class CityRecyclerAdapter extends RecyclerView.Adapter<CityRecyclerAdapter.MyViewHolder> {

        Context cont;
        String[] cityList;
        public CityRecyclerAdapter(Context context, String[] cityList) {
            cont = context;
            this.cityList = cityList;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView text;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                text = itemView.findViewById(R.id.cityTv);
            }
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(cont).inflate(R.layout.city_item, parent, false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.text.setText(cityList[position]);
        }

        @Override
        public int getItemCount() {
            return cityList.length;
        }
    }
}