package com.harshgaba.spuul.Screens.core;

import android.util.Log;

import com.harshgaba.spuul.models.FeedData;
import com.harshgaba.spuul.models.picks.Pick;
import com.harshgaba.spuul.utils.RxSchedulers;
import com.harshgaba.spuul.utils.UiUtils;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by harshgaba on 05/08/17.
 */

public class FeedPresenter {

    FeedView feedView;
    FeedModel feedModel;
    RxSchedulers rxSchedulers;
    CompositeSubscription compositeSubscription;
    ArrayList<Pick> picks = new ArrayList<>();
    int count = 0;
    ArrayList<FeedData> feedDatas = new ArrayList<>();


    public FeedPresenter(RxSchedulers schedulers, FeedModel feedModel, FeedView feedView, CompositeSubscription compositeSubscription) {
        this.rxSchedulers = schedulers;
        this.feedView = feedView;
        this.feedModel = feedModel;
        this.compositeSubscription = compositeSubscription;
    }

    public void onCreate() {

        compositeSubscription.add(getBannersList());
        compositeSubscription.add(getFeeds());
    }

    public void onDestroy() {
        compositeSubscription.clear();
    }


    private void savePicksData(List<Pick> picks) {

        this.picks.addAll(picks);
    }

    private Subscription getFeeds() {

        return feedModel.isNetworkAvailable().doOnNext(networkAvailable -> {
            if (!networkAvailable) {
                feedView.showNetworkError();
            }
        }).
                filter(isNetworkAvailable -> true).
                flatMap(isAvailable ->
                        feedModel.provideListCategory()).subscribeOn(rxSchedulers.internet()).doOnNext(this::savePicksData).flatMapIterable(item -> item)
                .flatMap(item -> feedModel.provideListVideos(item.getId())).observeOn(rxSchedulers.androidThread()).doOnCompleted(() -> {
                    feedView.swapAdapter(this.feedDatas);
                }).
                        subscribe(videos -> {
                            FeedData feedData = new FeedData(picks.get(count), videos);
                            this.feedDatas.add(feedData);
                            count++;
                        }, throwable -> {
                            UiUtils.handleThrowable(throwable);
                        });

    }


    private Subscription getBannersList() {


        return feedModel.isNetworkAvailable().doOnNext(networkAvailable -> {
            if (!networkAvailable) {
                feedView.showNetworkError();
            }
        }).
                filter(isNetworkAvailable -> true).
                flatMap(isAvailable -> feedModel.provideListBanner()).
                subscribeOn(rxSchedulers.internet()).
                observeOn(rxSchedulers.androidThread()).subscribe(banners -> {

                    feedView.swapBannerAdapter(banners);
                }, throwable -> {
                    UiUtils.handleThrowable(throwable);
                    feedView.showServerError();
                }
        );

    }


}
