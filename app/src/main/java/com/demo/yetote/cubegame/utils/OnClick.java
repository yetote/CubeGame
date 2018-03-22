package com.demo.yetote.cubegame.utils;

import android.view.View;

/**
 * com.demo.yetote.cubegame.utils
 *
 * @author Swg
 * @date 2018/3/22 21:41
 */
public interface OnClick {
    /**
     * recyclerView的点击事件
     */
    void onClickListener(View v, String tag);

    /**
     * recyclerView的长按事件
     */
//    void onLongClickListener(View v, String tag);
}
