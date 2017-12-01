package com.app.xandone.xlive.ui.news.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.app.xandone.xlive.R;
import com.app.xandone.xlive.base.BaseFragment;
import com.app.xandone.xlive.model.bean.news.NewsSummary;
import com.app.xandone.xlive.ui.news.adapter.BaseFragmentAdapter;
import com.app.xandone.xlive.ui.news.contract.NewsContract;
import com.app.xandone.xlive.utils.SimpleUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;


/**
 * author: xandone
 * created on: 2017/11/28 14:52
 */

public class NewsMainFragment extends BaseFragment implements NewsContract.View {
    @BindView(R.id.news_main_vp)
    ViewPager mNewsVp;
    @BindView(R.id.news_tablayout)
    TabLayout mTab;
    private BaseFragmentAdapter mBaseFragmentAdapter;
    private List<Fragment> fragmentList;
    private List<String> titleList = new ArrayList<>(Arrays.asList("NBA", "NBA", "NBA", "NBA", "NBA", "NBA", "NBA", "NBA", "NBA", "NBA", "NBA"));

    @Override
    public int setLayout() {
        return R.layout.frag_main_news_layout;
    }

    @Override
    protected void initInject() {
    }

    @Override
    public void initData() {
        super.initData();

        fragmentList = new ArrayList<>();
        for (int i = 1; i < titleList.size(); i++) {
            fragmentList.add(new NewsFragment());
        }

        mBaseFragmentAdapter = new BaseFragmentAdapter(getChildFragmentManager(), fragmentList, titleList);
        mNewsVp.setAdapter(mBaseFragmentAdapter);
        mTab.setupWithViewPager(mNewsVp);
        SimpleUtils.dynamicSetTabLayoutMode(mTab);
    }

    @Override
    public void showContent(NewsSummary newsSummary) {
    }

    @Override
    public void showMoreContent(NewsSummary newsSummary) {

    }
}
