package com.harshgaba.spuul.Screens.list.categorized_list;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.harshgaba.spuul.R;
import com.harshgaba.spuul.models.FeedData;
import com.harshgaba.spuul.models.banner.Banner;
import com.harshgaba.spuul.models.videos.Video;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by harshgaba on 06/08/17.
 */

public class BannerViewHolder extends RecyclerView.ViewHolder {

    private View view;
    private BannerPagerAdapter bannerPagerAdapter;
    @BindView(R.id.viewpager_banner)
    ViewPager sliderBanner;
    Context context;

    public BannerViewHolder(View itemView) {
        super(itemView);
        this.view = itemView;
        ButterKnife.bind(this, view);

    }

    public void bind(Context context) {

        this.context=context;
//        this.bannerPagerAdapter = new BannerPagerAdapter(context,null);
//        sliderBanner.setAdapter(this.bannerPagerAdapter);

    }

    public void swapAdapter(List<Banner> banners) {
        Log.e("feedDatasbanner", banners.size() + "view holder banner");
//        this.bannerPagerAdapter.swapAdapter(banners);
    }

}
