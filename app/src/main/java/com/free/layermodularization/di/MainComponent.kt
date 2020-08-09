package com.free.layermodularization.di

import android.app.Activity
import android.app.Application
import com.free.core.di.CoreApplication
import com.mintfintech.app.di.scope.AppScope
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@AppScope
@Component(
    modules = [AndroidInjectionModule::class])
interface MainComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): MainComponent
    }

    fun inject(application: CoreApplication)
}