package com.example.firstlesson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.firstlesson.adapter.GalleryAdapter;

import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {

    RecyclerView galleryRV;
    ArrayList<String> pictureList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        galleryRV = findViewById(R.id.galleryRV);
        pictureList = new ArrayList<>();
        for (int i = 0; i < 140; i++) {
            pictureList.add("https://loremflickr.com/200/200/");
        }
        galleryRV.setAdapter(new GalleryAdapter(pictureList));
        galleryRV.setLayoutManager(new GridLayoutManager(getApplicationContext(), 7, RecyclerView.VERTICAL, false));
    }
}