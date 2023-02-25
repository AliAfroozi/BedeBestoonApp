package com.example.onlineshopapp.api.product

import com.example.onlineshopapp.model.ServiceResponse
import com.example.onlineshopapp.model.product.ProductColor
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductColorApi {
    @GET("/api/color")
    suspend fun getAllColors() : ServiceResponse<ProductColor>

    @GET("/api/color/{id}")
    suspend fun getColorById(@Path("id") colorId : Long) : ServiceResponse<ProductColor>
}