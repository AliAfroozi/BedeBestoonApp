package com.example.BedeBestoon.viewmodel.otherContent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.BedeBestoon.model.ServiceResponse
import com.example.BedeBestoon.model.otherContent.Blog
import com.example.BedeBestoon.repository.otherContent.BlogRepo
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