package com.free.cityfeature.di
import com.free.data.*
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class CityModule{

    @Provides
    fun provideWeatherByCityDataSource(retrofit: Retrofit): WeatherByCityDataSource {
        val service = retrofit.create(WeatherByCityService::class.java)
        return WeatherByCityRepository(service)
    }

    @Provides
    fun provideWeatherByCoordinateDataSource(retrofit: Retrofit): WeatherByCoordinateDataSource {
        val service = retrofit.create(WeatherByCoordinateService::class.java)
        return WeatherByCoordinateRepository(service)
    }
}