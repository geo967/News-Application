package com.example.secondnewsappmvp;

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
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.secondnewsappmvp.contract.ArticleListContract;
import com.example.secondnewsappmvp.model.ArticlesItem;
import com.example.secondnewsappmvp.presenter.ArticlesPresenter;
import com.example.secondnewsappmvp.view.ArticleListAdapter;
import com.example.secondnewsappmvp.view.RecyclerViewInterface;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ArticleListContract.View, RecyclerViewInterface {

    private RecyclerView rvMovieList;
    private List<ArticlesItem> movieList;
    private ProgressBar pbLoading;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMovieList = findViewById(R.id.rvMovieList);
        pbLoading = findViewById(R.id.pbLoading);

        movieList = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvMovieList.setLayoutManager(layoutManager);
        rvMovieList.setHasFixedSize(true);

        ArticlesPresenter moviePresenter = new ArticlesPresenter(this);
        moviePresenter.requestDataFromServer();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.item1:
                Toast.makeText(getApplicationContext(), "Item 1 Selected", Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(), "Item 2 Selected", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void showProgress() {
        pbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        pbLoading.setVisibility(View.GONE);
    }

    @Override
    public void setDataToRecyclerview(List<ArticlesItem> movieListArray) {

        movieList.addAll(movieListArray);
        ArticleListAdapter movieListAdapter = new ArticleListAdapter(movieList, MainActivity.this, this);
        rvMovieList.setAdapter(movieListAdapter);

    }

    @Override
    public void onResponseFailure(Throwable throwable) {

        Log.e("ERROR:", throwable.getMessage());
        Toast.makeText(MainActivity.this, "Error in getting data", Toast.LENGTH_LONG).show();

    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("url", movieList.get(position).getUrl());
        startActivity(intent);
    }
}