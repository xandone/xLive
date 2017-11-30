package com.app.xandone.xlive.ui.news.contract;

import com.app.xandone.xlive.base.BasePresenter;
import com.app.xandone.xlive.base.BaseView;
import com.app.xandone.xlive.model.bean.news.NewsSummary;

/**
 * author: xandone
 * created on: 2017/11/29 11:03
 */

public interface NewsContract {
    interface View extends BaseView {
        void showContent(NewsSummary newsSummary);

        void showMoreContent(NewsSummary newsSummary);
    }

    interface Presenter extends BasePresenter<View> {
        void getNewsData(String type);

        void insertReadToDB(int id);
    }
}
