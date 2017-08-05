package com.harshgaba.spuul.Screens.dagger;

import com.harshgaba.spuul.Screens.FeedActivity;
import com.harshgaba.spuul.application.builder.ApplicationComponent;

import dagger.Component;

/**
 * Created by harshgaba on 05/08/17.
 */
@FeedActivityScope
@Component(dependencies = {ApplicationComponent.class}, modules = {FeedModule.class})
public interface FeedComponent {

    void inject(FeedActivity feedActivity);
}
