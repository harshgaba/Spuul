package com.harshgaba.spuul.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

import com.harshgaba.spuul.R;

import timber.log.Timber;

/**
 * Created by harshgaba on 05/08/17.
 */

public class UiUtils {

    public static void handleThrowable(Throwable throwable) {
        Timber.e(throwable, throwable.toString());
    }

    public static void showSnackbar(View view, String message) {
        Snackbar snackbar = Snackbar
                .make(view, message, Snackbar.LENGTH_LONG);

        snackbar.show();
    }

    public static void showNetworkError(View view) {
        showSnackbar(view, view.getContext().getResources().getString(R.string.network_error));
    }


}
