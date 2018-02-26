package com.demo.yetote.cubegame;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * com.demo.yetote.cubegame
 * 游戏讯息
 *
 * @author Swg
 * @date 2018/2/2 14:13
 */
public class GameInfoActivity extends AppCompatActivity {
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_info);
        initViews();

        tabLayout.addTab(tabLayout.newTab().setText("详情"));
        tabLayout.addTab(tabLayout.newTab().setText("评价"));
        tabLayout.addTab(tabLayout.newTab().setText("论坛"));

    }

    private void initViews() {
        tabLayout = findViewById(R.id.gameinfo_tablayout);
    }
}
