package com.app.xandone.xlive.ui.news.presenter;

import com.app.xandone.xlive.base.RxPresenter;
import com.app.xandone.xlive.model.DataManager;
import com.app.xandone.xlive.model.bean.news.NewsSummary;
import com.app.xandone.xlive.ui.CommonSubscriber;
import com.app.xandone.xlive.ui.news.contract.NewsContract;

import org.reactivestreams.Publisher;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * author: xandone
 * created on: 2017/11/29 11:10
 */

public class NewsPresenter extends RxPresenter<NewsContract.View> implements NewsContract.Presenter {
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
    public void getNewsData(String type, final String id, int currentPage, final int mode) {
        Flowable<Map<String, List<NewsSummary>>> list = mDataManager.getNewsData(type, id, currentPage);

        addSubscrible(list
                .flatMap(new Function<Map<String, List<NewsSummary>>, Publisher<List<NewsSummary>>>() {
                    @Override
                    public Publisher<List<NewsSummary>> apply(Map<String, List<NewsSummary>> map) {
                        return Flowable.fromArray(map.get(id));
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new CommonSubscriber<List<NewsSummary>>(mView) {
                    @Override
                    public void onNext(List<NewsSummary> newsSummaries) {
                        if (mode == NewsContract.MODE_ONE) {
                            mView.showContent(newsSummaries);
                        } else {
                            mView.showMoreContent(newsSummaries);
                        }
                    }
                })

        );
    }

    @Override
    public void insertReadToDB(int id) {

    }

    public void registerEvent() {
    }
}
