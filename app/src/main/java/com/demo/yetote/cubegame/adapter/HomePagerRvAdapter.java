package com.demo.yetote.cubegame.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.demo.yetote.cubegame.R;
import com.demo.yetote.cubegame.model.HomePgaerModel;

import java.util.ArrayList;

/**
 * com.demo.yetote.cubegame.adapter
 *
 * @author Swg
 * @date 2018/1/17 14:40
 */
public class HomePagerRvAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<HomePgaerModel> list;
    private final int HOMEPAGER_TAG_LOVE = 1;
    private final int HOMEPAGER_TAG_UNLOVE = 0;
    private final String HOMEPAGER_LOVETAG = "怀旧";

    public HomePagerRvAdapter(Context context, ArrayList<HomePgaerModel> list) {
        this.context = context;
        this.list = list;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView title, content, date, tag, discuss;

        ImageView getIv() {
            return iv;
        }

        TextView getTitle() {
            return title;
        }

        TextView getContent() {
            return content;
        }

        TextView getDate() {
            return date;
        }

        TextView getTag() {
            return tag;
        }

        TextView getDiscuss() {
            return discuss;
        }

        MyViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.item_homePager_iv);
            title = itemView.findViewById(R.id.item_homePager_title);
            content = itemView.findViewById(R.id.item_homePager_content);
            date = itemView.findViewById(R.id.item_homePager_time);
            tag = itemView.findViewById(R.id.item_homePager_tag);
            discuss = itemView.findViewById(R.id.item_homePager_discuss);
        }
    }

    class MyLoveViewHolder extends RecyclerView.ViewHolder {
        private ImageView loveIv;
        private TextView loveTitle, loveContent, loveDate, loveTag, loveDiscuss;

        ImageView getLoveIv() {
            return loveIv;
        }

        TextView getLoveTitle() {
            return loveTitle;
        }

        TextView getLoveContent() {
            return loveContent;
        }

        TextView getLoveDate() {
            return loveDate;
        }

        TextView getLoveTag() {
            return loveTag;
        }

        TextView getLoveDiscuss() {
            return loveDiscuss;
        }

        MyLoveViewHolder(View itemView) {
            super(itemView);
            loveIv = itemView.findViewById(R.id.item_homePager_love_iv);
            loveTitle = itemView.findViewById(R.id.item_homePager_love_title);
            loveContent = itemView.findViewById(R.id.item_homePager_love_content);
            loveDate = itemView.findViewById(R.id.item_homePager_love_time);
            loveTag = itemView.findViewById(R.id.item_homePager_love_tag);
            loveDiscuss = itemView.findViewById(R.id.item_homePager_love_discuss);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HOMEPAGER_TAG_LOVE) {
            View v = LayoutInflater.from(context).inflate(R.layout.item_homepager_love, parent, false);
            return new MyLoveViewHolder(v);
        } else {
            View v = LayoutInflater.from(context).inflate(R.layout.item_homepager, parent, false);
            return new MyViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyLoveViewHolder) {
            Glide.with(context).load(list.get(position).getImg()).into(((MyLoveViewHolder) holder).getLoveIv());
            ((MyLoveViewHolder) holder).getLoveContent().setText(list.get(position).getContent());
            ((MyLoveViewHolder) holder).getLoveDate().setText(list.get(position).getDate());
            ((MyLoveViewHolder) holder).getLoveDiscuss().setText(list.get(position).getDiscuss());
            ((MyLoveViewHolder) holder).getLoveTag().setText(list.get(position).getTag());
            ((MyLoveViewHolder) holder).getLoveTitle().setText(list.get(position).getTitle());

        } else {
            Glide.with(context).load(list.get(position).getImg()).into(((MyViewHolder) holder).getIv());
            ((MyViewHolder) holder).getContent().setText(list.get(position).getContent());
            ((MyViewHolder) holder).getDate().setText(list.get(position).getDate());
            ((MyViewHolder) holder).getDiscuss().setText(list.get(position).getDiscuss());
            ((MyViewHolder) holder).getTag().setText(list.get(position).getTag());
            ((MyViewHolder) holder).getTitle().setText(list.get(position).getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getTag().equals(HOMEPAGER_LOVETAG)) {
            return HOMEPAGER_TAG_LOVE;
        } else {
            return HOMEPAGER_TAG_UNLOVE;
        }
    }
}
