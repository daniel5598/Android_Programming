package com.cookandroid.ch8_rawfolder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Raw Folder 파일처리");

        Button btnRead=findViewById(R.id.btnRed);
        final EditText edtRaw=findViewById(R.id.edtRaw);
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    InputStream inputS=getResources().openRawResource(R.raw.raw_test); //InputStream 타입으로 해야함
                    byte[] txt=new byte[inputS.available()]; //대략적인 바이트 수 반환
                    inputS.read(txt);
                    edtRaw.setText(new String(txt));
                    inputS.close();
                }
                catch (IOException e){
                }
            }
        });
    }
}