package com.free.coordinatefeature.di

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.free.coordinatefeature.CoordinateApplication
import com.free.core.di.CoreComponent
import com.free.core.di.modules.CoreModule
import com.free.core.di.modules.callbacks.ActivityLifecycleCallback
import com.free.core.di.modules.callbacks.Injectable
import dagger.android.AndroidInjection
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection

class CoordinateInjector {
    companion object {

//        fun init(app: CoordinateApplication, coreComponent: CoreComponent) {
//            DaggerCoordinateComponent.builder()
//                .coordinateModule(CoordinateModule())
//                .coreComponent(coreComponent)
//                .build()
//                //.inject(app)
//
//            app.registerActivityLifecycleCallbacks(object : ActivityLifecycleCallback() {
//                override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
//                    super.onActivityCreated(activity, bundle)
//                    handleActivity(activity)
//                }
//
//            })
//        }

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