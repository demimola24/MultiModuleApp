package com.free.cityfeature.di
import com.free.core.di.modules.CoreModule
import com.free.data.*
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module(includes = [ViewModelModule::class, CoreModule::class ])
class CityModule{

    @Provides
    fun provideWeatherByCityDataSource(retrofit: Retrofit): WeatherByCityDataSource {
        val service = retrofit.create(WeatherByCityService::class.java)
        return WeatherByCityRepository(service)
    }
}