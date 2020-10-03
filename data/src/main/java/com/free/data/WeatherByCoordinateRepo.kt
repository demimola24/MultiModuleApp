package com.free.data

import com.free.core.di.scope.ModuleScope
import com.free.domain.WeatherStatus
import retrofit2.http.POST
import retrofit2.http.Query
import javax.inject.Inject


interface WeatherByCoordinateService {
    @POST("weather")
    suspend fun locationByCoordinate(@Query("lat") lat: String,@Query("lon") lon: String, @Query("appid") key: String): WeatherStatus
}

interface WeatherByCoordinateDataSource {
    suspend fun locationByCoordinate(lat: String,lon: String,key: String): WeatherStatus
}

@ModuleScope
class WeatherByCoordinateRepository @Inject constructor(private val apiService: WeatherByCoordinateService) :
    WeatherByCoordinateDataSource {
    override suspend fun locationByCoordinate(lat: String,lon: String,key: String): WeatherStatus{
        return apiService.locationByCoordinate(lat,lon,key)
    }

}