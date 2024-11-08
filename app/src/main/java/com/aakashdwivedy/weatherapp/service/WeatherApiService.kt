package com.aakashdwivedy.weatherapp.service

import com.aakashdwivedy.weatherapp.model.forecast.response.ForecastResponse
import com.aakashdwivedy.weatherapp.model.response.WeatherDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("weather")
    suspend fun getWeatherData(
        @Query("lat") latitude: Double? = null,
        @Query("lon") longitude: Double? = null,
        @Query("q") city: String? = null,
        @Query("appid") apiKey: String
    ): Response<WeatherDataResponse>
}

interface WeatherForecastApiService{
    @GET("forecast")
    suspend fun getWeatherForecast(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("daily") daily: String,
        @Query("timezone") timezone: String
    ): Response<ForecastResponse>
}