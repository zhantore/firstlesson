package com.example.firstlesson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailedActivity extends AppCompatActivity {

    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        resultText = findViewById(R.id.tvResult);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            resultText.setText(b.getString("Fullname"));
        }
    }
}