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
 * 福利
 *
 * @author Swg
 * @date 2018/1/16 14:28
 */
public class BoonFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_boon, container,false);
        return v;
        // TODO: 2018/1/16 福利fragment
    }
}
