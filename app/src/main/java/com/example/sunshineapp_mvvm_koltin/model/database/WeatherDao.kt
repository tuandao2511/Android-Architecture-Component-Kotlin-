package com.example.sunshineapp_mvvm_koltin.model.database

import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.*

@Dao
public interface WeatherDao {

    @Query("SELECT * FROM weather ")
    fun getWeatherForecasts() : LiveData<List<WeatherEntry>>

    @Query("SELECT * FROM weather WHERE date = :date")
    fun getWeatherByDate(date :Date) : LiveData<WeatherEntry>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(weatherEntries: List<WeatherEntry>)


    @Query("DELETE FROM weather")
    fun deleteAllData()
}