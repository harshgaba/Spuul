package com.harshgaba.spuul.application.builder;

import android.content.Context;


import com.harshgaba.spuul.utils.AppRxSchedulers;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by harshgaba on 05/08/17.
 */

@Module
public class NetworkModule {

    @SpullApplicationScope
    @Provides
    OkHttpClient provideHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, Cache cache) {

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.addInterceptor(httpLoggingInterceptor);
        builder.cache(cache);
        return builder.build();
    }

    @SpullApplicationScope
    @Provides
    HttpLoggingInterceptor provideInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @SpullApplicationScope
    @Provides
    Cache provideCache(File file) {
        return new Cache(file, 10 * 10 * 1000);
    }

    @SpullApplicationScope
    @Provides
    File provideCacheFile(Context context) {
        return context.getFilesDir();
    }

    @SpullApplicationScope
    @Provides
    RxJavaCallAdapterFactory provideRxAdapter() {
        return RxJavaCallAdapterFactory.createWithScheduler(AppRxSchedulers.INTERNET_SCHEDULERS);
    }


    @Provides
    GsonConverterFactory provideGsonClient() {
        return GsonConverterFactory.create();
    }

}

