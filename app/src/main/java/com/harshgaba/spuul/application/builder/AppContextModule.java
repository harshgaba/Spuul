package com.harshgaba.spuul.application.builder;

import android.content.Context;


import dagger.Module;
import dagger.Provides;

/**
 * Created by harshgaba on 05/08/17.
 */
@Module
public class AppContextModule {


    private final Context context;

    public AppContextModule(Context aContext) {
        this.context = aContext;
    }

    @SpullApplicationScope
    @Provides
    Context provideAppContext() {
        return context;
    }

}
