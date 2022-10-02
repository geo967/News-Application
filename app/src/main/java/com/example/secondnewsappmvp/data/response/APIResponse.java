package com.example.secondnewsappmvp.data.response;

import com.example.secondnewsappmvp.data.model.ArticlesItem;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * APIResponse class contains the full details of the article
 *
 * @Param List<ArticleItem> denotes the list of articles of news to display in recycler view
 * @Param status denotes the status of the news
 */

public class APIResponse {

    @SerializedName("articles")
    private List<ArticlesItem> articles;

    @SerializedName("status")
    private String status;

    public List<ArticlesItem> getArticles() {
        return articles;
    }

    public String getStatus() {
        return status;
    }
}