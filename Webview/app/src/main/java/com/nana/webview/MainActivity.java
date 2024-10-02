package com.nana.webview;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWebView = findViewById(R.id.webview);
        myWebView.setWebViewClient(new WebViewClient()); // Untuk membuka link di WebView
        myWebView.loadUrl("https://alphatechin.id/#:~:text=Alphatech%20solusi%20permasalahan%20teknologi%20dan%20bisnis%20Anda%20dengan");

        // Mengatur pengaturan WebView
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Mengaktifkan JavaScript
        webSettings.setDomStorageEnabled(true); // Mengaktifkan penyimpanan DOM
    }

    @Override
    public void onBackPressed() {
        if (myWebView.canGoBack()) {
            myWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}