package com.example.loginregister;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class Eight extends AppCompatActivity {
    EditText e9,e10,e11,e12;
    Button b18,b17,b32;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_eight);
        e9=(EditText)findViewById(R.id.editTextText9);
        e10=(EditText)findViewById(R.id.editTextText10);
        e11=(EditText)findViewById(R.id.editTextText11);
        e12=(EditText)findViewById(R.id.editTextText12);
        b17=(Button) findViewById(R.id.button17);
        b18=(Button) findViewById(R.id.button18);
        b32=(Button) findViewById(R.id.button32);
        firebaseDatabase=FirebaseDatabase.getInstance();
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Eight.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference=firebaseDatabase.getReference("users");
                String s1=e9.getText().toString();
                String s2=e10.getText().toString();
                String s3=e11.getText().toString();
                String s4=e12.getText().toString();
                if(s3.length()!=10)
                {
                    Toast.makeText(Eight.this, "please fill phone number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    users users=new users(s1,s2,s3,s4);
                    databaseReference.child(s4).setValue(users);
                    Toast.makeText(Eight.this, "Realtime Database updated", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent w=new Intent(Eight.this,Ninth.class);
                startActivity(w);
                finish();
            }
        });
    }
}