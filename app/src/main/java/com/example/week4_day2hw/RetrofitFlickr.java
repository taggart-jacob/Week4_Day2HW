package com.example.week4_day2hw;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class RetrofitFlickr {

    //COME BACK TO THIS IF THERE ARE ISSUES
    public static final String BASE_URL = "https://api.flickr.com/";

    public Retrofit getRetroFitInstance(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)).build();

        return new Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public FlickrApiService getService(){
        return getRetroFitInstance().create(FlickrApiService.class);
    }

    public interface FlickrApiService{
        @GET
        Call<FlickrObject> getFlickrObject(@Url String api_url);
    }
}
