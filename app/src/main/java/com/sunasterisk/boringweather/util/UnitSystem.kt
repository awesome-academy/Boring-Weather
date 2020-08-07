package com.sunasterisk.boringweather.util

import android.content.res.Resources
import com.sunasterisk.boringweather.R
import com.sunasterisk.boringweather.util.Constants.KILOMETER_TO_MILES
import com.sunasterisk.boringweather.util.Constants.KILOPASCAL_TO_HECTOPASCAL
import com.sunasterisk.boringweather.util.Constants.METER_TO_KILOMETER
import com.sunasterisk.boringweather.util.Constants.MULTIPLE_KELVIN_TO_CELSIUS
import com.sunasterisk.boringweather.util.Constants.MULTIPLE_KELVIN_TO_FAHRENHEIT
import com.sunasterisk.boringweather.util.Constants.OFFSET_KELVIN_TO_CELSIUS
import com.sunasterisk.boringweather.util.Constants.OFFSET_KELVIN_TO_FAHRENHEIT

enum class UnitSystem {
    METRIC, IMPERIAL, INTERNATIONAL;

    fun formatTemperature(temperature: Float, resources: Resources) =
        when (this) {
            METRIC -> R.string.format_temperature_metric to
                (temperature * MULTIPLE_KELVIN_TO_CELSIUS + OFFSET_KELVIN_TO_CELSIUS)
            IMPERIAL -> R.string.format_temperature_imperial to
                (temperature * MULTIPLE_KELVIN_TO_FAHRENHEIT + OFFSET_KELVIN_TO_FAHRENHEIT)
            INTERNATIONAL -> R.string.format_temperature_international to temperature
        }.let { (stringRes, unitTemperature) -> resources.getString(stringRes, unitTemperature) }

    fun formatDistance(visibility: Int?, resources: Resources) =
        visibility?.div(METER_TO_KILOMETER)
            ?.takeIf { it > 0f }
            ?.let {
                val (format, number) = when (this) {
                    METRIC -> R.string.format_visibility_metric to it
                    IMPERIAL -> R.string.format_visibility_imperial to it / KILOMETER_TO_MILES
                    INTERNATIONAL -> R.string.format_visibility_international to it
                }
                resources.getString(format, number)
            } ?: resources.getString(R.string.title_holder_float_number)

    fun formatSpeed(speed: Float, resources: Resources) = when (this) {
        METRIC -> R.string.format_speed_metric to speed
        IMPERIAL -> R.string.format_speed_imperial to speed * Constants.METER_PER_SECOND_TO_MILES_PER_HOUR
        INTERNATIONAL -> R.string.format_speed_international to speed
    }.let { (stringRes, unitSpeed) -> resources.getString(stringRes, unitSpeed) }

    fun formatPressure(pressure: Int, resources: Resources) =
        resources.getString(
            R.string.format_pressure,
            pressure.toFloat() / KILOPASCAL_TO_HECTOPASCAL
        )
}
