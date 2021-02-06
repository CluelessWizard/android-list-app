package com.cluelesswizard.mylistapp.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cluelesswizard.mylistapp.network.ResponseModel

class DetailViewModel(photo: ResponseModel, app: Application) : AndroidViewModel(app) {
    private val _selectedPhoto = MutableLiveData<ResponseModel>()

    // The external LiveData for the SelectedPhoto
    val selectedPhoto: LiveData<ResponseModel>
        get() = _selectedPhoto

    init {
        _selectedPhoto.value = photo
    }

}