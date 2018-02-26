package com.demo.yetote.cubegame.utils;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.demo.yetote.cubegame.R;

/**
 * com.demo.yetote.cubegame.utils
 * 评分按钮
 *
 * @author Swg
 * @date 2018/2/2 16:06
 */
public class ScoreButton extends View {
    private Context context;
    /**
     * 小圆画笔
     */
    private Paint smallCirclePaint;
    /**
     * 大圆画笔
     */
    private Paint bigCirclePaint;
    /**
     * 评分画笔
     */
    private Paint textPaint, scorePaint;
    private float smallCircleRadius, bigCircleRadius;
    private int centerX, centerY;
    private int width, height;
    private int textSize, scoreSize;
    private float score;

    public ScoreButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.context = context;

        TypedArray ta = context.obtainStyledAttributes(R.styleable.ScoreButton);
        score = ta.getFloat(R.styleable.ScoreButton_score, 0);
        ta.recycle();

        initData();
    }


    private void initData() {
        textSize = 50;
        scoreSize = 75;

        smallCirclePaint = new Paint();
        smallCirclePaint.setStyle(Paint.Style.FILL);
        smallCirclePaint.setColor(ContextCompat.getColor(context, R.color.lightseagreen));
        smallCirclePaint.setStrokeWidth(100);

        bigCirclePaint = new Paint();
        bigCirclePaint.setStyle(Paint.Style.FILL);


        textPaint = new Paint();
        textPaint.setTextSize(textSize);
        textPaint.setColor(Color.WHITE);
        textPaint.setStrokeWidth(100);

        scorePaint = new Paint();
        scorePaint.setTextSize(scoreSize);
        scorePaint.setColor(Color.WHITE);
        //绘制文字的基点为中心点
        scorePaint.setTextAlign(Paint.Align.CENTER);

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
        smallCircleRadius = bigCircleRadius - 10;

        centerX = getLeft() + width / 2;
        centerY = getTop() + height / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBigCircle(canvas);
        drawSmallCircle(canvas);
    }

    /**
     * 画大圆
     *
     * @param canvas 画板
     */
    private void drawBigCircle(Canvas canvas) {
        Shader shader = new LinearGradient((float) (centerX + smallCircleRadius * Math.sin((Math.PI / 180) * 60)),
                (float) (centerY - smallCircleRadius * Math.cos((Math.PI / 180) * 60)),
                (float) (centerX - smallCircleRadius * Math.sin((Math.PI / 180) * 60)),
                (float) (centerY + smallCircleRadius * Math.cos((Math.PI / 180) * 60)),
                ContextCompat.getColor(context, R.color.aliceblue),
                ContextCompat.getColor(context, R.color.teal),
                Shader.TileMode.CLAMP);
        bigCirclePaint.setShader(shader);
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
        * 直接可以通过中心点减去文字的宽高就可以求出文字的起始位置了
        * */

        canvas.drawText("评分", centerX - textSize, centerY - smallCircleRadius / 2 + textSize / 2, textPaint);
        canvas.drawText(score + "", centerX, centerY + smallCircleRadius / 2 + scoreSize / 3, scorePaint);
    }
}
