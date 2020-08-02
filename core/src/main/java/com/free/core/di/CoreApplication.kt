package com.free.core.di

import android.app.Application
import android.content.Context
import com.free.core.di.CoreComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class CoreApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        //init injector
        CoreInjector.init(this)
    }


//    companion object {
//        val appComponent by lazy {
//            DaggerCoreComponent.create()
//        }
//    }

    companion object {
        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as CoreApplication).coreComponent
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}