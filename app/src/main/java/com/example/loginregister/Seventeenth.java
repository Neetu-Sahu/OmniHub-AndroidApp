package com.example.loginregister;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.VideoView;
import android.widget.MediaController;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Seventeenth extends AppCompatActivity {
    VideoView vv;
    Button bPlay, bPause, bBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_seventeenth);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        vv = findViewById(R.id.videoView);
        bPlay = findViewById(R.id.buttonPlay);
        bPause = findViewById(R.id.buttonPause);
        bBack = findViewById(R.id.buttonBackToFourteen);

        // Path to the video file in res/raw
        // Note: Used R.raw.b as bb.mp4 was not found in the raw folder.
        // Rename your file to bb.mp4 if you want to use R.raw.bb
        String videoPath = "android.resource://" + getPackageName() + "/" + R.raw.b;
        Uri uri = Uri.parse(videoPath);
        vv.setVideoURI(uri);

        // Adding a MediaController to the VideoView for seekbar and standard controls
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(vv);
        vv.setMediaController(mediaController);

        bPlay.setOnClickListener(v -> {
            vv.start();
        });

        bPause.setOnClickListener(v -> {
            vv.pause();
        });

        bBack.setOnClickListener(v -> {
            Intent intent = new Intent(Seventeenth.this, Fourteenth.class);
            startActivity(intent);
            finish();
        });
    }
}
