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
import com.demo.yetote.cubegame.adapter.recyclerview.HomePagerAdapter;
import com.demo.yetote.cubegame.model.HomePagerModel;

import java.util.ArrayList;

/**
 * com.demo.yetote.cubegame.fragment
 * 首页
 *
 * @author Swg
 * @date 2018/1/16 14:29
 */
public class HomePagerFragment extends Fragment {
    private RecyclerView rv;
    private HomePagerAdapter adapter;
    private ArrayList<HomePagerModel> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_homepager, container, false);

        initViews(v);
        initData();

        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapter = new HomePagerAdapter(getActivity(), list);
        rv.setAdapter(adapter);

        return v;
    }

    private void initData() {
        list = new ArrayList<>();
        list.add(new HomePagerModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557998340&di=ab6eab44ff5536fdec759714b4387028&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201407%2F27%2F20140727140948_Mkh8e.jpeg", "一栋", "  云对雨，雪对风，晚照对晴空。来鸿对去燕，宿鸟对鸣虫。三尺剑，六钧弓，岭北对江东。人间清暑殿，天上广寒宫。两岸晓烟杨柳绿，一园春雨杏花红。两鬓风霜，途次早行之客；一蓑烟雨，溪边晚钓之翁。", "9.6", "2212", "wokanbudong ,wangle zheshishenem le ", "仙剑", "我是开发者，我没啥说的", 1));
        list.add(new HomePagerModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557998339&di=245d655d7f77e4383bb153a729410a7d&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F5%2F59bc9a66ae1e7.jpg", "二楼", "沿对革，异对同，白叟对黄童。江风对海雾，牧子对渔翁。颜巷陋，阮途穷，冀北对辽东。池中濯足水，门外打头风。梁帝讲经同泰寺，汉皇置酒未央宫。尘虑萦心，懒抚七弦绿绮；霜华满鬓，羞看百炼青铜。", "9.6", "1512", "wokanbudong ,wangle zheshishenem le ", "国产", "我是开发者，我没啥说的", 2));
        list.add(new HomePagerModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557998339&di=ca344918139b2f2021d0192a3122b0a0&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201407%2F16%2F20140716194205_EUEGa.png", "三阳开泰", "贫对富，塞对通，野叟对溪童。鬓皤对眉绿，齿皓对唇红。天浩浩，日融融，佩剑对弯弓。半溪流水绿，千树落花红。野渡燕穿杨柳雨，芳池鱼戏芰荷风。女子眉纤，额下现一弯新月；男儿气壮，胸中吐万丈长虹。", "9.6", "1912", "wokanbudong ,wangle zheshishenem le ", "口碑", "我是开发者，我没啥说的", 3));
        list.add(new HomePagerModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557998339&di=5e5cf778e174a2296d9e9fa056c4f9d1&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201406%2F16%2F20140616210828_N3efC.jpeg", "泰山压顶", "春对夏，秋对冬，暮鼓对晨钟。观山对玩水，绿竹对苍松。冯妇虎，叶公龙，舞蝶对鸣蛩。街泥双紫燕，课密几黄蜂。春日园中莺恰恰，秋天寒外雁雍雍。秦岭云横，迢递八千远路；巫山雨洗，嵯峨十二危峰。", "9.6", "1712", "wokanbudong ,wangle zheshishenem le ", "唯美", "我是开发者，我没啥说的", 4));
        list.add(new HomePagerModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557998338&di=63ded62f0912799614b24273c48da67d&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201407%2F18%2F20140718210225_m4sXe.jpeg", "顶不住了", "明对暗，淡对浓，上智对中庸。镜奁对衣笥，野杵对村舂。花灼烁，草蒙茸，九夏对三冬。台高名戏马，斋小号蟠龙。手擘蟹螯从毕卓，身披鹤氅自王恭。五老峰高，秀插云霄如玉笔；三姑石大，响传风雨若金镛。", "9.6", "1612", "wokanbudong ,wangle zheshishenem le ", "独立", "我是开发者，我没啥说的", 5));
        list.add(new HomePagerModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521561672350&di=a7484820886c1a23e1853a6a709fc9ed&imgtype=jpg&src=http%3A%2F%2Fimg3.imgtn.bdimg.com%2Fit%2Fu%3D3774960988%2C2667353707%26fm%3D214%26gp%3D0.jpg", "了无生趣", "仁对义，让对恭，禹舜对羲农。雪花对云叶，芍药对芙蓉。陈后主，汉中宗，绣虎对雕龙。柳塘风淡淡，花圃月浓浓。春日正宜朝看蝶，秋风那更夜闻蛩。战士邀功，必借干戈成勇武；逸民适志，须凭诗酒养疏慵。", "9.6", "1612", "wokanbudong ,wangle zheshishenem le ", "主机", "我是开发者，我没啥说的", 6));
        list.add(new HomePagerModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521557998336&di=372ebddfbd55c98688007fdafe60d949&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F9%2F593f40a798054.jpg", "去你妈的", "楼对阁，户对窗，巨海对长江。蓉裳对蕙帐，玉斝对银釭。青布幔，碧油幢，宝剑对金缸。忠心安社稷，利口覆家邦。世祖中兴延马武，桀王失道杀龙逄。秋雨潇潇，漫烂黄花都满径；春风袅袅，扶疏绿竹正盈窗。", "9.6", "1712", "wokanbudong ,wangle zheshishenem le ", "仙剑", "我是开发者，我没啥说的", 7));
        list.add(new HomePagerModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521561647741&di=fa103821c5b8cdc926e417039f5b008b&imgtype=0&src=http%3A%2F%2Fimg5q.duitang.com%2Fuploads%2Fitem%2F201407%2F20%2F20140720141316_knBLc.jpeg", "的了吧", "旌对旆，盖对撞，故国对他邦。行山对万水，九泽对三江。山岌岌，水淙淙，鼓振对钟撞。清风生酒舍，皓月照书窗。阵上倒戈辛纣战，道旁系剑子婴降。夏日池塘，出没浴波鸥对对；春风帘幕，往来营垒燕双双。", "9.6", "1612", "wokanbudong ,wangle zheshishenem le ", "PC", "我是开发者，我没啥说的", 8));
        list.add(new HomePagerModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521561647737&di=c5c1324b836077dba90f9e4b06366d92&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201404%2F14%2F20140414202600_Ere4R.jpeg", "八仙过海", "铢对两，只对双，华岳对湘江。朝车对禁鼓，宿火对塞缸。青琐闼，碧纱窗，汉社对周邦。笙箫鸣细细，钟鼓响摐摐。主簿栖鸾名有览，治中展骥姓惟庞。苏武牧羊，雪屡餐于北海；庄周活鲋，水必决于西江。  ", "9.6", "1312", "wokanbudong ,wangle zheshishenem le ", "优惠", "我是开发者，我没啥说的", 9));
        list.add(new HomePagerModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521561647733&di=84256727e8e59bd587c170391b9abfcb&imgtype=0&src=http%3A%2F%2Fimg3.duitang.com%2Fuploads%2Fitem%2F201406%2F28%2F20140628163647_zePAe.jpeg", "海市蜃楼", "茶对酒，赋对诗，燕子对莺儿。栽花对种竹，落絮对游丝。四目颉，一只夔，鸲鹆对鹭鸶。半池红菡萏，一架白荼蘼。几阵秋风能应候，一犁春雨甚知时。智伯恩深，国士吞变形之炭；羊公德大，邑人竖堕泪之碑。", "9.6", "1312", "wokanbudong ,wangle zheshishenem le ", "预告", "我是开发者，我没啥说的", 10));
        list.add(new HomePagerModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521561647733&di=11b1b64bf8210fe361e26aa11141d58b&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201404%2F20%2F20140420133920_YMZWW.jpeg", "琉璃大顺", "行对止，速对迟，舞剑对围棋。花笺对草字，竹简对毛锥。汾水鼎，岘山碑，虎豹对熊罴。花开红锦绣，水漾碧琉璃。去妇因探邻舍枣，出妻为种后园葵。笛韵和谐，仙管恰从云里降；橹声咿轧，渔舟正向雪中移。", "9.6", "12212", "wokanbudong ,wangle zheshishenem le ", "折扣", "我是开发者，我没啥说的", 11));
        list.add(new HomePagerModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521561647731&di=0f875993ee90bd7c5b464e84c16b727d&imgtype=0&src=http%3A%2F%2Fpic1.5442.com%2F2015%2F0913%2F04%2F04.jpg", "顺天府尹", "戈对甲，鼓对旗，紫燕对黄鹂。梅酸对李苦，青眼对白眉。三弄笛，地围棋，雨打对风吹。海棠春睡早，杨柳昼眠迟。张骏曾为槐树赋，杜陵不作海堂诗。晋士特奇，可比一斑之豹；唐儒博识，堪为五总之龟。  ", "9.6", "122", "wokanbudong ,wangle zheshishenem le ", "推广", "我是开发者，我没啥说的", 12));
        list.add(new HomePagerModel("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1521561706546&di=19a9c6a53af86970bcecd4eb61a4c30e&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201409%2F15%2F20140915130839_QnYJQ.jpeg", "引火烧身", "来对往，密对稀，燕舞对莺飞。风清对月朗，露重对烟微。霜菊瘦，雨梅肥，客路对渔矶。晚霞舒锦绣，朝露缀珠玑。夏暑客思欹石枕，秋寒妇念寄边衣。春水才深，青草岸边渔父去；夕阳半落，绿莎原上牧童归。", "9.6", "112", "wokanbudong ,wangle zheshishenem le ", "免费", "我是开发者，我没啥说的", 13));
    }

    private void initViews(View v) {
        rv = v.findViewById(R.id.fragment_homePager_rv);
    }
}
