package com.app.xandone.xlive.di.component;

import android.app.Activity;

import com.app.xandone.xlive.di.module.ActivityModule;
import com.app.xandone.xlive.di.scope.ActivityScope;

import dagger.Component;

/**
 * author: xandone
 * created on: 2017/11/28 9:27
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Activity getActivity();
}
