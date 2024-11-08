package com.aakashdwivedy.weatherapp.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aakashdwivedy.weatherapp.utils.Constants

@Composable
fun WeatherForecastCard() {
    val forecastData = Constants.FORECAST_DATA

    if (forecastData != null) {
        Text(forecastData.timezone)
    }
    Spacer(Modifier.height(16.dp))
}