package com.example.wanandroid.ui.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.wanandroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeDateilActivity extends AppCompatActivity {

    @BindView(R.id.web)
    WebView mWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_dateil);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        mWeb.loadUrl(url);
        mWeb.setWebViewClient(new WebViewClient());
    }
}
