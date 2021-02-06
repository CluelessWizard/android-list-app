package com.cluelesswizard.mylistapp.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.viewModelScope
import com.cluelesswizard.mylistapp.network.ApiService
import com.cluelesswizard.mylistapp.network.ResponseModel
import kotlinx.coroutines.launch

enum class ApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<ApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<ApiStatus>
        get() = _status

    private val _properties = MutableLiveData<List<ResponseModel>>()

    val properties: LiveData<List<ResponseModel>>
        get() = _properties

    private val _navigateToSelectedPhoto = MutableLiveData<ResponseModel>()

    val navigateToSelectedPhoto: LiveData<ResponseModel>
        get() = _navigateToSelectedPhoto

    init {
        getApiResponse()
    }

    private fun getApiResponse() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _properties.value = ApiService.retrofitService.getProperties()
                correctPhotoURL()
                _status.value = ApiStatus.DONE
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }

    private fun correctPhotoURL(){
        for (photos in _properties.value!!){
            photos.url = photos.url + ".png"
            photos.thumbnailUrl = photos.thumbnailUrl + ".png"
        }
    }

    fun displayPhotoDetails(photo: ResponseModel) {
        _navigateToSelectedPhoto.value = photo
    }

    fun displayPhotoDetailsComplete() {
        _navigateToSelectedPhoto.value = null
    }
}