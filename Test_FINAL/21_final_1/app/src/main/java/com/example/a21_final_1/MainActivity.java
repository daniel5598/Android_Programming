package com.example.a21_final_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("기말고사 1번");

        Button btnSubmit=findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subject=((EditText)findViewById(R.id.edtSubject)).getText().toString().trim();
                Intent intent=new Intent(getApplicationContext(),SecondActivity.class);
                intent.putExtra("Subject",subject);
                startActivityForResult(intent,0);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                TextView tvSubject=findViewById(R.id.tvSubject);
                tvSubject.setText(subject);
                TextView tvScore = findViewById(R.id.tvScore);
                tvScore.setText(data.getStringExtra("SELECTED"));
            }
        }
    }
}