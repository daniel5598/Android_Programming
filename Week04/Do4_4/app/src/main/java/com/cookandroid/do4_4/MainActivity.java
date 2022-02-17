package com.cookandroid.do4_4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView text1, text2;
    Switch switchAgree;
    RadioGroup rGroup1;
    RadioButton rdoPie9, rdoQ10, rdoR11;
    ImageView imgAndroid;
    Button btnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        //위젯을 변수에 대입
        text1=findViewById(R.id.Text1);
        switchAgree=findViewById(R.id.SwitchAgree);

        text2=findViewById(R.id.Text2);
        rGroup1=findViewById(R.id.Rgroup1);
        rdoPie9=findViewById(R.id.RdoPie9);
        rdoQ10=findViewById(R.id.RdoQ10);
        rdoR11=findViewById(R.id.RdoR11);

        imgAndroid=findViewById(R.id.ImgAndroid);
        btnEnd=findViewById(R.id.BtnEnd);

        //동의함 스위치의 상태가 변경되면
        switchAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                //스위치를 누르면 모두 보이도록 설정
                if(switchAgree.isChecked()==true){
                    text2.setVisibility(android.view.View.VISIBLE);
                    rGroup1.setVisibility(android.view.View.VISIBLE);
                    imgAndroid.setVisibility(android.view.View.VISIBLE);
                    btnEnd.setVisibility(android.view.View.VISIBLE);
                }
                else{
                    text2.setVisibility(android.view.View.INVISIBLE);
                    rGroup1.setVisibility(android.view.View.INVISIBLE);
                    imgAndroid.setVisibility(android.view.View.INVISIBLE);
                    btnEnd.setVisibility(android.view.View.INVISIBLE);
                }

                rdoPie9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgAndroid.setImageResource(R.drawable.pie);
                    }
                });
                rdoQ10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgAndroid.setImageResource(R.drawable.q10);
                    }
                });
                rdoR11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgAndroid.setImageResource(R.drawable.r11);
                    }
                });

                btnEnd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view)  { finish(); }
                });
            }
        });
    }
}