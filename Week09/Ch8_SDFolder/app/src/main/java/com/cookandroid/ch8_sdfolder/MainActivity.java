package com.cookandroid.ch8_sdfolder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("SD카드 폴더");

        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        Button btnMkdir=findViewById(R.id.btnMkdir);
        Button btnRmdir=findViewById(R.id.btnRmdir);
        final String strSDpath= Environment.getExternalStorageDirectory().getAbsolutePath(); //SD카드의 절대경로를 얻음-> "/sdcard"
        final File myDir=new File(strSDpath+"/mydir"); //   "/sdcard/mydir"

        btnMkdir.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                myDir.mkdir(); //make directory
            }
        });
        btnRmdir.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                myDir.delete(); //remove directory
            }
        });
    }
}