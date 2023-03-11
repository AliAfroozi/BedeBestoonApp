package com.example.BedeBestoon.viewmodel.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.BedeBestoon.model.ServiceResponse
import com.example.BedeBestoon.model.product.ProductCategory
import com.example.BedeBestoon.repository.product.ProductCategoryRepo
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