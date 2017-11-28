package com.app.xandone.xlive.component;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.app.xandone.xlive.BuildConfig;
import com.app.xandone.xlive.app.Constants;
import com.app.xandone.xlive.utils.SystemUtils;
import com.orhanobut.logger.Logger;
import com.tencent.bugly.crashreport.CrashReport;


/**
 * author: xandone
 * created on: 2017/11/27 17:22
 */

public class IntializeService extends IntentService {
    public static final String ACTION_INIT = "appliaction_action";
    private static final boolean isDebug = BuildConfig.DEBUG;

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public IntializeService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (ACTION_INIT.equals(action)) {
                initApplication();
            }
        }
    }

    public void initApplication() {
        Logger.init(getPackageName()).hideThreadInfo();
    }

    private void initBugly() {
        Context context = getApplicationContext();
        String packageName = context.getPackageName();
        String processName = SystemUtils.getProcessName(android.os.Process.myPid());
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
        strategy.setUploadProcess(processName == null || processName.equals(packageName));
        CrashReport.initCrashReport(context, Constants.BUGLY_ID, isDebug, strategy);
    }
}
