package com.demo.yetote.cubegame;

import android.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.demo.yetote.cubegame.adapter.HomePagerViewPagerAdapter;
import com.demo.yetote.cubegame.fragment.BoonFragment;
import com.demo.yetote.cubegame.fragment.CommunityFragment;
import com.demo.yetote.cubegame.fragment.GameLibFragment;
import com.demo.yetote.cubegame.fragment.HomePagerFragment;
import com.demo.yetote.cubegame.fragment.NewsFragment;

import java.util.ArrayList;

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
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        ArrayList<Fragment> fmList = new ArrayList<>();
        ArrayList<String> title = new ArrayList<>();

        toolbar.inflateMenu(R.menu.toolbar_menu);
        toolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                //搜索按钮
                case R.id.toolbar_search:
                    break;
                //分享按钮
                case R.id.toolbar_share:
                    break;
                default:
                    break;
            }
            return true;
        });

        fmList.add(new HomePagerFragment());
        fmList.add(new NewsFragment());
        fmList.add(new GameLibFragment());
        fmList.add(new BoonFragment());
        fmList.add(new CommunityFragment());

        title.add("首页");
        title.add("资讯");
        title.add("游戏库");
        title.add("福利");
        title.add("社区");

        tabLayout.addTab(tabLayout.newTab().setText("首页"));
        tabLayout.addTab(tabLayout.newTab().setText("资讯"));
        tabLayout.addTab(tabLayout.newTab().setText("游戏库"));
        tabLayout.addTab(tabLayout.newTab().setText("福利"));
        tabLayout.addTab(tabLayout.newTab().setText("社区"));

        HomePagerViewPagerAdapter adapter = new HomePagerViewPagerAdapter(getFragmentManager(), fmList, title);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }

    private void initViews() {
        tabLayout = findViewById(R.id.main_tabLayout);
        viewPager = findViewById(R.id.main_viewPager);
        toolbar = findViewById(R.id.main_toolbar);
    }

}
