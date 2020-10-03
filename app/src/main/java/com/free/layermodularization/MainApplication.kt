package com.free.layermodularization

import android.app.Application
import android.content.Context
import android.util.Log
import com.free.core.di.CoreComponent
import com.free.core.di.CoreComponentProvider
import com.free.core.di.DaggerCoreComponent
import com.free.core.di.modules.CoreModule
import com.free.layermodularization.di.MainInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainApplication : Application(), CoreComponentProvider {


    override fun provideCoreComponent(): CoreComponent {
        return  coreComponent
    }

    lateinit var coreComponent: CoreComponent
//
//    @Inject
//    lateinit var androidInjector: DispatchingAndroidInjector<Any>
//
//    override fun androidInjector(): AndroidInjector<Any> {
//        return androidInjector
//    }
//

    override fun onCreate() {
        super.onCreate()
        Log.d("CoreInjector","CoreApplication onCreate")
        coreComponent = DaggerCoreComponent
            .builder()
            .application(this)
            .coreModule(CoreModule())
            .build()
        coreComponent.inject(this)
        Log.d("CoreInjector","CoreApplication Oncreated")

    }


//    companion object {
//        val appComponent by lazy {
//            DaggerCoreComponent.create()
//        }
//    }
//
//    companion object {
//        @JvmStatic
//        fun coreComponent(context: Context) =
//            (context.applicationContext as MainApplication).coreComponent
//    }
//
//    override fun androidInjector(): AndroidInjector<Any> {
//        return androidInjector
//    }
}