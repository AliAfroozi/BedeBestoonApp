package com.example.bedebestoon.api.otherContent

import com.example.bedebestoon.model.ServiceResponse
import com.example.bedebestoon.model.otherContent.Blog
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface BlogApi {
    @GET("/api/blog/all")
    suspend fun getAllBlogs() : ServiceResponse<Blog>

    @GET("/api/blog/{id}")
    suspend fun getBlogById(@Path("id") blogId : Long) : ServiceResponse<Blog>

    @GET("/api/blog/{pageIndex}&{pageSize}")
    suspend fun getPagedBlogs(@Query("pageIndex") pageIndex : Int, @Query("pageSize") pageSize : Int) : ServiceResponse<Blog>
}