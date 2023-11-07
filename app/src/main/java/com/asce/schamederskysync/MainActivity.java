
package com.asce.schamederskysync;

import android.os.Bundle;
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


        Button btnVereinsflieger = findViewById(R.id.vereinsflieger);
        btnVereinsflieger.setOnLongClickListener(view -> {
            // Popup-Menü anzeigen
            PopupMenu popup = new PopupMenu(MainActivity.this, view);
            popup.getMenuInflater().inflate(R.menu.open_link_menu, popup.getMenu());
            popup.setOnMenuItemClickListener(item -> {
               int itemID= item.getItemId();

                    if(itemID == R.id.open_in_new_tab) {
                        // Link in neuem Tab öffnen
                        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                        CustomTabsIntent customTabsIntent = builder.build();
                        customTabsIntent.intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        customTabsIntent.launchUrl(MainActivity.this, Uri.parse(vereinsfliegerUrl));
                    }
                if(itemID == R.id.open_in_browser) {
                        // Link im Browser öffnen
                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(vereinsfliegerUrl));
                        startActivity(browserIntent);

                }
                return true;
            });
            popup.show();
            return true;
        });



        Button btnWetter = findViewById(R.id.btnWetter);
        btnWetter.setOnLongClickListener(view -> {
            // show popup-Menu
            PopupMenu popup = new PopupMenu(MainActivity.this, view);
            popup.getMenuInflater().inflate(R.menu.open_link_menu, popup.getMenu());
            popup.setOnMenuItemClickListener(item -> {
                int itemID= item.getItemId();

                if(itemID == R.id.open_in_new_tab) {
                    // open link in new tab
                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    CustomTabsIntent customTabsIntent = builder.build();
                    customTabsIntent.intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    customTabsIntent.launchUrl(MainActivity.this, Uri.parse(wetterUrl));
                }
                if(itemID == R.id.open_in_browser) {
                    // open link in browser
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(wetterUrl));
                    startActivity(browserIntent);

                }
                return true;
            });
            popup.show();
            return true;
        });

        Button btnFlightBook = findViewById(R.id.btnFlightBook);
        btnFlightBook.setOnLongClickListener(view -> {
            // show popup-Menu
            PopupMenu popup = new PopupMenu(MainActivity.this, view);
            popup.getMenuInflater().inflate(R.menu.open_link_menu, popup.getMenu());
            popup.setOnMenuItemClickListener(item -> {
                int itemID= item.getItemId();

                if(itemID == R.id.open_in_new_tab) {
                    // open link in new tab
                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    CustomTabsIntent customTabsIntent = builder.build();
                    customTabsIntent.intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    customTabsIntent.launchUrl(MainActivity.this, Uri.parse(flightBookUrl));
                }
                if(itemID == R.id.open_in_browser) {
                    // open link in browser
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(flightBookUrl));
                    startActivity(browserIntent);

                }
                return true;
            });
            popup.show();
            return true;
        });

        Button btnGliderTracker = findViewById(R.id.btnGliderTracker);
        btnGliderTracker.setOnLongClickListener(view -> {
            // show popup-Menu
            PopupMenu popup = new PopupMenu(MainActivity.this, view);
            popup.getMenuInflater().inflate(R.menu.open_link_menu, popup.getMenu());
            popup.setOnMenuItemClickListener(item -> {
                int itemID= item.getItemId();

                if(itemID == R.id.open_in_new_tab) {
                    // open link in new tab
                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    CustomTabsIntent customTabsIntent = builder.build();
                    customTabsIntent.intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    customTabsIntent.launchUrl(MainActivity.this, Uri.parse(gliderTrackerUrl));
                }
                if(itemID == R.id.open_in_browser) {
                    // open link in browser
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(gliderTrackerUrl));
                    startActivity(browserIntent);

                }
                return true;
            });
            popup.show();
            return true;
        });

    }


        public static void openCustomTab(MainActivity activity, CustomTabsIntent customTabsIntent, Uri uri) {
            // package name is the default package
            // for our custom chrome tab
            String packageName = "com.android.chrome";
            if (packageName != null) {

                // we are checking if the package name is not null
                // if package name is not null then we are calling
                // that custom chrome tab with intent by passing its
                // package name.
                customTabsIntent.intent.setPackage(packageName);

                // in that custom tab intent we are passing
                // our url which we have to browse.
                customTabsIntent.launchUrl(activity, uri);
            } else {
                // if the custom tabs fails to load then we are simply
                // redirecting our user to users device default browser.
                activity.startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        }
    }

