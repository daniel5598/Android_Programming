package com.cookandroid.project8_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileFilter;

public class MainActivity extends AppCompatActivity {
    Button btnPrev, btnNext;
    MyPictureView myPicture;
    int curNum;
    File[] imageFiles;
    String imageFname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지 뷰어");

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);
        //Manifest도 수정 필요
        btnPrev=findViewById(R.id.btnPrev);
        btnNext=findViewById(R.id.btnNext);
        myPicture=findViewById(R.id.myPictureView1); //커스텀뷰를 코드로 접근

        imageFiles=new File(Environment.getExternalStorageDirectory().getAbsoluteFile()+"/Pictures").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return !file.getName().startsWith(".");
            }
        });

        imageFname=imageFiles[0].toString();
        myPicture.imagePath=imageFname;

        btnPrev.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(curNum<=0) {
                    Toast.makeText(getApplicationContext(), "첫번째 그림입니다", Toast.LENGTH_SHORT).show();
                }
                else{
                    curNum--;
                    imageFname=imageFiles[curNum].toString();
                    myPicture.imagePath=imageFname; //MyPictureView의 인스턴스변수 지정
                    myPicture.invalidate(); //onDraw()를 불러 뷰를 다시 그림
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(curNum>=imageFiles.length-1) {
                    Toast.makeText(getApplicationContext(), "마지막 그림입니다", Toast.LENGTH_SHORT).show();
                }
                else{
                    curNum++;
                    imageFname=imageFiles[curNum].toString();
                    myPicture.imagePath=imageFname;
                    myPicture.invalidate();
                }
            }
        });
    }
}