package com.aakashdwivedy.weatherapp.repository

import com.aakashdwivedy.weatherapp.model.response.WeatherDataResponse
import com.aakashdwivedy.weatherapp.retrofit.RetrofitInstance
import retrofit2.Response

class WeatherApiRepository {
    private val weatherApiService = RetrofitInstance.weatherApiService

    suspend fun getWeatherData(
        latitude: Double?,
        longitude: Double?,
        city: String?,
        apiKey: String
    ): Response<WeatherDataResponse> {
        return weatherApiService.getWeatherData(latitude, longitude, city, apiKey)
    }
}