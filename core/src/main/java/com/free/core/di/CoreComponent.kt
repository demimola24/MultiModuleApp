package com.free.core.di

import android.app.Activity
import android.app.Application
import com.free.core.di.modules.CoreModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton
/**
 * @author Demimola on 2/13/18.
 * Core Component Class
 * */

@Singleton
@Component(modules = [CoreModule::class])
interface CoreComponent {

    interface Builder {
        fun coreModule(coreModule: CoreModule): Builder
        fun build(): CoreComponent
    }
    fun inject(activity: Activity)

}