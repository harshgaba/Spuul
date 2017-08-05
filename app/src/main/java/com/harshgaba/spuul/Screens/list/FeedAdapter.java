package com.harshgaba.spuul.Screens.list;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.harshgaba.spuul.R;
import com.harshgaba.spuul.models.FeedData;

import java.util.ArrayList;


/**
 * Created by harshgaba on 05/08/17.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedViewHolder> {

    ArrayList<FeedData> feedDatas = new ArrayList<>();


    public void swapAdapter(ArrayList<FeedData> feedDatas) {
        this.feedDatas.clear();
        this.feedDatas.addAll(feedDatas);
        notifyDataSetChanged();
    }


    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_list_item_view, parent, false);
        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FeedViewHolder feedViewHolder, int position) {
        FeedData hero = feedDatas.get(position);
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

