package com.example.githubrepo_livedata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubrepo_livedata.viewModel.MainViewModel
import java.lang.IllegalArgumentException

class MainViewModelFactory (private var name: String): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if(modelClass.isAssignableFrom(MainViewModel::class.java)){

            return MainViewModel(name) as T
        }
        throw IllegalArgumentException("ViewModel Not found")
    }
}