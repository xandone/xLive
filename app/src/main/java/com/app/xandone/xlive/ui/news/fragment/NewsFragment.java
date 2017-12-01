package com.app.xandone.xlive.ui.news.fragment;

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

    private NewsAdapter mNewsApdapter;
    private CommonItemDecoration mDecoration;
    private List<NewsSummary.T1348649145984Bean> newsList;

    @Override
    public int setLayout() {
        return R.layout.frag_news_layout;
    }

    @Override
    public void initData() {
        super.initData();
        mPresenter.attachView(this);
        mPresenter.getNewsData("list", "T1348649145984");

        newsList = new ArrayList<>();
        mNewsApdapter = new NewsAdapter(newsList);
        mDecoration = new CommonItemDecoration(1, CommonItemDecoration.UNIT_DP);
        mNewsRecycler.setAdapter(mNewsApdapter);
        mNewsRecycler.setLayoutManager(new LinearLayoutManager(mActivity));
        mNewsRecycler.addItemDecoration(mDecoration);
    }

    @Override
    public void showContent(NewsSummary newsSummary) {
        if (newsSummary != null && newsSummary.getT1348649145984() != null) {
            newsList.clear();
            newsList.addAll(newsSummary.getT1348649145984());
            mNewsApdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void showMoreContent(NewsSummary newsSummary) {

    }


    @Override
    protected void initInject() {
        getFragmentComponent().inject(this);
    }
}
