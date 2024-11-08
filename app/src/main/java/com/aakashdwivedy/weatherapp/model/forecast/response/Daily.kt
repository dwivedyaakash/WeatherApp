package com.aakashdwivedy.weatherapp.model.forecast.response

data class Daily(
    val temperature_2m_max: List<Double>,
    val temperature_2m_min: List<Double>,
    val time: List<String>
)