package com.free.data

import com.free.domain.WeatherStatus
import com.mintfintech.app.di.scope.FeatureScope
import retrofit2.http.POST
import retrofit2.http.Path
import javax.inject.Inject


interface WeatherByCityService {
    @POST("weather?id={cityId}&appid={key}")
    suspend fun locationByCity(@Path("cityId") cityId: String, @Path("key") key: String): WeatherStatus
}

interface WeatherByCityDataSource {
    suspend fun locationByCity(cityId: String,key: String): WeatherStatus
}

@FeatureScope
class WeatherByCityRepository @Inject constructor(private val apiService: WeatherByCityService) :
    WeatherByCityDataSource {
    override suspend fun locationByCity(cityId: String,key: String): WeatherStatus{
        return apiService.locationByCity(cityId,key)
    }

}