package com.cookandroid.do7_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvName, tvEmail;
    Button button1;
    EditText dlgEdtName, dlgEdtEmail;
    TextView toastText;
    View dialogView, toastView;
    //대화상자에 사용할 커스텀뷰 //토스트에 사용할 커스텀뷰

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("사용자 정보 입력");

        tvName=findViewById(R.id.tvName);
        tvEmail=findViewById(R.id.tvEmail);
        button1=findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener(){ //버튼이 눌리면 대화상자 표시
            @Override
            public void onClick(View v) {
                dialogView=View.inflate(MainActivity.this, R.layout.dialog1, null);

                AlertDialog.Builder dlg=new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("사용자 정보 입력");
                dlg.setIcon(R.drawable.ic_menu_allfriends);
                dlg.setView(dialogView);

                dlgEdtName=dialogView.findViewById(R.id.dlgEdt1);
                dlgEdtEmail=dialogView.findViewById(R.id.dlgEdt2);
                dlgEdtName.setText(tvName.getText().toString());
                dlgEdtEmail.setText(tvEmail.getText().toString());

                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override //확인이 눌리면 입력 내용을 텍스트뷰에 표시
                    public void onClick(DialogInterface dialog, int which) {
                        tvName.setText(dlgEdtName.getText().toString());
                        tvEmail.setText(dlgEdtEmail.getText().toString());
                    }
                });
                
                //취소가 눌리면 Toast 표시
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast=new Toast(MainActivity.this);

                        toastView=View.inflate(MainActivity.this, R.layout.toast1, null);
                        toastText=toastView.findViewById(R.id.toastText1);
                        toastText.setText("취소했습니다");
                        toast.setView(toastView);
                        toast.show();
                    }
                });
                dlg.show();
            }
        });
    }
}