package com.cookandroid.do5_3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText edit;
    private Button btn;
    private TextView tView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,   //width
                LinearLayout.LayoutParams.MATCH_PARENT);  //height

        LinearLayout baseLayout=new LinearLayout(this);
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        setContentView(baseLayout,params);

        edit=new EditText(this);
        edit.setHint("여기에 입력하세요");
        baseLayout.addView(edit);

        btn= new Button(this);
        btn.setText("버튼입니다");
        btn.setBackgroundColor(Color.YELLOW);
        baseLayout.addView(btn);

        tView=new TextView(this);
        tView.setText("텍스트뷰입니다.");
        tView.setTextSize(20);
        tView.setTextColor(Color.MAGENTA);
        baseLayout.addView(tView);

        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                tView.setText(edit.getText().toString());
            }
        });
    }
}