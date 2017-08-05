package com.harshgaba.spuul.application.builder;

import android.content.Context;

import com.harshgaba.spuul.api.SpuulApi;
import com.harshgaba.spuul.utils.RxSchedulers;

import dagger.Component;

/**
 * Created by harshgaba on 05/08/17.
 */
@SpullApplicationScope
@Component(modules = {NetworkModule.class, AppContextModule.class, RxModule.class, SpullApiServiceModule.class})
public interface ApplicationComponent {


    Context getAppContext();
    RxSchedulers rxSchedulers();
    SpuulApi spullApiService();


}
