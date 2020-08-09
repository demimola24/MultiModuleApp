package com.free.coordinatefeature.di
import com.free.data.*
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit


@Module
class CoordinateModule{

    @Provides
    fun provideWeatherByCoordinateDataSource(retrofit: Retrofit): WeatherByCoordinateDataSource {
        val service = retrofit.create(WeatherByCoordinateService::class.java)
        return WeatherByCoordinateRepository(service)
    }
}