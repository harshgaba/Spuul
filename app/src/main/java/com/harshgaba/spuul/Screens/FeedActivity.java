package com.harshgaba.spuul.Screens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.harshgaba.spuul.R;
import com.harshgaba.spuul.Screens.core.FeedPresenter;
import com.harshgaba.spuul.Screens.core.FeedView;
import com.harshgaba.spuul.Screens.dagger.DaggerFeedComponent;
import com.harshgaba.spuul.Screens.dagger.FeedModule;
import com.harshgaba.spuul.application.ApplicationController;

import javax.inject.Inject;

public class FeedActivity extends AppCompatActivity {

    @Inject
    FeedView view;
    @Inject
    FeedPresenter presenter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerFeedComponent.builder().applicationComponent(ApplicationController.getNetComponent()).feedModule(new FeedModule(this)).build().inject(this);
        setContentView(view.view());
        presenter.onCreate();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
