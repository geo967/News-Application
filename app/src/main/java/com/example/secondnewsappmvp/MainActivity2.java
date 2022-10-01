package com.example.secondnewsappmvp;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String url = getIntent().getStringExtra("url");
        WebView browser = (WebView) findViewById(R.id.webview);
        browser.loadUrl(url);

        // this will enable the javascript.
        browser.getSettings().setJavaScriptEnabled(true);

        // WebViewClient allows you to handle
        // onPageFinished and override Url loading.
        browser.setWebViewClient(new WebViewClient());

    }
}