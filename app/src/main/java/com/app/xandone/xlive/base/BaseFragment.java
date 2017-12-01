package com.app.xandone.xlive.base;

import android.view.ViewGroup;

import com.app.xandone.xlive.app.App;
import com.app.xandone.xlive.di.component.DaggerFragmentComponent;
import com.app.xandone.xlive.di.component.FragmentComponent;
import com.app.xandone.xlive.di.module.FragmentModule;
import com.app.xandone.xlive.utils.SnackbarUtil;

import javax.inject.Inject;

/**
 * author: xandone
 * created on: 2017/11/28 15:07
 */

public abstract class BaseFragment<T extends BasePresenter> extends SimpleFragment implements BaseView {
    @Inject
    protected T mPresenter;

    protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .fragmentModule(getFragmentModule())
                .build();
    }

    @Override
    public void initView() {
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void initData() {

    }

    @Override
    public void initEvent() {

    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroyView();
    }

    protected FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }

    @Override
    public void showErrorMsg(String msg) {
        SnackbarUtil.show(((ViewGroup) getActivity().findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    @Override
    public void useNightMode(boolean isNight) {

    }

    @Override
    public void stateError() {

    }

    @Override
    public void stateEmpty() {

    }

    @Override
    public void stateLoading() {

    }

    @Override
    public void stateMain() {

    }

    protected abstract void initInject();
}
