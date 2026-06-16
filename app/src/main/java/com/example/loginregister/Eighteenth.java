package com.example.loginregister;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Eighteenth extends AppCompatActivity {

    TextView tvDisplay, tvHistory;
    double lastValue = 0;
    char lastOperator = ' ';
    boolean isNewOp = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_eighteenth);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            WindowInsetsCompat.Type.systemBars();
            return insets;
        });

        tvDisplay = findViewById(R.id.tvDisplay);
        tvHistory = findViewById(R.id.tvHistory);

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
            tvHistory.setText("");
            lastValue = 0;
            lastOperator = ' ';
            isNewOp = true;
        });

        findViewById(R.id.btnPlus).setOnClickListener(v -> setOperator('+'));
        findViewById(R.id.btnMinus).setOnClickListener(v -> setOperator('-'));
        findViewById(R.id.btnMul).setOnClickListener(v -> setOperator('*'));
        findViewById(R.id.btnDiv).setOnClickListener(v -> setOperator('/'));

        findViewById(R.id.btnEqual).setOnClickListener(v -> calculate());

        findViewById(R.id.btnBack).setOnClickListener(v -> {
            Intent intent = new Intent(Eighteenth.this, Fifteenth.class);
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
        if (!isNewOp) {
            if (lastOperator != ' ') {
                calculate();
            } else {
                lastValue = Double.parseDouble(tvDisplay.getText().toString());
            }
        }
        lastOperator = op;
        tvHistory.setText(lastValue + " " + op);
        isNewOp = true;
    }

    private void calculate() {
        if (lastOperator == ' ') return;
        try {
            double currentValue = Double.parseDouble(tvDisplay.getText().toString());
            double result = lastValue;
            switch (lastOperator) {
                case '+': result += currentValue; break;
                case '-': result -= currentValue; break;
                case '*': result *= currentValue; break;
                case '/':
                    if (currentValue == 0) {
                        Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result /= currentValue;
                    break;
            }
            tvHistory.setText(lastValue + " " + lastOperator + " " + currentValue + " =");
            tvDisplay.setText(String.valueOf(result));
            lastValue = result;
            lastOperator = ' ';
            isNewOp = true;
        } catch (Exception e) {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }
    }
}
