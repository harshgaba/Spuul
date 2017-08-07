package com.harshgaba.spuul.Screens.list;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.harshgaba.spuul.R;
import com.harshgaba.spuul.Screens.list.categorized_list.BannerPagerAdapter;
import com.harshgaba.spuul.Screens.list.categorized_list.BannerViewHolder;
import com.harshgaba.spuul.Screens.list.categorized_list.FeedCategorizeMoviesAdapter;
import com.harshgaba.spuul.models.FeedData;
import com.harshgaba.spuul.models.banner.Banner;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by harshgaba on 05/08/17.
 */

public class FeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    ArrayList<FeedData> feedDatas = new ArrayList<>();
    private BannerPagerAdapter bannerPagerAdapter = null;

    private FeedViewHolder feedViewHolder;
    private BannerViewHolder bannerViewHolder;
    private Context context;

    public FeedAdapter(Context context) {
        this.context = context;
    }

    public void swapAdapter(ArrayList<FeedData> feedDatas) {
        this.feedDatas = new ArrayList<>();
        this.feedDatas.addAll(feedDatas);
        notifyDataSetChanged();
    }

    public void swapBannerAdapter(List<Banner> banners) {
        Log.e("feedDatasbanner", banners.size() + "feedadater");
//        bannerViewHolder.swapAdapter(banners);

    }


    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    @Override
    public int getItemViewType(int position) {
//        if (isPositionHeader(position))
//            return TYPE_HEADER;
        return TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_HEADER) {
            //inflate your layout and pass it to view holder
            Log.e("hereinTYPE_HEADER", "TYPE_HEADER");
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_view, parent, false);
//            return new BannerViewHolder(view);
return null;
        } else {
            //inflate your layout and pass it to view holder
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_list_item_view, parent, false);
            return new FeedViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        if (isPositionHeader(position)) {
//            bannerViewHolder = (BannerViewHolder) holder;
//            bannerViewHolder.bind(context);
//        } else {
            FeedData hero = feedDatas.get(position);
            feedViewHolder = (FeedViewHolder) holder;
            feedViewHolder.bind(hero);
       // }
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

