package com.aakashdwivedy.weatherapp.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aakashdwivedy.weatherapp.model.forecast.response.ForecastResponse

@Composable
fun WeatherForecastCard(forecastData: ForecastResponse) {
    Text(forecastData.timezone)
    Spacer(Modifier.height(16.dp))
}