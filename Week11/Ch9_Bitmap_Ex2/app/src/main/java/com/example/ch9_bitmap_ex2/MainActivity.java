package com.example.ch9_bitmap_ex2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("비트맵 예제(SD카드)");
        ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);;
    }

    private static class MyGraphicView extends View {
        public MyGraphicView(Context context){
            super(context);
        }

        protected void onDraw(Canvas canvas){
            super.onDraw(canvas);
            Bitmap picture= BitmapFactory.decodeFile("/sdcard/Pictures/jeju.jpg");
            int picX=(this.getWidth()-picture.getWidth())/2;
            int picY=(this.getHeight()-picture.getHeight())/2;
            //canvas.scale(2, 2, this.getWidth()/2, this.getHeight()/2);
            canvas.drawBitmap(picture,picX,picY,null);
            picture.recycle();
        }
    }
}