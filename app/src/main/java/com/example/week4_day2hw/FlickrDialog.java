package com.example.week4_day2hw;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class FlickrDialog extends AppCompatActivity {

    ImageView imgFlickrSmall;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        imgFlickrSmall = findViewById(R.id.imgFlickrSmall);
        // Get the layout inflater
        LayoutInflater inflater = getLayoutInflater();
        setContentView(inflater.inflate(R.layout.dialog_flickr, null));
    }

    public void onClickFull(View view) {
        startActivity(new Intent(view.getContext(), FullSizeFlickr.class));
    }

    public void onClickSmall(View view) {
        imgFlickrSmall.setVisibility(View.VISIBLE);
    }

}
