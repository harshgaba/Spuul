package com.harshgaba.spuul.Screens.core;

import android.os.Looper;
import android.util.Log;

import com.harshgaba.spuul.R;
import com.harshgaba.spuul.models.FeedData;
import com.harshgaba.spuul.models.banner.Banner;
import com.harshgaba.spuul.models.picks.Pick;
import com.harshgaba.spuul.models.videos.Video;
import com.harshgaba.spuul.utils.RxSchedulers;
import com.harshgaba.spuul.utils.UiUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;
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

        Log.d("enter to presenter", "oki");
//        compositeSubscription.add(getFeeds());
        compositeSubscription.add(getBannersList());
        compositeSubscription.add(here());
//        here();
    }

    public void onDestroy() {
        compositeSubscription.clear();
        Log.e("allsubscriptionsclrea", "yes");
    }


    private void hereSavePicks(List<Pick> picks) {

        Log.e("hereSavePicks", picks.size() + "  ");
        this.picks.addAll(picks);
    }

    private Subscription here() {
        return feedModel.provideListCategory().subscribeOn(rxSchedulers.internet()).doOnNext(this::hereSavePicks).flatMapIterable(item -> item)
                .flatMap(item -> feedModel.provideListVideos(item.getId())).observeOn(rxSchedulers.androidThread()).doOnCompleted(() -> {
                    Log.e("herewehaveresult", "hereitcompleted" + "");

                    feedView.swapAdapter(this.feedDatas);
                }).
                        subscribe(videos -> {
                            Log.e("herewehaveresult", videos.size() + "");
                            FeedData feedData = new FeedData(picks.get(count), videos);
                            this.feedDatas.add(feedData);
                            count++;
                        });

    }

    private Subscription getFeeds() {
        return feedModel.isNetworkAvailable().doOnNext(networkAvailable -> {
            if (!networkAvailable) {
                Log.d("no conn", "no connexion");

            }
        }).filter(isNetworkAvailable -> true).flatMap(isAvailable -> getFeedDataList()).subscribeOn(rxSchedulers.internet())
                .observeOn(rxSchedulers.androidThread()).subscribe(feedDatas -> {
                    Log.d("ok loaded", "cccc");

                    feedView.swapAdapter(feedDatas);
                }, throwable -> {
                    Log.d("ok loaded", "exception " + throwable.getMessage());

                });
    }

    private Subscription getBannersList() {


        return feedModel.isNetworkAvailable().doOnNext(networkAvailable -> {
            if (!networkAvailable) {
                Log.d("no conn", "no connexion");
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
                }
        );

    }


    private Observable<ArrayList<FeedData>> getFeedDataList() {
        return Observable.zip(feedModel.provideListCategory(), feedModel.provideListVideos(), new Func2<List<Pick>, List<Video>, ArrayList<FeedData>>() {
            @Override
            public ArrayList<FeedData> call(List<Pick> picks, List<Video> videos) {
                ArrayList<FeedData> feedDataArrayList = new ArrayList<FeedData>();


                Map<Integer, ArrayList<Video>> map = new HashMap<Integer, ArrayList<Video>>();
                if (picks != null && picks.size() > 0 && videos != null && videos.size() > 0) {
                    for (Video video : videos) {
                        int categoryId = video.getCategoryId();
                        for (Pick pick : picks) {
                            if (categoryId == pick.getId()) {
                                ArrayList<Video> temp = new ArrayList<Video>();
                                if (map.containsKey(categoryId)) {
                                    temp.addAll(map.get(categoryId));
                                    temp.add(video);
                                    map.put(categoryId, temp);
                                } else {
                                    temp.add(video);
                                    map.put(categoryId, temp);
                                }
                                break;
                            }
                        }
                    }
                    Log.e("pick and videos size ", picks.size() + " " + videos.size());
                    for (Pick pick : picks) {
                        if (map.containsKey(pick.getId())) {
                            FeedData feedData = new FeedData(pick, map.get(pick.getId()));
                            feedDataArrayList.add(feedData);
                        }
                    }
                }
                Log.e("feedDatas size", feedDataArrayList.size() + "");
                return feedDataArrayList;

            }
        });
    }

    private Subscription getVideoList() {


        return feedModel.isNetworkAvailable().doOnNext(networkAvailable -> {
            if (!networkAvailable) {
                Log.d("no conn", "no connexion");
                // UiUtils.showSnackbar();
                // Show Snackbar can't use app
            }
        }).
                filter(isNetworkAvailable -> true).
                flatMap(isAvailable -> feedModel.provideListCategory()).
                subscribeOn(rxSchedulers.internet()).
                observeOn(rxSchedulers.runOnBackground()).subscribe(picks -> {
                    Log.d("ok loaded", "cccc");
                    Log.e("ok loaded", picks.size() + "");

//                    feedView.swapAdapter((List<Pick>) picks);
//                    picks = (ArrayList<Pick>) heroes.getElements();
                }, throwable -> {
                    UiUtils.handleThrowable(throwable);
                }
        );

    }
}
