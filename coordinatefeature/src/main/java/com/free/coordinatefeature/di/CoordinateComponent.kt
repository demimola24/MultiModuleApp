package com.free.coordinatefeature.di

import com.free.coordinatefeature.scope.ModuleScope
import com.free.core.di.modules.CoreModule
import dagger.Component
import dagger.android.AndroidInjectionModule

@ModuleScope
@Component(modules = [CoordinateModule::class, AndroidInjectionModule::class, CoreModule::class])
interface CoordinateComponent {

    @Component.Builder
    interface Builder {
        fun coreModule(coreModule: CoreModule): Builder
        fun coordinateModule(coordinateModule: CoordinateModule): Builder
        fun build(): CoordinateComponent
    }
}