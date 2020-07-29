package com.sunasterisk.boringweather.ui.current

import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sunasterisk.boringweather.R
import com.sunasterisk.boringweather.data.local.model.SummaryWeather
import kotlinx.android.synthetic.main.item_summary_weather.view.*

class SummaryWeatherAdapter(
    private val tempUnit: String
) : ListAdapter<SummaryWeather, SummaryWeatherAdapter.SummaryWeatherVH>(
    SummaryWeather.diffUtil
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SummaryWeatherVH {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_summary_weather, parent, false)
        return SummaryWeatherVH(view, tempUnit)
    }

    override fun onBindViewHolder(holder: SummaryWeatherVH, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class SummaryWeatherVH(
        view: View,
        private val tempUnit: String
    ) : RecyclerView.ViewHolder(view) {

        fun bind(item: SummaryWeather) {
            with(itemView) {
                textTemperature.text = "${item.temperature} $tempUnit"
                // TODO implement parse Long to date time String
                textDateTime.text = DateUtils.formatElapsedTime(item.dt / 1000)
            }
        }
    }
}