package com.free.cityfeature.di

import android.app.Activity
import android.content.Context
import com.free.cityfeature.CityActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Suppress("unused")
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeCityActivity(): CityActivity
//    @Binds
//    abstract fun homeActivityAsActivity(activity: CityActivity): Activity
//
//    @Binds
//    abstract fun context(activity: Activity): Context
}