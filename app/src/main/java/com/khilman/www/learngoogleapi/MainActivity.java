package com.khilman.www.learngoogleapi;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
   Button pencarian_jalur,posindonesia,help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pencarian_jalur=findViewById(R.id.pencarian_jalur);
        posindonesia=findViewById(R.id.posindonesia);
        help=findViewById(R.id.help);

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                Toast.makeText(this, "Membutuhkan Izin Lokasi", Toast.LENGTH_SHORT).show();
            } else {

                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                        1);
            }
        } else {
            // Permission has already been granted
            Toast.makeText(this, "Izin Lokasi diberikan", Toast.LENGTH_SHORT).show();
        }


        pencarian_jalur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ojekActivity = new Intent(MainActivity.this,OjekActivity.class);
                startActivity(ojekActivity);
            }
        });
        posindonesia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutActivity = new Intent(MainActivity.this,AboutActivity.class);
                startActivity(aboutActivity);
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpActivity = new Intent(MainActivity.this,HelpActivity.class);
                startActivity(helpActivity);
            }
        });
    }

//    public void openAutoPlace(View view) {
//        startActivity(new Intent(this, PlaceAutoCompleteActivity.class));
//    }
//
//    public void openDirectionMap(View view) {
//        startActivity(new Intent(this, DirectionActivity.class));
//    }
//
//    public void openOjek(View view) {
//        startActivity(new Intent(this, OjekActivity.class));
//    }
}
