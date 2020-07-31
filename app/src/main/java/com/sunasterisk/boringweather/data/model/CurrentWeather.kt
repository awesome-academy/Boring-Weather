package com.sunasterisk.boringweather.data.model

data class CurrentWeather(
    val currentWeather: HourlyWeather = HourlyWeather(),
    val dailyWeather: DailyWeather = DailyWeather(),
    val todaySummaryWeathers: List<SummaryWeather> = emptyList(),
    val forecastSummaryWeather: List<SummaryWeather> = emptyList()
)