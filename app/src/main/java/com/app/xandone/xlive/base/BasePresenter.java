package com.app.xandone.xlive.base;

/**
 * author: xandone
 * created on: 2017/11/27 16:47
 */

public interface BasePresenter<T extends BaseView> {
    void attachView(T view);

    void detachView();
}
