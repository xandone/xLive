package com.app.xandone.xlive.utils;

import java.util.Collection;

/**
 * author: xandone
 * created on: 2017/12/1 14:15
 */

public class CollectionUtils {
    public static boolean isNullOrEmpty(Collection c) {
        if (null == c || c.isEmpty()) {
            return true;
        }
        return false;
    }
}
