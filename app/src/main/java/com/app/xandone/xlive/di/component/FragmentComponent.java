package com.app.xandone.xlive.di.component;

import android.app.Activity;

import com.app.xandone.xlive.di.module.FragmentModule;
import com.app.xandone.xlive.di.scope.FragmentScope;
import com.app.xandone.xlive.ui.news.fragment.NewsMainFragment;

import dagger.Component;

/**
 * author: xandone
 * created on: 2017/11/28 15:17
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {
    Activity getActivity();

    void inject(NewsMainFragment newsMainFragment);

}
