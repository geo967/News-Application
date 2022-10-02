package com.example.secondnewsappmvp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Response {

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