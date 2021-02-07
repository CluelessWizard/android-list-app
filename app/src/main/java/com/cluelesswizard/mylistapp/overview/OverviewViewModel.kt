package com.cluelesswizard.mylistapp.overview

//import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.viewModelScope
import com.cluelesswizard.mylistapp.model.Product
import com.cluelesswizard.mylistapp.network.ApiService
import com.cluelesswizard.mylistapp.model.ResponseModel
import kotlinx.coroutines.launch

enum class ApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<ApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<ApiStatus>
        get() = _status

    private val _properties = MutableLiveData<ResponseModel>()

    val properties: LiveData<ResponseModel>
        get() = _properties

    private val _navigateToSelectedProduct = MutableLiveData<Product>()

    val navigateToSelectedPhoto: LiveData<Product>
        get() = _navigateToSelectedProduct

    init {
        getApiResponse()
    }

    private fun getApiResponse() {
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _properties.value = ApiService.retrofitService.getProperties()
                _status.value = ApiStatus.DONE
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
                _properties.value = null
//                Log.e("getApiResponse", e.toString())
            }
        }
    }

    fun displayPhotoDetails(product: Product) {
        _navigateToSelectedProduct.value = product
    }

    fun displayPhotoDetailsComplete() {
        _navigateToSelectedProduct.value = null
    }
}