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
     *
     * @param v   recyclerView的item的view
     * @param tag itemView的id
     */
    void onClickListener(View v, int tag);

    /**
     * recyclerView的长按事件
     */
//    void onLongClickListener(View v, String tag);
}
