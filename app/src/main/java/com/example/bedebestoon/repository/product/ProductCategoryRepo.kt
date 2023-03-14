package com.example.bedebestoon.repository.product

import com.example.bedebestoon.api.product.ProductCategoryApi
import com.example.bedebestoon.model.ServiceResponse
import com.example.bedebestoon.model.product.ProductCategory
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class ProductCategoryRepo @Inject constructor(private val ProductCategoryApi: ProductCategoryApi) {
    suspend fun getAllProductCategories() : ServiceResponse<ProductCategory> {
        return try {
            ProductCategoryApi.getAllProductCategories()
        }catch (e: Exception){
            ServiceResponse(status = "EXCEPTION" , message = e.message)
        }
    }

    suspend fun getProductCategoryById(id : Long) : ServiceResponse<ProductCategory> {
        return try {
            ProductCategoryApi.getProductCategoryById(id)
        }catch (e: Exception){
            ServiceResponse(status = "EXCEPTION" , message = e.message)
        }
    }

}