package com.example.ruben_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.MapsInitializer;

public class Home2 extends AppCompatActivity {
    CardView home;
    CardView maps;
    CardView materi;
    CardView about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        home = (CardView) findViewById(R.id.home);
        maps = (CardView) findViewById(R.id.maps);
        materi = (CardView) findViewById(R.id.materi);
        about = (CardView) findViewById(R.id.about);


        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home2.this, MapsActivity.class);
                startActivity(i);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home2.this, Home.class);
                startActivity(i);
            }
        });

        materi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Home2.this, MateriActivity.class);
                startActivity(i);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(Home2.this, AbooutActivity.class);
                startActivity(i);

            }
        });


    }
}