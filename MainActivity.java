package com.sohailkhan.cricketupdates;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create a layout for the app
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.BLACK); // Set background to black for hacking theme

        // Add a glowing banner on top
        TextView banner = new TextView(this);
        banner.setText("Cricket Updates by Muzzamil");
        banner.setTextSize(24);
        banner.setTextColor(Color.GREEN);
        banner.setBackgroundColor(Color.RED);
        banner.setPadding(20, 50, 20, 50);
        banner.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        banner.setShadowLayer(10, 0, 0, Color.GREEN); // Glow effect

        // Create WebView
        webView = new WebView(this);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                // Inject JavaScript to change website colors to hacking theme
                webView.loadUrl("javascript:(function() { " +
                        "document.body.style.backgroundColor = 'black'; " +
                        "document.body.style.color = 'green'; " +
                        "document.querySelectorAll('*').forEach(el => el.style.color = 'green'); " +
                        "document.querySelectorAll('a').forEach(el => el.style.color = 'red'); " +
                        "document.querySelectorAll('.ads-container, .advertisement').forEach(el => el.remove()); " +
                        "})()");
            }
        });

        webView.loadUrl("https://www.espncricinfo.com/live-cricket-score");

        // Add elements to layout
        layout.addView(banner);
        layout.addView(webView);

        // Set layout as content view
        setContentView(layout);
    }
}
