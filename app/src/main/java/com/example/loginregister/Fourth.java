package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Fourth extends AppCompatActivity {
    EditText e1,e2;
    TextView t1;
    Button b9,b10;
    FirebaseAuth fa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fourth);
        e1=(EditText) findViewById(R.id.editTextText);
        e2=(EditText) findViewById(R.id.editTextText2);
        e2.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        b9=(Button) findViewById(R.id.button9);
        b10=(Button) findViewById(R.id.button10);
        fa=FirebaseAuth.getInstance();
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString().trim();
                String s2=e2.getText().toString();
                if(s1.isEmpty())
                {
                    e1.setError("please fill email");
                    return;
                }
                else
                {
                    if(s2.isEmpty())
                    {
                        e2.setError("please fill password");
                        return;
                    }
                    else
                    {
                        fa.signInWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    Toast.makeText(Fourth.this, "online login done", Toast.LENGTH_SHORT).show();
                                    Intent j=new Intent(Fourth.this,Eight.class);
                                    startActivity(j);
                                    finish();
                                }
                                else
                                {
                                    Toast.makeText(Fourth.this, "login failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                }
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent g=new Intent(Fourth.this,Second.class);
                startActivity(g);
                finish();
            }
        });
    }
}