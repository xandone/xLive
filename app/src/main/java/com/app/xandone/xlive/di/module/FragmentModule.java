package com.app.xandone.xlive.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.app.xandone.xlive.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * author: xandone
 * created on: 2017/11/28 15:12
 */

@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return fragment.getActivity();
    }
}
