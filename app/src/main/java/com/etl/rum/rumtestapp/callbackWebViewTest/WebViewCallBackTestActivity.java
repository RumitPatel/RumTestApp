package com.etl.rum.rumtestapp.callbackWebViewTest;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.etl.rum.rumtestapp.R;

/**
 * Created by FatehAli Asamadi on 1/12/2018.
 * WebViewCallBackTestActivity
 */

public class WebViewCallBackTestActivity extends AppCompatActivity {

    private Context mContext;

    private WebView webView;
    private Button btnStart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_callback_test);

        initComponents();
    }

    private void initComponents() {
        mContext = this;

        btnStart = findViewById(R.id.btn_click_here);
        webView = findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new WebAppInterface(this), "Android");

        setListeners();
    }

    private void setListeners() {
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadWebView();
            }
        });

        webView.setWebViewClient(new WebViewClient() {

            public void onPageFinished(WebView view, String url) {
                Toast.makeText(mContext, "onPageFinished, url = " + url, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                Toast.makeText(mContext, "onPageStarted, url = " + url, Toast.LENGTH_SHORT).show();
                super.onPageStarted(view, url, favicon);
            }


            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String urlNewString) {


                Toast.makeText(mContext, "shouldOverrideUrlLoading, urlNewString = " + urlNewString, Toast.LENGTH_SHORT).show();
                webView.loadUrl(urlNewString);
                return true;
            }
        });
    }

    private void loadWebView() {
//        webView.loadUrl("http://blog.emedstore.in/New/");
        webView.loadUrl("http://onlinepharmacyapp.com/test.html");
    }

    public class WebAppInterface {
        Context mContext;

        /** Instantiate the interface and set the context */
        WebAppInterface(Context c) {
            mContext = c;
        }

        /** Show a toast from the web page */
        @JavascriptInterface
        public void showToast(String toast) {
            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
        }
    }
}