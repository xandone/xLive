package com.app.xandone.xlive.ui.news.presenter;

import com.app.xandone.xlive.base.RxPresenter;
import com.app.xandone.xlive.model.DataManager;
import com.app.xandone.xlive.ui.news.contract.NewsContract;

import javax.inject.Inject;

import io.reactivex.disposables.Disposable;

/**
 * author: xandone
 * created on: 2017/11/29 11:10
 */

public class NewsPresenter extends RxPresenter<NewsContract.View> implements NewsContract.Presenter {
    private Disposable mDisposable;
    private DataManager mDataManager;

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
    public void getNewsData() {

    }

    @Override
    public void insertReadToDB(int id) {

    }

    public void registerEvent() {
    }
}
