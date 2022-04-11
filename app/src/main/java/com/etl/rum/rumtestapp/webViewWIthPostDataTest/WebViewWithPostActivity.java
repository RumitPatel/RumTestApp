package com.etl.rum.rumtestapp.webViewWIthPostDataTest;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.etl.rum.rumtestapp.R;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by FatehAli Asamadi on 1/30/2018.
 * WebViewWithPostActivity
 */

public class WebViewWithPostActivity extends AppCompatActivity {

    private Context mContext;

    private WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_with_post);

        initComponents();
        setListeners();
    }

    private void initComponents() {
        mContext = this;
        mWebView = findViewById(R.id.web_view);
    }

    private void setListeners() {
        findViewById(R.id.btnClickHere).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadUrlToWebView("9978084284", "111111");
            }
        });


        mWebView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // do your handling codes here, which url is the requested url
                // probably you need to open that url rather than redirect:
                Toast.makeText(mContext, "shouldOverrideUrlLoading", Toast.LENGTH_SHORT).show();
                view.loadUrl(url);
                return false; // then it is not handled by default action
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Toast.makeText(mContext, "onPageStarted", Toast.LENGTH_SHORT).show();
                super.onPageStarted(view, url, favicon);
            }
        });

    }

    private void loadUrlToWebView(String userName, String password) {
//        String url = "http://apnadawabazar.com/doctor_anytimehealthcare/index.php/welcome/index_blog";
        String url = "http://apnadawabazar.com/doctor_anytimehealthcare/index.php/welcome/blog_login";

        String postData = null;
        try {
            postData = "username=" + URLEncoder.encode(userName, "UTF-8") +
                    "&password=" + URLEncoder.encode(password, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        if (postData != null) {
            mWebView.postUrl(url, postData.getBytes());
        }

    }
}