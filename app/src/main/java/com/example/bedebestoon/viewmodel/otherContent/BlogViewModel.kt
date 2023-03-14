package com.example.bedebestoon.viewmodel.otherContent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bedebestoon.model.ServiceResponse
import com.example.bedebestoon.model.otherContent.Blog
import com.example.bedebestoon.repository.otherContent.BlogRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlogViewModel @Inject constructor(private val blogRepo: BlogRepo) : ViewModel() {
    fun getAllBlogs(onResponse : (ServiceResponse<Blog>) -> Unit) {
        viewModelScope.launch {
            onResponse(blogRepo.getAllBlogs())
        }
    }

    fun getBlogById(id : Long , onResponse : (ServiceResponse<Blog>) -> Unit) {
        viewModelScope.launch {
            onResponse(blogRepo.getBlogById(id))
        }
    }

    fun getPagedBlog(pageSize : Int , pageIndex: Int , onResponse : (ServiceResponse<Blog>) -> Unit) {
        viewModelScope.launch {
            onResponse(blogRepo.getPagedBlog(pageIndex , pageSize))
        }
    }

}