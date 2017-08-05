package com.harshgaba.spuul.utils;

import android.view.View;

import timber.log.Timber;

/**
 * Created by harshgaba on 05/08/17.
 */

public class UiUtils {


    public static void handleThrowable(Throwable throwable) {
        Timber.e(throwable, throwable.toString());
    }

    public static void showSnackbar(View view, String message, int length) {
//        Snackbar.make(view, message, length).setAction("Action", null).show();
    }


}
