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
import com.demo.yetote.cubegame.model.HomePagerModel;

import java.util.ArrayList;

/**
 * com.demo.yetote.cubegame.adapter.recyclerview
 *
 * @author Swg
 * @date 2018/3/12 21:07
 */
public class HomePagerAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<HomePagerModel> list;
    private String tag = "炉石传说";
    private static final int RECOMMEND_TAG = 1;
    private static final int UN_RECOMMEND_TAG = 0;

    public HomePagerAdapter(Context context, ArrayList<HomePagerModel> list) {
        this.context = context;
        this.list = list;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title, content, score;
        private ImageView iv;

        private TextView getTitle() {
            return title;
        }

        private TextView getContent() {
            return content;
        }

        private TextView getScore() {
            return score;
        }

        private ImageView getIv() {
            return iv;
        }

        private MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_homePager_title);
            content = itemView.findViewById(R.id.item_homePager_content);
            score = itemView.findViewById(R.id.item_homePager_score);
            iv = itemView.findViewById(R.id.item_homePager_iv);

        }
    }

    private class MyRecommendViewHolder extends RecyclerView.ViewHolder {
        private TextView recommendTitle, recommendScore, recommendOriginate, recommendDiscussNum, developerWords;
        private ImageView recommendIv, recommendMenu;

        private TextView getDeveloperWords() {
            return developerWords;
        }

        private TextView getRecommendTitle() {
            return recommendTitle;
        }

        private ImageView getRecommendMenu() {
            return recommendMenu;
        }

        private TextView getRecommendScore() {
            return recommendScore;
        }

        private TextView getRecommendOriginate() {
            return recommendOriginate;
        }

        private TextView getRecommendDiscussNum() {
            return recommendDiscussNum;
        }

        private ImageView getRecommendIv() {
            return recommendIv;
        }

        private MyRecommendViewHolder(View itemView) {
            super(itemView);
            recommendTitle = itemView.findViewById(R.id.item_homePager_recommend_title);
            recommendMenu = itemView.findViewById(R.id.item_homePager_recommend_menu);
            recommendScore = itemView.findViewById(R.id.item_homePager_recommend_score);
            recommendOriginate = itemView.findViewById(R.id.item_homePager_recommend_originate);
            recommendDiscussNum = itemView.findViewById(R.id.item_homePager_recommend_discussNum);
            developerWords = itemView.findViewById(R.id.item_homePager_recommend_developerWords);
            recommendIv = itemView.findViewById(R.id.item_homePager_recommend_iv);


        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (viewType == RECOMMEND_TAG) {
            v = LayoutInflater.from(context).inflate(R.layout.item_homepager_recommend, parent, false);
            return new MyViewHolder(v);
        } else {
            v = LayoutInflater.from(context).inflate(R.layout.item_homepager, parent, false);
            return new MyRecommendViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyRecommendViewHolder) {
            MyRecommendViewHolder vh = (MyRecommendViewHolder) holder;
            vh.getRecommendTitle().setText(list.get(position).getTitle());
            vh.getRecommendScore().setText(list.get(position).getScore());
            vh.getRecommendDiscussNum().setText(list.get(position).getDiscussNum());
            vh.getDeveloperWords().setText(list.get(position).getDeveloperWords());
            Glide.with(context).load(list.get(position).getIv()).into(vh.getRecommendIv());
        } else {
            MyViewHolder vh = (MyViewHolder) holder;
            vh.getContent().setText(list.get(position).getContent());
            vh.getTitle().setText(list.get(position).getTitle());
            vh.getScore().setText(list.get(position).getScore());
            Glide.with(context).load(list.get(position).getIv()).into(vh.getIv());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getTag().equals(tag)) {
            return RECOMMEND_TAG;
        } else {
            return UN_RECOMMEND_TAG;
        }
    }
}
