package com.harshgaba.spuul.application;

import android.app.Application;

import com.harshgaba.spuul.application.builder.ApplicationComponent;
import com.harshgaba.spuul.application.builder.AppContextModule;
import com.harshgaba.spuul.application.builder.DaggerApplicationComponent;

import timber.log.BuildConfig;
import timber.log.Timber;

/**
 * Created by harshgaba on 05/08/17.
 */


public class ApplicationController extends Application {


    private static ApplicationComponent applicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        initialiseLogger();
        initAppComponent();

    }


    private void initAppComponent() {
        applicationComponent = DaggerApplicationComponent.builder().appContextModule(new AppContextModule(this)).build();
    }


    private void initialiseLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public static ApplicationComponent getNetComponent() {
        return applicationComponent;
    }

}
