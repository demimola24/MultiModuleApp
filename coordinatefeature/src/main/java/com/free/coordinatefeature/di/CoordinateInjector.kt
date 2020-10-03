package com.free.coordinatefeature.di

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.free.coordinatefeature.CoordinateActivity
import com.free.core.di.modules.callbacks.Injectable
import com.free.core.di.utils.InjectUtils
import dagger.android.support.AndroidSupportInjection

class CoordinateInjector {
    companion object {

        fun init( activity: CoordinateActivity) {
            DaggerCoordinateComponent.builder()
                .coordinateActivity(activity = activity)
                .coreComponent(InjectUtils.provideCoreComponent(activity.applicationContext))
                .build()
                .inject(activity)

//            app.registerActivityLifecycleCallbacks(object : ActivityLifecycleCallback() {
//                override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
//                    super.onActivityCreated(activity, bundle)
//                    handleActivity(activity)
//                }
//
//            })
        }

        fun handleActivity(activity: Activity) {
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