package com.aakashdwivedy.weatherapp.utils

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

fun getTempInCelsius(temp: Double): String {
    return "${(temp - 273.15).toString().substringBefore(".")}°C"
}

fun getFormattedTime(timestamp: Int): String {
    val instant = Instant.ofEpochSecond(timestamp.toLong())
    val formatter = DateTimeFormatter.ofPattern("HH:mm a")
        .withZone(ZoneId.systemDefault())
    return formatter.format(instant)
}

fun getFormattedDate(dateString: String): String {
    val date = LocalDate.parse(dateString)
    val today = LocalDate.now()
    val tomorrow = today.plusDays(1)

    return when {
        date.isEqual(today) -> "Today"
        date.isEqual(tomorrow) -> "Tomorrow"
        else -> date.dayOfWeek.getDisplayName(java.time.format.TextStyle.FULL, Locale.getDefault())
    }
}