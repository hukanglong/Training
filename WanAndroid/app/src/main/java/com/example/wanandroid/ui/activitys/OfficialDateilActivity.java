package com.example.wanandroid.ui.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.wanandroid.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OfficialDateilActivity extends AppCompatActivity {

    @BindView(R.id.web_off)
    WebView mWebOff;
    @BindView(R.id.title_off)
    TextView mTitleOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_official_dateil);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");
        mTitleOff.setText(title);
        mWebOff.setWebViewClient(new WebViewClient());
        mWebOff.loadUrl(url);
    }
}
