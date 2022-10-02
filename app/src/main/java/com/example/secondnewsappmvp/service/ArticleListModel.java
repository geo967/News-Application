package com.example.secondnewsappmvp.service;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.secondnewsappmvp.contract.ArticleListContract;
import com.example.secondnewsappmvp.model.ArticlesItem;
import com.example.secondnewsappmvp.model.Response;
import com.example.secondnewsappmvp.network.ApiClient;
import com.example.secondnewsappmvp.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class ArticleListModel implements ArticleListContract.Model {

    private final String TAG = "Article List Model";
    private final int pageNo = 1;

    @Override
    public void getMovieList(final OnFinishedListener onFinishedListener, int pageNo) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Response> call = apiService.getPopularMovies();

        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(@NonNull Call<Response> call, @NonNull retrofit2.Response<Response> response) {
                assert response.body() != null;
                List<ArticlesItem> movies = response.body().getArticles();
                onFinishedListener.onFinished(movies);
            }

            @Override
            public void onFailure(@NonNull Call<Response> call, Throwable t) {
                Log.e(TAG, t.toString());
                onFinishedListener.onFailure(t);
            }
        });
    }
}