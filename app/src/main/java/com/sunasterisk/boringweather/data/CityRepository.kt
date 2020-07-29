package com.sunasterisk.boringweather.data

import com.sunasterisk.boringweather.base.Result
import com.sunasterisk.boringweather.data.local.model.City

interface CityRepository {
    fun getCityById(cityId: Int, callback: (Result<City>) -> Unit)

    fun findCityByName(cityName: String, callback: (Result<List<City>>) -> Unit)

    fun findCityById(cityId: Int, callback: (Result<List<City>>) -> Unit)

    fun insertCity(vararg city: City, callback: (Result<Int>) -> Unit)
}
