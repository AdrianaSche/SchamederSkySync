package com.asce.schamederskysync;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

public class MainActivity extends AppCompatActivity {

    String vereinsfliegerUrl = "http://www.vereinsflieger.de";
    String wetterUrl = "https://www.wetteronline.de/wetter/erndtebrueck/schameder";
    String flightBookUrl = "https://flightbook.glidernet.org/logbook/EDGQ/";
    String gliderTrackerUrl = "https://glidertracker.de/#lat=51.0011437&lon=8.3081582&z=15";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButtonWithClickListener(R.id.vereinsflieger, vereinsfliegerUrl);
        setupButtonWithClickListener(R.id.btnWetter, wetterUrl);
        setupButtonWithClickListener(R.id.btnFlightBook, flightBookUrl);
        setupButtonWithClickListener(R.id.btnGliderTracker, gliderTrackerUrl);
    }

    private void setupButtonWithClickListener(int buttonId, String url) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(item -> {
            openCustomTab(url);
        });
    }

    private void openCustomTab(String url) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();

        // try to open Custom Tabs
        if (customTabsIntent.intent.resolveActivity(getPackageManager()) != null) {
            customTabsIntent.intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            customTabsIntent.launchUrl(MainActivity.this, Uri.parse(url));
        } else {
            // Fallback: open Link in Webbrowser
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(browserIntent);
        }
    }

    @Override
    public void onBackPressed() {

    }


}
