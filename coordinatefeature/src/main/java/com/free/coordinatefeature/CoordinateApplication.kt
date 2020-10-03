package com.free.coordinatefeature

import android.app.Application
import android.content.Context
import android.util.Log
import com.free.coordinatefeature.di.CoordinateInjector
import com.free.core.di.CoreComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class CoordinateApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

  //  lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        Log.d("CoordinateApplication","CoordinateApplication onCreate")
        //CoordinateInjector.init(this, CoreApplication.coreComponent(this))
    }


//    companion object {
//        val appComponent by lazy {
//            DaggerCoreComponent.create()
//        }
//    }

//    companion object {
//        @JvmStatic
//        fun coreComponent(context: Context) =
//            (context.applicationContext as CoreApplication).coreComponent
//    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}