package com.free.coordinatefeature.di

import com.free.coordinatefeature.CoordinateActivity
import com.free.core.di.BaseActivityComponent
import com.free.core.di.CoreComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(dependencies = [CoreComponent::class],modules = [CoordinateModule::class])

interface CoordinateComponent: BaseActivityComponent<CoordinateActivity> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun coordinateActivity(activity: CoordinateActivity): Builder
        fun coreComponent(coreComponent: CoreComponent): Builder
        fun build(): CoordinateComponent
    }

    //fun inject(application: CoordinateApplication)
}