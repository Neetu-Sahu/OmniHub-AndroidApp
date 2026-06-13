package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class TwentyFourth extends AppCompatActivity {
    Button b,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_twenty_fourth);
        b=(Button) findViewById(R.id.buttonSubmitQuiz);
        b2=(Button) findViewById(R.id.buttonBack24);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(TwentyFourth.this, Question1.class);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x=new Intent(TwentyFourth.this, Fourteenth.class);
                startActivity(x);
                finish();
            }
        });

    }
}
