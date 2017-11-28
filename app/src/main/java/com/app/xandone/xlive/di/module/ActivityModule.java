package com.app.xandone.xlive.di.module;

import android.app.Activity;

import com.app.xandone.xlive.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * author: xandone
 * created on: 2017/11/28 9:39
 */


@Module
public class ActivityModule {
    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return activity;
    }
}
