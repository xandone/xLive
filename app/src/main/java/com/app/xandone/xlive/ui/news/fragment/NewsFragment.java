package com.app.xandone.xlive.ui.news.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.app.xandone.xlive.R;
import com.app.xandone.xlive.base.BaseFragment;
import com.app.xandone.xlive.model.bean.news.NewsSummary;
import com.app.xandone.xlive.ui.news.adapter.NewsAdapter;
import com.app.xandone.xlive.ui.news.contract.NewsContract;
import com.app.xandone.xlive.ui.news.presenter.NewsPresenter;
import com.app.xandone.xlive.widget.CommonItemDecoration;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * author: xandone
 * created on: 2017/12/1 13:47
 */

public class NewsFragment extends BaseFragment<NewsPresenter> implements NewsContract.View {
    @BindView(R.id.news_recycler)
    RecyclerView mNewsRecycler;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout mRefreshLayout;

    private NewsAdapter mNewsApdapter;
    private DividerItemDecoration mDecoration;
    private List<NewsSummary.T1348649145984Bean> newsList;

    private int mPage = 0;

    @Override
    public int setLayout() {
        return R.layout.frag_news_layout;
    }

    @Override
    public void initData() {
        super.initData();
        mPresenter.attachView(this);
        mPresenter.getNewsData("list", "T1348649145984", mPage, NewsContract.MODE_ONE);

        newsList = new ArrayList<>();
        mNewsApdapter = new NewsAdapter(newsList);
        mDecoration = new DividerItemDecoration(mActivity, DividerItemDecoration.VERTICAL);
        mNewsRecycler.setAdapter(mNewsApdapter);
        mNewsRecycler.setLayoutManager(new LinearLayoutManager(mActivity));
        mNewsRecycler.addItemDecoration(mDecoration);
    }

    @Override
    public void initEvent() {
        super.initEvent();
        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                mPage = 0;
                mPresenter.getNewsData("list", "T1348649145984", mPage, NewsContract.MODE_ONE);
            }
        });

        mRefreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                mPage += 20;
                mPresenter.getNewsData("list", "T1348649145984", mPage, NewsContract.MODE_MORE);
            }
        });
    }

    @Override
    public void showContent(NewsSummary newsSummary) {
        mRefreshLayout.finishRefresh();
        if (newsSummary != null && newsSummary.getT1348649145984() != null) {
            newsList.clear();
            newsList.addAll(newsSummary.getT1348649145984());
            mNewsApdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showMoreContent(NewsSummary newsSummary) {
        mRefreshLayout.finishLoadmore();
        if (newsSummary != null && newsSummary.getT1348649145984() != null) {
            newsList.clear();
            newsList.addAll(newsSummary.getT1348649145984());
            mNewsApdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showErrorMsg(String msg) {
        super.showErrorMsg(msg);
        mRefreshLayout.finishRefresh();
        mRefreshLayout.finishLoadmore();
    }

    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }
}
