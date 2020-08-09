package com.free.layermodularization.di

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.free.core.di.CoreApplication
import com.free.core.di.modules.CoreModule
import com.free.core.di.modules.callbacks.Injectable
import dagger.android.AndroidInjection
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection

class MainInjector {
    companion object {

        fun init(app: CoreApplication) {
            DaggerMainComponent.builder()
                .application(app)
                .build()
                .inject(app)
        }

//            app.registerActivityLifecycleCallbacks(object : ActivityLifecycleCallback() {
//                override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
//                    super.onActivityCreated(activity, bundle)
//                    handleActivity(activity)
//                }
//
//            })
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
