package com.demo.yetote.cubegame.utils;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.demo.yetote.cubegame.R;


/**
 * com.demo.yetote.cubegame.utils
 * 自定义按钮--I think OJbK
 *
 * @author Swg
 * @date 2018/2/11 11:00
 */
public class ExcellentButton extends View {
    private Context context;
    private Bitmap unExcellentBitmap, excellentBitmap;
    private Paint bitmapPaint;
    private Paint unExcellentTextPaint, excellentTextPaint;
    private int width, height;
    private Boolean isChecked;
    private static final String TAG = "ExcellentButton";
    private final int textSize = 50;
    /**
     * 图片旋转角度
     */
    private int rotate = 0;

    public void setRotate(int rotate) {
        this.rotate = rotate;
        invalidate();
    }

    public ExcellentButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        TypedArray ta = context.obtainStyledAttributes(R.styleable.ExcellentButton);
        isChecked = ta.getBoolean(R.styleable.ExcellentButton_excellentButton_isChecked, true);
        rotate = ta.getInt(R.styleable.ExcellentButton_rotate, 0);
        ta.recycle();

        initData();
    }

    public ExcellentButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initData() {
        bitmapPaint = new Paint();

        unExcellentTextPaint = new Paint();
        unExcellentTextPaint.setColor(ContextCompat.getColor(context, R.color.gray));
        //设置文字的基点为中心点
        unExcellentTextPaint.setTextAlign(Paint.Align.CENTER);
        unExcellentTextPaint.setTextSize(textSize);

        excellentTextPaint = new Paint();
        excellentTextPaint.setColor(ContextCompat.getColor(context, R.color.textColor));
        excellentTextPaint.setTextAlign(Paint.Align.CENTER);
        excellentTextPaint.setTextSize(textSize);
        excellentTextPaint.setStrokeWidth(10);

        unExcellentBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.un_excellent);
        excellentBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.excellent);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isChecked) {
            drawBitmap(canvas, excellentBitmap, "喜欢", excellentTextPaint);
        } else {
            drawBitmap(canvas, unExcellentBitmap, "不喜欢", unExcellentTextPaint);
        }
    }


    /**
     * 绘制按钮
     *
     * @param canvas 画板
     * @param bitmap 按钮的图片
     * @param text   按钮的文字
     */
    private void drawBitmap(Canvas canvas, Bitmap bitmap, String text, Paint paint) {
//        Bitmap newBitmap = CountBitmapScale.count(bitmap, width, height);

        canvas.save();
        canvas.clipRect(0,
                0,
                getRight(),
                getBottom());
        canvas.drawColor(Color.BLACK);
        //绘制经过变换之后的位图
        canvas.rotate(-rotate);
        canvas.drawBitmap(bitmap, 0, (height - bitmap.getHeight()) / 2, paint);
        canvas.restore();
        canvas.drawLine(0, getHeight()/2 , getWidth(), getHeight()/2 , excellentTextPaint);
        canvas.drawLine( getWidth() / 2,0,   getWidth() / 2, getHeight(),excellentTextPaint);
        canvas.drawText(text,
                (width - bitmap.getWidth()) / 2 + bitmap.getWidth()*2 - textSize,
                (height + textSize)/2,
                paint);
    }


    /**
     * 绘制按钮按下时的动画
     */
    public void drawPressAnimation() {
        ObjectAnimator animator = ObjectAnimator.ofInt(this,
                "rotate",
                0, 30, 0);
        animator.setDuration(1000);
        animator.setInterpolator(new LinearInterpolator());
        animator.start();

    }
}
