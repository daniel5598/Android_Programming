package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button b1=findViewById(R.id.btn);
        //내부클래스에서 외부 지역변수를 접근하려면 final로 선언되어야 함!
        //(단 JAVA 1.8 부터는 생략가능하나 실제적으로 final이어야 함)

        b1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                b1.setText("Button pressed!");
            }
        });
    }
}