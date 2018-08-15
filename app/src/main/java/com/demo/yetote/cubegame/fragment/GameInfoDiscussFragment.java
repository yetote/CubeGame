package com.demo.yetote.cubegame.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.yetote.cubegame.DetailedDiscussActivity;
import com.demo.yetote.cubegame.GameInfoActivity;
import com.demo.yetote.cubegame.R;
import com.demo.yetote.cubegame.adapter.recyclerview.GameInfoDiscussAdapter;
import com.demo.yetote.cubegame.model.GameInfoDiscussModel;
import com.demo.yetote.cubegame.service.GameInfoDiscussService;
import com.demo.yetote.cubegame.utils.Config;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * com.demo.yetote.cubegame.fragment
 * 游戏信息评论
 *
 * @author Swg
 * @date 2018/2/7 14:28
 */
public class GameInfoDiscussFragment extends Fragment {
    private static final String TAG = "GameInfoDiscussFragment";
    private RecyclerView rv;
    private GameInfoDiscussAdapter adapter;
    private ArrayList<GameInfoDiscussModel> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gameinfo_discuss, container, false);
        // TODO: 2018/2/7 游戏评论
        initViews(v);
        initData();

        adapter = new GameInfoDiscussAdapter(list, getActivity());
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adapter);

        adapter.setListener((v1, tag) -> {
            Intent i = new Intent();
            i.setClass(getActivity(), DetailedDiscussActivity.class);
            startActivity(i);
        });
//        requestData();
        return v;
    }

    private void requestData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GameInfoDiscussService discussService = retrofit.create(GameInfoDiscussService.class);

        discussService.getData()
                .observeOn(Schedulers.newThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(gameInfoDiscussModels -> {
                    list.addAll(gameInfoDiscussModels);
                    adapter.notifyDataSetChanged();
                });
    }

    private void initData() {
        list = new ArrayList<>();
        list.add(new GameInfoDiscussModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521385648468&di=47cec5dbb8bf70d4710f09e58de4ee8d&imgtype=0&src=http%3A%2F%2Fg.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fae51f3deb48f8c54d2a0b13736292df5e0fe7fb2.jpg", "2017-12-18", "a", "a", "1900", "212311313", "huawei mate8", "liu", "2", 1, 12, 10, 92));
        list.add(new GameInfoDiscussModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521385648468&di=f185ab624c8030d4995f9eaa7bcdfb26&imgtype=0&src=http%3A%2F%2Fh.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F7dd98d1001e939010e71f92677ec54e736d196b2.jpg", "2017-12-18", "b", "aa", "1600", "212311313", "huawei mate9", "liu", "2", 2, 122, 120, 91));
        list.add(new GameInfoDiscussModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521385648468&di=a641414ce2a95374cc455ae258d01d20&imgtype=0&src=http%3A%2F%2Fh.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F37d3d539b6003af335c8a878392ac65c1038b6b3.jpg", "2017-12-18", "c", "af", "15600", "212311313", "huawei mate10", "liu", "2", 3, 142, 110, 29));
        list.add(new GameInfoDiscussModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521385648467&di=646b4aeca7a50ebb86c3d0eb4eda6cf2&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F9a504fc2d5628535df92a6399cef76c6a7ef63b3.jpg", "2017-12-18", "d", "af", "1260", "212311313", "huawei mate11", "liu", "2", 4, 142, 120, 91));
        list.add(new GameInfoDiscussModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521385648467&di=a567fc4f9422e7b21ec21f5940f77ea8&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F96dda144ad34598293c4918a00f431adcbef845f.jpg", "2017-12-18", "e", "afa", "12960", "212311313", "huawei mate12", "liu", "2", 5, 42, 110, 29));
        list.add(new GameInfoDiscussModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521385648467&di=a567fc4f9422e7b21ec21f5940f77ea8&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F96dda144ad34598293c4918a00f431adcbef845f.jpg", "2017-12-18", "f", "aa", "1260", "212311313", "huawei mate123", "liu", "2", 6, 132, 120, 19));
        list.add(new GameInfoDiscussModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521385648467&di=95b041cbb104b233cb717e0a2a7cb491&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fd52a2834349b033b53c188c219ce36d3d539bd58.jpg", "2017-12-18", "g", "af", "1800", "212311313", "huawei mate15", "liu", "2", 7, 124, 110, 92));
        list.add(new GameInfoDiscussModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521385648466&di=ea738255af2208d8b3db3be9a42ac2ca&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fb2de9c82d158ccbf31fdc02215d8bc3eb1354160.jpg", "2017-12-18", "h", "aav", "1290", "212311313", "huawei mate8", "liu", "2", 8, 126, 120, 91));
        list.add(new GameInfoDiscussModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521385648466&di=9b8c1181698293daa0acc612eb83f148&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F4b90f603738da97782dbf333bc51f8198618e336.jpg", "2017-12-18", "i", "va", "1920", "212311313", "huawei mate7", "liu", "2", 9, 127, 110, 92));
        list.add(new GameInfoDiscussModel("https://ss2.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=b3d3dd3ef1faaf519be387bfbc5594ed/738b4710b912c8fcbe0683d5f0039245d6882134.jpg", "2017-12-18", "a", "a", "1900", "219+5+651313", "xiaomi mate8", "lu", "我是小米", 10, 1532, 130, 94));
        list.add(new GameInfoDiscussModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521385264789&di=2498c3a856e2ecf0463461fb1167acff&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F2fdda3cc7cd98d105c9f28202d3fb80e7bec9053.jpg", "2017-12-18", "k", "vaa", "1600", "212311313", "huawei mate6", "liu", "2", 11, 182, 120, 1));
        list.add(new GameInfoDiscussModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521385264788&di=27d51342a189ebfc7b9a6d5c01cc5125&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F8b82b9014a90f603e0fbcf573512b31bb051ed53.jpg", "2017-12-18", "l", "aa", "1600", "212311313", "huawei mate4", "liu", "2", 12, 172, 110, 92));
        list.add(new GameInfoDiscussModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521385648468&di=a777dbf4a04a2649ddded6d6d630e0b2&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F5882b2b7d0a20cf415e38ac77a094b36acaf99b2.jpg", "2017-12-18", "b", "da", "1860", "212311313", "huawei mate6", "liu", "2", 13, 192, 120, 91));
    }

    private void initViews(View v) {
        rv = v.findViewById(R.id.fragment_gameinfo_discuss_rv);
    }
}
