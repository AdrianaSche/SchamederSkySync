package com.asce.schamederskysync;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Vereinsflieger
        Button btnVereinsflieger = (Button) findViewById(R.id.vereinsflieger);
        btnVereinsflieger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vereinsflieger.de"));
                browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(browserIntent);
            }
        });


        //Wetteronline
        Button btnWetter = findViewById(R.id.btnWetter);
        btnWetter.setOnClickListener(view -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.wetteronline.de/wetter/erndtebrueck/schameder"));
            browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(browserIntent);
        });


        //Flightbook
        Button btnFlightBook = findViewById(R.id.btnFlightBook);
        btnFlightBook.setOnClickListener(view -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://flightbook.glidernet.org/logbook/EDGQ/"));
            browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(browserIntent);
        });

        //Glidertracker
        Button btnGliderTracker = findViewById(R.id.btnGliderTracker);
        btnGliderTracker.setOnClickListener(view -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://glidertracker.de/#lat=51.0011437&lon=8.3081582&z=15"));
            browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(browserIntent);
        });

    }
}
