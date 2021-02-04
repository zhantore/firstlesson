package com.example.firstlesson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class DetailedActivity extends AppCompatActivity {

    TextView resultText;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        resultText = findViewById(R.id.tvResult);
        sharedPreferences = new SharedFiles(getApplicationContext()).getSharedPreferences();

        String dateTime = sharedPreferences.getString("date_time", "");
        resultText.setText(dateTime);

        /*
        Bundle b = getIntent().getExtras();
        if (b != null) {
            resultText.setText(b.getString("Fullname"));
        }*/
    }
}