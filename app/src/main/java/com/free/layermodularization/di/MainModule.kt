package com.free.layermodularization.di

import android.app.Activity
import android.content.Context
import com.free.layermodularization.MainActivity
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
class MainModule {

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

//    @Binds
//    abstract fun homeActivityAsActivity(activity: MainActivity): Activity
//
//    @Binds
//    abstract fun context(activity: Activity): Context
}