package com.free.data

import com.free.domain.WeatherStatus
import com.mintfintech.app.di.scope.FeatureScope
import retrofit2.http.POST
import retrofit2.http.Path
import javax.inject.Inject


interface WeatherByCoordinateService {
    @POST("weather?lat={lat}&lon={lon}&appid={key}")
    suspend fun locationByCoordinate(@Path("lat") lat: String,@Path("lon") lon: String, @Path("key") key: String): WeatherStatus
}

interface WeatherByCoordinateDataSource {
    suspend fun locationByCoordinate(lat: String,lon: String,key: String): WeatherStatus
}

@FeatureScope
class WeatherByCoordinateRepository @Inject constructor(private val apiService: WeatherByCoordinateService) :
    WeatherByCoordinateDataSource {
    override suspend fun locationByCoordinate(lat: String,lon: String,key: String): WeatherStatus{
        return apiService.locationByCoordinate(lat,lon,key)
    }

}