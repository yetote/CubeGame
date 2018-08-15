package com.demo.yetote.cubegame.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.yetote.cubegame.GameInfoActivity;
import com.demo.yetote.cubegame.R;
import com.demo.yetote.cubegame.adapter.recyclerview.BoonAdapter;
import com.demo.yetote.cubegame.model.BoonModel;
import com.demo.yetote.cubegame.service.BoonService;
import com.demo.yetote.cubegame.utils.Config;
import com.demo.yetote.cubegame.utils.OnClick;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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

        adapter.setListener((v1, tag) -> {
            Intent i = new Intent();
            i.setClass(getActivity(), GameInfoActivity.class);
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

        BoonService service = retrofit.create(BoonService.class);

        service.getData()
                .observeOn(Schedulers.newThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(boonModels -> {
                    list.addAll(boonModels);
                    adapter.notifyDataSetChanged();
                });
    }

    private void initViews(View v) {
        rv = v.findViewById(R.id.fragment_boon_rv);
    }

    private void initData() {
        list = new ArrayList<>();
        // TODO: 2018/3/18 test
        list.add(new BoonModel("a", "free", "https://ss1.baidu.com/9vo3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=e79fdbb1067b020813c939e152d8f25f/14ce36d3d539b600b36afca3e550352ac65cb77a.jpg", "云对雨，雪对风，晚照对晴空。来鸿对去燕，宿鸟对鸣虫。三尺剑，六钧弓，岭北对江东。人间清暑殿，天上广寒宫。两岸晓烟杨柳绿，一园春雨杏花红。两鬓风霜，途次早行之客；一蓑烟雨，溪边晚钓之翁", "%50", "￥85", "￥170", 1, 176));
        list.add(new BoonModel("b", "count", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854240&di=a87480aa3a343e8666c22f855d5bd524&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fd833c895d143ad4b3ae286d88e025aafa50f06de.jpg", "沿对革，异对同，白叟对黄童。江风对海雾，牧子对渔翁。颜巷陋，阮途穷，冀北对辽东。池中濯足水，门外打头风。梁帝讲经同泰寺，汉皇置酒未央宫。尘虑萦心，懒抚七弦绿绮；霜华满鬓，羞看百炼青铜。", "%50", "￥85", "￥170", 1, 76));
        list.add(new BoonModel("c", "free", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854239&di=d0a31ef22e8cc3fea4c6c196aeeaad78&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F72f082025aafa40f8197e0cca764034f78f01949.jpg", "贫对富，塞对通，野叟对溪童。鬓皤对眉绿，齿皓对唇红。天浩浩，日融融，佩剑对弯弓。半溪流水绿，千树落花红。野渡燕穿杨柳雨，芳池鱼戏芰荷风。女子眉纤，额下现一弯新月；男儿气壮，胸中吐万丈长", "%70", "￥85", "￥170", 2, 76));
        list.add(new BoonModel("d", "count", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557998343&di=7e8a3b33a9704867723342acb14e826c&imgtype=0&src=http%3A%2F%2Fimg4.xiazaizhijia.com%2Fwalls%2F20151211%2F1440x900_6e1d77f35d48c7a.jpg", "春对夏，秋对冬，暮鼓对晨钟。观山对玩水，绿竹对苍松。冯妇虎，叶公龙，舞蝶对鸣蛩。街泥双紫燕，课密几黄蜂。春日园中莺恰恰，秋天寒外雁雍雍。秦岭云横，迢递八千远路；巫山雨洗，嵯峨十二危峰。", "%50", "￥85", "￥170", 3, 156));
        list.add(new BoonModel("e", "free", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854239&di=25eb520282df643a2cebf20def89e9a7&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F0dd7912397dda144a5db01a2beb7d0a20df486cb.jpg", "明对暗，淡对浓，上智对中庸。镜奁对衣笥，野杵对村舂。花灼烁，草蒙茸，九夏对三冬。台高名戏马，斋小号蟠龙。手擘蟹螯从毕卓，身披鹤氅自王恭。五老峰高，秀插云霄如玉笔；三姑石大，响传风雨若金", "%50", "￥525", "￥240", 4, 87));
        list.add(new BoonModel("f", "count", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854239&di=25eb520282df643a2cebf20def89e9a7&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F0dd7912397dda144a5db01a2beb7d0a20df486cb.jpg", "仁对义，让对恭，禹舜对羲农。雪花对云叶，芍药对芙蓉。陈后主，汉中宗，绣虎对雕龙。柳塘风淡淡，花圃月浓浓。春日正宜朝看蝶，秋风那更夜闻蛩。战士邀功，必借干戈成勇武；逸民适志，须凭诗酒养疏", "%80", "￥35", "￥150", 5, 76));
        list.add(new BoonModel("g", "free", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854239&di=cf475721d95f754b733a7d72c3a35816&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F359b033b5bb5c9eaa91bb9f0d939b6003af3b33d.jpg", "楼对阁，户对窗，巨海对长江。蓉裳对蕙帐，玉斝对银釭。青布幔，碧油幢，宝剑对金缸。忠心安社稷，利口覆家邦。世祖中兴延马武，桀王失道杀龙逄。秋雨潇潇，漫烂黄花都满径；春风袅袅，扶疏绿竹正盈", "%52", "￥755", "￥150", 6, 16));
        list.add(new BoonModel("h", "free", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854239&di=be61b728a9a40a1321591505309ace82&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F962bd40735fae6cd09ccfb7903b30f2442a70fa9.jpg", "旌对旆，盖对撞，故国对他邦。行山对万水，九泽对三江。山岌岌，水淙淙，鼓振对钟撞。清风生酒舍，皓月照书窗。阵上倒戈辛纣战，道旁系剑子婴降。夏日池塘，出没浴波鸥对对；春风帘幕，往来营垒燕双", "%42", "￥5", "￥150", 7, 18));
        list.add(new BoonModel("i", "count", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854238&di=4c9a01ca62ba495935e4e995d6557451&imgtype=0&src=http%3A%2F%2Fe.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F3801213fb80e7bec00e429f3232eb9389b506be1.jpg", "铢对钅两，只对双，华岳对湘江。朝车对禁鼓，宿火对塞缸。青琐闼，碧纱窗，汉社对周邦。笙箫鸣细细，钟鼓响摐摐。主簿栖鸾名有览，治中展骥姓惟庞。苏武牧羊，雪屡餐于北海；庄周活鲋，水必决于西江", "%25", "￥65", "￥140", 8, 15));
        list.add(new BoonModel("j", "free", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854238&di=09c307ecd99c3d5dff335df49446971b&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fe850352ac65c10384bfac6d1be119313b07e8918.jpg", "茶对酒，赋对诗，燕子对莺儿。栽花对种竹，落絮对游丝。四目颉，一只夔，鸲鹆对鹭鸶。半池红菡萏，一架白荼蘼。几阵秋风能应候，一犁春雨甚知时。智伯恩深，国士吞变形之炭；羊公德大，邑人竖堕泪之", "%86", "￥25", "￥17", 9, 15));
        list.add(new BoonModel("k", "count", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854238&di=cdd8d3382586dbfaeee674bb40fc7ab6&imgtype=0&src=http%3A%2F%2Fh.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F4afbfbedab64034faff6e516a3c379310a551de2.jpg", "行对止，速对迟，舞剑对围棋。花笺对草字，竹简对毛锥。汾水鼎，岘山碑，虎豹对熊罴。花开红锦绣，水漾碧琉璃。去妇因探邻舍枣，出妻为种后园葵。笛韵和谐，仙管恰从云里降；橹声咿轧，渔舟正向雪中", "%70", "￥80", "￥170", 10, 56));
        list.add(new BoonModel("l", "free", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854237&di=c6b54266880186644225a10fe78a1c37&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F9f2f070828381f305c2ce1b9a5014c086e06f0ed.jpg", "戈对甲，鼓对旗，紫燕对黄鹂。梅酸对李苦，青眼对白眉。三弄笛，地围棋，雨打对风吹。海棠春睡早，杨柳昼眠迟。张骏曾为槐树赋，杜陵不作海堂诗。晋士特奇，可比一斑之豹；唐儒博识，堪为五总之龟。", "%80", "￥85", "￥190", 11, 16));
        list.add(new BoonModel("m", "free", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854237&di=36c5ab3e428215cb157db298682b8235&imgtype=0&src=http%3A%2F%2Fg.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F8435e5dde71190ef500dffcfc21b9d16fdfa602f.jpg", "来对往，密对稀，燕舞对莺飞。风清对月朗，露重对烟微。霜菊瘦，雨梅肥，客路对渔矶。晚霞舒锦绣，朝露缀珠玑。夏暑客思欹石枕，秋寒妇念寄边衣。春水才深，青草岸边渔父去；夕阳半落，绿莎原上牧童归。", "%53", "￥88", "￥17", 12, 16));
        list.add(new BoonModel("n", "free", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854236&di=09db46b56156478d7305ae24bee88ed8&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fb03533fa828ba61ee51aa53f4d34970a304e592d.jpg", "宽对猛，是对非，服美对乘肥。珊瑚对玳瑁，锦绣对珠玑。桃灼灼，柳依依，绿暗对红稀。窗前莺并语，帘外燕双飞。汉致太平三尺剑，周臻大定一戎衣。吟成赏月之待，只悉月堕；斟满送春之酒，惟憾春归。", "%50", "￥87", "￥13", 13, 176));
        list.add(new BoonModel("o", "count", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854236&di=dcfa517e4daaee2337b9cc761364921a&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F6f061d950a7b02080870a9f26ed9f2d3572cc86c.jpg", "声对色，饱对饥，虎节对龙旗。杨花对桂叶，白简对朱衣。龙也吠，燕于飞，荡荡对巍巍。春暄资日气，秋冷借霜威。出使振威冯奉世，治民异等尹翁归。燕我弟兄，载咏棣棠韡韡；命伊将帅，为歌杨柳依依。", "%40", "￥95", "￥140", 14, 176));
        list.add(new BoonModel("p", "count", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854236&di=f20702f79e03ada56cafe34db2c03358&imgtype=0&src=http%3A%2F%2Fb.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2F203fb80e7bec54e77fe8040fb5389b504fc26a9e.jpg", "无对有，实对虚，作赋对观书。绿窗对朱户，宝马对香车。伯乐马，浩然驴，弋雁对求鱼。分金齐鲍叔，奉璧蔺相如。掷地金声孙绰赋，回文锦字窦滔书。未遇殷宗，胥靡困傅岩之筑；既逢周后，太公舍渭水之渔。", "%45", "￥75", "￥173", 15, 156));
        list.add(new BoonModel("q", "free", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854235&di=80438a31abacfcd86825700322b7ffec&imgtype=0&src=http%3A%2F%2Fg.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fcaef76094b36acaf7853b7ed70d98d1001e99c6b.jpg", "终对始，疾对徐，短褐对华裾。六朝对三国，天禄对石渠。千字策，八行书，有若对相如。花残无戏蝶，藻密有潜鱼。落叶舞风高复下，小荷浮水卷还舒。爱见人长，共服宣尼休假盖；恐彰已吝，谁知阮裕竟焚车。", "%7", "￥86", "￥170", 16, 15));
        list.add(new BoonModel("r", "count", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854234&di=53c0f23553c6c3a2462241fb1baf57b3&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Ff2deb48f8c5494ee850a290821f5e0fe99257ef2.jpg", "麟对凤，鳖对鱼，内史对中书。犁锄对耒耜，畎浍对郊墟。犀角带，象牙梳，驷马对安车。青衣能报赦，黄耳解传书。庭畔有人持短剑，门前无客曳长裾。波浪拍船，骇舟人之水宿；峰峦绕舍，乐隐者之山居。", "%80", "￥95", "￥180", 17, 156));
        list.add(new BoonModel("s", "count", "https://ss0.baidu.com/7Po3dSag_xI4khGko9WTAnF6hhy/image/h%3D300/sign=316a9f2b24381f3081198ba999014c67/6159252dd42a28349bde9b1857b5c9ea15cebfad.jpg", "金对玉，宝对珠，玉兔对金鸟。孤舟对短棹，一雁对双凫。横醉眼，捻吟须，李白对杨朱。秋霜多过雁，夜月有啼乌。日暧园林花易赏，雪寒村舍酒难沽。人处岭南，善探巨象口中齿；客居江右，偶夺骊龙颔下珠。", "%50", "￥85", "￥170", 18, 15));
        list.add(new BoonModel("t", "free", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521384854233&di=a03fc3bcc3b6da9fa6e0168ea44136ce&imgtype=0&src=http%3A%2F%2Fa.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fcc11728b4710b912881abfedcffdfc03934522cd.jpg", "    铢对钅两，只对双，华岳对湘江。朝车对禁鼓，宿火对塞缸。青琐闼，碧纱窗，汉社对周邦。笙箫鸣细细，钟鼓响摐摐。主簿栖鸾名有览，治中展骥姓惟庞。苏武牧羊，雪屡餐于北海；庄周活鲋，水必决于西江", "%50", "￥85", "￥170", 19, 176));
    }


}