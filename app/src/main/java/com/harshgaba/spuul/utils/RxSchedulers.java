package com.harshgaba.spuul.utils;

import rx.Scheduler;

/**
 * Created by harshgaba on 05/08/17.
 */

public interface RxSchedulers {


    Scheduler runOnBackground();

    Scheduler io();

    Scheduler compute();

    Scheduler androidThread();

    Scheduler internet();



}
