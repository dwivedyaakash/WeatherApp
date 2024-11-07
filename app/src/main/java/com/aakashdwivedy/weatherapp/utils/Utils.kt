package com.aakashdwivedy.weatherapp.utils

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object Constants {
    const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
}

fun getTempInCelsius(temp: Double): String {
    return "${(temp - 273.15).toString().substringBefore(".")}°C"
}

fun getFormattedTime(timestamp: Int): String {
    val instant = Instant.ofEpochSecond(timestamp.toLong())
    val formatter = DateTimeFormatter.ofPattern("HH:mm a")
        .withZone(ZoneId.of("UTC"))
    return formatter.format(instant)
}