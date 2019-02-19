package com.example.sunshineapp_mvvm_koltin.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sunshineapp_mvvm_koltin.model.SunshineRepository

class MainViewModelFactory(val repository: SunshineRepository?): ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel(repository) as T
    }
}