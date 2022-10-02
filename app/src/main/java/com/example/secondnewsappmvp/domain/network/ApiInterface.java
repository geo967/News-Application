package com.example.secondnewsappmvp.domain.network;

import com.example.secondnewsappmvp.data.response.APIResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Contains the api end point and call the response from data model to get
 * the latest news
 */

public interface ApiInterface {

    @GET("Android/news-api-feed/staticResponse.json")
    Call<APIResponse> getLatestNews();

}
