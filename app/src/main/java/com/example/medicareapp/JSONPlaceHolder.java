package com.example.medicareapp;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceHolder {

    @GET("feeds.json?results=2")
    Call<Feeds> getFeeds();
}


