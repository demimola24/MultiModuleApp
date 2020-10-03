package com.free.layermodularization.di

import android.app.Activity
import android.app.Application
import com.free.core.di.BaseActivityComponent
import com.free.core.di.CoreComponent
import com.free.core.di.modules.CoreModule
import com.free.core.di.scope.ModuleScope
import com.free.layermodularization.MainActivity
import com.mintfintech.app.di.scope.AppScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * @author Demimola on 2/13/18.
 * Core Component Class
 * */

//@ModuleScope
//@Component(modules = [CoreModule::class])
//interface CoreComponent {
//
//    interface Builder {
//        fun coreModule(coreModule: CoreModule): Builder
//        fun build(): CoreComponent
//    }
//    fun inject(activity: Activity)
//
//}

@Singleton
@Component(
    dependencies = [CoreComponent::class], modules = [MainModule::class])
interface MainComponent : BaseActivityComponent<MainActivity> {

    @Component.Builder
    interface Builder {
        @BindsInstance fun mainActivity(activity: MainActivity): Builder
        fun coreComponent(module: CoreComponent): Builder
        fun build(): MainComponent

    }


    //fun inject(activity: Activity)
}