package com.free.cityfeature.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.free.cityfeature.viewmodel.CityViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CityViewModel::class)
    abstract fun bindCityViewModel(viewModel: CityViewModel): ViewModel

    /**
     * Provides the ViewModelFactory
     * */
    @Binds
    abstract fun provideViewModelFactory(factory: MintViewModelFactory): ViewModelProvider.Factory


}