package com.aakashdwivedy.weatherapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aakashdwivedy.weatherapp.model.forecast.response.ForecastResponse
import com.aakashdwivedy.weatherapp.model.response.WeatherDataResponse
import com.aakashdwivedy.weatherapp.repository.WeatherApiRepository
import com.aakashdwivedy.weatherapp.utils.Constants
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val repository = WeatherApiRepository()

    private val _weatherData = MutableLiveData<WeatherDataResponse>()
    val weatherData: LiveData<WeatherDataResponse> get() = _weatherData
    private val _weatherForecast = MutableLiveData<ForecastResponse>()
    val weatherForecast: LiveData<ForecastResponse> get() = _weatherForecast

    fun fetchWeatherData(latitude: Double?, longitude: Double?, city: String?, apiKey: String) {
        viewModelScope.launch {
            try {
                val response = repository.getWeatherData(latitude, longitude, city, apiKey)
                if (response.isSuccessful) {
                    _weatherData.value = response.body()
                    if (_weatherData.value?.coord?.lat != null && _weatherData.value?.coord?.lon != null) {
                        fetchWeatherForecast(
                            _weatherData.value?.coord?.lat!!,
                            _weatherData.value?.coord?.lon!!,
                            Constants.DAILY,
                            "Asia/Kolkata"
                        )
                    }
                } else {
                    Log.e("API Error", "Error fetching weather data: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("Network Error", e.toString())
            }
        }
    }

    private fun fetchWeatherForecast(latitude: Double, longitude: Double, daily: String, timezone: String) {
        viewModelScope.launch {
            try {
                val response = repository.getWeatherForecast(latitude, longitude, daily, timezone)
                if (response.isSuccessful) {
                    _weatherForecast.value = response.body()
                } else {
                    Log.e("API Error", "Error fetching weather forecast: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("Network Error", e.toString())
            }
        }
    }
}