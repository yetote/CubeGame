package com.demo.yetote.cubegame;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * com.demo.yetote.cubegame
 * 主页
 *
 * @author Swg
 * @date 2018/1/16 14:28
 */
public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        tabLayout.addTab(tabLayout.newTab().setText("首页"));
        tabLayout.addTab(tabLayout.newTab().setText("资讯"));
        tabLayout.addTab(tabLayout.newTab().setText("游戏库"));
        tabLayout.addTab(tabLayout.newTab().setText("福利"));
        tabLayout.addTab(tabLayout.newTab().setText("社区"));

        tabLayout.setupWithViewPager(viewPager);
    }

    private void initViews() {
        tabLayout = findViewById(R.id.main_tabLayout);
        viewPager = findViewById(R.id.main_viewPager);
    }
}
