package com.cookandroid.project8_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class MyPictureView extends View {
    String imagePath=null;

    public MyPictureView(Context context, AttributeSet attrs){
        super(context, attrs);
    } //커스텀뷰 만들때 (필수)생성자

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        if(imagePath!=null){
            Bitmap bitmap= BitmapFactory.decodeFile(imagePath);
            canvas.drawBitmap(bitmap,0,0,null);
            bitmap.recycle();
        }
    } //뷰를 화면에 표시할 때 자동 호출되는 콜백메소드
}
