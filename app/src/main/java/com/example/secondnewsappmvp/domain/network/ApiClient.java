package com.example.secondnewsappmvp.domain.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ApiClient to call the api using 3rd party retrofit library
 * <p>
 * contains base url of the remote api
 *
 * @Function getClient to return the retrofit instance
 */

public class ApiClient {

    public static final String BASE_URL = "https://candidate-test-data-moengage.s3.amazonaws.com/";
    public static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
