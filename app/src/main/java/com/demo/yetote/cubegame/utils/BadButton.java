package com.demo.yetote.cubegame.utils;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.demo.yetote.cubegame.R;


/**
 * com.demo.yetote.cubegame.utils
 * 自定义按钮--反对
 *
 * @author Swg
 * @date 2018/2/26 11:03
 */
public class BadButton extends View {
    private Context context;
    private Bitmap unBadBitmap, badBitmap;
    private Paint unBadTextPaint, badTextPaint;
    private int width, height;
    private Boolean isChecked;
    private static final String TAG = "BadButton";
    private final int textSize = 50;
    /**
     * 图片旋转角度
     */
    private int rotate = 0;

    public void setRotate(int rotate) {
        this.rotate = rotate;
        invalidate();
    }

    public BadButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        TypedArray ta = context.obtainStyledAttributes(R.styleable.BadButton);
        isChecked = ta.getBoolean(R.styleable.BadButton_badButton_isChecked, true);
        rotate = ta.getInt(R.styleable.BadButton_badButton_rotate, 0);
        ta.recycle();

        initData();
    }

    public BadButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initData() {

        unBadTextPaint = new Paint();
        unBadTextPaint.setColor(ContextCompat.getColor(context, R.color.gray));
        //设置文字的基点为中心点
        unBadTextPaint.setTextAlign(Paint.Align.CENTER);
        unBadTextPaint.setTextSize(textSize);

        badTextPaint = new Paint();
        badTextPaint.setColor(ContextCompat.getColor(context, R.color.textColor));
        badTextPaint.setTextAlign(Paint.Align.CENTER);
        badTextPaint.setTextSize(textSize);
        badTextPaint.setStrokeWidth(10);

        unBadBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.un_bad);
        badBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bad);

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
            drawBitmap(canvas, badBitmap, "反对", badTextPaint);
        } else {
            drawBitmap(canvas, unBadBitmap, "取消", unBadTextPaint);
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
        if (isChecked) {
            canvas.save();

            canvas.clipRect(0,
                    0,
                    getRight(),
                    getBottom());
            canvas.rotate(rotate);

            canvas.drawBitmap(bitmap, 0, (height - bitmap.getHeight()) / 2, paint);

            canvas.restore();

            canvas.drawText(text,
                    (width - bitmap.getWidth()) / 2 + bitmap.getWidth(),
                    (height + textSize) / 2,
                    paint);
        } else {
            canvas.drawBitmap(bitmap, 0, (height - bitmap.getHeight()) / 2, paint);

            canvas.drawText(text,
                    (width - bitmap.getWidth()) / 2 + bitmap.getWidth(),
                    (height + textSize) / 2,
                    paint);
        }
    }

    /**
     * 绘制按钮按下时的动画
     */
    public void drawPressAnimation() {
        ObjectAnimator animator = ObjectAnimator.ofInt(this,
                "rotate",
                0, 20, 0);
        animator.setDuration(1000);
        animator.setInterpolator(new LinearInterpolator());
        animator.start();

        isChecked = !isChecked;
    }
}
