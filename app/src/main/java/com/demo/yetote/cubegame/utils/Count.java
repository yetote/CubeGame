package com.demo.yetote.cubegame.utils;

import android.util.Log;

/**
 * com.demo.yetote.cubegame.utils
 * 计算一些数学上的东西
 *
 * @author Swg
 * @date 2018/3/5 15:26
 */
public class Count {
    private static final String TAG = "Count";

    /**
     * 倒计时
     *
     * @param date 时间戳
     * @return 字符类型的倒计时
     */
    public static String countTime(long date) {
        int hour = (int) (date / 60 / 60);
        int min = (int) (date / 60);
        int sec = (int) (date % 60);
        Log.e(TAG, "countTime: " + date);
        return hour + ":" + min + ":" + sec;
    }
}
