package com.app.xandone.xlive.model.http;

import com.app.xandone.xlive.model.bean.news.NewsSummary;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;

/**
 * author: xandone
 * created on: 2017/11/30 15:29
 */

public interface HttpHelper {
    Flowable<Map<String, List<NewsSummary>>> getNewsData(String type, String id, int page);
}
