package com.feliperodcoding.frenchteacherapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button blckBtn, yellowBtn, redBtn,purpleBtn, greenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        blckBtn = findViewById(R.id.blackBtn);
        yellowBtn = findViewById(R.id.yellowBtn);
        redBtn = findViewById(R.id.redBtn);
        purpleBtn = findViewById(R.id.purpleBtn);
        greenBtn = findViewById(R.id.greenBtn);

        redBtn.setOnClickListener(this);
        yellowBtn.setOnClickListener(this);
        blckBtn.setOnClickListener(this);
        purpleBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View view) {

        int clickBtnId = view.getId();
        MediaPlayer mediaPlayer;
        if (clickBtnId == R.id.redBtn){
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.red);
        } else if (clickBtnId == R.id.blackBtn) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.black);
        }
        else if (clickBtnId == R.id.yellowBtn) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.yellow);
        }
        else if (clickBtnId == R.id.purpleBtn) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.purple);
        }
        else{
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.green);
        }
        mediaPlayer.start();
    }
}