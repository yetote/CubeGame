package com.demo.yetote.cubegame.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * com.demo.yetote.cubegame.utils
 *
 * @author Swg
 * @date 2018/2/2 16:06
 */
public class ScrollButton extends View {
    private Context context;
    //小圆画笔
    private Paint smallCirclePaint;
    //大圆画笔
    private Paint bigCirclePaint;
    private Paint textPaint;
    private float smallCircleRadius, bigCircleRadius;
    private int centerX, centerY;
    private int width, height;

    public ScrollButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initData();
    }


    private void initData() {
        smallCirclePaint = new Paint();
        smallCirclePaint.setStyle(Paint.Style.FILL);

        bigCirclePaint = new Paint();
        bigCirclePaint.setStyle(Paint.Style.STROKE);
        bigCirclePaint.setStrokeWidth(5);

        textPaint = new Paint();
        textPaint.setTextSize(100);
        textPaint.setColor(Color.WHITE);

        smallCircleRadius = 0;
        bigCircleRadius = 0;
        centerX = 0;
        centerY = 0;
        width = 0;
        height = 0;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        bigCircleRadius = width / 2;
        smallCircleRadius = bigCircleRadius - 5;

        centerX = getLeft() + width / 2;
        centerY = getTop() + height / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSmallCircle(canvas);
        drawBigCircle(canvas);
    }

    /**
     * 画大圆
     *
     * @param canvas 画板
     */
    private void drawBigCircle(Canvas canvas) {
        canvas.drawCircle(centerX, centerY, bigCircleRadius, bigCirclePaint);
    }

    /**
     * 画小圆
     *
     * @param canvas 画板
     */
    private void drawSmallCircle(Canvas canvas) {
        canvas.drawCircle(centerX, centerY, smallCircleRadius, smallCirclePaint);
        /*
        * 先求出文字所在的矩形的坐标
        * sinα=15/r
        * cosα=(h/2)/r
        * w=10
        * 所以矩形的坐标就可以求出来了,
        * 因为你文字居中，就可以求出文字的位置了
        * 额，最后发现好像想的有点复杂
        * */
        canvas.drawText("评分", centerX - 22, centerY - 22, textPaint);
    }
}
