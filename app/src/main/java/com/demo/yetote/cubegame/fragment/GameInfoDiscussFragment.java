package com.demo.yetote.cubegame.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.yetote.cubegame.R;
import com.demo.yetote.cubegame.adapter.recyclerview.GameInfoDiscussAdapter;
import com.demo.yetote.cubegame.model.GameInfoDiscussModel;

import java.util.ArrayList;

/**
 * com.demo.yetote.cubegame.fragment
 * 游戏信息评论
 *
 * @author Swg
 * @date 2018/2/7 14:28
 */
public class GameInfoDiscussFragment extends Fragment {
    private static final String TAG = "GameInfoDiscussFragment";
    private RecyclerView rv;
    private GameInfoDiscussAdapter adapter;
    private ArrayList<GameInfoDiscussModel> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gameinfo_discuss, container, false);
        // TODO: 2018/2/7 游戏评论
        initViews(v);
        initData();

        adapter = new GameInfoDiscussAdapter(list, getActivity());
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adapter);

        return v;
    }

    private void initData() {
        list = new ArrayList<>();
    }

    private void initViews(View v) {
        rv = v.findViewById(R.id.fragment_gameinfo_discuss_rv);
    }
}
