package com.demo.yetote.cubegame.adapter.viewpager;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.Nullable;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * com.demo.yetote.cubegame.adapter
 * news中viewPager的适配器
 *
 * @author Swg
 * @date 2018/1/18 15:13
 */
public class NewsViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> list;
    private ArrayList<String> title;

    public NewsViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> list, ArrayList<String> title) {
        super(fm);
        this.list = list;
        this.title = title;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}