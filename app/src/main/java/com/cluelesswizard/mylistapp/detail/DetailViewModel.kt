package com.cluelesswizard.mylistapp.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cluelesswizard.mylistapp.model.Product
import com.cluelesswizard.mylistapp.model.ResponseModel

class DetailViewModel(product: Product, app: Application) : AndroidViewModel(app) {
    private val _selectedProduct = MutableLiveData<Product>()

    // The external LiveData for the SelectedPhoto
    val selectedProduct: LiveData<Product>
        get() = _selectedProduct

    init {
        _selectedProduct.value = product
    }

}