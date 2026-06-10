package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Nineteenth extends AppCompatActivity {

    private TextView tvDisplay;
    private double lastValue = 0;
    private char lastOperator = ' ';
    private boolean isNewOp = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nineteenth);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvDisplay = findViewById(R.id.tvDisplay);

        int[] numberIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        };

        for (int id : numberIds) {
            findViewById(id).setOnClickListener(v -> {
                Button b = (Button) v;
                appendNumber(b.getText().toString());
            });
        }

        findViewById(R.id.btnDot).setOnClickListener(v -> appendNumber("."));

        findViewById(R.id.btnClear).setOnClickListener(v -> {
            tvDisplay.setText("0");
            lastValue = 0;
            lastOperator = ' ';
            isNewOp = true;
        });

        findViewById(R.id.btnPlus).setOnClickListener(v -> setOperator('+'));
        findViewById(R.id.btnMinus).setOnClickListener(v -> setOperator('-'));
        findViewById(R.id.btnMul).setOnClickListener(v -> setOperator('*'));
        findViewById(R.id.btnDiv).setOnClickListener(v -> setOperator('/'));

        findViewById(R.id.btnEqual).setOnClickListener(v -> calculate());

        findViewById(R.id.btnSin).setOnClickListener(v -> applySciFunc("sin"));
        findViewById(R.id.btnCos).setOnClickListener(v -> applySciFunc("cos"));
        findViewById(R.id.btnTan).setOnClickListener(v -> applySciFunc("tan"));
        findViewById(R.id.btnLog).setOnClickListener(v -> applySciFunc("log"));
        findViewById(R.id.btnSqrt).setOnClickListener(v -> applySciFunc("sqrt"));
        findViewById(R.id.btnSquare).setOnClickListener(v -> applySciFunc("square"));

        findViewById(R.id.btnBack).setOnClickListener(v -> {
            Intent intent = new Intent(Nineteenth.this, Fifteenth.class);
            startActivity(intent);
            finish();
        });
    }

    private void appendNumber(String num) {
        if (isNewOp) {
            tvDisplay.setText("");
            isNewOp = false;
        }
        String current = tvDisplay.getText().toString();
        if (num.equals(".") && current.contains(".")) return;
        tvDisplay.append(num);
    }

    private void setOperator(char op) {
        if (!isNewOp) calculate();
        try {
            lastValue = Double.parseDouble(tvDisplay.getText().toString());
            lastOperator = op;
            isNewOp = true;
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid number", Toast.LENGTH_SHORT).show();
        }
    }

    private void calculate() {
        if (lastOperator == ' ') return;
        try {
            double currentValue = Double.parseDouble(tvDisplay.getText().toString());
            switch (lastOperator) {
                case '+': lastValue += currentValue; break;
                case '-': lastValue -= currentValue; break;
                case '*': lastValue *= currentValue; break;
                case '/':
                    if (currentValue == 0) {
                        Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    lastValue /= currentValue;
                    break;
            }
            tvDisplay.setText(String.valueOf(lastValue));
            lastOperator = ' ';
            isNewOp = true;
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid number", Toast.LENGTH_SHORT).show();
        }
    }

    private void applySciFunc(String func) {
        try {
            double val = Double.parseDouble(tvDisplay.getText().toString());
            double res = 0;
            switch (func) {
                case "sin": res = Math.sin(Math.toRadians(val)); break;
                case "cos": res = Math.cos(Math.toRadians(val)); break;
                case "tan": res = Math.tan(Math.toRadians(val)); break;
                case "log": 
                    if (val <= 0) {
                        Toast.makeText(this, "Log must be > 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    res = Math.log10(val); 
                    break;
                case "sqrt":
                    if (val < 0) {
                        Toast.makeText(this, "Cannot sqrt negative", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    res = Math.sqrt(val); 
                    break;
                case "square": res = val * val; break;
            }
            tvDisplay.setText(String.valueOf(res));
            isNewOp = true;
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid number", Toast.LENGTH_SHORT).show();
        }
    }
}
