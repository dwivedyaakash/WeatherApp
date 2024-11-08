package com.aakashdwivedy.weatherapp.retrofit

import com.aakashdwivedy.weatherapp.service.WeatherApiService
import com.aakashdwivedy.weatherapp.service.WeatherForecastApiService
import com.aakashdwivedy.weatherapp.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val weatherApiService: WeatherApiService by lazy {
        retrofit.create(WeatherApiService::class.java)
    }
}

object WeatherForecastRetrofitInstance {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.FORECAST_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val weatherForecastApiService: WeatherForecastApiService by lazy {
        retrofit.create(WeatherForecastApiService::class.java)
    }
}