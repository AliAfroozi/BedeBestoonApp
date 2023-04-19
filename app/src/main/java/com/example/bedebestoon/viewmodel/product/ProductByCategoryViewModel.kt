package com.example.bedebestoon.viewmodel.product

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bedebestoon.model.ServiceResponse
import com.example.bedebestoon.model.product.Product
import com.example.bedebestoon.repository.product.ProductRepo
import com.example.bedebestoon.utils.ThisApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductByCategoryViewModel @Inject constructor(private val productRepo: ProductRepo) :
    ViewModel() {
    var productByCategoryList = mutableStateOf<List<Product>>(listOf())
    var categoryId: Long = ThisApp.productCategoryId
    var pageIndex = mutableStateOf(0)
    var pageSize = 9
    var isLoading = mutableStateOf(true)
    private var scrollPosition = 0

    init {
        getByCategoryId(categoryId, pageSize, pageIndex.value) {
            if (it.status == "OK") {
                productByCategoryList.value = it.data!!
                isLoading.value = false
            }
        }
    }


    private fun getByCategoryId(
        categoryId: Long,
        pageSize: Int,
        pageIndex: Int,
        onResponse: (ServiceResponse<Product>) -> Unit
    ) {
        viewModelScope.launch {
            onResponse(productRepo.getProductsByCategory(categoryId, pageSize, pageIndex))
        }
    }

    private fun goToNextPage() {

        incrementPageIndex()
        viewModelScope.launch(Dispatchers.IO) {
            getByCategoryId(categoryId, pageSize, pageIndex.value) {
                if (it.status == "OK" && it.data!!.isNotEmpty()) {
                    val currentDataList = ArrayList<Product>(productByCategoryList.value)
                    currentDataList.addAll(it.data!!)
                    productByCategoryList.value = currentDataList
                }
                isLoading.value = false
            }

        }
    }


    private fun incrementPageIndex() {
        pageIndex.value += 1
    }

     fun onScrollPositionChange(position : Int) {
         scrollPosition = position
         if ((scrollPosition + 1) >= (pageIndex.value + 1)  *  pageSize) {
             isLoading.value = true
             goToNextPage()
         }
    }

}