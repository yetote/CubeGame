package com.demo.yetote.cubegame.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.yetote.cubegame.R;

/**
 * com.demo.yetote.cubegame.fragment
 * 游戏信息论坛
 *
 * @author Swg
 * @date 2018/2/7 14:28
 */
public class GameInfoForumFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gameinfo_forum, container, false);
        return v;
        // TODO: 2018/2/7 游戏论坛fragment
    }
}
