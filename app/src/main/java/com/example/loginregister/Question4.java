package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Question4 extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    Button b54;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_question4);
        r1=(RadioButton) findViewById(R.id.rb4_1);
        r2=(RadioButton) findViewById(R.id.rb4_2);
        r3=(RadioButton) findViewById(R.id.rb4_3);
        r4=(RadioButton) findViewById(R.id.rb4_4);
        b54=(Button) findViewById(R.id.button54);
        b54.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(r4.isChecked())
                {
                    ++Question1.score;
                }
                else
                {
                    --Question1.score;
                }
                Intent i=new Intent(Question4.this, Question5.class);
                startActivity(i);
                finish();
            }
        });
    }
}