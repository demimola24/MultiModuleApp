package com.free.core.di.modules.callbacks

import android.app.Activity
import android.app.Application
import android.os.Bundle

open class ActivityLifecycleCallback : Application.ActivityLifecycleCallbacks {

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStarted(activity: Activity) {

    }

    override fun onActivityDestroyed(activity: Activity) {

    }

    override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) {

    }

    override fun onActivityStopped(activity: Activity) {

    }

    override fun onActivityCreated(activity: Activity, bundle: Bundle?) {

    }

    override fun onActivityResumed(activity: Activity) {

    }

}