package com.demo.yetote.cubegame.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.yetote.cubegame.R;

/**
 * com.demo.yetote.cubegame.fragment
 * 游戏信息评论
 *
 * @author Swg
 * @date 2018/2/7 14:28
 */
public class GameInfoDiscussFragment extends Fragment {
    private static final String TAG = "GameInfoDiscussFragment";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gameinfo_discuss, container, false);
        Log.e(TAG, "onCreateView: "+"2" );
        return v;
        // TODO: 2018/2/7 游戏评论
    }
}
