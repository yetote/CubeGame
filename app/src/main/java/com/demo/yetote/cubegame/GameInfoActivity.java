package com.demo.yetote.cubegame;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.demo.yetote.cubegame.adapter.viewpager.GameInfoViewPagerAdapter;
import com.demo.yetote.cubegame.fragment.GameInfoDetailedFragment;
import com.demo.yetote.cubegame.fragment.GameInfoDiscussFragment;
import com.demo.yetote.cubegame.fragment.GameInfoForumFragment;
import com.demo.yetote.cubegame.model.GameInfoTabLayoutModel;

import java.util.ArrayList;

/**
 * com.demo.yetote.cubegame
 * 游戏讯息
 *
 * @author Swg
 * @date 2018/2/2 14:13
 */
public class GameInfoActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentsList;
    private ArrayList<GameInfoTabLayoutModel> numList;
    private GameInfoViewPagerAdapter adapter;
    private String[] titleArr = new String[]{"详情", "评价", "论坛"};
    /**
     * 显示的数字的最大值
     */
    public static final int MAX_NUM = 10000;
    private static final String TAG = "GameInfoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_info);
        initViews();
        initData();

        adapter = new GameInfoViewPagerAdapter(getFragmentManager(), fragmentsList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        setTab();

        tabLayout.addOnTabSelectedListener(this);

    }

    /**
     * 为TabLayout添加自定义Tab
     */
    private void setTab() {
        for (int i = 0; i < adapter.getCount(); i++) {
            Log.e(TAG, "setTab: " + i);
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(R.layout.item_game_tablayout);
            TextView title = tab.getCustomView().findViewById(R.id.item_game_info_tabLayout_title);
            TextView num = tab.getCustomView().findViewById(R.id.item_game_info_tabLayout_num);
            title.setText(titleArr[i]);
            switch (i) {
                case 0:
                    tab.getCustomView().findViewById(R.id.item_game_info_tabLayout_title).setSelected(true);
                    tab.getCustomView().findViewById(R.id.item_game_info_tabLayout_num).setVisibility(View.GONE);
                    break;
                case 1:
                    if (numList.get(0).getEvaluateNum() >= MAX_NUM) {
                        num.setText("1万+");
                    } else {
                        num.setText(numList.get(0).getEvaluateNum() + "");
                    }
                    break;
                case 2:
                    if (numList.get(0).getThemeNum() >= MAX_NUM) {
                        num.setText("1万+");
                    } else {
                        num.setText(numList.get(0).getThemeNum() + "");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void initData() {
        fragmentsList = new ArrayList<>();

        fragmentsList.add(new GameInfoDetailedFragment());
        fragmentsList.add(new GameInfoDiscussFragment());
        fragmentsList.add(new GameInfoForumFragment());

        numList = new ArrayList<>();
        // TODO: 2018/2/27 numList内容为测试使用，应删除
        numList.add(new GameInfoTabLayoutModel(1000, 15264));
    }

    private void initViews() {
        tabLayout = findViewById(R.id.gameinfo_tablayout);
        viewPager = findViewById(R.id.gameinfo_viewPager);
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        tab.getCustomView().findViewById(R.id.item_game_info_tabLayout_title).setSelected(true);
        tab.getCustomView().findViewById(R.id.item_game_info_tabLayout_num).setSelected(true);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        tab.getCustomView().findViewById(R.id.item_game_info_tabLayout_title).setSelected(false);
        tab.getCustomView().findViewById(R.id.item_game_info_tabLayout_num).setSelected(false);
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
