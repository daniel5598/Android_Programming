package com.cookandroid.ch6_chronotest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    Chronometer chrono;
    Button button;
    boolean isStopped = true;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chrono = findViewById(R.id.chrono);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (isStopped) {
                    chrono.setBase(SystemClock.elapsedRealtime()); //0으로 초기화
                    chrono.start();
                    chrono.setTextColor(Color.BLUE);
                    button.setText("Stop");
                } else {
                    chrono.stop();
                    chrono.setTextColor(Color.RED);
                    button.setText("Start");
                }
                isStopped = !isStopped;
            }
        });
    }
}