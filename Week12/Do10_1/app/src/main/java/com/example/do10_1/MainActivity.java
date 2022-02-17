package com.example.do10_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티 (수정)");

        final RadioButton rdoSecond=findViewById(R.id.rdoSecond);
        Button btnNewActivity=findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if( rdoSecond.isChecked()==true)
                    intent=new Intent(getApplicationContext(), SecondActivity.class );
                else
                    intent=new Intent(getApplicationContext(), ThirdActivity.class );
                startActivity(intent);
            }
        });
    }
}