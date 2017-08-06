package com.harshgaba.spuul.Screens.core;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.harshgaba.spuul.R;
import com.harshgaba.spuul.Screens.FeedActivity;
import com.harshgaba.spuul.Screens.list.FeedAdapter;
import com.harshgaba.spuul.models.FeedData;
import com.harshgaba.spuul.models.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;

/**
 * Created by harshgaba on 05/08/17.
 */

public class FeedView {

    @BindView(R.id.recyclerview_movies)
    RecyclerView moviesList;

    private View view;

    private FeedAdapter feedAdapter;


    public FeedView(FeedActivity context) {
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_feed, parent, true);
        ButterKnife.bind(this, view);
        feedAdapter = new FeedAdapter(context);
        moviesList.setAdapter(feedAdapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(context);
        moviesList.setLayoutManager(mLayoutManager);
    }

//    public Observable<Integer> itemClicks()
//    {
////        return adapter.observeClicks();
//    }

    public View view() {
        return view;
    }

    public void swapAdapter(ArrayList<FeedData> feedDatas) {
        Log.e("feedDatas", feedDatas.size() + "");
        feedAdapter.swapAdapter(feedDatas);

    }
    public void swapBannerAdapter(List<Banner> banners) {
        Log.e("feedDatasbanner", banners.size() + "");
        feedAdapter.swapBannerAdapter(banners);

    }
}
