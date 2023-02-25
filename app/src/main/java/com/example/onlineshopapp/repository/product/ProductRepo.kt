package com.example.onlineshopapp.repository.product

import com.example.onlineshopapp.api.product.ProductApi
import com.example.onlineshopapp.model.ServiceResponse
import com.example.onlineshopapp.model.product.Product
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class ProductRepo @Inject constructor(private val ProductApi: ProductApi) {
    suspend fun getAllProducts() : ServiceResponse<Product> {
        return try {
            ProductApi.getAllProducts()
        }catch (e: Exception){
            ServiceResponse(status = "EXCEPTION" , message = e.message)
        }
    }

    suspend fun getProductById(id : Long) : ServiceResponse<Product> {
        return try {
            ProductApi.getProductById(id)
        }catch (e: Exception){
            ServiceResponse(status = "EXCEPTION" , message = e.message)
        }
    }

    suspend fun getPagedProducts(pageIndex : Int , pageSize: Int) : ServiceResponse<Product> {
        return try {
            ProductApi.getAllProductsPaged(pageIndex , pageSize )
        }catch (e: Exception){
            ServiceResponse(status = "EXCEPTION" , message = e.message)
        }
    }

    suspend fun getNewProducts() : ServiceResponse<Product> {
        return try {
            ProductApi.getNewProducts()
        }catch (e: Exception){
            ServiceResponse(status = "EXCEPTION" , message = e.message)
        }
    }

    suspend fun getPopularProducts() : ServiceResponse<Product> {
        return try {
            ProductApi.getPopularProducts()
        }catch (e: Exception){
            ServiceResponse(status = "EXCEPTION" , message = e.message)
        }
    }
}