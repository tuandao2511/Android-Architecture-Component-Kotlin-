package com.example.sunshineapp_mvvm_koltin.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.sunshineapp_mvvm_koltin.model.SunshineRepository
import com.example.sunshineapp_mvvm_koltin.model.database.WeatherEntry
import java.util.*

class DetailActivityViewModel(val repository: SunshineRepository?, val date: Date): ViewModel() {

    private var mWeather : LiveData<WeatherEntry>?

    init {
        mWeather = repository?.getWeatherByDate(date)
    }


    fun getWeather(): LiveData<WeatherEntry>? {
        return mWeather
    }
}