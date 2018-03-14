package com.demo.yetote.cubegame.adapter.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.demo.yetote.cubegame.R;
import com.demo.yetote.cubegame.model.GameLibModel;

import java.util.ArrayList;

/**
 * com.demo.yetote.cubegame.adapter.recyclerview
 * 游戏库Adapter
 *
 * @author Swg
 * @date 2018/3/14 20:39
 */
public class GameLibAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<GameLibModel> list;

    public GameLibAdapter(Context context, ArrayList<GameLibModel> list) {
        this.context = context;
        this.list = list;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private RatingBar score;
        private ImageView iv;
        // TODO: 2018/3/14 缺少自定义流式布局，展示标签


        private TextView getTitle() {
            return title;
        }

        private RatingBar getScore() {
            return score;
        }

        private ImageView getIv() {
            return iv;
        }

        private MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.fragment_gameLib_item_title);
            iv = itemView.findViewById(R.id.fragment_gameLib_item_cv_iv);
            score = itemView.findViewById(R.id.fragment_gameLib_item_ratingBar);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_gamelib, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder vh = (MyViewHolder) holder;
        vh.getTitle().setText(list.get(position).getTitle());
        vh.getScore().setRating(Float.parseFloat(list.get(position).getScore()));
        Glide.with(context).load(list.get(position).getImg()).into(vh.getIv());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
