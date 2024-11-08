package com.aakashdwivedy.weatherapp.utils

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun getTempInCelsius(temp: Double): String {
    return "${(temp - 273.15).toString().substringBefore(".")}°C"
}

fun getFormattedTime(timestamp: Int): String {
    val instant = Instant.ofEpochSecond(timestamp.toLong())
    val formatter = DateTimeFormatter.ofPattern("HH:mm a")
        .withZone(ZoneId.systemDefault())
    return formatter.format(instant)
}