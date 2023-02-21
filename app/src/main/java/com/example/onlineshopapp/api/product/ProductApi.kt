package com.example.onlineshopapp.api.product

import com.example.onlineshopapp.model.ServiceResponse
import com.example.onlineshopapp.model.product.Product
import com.example.onlineshopapp.model.product.ProductCategory
import com.example.onlineshopapp.model.product.ProductColor
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