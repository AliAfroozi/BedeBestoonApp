package com.example.bedebestoon.repository.product

import com.example.bedebestoon.api.product.ProductColorApi
import com.example.bedebestoon.model.ServiceResponse
import com.example.bedebestoon.model.product.ProductColor
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class ProductColorRepo @Inject constructor(private val ProductColorApi: ProductColorApi) {
    suspend fun getAllColors() : ServiceResponse<ProductColor> {
        return try {
            ProductColorApi.getAllColors()
        }catch (e: Exception){
            ServiceResponse(status = "EXCEPTION" , message = e.message)
        }
    }

    suspend fun getColorById(id : Long) : ServiceResponse<ProductColor> {
        return try {
            ProductColorApi.getColorById(id)
        }catch (e: Exception){
            ServiceResponse(status = "EXCEPTION" , message = e.message)
        }
    }

}