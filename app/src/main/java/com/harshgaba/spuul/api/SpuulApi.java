package com.harshgaba.spuul.api;

import com.harshgaba.spuul.models.banner.Banner;
import com.harshgaba.spuul.models.picks.Pick;
import com.harshgaba.spuul.models.videos.Video;

import java.util.List;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by harshgaba on 05/08/17.
 */

public interface SpuulApi {

    @GET("/banner")
    Observable<List<Banner>> getBannerData();

    @GET("picks")
    Observable<List<Pick>> getPicksData();

    @GET("videos")
    Observable<List<Video>> getVideosData();
}
