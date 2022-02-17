package com.cookandroid.hwork01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnClass, btnName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnClass=findViewById(R.id.btnClass);
        btnName=findViewById(R.id.btnName);

        btnClass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"학번은 201704046이고",Toast.LENGTH_SHORT).show();
            }
        });

        btnName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "이름은 서범준입니다", Toast.LENGTH_SHORT).show();
            }
        });
    }
}