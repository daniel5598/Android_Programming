package com.cookandroid.project5_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;

    Button[] numButtons = new Button[10]; //10개 숫자 버튼 배열
    int[] numBtnIDs = {R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4,
            R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("테이블레이아웃 계산기");

        edit1 = findViewById(R.id.Edit1);
        edit2 = findViewById(R.id.Edit2);
        btnAdd = findViewById(R.id.BtnAdd);
        btnSub = findViewById(R.id.BtnSub);
        btnMul = findViewById(R.id.BtnMul);
        btnDiv = findViewById(R.id.BtnDiv);
        textResult = findViewById(R.id.TextResult);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);

        //숫자 버튼 10개를 대입
        for (int i = 0; i < numBtnIDs.length; i++) {
            numButtons[i] = findViewById(numBtnIDs[i]);
        }

        // 숫자 버튼 10개에 대해서 클릭이벤트 철
        for (int i = 0; i < numBtnIDs.length; i++) {
            final int index = i; //주의! final 선언이 꼭 필요함. 내부클래스에서 외부 지역변수 접근 문제로 인해 index를 final로 선언함!
            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //포커스가 되어 있는 에디트텍스트에 숫자 추가
                    if (edit1.isFocused() == true) {
                        num1 = edit1.getText().toString()
                                + numButtons[index].getText().toString();
                        edit1.setText(num1);
                    } else if (edit2.isFocused() == true) {
                        num2 = edit2.getText().toString()
                                + numButtons[index].getText().toString();
                        edit2.setText(num2);
                    } else {
                        Toast.makeText(getApplicationContext(),
                                "먼저 에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public void onClick(View view) {
        num1 = edit1.getText().toString();
        num2 = edit2.getText().toString();
        int result = 0;
        switch (view.getId()) {
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
        textResult.setText("계산 결과 : " + result);
    }
}