package com.example.sunshineapp_mvvm_koltin.ui.list

import android.util.Log
import androidx.lifecycle.*
import com.example.sunshineapp_mvvm_koltin.model.SunshineRepository
import com.example.sunshineapp_mvvm_koltin.model.database.WeatherEntry

class MainActivityViewModel(val repository: SunshineRepository?): ViewModel() {


    private var mLocationForecast = MutableLiveData<String>()
    private var mForecast: LiveData<List<WeatherEntry>>?

    init {
        mForecast = repository?.getWeatherForecasts()
    }


    fun getListWeatherEntry() : LiveData<List<WeatherEntry>>? {
        return mForecast
    }


    fun setLocationForecast(location: String) {
        Log.d(".MainActivityViewModel", "location " +location)
        mLocationForecast.value = location
        repository?.requestWeatherForecasts(location)
    }

    fun getLocationForecast() : MutableLiveData<String> {
        return mLocationForecast
    }
}