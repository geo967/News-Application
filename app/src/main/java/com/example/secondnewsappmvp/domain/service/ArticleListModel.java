package com.example.secondnewsappmvp.domain.service;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.secondnewsappmvp.data.model.ArticlesItem;
import com.example.secondnewsappmvp.data.response.APIResponse;
import com.example.secondnewsappmvp.domain.contract.ArticleListContract;
import com.example.secondnewsappmvp.domain.network.ApiClient;
import com.example.secondnewsappmvp.domain.network.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class ArticleListModel implements ArticleListContract.Model {

    private final String TAG = "Article List Model";
    private final int pageNo = 1;

    /**
     * Fetch the response from the api and assign to the list of articles
     *
     * @param onFinishedListener callback when api fetch is completed
     * @param pageNo             fetch the current page number
     */
    @Override
    public void getMovieList(final OnFinishedListener onFinishedListener, int pageNo) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<APIResponse> call = apiService.getLatestNews();

        call.enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(@NonNull Call<APIResponse> call, @NonNull retrofit2.Response<APIResponse> response) {
                assert response.body() != null;
                List<ArticlesItem> articles = response.body().getArticles();
                onFinishedListener.onFinished(articles);
            }

            @Override
            public void onFailure(@NonNull Call<APIResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
                onFinishedListener.onFailure(t);
            }
        });
    }
}