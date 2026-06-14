package com.example.loginregister;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tenth extends AppCompatActivity {
    Button b20,b21,b22,b43,b45,b46,b47;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tenth);
        b20=(Button) findViewById(R.id.button20);
        b21=(Button) findViewById(R.id.button21);
        b22=(Button) findViewById(R.id.button22);
        b43=(Button) findViewById(R.id.button43);
        b45=(Button) findViewById(R.id.button45);
        b46=(Button) findViewById(R.id.button46);
        b47=(Button) findViewById(R.id.button47);
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Tenth.this, Eleventh.class);
                startActivity(i);
                finish();
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent g=new Intent(Tenth.this, Twelfth.class);
                startActivity(g);
                finish();
            }
        });
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent h=new Intent(Tenth.this, Thirteenth.class);
                startActivity(h);
                finish();
            }
        });
        b43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent y=new Intent(Tenth.this, Ninth.class);
                startActivity(y);
                finish();
            }
        });
        b45.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Tenth.this, Twentieth.class);
                startActivity(i);
                finish();
            }
        });
        b46.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Tenth.this, TwentyFirst.class);
                startActivity(i);
                finish();
            }
        });
        b47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Tenth.this, TwentySecond.class);
                startActivity(i);
                finish();
            }
        });
    }
}