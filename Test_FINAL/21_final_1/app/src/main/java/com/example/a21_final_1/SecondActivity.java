package com.example.a21_final_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private String selected = "";
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("학점 입력");

        //인텐트 데이터 접근
        Intent inIntent = getIntent();
        String subject= inIntent.getStringExtra("Subject");
        TextView tvMsg=findViewById(R.id.tvMsg);
        tvMsg.setText(subject+"의 학점을 선택하세요:");
        RadioGroup radioGroup = findViewById(R.id.rGroup);
        radioGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selected = ((RadioButton)view).getText().toString();
            }
        });

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oIntent = new Intent(SecondActivity.this, MainActivity.class);
                oIntent.putExtra("SELECTED", selected);
                setResult(RESULT_OK, oIntent);
                finish();
            }
        });
    }
}
