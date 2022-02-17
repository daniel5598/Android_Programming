package com.cookandroid.ch9_graphic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("안드로이드 그래픽 기초");
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context){
            super(context);
        }

        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Paint paint=new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.GREEN);
            canvas.drawLine(10, 50, 300, 50, paint);

            paint.setColor(Color.BLUE);
            paint.setStrokeWidth(10);
            canvas.drawLine(10, 100, 300, 100, paint);

            paint.setColor(Color.RED);
            paint.setStrokeWidth(0);

            paint.setStyle(Paint.Style.FILL);
            Rect rect1=new Rect(10, 150, 10+100, 150+100);
            canvas.drawRect(rect1, paint);

            paint.setStyle(Paint.Style.STROKE);
            Rect rect2=new Rect(130, 150, 130+100, 150+100);
            canvas.drawRect(rect2, paint);

            RectF rect3=new RectF(250, 150, 250+100, 150+100);
            canvas.drawRoundRect(rect3, 20, 20, paint);

            canvas.drawCircle(60, 350, 50, paint);

            paint.setStrokeWidth(5);
            Path path1=new Path();
            path1.moveTo(10, 450);
            path1.lineTo(10+50, 450+50);
            path1.lineTo(10+100, 450);
            path1.lineTo(10+150, 450+50);
            path1.lineTo(10+200, 450);
            canvas.drawPath(path1, paint);

            paint.setStrokeWidth(0);
            paint.setTextSize(80);
            canvas.drawText("안드로이드", 10, 600, paint);
        }
    }
}