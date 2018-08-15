package com.demo.yetote.cubegame.utils;

import java.util.Random;

/**
 * 生成随机点
 */
public class RandomPoint {
    /**
     * 生成随机点
     *
     * @param x 点的x值范围，从0开始
     * @param y 点的y值范围，从0开始
     * @return 二维元祖
     */
    public static TwoTuple Point(int x, int y) {
        return Point(0, 0, x, y);
    }

    /**
     * 生成随机点
     *
     * @param xMin x的最小值
     * @param yMin y的最小值
     * @param xMax x的最大值
     * @param yMax y的最大值
     */
    public static TwoTuple Point(int xMin, int yMin, int xMax, int yMax) {
        Random random = new Random();
        int x = random.nextInt(xMax) + xMin;
        if (x >= xMax) x = x - xMin;
        int y = random.nextInt(yMax) + yMin;
        if (y >= yMax) y = y - yMin;
        return new TwoTuple(x, y);
    }
}
