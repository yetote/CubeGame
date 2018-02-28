package com.demo.yetote.cubegame.adapter.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.demo.yetote.cubegame.R;
import com.demo.yetote.cubegame.model.GameInfoDiscussModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * com.demo.yetote.cubegame.adapter.recyclerview
 * 游戏信息评论适配器
 *
 * @author Swg
 * @date 2018/2/27 16:41
 */
public class GameInfoDiscussAdapter extends RecyclerView.Adapter {
    private ArrayList<GameInfoDiscussModel> list;
    private Context context;

    public GameInfoDiscussAdapter(ArrayList<GameInfoDiscussModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView iv;
        private TextView name, date, content, discussNum, badButton, excellentButton, phone, discussPeople1, discussContent1, discussPeople2, discussContent2;
        private LinearLayout discussLl1, discussLl2;

        private LinearLayout getDiscussLl1() {
            return discussLl1;
        }

        private LinearLayout getDiscussLl2() {
            return discussLl2;
        }

        private CircleImageView getIv() {
            return iv;
        }

        private TextView getName() {
            return name;
        }

        private TextView getDate() {
            return date;
        }

        private TextView getContent() {
            return content;
        }

        private TextView getDiscussNum() {
            return discussNum;
        }

        private TextView getBadButton() {
            return badButton;
        }

        private TextView getExcellentButton() {
            return excellentButton;
        }

        private TextView getPhone() {
            return phone;
        }

        private TextView getDiscussPeople1() {
            return discussPeople1;
        }

        private TextView getDiscussContent1() {
            return discussContent1;
        }

        private TextView getDiscussPeople2() {
            return discussPeople2;
        }

        private TextView getDiscussContent2() {
            return discussContent2;
        }

        private MyViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.item_discuss_iv);
            name = itemView.findViewById(R.id.item_discuss_people);
            date = itemView.findViewById(R.id.item_discuss_date);
            content = itemView.findViewById(R.id.item_discuss_content);
            discussNum = itemView.findViewById(R.id.item_discuss_evaluate_discussNum);
            badButton = itemView.findViewById(R.id.item_discuss_evaluate_bad);
            excellentButton = itemView.findViewById(R.id.item_discuss_evaluate_excellent);
            phone = itemView.findViewById(R.id.item_discuss_evaluate_mobile);
            discussPeople1 = itemView.findViewById(R.id.item_discuss_discussPeople);
            discussContent1 = itemView.findViewById(R.id.item_discuss_discussInfo);
            discussPeople2 = itemView.findViewById(R.id.item_discuss_discussPeople2);
            discussContent2 = itemView.findViewById(R.id.item_discuss_discussInfo2);
            discussLl1 = itemView.findViewById(R.id.item_discuss_ll_discussInfo_ll);
            discussLl2 = itemView.findViewById(R.id.item_discuss_ll_discussInfo_ll2);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_discuss, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder vh = (MyViewHolder) holder;
        Glide.with(context).load(list.get(position).getImg()).into(vh.getIv());
        vh.getName().setText(list.get(position).getName());
        vh.getDate().setText(list.get(position).getDate());
        vh.getContent().setText(list.get(position).getContent());
        vh.getDiscussNum().setText(list.get(position).getDiscussNum());
        vh.getBadButton().setText(list.get(position).getBadNum());
        vh.getExcellentButton().setText(list.get(position).getExcellentNum());
        vh.getPhone().setText(list.get(position).getPhone());
        if (list.get(position).getDiscussPeople() == null) {
            vh.getDiscussLl1().setVisibility(View.GONE);
            vh.getDiscussLl2().setVisibility(View.GONE);
        } else if (list.get(position).getDiscussPeople() != null && list.get(position).getDiscussPeople2() != null) {
            vh.getDiscussPeople1().setText(list.get(position).getDiscussPeople());
            vh.getDiscussContent1().setText(list.get(position).getDiscussContent());
            vh.getDiscussContent2().setText(list.get(position).getDiscussContent2());
            vh.getDiscussPeople2().setText(list.get(position).getDiscussPeople2());
        } else {
            vh.getDiscussPeople1().setText(list.get(position).getDiscussPeople());
            vh.getDiscussContent1().setText(list.get(position).getDiscussContent());
        }
        vh.itemView.setTag(list.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
