package com.example.sunshineapp_mvvm_koltin.model.database

import android.content.Context
import androidx.room.*

@Database(entities = [WeatherEntry::class],version = 1)
@TypeConverters(DateConverter::class)
abstract class SunshineDatabase : RoomDatabase() {

    abstract fun weatherDao() : WeatherDao

    companion object {
        private var INSTANCE : SunshineDatabase? = null

        fun getInstace(context: Context) : SunshineDatabase? {
            if (INSTANCE == null) {
                synchronized(SunshineDatabase::class.java){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        SunshineDatabase::class.java,"weather.db")
                        .build()
                }
            }

            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

}