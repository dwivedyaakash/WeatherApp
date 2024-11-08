package com.aakashdwivedy.weatherapp.utils

import com.aakashdwivedy.weatherapp.model.forecast.response.ForecastResponse

object Constants {
    const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    const val FORECAST_BASE_URL = "https://api.open-meteo.com/v1/"
    var FORECAST_DATA: ForecastResponse? = null
}