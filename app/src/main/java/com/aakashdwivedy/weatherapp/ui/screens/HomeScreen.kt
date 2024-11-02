package com.aakashdwivedy.weatherapp.ui.screens

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import com.aakashdwivedy.weatherapp.ui.components.PermissionDeniedScreen
import com.aakashdwivedy.weatherapp.ui.components.WeatherHomeScreen

@Composable
fun HomeScreen(navController: NavHostController) {
    var permissionGranted by remember { mutableStateOf(false) }

    val locationPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) { permissionGranted = true }
    }

    // Request permission on launch
    LaunchedEffect(Unit) {
        locationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }

    if (permissionGranted) {
        WeatherHomeScreen()
    } else {
        PermissionDeniedScreen()
    }
}