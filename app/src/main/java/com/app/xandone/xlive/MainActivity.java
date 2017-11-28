package com.app.xandone.xlive;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.app.xandone.xlive.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    private List<Fragment> fragmentList;
    private int mFragmentIndex;
    private Fragment mCurrentFrag;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    public void useNightMode(boolean isNight) {

    }

    @Override
    public void initInject() {

    }

    @Override
    protected void initData() {
        super.initData();
        fragmentList = new ArrayList<>();

        mFragmentIndex = 0;
        turnToFragment();
    }

    @OnClick({R.id.rb_main_foot_1, R.id.rb_main_foot_2, R.id.rb_main_foot_3, R.id.rb_main_foot_4})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.rb_main_foot_1:
                mFragmentIndex = 0;
                break;
            case R.id.rb_main_foot_2:
                mFragmentIndex = 1;
                break;
            case R.id.rb_main_foot_3:
                mFragmentIndex = 2;
                break;
            case R.id.rb_main_foot_4:
                mFragmentIndex = 3;
                break;
        }
        turnToFragment();
    }

    public void turnToFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = fragmentList.get(mFragmentIndex);
        if (mCurrentFrag != null) {
            ft.hide(mCurrentFrag);
        }
        if (fragment.isAdded()) {
            ft.show(fragment);
        } else {
            ft.add(R.id.fl_main, fragment);
        }
        ft.commitAllowingStateLoss();
        mCurrentFrag = fragment;

    }
}
