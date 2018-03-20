package com.demo.yetote.cubegame.adapter.recyclerview;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.demo.yetote.cubegame.R;
import com.demo.yetote.cubegame.model.BoonModel;
import com.demo.yetote.cubegame.utils.TimingButton;

import java.util.ArrayList;

/**
 * com.demo.yetote.cubegame.adapter.recyclerview
 *
 * @author Swg
 * @date 2018/3/13 20:32
 */
public class BoonAdapter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<BoonModel> list;
    private static final String BOON_FREE_TAG = "free";
    private static final int BOON_FREE = 1;
    private static final int BOON_UNFREE = 0;

    public BoonAdapter(Context context, ArrayList<BoonModel> list) {
        this.context = context;
        this.list = list;
    }

    private class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView title, content, originalCost, discountCost, percentage;

        private ImageView getIv() {
            return iv;
        }

        private TextView getTitle() {
            return title;
        }

        private TextView getContent() {
            return content;
        }

        private TextView getOriginalCost() {
            return originalCost;
        }

        private TextView getDiscountCost() {
            return discountCost;
        }

        private TextView getPercentage() {
            return percentage;
        }

        private MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_boon_discount_title);
            content = itemView.findViewById(R.id.item_boon_discount_content);
            originalCost = itemView.findViewById(R.id.item_boon_discount_originalCost);
            discountCost = itemView.findViewById(R.id.item_boon_discount_discountCost);
            percentage = itemView.findViewById(R.id.item_boon_discount_percentage);
            iv = itemView.findViewById(R.id.item_boon_discount_iv);
        }
    }

    private class MyFreeViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView title, content;
        private TimingButton timingButton;

        private ImageView getIv() {
            return iv;
        }

        private TextView getTitle() {
            return title;
        }

        private TextView getContent() {
            return content;
        }

        private TimingButton getTimingButton() {
            return timingButton;
        }

        private MyFreeViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_boon_free_title);
            content = itemView.findViewById(R.id.item_boon_free_content);
            iv = itemView.findViewById(R.id.item_boon_free_iv);
            timingButton = itemView.findViewById(R.id.item_boon_free_download);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        if (viewType == BOON_FREE) {
            v = LayoutInflater.from(context).inflate(R.layout.item_boon_free, parent, false);
            return new MyFreeViewHolder(v);
        } else {
            v = LayoutInflater.from(context).inflate(R.layout.item_boon_discount, parent, false);
            return new MyViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyFreeViewHolder) {
            MyFreeViewHolder vh = (MyFreeViewHolder) holder;
            vh.getContent().setText(list.get(position).getContent());
            vh.getTitle().setText(list.get(position).getTitle());
            vh.getTimingButton().setTime(list.get(position).getTime());
            Glide.with(context).load(list.get(position).getImg()).into(vh.getIv());
        } else {
            MyViewHolder vh = (MyViewHolder) holder;
            vh.getContent().setText(list.get(position).getContent());
            vh.getTitle().setText(list.get(position).getTitle());
            vh.getPercentage().setText(list.get(position).getPercentage());
            vh.getDiscountCost().setText(list.get(position).getDiscountCost());
            vh.getOriginalCost().setText(list.get(position).getOriginalCost());
            Glide.with(context).load(list.get(position).getImg()).into(vh.getIv());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position).getTag().equals(BOON_FREE_TAG)) {
            return BOON_FREE;
        } else {
            return BOON_UNFREE;
        }
    }
}
