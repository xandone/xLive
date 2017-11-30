package com.app.xandone.xlive.model.http;

import com.app.xandone.xlive.api.NewsApi;
import com.app.xandone.xlive.model.bean.news.NewsSummary;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * author: xandone
 * created on: 2017/11/28 9:37
 */

public class RetrofitHelper implements HttpHelper {
    private NewsApi mNewsApi;

    @Inject
    public RetrofitHelper(NewsApi newsApi) {
        this.mNewsApi = newsApi;
    }

    @Override
    public Flowable<List<NewsSummary>> getNewsData(String type, int num, int page) {
        return null;
    }
}
