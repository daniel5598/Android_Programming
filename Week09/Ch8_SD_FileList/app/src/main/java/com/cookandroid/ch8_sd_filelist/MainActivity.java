package com.cookandroid.ch8_sd_filelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("SD카드 파일목록");

        Button btnFilelist=findViewById(R.id.btnFilelist);
        final EditText edtFilelist=findViewById(R.id.edtFilelist);

        btnFilelist.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String sysDir= Environment.getRootDirectory().getAbsolutePath();
                //안드로이드 시스템의 폴더 경로를 얻음 "/system"
                File[] sysFiles=(new File(sysDir).listFiles());

                String strFname;
                for(int i=0;i<sysFiles.length;i++){
                    if(sysFiles[i].isDirectory()==true)
                        strFname="<폴더>"+sysFiles[i].toString();
                    else
                        strFname="<파일>"+sysFiles[i].toString();
                    edtFilelist.setText(edtFilelist.getText()+"\n"+strFname);
                }
            }
        });

    }
}