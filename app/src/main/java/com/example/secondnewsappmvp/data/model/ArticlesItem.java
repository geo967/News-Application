package com.example.secondnewsappmvp.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * ArticlesItem class represents the model for API Articles it contains
 *
 * @Param publishedAt denotes the time at which news  is publish
 * @Param author denotes the author of news
 * @Param urlToImage denotes the news image main url
 * @Param description denotes the short description of news
 * @Param source denotes the source of news
 * @Param title denotes the main heading of news
 * @Param url denotes the url to external site
 * @Param content denotes the full content with rest no of characters in content available
 */

public class ArticlesItem {

    @SerializedName("publishedAt")
    private String publishedAt;

    @SerializedName("author")
    private String author;

    @SerializedName("urlToImage")
    private String urlToImage;

    @SerializedName("description")
    private String description;

    @SerializedName("source")
    private Source source;

    @SerializedName("title")
    private String title;

    @SerializedName("url")
    private String url;

    @SerializedName("content")
    private String content;

    public String getPublishedAt() {
        return publishedAt;
    }

    public String getAuthor() {
        return author;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getDescription() {
        return description;
    }

    public Source getSource() {
        return source;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getContent() {
        return content;
    }
}