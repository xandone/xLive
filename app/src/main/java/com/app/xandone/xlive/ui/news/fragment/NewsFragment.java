package com.app.xandone.xlive.ui.news.fragment;

import com.app.xandone.xlive.R;
import com.app.xandone.xlive.base.BaseFragment;
import com.app.xandone.xlive.model.bean.news.NewsSummary;
import com.app.xandone.xlive.ui.news.contract.NewsContract;
import com.app.xandone.xlive.ui.news.presenter.NewsPresenter;

/**
 * author: xandone
 * created on: 2017/11/28 14:52
 */

public class NewsFragment extends BaseFragment<NewsPresenter> implements NewsContract.View {

    @Override
    public int setLayout() {
        return R.layout.frag_news_layout;
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void initData() {
        super.initData();
        mPresenter.attachView(this);
    }

    @Override
    public void showContent(NewsSummary newsSummary) {

    }

    @Override
    public void showMoreContent(NewsSummary newsSummary) {

    }
}
