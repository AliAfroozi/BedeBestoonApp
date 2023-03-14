package com.example.bedebestoon.api.product

import com.example.bedebestoon.model.ServiceResponse
import com.example.bedebestoon.model.product.ProductCategory
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductCategoryApi {
    @GET("/api/productCategory")
    suspend fun getAllProductCategories() : ServiceResponse<ProductCategory>

    @GET("/api/productCategory/{id}")
    suspend fun getProductCategoryById(@Path("id") categoryId : Long) : ServiceResponse<ProductCategory >

}