package com.aakashdwivedy.weatherapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aakashdwivedy.weatherapp.R
import com.aakashdwivedy.weatherapp.model.forecast.response.ForecastResponse
import com.aakashdwivedy.weatherapp.model.response.WeatherDataResponse
import com.aakashdwivedy.weatherapp.ui.theme.BgColor
import com.aakashdwivedy.weatherapp.utils.getTempInCelsius

@Composable
fun WeatherHomeScreenUI(
    weatherData: WeatherDataResponse,
    forecastData: ForecastResponse,
    makeApiCall: (String) -> Unit
) {
    val scrollState = rememberScrollState()
    var showSearchBar by remember { mutableStateOf(false) }

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
        if (showSearchBar) {
            SearchBar(
                dismiss = { showSearchBar = false },
                submit = { query ->
                    showSearchBar = false
                    makeApiCall(query)
                }
            )
        }
        Column(
            Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .padding(start = 30.dp),
                    text = weatherData.name,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
                Image(
                    modifier = Modifier
                        .size(30.dp)
                        .clickable(
                            onClick = { showSearchBar = !showSearchBar },
                            indication = null,
                            interactionSource = null
                        ),
                    painter = painterResource(R.drawable.search),
                    contentDescription = "search"
                )
            }
            Text(
                text = getTempInCelsius(weatherData.main.temp),
                fontSize = 80.sp
            )
            Text(
                text = weatherData.weather.first().main,
                fontSize = 20.sp
            )
        }
        WeatherDetailsCard(weatherData, forecastData)
    }
}