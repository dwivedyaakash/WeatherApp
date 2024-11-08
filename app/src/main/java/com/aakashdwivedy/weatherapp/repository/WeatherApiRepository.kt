package com.aakashdwivedy.weatherapp.repository

import com.aakashdwivedy.weatherapp.model.forecast.response.ForecastResponse
import com.aakashdwivedy.weatherapp.model.response.WeatherDataResponse
import com.aakashdwivedy.weatherapp.retrofit.RetrofitInstance
import com.aakashdwivedy.weatherapp.retrofit.WeatherForecastRetrofitInstance
import retrofit2.Response

class WeatherApiRepository {
    private val weatherApiService = RetrofitInstance.weatherApiService
    private val weatherForecastApiService = WeatherForecastRetrofitInstance.weatherForecastApiService

    suspend fun getWeatherData(
        latitude: Double?,
        longitude: Double?,
        city: String?,
        apiKey: String
    ): Response<WeatherDataResponse> {
        return weatherApiService.getWeatherData(latitude, longitude, city, apiKey)
    }

    suspend fun getWeatherForecast(
        latitude: Double,
        longitude: Double,
        daily: String,
        timezone: String
    ): Response<ForecastResponse> {
        return weatherForecastApiService.getWeatherForecast(latitude, longitude, daily, timezone)
    }
}