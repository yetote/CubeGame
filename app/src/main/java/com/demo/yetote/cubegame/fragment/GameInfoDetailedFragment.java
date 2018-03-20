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
import android.widget.Button;
import android.widget.TextView;

import com.demo.yetote.cubegame.R;

import com.demo.yetote.cubegame.adapter.recyclerview.GameInfoPicAdapter;
import com.demo.yetote.cubegame.adapter.recyclerview.GameInfoThemeAdapter;
import com.demo.yetote.cubegame.model.GameInfoPicModel;
import com.demo.yetote.cubegame.model.GameInfoThemeModel;

import java.util.ArrayList;

/**
 * com.demo.yetote.cubegame.fragment
 * 游戏信息详情
 *
 * @author Swg
 * @date 2018/2/7 14:27
 */
public class GameInfoDetailedFragment extends Fragment {
    private RecyclerView picRv;
    private RecyclerView themeRv;
    private TextView developerWordsContent, gameBcContent, downloadNum, version, apkSize, manufacturer;
    private Button developerWordsShowMore, gameBcShowMore;
    private GameInfoPicAdapter picAdapter;
    private GameInfoThemeAdapter themeAdapter;
    private ArrayList<GameInfoPicModel> picList;
    private ArrayList<GameInfoThemeModel> themeList;
    private static final String TAG = "GameInfoDetailedFragmen";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gameinfo_detailed, container, false);
        initViews(v);
        initData();
        Log.e(TAG, "onCreateView: " + "a");
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
        // TODO: 2018/3/18 tset
        picList.add(new GameInfoPicModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854233&di=cf3bcab5c0e3ee4deb851b2b26c3b055&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F5ab5c9ea15ce36d3f7ff9d2136f33a87e950b123.jpg"));
        picList.add(new GameInfoPicModel("https://ss3.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=ea376b0a7e0e0cf3bff748fb3a46f23d/adaf2edda3cc7cd9f775f2c13501213fb80e914a.jpg"));
        picList.add(new GameInfoPicModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854231&di=fa395a127c118f075241fec30752d4cc&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Ffaf2b2119313b07e824d771800d7912397dd8c29.jpg"));
        picList.add(new GameInfoPicModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521385264791&di=2181b33ec97e75a990820f7849ebf463&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F18d8bc3eb13533fa434d443ea4d3fd1f41345b23.jpg"));
        picList.add(new GameInfoPicModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521385648469&di=2646274010a3dd82c841dd9e70de8242&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fb3119313b07eca807eff4cff9d2397dda144832b.jpg"));
        picList.add(new GameInfoPicModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521385648469&di=f2393359939578f829fbf9405fae3a48&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fbd3eb13533fa828bc264e8fbf11f4134970a5a66.jpg"));
        picList.add(new GameInfoPicModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521385648469&di=bd55edfec49cae8e68874be0356a9974&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F8718367adab44aedec01cafcbf1c8701a18bfb5f.jpg"));
        picList.add(new GameInfoPicModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521385648468&di=ecadd31efb0e7ed417dad0524a3209dd&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F4b90f603738da9778360f233bc51f8198618e35f.jpg"));
        picList.add(new GameInfoPicModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854232&di=529a7b60aaa03551a757d58c34036772&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fcc11728b4710b912c87f7fedcffdfc0392452262.jpg"));

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
