package com.demo.yetote.cubegame.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.yetote.cubegame.R;
import com.demo.yetote.cubegame.adapter.recyclerview.GameLibAdapter;
import com.demo.yetote.cubegame.model.GameLibModel;

import java.util.ArrayList;

/**
 * com.demo.yetote.cubegame.fragment
 * 游戏库
 *
 * @author Swg
 * @date 2018/1/16 14:29
 */
public class GameLibFragment extends Fragment {
    private TabLayout tabLayout;
    private RecyclerView rv;
    private GameLibAdapter adapter;
    private ArrayList<GameLibModel> list;
    private String[] tabTitles = new String[]{"全部 ", "口碑 ", "仙剑 ", "轩辕剑", "解谜 ", "动作 ", "策略 ", "日漫 ", "AVG",
            "轻松 ", "射击 ", "唯美 ", "5元区", "免费 ", "国产 ", "ARP", "怀旧 ", "试玩 ", "育碧 ", "养成 ", "预告 "};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gamelib, container, false);

        initViews(v);
        initData();

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new GameLibAdapter(getActivity(), list);
        rv.setAdapter(adapter);

        return v;
    }

    private void initData() {
        for (String title : tabTitles) {
            tabLayout.addTab(tabLayout.newTab().setText(title));
        }

        list = new ArrayList<>();
        list.add(new GameLibModel("仙剑免费了", "怀旧", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557936372&di=3ee2f22625a88beaee1c6319923d13c4&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201503%2F30%2F20150330181805_sPeci.jpeg", "8.5", 1));
        list.add(new GameLibModel("侠客免费了", "经典", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557936371&di=f4ef540a9431017e3f3e72d2ae0e0655&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201311%2F13%2F20131113142737_KXGQ2.jpeg", "8.7", 2));
        list.add(new GameLibModel("吃鸡免费了", "口碑", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557936367&di=99bb70e3a11f99068b58ae4f0539581a&imgtype=0&src=http%3A%2F%2Fimg3.xiazaizhijia.com%2Fwalls%2F20151211%2Fmid_37926366cfebca0.jpg", "8.6", 3));
        list.add(new GameLibModel("炉石免费了", "国产", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557936364&di=3b5e132b93944fbfa9fbea13223cd45b&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201403%2F14%2F20140314204125_sFTEC.jpeg", "8.7", 4));
        list.add(new GameLibModel("魔兽免费了", "怀旧", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557936394&di=1c00135dbd9b817e0d0cbfcbdc16c34f&imgtype=0&src=http%3A%2F%2Fwww.285868.com%2Fuploadfile%2F2016%2F1024%2F20161024023117384.jpg", "8.6", 5));
        list.add(new GameLibModel("星际免费了", "解谜", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557936394&di=1715c7b41e6b1dd069061ac67054dfbb&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201409%2F20%2F20140920115054_nBMNc.png", "8.7", 6));
        list.add(new GameLibModel("梦幻免费了", "怀旧", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557936393&di=7e2fdc63316e4154b7db8310e8a3d21f&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201408%2F11%2F20140811200231_BfmyU.jpeg", "8.9", 7));
        list.add(new GameLibModel("大话免费了", "独立", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557936392&di=72adf3176f3725fe15c91ae928f68c84&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201311%2F13%2F20131113145610_taBZs.jpeg", "8.1", 8));
        list.add(new GameLibModel("诛仙免费了", "经典", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557936389&di=52de142a443209c26cbb6e8e0440e7a2&imgtype=0&src=http%3A%2F%2Fcdn.duitang.com%2Fuploads%2Fitem%2F201407%2F22%2F20140722212229_imKZk.jpeg", "8.3", 9));
        list.add(new GameLibModel("寻仙免费了", "唯美", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557936386&di=a5a92c4291811578ed9705183eeb6760&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201408%2F11%2F20140811200850_LUY5c.png", "8.2", 10));
        list.add(new GameLibModel("驯龙免费了", "独立", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557998343&di=b4c2ebe5bc2e97a9e8d125b0d2cae4c9&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201409%2F09%2F20140909231305_xRuhz.png", "8.5", 11));
    }

    private void initViews(View v) {
        tabLayout = v.findViewById(R.id.fragment_gameLib_tabLayout);
        rv = v.findViewById(R.id.fragment_gameLib_rv);
    }
}
