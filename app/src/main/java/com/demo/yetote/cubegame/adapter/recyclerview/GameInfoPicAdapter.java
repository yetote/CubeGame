package com.demo.yetote.cubegame.adapter.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.demo.yetote.cubegame.R;
import com.demo.yetote.cubegame.model.GameInfoPicModel;
import com.demo.yetote.cubegame.utils.OnClick;

import java.util.ArrayList;

/**
 * com.demo.yetote.cubegame.adapter
 * 游戏信息fragment的图片适配器
 *
 * @author Swg
 * @date 2018/2/8 14:03
 */
public class GameInfoPicAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<GameInfoPicModel> list;
    private OnClick listener;

    public OnClick getListener() {
        return listener;
    }

    public void setListener(OnClick listener) {
        this.listener = listener;
    }

    public GameInfoPicAdapter(Context context, ArrayList<GameInfoPicModel> list) {
        this.context = context;
        this.list = list;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;

        private ImageView getIv() {
            return iv;
        }

        private MyViewHolder(View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.item_game_info_pic_iv);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_game_info_pic, parent, false);
        v.setOnClickListener(v1 -> listener.onClickListener(v, (Integer) v.getTag()));
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder vh = (MyViewHolder) holder;
        Glide.with(context).load(list.get(position).getImg()).into(vh.getIv());
//        vh.itemView.setTag(list.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}