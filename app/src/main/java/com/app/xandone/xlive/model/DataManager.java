package com.app.xandone.xlive.model;

import com.app.xandone.xlive.model.bean.news.NewsSummary;
import com.app.xandone.xlive.model.http.HttpHelper;

import java.util.List;

import io.reactivex.Flowable;

/**
 * author: xandone
 * created on: 2017/11/28 9:36
 */

public class DataManager implements HttpHelper {
    HttpHelper mHttpHelper;

    public DataManager(HttpHelper httpHelper) {
        this.mHttpHelper = httpHelper;
    }

    @Override
    public Flowable<NewsSummary> getNewsData(String type, String id, int page) {
        return mHttpHelper.getNewsData(type, id, page);
    }
}
