package com.harshgaba.spuul.application.builder;

import com.harshgaba.spuul.api.SpuulApi;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by harshgaba on 05/08/17.
 */

@Module
public class SpullApiServiceModule {

    private static final String BASE_URL = "http://demo7051729.mockable.io/";
    @SpullApplicationScope
    @Provides
    SpuulApi provideSpullApiService(OkHttpClient okHttpClient, GsonConverterFactory gsonConverterFactory, RxJavaCallAdapterFactory rxJavaCallAdapterFactory)
    {
        Retrofit retrofit =   new Retrofit.Builder().client(okHttpClient)
                .baseUrl(BASE_URL).addConverterFactory(gsonConverterFactory).
                        addCallAdapterFactory(rxJavaCallAdapterFactory).build();

        return  retrofit.create(SpuulApi.class);
    }


}
