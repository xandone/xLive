package com.app.xandone.xlive.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * author: xandone
 * created on: 2017/11/28 8:56
 */

public class SnackbarUtil {

    public static void show(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show();
    }

    public static void showShort(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
    }
}