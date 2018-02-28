package com.demo.yetote.cubegame.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import com.demo.yetote.cubegame.R;
import com.demo.yetote.cubegame.adapter.recyclerview.GameInfoForumAdapter;
import com.demo.yetote.cubegame.model.GameInfoForumModel;

import java.util.ArrayList;

/**
 * com.demo.yetote.cubegame.fragment
 * 游戏信息论坛
 *
 * @author Swg
 * @date 2018/2/7 14:28
 */
public class GameInfoForumFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private RecyclerView rv;
    private ArrayList<GameInfoForumModel> list;
    private GameInfoForumAdapter adapter;
    private Spinner spinner;
    private String[] spinnerItem = new String[]{"按时间排序", "按热度排序"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // TODO: 2018/2/7 游戏论坛fragment
        View v = inflater.inflate(R.layout.fragment_gameinfo_forum, container, false);

        initViews(v);

        initData();

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new GameInfoForumAdapter(getActivity(), list);
        rv.setAdapter(adapter);

        spinner.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, spinnerItem));
        spinner.setOnItemSelectedListener(this);

        return v;

    }

    private void initViews(View v) {
        rv = v.findViewById(R.id.fragment_gameinfo_forum_rv);
        spinner = v.findViewById(R.id.fragment_gameinfo_forum_spinner);
    }

    private void initData() {
        list = new ArrayList<>();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
