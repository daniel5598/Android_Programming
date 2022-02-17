package com.cookandroid.ch7_alertdialogtest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("대화상제 예제");

        final Button button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                final String[] versionArray=new String[]{"파이","큐(10)","알(11)"};
                final boolean[] checkArray={true, false, false}; //체크박스 목록을 만들때 사용

                AlertDialog.Builder dlg=new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("제목입니다");
                //dlg.setMessage("이곳이 내용입니다");
                dlg.setIcon(R.mipmap.ic_launcher);

                //가장 기본적인 목록을 만드는 형식
                //dlg.setItems(versionArray, new DialogInterface.OnClickListener() {
                //    @Override
                //    public void onClick(DialogInterface dialogInterface, int i) {
                //        button1.setText(versionArray[i]);
                //    }
                //});

                //라디오버튼 목록을 만드는 형식
                //dlg.setSingleChoiceItems(versionArray, 0, new DialogInterface.OnClickListener() {
                //   @Override //0은 첫번째 항목을 초기에 선택한 상태 (Checked Item) (2일 경우 세번째 항목)
                //    public void onClick(DialogInterface dialogInterface, int i) {
                //        button1.setText(versionArray[i]);
                //    }
                //});

                //체크박스 목록을 만드는 형식(다중 선택)              //리스너 다름
                dlg.setMultiChoiceItems(versionArray, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        button1.setText(versionArray[i]);
                    }
                });

                //dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                //    @Override
                //    public void onClick(DialogInterface dialogInterface, int i) {
                //        Toast.makeText(MainActivity.this, "확인을 눌렀네요",Toast.LENGTH_SHORT).show();
                //    }
                //});
                dlg.setNegativeButton("닫기",null);
                dlg.show();
            }
        });
    }
}