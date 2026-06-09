package com.example.loginregister;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Eleventh extends AppCompatActivity {
    Button b23,b24,b25;
    WifiManager wm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_eleventh);
        b23=(Button) findViewById(R.id.button23);
        b24=(Button) findViewById(R.id.button24);
        b25=(Button) findViewById(R.id.button25);
        wm=(WifiManager)getSystemService(WIFI_SERVICE);
        b25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent x=new Intent(Eleventh.this, Tenth.class);
                startActivity(x);
                finish();
            }
        });
        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.Q)
                {
                    Intent a=new Intent(Settings.Panel.ACTION_WIFI);
                    startActivityForResult(a,0);
                }
                else
                {
                    wm.setWifiEnabled(true);
                }
            }
        });
        b24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                    Intent panelIntent = new Intent(Settings.Panel.ACTION_WIFI);
                    startActivityForResult(panelIntent, 0);
                } else {
                    wm.setWifiEnabled(false);
                }
            }
        });
    }
}