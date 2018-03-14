package com.demo.yetote.cubegame.adapter.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.demo.yetote.cubegame.R;
import com.demo.yetote.cubegame.model.GameInfoForumModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * com.demo.yetote.cubegame.adapter.recyclerview
 * 游戏信息社区适配器
 *
 * @author Swg
 * @date 2018/2/28 14:10
 */
public class GameInfoForumAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<GameInfoForumModel> list;

    public GameInfoForumAdapter(Context context, ArrayList<GameInfoForumModel> list) {
        this.context = context;
        this.list = list;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        private CircleImageView headImg;
        private ImageView contentImg;
        private TextView name, title, content, date, excellentBtn, discuss, seeNum;

        private CircleImageView getHeadImg() {
            return headImg;
        }

        private ImageView getContentImg() {
            return contentImg;
        }

        private TextView getName() {
            return name;
        }

        private TextView getTitle() {
            return title;
        }

        private TextView getContent() {
            return content;
        }

        private TextView getDate() {
            return date;
        }

        private TextView getExcellentBtn() {
            return excellentBtn;
        }

        private TextView getDiscuss() {
            return discuss;
        }

        private TextView getSeeNum() {
            return seeNum;
        }

        private MyViewHolder(View itemView) {
            super(itemView);
            headImg = itemView.findViewById(R.id.item_gameinfo_forum_headImg);
            contentImg = itemView.findViewById(R.id.item_gameinfo_forum_contentImg);
            name = itemView.findViewById(R.id.item_gameinfo_forum_name);
            title = itemView.findViewById(R.id.item_gameinfo_forum_title);
            content = itemView.findViewById(R.id.item_gameinfo_forum_content);
            date = itemView.findViewById(R.id.item_gameinfo_forum_date);
            excellentBtn = itemView.findViewById(R.id.item_gameinfo_forum_excellent);
            discuss = itemView.findViewById(R.id.item_gameinfo_forum_discuss);
            seeNum = itemView.findViewById(R.id.item_gameinfo_forum_seeNum);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_gameinfo_forum, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder vh = (MyViewHolder) holder;
        Glide.with(context).load(list.get(position).getHeadImg()).into(vh.getHeadImg());
        Glide.with(context).load(list.get(position).getContentImg()).into(vh.getContentImg());
        vh.getName().setText(list.get(position).getName());
        vh.getTitle().setText(list.get(position).getTitle());
        vh.getContent().setText(list.get(position).getContent());
        vh.getDate().setText(list.get(position).getDate());
        vh.getExcellentBtn().setText(list.get(position).getExcellentNum() + "");
        vh.getDiscuss().setText(list.get(position).getDiscussNum() + "");
        vh.getSeeNum().setText(list.get(position).getSeeNum() + "次游览");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
