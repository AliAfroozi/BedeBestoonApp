package com.example.bedebestoon.api.product

import com.example.bedebestoon.model.ServiceResponse
import com.example.bedebestoon.model.product.Product
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ProductApi {
    @GET("/api/product")
    suspend fun getAllProductsPaged(@Query("pageIndex") pageIndex : Int , @Query("pageSize") pageSize: Int ) : ServiceResponse<Product>

    @GET("/api/product/{id}")
    suspend fun getProductById(@Path("id") productId : Long) : ServiceResponse<Product>

    @GET("/api/product/all")
    suspend fun getAllProducts() : ServiceResponse<Product>

    @GET("/api/product/new")
    suspend fun getNewProducts() : ServiceResponse<Product>

    @GET("/api/product/popular")
    suspend fun getPopularProducts() : ServiceResponse<Product>

}