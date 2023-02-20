package com.example.onlineshopapp.api.product

import com.example.onlineshopapp.model.ServiceResponse
import com.example.onlineshopapp.model.otherContent.Blog
import com.example.onlineshopapp.model.product.ProductCategory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductCategoryApi {
    @GET("/api/productCategory")
    suspend fun getAllProductCategories() : ServiceResponse<ProductCategory>

    @GET("/api/productCategory/{id}")
    suspend fun getBlogById(@Path("id") categoryId : Long) : ServiceResponse<ProductCategory >

}