package com.cookandroid.onclickxml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void myClick(View view){
        String tmp=((Button)view).getText().toString();
        Toast.makeText(getApplicationContext(),tmp+"눌림",Toast.LENGTH_SHORT).show();
    }
}