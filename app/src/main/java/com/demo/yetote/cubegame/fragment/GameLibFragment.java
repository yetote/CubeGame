package com.demo.yetote.cubegame.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.yetote.cubegame.R;
import com.demo.yetote.cubegame.adapter.recyclerview.GameLibAdapter;
import com.demo.yetote.cubegame.model.GameLibModel;

import java.util.ArrayList;

/**
 * com.demo.yetote.cubegame.fragment
 * 游戏库
 *
 * @author Swg
 * @date 2018/1/16 14:29
 */
public class GameLibFragment extends Fragment {
    private TabLayout tabLayout;
    private RecyclerView rv;
    private GameLibAdapter adapter;
    private ArrayList<GameLibModel> list;
    private String[] tabTitles = new String[]{"全部 ", "口碑 ", "仙剑 ", "轩辕剑", "解谜 ", "动作 ", "策略 ", "日漫 ", "AVG",
            "轻松 ", "射击 ", "唯美 ", "5元区", "免费 ", "国产 ", "ARP", "怀旧 ", "试玩 ", "育碧 ", "养成 ", "预告 "};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gamelib, container, false);

        initViews(v);
        initData();

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new GameLibAdapter(getActivity(), list);
        rv.setAdapter(adapter);

        return v;
    }

    private void initData() {
        for (String title : tabTitles) {
            tabLayout.addTab(tabLayout.newTab().setText(title));
        }

        list = new ArrayList<>();
    }

    private void initViews(View v) {
        tabLayout = v.findViewById(R.id.fragment_gameLib_tabLayout);
        rv = v.findViewById(R.id.fragment_gameLib_rv);
    }
}
