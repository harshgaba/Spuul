package com.harshgaba.spuul.Screens.list;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.harshgaba.spuul.R;
import com.harshgaba.spuul.models.FeedData;
import com.harshgaba.spuul.models.banner.Banner;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by harshgaba on 05/08/17.
 */

public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 1;
    ArrayList<FeedData> feedDatas = new ArrayList<>();

    private FeedViewHolder feedViewHolder;

    public FeedAdapter() {

    }

    public void swapAdapter(ArrayList<FeedData> feedDatas) {
        this.feedDatas = new ArrayList<>();
        this.feedDatas.addAll(feedDatas);
        notifyDataSetChanged();
    }


    @Override
    public int getItemViewType(int position) {
        return TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_list_item_view, parent, false);
            return new FeedViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FeedData hero = feedDatas.get(position);
        feedViewHolder = (FeedViewHolder) holder;
        feedViewHolder.bind(hero);
    }

    @Override
    public int getItemCount() {
        if (feedDatas != null && feedDatas.size() > 0) {
            return feedDatas.size();
        } else {
            return 0;
        }
    }
}

