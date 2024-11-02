package com.aakashdwivedy.weatherapp.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.aakashdwivedy.weatherapp.utils.LocationData
import com.aakashdwivedy.weatherapp.utils.LocationManager

@Composable
fun WeatherHomeScreen() {
    val context = LocalContext.current
    val locationManager = remember { LocationManager(context) }
    var locationData by remember { mutableStateOf(LocationData()) }

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

    Text(text = "${locationData.latitude}, ${locationData.longitude}")
}