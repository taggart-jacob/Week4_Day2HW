package com.example.week4_day2hw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class FullSizeFlickr extends AppCompatActivity {

    ImageView imgFullSizeFlickr;
    String img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_size_flickr);
        imgFullSizeFlickr = findViewById(R.id.imgFlickrLarge);
        img = getIntent().getStringExtra("String_needed");
        Log.d("TAG", img);
        Glide.with(imgFullSizeFlickr).load(img).into(imgFullSizeFlickr);

    }
}
