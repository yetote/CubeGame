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
import com.demo.yetote.cubegame.model.NewsModel;
import com.demo.yetote.cubegame.utils.OnClick;

import java.util.ArrayList;

/**
 * com.demo.yetote.cubegame.adapter
 *
 * @author Swg
 * @date 2018/1/17 14:40
 */
public class NewsRvAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<NewsModel> list;
    private final int NEWS_TAG_LOVE = 1;
    private final int NEWS_TAG_UNLOVE = 0;
    private final String NEWS_LOVETAG = "怀旧";
    private OnClick listener;

    public OnClick getListener() {
        return listener;
    }

    public void setListener(OnClick listener) {
        this.listener = listener;
    }

    public NewsRvAdapter(Context context, ArrayList<NewsModel> list) {
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
            iv = itemView.findViewById(R.id.item_news_iv);
            title = itemView.findViewById(R.id.item_news_title);
            content = itemView.findViewById(R.id.item_news_content);
            date = itemView.findViewById(R.id.item_news_time);
            tag = itemView.findViewById(R.id.item_news_tag);
            discuss = itemView.findViewById(R.id.item_news_discuss);
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
            loveIv = itemView.findViewById(R.id.item_news_love_iv);
            loveTitle = itemView.findViewById(R.id.item_news_love_title);
            loveContent = itemView.findViewById(R.id.item_news_love_content);
            loveDate = itemView.findViewById(R.id.item_news_love_time);
            loveTag = itemView.findViewById(R.id.item_news_love_tag);
            loveDiscuss = itemView.findViewById(R.id.item_news_love_discuss);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == NEWS_TAG_LOVE) {
            View v = LayoutInflater.from(context).inflate(R.layout.item_news_love, parent, false);
            v.setOnClickListener(v1 -> listener.onClickListener(v,   (Integer) v.getTag()));
            return new MyLoveViewHolder(v);
        } else {
            View v = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
            v.setOnClickListener(v1 -> listener.onClickListener(v,   (Integer) v.getTag()));
            return new MyViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyLoveViewHolder) {
            Glide.with(context).load(list.get(position).getImg()).into(((MyLoveViewHolder) holder).getLoveIv());
            ((MyLoveViewHolder) holder).getLoveContent().setText(list.get(position).getContent());
            ((MyLoveViewHolder) holder).getLoveDate().setText(list.get(position).getDate());
            ((MyLoveViewHolder) holder).getLoveDiscuss().setText(list.get(position).getDiscuss() + "");
            ((MyLoveViewHolder) holder).getLoveTag().setText(list.get(position).getTag());
            ((MyLoveViewHolder) holder).getLoveTitle().setText(list.get(position).getTitle());
            holder.itemView.setTag(list.get(position).getId());
        } else {
            Glide.with(context).load(list.get(position).getImg()).into(((MyViewHolder) holder).getIv());
            ((MyViewHolder) holder).getContent().setText(list.get(position).getContent());
            ((MyViewHolder) holder).getDate().setText(list.get(position).getDate());
            ((MyViewHolder) holder).getDiscuss().setText(list.get(position).getDiscuss() + "");
            ((MyViewHolder) holder).getTag().setText(list.get(position).getTag());
            ((MyViewHolder) holder).getTitle().setText(list.get(position).getTitle());
            holder.itemView.setTag(list.get(position).getId());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getTag().equals(NEWS_LOVETAG)) {
            return NEWS_TAG_LOVE;
        } else {
            return NEWS_TAG_UNLOVE;
        }
    }
}