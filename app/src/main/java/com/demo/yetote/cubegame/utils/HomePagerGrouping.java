package com.demo.yetote.cubegame.utils;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * com.demo.yetote.cubegame.utils
 * 添加分组信息
 *
 * @author Swg
 * @date 2018/1/19 13:32
 */
public class HomePagerGrouping extends RecyclerView.ItemDecoration {
    private Paint mPaint, mTextPaint;
    private String[] tags;

    public HomePagerGrouping(String[] tags) {
        this.tags = tags;
        mPaint = new Paint();
        mPaint.setColor(Color.GRAY);
        mTextPaint = new Paint();
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setStrokeWidth(16);
    }


    /**
     * 设置itemView偏移量
     *
     * @param outRect 偏移的矩形
     * @param view    指定View
     * @param parent  recyclerView
     * @param state   标志
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        RecyclerView.LayoutManager manager = parent.getLayoutManager();

        int position = parent.getChildAdapterPosition(view);
        //ItemView的position==0 或者 当前ItemView的data的tag和上一个ItemView的不相等，则为当前ItemView设置top 偏移量
        if (position == 0 || !tags[position].equals(tags[position - 1])) {
            outRect.set(0, 20, 0, 0);
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        for (int i = 0; i < parent.getChildCount(); i++) {
            View v = parent.getChildAt(i);
            int position = parent.getChildAdapterPosition(v);
            String tag = tags[i];
            if (position == 0 || !tags[i].equals(tags[i - 1])) {
                drawGroupHeader(c, parent, v, tag);
            }
        }
    }

    /**
     * 绘制分组
     *
     * @param c      画板
     * @param parent recyclerView
     * @param v      子itemView
     * @param tag    分组标题
     */
    private void drawGroupHeader(Canvas c, RecyclerView parent, View v, String tag) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) v.getLayoutParams();
        int left = parent.getPaddingLeft();
        int right = parent.getPaddingRight();
        int top = parent.getPaddingTop();
        int bottom = parent.getPaddingBottom();
        c.drawRect(left, top, right, bottom, mPaint);
        int x = left + 2;
        int y = 2;
        c.drawText(tag, x, y, mTextPaint);
    }
}
