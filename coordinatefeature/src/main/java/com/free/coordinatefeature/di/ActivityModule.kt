package com.free.coordinatefeature.di

import com.free.coordinatefeature.CoordinateActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Suppress("unused")
@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    abstract fun contributeCityActivity(): CoordinateActivity
}