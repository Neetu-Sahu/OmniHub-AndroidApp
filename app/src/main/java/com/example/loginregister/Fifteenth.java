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

public class Fifteenth extends AppCompatActivity {
    Button b38,b37,b39;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fifteenth);
        b38=(Button) findViewById(R.id.button38);
        b37=(Button) findViewById(R.id.button37);
        b39=(Button) findViewById(R.id.button39);
        b38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Fifteenth.this,Eighteenth.class);
                startActivity(i);
                finish();
            }
        });
        b37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j=new Intent(Fifteenth.this,Nineteenth.class);
                startActivity(j);
                finish();
            }
        });
        b39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k=new Intent(Fifteenth.this,Fourteenth.class);
                startActivity(k);
                finish();
            }
        });

    }
}