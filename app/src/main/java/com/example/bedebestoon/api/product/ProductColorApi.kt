package com.example.bedebestoon.api.product

import com.example.bedebestoon.model.ServiceResponse
import com.example.bedebestoon.model.product.ProductColor
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductColorApi {
    @GET("/api/color")
    suspend fun getAllColors() : ServiceResponse<ProductColor>

    @GET("/api/color/{id}")
    suspend fun getColorById(@Path("id") colorId : Long) : ServiceResponse<ProductColor>
}