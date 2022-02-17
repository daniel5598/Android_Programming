package com.cookandroid.assign05_tabhost;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvColor, tvSize;
    RadioButton rdoRed, rdoGreen, rdoBlue;
    Button btnSmall, btnBig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("과제05_탭호스트 과제");

        tvColor=findViewById(R.id.TvColor);
        tvSize=findViewById(R.id.TvSize);
        rdoRed=findViewById(R.id.ColorRed);
        rdoGreen=findViewById(R.id.ColorGreen);
        rdoBlue=findViewById(R.id.ColorBlue);
        btnSmall=findViewById(R.id.BtnSmall);
        btnBig=findViewById(R.id.BtnBig);

        TabHost tabHost = findViewById(R.id.tabHost); //탭호스트 변수 생성
        tabHost.setup(); //탭스펙 생성

        TabHost.TabSpec tabSpecColor = tabHost.newTabSpec("COLOR").setIndicator("색상"); //색상->탭에 출력될 글자
        tabSpecColor.setContent(R.id.tabColor); //탭스펙을 탭과 연결
        tabHost.addTab(tabSpecColor); //탭을 탭호스트에 부착
        rdoRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvColor.setTextColor(Color.RED);
            }
        });
        rdoGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvColor.setTextColor(Color.GREEN);
            }
        });
        rdoBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvColor.setTextColor(Color.BLUE);
            }
        });

        TabHost.TabSpec tabSpecSize = tabHost.newTabSpec("SIZE").setIndicator("크기"); //크기->탭에 출력될 글자
        tabSpecSize.setContent(R.id.tabSize); //탭스펙을 탭과 연결
        tabHost.addTab(tabSpecSize); //탭을 탭호스트에 부착
        btnSmall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float size=tvSize.getTextSize();
                tvSize.setTextSize(TypedValue.COMPLEX_UNIT_PX,size-10);
            }
        });
        btnBig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float size=tvSize.getTextSize();
                tvSize.setTextSize(TypedValue.COMPLEX_UNIT_PX,size+10);
            }
        });

        tabHost.setCurrentTab(0); //첫번째 색상 탭이 초기에 보여짐
    }
}