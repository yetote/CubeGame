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
        // TODO: 2018/3/18 test
        list.add(new BoonModel("a", "free", "https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=e79fdbb1067b020813c939e152d8f25f/14ce36d3d539b600b36afca3e550352ac65cb77a.jpg", "''asfgvagsdfasfasf", "%50", "￥85", "￥170", 1, 176));
        list.add(new BoonModel("b", "count", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854240&di=a87480aa3a343e8666c22f855d5bd524&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fd833c895d143ad4b3ae286d88e025aafa50f06de.jpg", "''asfgvagsdfasfasf", "%50", "￥85", "￥170", 1, 76));
        list.add(new BoonModel("c", "free", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854239&di=d0a31ef22e8cc3fea4c6c196aeeaad78&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F72f082025aafa40f8197e0cca764034f78f01949.jpg", "''asfgvagsdfasfasf", "%70", "￥85", "￥170", 2, 76));
        list.add(new BoonModel("d", "count", "https://ss3.baidu.com/9fo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=e7ea61e75dda81cb51e685cd6267d0a4/4bed2e738bd4b31ccd851da88bd6277f9e2ff86c.jpg", "''asfgvagsdfasfasf", "%50", "￥85", "￥170", 3, 156));
        list.add(new BoonModel("e", "free", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854239&di=25eb520282df643a2cebf20def89e9a7&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F0dd7912397dda144a5db01a2beb7d0a20df486cb.jpg", "''asfgvagsdfasfasf", "%50", "￥525", "￥240", 4, 87));
        list.add(new BoonModel("f", "count", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854239&di=25eb520282df643a2cebf20def89e9a7&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F0dd7912397dda144a5db01a2beb7d0a20df486cb.jpg", "''asfgvagsdfasfasf", "%80", "￥35", "￥150", 5, 76));
        list.add(new BoonModel("g", "free", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854239&di=cf475721d95f754b733a7d72c3a35816&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F359b033b5bb5c9eaa91bb9f0d939b6003af3b33d.jpg", "''asfgvagsdfasfasf", "%52", "￥755", "￥150", 6, 16));
        list.add(new BoonModel("h", "free", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854239&di=be61b728a9a40a1321591505309ace82&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F962bd40735fae6cd09ccfb7903b30f2442a70fa9.jpg", "''asfgvagsdfasfasf", "%42", "￥5", "￥150", 7, 18));
        list.add(new BoonModel("i", "count", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854238&di=4c9a01ca62ba495935e4e995d6557451&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F3801213fb80e7bec00e429f3232eb9389b506be1.jpg", "''asfgvagsdfasfasf", "%25", "￥65", "￥140", 8, 15));
        list.add(new BoonModel("j", "free", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854238&di=09c307ecd99c3d5dff335df49446971b&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fe850352ac65c10384bfac6d1be119313b07e8918.jpg", "''asfgvagsdfasfasf", "%86", "￥25", "￥17", 9, 15));
        list.add(new BoonModel("k", "count", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854238&di=cdd8d3382586dbfaeee674bb40fc7ab6&imgtype=0&src=http%3A%2F%2Fh.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F4afbfbedab64034faff6e516a3c379310a551de2.jpg", "''asfgvagsdfasfasf", "%70", "￥80", "￥170", 10, 56));
        list.add(new BoonModel("l", "free", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854237&di=c6b54266880186644225a10fe78a1c37&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F9f2f070828381f305c2ce1b9a5014c086e06f0ed.jpg", "''asfgvagsdfasfasf", "%80", "￥85", "￥190", 11, 16));
        list.add(new BoonModel("m", "free", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854237&di=36c5ab3e428215cb157db298682b8235&imgtype=0&src=http%3A%2F%2Fg.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F8435e5dde71190ef500dffcfc21b9d16fdfa602f.jpg", "''asfgvagsdfasfasf", "%53", "￥88", "￥17", 12, 16));
        list.add(new BoonModel("n", "free", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854236&di=09db46b56156478d7305ae24bee88ed8&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fb03533fa828ba61ee51aa53f4d34970a304e592d.jpg", "''asfgvagsdfasfasf", "%50", "￥87", "￥13", 13, 176));
        list.add(new BoonModel("o", "count", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854236&di=dcfa517e4daaee2337b9cc761364921a&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F6f061d950a7b02080870a9f26ed9f2d3572cc86c.jpg", "''asfgvagsdfasfasf", "%40", "￥95", "￥140", 14, 176));
        list.add(new BoonModel("p", "count", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854236&di=f20702f79e03ada56cafe34db2c03358&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F203fb80e7bec54e77fe8040fb5389b504fc26a9e.jpg", "''asfgvagsdfasfasf", "%45", "￥75", "￥173", 15, 156));
        list.add(new BoonModel("q", "free", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854235&di=80438a31abacfcd86825700322b7ffec&imgtype=0&src=http%3A%2F%2Fg.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fcaef76094b36acaf7853b7ed70d98d1001e99c6b.jpg", "''asfgvagsdfasfasf", "%7", "￥86", "￥170", 16, 15));
        list.add(new BoonModel("r", "count", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854234&di=53c0f23553c6c3a2462241fb1baf57b3&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Ff2deb48f8c5494ee850a290821f5e0fe99257ef2.jpg", "''asfgvagsdfasfasf", "%80", "￥95", "￥180", 17, 156));
        list.add(new BoonModel("s", "count", "https://ss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=316a9f2b24381f3081198ba999014c67/6159252dd42a28349bde9b1857b5c9ea15cebfad.jpg", "''asfgvagsdfasfasf", "%50", "￥85", "￥170", 18, 15));
        list.add(new BoonModel("t", "free", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854233&di=a03fc3bcc3b6da9fa6e0168ea44136ce&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fcc11728b4710b912881abfedcffdfc03934522cd.jpg", "''asfgvagsdfasfasf", "%50", "￥85", "￥170", 19, 176));
    }


}
