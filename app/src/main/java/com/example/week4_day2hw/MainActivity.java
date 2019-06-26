package com.example.week4_day2hw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvFlickr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvFlickr = findViewById(R.id.rvFlickr);

        RetrofitFlickr retrofitFlickr = new RetrofitFlickr();
        retrofitFlickr.getService().getFlickrObject("https://api.flickr.com/services/feeds/photos_public.gne?tag=kitten&format=json&nojsoncallback=1").enqueue(new Callback<FlickrObject>() {
            @Override
            public void onResponse(Call<FlickrObject> call, Response<FlickrObject> response) {
                FlickrObject flickrObject = response.body();
                populateRVFlickr(flickrObject);
            }

            @Override
            public void onFailure(Call<FlickrObject> call, Throwable t) {
                Log.e("TAG", t.getMessage());
            }
        });
    }

    private void populateRVFlickr(FlickrObject flickrObj){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        FlickrRVAdapter flickrRVAdapter = new FlickrRVAdapter(flickrObj.getItems());
        rvFlickr.setLayoutManager(layoutManager);
        rvFlickr.setAdapter(flickrRVAdapter);
    }
}
