package com.app.xandone.xlive.di.module;

import com.app.xandone.xlive.app.App;
import com.app.xandone.xlive.model.DataManager;
import com.app.xandone.xlive.model.http.HttpHelper;
import com.app.xandone.xlive.model.http.RetrofitHelper;
import com.app.xandone.xlive.model.prefs.ImplPreferencesHelper;
import com.app.xandone.xlive.model.prefs.PreferencesHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * author: xandone
 * created on: 2017/11/28 9:30
 */

@Module
public class AppModule {
    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(RetrofitHelper retrofitHelper) {
        return retrofitHelper;
    }


    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(ImplPreferencesHelper implPreferencesHelper) {
        return implPreferencesHelper;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(HttpHelper httpHelper) {
        return new DataManager(httpHelper);
    }
}
