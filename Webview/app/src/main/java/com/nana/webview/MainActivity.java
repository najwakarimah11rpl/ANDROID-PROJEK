package com.nana.webview;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient()); // Menghindari membuka browser eksternal
        webView.loadUrl("https://glints.com/id/companies/pt-alpha-tech-indonesiana/5b614c8b-92fb-4c0e-a8b4-49c9fb729f8a"); // Ganti dengan URL yang diinginkan
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
