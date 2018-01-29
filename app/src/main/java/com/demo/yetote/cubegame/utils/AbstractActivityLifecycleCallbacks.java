package com.demo.yetote.cubegame.utils;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * com.demo.yetote.cubegame.utils
 * 用于监听Activity的生命周期
 *
 * @author Swg
 * @date 2018/1/26 9:54
 */
public abstract class AbstractActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }
}
