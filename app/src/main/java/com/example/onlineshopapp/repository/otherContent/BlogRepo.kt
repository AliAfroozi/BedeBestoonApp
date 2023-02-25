package com.example.onlineshopapp.repository.otherContent

import com.example.onlineshopapp.api.otherContent.BlogApi
import com.example.onlineshopapp.model.ServiceResponse
import com.example.onlineshopapp.model.otherContent.Blog
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class BlogRepo @Inject constructor(private val BlogApi: BlogApi) {
    suspend fun getAllBlogs() : ServiceResponse<Blog> {
        return try {
            BlogApi.getAllBlogs()
        }catch (e: Exception){
            ServiceResponse(status = "EXCEPTION" , message = e.message)
        }
    }

    suspend fun getBlogById(id : Long) : ServiceResponse<Blog> {
        return try {
            BlogApi.getBlogById(id)
        }catch (e: Exception){
            ServiceResponse(status = "EXCEPTION" , message = e.message)
        }
    }

    suspend fun getPagedBlog(pageIndex : Int , pageSize: Int) : ServiceResponse<Blog> {
        return try {
            BlogApi.getPagedBlogs(pageIndex , pageSize )
        }catch (e: Exception){
            ServiceResponse(status = "EXCEPTION" , message = e.message)
        }
    }
}