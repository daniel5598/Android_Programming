package com.cookandroid.do8_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileFilter;

public class MainActivity extends AppCompatActivity {
    Button btnPrev, btnNext;
    MyPictureView myPicture;
    int curNum;
    File[] imageFiles;
    String imageFname;
    TextView tvNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지 뷰어(수정)");

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);
        //Manifest도 수정 필요
        btnPrev=findViewById(R.id.btnPrev);
        btnNext=findViewById(R.id.btnNext);
        myPicture=findViewById(R.id.myPictureView1); //커스텀뷰를 코드로 접근
        tvNumber=findViewById(R.id.tvNumber);

        imageFiles=new File(Environment.getExternalStorageDirectory().getAbsoluteFile()+"/Pictures").listFiles(new FileFilter() {
            @Override //추가된 필터 부분
            public boolean accept(File file) {
                return !file.getName().startsWith(".");
            }
        });

        curNum=imageFiles.length/imageFiles.length;
        imageFname=imageFiles[0].toString();
        myPicture.imagePath=imageFname;
        myPicture.invalidate();
        tvNumber.setText(Integer.toString(curNum)+"/"+Integer.toString(imageFiles.length));

        btnPrev.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(curNum<=1) {
                    curNum=imageFiles.length;
                    imageFname=imageFiles[curNum-1].toString();
                    myPicture.imagePath=imageFname;
                    myPicture.invalidate();
                    tvNumber.setText(Integer.toString(curNum)+"/"+Integer.toString(imageFiles.length));
                }
                else{
                    curNum--;
                    imageFname=imageFiles[curNum-1].toString();
                    myPicture.imagePath=imageFname;
                    myPicture.invalidate();
                    tvNumber.setText(Integer.toString(curNum)+"/"+Integer.toString(imageFiles.length));
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                if(curNum>=imageFiles.length) {
                    curNum=1;
                    imageFname=imageFiles[curNum-1].toString();
                    myPicture.imagePath=imageFname;
                    myPicture.invalidate();
                    tvNumber.setText(Integer.toString(curNum)+"/"+Integer.toString(imageFiles.length));
                }
                else{
                    curNum++;
                    imageFname=imageFiles[curNum-1].toString();
                    myPicture.imagePath=imageFname;
                    myPicture.invalidate();
                    tvNumber.setText(Integer.toString(curNum)+"/"+Integer.toString(imageFiles.length));
                }
            }
        });
    }
}