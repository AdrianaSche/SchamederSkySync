package com.asce.schamederskysync;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    String vereinsfliegerUrl = "http://www.vereinsflieger.de";
    String wetterUrl = "https://www.wetteronline.de/wetter/erndtebrueck/schameder";
    String flightBookUrl = "https://flightbook.glidernet.org/logbook/EDGQ/";
    String gliderTrackerUrl = "https://glidertracker.de/#lat=51.0011437&lon=8.3081582&z=15";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);
        setupWebView();

        setupButtonWithClickListener(R.id.vereinsflieger, vereinsfliegerUrl);
        setupButtonWithClickListener(R.id.btnWetter, wetterUrl);
        setupButtonWithClickListener(R.id.btnFlightBook, flightBookUrl);
        setupButtonWithClickListener(R.id.btnGliderTracker, gliderTrackerUrl);
    }

    private void setupButtonWithClickListener(int buttonId, String url) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(view -> openInWebView(url));
    }

    private void setupWebView() {
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.clearCache(true);

    }

    private void openInWebView(String url) {
        webView.loadUrl(url);
        webView.setVisibility(View.VISIBLE);
        webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
    }

    // Überschreiben Sie onBackPressed, um WebView-Navigation zu ermöglichen
    @Override
    public void onBackPressed() {
        if (webView.getVisibility() == View.VISIBLE && webView.canGoBack()) {
            webView.goBack();
        } else if (webView.getVisibility() == View.VISIBLE) {
            webView.setVisibility(View.GONE);
        } else {
            super.onBackPressed();
        }
    }
}
