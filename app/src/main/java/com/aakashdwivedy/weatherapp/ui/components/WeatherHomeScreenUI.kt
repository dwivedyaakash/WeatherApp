package com.aakashdwivedy.weatherapp.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.aakashdwivedy.weatherapp.model.response.WeatherDataResponse

@Composable
fun WeatherHomeScreenUI(weatherData: WeatherDataResponse) {
    Text(text = weatherData.name)
}