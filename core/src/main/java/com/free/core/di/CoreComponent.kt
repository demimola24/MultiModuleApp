package com.free.core.di

import android.app.Activity
import android.app.Application
import com.free.core.di.modules.CoreModule
import com.free.core.di.scope.ModuleScope
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

@Component(modules = [CoreModule::class])
interface CoreComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun coreModule(coreModule: CoreModule): Builder
        fun build(): CoreComponent
    }

    fun inject(application: Application)

    //fun inject(activity: Activity)
}