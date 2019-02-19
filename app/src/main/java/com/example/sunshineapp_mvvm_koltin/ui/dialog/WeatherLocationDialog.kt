package com.example.sunshineapp_mvvm_koltin.ui.dialog

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import com.example.sunshineapp_mvvm_koltin.R
import com.example.sunshineapp_mvvm_koltin.model.SunshineRepository
import com.example.sunshineapp_mvvm_koltin.model.database.SunshineDatabase
import com.example.sunshineapp_mvvm_koltin.model.remote.RemoteWeatherDataSource
import com.example.sunshineapp_mvvm_koltin.ui.list.MainActivity
import com.example.sunshineapp_mvvm_koltin.ui.list.MainActivityViewModel
import com.example.sunshineapp_mvvm_koltin.ui.list.MainViewModelFactory
import kotlinx.android.synthetic.main.dialog_location_input.*


@SuppressLint("ValidFragment")
class WeatherLocationDialog(context: Context): DialogFragment() {


    private lateinit var mMainActivityViewModel : MainActivityViewModel

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(context)
        val inflater = requireActivity().layoutInflater
        builder.setTitle(R.string.location_weather_forecast)
        val view = inflater.inflate(R.layout.dialog_location_input,null)
        val editText = view.findViewById<EditText>(R.id.location_input)

        val remoteWeatherDataSource = RemoteWeatherDataSource.getInstance()
        val weatherDao = SunshineDatabase.getInstace(context!!)?.weatherDao()
        val repository = SunshineRepository.getInstance(remoteWeatherDataSource,weatherDao)
        val factory = MainViewModelFactory(repository)

        mMainActivityViewModel = ViewModelProviders.of(activity!!,factory).get(MainActivityViewModel::class.java)
        builder.setView(view)
            .setPositiveButton(R.string.postionButton) { dialog, which ->
                val locationStr = editText.text?.toString()
                Log.d(".MainActivity", "locationStr " +locationStr)
                if (locationStr!=null) mMainActivityViewModel.setLocationForecast(locationStr)
                dialog.dismiss()
            }
            .setNegativeButton(R.string.nagativeButton) { dialog, which ->
                getDialog().cancel()
            }

        return builder.create()
    }



}