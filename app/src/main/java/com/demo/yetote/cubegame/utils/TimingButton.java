package com.demo.yetote.cubegame.utils;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.LinearInterpolator;

import com.demo.yetote.cubegame.R;

import java.util.Date;

/**
 * com.demo.yetote.cubegame.utils
 *
 * @author Swg
 * @date 2018/3/5 13:48
 */
public class TimingButton extends AppCompatButton {
    private Context context;
    private Paint bcPaint, textPaint;
    private Paint timingBcPaint, timingTextPaint;
    private int width, height;
    private Date date;
    public static final long DAY_TIMESTAMP = 60 * 60 * 24;
    private final int textSize = 100;
    private int time;
    private static final String TAG = "TimingButton";

    public void setTime(int time) {
        this.time = time;
        Log.e(TAG, "setTime: " + time);
        invalidate();
    }

    public TimingButton(Context context, Date date) {
        super(context);
        this.date = date;
    }

    public TimingButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TimingButton);
        time = ta.getInt(R.styleable.TimingButton_time, 0);
        ta.recycle();

        init();
    }

    private void init() {
        bcPaint = new Paint();
        bcPaint.setColor(Color.WHITE);

        textPaint = new Paint();
        textPaint.setColor(Color.GRAY);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setTextSize(textSize);

        timingBcPaint = new Paint();
        timingBcPaint.setColor(Color.GRAY);

        timingTextPaint = new Paint();
        timingTextPaint.setColor(Color.BLACK);
        timingTextPaint.setTextAlign(Paint.Align.CENTER);
        timingTextPaint.setTextSize(textSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawTiming(canvas);
    }

    private void drawTiming(Canvas canvas) {
        canvas.drawRoundRect(getLeft(), getTop(), getRight(), getBottom(), 10, 100, timingBcPaint);

        if (time > DAY_TIMESTAMP) {
            String text = "超过一天";
            Log.e(TAG, "drawTiming: " + 'a');
            canvas.drawText(text, getWidth() / 2, getHeight() / 2 + textSize / 2, timingTextPaint);
        } else if (time == 0) {
            Log.e(TAG, "drawTiming: " + 'b');
            drawTimingEnd(canvas);
        } else {
            Log.e(TAG, "drawTiming: " + 'c');
            String text = Count.countTime(time);
            canvas.drawText(text, getWidth() / 2, getHeight() / 2 + textSize / 2, timingTextPaint);
        }
    }

    private void drawTimingEnd(Canvas canvas) {
        canvas.drawRoundRect(getLeft(), getTop(), getRight(), getBottom(), 10, 100, bcPaint);
        String text = "现已开售";
        canvas.drawText(text, getWidth() / 2, getHeight() / 2 + textSize / 2, timingTextPaint);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getMode(widthMeasureSpec);
        height = MeasureSpec.getMode(heightMeasureSpec);
    }

    public void startAnimation() {
        ObjectAnimator oa = ObjectAnimator.ofInt(this, "time", time / 100, 0);
        oa.setDuration(time * 10);
        Log.e(TAG, "startAnimation: " + time);
        oa.setInterpolator(new LinearInterpolator());
        oa.start();

    }
}


