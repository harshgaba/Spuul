package com.harshgaba.spuul.application.builder;


import com.harshgaba.spuul.utils.AppRxSchedulers;
import com.harshgaba.spuul.utils.RxSchedulers;

import dagger.Module;
import dagger.Provides;

/**
 * Created by harshgaba on 05/08/17.
 */

@Module
public class RxModule {

    @Provides
    RxSchedulers provideRxSchedulers() {
        return new AppRxSchedulers();
    }
}
