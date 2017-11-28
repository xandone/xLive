package com.app.xandone.xlive.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.app.xandone.xlive.di.component.AppComponent;
import com.app.xandone.xlive.di.component.DaggerAppComponent;
import com.app.xandone.xlive.di.module.AppModule;
import com.app.xandone.xlive.di.module.HttpModule;

import java.util.HashSet;
import java.util.Set;

/**
 * author: xandone
 * created on: 2017/11/27 17:14
 */

public class App extends Application {
    private static App instance;
    public static AppComponent appComponent;
    private Set<Activity> allActs;

    public static int SCREEN_WIDTH = -1;
    public static int SCREEN_HEIGHT = -1;
    public static float DIMEN_RATE = -1.0F;
    public static int DIMEN_DPI = -1;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        MultiDex.install(this);

        getScrenSize();
    }

    public static synchronized App getInstance() {
        return instance;
    }

    public static AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule())
                    .httpModule(new HttpModule())
                    .build();
        }
        return appComponent;
    }

    public void getScrenSize() {
        WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        Display display = windowManager.getDefaultDisplay();
        display.getMetrics(dm);
        DIMEN_RATE = dm.density / 1.0F;
        DIMEN_DPI = dm.densityDpi;
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        if (SCREEN_WIDTH > SCREEN_HEIGHT) {
            int t = SCREEN_HEIGHT;
            SCREEN_HEIGHT = SCREEN_WIDTH;
            SCREEN_WIDTH = t;
        }
    }

    public void addAct(Activity activity) {
        if (allActs == null) {
            allActs = new HashSet<>();
        }
        allActs.add(activity);
    }

    public void removeAct(Activity activity) {
        if (allActs != null) {
            allActs.remove(activity);
        }
    }

    public void exitApp() {
        if (allActs != null) {
            synchronized (allActs) {
                for (Activity activity : allActs) {
                    allActs.remove(activity);
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
