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
import com.demo.yetote.cubegame.adapter.recyclerview.NewsRvAdapter;
import com.demo.yetote.cubegame.model.NewsModel;

import java.util.ArrayList;

/**
 * com.demo.yetote.cubegame.fragment
 * 咨讯
 *
 * @author Swg
 * @date 2018/1/16 14:29
 */
public class NewsFragment extends Fragment {
    private RecyclerView rv;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // TODO: 2018/ 2/26 资讯fragment
        View v = inflater.inflate(R.layout.fragment_news, container, false);

        initViews(v);

        ArrayList<NewsModel> list = new ArrayList<>();
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        NewsRvAdapter adapter = new NewsRvAdapter(getActivity(), list);
        rv.setAdapter(adapter);
        return v;
    }

    private void initViews(View v) {
        viewPager = v.findViewById(R.id.fragment_news_viewPager);
        rv = v.findViewById(R.id.fragment_news_rv);
    }

}
