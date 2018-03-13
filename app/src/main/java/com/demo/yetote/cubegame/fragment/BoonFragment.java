package com.demo.yetote.cubegame.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.yetote.cubegame.R;
import com.demo.yetote.cubegame.adapter.recyclerview.BoonAdapter;
import com.demo.yetote.cubegame.model.BoonModel;

import java.util.ArrayList;

/**
 * com.demo.yetote.cubegame.fragment
 * 福利
 *
 * @author Swg
 * @date 2018/1/16 14:28
 */
public class BoonFragment extends Fragment {
    private RecyclerView rv;
    private ArrayList<BoonModel> list;
    private BoonAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // TODO: 2018/1/16 福利fragment
        View v = inflater.inflate(R.layout.fragment_boon, container, false);

        initViews(v);
        initData();

        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapter = new BoonAdapter(getActivity(), list);
        rv.setAdapter(adapter);

        return v;
    }

    private void initViews(View v) {
        rv = v.findViewById(R.id.fragment_boon_rv);
    }

    private void initData() {
        list = new ArrayList<>();
    }
}
