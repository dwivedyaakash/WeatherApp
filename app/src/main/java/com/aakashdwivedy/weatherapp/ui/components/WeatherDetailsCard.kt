package com.aakashdwivedy.weatherapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aakashdwivedy.weatherapp.R
import com.aakashdwivedy.weatherapp.model.response.WeatherDataResponse
import com.aakashdwivedy.weatherapp.utils.getFormattedTime
import com.aakashdwivedy.weatherapp.utils.getTempInCelsius

@Composable
fun WeatherDetailsCard(weatherData: WeatherDataResponse) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier
                .background(Color.White, shape = RoundedCornerShape(16.dp))
                .padding(16.dp),
            text = buildAnnotatedString {
                append("Feels like ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.SemiBold)) {
                    append(getTempInCelsius(weatherData.main.feels_like))
                }
            },
            fontSize = 16.sp
        )
    }
    Spacer(Modifier.height(32.dp))
    RectangularWeatherCard(
        getTempInCelsius(weatherData.main.temp_min),
        getTempInCelsius(weatherData.main.temp_max),
        R.drawable.arrow_down,
        R.drawable.arrow_up,
        true
    )
    SquareWeatherCards(
        "Humidity",
        "Wind speed",
        weatherData.main.humidity.toString() + "%",
        weatherData.wind.speed.toString() + "m/s",
        R.drawable.humidity,
        R.drawable.wind
    )
    SquareWeatherCards(
        "Visibility",
        "Pressure",
        (weatherData.visibility / 1000).toString() + "km",
        weatherData.main.pressure.toString() + "hPa",
        R.drawable.visibility,
        R.drawable.barometer
    )
    SquareWeatherCards(
        "Ground level\npressure",
        "Sea level\npressure",
        weatherData.main.grnd_level.toString() + "hPa",
        weatherData.main.sea_level.toString() + "hPa",
        R.drawable.measurement,
        R.drawable.tide
    )
    RectangularWeatherCard(
        getFormattedTime(weatherData.sys.sunrise),
        getFormattedTime(weatherData.sys.sunset),
        R.drawable.sunrise,
        R.drawable.sunset,
        false
    )
}