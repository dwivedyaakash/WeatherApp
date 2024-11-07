package com.aakashdwivedy.weatherapp.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.aakashdwivedy.weatherapp.BuildConfig
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

    // Fetch weather data api call
    LaunchedEffect(locationData) {
        if (locationData.latitude != 0.0 && locationData.longitude != 0.0) {
            viewModel.fetchWeatherData(locationData.latitude, locationData.longitude, apiKey)
        }
    }

    if (weatherData != null) {
        Text(text = "${weatherData?.name}")
    }
}