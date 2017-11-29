package com.app.xandone.xlive.utils;

import com.app.xandone.xlive.BuildConfig;
import com.orhanobut.logger.Logger;

/**
 * author: xandone
 * created on: 2017/11/29 14:12
 */

public class LogUtils {
    private static boolean isDeBug = BuildConfig.DEBUG;

    public static void d(String msg) {
        if (isDeBug) {
            Logger.d(msg);
        }
    }
}
