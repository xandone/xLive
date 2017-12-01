package com.app.xandone.xlive.api;

import com.app.xandone.xlive.model.bean.news.NewsSummary;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * author: xandone
 * created on: 2017/11/29 14:19
 */

public interface NewsApi {

    String HOST = "http://c.m.163.com/";

    @GET("nc/article/{type}/{id}/{startPage}-20.html")
    Flowable<NewsSummary> getNewsList(
            @Path("type") String type,
            @Path("id") String id,
            @Path("startPage") int startPage);

}
