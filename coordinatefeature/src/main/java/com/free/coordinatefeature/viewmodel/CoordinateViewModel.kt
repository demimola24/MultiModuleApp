package com.free.coordinatefeature.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.free.data.WeatherByCityDataSource
import com.free.data.WeatherByCoordinateDataSource
import com.free.domain.WeatherStatus
import com.mintfintech.app.event.UIEvent
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoordinateViewModel
@Inject internal constructor(private val dataSource: WeatherByCoordinateDataSource) : ViewModel(){
    private val _progress = MutableLiveData<UIEvent<Boolean>>()
    val progress: LiveData<UIEvent<Boolean>> = _progress

    private val _error = MutableLiveData<UIEvent<String>>()
    val error: LiveData<UIEvent<String>> = _error

    private val _getWeatherStatus = MutableLiveData<UIEvent<WeatherStatus>>()
    val getWeatherStatus: LiveData<UIEvent<WeatherStatus>> = _getWeatherStatus

    fun generateWeatherStatus(long: String, lat: String) {
        viewModelScope.launch {
            //show progress
            _progress.value = UIEvent(true)
            try {
                val response = dataSource.locationByCoordinate(lat,long, "3bb5393f60824e2db7fa1f112db3d3bd")
                response.let {WeatherStatus ->
                    _getWeatherStatus.value = UIEvent(WeatherStatus)
                }
            } catch (e: Exception) {
                _progress.value = UIEvent(false)
                _error.value = UIEvent("Unable to fetch weather status")
            } finally {
                //hide progress here
                _progress.value = UIEvent(false)
            }
        }
    }
}