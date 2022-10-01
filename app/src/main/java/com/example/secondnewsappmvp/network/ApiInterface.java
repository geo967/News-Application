package com.example.secondnewsappmvp.network;

import com.example.secondnewsappmvp.model.Response;

import retrofit2.Call;

import retrofit2.http.GET;

public interface ApiInterface {

    @GET("Android/news-api-feed/staticResponse.json")
    Call<Response> getPopularMovies();

}
