package com.aakashdwivedy.weatherapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aakashdwivedy.weatherapp.model.response.WeatherDataResponse
import com.aakashdwivedy.weatherapp.repository.WeatherApiRepository
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val repository = WeatherApiRepository()

    private val _weatherData = MutableLiveData<WeatherDataResponse>()
    val weatherData: LiveData<WeatherDataResponse> get() = _weatherData

    fun fetchWeatherData(latitude: Double, longitude: Double, apiKey: String) {
        viewModelScope.launch {
            try {
                val response = repository.getWeatherData(latitude, longitude, apiKey)
                if (response.isSuccessful) {
                    _weatherData.value = response.body()
                } else {
                    Log.e("API Error", "Error fetching weather data: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("Network Error", e.toString())
            }
        }
    }
}