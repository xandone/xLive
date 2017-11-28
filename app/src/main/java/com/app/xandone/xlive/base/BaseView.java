package com.app.xandone.xlive.base;

/**
 * author: xandone
 * created on: 2017/11/27 16:44
 */

public interface BaseView {
    void showErrorMsg(String msg);

    void useNightMode(boolean isNight);

    void stateError();

    void stateEmpty();

    void stateLoading();

    void stateMain();
}
