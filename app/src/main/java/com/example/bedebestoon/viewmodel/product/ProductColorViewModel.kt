package com.example.bedebestoon.viewmodel.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bedebestoon.model.ServiceResponse
import com.example.bedebestoon.model.product.ProductColor
import com.example.bedebestoon.repository.product.ProductColorRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductColorViewModel @Inject constructor(private val productColorRepo: ProductColorRepo) : ViewModel() {
    fun getAllProductColors(onResponse : (ServiceResponse<ProductColor>) -> Unit) {
        viewModelScope.launch {
            onResponse(productColorRepo.getAllColors())
        }
    }

    fun getProductColorById(id : Long , onResponse : (ServiceResponse<ProductColor>) -> Unit) {

        viewModelScope.launch {
            onResponse(productColorRepo.getColorById(id))
        }
    }

}