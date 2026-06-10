package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Eighteenth extends AppCompatActivity {

    EditText et1, et2;
    Button bPlus, bMinus, bMul, bDiv, bBack;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_eighteenth);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        et1 = findViewById(R.id.etNum1);
        et2 = findViewById(R.id.etNum2);
        bPlus = findViewById(R.id.btnPlus);
        bMinus = findViewById(R.id.btnMinus);
        bMul = findViewById(R.id.btnMul);
        bDiv = findViewById(R.id.btnDiv);
        bBack = findViewById(R.id.btnBack);
        tvResult = findViewById(R.id.tvResult);

        bPlus.setOnClickListener(v -> calculate('+'));
        bMinus.setOnClickListener(v -> calculate('-'));
        bMul.setOnClickListener(v -> calculate('*'));
        bDiv.setOnClickListener(v -> calculate('/'));

        bBack.setOnClickListener(v -> {
            Intent intent = new Intent(Eighteenth.this, Fifteenth.class);
            startActivity(intent);
            finish();
        });
    }

    private void calculate(char op) {
        String s1 = et1.getText().toString();
        String s2 = et2.getText().toString();

        if (s1.isEmpty() || s2.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double n1 = Double.parseDouble(s1);
        double n2 = Double.parseDouble(s2);
        double res = 0;

        switch (op) {
            case '+': res = n1 + n2; break;
            case '-': res = n1 - n2; break;
            case '*': res = n1 * n2; break;
            case '/':
                if (n2 == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                res = n1 / n2;
                break;
        }
        tvResult.setText("Result: " + res);
    }
}
