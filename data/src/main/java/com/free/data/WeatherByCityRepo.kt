package com.free.data

import com.free.core.di.scope.ModuleScope
import com.free.domain.WeatherStatus
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject


interface WeatherByCityService {
    @POST("weather")
    suspend fun locationByCity(@Query("id") cityId: String, @Query("appid") key: String): WeatherStatus
}

interface WeatherByCityDataSource {
    suspend fun locationByCity(cityId: String,key: String): WeatherStatus
}

@ModuleScope
class WeatherByCityRepository @Inject constructor(private val apiService: WeatherByCityService) :
    WeatherByCityDataSource {
    override suspend fun locationByCity(cityId: String,key: String): WeatherStatus{
        return apiService.locationByCity(cityId,key)
    }

}