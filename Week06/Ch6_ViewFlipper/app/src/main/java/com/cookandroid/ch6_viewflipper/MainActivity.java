package com.cookandroid.ch6_viewflipper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("뷰플리퍼 예쩨");

        Button btnPrev,btnNext;
        final ViewFlipper vFlipper;

        btnPrev=findViewById(R.id.btnPrev);
        btnNext=findViewById(R.id.btnNext);

        vFlipper=findViewById(R.id.viewFlipper1);

        btnPrev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                vFlipper.showPrevious();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                vFlipper.showNext();
            }
        });
    }
}