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

public class Seventh extends AppCompatActivity {
    EditText e7,e8;
    Button b15,b16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_seventh);
        e7=(EditText) findViewById(R.id.editTextText7);
        e8=(EditText) findViewById(R.id.editTextText8);
        e8.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        b15=(Button) findViewById(R.id.button15);
        b16=(Button) findViewById(R.id.button16);
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent h=new Intent(Seventh.this,Third.class);
                startActivity(h);
                finish();
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=e7.getText().toString();
                String s2=e8.getText().toString();
                if(s1.isEmpty()||s2.isEmpty()){
                    Toast.makeText(Seventh.this, "please fill all", Toast.LENGTH_SHORT).show();
                }
                else{
                    SQLiteDatabase data=openOrCreateDatabase("srms",MODE_PRIVATE,null);
                    data.execSQL("create table if not exists student (email varchar,password varchar)");
                    String s3="select * from student where (email='"+s1+"' and password='"+s2+"')";
                    Cursor cursor=data.rawQuery(s3,null);
                    if(cursor.getCount()>0){
                        Toast.makeText(Seventh.this, "user exists", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        data.execSQL("insert into student values('"+s1+"','"+s2+"')");
                        Toast.makeText(Seventh.this, "database updated", Toast.LENGTH_SHORT).show();
                        Intent j=new Intent(Seventh.this, MainActivity.class);
                        startActivity(j);
                        finish();
                    }
                }
            }
        });
    }
}