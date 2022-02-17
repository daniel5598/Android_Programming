package com.cookandroid.ch7_showanimal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("동물 선택 대화상자");

        image=findViewById(R.id.imageView);
    }

    public void onClick(View view){
        String animals[]={"강아지", "고양이", "말", "토끼"};

        AlertDialog.Builder dlg=new AlertDialog.Builder(MainActivity.this);
        dlg.setTitle("좋아하는 동물은?");
        dlg.setItems(animals, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch (i){
                    case 0:
                        image.setImageResource(R.drawable.dog);
                        break;
                    case 1:
                        image.setImageResource(R.drawable.cat);
                        break;
                    case 2:
                        image.setImageResource(R.drawable.horse);
                        break;
                    case 3:
                        image.setImageResource(R.drawable.rabbit);
                        break;
                }
            }
        });
        dlg.setNegativeButton("닫기",null);
        dlg.show();
    }
}