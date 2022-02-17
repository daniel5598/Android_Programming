package com.cookandroid.project6_1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer chrono;
    Button btnStart, btnEnd;
    RadioButton rdoCal, rdoTime;
    CalendarView calView;
    TimePicker tPicker;
    TextView tvDate;
    int selectYear, selectMonth, selectDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        chrono=findViewById(R.id.chronometer1); //크로노미터
        btnStart=findViewById(R.id.btnStart); //시작 및 종료 버튼
        btnEnd=findViewById(R.id.btnEnd);
        rdoCal=findViewById(R.id.rdoCal); //라디오버튼 2개
        rdoTime=findViewById(R.id.rdoTime);
        tPicker=findViewById(R.id.timePicker1); //FrameLayout의 2개 위젯
        calView=findViewById(R.id.calendarView1);
        tvDate=findViewById(R.id.tvDate); //날짜 텍스트뷰
        //처음에는 2개를 안보이게 설정
        tPicker.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                tPicker.setVisibility(View.INVISIBLE);
                calView.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                tPicker.setVisibility(View.VISIBLE);
                calView.setVisibility(View.INVISIBLE);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);
            }
        });

        //버튼을 클릭하면 날짜, 시간을 가져온다.
        btnEnd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                String dateStr=selectYear+"년"+selectMonth+"월"+selectDay+"일"+
                        tPicker.getCurrentHour()+"시"+tPicker.getCurrentMinute()+"분"+" 예약됨";
                tvDate.setText(dateStr);
            }
        });

        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth){
                selectYear=year;
                selectMonth=month+1;
                selectDay=dayOfMonth;
            }
        });
    }
}