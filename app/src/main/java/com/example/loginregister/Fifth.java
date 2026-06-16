package com.example.loginregister;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;

public class Fifth extends AppCompatActivity {
    EditText e3,e4;
    TextView t2;
    Button b11,b12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fifth);
        e3=(EditText) findViewById(R.id.editTextText3);
        e4=(EditText) findViewById(R.id.editTextText4);
        e4.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        b11=(Button) findViewById(R.id.button11);
        b12=(Button) findViewById(R.id.button12);
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent g=new Intent(Fifth.this, Second.class);
                startActivity(g);
                finish();
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e3.getText().toString();
                String s2=e4.getText().toString();
                if(s1.isEmpty()||s2.isEmpty()){
                    Toast.makeText(Fifth.this, "please fill all", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    SQLiteDatabase data=openOrCreateDatabase("srms",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists student (email varchar,password varchar)");
                    String s3="select * from student where (email='"+s1+"' and password='"+s2+"')";
                    Cursor cursor=data.rawQuery(s3,null);
                    if(cursor.getCount()>0){
                        Toast.makeText(Fifth.this, "offline login done", Toast.LENGTH_SHORT).show();
                        Intent g=new Intent(Fifth.this, Eight.class);
                        startActivity(g);
                        finish();
                    }
                    else {
                        Toast.makeText(Fifth.this, "invalid credentials", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

    }
}