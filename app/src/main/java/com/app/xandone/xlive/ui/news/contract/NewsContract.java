package com.app.xandone.xlive.ui.news.contract;

import com.app.xandone.xlive.base.BasePresenter;
import com.app.xandone.xlive.base.BaseView;
import com.app.xandone.xlive.model.bean.news.NewsSummary;

import java.util.List;

/**
 * author: xandone
 * created on: 2017/11/29 11:03
 */

public interface NewsContract {
    int MODE_ONE = 0;
    int MODE_MORE = 1;

    interface View extends BaseView {
        void showContent(List<NewsSummary> newsSummary);

        void showMoreContent(List<NewsSummary> newsSummary);
    }

    interface Presenter extends BasePresenter<View> {
        void getNewsData(String type, String id, int currentPage, int mode);

        void insertReadToDB(int id);
    }
}
