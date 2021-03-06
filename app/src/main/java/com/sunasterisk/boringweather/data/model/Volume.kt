package com.sunasterisk.boringweather.data.model

import com.sunasterisk.boringweather.util.getOrNull
import org.json.JSONObject

/**
 * @param lastHour - Rain/Snow volume for the last one hour, mm
 * @param last3Hours - Rain/Snow volume for the last three hours, mm
 */
data class Volume(val lastHour: Float? = null, val last3Hours: Float? = null) {

    constructor(jsonObject: JSONObject) : this(
        jsonObject.getOrNull(LAST_HOUR),
        jsonObject.getOrNull(LAST_3HOURS)
    )

    companion object {
        const val LAST_HOUR = "1h"
        const val LAST_3HOURS = "3h"
    }
}
