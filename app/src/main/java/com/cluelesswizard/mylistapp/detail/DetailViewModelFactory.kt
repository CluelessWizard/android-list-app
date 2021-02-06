package com.cluelesswizard.mylistapp.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cluelesswizard.mylistapp.network.ResponseModel

class DetailViewModelFactory(
    private val model: ResponseModel,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(model, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}