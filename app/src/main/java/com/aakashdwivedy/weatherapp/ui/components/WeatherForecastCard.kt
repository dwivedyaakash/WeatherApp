package com.aakashdwivedy.weatherapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aakashdwivedy.weatherapp.R
import com.aakashdwivedy.weatherapp.model.forecast.response.ForecastResponse
import com.aakashdwivedy.weatherapp.utils.getFormattedDate

@Composable
fun WeatherForecastCard(forecastData: ForecastResponse) {
    Column(
        Modifier
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            modifier = Modifier.padding(top = 8.dp, start = 8.dp, bottom = 8.dp),
            text = "${forecastData.daily.time.size} days forecast",
            fontSize = 18.sp
        )
        Column(Modifier.fillMaxWidth()) {
            forecastData.daily.time.indices.toList().forEach {
                WeatherForecastCardItem(
                    forecastData.daily.time[it],
                    forecastData.daily.temperature_2m_max[it],
                    forecastData.daily.temperature_2m_min[it],
                    forecastData.daily_units.temperature_2m_max
                )
            }
        }
    }
    Spacer(Modifier.height(16.dp))
}

@Composable
fun WeatherForecastCardItem(
    date: String, tempMax: Double,
    tempMin: Double, unit: String
) {
    val formattedDate = getFormattedDate(date)
    Row(
        Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color(0xFFC6E7FF), shape = RoundedCornerShape(8.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(0.4f),
            text = formattedDate,
            fontWeight = FontWeight.SemiBold
        )
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "$tempMin$unit")
            Image(
                modifier = Modifier.size(30.dp),
                painter = painterResource(R.drawable.sunrise),
                contentDescription = "image"
            )
            Text(text = "$tempMax$unit")
        }
    }
}