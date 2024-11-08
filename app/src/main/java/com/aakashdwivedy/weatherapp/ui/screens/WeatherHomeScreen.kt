package com.aakashdwivedy.weatherapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.aakashdwivedy.weatherapp.BuildConfig
import com.aakashdwivedy.weatherapp.ui.components.LoadingScreen
import com.aakashdwivedy.weatherapp.ui.components.WeatherHomeScreenUI
import com.aakashdwivedy.weatherapp.utils.Constants
import com.aakashdwivedy.weatherapp.utils.LocationData
import com.aakashdwivedy.weatherapp.utils.LocationManager
import com.aakashdwivedy.weatherapp.viewmodel.WeatherViewModel

@Composable
fun WeatherHomeScreen() {
    val context = LocalContext.current
    val locationManager = remember { LocationManager(context) }
    var locationData by remember { mutableStateOf(LocationData()) }

    val apiKey = BuildConfig.API_KEY
    val viewModel = remember { WeatherViewModel() }
    val weatherData by viewModel.weatherData.observeAsState()
    val forecastData by viewModel.weatherForecast.observeAsState()

    // Collect location updates
    LaunchedEffect(locationManager) {
        if (locationManager.hasLocationPermission() && locationManager.isLocationEnabled()) {
            locationManager.getLocationUpdates().collect { location ->
                locationData = LocationData(
                    latitude = location.latitude,
                    longitude = location.longitude,
                    isLocationEnabled = true
                )
            }
        }
    }

    // Fetch weather data api call by current location (latitude and longitude)
    LaunchedEffect(locationData) {
        if (locationData.latitude != 0.0 && locationData.longitude != 0.0) {
            viewModel.fetchWeatherData(locationData.latitude, locationData.longitude, null, apiKey)
        }
    }

    if (weatherData != null && forecastData != null) {
        WeatherHomeScreenUI(weatherData!!, forecastData!!) { query ->
            // Fetch weather data api call by city name
            viewModel.fetchWeatherData(null, null, query, apiKey)
        }
    } else {
        LoadingScreen()
    }
}