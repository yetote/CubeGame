package com.demo.yetote.cubegame.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.yetote.cubegame.R;
import com.demo.yetote.cubegame.adapter.HomePagerRVAdapter;
import com.demo.yetote.cubegame.model.HomePgaerModel;

import java.util.ArrayList;

/**
 * com.demo.yetote.cubegame.fragment
 * 首页
 *
 * @author Swg
 * @date 2018/1/16 14:29
 */
public class HomePagerFragment extends Fragment {
    private RecyclerView rv;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_homepager, container,false);

        initViews(v);

        ArrayList<HomePgaerModel> list = new ArrayList<>();
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        HomePagerRVAdapter adapter = new HomePagerRVAdapter(getActivity(), list);
        rv.setAdapter(adapter);

        return v;
    }

    private void initViews(View v) {
        viewPager = v.findViewById(R.id.fragment_homePager_viewPager);
        rv = v.findViewById(R.id.fragment_homePager_rv);
    }
}
