package com.cookandroid.project4_1_2;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edit1, edit2;
    private Button btnAdd,btnSub,btnMul,btnDiv;
    private TextView textResult;
    private String num1,num2;
    private int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기");

        edit1=findViewById(R.id.Edit1);
        edit2=findViewById(R.id.Edit2);

        btnAdd=findViewById(R.id.BtnAdd);
        btnSub=findViewById(R.id.BtnSub);
        btnMul=findViewById(R.id.BtnMul);
        btnDiv=findViewById(R.id.BtnDiv);

        textResult=findViewById(R.id.TextResult);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        num1= edit1.getText().toString();
        num2= edit2.getText().toString();
        switch(view.getId()) {
            case R.id.BtnAdd:
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                break;
            case R.id.BtnSub:
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                break;
            case R.id.BtnMul:
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                break;
            case R.id.BtnDiv:
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                break;
        }
        textResult.setText("계산 결과: "+result);
    }
}