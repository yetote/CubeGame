package com.demo.yetote.cubegame.adapter.viewpager;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.Nullable;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * com.demo.yetote.cubegame.adapter.viewPagerAdapter
 * 游戏讯息中viewpager的适配器
 *
 * @author Swg
 * @date  2018/2/27 10:08
 */
public class GameInfoViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragment;

    public GameInfoViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragment) {
        super(fm);
        this.fragment = fragment;
    }

    @Override
    public Fragment getItem(int position) {
        return fragment.get(position);
    }

    @Override
    public int getCount() {
        return fragment.size();
    }

}
