package com.example.onlineshopapp.viewmodel.otherContent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshopapp.model.ServiceResponse
import com.example.onlineshopapp.model.otherContent.Blog
import com.example.onlineshopapp.model.otherContent.Slider
import com.example.onlineshopapp.repository.otherContent.BlogRepo
import com.example.onlineshopapp.repository.otherContent.SliderRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.lang.Exception
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