package com.demo.yetote.cubegame.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.yetote.cubegame.R;
import com.demo.yetote.cubegame.model.GameInfoThemeModel;

import java.util.ArrayList;

/**
 * com.demo.yetote.cubegame.adapter
 *
 * @author Swg
 * @date 2018/2/8 14:05
 */
public class GameInfoThemeAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<GameInfoThemeModel> list;

    public GameInfoThemeAdapter(Context context, ArrayList<GameInfoThemeModel> list) {
        this.context = context;
        this.list = list;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title, content, time, discussNum;

        private TextView getTitle() {
            return title;
        }

        private TextView getContent() {
            return content;
        }

        private TextView getTime() {
            return time;
        }

        private TextView getDiscussNum() {
            return discussNum;
        }

        private MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_game_info_theme_title);
            content = itemView.findViewById(R.id.item_game_info_theme_content);
            time = itemView.findViewById(R.id.item_game_info_theme_time);
            discussNum = itemView.findViewById(R.id.item_game_info_theme_discussNum);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_game_info_theme, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder vh = (MyViewHolder) holder;
        vh.getContent().setText(list.get(position).getContent());
        vh.getTitle().setText(list.get(position).getTitle());
        vh.getTime().setText(list.get(position).getTime());
        vh.getDiscussNum().setText(list.get(position).getDiscussNum());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
