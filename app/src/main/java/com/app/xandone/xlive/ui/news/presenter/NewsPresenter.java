package com.app.xandone.xlive.ui.news.presenter;

import com.app.xandone.xlive.base.RxPresenter;
import com.app.xandone.xlive.model.DataManager;
import com.app.xandone.xlive.model.bean.news.NewsSummary;
import com.app.xandone.xlive.ui.news.contract.NewsContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;

/**
 * author: xandone
 * created on: 2017/11/29 11:10
 */

public class NewsPresenter extends RxPresenter<NewsContract.View> implements NewsContract.Presenter {
    private DataManager mDataManager;
    private int currentPage = 0;

    private static final int NUM_EACH_PAGE = 20;

    @Inject
    NewsPresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    @Override
    public void attachView(NewsContract.View view) {
        super.attachView(view);
        registerEvent();
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    @Override
    public void getNewsData(String type) {
        currentPage = 0;
        Flowable<List<NewsSummary>> list = mDataManager.getNewsData(type, currentPage, NUM_EACH_PAGE);

//        addSubscrible(list);
    }

    @Override
    public void insertReadToDB(int id) {

    }

    public void registerEvent() {
    }
}
