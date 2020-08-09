package com.free.coordinatefeature.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.free.coordinatefeature.viewmodel.CoordinateViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CoordinateViewModel::class)
    abstract fun bindCoordinateViewModel(viewModel: CoordinateViewModel): ViewModel

    /**
     * Provides the ViewModelFactory
     * */
    @Binds
    abstract fun provideViewModelFactory(factory: MintViewModelFactory): ViewModelProvider.Factory


}