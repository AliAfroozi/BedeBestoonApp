package com.example.BedeBestoon.repository.product

import com.example.BedeBestoon.api.product.ProductColorApi
import com.example.BedeBestoon.model.ServiceResponse
import com.example.BedeBestoon.model.product.ProductColor
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