package com.example.loginregister;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class TwentyFirst extends AppCompatActivity {
    Button bVibrate, bBack;
    Vibrator v1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_twenty_first);

        bVibrate = findViewById(R.id.buttonVibrate);
        bBack = findViewById(R.id.buttonBack21);
        v1 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        bVibrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v1.vibrate(500); // Vibrate for 500 milliseconds
            }
        });

        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TwentyFirst.this, Tenth.class);
                startActivity(i);
                finish();
            }
        });
    }
}
