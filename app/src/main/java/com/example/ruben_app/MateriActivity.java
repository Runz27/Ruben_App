package com.example.ruben_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MateriActivity extends AppCompatActivity {
    CardView networking;
    CardView sms;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);

        networking = findViewById(R.id.networking);
        sms = findViewById(R.id.sms);

        networking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MateriActivity.this, Networking.class);
                startActivity(i);

            }
        });

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MateriActivity.this, SmsActivity.class);
                startActivity(i);
            }
        });
    }
}
