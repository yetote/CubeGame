package com.demo.yetote.cubegame.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/**
 * com.demo.yetote.cubegame.utils
 * 计算图片比例，并根据比例放大或缩小
 *
 * @author Swg
 * @date 2018/2/11 11:50
 */
class CountBitmapScale {

    /**
     * 变换图片
     *
     * @param bitmap 变换的位图
     * @param width  期望位图的宽
     * @param height 期望位图的高
     * @return 变换之后的位图
     */
    static public Bitmap count(Bitmap bitmap, int width, int height) {
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();

        float scaleWidth = width / bitmapWidth;
        float scaleHeight = height / bitmapHeight;


        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);

        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

}
