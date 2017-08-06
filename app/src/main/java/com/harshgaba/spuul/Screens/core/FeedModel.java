package com.harshgaba.spuul.Screens.core;

import com.harshgaba.spuul.Screens.FeedActivity;
import com.harshgaba.spuul.api.SpuulApi;
import com.harshgaba.spuul.models.banner.Banner;
import com.harshgaba.spuul.models.picks.Pick;
import com.harshgaba.spuul.models.videos.Video;
import com.harshgaba.spuul.utils.NetworkUtils;

import java.util.List;

import rx.Observable;

/**
 * Created by harshgaba on 05/08/17.
 */

public class FeedModel {


    FeedActivity context;
    SpuulApi spuulApi;

    public FeedModel(FeedActivity context, SpuulApi spuulApi) {
        this.spuulApi = spuulApi;
        this.context = context;
    }


    Observable<List<Video>> provideListVideos() {
        return spuulApi.getVideosData();
    }

    Observable<List<Pick>> provideListCategory() {
        return spuulApi.getPicksData();
    }

    Observable<List<Banner>> provideListBanner() {
        return spuulApi.getBannerData();
    }

    Observable<Boolean> isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableObservable(context);
    }


//    public void gotoHeroDetailsActivity(Hero hero) {
//        context.goToHeroDetailsActivity(hero);
//    }


}
