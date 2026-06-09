package com.example.loginregister;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class Twelfth extends AppCompatActivity {
    Button b26, b27, b28;
    BluetoothAdapter ba;
    private ActivityResultLauncher<Intent> enableBtLauncher;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_twelfth);

        b26 = findViewById(R.id.button26);
        b27 = findViewById(R.id.button27);
        b28 = findViewById(R.id.button28);

        ba = BluetoothAdapter.getDefaultAdapter();
        if (ba == null) {
            Toast.makeText(this, "Bluetooth not supported", Toast.LENGTH_SHORT).show();
            return;
        }

        enableBtLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (ba.isEnabled()) {
                        Toast.makeText(this, "Bluetooth enabled", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Bluetooth NOT enabled", Toast.LENGTH_SHORT).show();
                    }
                });

        b26.setOnClickListener(v -> {
            if (checkPermission()) {
                if (!ba.isEnabled()) {
                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    enableBtLauncher.launch(enableBtIntent);
                } else {
                    Toast.makeText(this, "Bluetooth is already ON", Toast.LENGTH_SHORT).show();
                }
            } else {
                requestPermission();
            }
        });

        b27.setOnClickListener(v -> {
            if (checkPermission()) {
                if (ba.isEnabled()) {
                    // Open Bluetooth settings so user can turn it off manually
                    Intent intent = new Intent(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Bluetooth is already OFF", Toast.LENGTH_SHORT).show();
                }
            } else {
                requestPermission();
            }
        });

        b28.setOnClickListener(v -> {
            Intent x = new Intent(Twelfth.this, Tenth.class);
            startActivity(x);
            finish();
        });
    }

    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            return ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) == PackageManager.PERMISSION_GRANTED;
        }
        return true;
    }

    private void requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.BLUETOOTH_CONNECT}, 1);
        }
    }
}
