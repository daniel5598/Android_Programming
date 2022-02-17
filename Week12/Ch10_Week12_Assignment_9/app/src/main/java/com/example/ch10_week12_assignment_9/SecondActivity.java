package com.example.ch10_week12_assignment_9;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
public class SecondActivity extends AppCompatActivity {
    private String selected = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        //인텐트 데이터 접근
        Intent inIntent = getIntent();
        String name = inIntent.getStringExtra("NAME");
        ArrayList<String> list = inIntent.getStringArrayListExtra("LIST");
        TextView tvMsg = findViewById(R.id.tvMsg);
        tvMsg.setText(name +"님의 목록:");
        //라디오그룹에 addView()로 라디오버튼 삽입
        RadioGroup radioGroup = findViewById(R.id.rGroup);
        for (int i=0; i<list.size(); i++) {
            RadioButton radio = new RadioButton(this);
            radio.setText(list.get(i));
            radio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    selected = ((RadioButton)view).getText().toString();
                }
            });
            radioGroup.addView(radio);
        }
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