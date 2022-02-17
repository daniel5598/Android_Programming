package com.example.ch9_paint_week11_assignment_8;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private MyPaintView myView;
    Button btnThickness;
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그림판 과제 #8");

        myView = new MyPaintView(this);
        ((LinearLayout) findViewById(R.id.paintLayout)).addView(myView);

        btnThickness=findViewById(R.id.btnThickness);
        btnThickness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(i==0){
                    btnThickness.setText("Thick");
                    myView.mPaint.setStrokeWidth(20);
                    i++;
                }
                else{
                    btnThickness.setText("Thin");
                    myView.mPaint.setStrokeWidth(10);
                    i--;
                }
            }
        });

        ((RadioGroup)findViewById(R.id.radioGroup)).setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                        switch (checkedId) {
                            case R.id.btnRed:
                                myView.mPaint.setColor(Color.RED);
                                break;
                            case R.id.btnGreen:
                                myView.mPaint.setColor(Color.GREEN);
                                break;
                            case R.id.btnBlue:
                                myView.mPaint.setColor(Color.BLUE);
                                break;
                        }
                    }
                });

        ((Button)findViewById(R.id.btnClear)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myView.mBitmap.eraseColor(Color.TRANSPARENT);
                myView.invalidate();
            }
        });
    }
    private static class MyPaintView extends View {
        private Bitmap mBitmap; //그림을 저장할 비트맵
        private Canvas mCanvas; //비트맵과 연결된 캔버스
        private Path mPath;
        private Paint mPaint;
        public MyPaintView(Context context) {
            super(context);
            mPath = new Path();
            mPaint = new Paint();
            mPaint.setColor(Color.RED);
            mPaint.setAntiAlias(true);
            mPaint.setStrokeWidth(10);
            mPaint.setStyle(Paint.Style.STROKE);
        }
        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas(mBitmap);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(mBitmap, 0, 0, null); //지금까지 그려진 내용
            canvas.drawPath(mPath, mPaint); //현재 그리고 있는 내용
        }
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            int x = (int)event.getX();
            int y = (int)event.getY();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    mPath.reset();
                    mPath.moveTo(x, y);
                    break;
                case MotionEvent.ACTION_MOVE:
                    mPath.lineTo(x, y);
                    break;
                case MotionEvent.ACTION_UP:
                    mPath.lineTo(x, y);
                    mCanvas.drawPath(mPath, mPaint); //mBitmap 에 기록
                    mPath.reset();
                    break;
            }
            this.invalidate();
            return true;
        }
    }
}