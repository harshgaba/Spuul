package com.harshgaba.spuul.Screens.core;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.harshgaba.spuul.R;
import com.harshgaba.spuul.Screens.FeedActivity;
import com.harshgaba.spuul.Screens.list.FeedAdapter;
import com.harshgaba.spuul.Screens.list.categorized_list.SliderAdapter;
import com.harshgaba.spuul.models.FeedData;
import com.harshgaba.spuul.models.banner.Banner;
import com.harshgaba.spuul.utils.UiUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by harshgaba on 05/08/17.
 */

public class FeedView {

    @BindView(R.id.recyclerview_movies)
    RecyclerView moviesList;
    @BindView(R.id.viewpager_banner)
    ViewPager sliderBanner;
    private View view;
    private FeedAdapter feedAdapter;
    Context context;
    SliderAdapter sliderAdapter;


    public FeedView(FeedActivity context) {
        this.context = context;
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_feed, parent, true);
        ButterKnife.bind(this, view);
        feedAdapter = new FeedAdapter();
        moviesList.setAdapter(feedAdapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        moviesList.setLayoutManager(mLayoutManager);

    }


    public View view() {
        return view;
    }

    public void swapAdapter(ArrayList<FeedData> feedDatas) {
        feedAdapter.swapAdapter(feedDatas);

    }


    public void swapBannerAdapter(List<Banner> banners) {

        sliderAdapter = new SliderAdapter(banners, context);
        sliderBanner.setAdapter(sliderAdapter);
    }

    public void showNetworkError() {
        UiUtils.showNetworkError(view);
    }

    public void showServerError() {
        UiUtils.showSnackbar(view, context.getResources().getString(R.string.server_error));
    }



}
