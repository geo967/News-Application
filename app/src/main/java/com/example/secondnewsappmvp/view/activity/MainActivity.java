package com.example.secondnewsappmvp.view.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.secondnewsappmvp.R;
import com.example.secondnewsappmvp.data.model.ArticlesItem;
import com.example.secondnewsappmvp.domain.contract.ArticleListContract;
import com.example.secondnewsappmvp.domain.presenter.ArticlesPresenter;
import com.example.secondnewsappmvp.view.adapter.ArticleListAdapter;
import com.example.secondnewsappmvp.view.adapter.RecyclerViewInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends
        AppCompatActivity implements
        ArticleListContract.View, RecyclerViewInterface {

    ArticleListAdapter articleListAdapter;
    boolean onClickedMenuIcon = false;
    boolean onClickedOldToNew = false;
    boolean onClickedNewToOld = false;
    private RecyclerView articleRecyclerView;
    private List<ArticlesItem> articleItems;
    private ProgressBar articleLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        articleRecyclerView = findViewById(R.id.articleListRecyclerView);
        articleLoading = findViewById(R.id.recyclerViewLoading);

        articleItems = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        articleRecyclerView.setLayoutManager(layoutManager);
        articleRecyclerView.setHasFixedSize(true);

        ArticlesPresenter moviePresenter = new ArticlesPresenter(this);
        moviePresenter.requestDataFromServer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (!onClickedMenuIcon) {
            Collections.sort(articleItems, new Comparator<ArticlesItem>() {
                @Override
                public int compare(ArticlesItem articlesItem, ArticlesItem t1) {
                    return articlesItem.getPublishedAt().compareToIgnoreCase(t1.getPublishedAt());
                }
            });
            onClickedMenuIcon = true;
        }
        switch (id) {
            case R.id.item1:
                if (!onClickedOldToNew) {
                    Toast.makeText(getApplicationContext(), "Old to New", Toast.LENGTH_LONG).show();
                    Collections.reverse(articleItems);
                    setDataToRecyclerview(articleItems);
                    onClickedOldToNew = true;
                    onClickedNewToOld = false;
                    return true;
                }
            case R.id.item2:
                if (!onClickedNewToOld) {
                    Toast.makeText(getApplicationContext(), "New to Old", Toast.LENGTH_LONG).show();
                    Collections.reverse(articleItems);
                    setDataToRecyclerview(articleItems);
                    onClickedNewToOld = true;
                    onClickedOldToNew = false;
                    return true;
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showProgress() {
        articleLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        articleLoading.setVisibility(View.GONE);
    }

    @Override
    public void setDataToRecyclerview(List<ArticlesItem> articleItemsArray) {

        articleItems.addAll(articleItemsArray);
        articleListAdapter = new ArticleListAdapter(articleItems, MainActivity.this, this);
        articleRecyclerView.setAdapter(articleListAdapter);
        articleListAdapter.notifyDataSetChanged();

    }

    @Override
    public void onResponseFailure(Throwable throwable) {
        Log.e("ERROR:", throwable.getMessage());
        Toast.makeText(MainActivity.this, "Error in getting data", Toast.LENGTH_LONG).show();
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
        intent.putExtra("url", articleItems.get(position).getUrl());
        startActivity(intent);
    }
}