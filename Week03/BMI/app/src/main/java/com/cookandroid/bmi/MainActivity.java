package com.cookandroid.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edit1, edit2;
    private Button btnCal;
    private TextView textResult;
    private String num1,num2;
    private double result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("비만도 계산기");

        edit1 = findViewById(R.id.Edit1);
        edit2 = findViewById(R.id.Edit2);

        btnCal = findViewById(R.id.BtnCal);

        textResult = findViewById(R.id.TextResult);

        btnCal.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                num1 = edit1.getText().toString();
                num2 = edit2.getText().toString();
                result = (Double.parseDouble(num2)*100*100)/(Double.parseDouble(num1)*Double.parseDouble(num1));
                result=Math.round(result*100)/100.0;
                if (result <= 18.5)
                    textResult.setText("귀하의 BMI = " + result + "이며, 저체중입니다.");
                else if (result>18.5 && result <= 23)
                    textResult.setText("귀하의 BMI = " + result + "이며, 정상입니다.");
                else if (result>23 && result <= 25)
                    textResult.setText("귀하의 BMI = " + result + "이며, 과체중입니다.");
                else if (result>25 && result <= 30)
                    textResult.setText("귀하의 BMI = " + result + "이며, 비만입니다.");
                else if(result>30)
                    textResult.setText("귀하의 BMI = " + result + "이며, 고도비만입니다.");
                return false;
            }
        });
    }
}