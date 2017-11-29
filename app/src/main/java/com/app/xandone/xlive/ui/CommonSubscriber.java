package com.app.xandone.xlive.ui;

import android.text.TextUtils;

import com.app.xandone.xlive.base.BaseView;
import com.app.xandone.xlive.exception.ApiException;
import com.app.xandone.xlive.utils.LogUtils;

import io.reactivex.subscribers.ResourceSubscriber;
import retrofit2.HttpException;

/**
 * author: xandone
 * created on: 2017/11/29 14:01
 */

public class CommonSubscriber<T> extends ResourceSubscriber<T> {
    private BaseView mView;
    private String mErrorMsg;
    private boolean isShowErrorState;

    public CommonSubscriber(BaseView baseView) {
        this.mView = baseView;
    }

    protected CommonSubscriber(BaseView view, String errorMsg) {
        this.mView = view;
        this.mErrorMsg = errorMsg;
    }

    protected CommonSubscriber(BaseView view, boolean isShowErrorState) {
        this.mView = view;
        this.isShowErrorState = isShowErrorState;
    }

    protected CommonSubscriber(BaseView view, String errorMsg, boolean isShowErrorState) {
        this.mView = view;
        this.mErrorMsg = errorMsg;
        this.isShowErrorState = isShowErrorState;
    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable t) {
        if (mView == null) {
            return;
        }
        if (!TextUtils.isEmpty(mErrorMsg)) {
            mView.showErrorMsg(mErrorMsg);
        } else if (t instanceof ApiException) {
            mView.showErrorMsg(t.toString());
        } else if (t instanceof HttpException) {
            mView.showErrorMsg("数据加载失败");
        } else {
            mView.showErrorMsg("未知错误");
            LogUtils.d(t.toString());
        }
        if (isShowErrorState) {
            mView.stateError();
        }

    }

    @Override
    public void onComplete() {

    }
}
