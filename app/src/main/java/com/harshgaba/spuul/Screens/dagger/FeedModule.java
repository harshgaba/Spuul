package com.harshgaba.spuul.Screens.dagger;

import com.harshgaba.spuul.Screens.FeedActivity;
import com.harshgaba.spuul.Screens.core.FeedModel;
import com.harshgaba.spuul.Screens.core.FeedPresenter;
import com.harshgaba.spuul.Screens.core.FeedView;
import com.harshgaba.spuul.api.SpuulApi;
import com.harshgaba.spuul.utils.RxSchedulers;

import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by harshgaba on 05/08/17.
 */
@Module
public class FeedModule {

    FeedActivity context;

    public FeedModule(FeedActivity context) {
        this.context = context;
    }


    @FeedActivityScope
    @Provides
    FeedView provideView() {
        return new FeedView(context);
    }

    @FeedActivityScope
    @Provides
    FeedPresenter providePresenter(RxSchedulers schedulers, FeedView feedView, FeedModel feedModel) {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        return new FeedPresenter(schedulers, feedModel, feedView, compositeSubscription);
    }


    @FeedActivityScope
    @Provides
    FeedActivity provideFeedActivityContext() {
        return context;
    }

    @FeedActivityScope
    @Provides
    FeedModel provideFeedModel(SpuulApi spuulApi) {
        return new FeedModel(context, spuulApi);
    }
}
