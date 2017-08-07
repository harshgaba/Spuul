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

//    private Subscription getFeeds() {
//        return feedModel.isNetworkAvailable().doOnNext(networkAvailable -> {
//            if (!networkAvailable) {
//                Log.d("no conn", "no connexion");
//
//            }
//        }).filter(isNetworkAvailable -> true).flatMap(isAvailable -> getFeedDataList()).subscribeOn(rxSchedulers.internet())
//                .observeOn(rxSchedulers.androidThread()).subscribe(feedDatas -> {
//                    Log.d("ok loaded", "cccc");
//
//                    feedView.swapAdapter(feedDatas);
//                }, throwable -> {
//                    Log.d("ok loaded", "exception " + throwable.getMessage());
//
//                });
//    }

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
                    Log.d("ok loaded", "cccc");
                    Log.e("ok loadedbanner", banners.size() + "");

                    feedView.swapBannerAdapter(banners);
                }, throwable -> {
                    UiUtils.handleThrowable(throwable);
                    feedView.showServerError();
                }
        );

    }


//    private Observable<ArrayList<FeedData>> getFeedDataList() {
//        return Observable.zip(feedModel.provideListCategory(), feedModel.provideListVideos(), new Func2<List<Pick>, List<Video>, ArrayList<FeedData>>() {
//            @Override
//            public ArrayList<FeedData> call(List<Pick> picks, List<Video> videos) {
//                ArrayList<FeedData> feedDataArrayList = new ArrayList<FeedData>();
//
//
//                Map<Integer, ArrayList<Video>> map = new HashMap<Integer, ArrayList<Video>>();
//                if (picks != null && picks.size() > 0 && videos != null && videos.size() > 0) {
//                    for (Video video : videos) {
//                        int categoryId = video.getCategoryId();
//                        for (Pick pick : picks) {
//                            if (categoryId == pick.getId()) {
//                                ArrayList<Video> temp = new ArrayList<Video>();
//                                if (map.containsKey(categoryId)) {
//                                    temp.addAll(map.get(categoryId));
//                                    temp.add(video);
//                                    map.put(categoryId, temp);
//                                } else {
//                                    temp.add(video);
//                                    map.put(categoryId, temp);
//                                }
//                                break;
//                            }
//                        }
//                    }
//                    Log.e("pick and videos size ", picks.size() + " " + videos.size());
//                    for (Pick pick : picks) {
//                        if (map.containsKey(pick.getId())) {
//                            FeedData feedData = new FeedData(pick, map.get(pick.getId()));
//                            feedDataArrayList.add(feedData);
//                        }
//                    }
//                }
//                Log.e("feedDatas size", feedDataArrayList.size() + "");
//                return feedDataArrayList;
//
//            }
//        });
//    }

//    private Subscription getVideoList() {
//
//
//        return feedModel.isNetworkAvailable().doOnNext(networkAvailable -> {
//            if (!networkAvailable) {
//                Log.d("no conn", "no connexion");
//                // UiUtils.showSnackbar();
//                // Show Snackbar can't use app
//            }
//        }).
//                filter(isNetworkAvailable -> true).
//                flatMap(isAvailable -> feedModel.provideListCategory()).
//                subscribeOn(rxSchedulers.internet()).
//                observeOn(rxSchedulers.runOnBackground()).subscribe(picks -> {
//                    Log.d("ok loaded", "cccc");
//                    Log.e("ok loaded", picks.size() + "");
//
////                    feedView.swapAdapter((List<Pick>) picks);
////                    picks = (ArrayList<Pick>) heroes.getElements();
//                }, throwable -> {
//                    UiUtils.handleThrowable(throwable);
//                }
//        );
//
//    }
}
