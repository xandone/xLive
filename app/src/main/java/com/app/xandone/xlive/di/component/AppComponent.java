package com.app.xandone.xlive.di.component;

import com.app.xandone.xlive.app.App;
import com.app.xandone.xlive.di.module.AppModule;
import com.app.xandone.xlive.di.module.HttpModule;
import com.app.xandone.xlive.model.DataManager;
import com.app.xandone.xlive.model.http.RetrofitHelper;
import com.app.xandone.xlive.model.prefs.ImplPreferencesHelper;

import javax.inject.Singleton;

import dagger.Component;

/**
 * author: xandone
 * created on: 2017/11/28 9:28
 */
@Singleton
@Component(modules = {AppModule.class, HttpModule.class})
public interface AppComponent {

//    App getContext();  // 提供App的Context

//    DataManager getDataManager(); //数据中心

//    RetrofitHelper retrofitHelper();  //提供http的帮助类

//    RealmHelper realmHelper();    //提供数据库帮助类

    ImplPreferencesHelper preferencesHelper(); //提供sp帮助类
}