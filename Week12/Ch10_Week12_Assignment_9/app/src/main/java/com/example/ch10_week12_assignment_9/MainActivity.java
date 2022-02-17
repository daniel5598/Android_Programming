package com.example.ch10_week12_assignment_9;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int[] chkID = { R.id.chkPython, R.id.chkC, R.id.chkJava, R.id.chkCpp, R.id.chkCSharp };
        ArrayList<String> list = new ArrayList<>();
        Button btnGo = findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = ((EditText) findViewById(R.id.etName)).getText().toString().trim();
                for (int id: chkID) {
                    CheckBox chk = findViewById(id);
                    if (chk.isChecked())
                        list.add(chk.getText().toString());
                }
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("NAME", name);
                intent.putExtra("LIST", list);
                startActivityForResult(intent, 0);
            } });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                TextView tvResult = findViewById(R.id.tvResult);
                tvResult.setText(name + "님이 선택한 언어는 " + data.getStringExtra("SELECTED") +
                        "입니다.");
            }
        }
    }
}