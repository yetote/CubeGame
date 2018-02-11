package com.demo.yetote.cubegame.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.demo.yetote.cubegame.R;
import com.demo.yetote.cubegame.adapter.GameInfoPicAdapter;
import com.demo.yetote.cubegame.adapter.GameInfoThemeAdapter;
import com.demo.yetote.cubegame.model.GameInfoPicModel;
import com.demo.yetote.cubegame.model.GameInfoThemeModel;

import java.util.ArrayList;

/**
 * com.demo.yetote.cubegame.fragment
 * 游戏信息
 *
 * @author Swg
 * @date 2018/2/7 14:27
 */
public class GameInfoFragment extends Fragment {
    private RecyclerView picRv;
    private RecyclerView themeRv;
    private TextView developerWordsContent, gameBcContent, downloadNum, version, apkSize, manufacturer;
    private Button developerWordsShowMore, gameBcShowMore;
    private GameInfoPicAdapter picAdapter;
    private GameInfoThemeAdapter themeAdapter;
    private ArrayList<GameInfoPicModel> picList;
    private ArrayList<GameInfoThemeModel> themeList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_game_info, container, false);
        initViews(v);
        initData();

        picRv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        picAdapter = new GameInfoPicAdapter(getActivity(), picList);
        picRv.setAdapter(picAdapter);

        themeRv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        themeAdapter = new GameInfoThemeAdapter(getActivity(), themeList);
        themeRv.setAdapter(themeAdapter);

        return v;
    }

    private void initData() {
        picList = new ArrayList<>();
        themeList = new ArrayList<>();

    }

    private void initViews(View v) {
        picRv = v.findViewById(R.id.fragment_game_info_img);
        themeRv = v.findViewById(R.id.fragment_game_info_manufacturerTheme);
        developerWordsContent = v.findViewById(R.id.fragment_game_info_developerWords_content);
        gameBcContent = v.findViewById(R.id.fragment_game_info_gamebc_content);
        downloadNum = v.findViewById(R.id.fragment_game_info_detailed_downloadNum_content);
        version = v.findViewById(R.id.fragment_game_info_detailed_version_content);
        apkSize = v.findViewById(R.id.fragment_game_info_detailed_size_content);
        manufacturer = v.findViewById(R.id.fragment_game_info_detailed_manufacturer_content);
        developerWordsShowMore = v.findViewById(R.id.fragment_game_info_developerWords_showMore);
        gameBcShowMore = v.findViewById(R.id.fragment_game_info_gamebc_showMore);
    }


}
