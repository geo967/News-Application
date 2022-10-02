package com.example.secondnewsappmvp.view.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.secondnewsappmvp.R;

public class WebViewActivity extends AppCompatActivity {

    ProgressBar webViewProgressBar;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webViewProgressBar = findViewById(R.id.webViewLoading);
        webViewProgressBar.setVisibility(View.VISIBLE);

        String url = getIntent().getStringExtra("url");
        WebView browser = (WebView) findViewById(R.id.webview);
        browser.loadUrl(url);

        // this will enable the javascript.
        browser.getSettings().setJavaScriptEnabled(true);

        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        browser.setWebViewClient(new WebViewClient());
        webViewProgressBar.setVisibility(View.GONE);
    }
}