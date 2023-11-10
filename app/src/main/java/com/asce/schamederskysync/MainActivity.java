package com.asce.schamederskysync;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
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

        setupButtonWithLongClickListener(R.id.vereinsflieger, vereinsfliegerUrl);
        setupButtonWithLongClickListener(R.id.btnWetter, wetterUrl);
        setupButtonWithLongClickListener(R.id.btnFlightBook, flightBookUrl);
        setupButtonWithLongClickListener(R.id.btnGliderTracker, gliderTrackerUrl);
    }

    private void setupButtonWithLongClickListener(int buttonId, String url) {
        Button button = findViewById(buttonId);
        button.setOnLongClickListener(view -> {
            showPopupMenu(view, url);
            return true;
        });
    }

    private void showPopupMenu(View view, String url) {
        PopupMenu popup = new PopupMenu(MainActivity.this, view);
        popup.getMenuInflater().inflate(R.menu.open_link_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(item -> {
            if(item.getItemId() == R.id.open_in_new_tab) {
                openCustomTab(url);
            }else {
                openInBrowser(url);
            }
            return true;
        });
        popup.show();
    }

    private void openCustomTab(String url) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        customTabsIntent.launchUrl(MainActivity.this, Uri.parse(url));
    }

    private void openInBrowser(String url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }
}
