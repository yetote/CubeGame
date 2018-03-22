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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.demo.yetote.cubegame.DetailedDiscussActivity;
import com.demo.yetote.cubegame.GameInfoActivity;
import com.demo.yetote.cubegame.R;
import com.demo.yetote.cubegame.adapter.recyclerview.GameInfoForumAdapter;
import com.demo.yetote.cubegame.model.GameInfoForumModel;

import java.util.ArrayList;

/**
 * com.demo.yetote.cubegame.fragment
 * 游戏信息论坛
 *
 * @author Swg
 * @date 2018/2/7 14:28
 */
public class GameInfoForumFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private RecyclerView rv;
    private ArrayList<GameInfoForumModel> list;
    private GameInfoForumAdapter adapter;
    private Spinner spinner;
    private String[] spinnerItem = new String[]{"按时间排序", "按热度排序"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // TODO: 2018/2/7 游戏论坛fragment
        View v = inflater.inflate(R.layout.fragment_gameinfo_forum, container, false);

        initViews(v);

        initData();

        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new GameInfoForumAdapter(getActivity(), list);
        rv.setAdapter(adapter);

        adapter.setListener((v1, tag) -> {
            Intent i = new Intent();
            i.setClass(getActivity(), DetailedDiscussActivity.class);
            startActivity(i);
        });

        spinner.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, spinnerItem));
        spinner.setOnItemSelectedListener(this);

        return v;

    }

    private void initViews(View v) {
        rv = v.findViewById(R.id.fragment_gameinfo_forum_rv);
        spinner = v.findViewById(R.id.fragment_gameinfo_forum_spinner);
    }

    private void initData() {
        list = new ArrayList<>();
        list.add(new GameInfoForumModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521385264788&di=4fd841145339e233dde352f3dd008e76&imgtype=0&src=http%3A%2F%2Fd.hiphotos.baidu.com%2Fimage%2Fpic%2Fitem%2Fb151f8198618367a29fb44f322738bd4b31ce5aa.jpg", "今日开启测试", "2018-01-12", "ceshikaiqile", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521386626908&di=eeec5f969634c435409a3c31fd48f412&imgtype=0&src=http%3A%2F%2Fpic.yesky.com%2FuploadImages%2F2015%2F215%2F45%2F04L5VRR21C5W.jpg", "云对雨，雪对风，晚照对晴空。来鸿对去燕，宿鸟对鸣虫。三尺剑，六钧弓，岭北对江东。人间清暑殿，天上广寒宫。两岸晓烟杨柳绿，一园春雨杏花红。两鬓风霜，途次早行之客；一蓑烟雨，溪边晚钓之翁。", 12712, 112, 2, 1));
        list.add(new GameInfoForumModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521386626908&di=eeec5f969634c435409a3c31fd48f412&imgtype=0&src=http%3A%2F%2Fpic.yesky.com%2FuploadImages%2F2015%2F215%2F45%2F04L5VRR21C5W.jpg", "今日开启测试", "2018-10-12", "666", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521386626896&di=84d586d19891bd5adecf4b13f935e714&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F023b5bb5c9ea15cec98a9b35bd003af33a87b2a2.jpg", "沿对革，异对同，白叟对黄童。江风对海雾，牧子对渔翁。颜巷陋，阮途穷，冀北对辽东。池中濯足水，门外打头风。梁帝讲经同泰寺，汉皇置酒未央宫。尘虑萦心，懒抚七弦绿绮；霜华满鬓，羞看百炼青铜。", 12812, 12, 24, 2));
        list.add(new GameInfoForumModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521386626907&di=d680b5474da2e5e3f2b754439fc16c93&imgtype=0&src=http%3A%2F%2Fimg1.xiazaizhijia.com%2Fwalls%2F20151230%2F1440x900_6a3ec17c19e5064.jpg", "今日开启测试", "2018-11-12", "777", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521386626896&di=a589e985f96901e820eb8d9d0a47eba1&imgtype=0&src=http%3A%2F%2Fpic47.nipic.com%2F20140902%2F8607306_233416291000_2.jpg", "贫对富，塞对通，野叟对溪童。鬓皤对眉绿，齿皓对唇红。天浩浩，日融融，佩剑对弯弓。半溪流水绿，千树落花红。野渡燕穿杨柳雨，芳池鱼戏芰荷风。女子眉纤，额下现一弯新月；男儿气壮，胸中吐万丈长虹。", 1212, 112, 224, 3));
        list.add(new GameInfoForumModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521386626906&di=f9d826545a0b4eb3848542ca049a4e0f&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fe1fe9925bc315c600dce09d386b1cb13495477b6.jpg", "今日开启测试", "2018-01-12", "98", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521386626926&di=4a554de5e8aa35b3cb7f8dc1c116753f&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F77094b36acaf2edd47c3f4d4861001e9390193d9.jpg", "春对夏，秋对冬，暮鼓对晨钟。观山对玩水，绿竹对苍松。冯妇虎，叶公龙，舞蝶对鸣蛩。街泥双紫燕，课密几黄蜂。春日园中莺恰恰，秋天寒外雁雍雍。秦岭云横，迢递八千远路；巫山雨洗，嵯峨十二危峰。", 12712, 172, 224, 4));
        list.add(new GameInfoForumModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521386626904&di=6d02616046f66c505dbcf553484c3cea&imgtype=0&src=http%3A%2F%2Fdynamic-image.yesky.com%2F740x-%2FuploadImages%2F2015%2F131%2F33%2FD472XQ25C7H2.jpg ", "今日开启测试", "2018-12-12", "888", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521389154887&di=321669bd0dea6fa072ed5f7eb08c935e&imgtype=jpg&src=http%3A%2F%2Fimg0.imgtn.bdimg.com%2Fit%2Fu%3D2256946865%2C212613265%26fm%3D214%26gp%3D0.jpg", "明对暗，淡对浓，上智对中庸。镜奁对衣笥，野杵对村舂。花灼烁，草蒙茸，九夏对三冬。台高名戏马，斋小号蟠龙。手擘蟹螯从毕卓，身披鹤氅自王恭。五老峰高，秀插云霄如玉笔；三姑石大，响传风雨若金镛", 12162, 132, 20, 5));
        list.add(new GameInfoForumModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521386626902&di=e64698cb1af3b4efa945e73c941a0e66&imgtype=0&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2015%2F198%2F38%2F94P7DLV3N9UG.jpg", "今日开启测试", "2018-11-12", "895", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521386626925&di=0f986d6413f70dd942ea7259c314fa6c&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F060828381f30e924ae26530b47086e061d95f70e.jpg", "仁对义，让对恭，禹舜对羲农。雪花对云叶，芍药对芙蓉。陈后主，汉中宗，绣虎对雕龙。柳塘风淡淡，花圃月浓浓。春日正宜朝看蝶，秋风那更夜闻蛩。战士邀功，必借干戈成勇武；逸民适志，须凭诗酒养疏慵。", 12512, 124, 12, 6));
        list.add(new GameInfoForumModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521386626900&di=cab4f0ef3d1201236fc2d3e14a069552&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F241f95cad1c8a786ec11f5336c09c93d70cf50d7.jpg", "今日开启测试", "2018-01-12", "856", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521386626925&di=37d05c0739951eaf0a93b1c7dd06fe5f&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Faa18972bd40735faa97ff38495510fb30f24087b.jpg", "楼对阁，户对窗，巨海对长江。蓉裳对蕙帐，玉斝对银釭。青布幔，碧油幢，宝剑对金缸。忠心安社稷，利口覆家邦。世祖中兴延马武，桀王失道杀龙逄。秋雨潇潇，漫烂黄花都满径；春风袅袅，扶疏绿竹正盈窗。", 12124, 172, 24, 7));
        list.add(new GameInfoForumModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521386626899&di=0ec8e7a254fa83d7709cabc751e18ffa&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F3ac79f3df8dcd10088b14b1c798b4710b9122fd9.jpg", "今日开启测试", "2018-10-12", "我看美女", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521386626925&di=3a5063599781a33965ddff61581d4180&imgtype=0&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2014%2F266%2F40%2F6E0VK7L4C6O6_1000x500.jpg", "旌对旆，盖对撞，故国对他邦。行山对万水，九泽对三江。山岌岌，水淙淙，鼓振对钟撞。清风生酒舍，皓月照书窗。阵上倒戈辛纣战，道旁系剑子婴降。夏日池塘，出没浴波鸥对对；春风帘幕，往来营垒燕双双。", 14212, 182, 201, 8));
        list.add(new GameInfoForumModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521386626904&di=f905c9e14ace8de07bc1584186bd945d&imgtype=0&src=http%3A%2F%2Fpic.yesky.com%2FuploadImages%2F2015%2F199%2F11%2FISYG68AU213I.jpg ", "今日开启测试", "2018-01-12", "美女", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521386626924&di=3afa5c6073b7b509c37b375e45227626&imgtype=0&src=http%3A%2F%2Fimg05.tooopen.com%2Fimages%2F20150929%2Ftooopen_sy_143927879853.jpg", "铢对两，只对双，华岳对湘江。朝车对禁鼓，宿火对塞缸。青琐闼，碧纱窗，汉社对周邦。笙箫鸣细细，钟鼓响摐摐。主簿栖鸾名有览，治中展骥姓惟庞。苏武牧羊，雪屡餐于北海；庄周活鲋，水必决于西江。", 12612, 182, 242, 9));
        list.add(new GameInfoForumModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521386626908&di=6f2129fa40a63b677bb3d981962ae375&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dshijue1%252C0%252C0%252C294%252C40%2Fsign%3D72e134ec88025aafc73f76889384c111%2Fa50f4bfbfbedab64a0bd3fecfd36afc378311eca.jpg", "今日开启测试", "2018-01-15", "666", "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521386626923&di=75003c37a4ea3ada6ad49a549dfc84fe&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2F3bf33a87e950352a0c1c9a355843fbf2b2118b8a.jpg", "　茶对酒，赋对诗，燕子对莺儿。栽花对种竹，落絮对游丝。四目颉，一只夔，鸲鹆对鹭鸶。半池红菡萏，一架白荼蘼。几阵秋风能应候，一犁春雨甚知时。智伯恩深，国士吞变形之炭；羊公德大，邑人竖堕泪之碑。", 12142, 18, 82, 10));

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
