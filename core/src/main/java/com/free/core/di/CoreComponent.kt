package com.free.core.di

import android.app.Activity
import android.app.Application
import com.free.core.di.modules.CoreModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton
/**
 * @author Demimola on 2/13/18.
 * Core Compnent Class
 * */
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,CoreModule::class]
)
interface CoreComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun appModule(appModule: CoreModule): Builder
        fun build(): CoreComponent
    }

     fun inject(application: CoreApplication)

     fun inject(activity: Activity)

}