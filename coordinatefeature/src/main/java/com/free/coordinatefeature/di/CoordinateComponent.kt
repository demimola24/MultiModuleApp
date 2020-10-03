package com.free.coordinatefeature.di

import com.free.coordinatefeature.CoordinateApplication
import com.free.coordinatefeature.scope.ModuleScope
import com.free.core.di.CoreComponent
import com.free.core.di.modules.CoreModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(dependencies = [CoreComponent::class],modules = [CoordinateModule::class, ViewModelModule::class, ActivityModule::class])
interface CoordinateComponent {

    @Component.Builder
    interface Builder {
        fun coordinateModule(coordinateModule: CoordinateModule): Builder
        fun coreComponent(coreComponent: CoreComponent): Builder
        fun build(): CoordinateComponent
    }

    //fun inject(application: CoordinateApplication)
}