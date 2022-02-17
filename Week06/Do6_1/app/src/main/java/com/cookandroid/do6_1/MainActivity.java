package com.cookandroid.do6_1;


import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    Chronometer chrono;
    RadioButton rdoCal, rdoTime;
    DatePicker dPicker;
    TimePicker tPicker;
    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("시간 예약");

        chrono = findViewById(R.id.chronometer1); // 크로노미터
        rdoCal = findViewById(R.id.rdoCal); // 라디오버튼 2개
        rdoTime = findViewById(R.id.rdoTime);
        tPicker = findViewById(R.id.timePicker1); // FrameLayout의 2개 위젯
        dPicker = findViewById(R.id.datePicker1);
        tvDate = findViewById(R.id.tvDate); // 날짜 텍스트뷰
        // 처음에는 2 개를 안보이게 설정
        tPicker.setVisibility(View.INVISIBLE);
        dPicker.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tPicker.setVisibility(View.INVISIBLE);
                dPicker.setVisibility(View.VISIBLE);
            }
        });
        rdoTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tPicker.setVisibility(View.VISIBLE);
                dPicker.setVisibility(View.INVISIBLE);
            }
        });

        //크로노미터 리스너
        chrono.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);

                rdoCal.setVisibility(View.VISIBLE);
                rdoTime.setVisibility(View.VISIBLE);
            }
        });

        //날짜 텍스트뷰를 롱클릭하면
        tvDate.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);
                String dateStr = dPicker.getYear() + "년" + (dPicker.getMonth() + 1) + "월" +
                        dPicker.getDayOfMonth() + "일" + tPicker.getCurrentHour() + "시" +
                        tPicker.getCurrentMinute() + "분" + "예약됨";
                tvDate.setText(dateStr);

                rdoCal.setVisibility(View.INVISIBLE);
                rdoTime.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
                tPicker.setVisibility(View.INVISIBLE);
                return false;
            }
        });
    }
}