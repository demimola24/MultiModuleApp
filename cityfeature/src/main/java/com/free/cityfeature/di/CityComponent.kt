package com.free.cityfeature.di

import android.app.Application
import com.free.cityfeature.CityActivity
import com.free.cityfeature.scope.ModuleScope
import com.free.core.di.modules.CoreModule
import dagger.Component
import dagger.android.AndroidInjectionModule

@ModuleScope
@Component(modules = [CityModule::class, AndroidInjectionModule::class, CoreModule::class,ViewModelModule::class])
interface CityComponent {

    @Component.Builder
    interface Builder {
        fun coreModule(coreModule: CoreModule): Builder
        fun cityModule(cityModule: CityModule): Builder
        fun build(): CityComponent
    }
}