package com.example.bedebestoon.viewmodel.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bedebestoon.model.ServiceResponse
import com.example.bedebestoon.model.product.ProductCategory
import com.example.bedebestoon.repository.product.ProductCategoryRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductCategoryViewModel @Inject constructor(private val productCategoryRepo: ProductCategoryRepo) : ViewModel() {
    fun getAllProductCategories(onResponse : (ServiceResponse<ProductCategory>) -> Unit) {
        viewModelScope.launch {
            onResponse(productCategoryRepo.getAllProductCategories())
        }
    }

    fun getProductCategoryById(id : Long , onResponse : (ServiceResponse<ProductCategory>) -> Unit) {
        viewModelScope.launch {
            onResponse(productCategoryRepo.getProductCategoryById(id))
        }
    }

}