package com.example.bedebestoon.viewmodel.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bedebestoon.model.ServiceResponse
import com.example.bedebestoon.model.product.Product
import com.example.bedebestoon.repository.product.ProductRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val productRepo: ProductRepo) : ViewModel() {
    fun getAllProducts(onResponse : (ServiceResponse<Product>) -> Unit) {
        viewModelScope.launch {
            onResponse(productRepo.getAllProducts())
        }
    }

    fun getProductById(id : Long , onResponse : (ServiceResponse<Product>) -> Unit) {
        viewModelScope.launch {
            onResponse(productRepo.getProductById(id))
        }
    }

    fun getNewProducts( onResponse : (ServiceResponse<Product>) -> Unit) {
        viewModelScope.launch {
            onResponse(productRepo.getNewProducts())
        }
    }

    fun getPopularProducts(onResponse : (ServiceResponse<Product>) -> Unit) {
        viewModelScope.launch {
            onResponse(productRepo.getPopularProducts())
        }
    }

    fun getPagedProducts(pageSize : Int , pageIndex: Int , onResponse : (ServiceResponse<Product>) -> Unit) {
        viewModelScope.launch {
            onResponse(productRepo.getPagedProducts(pageIndex , pageSize))
        }
    }

}