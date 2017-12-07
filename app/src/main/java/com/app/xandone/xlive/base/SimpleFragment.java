package com.app.xandone.xlive.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * author: xandone
 * created on: 2017/11/28 14:53
 */

public abstract class SimpleFragment extends Fragment {
    protected Activity mActivity;

    //Fragment的View加载完毕的标记
    protected boolean isViewCreated;

    //Fragment对用户可见的标记
    protected boolean isUIVisible;

    @Override
    public void onAttach(Context context) {
        this.mActivity = (Activity) context;
        super.onAttach(context);
    }

    public abstract int setLayout();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayout(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isViewCreated = true;
        ButterKnife.bind(this, view);
        initView();
        initData();
        initEvent();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isUIVisible = true;
            lazyLoad();
        } else {
            isUIVisible = false;
        }
    }

    public abstract void initView();

    public abstract void initData();

    public abstract void initEvent();

    public void lazyLoad() {
        if (isViewCreated && isUIVisible) {
            lazyLoadData();
            //数据加载完毕,恢复标记,防止重复加载
            isViewCreated = false;
            isUIVisible = false;
        }
    }

    protected abstract void lazyLoadData();

}
