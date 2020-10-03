package com.free.cityfeature.di

import android.app.Activity
import com.free.cityfeature.CityActivity
import com.free.core.di.BaseActivityComponent
import com.free.core.di.CoreComponent
import com.free.layermodularization.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(dependencies = [CoreComponent::class], modules = [CityModule::class])

interface CityComponent: BaseActivityComponent<CityActivity> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun cityActivity(activity: CityActivity): Builder
        fun coreComponent(coreComponent: CoreComponent): Builder
        fun build(): CityComponent
    }
    //fun inject(activity: Activity)
}