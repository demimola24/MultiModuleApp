package com.free.core.di

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.free.core.di.modules.CoreModule
import com.free.core.di.modules.callbacks.ActivityLifecycleCallback
import com.free.core.di.modules.callbacks.Injectable
import dagger.android.AndroidInjection
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection

/**
 * @author Demimola on 2/13/18.
 * Core Injector Class
 * */
class CoreInjector {

    companion object {

        fun init(app: CoreApplication) {
            DaggerCoreComponent.builder()
                .application(app)
                .appModule(CoreModule(app))
                .build()
                .also { app.appComponent = it }
                .inject(app)

            app.registerActivityLifecycleCallbacks(object : ActivityLifecycleCallback() {
                override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
                    super.onActivityCreated(activity, bundle)
                    handleActivity(activity)
                }

            })
        }

        fun handleActivity(activity: Activity) {
            if (activity is HasAndroidInjector) {
                AndroidInjection.inject(activity)
            }

            (activity as? FragmentActivity)?.supportFragmentManager?.registerFragmentLifecycleCallbacks(
                object : FragmentManager.FragmentLifecycleCallbacks() {

                    override fun onFragmentPreAttached(
                        fm: FragmentManager,
                        f: Fragment,
                        context: Context
                    ) {
                        super.onFragmentPreAttached(fm, f, context)

                        if (f is Injectable) {
                            AndroidSupportInjection.inject(f)
                        }
                    }
                }, true
            )

        }
    }

}
