package com.demo.yetote.cubegame.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.demo.yetote.cubegame.GameInfoActivity;
import com.demo.yetote.cubegame.R;
import com.demo.yetote.cubegame.adapter.recyclerview.NewsRvAdapter;
import com.demo.yetote.cubegame.model.NewsModel;
import com.demo.yetote.cubegame.service.GameLibService;
import com.demo.yetote.cubegame.service.NewsService;
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
 * 咨讯
 *
 * @author Swg
 * @date 2018/1/16 14:29
 */
public class NewsFragment extends Fragment {
    private RecyclerView rv;
    private ViewPager viewPager;
    private ArrayList<NewsModel> list;
    private NewsRvAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // TODO: 2018/ 2/26 资讯fragment
        View v = inflater.inflate(R.layout.fragment_news, container, false);

        initViews(v);
        initData();

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new NewsRvAdapter(getActivity(), list);
        rv.setAdapter(adapter);

        adapter.setListener((v1, tag) -> {
            // TODO: 2018/3/22 加载h5页面
            Toast.makeText(getActivity(), tag, Toast.LENGTH_SHORT).show();
        });

//        requestData();

        return v;
    }

    private void initData() {
        list = new ArrayList<>();
        list.add(new NewsModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557496250&di=9874d9ea74260ff8b6bdf57f2fee8268&imgtype=0&src=http%3A%2F%2Fold.bz55.com%2Fuploads%2Fallimg%2F150420%2F139-150420114616.jpg", "a", "云对雨，雪对风，晚照对晴空。来鸿对去燕，宿鸟对鸣虫。三尺剑，六钧弓，岭北对江东。人间清暑殿，天上广寒宫。两岸晓烟杨柳绿，一园春雨杏花红。两鬓风霜，途次早行之客；一蓑烟雨，溪边晚钓之翁。", "怀旧", "2018-01-29", 6200, 1));
        list.add(new NewsModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557496249&di=3ead62d50c937ff518e483477ff0b764&imgtype=0&src=http%3A%2F%2Fpic.yesky.com%2FuploadImages%2F2015%2F105%2F48%2F407MK41068JD.jpg", "b", "沿对革，异对同，白叟对黄童。江风对海雾，牧子对渔翁。颜巷陋，阮途穷，冀北对辽东。池中濯足水，门外打头风。梁帝讲经同泰寺，汉皇置酒未央宫。尘虑萦心，懒抚七弦绿绮；霜华满鬓，羞看百炼青铜。", "免费", "2018-01-29", 5200, 2));
        list.add(new NewsModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557675333&di=a34d9510d96b41ca0341b32bb50bcc88&imgtype=jpg&src=http%3A%2F%2Fimg2.imgtn.bdimg.com%2Fit%2Fu%3D4207015072%2C4165546874%26fm%3D214%26gp%3D0.jpg", "c", "贫对富，塞对通，野叟对溪童。鬓皤对眉绿，齿皓对唇红。天浩浩，日融融，佩剑对弯弓。半溪流水绿，千树落花红。野渡燕穿杨柳雨，芳池鱼戏芰荷风。女子眉纤，额下现一弯新月；男儿气壮，胸中吐万丈长虹。", "仙剑", "2018-01-29", 3200, 3));
        list.add(new NewsModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557998342&di=fb6895227dc63b1c0ed40579026bfb35&imgtype=0&src=http%3A%2F%2Fimg4q.duitang.com%2Fuploads%2Fitem%2F201408%2F08%2F20140808205234_FTRMU.jpeg", "d", "春对夏，秋对冬，暮鼓对晨钟。观山对玩水，绿竹对苍松。冯妇虎，叶公龙，舞蝶对鸣蛩。街泥双紫燕，课密几黄蜂。春日园中莺恰恰，秋天寒外雁雍雍。秦岭云横，迢递八千远路；巫山雨洗，嵯峨十二危峰。", "口碑", "2018-01-29", 1230, 4));
        list.add(new NewsModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557687035&di=aa784a954a3f1140815f01edc0086842&imgtype=0&src=http%3A%2F%2Fold.bz55.com%2Fuploads%2Fallimg%2F150723%2F139-150H3091930.jpg", "e", "明对暗，淡对浓，上智对中庸。镜奁对衣笥，野杵对村舂。花灼烁，草蒙茸，九夏对三冬。台高名戏马，斋小号蟠龙。手擘蟹螯从毕卓，身披鹤氅自王恭。五老峰高，秀插云霄如玉笔；三姑石大，响传风雨若金镛。", "5元", "2018-01-29", 1520, 5));
        list.add(new NewsModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557687037&di=76a3c07566870125bd92fd745eae50ac&imgtype=0&src=http%3A%2F%2F4493bz.1985t.com%2Fuploads%2Fallimg%2F160523%2F3-160523132P7.jpg", "f", "仁对义，让对恭，禹舜对羲农。雪花对云叶，芍药对芙蓉。陈后主，汉中宗，绣虎对雕龙。柳塘风淡淡，花圃月浓浓。春日正宜朝看蝶，秋风那更夜闻蛩。战士邀功，必借干戈成勇武；逸民适志，须凭诗酒养疏慵", "口碑", "2018-01-29", 12540, 6));
        list.add(new NewsModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557687039&di=5535c67e6c77f74d671df6fddcf30dde&imgtype=0&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2014%2F330%2F25%2F0P8495X39584.jpg", "g", "楼对阁，户对窗，巨海对长江。蓉裳对蕙帐，玉斝对银釭。青布幔，碧油幢，宝剑对金缸。忠心安社稷，利口覆家邦。世祖中兴延马武，桀王失道杀龙逄。秋雨潇潇，漫烂黄花都满径；春风袅袅，扶疏绿竹正盈窗。", "怀旧", "2018-01-29", 1263, 7));
        list.add(new NewsModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557687039&di=dece8ded6c6b59cb68ce2c2730a4f61f&imgtype=0&src=http%3A%2F%2Fold.bz55.com%2Fuploads%2Fallimg%2F150428%2F139-15042Q91525.jpg", "h", "旌对旆，盖对撞，故国对他邦。行山对万水，九泽对三江。山岌岌，水淙淙，鼓振对钟撞。清风生酒舍，皓月照书窗。阵上倒戈辛纣战，道旁系剑子婴降。夏日池塘，出没浴波鸥对对；春风帘幕，往来营垒燕双双。", "免费", "2018-01-29", 1620, 8));
        list.add(new NewsModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557687040&di=d22068f26597a05fcf53eeb42f471589&imgtype=0&src=http%3A%2F%2Fold.bz55.com%2Fuploads%2Fallimg%2F150420%2F139-150420114618.jpg", "i", "铢对钅两，只对双，华岳对湘江。朝车对禁鼓，宿火对塞缸。青琐闼，碧纱窗，汉社对周邦。笙箫鸣细细，钟鼓响摐摐。主簿栖鸾名有览，治中展骥姓惟庞。苏武牧羊，雪屡餐于北海；庄周活鲋，水必决于西江", "独立", "2018-01-29", 1820, 9));
        list.add(new NewsModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557687040&di=8132aab6276e45d4445ecc8f2fee17e1&imgtype=0&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2015%2F144%2F54%2F99YY1B894532.jpg", "j", "茶对酒，赋对诗，燕子对莺儿。栽花对种竹，落絮对游丝。四目颉，一只夔，鸲鹆对鹭鸶。半池红菡萏，一架白荼蘼。几阵秋风能应候，一犁春雨甚知时。智伯恩深，国士吞变形之炭；羊公德大，邑人竖堕泪之碑。", "预告", "2018-01-29", 1260, 10));
        list.add(new NewsModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557496236&di=d35eaa9467f440550c1b0a1ddbddda4c&imgtype=0&src=http%3A%2F%2Fdynamic-image.yesky.com%2F740x-%2FuploadImages%2F2014%2F306%2F59%2F91239469O609.jpg", "k", "行对止，速对迟，舞剑对围棋。花笺对草字，竹简对毛锥。汾水鼎，岘山碑，虎豹对熊罴。花开红锦绣，水漾碧琉璃。去妇因探邻舍枣，出妻为种后园葵。笛韵和谐，仙管恰从云里降；橹声咿轧，渔舟正向雪中移。", "PC", "2018-01-29", 1240, 11));

    }

    private void initViews(View v) {
        viewPager = v.findViewById(R.id.fragment_news_viewPager);
        rv = v.findViewById(R.id.fragment_news_rv);
    }

    private void requestData() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        NewsService newsService = retrofit.create(NewsService.class);
        newsService.getData()
                .observeOn(Schedulers.newThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(newsModels -> {
                    list.addAll(newsModels);
                    adapter.notifyDataSetChanged();
                });
    }
}
