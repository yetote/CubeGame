package com.demo.yetote.cubegame.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions;
import com.demo.yetote.cubegame.R;

import java.util.Random;

public class AdvertisementImage extends View {
    private Paint paint;
    private Bitmap bitmap, anotherBitmap;
    private Context context;
    private int width, height;
    private boolean isShow = false;

    public AdvertisementImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    private void init() {
        paint = new Paint();
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.test1);
        anotherBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.test2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, 0, 0, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
    }
}
