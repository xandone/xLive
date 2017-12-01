package com.app.xandone.xlive.base;

import android.view.ViewGroup;

import com.app.xandone.xlive.app.App;
import com.app.xandone.xlive.di.component.ActivityComponent;
import com.app.xandone.xlive.di.component.DaggerActivityComponent;
import com.app.xandone.xlive.di.module.ActivityModule;
import com.app.xandone.xlive.utils.SnackbarUtil;

import javax.inject.Inject;

/**
 * author: xandone
 * created on: 2017/11/27 16:41
 */

public abstract class BaseActivity<T extends BasePresenter> extends SimpleActivity implements BaseView {
    @Inject
    protected T mPresenter;

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(getActivityModule())
                .build();

    }

    @Override
    protected void initView() {
        initInject();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }

    public ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    public abstract void initInject();

    @Override
    public void showErrorMsg(String msg) {
        SnackbarUtil.show(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    @Override
    public void stateEmpty() {

    }

    @Override
    public void stateError() {

    }


    @Override
    public void stateLoading() {

    }

    @Override
    public void stateMain() {

    }
}
