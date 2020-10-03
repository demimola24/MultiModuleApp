package com.free.coordinatefeature.di
import com.free.core.di.modules.CoreModule
import com.free.data.*
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module(includes = [ViewModelModule::class, CoreModule::class ])
class CoordinateModule{

    @Provides
    fun provideWeatherByCoordinateDataSource(retrofit: Retrofit): WeatherByCoordinateDataSource {
        val service = retrofit.create(WeatherByCoordinateService::class.java)
        return WeatherByCoordinateRepository(service)
    }
}