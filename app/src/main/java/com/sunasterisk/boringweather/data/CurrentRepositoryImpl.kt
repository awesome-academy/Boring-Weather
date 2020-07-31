package com.sunasterisk.boringweather.data

import android.os.AsyncTask
import com.sunasterisk.boringweather.base.CallbackAsyncTask
import com.sunasterisk.boringweather.base.Result
import com.sunasterisk.boringweather.data.local.model.City
import com.sunasterisk.boringweather.data.local.model.CurrentWeather

class CurrentRepositoryImpl : CurrentRepository {

    private var asyncTask: CallbackAsyncTask<*, *>? = null

    override fun getCurrentWeather(
        city: City,
        forceNetwork: Boolean,
        callback: (Result<CurrentWeather>) -> Unit
    ) {
        asyncTask = CallbackAsyncTask<City, CurrentWeather>(
            {
                Thread.sleep(2000) // TODO implement after implement data sources
                CurrentWeather()
            },
            {
                callback(it ?: Result.Error(NullPointerException()))
            }
        ).apply { executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, city) }
    }

    override fun stopTask() {
        asyncTask?.cancel(true)
    }
}
