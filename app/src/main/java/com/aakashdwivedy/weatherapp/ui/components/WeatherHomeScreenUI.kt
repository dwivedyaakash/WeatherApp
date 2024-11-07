package com.aakashdwivedy.weatherapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aakashdwivedy.weatherapp.model.response.WeatherDataResponse
import com.aakashdwivedy.weatherapp.ui.theme.BgColor
import com.aakashdwivedy.weatherapp.utils.getTempInCelsius

@Composable
fun WeatherHomeScreenUI(weatherData: WeatherDataResponse) {
    val scrollState = rememberScrollState()

    Column(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color.White, BgColor)
                )
            )
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .verticalScroll(scrollState)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = weatherData.name,
                fontSize = 24.sp
            )
            Text(
                text = getTempInCelsius(weatherData.main.temp),
                fontSize = 80.sp
            )
            Text(
                text = weatherData.weather.first().main,
                fontSize = 20.sp
            )
        }
        WeatherDetailsCard(weatherData)
    }
}