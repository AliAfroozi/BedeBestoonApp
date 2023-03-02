package com.example.onlineshopapp.viewmodel.otherContent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshopapp.model.ServiceResponse
import com.example.onlineshopapp.model.otherContent.Content
import com.example.onlineshopapp.repository.otherContent.ContentRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContentViewModel @Inject constructor(private val contentRepo: ContentRepo) : ViewModel() {
    fun getAllContents(onResponse : (ServiceResponse<Content>) -> Unit) {
        viewModelScope.launch {
            onResponse(contentRepo.getAllContents())
        }
    }

    fun getContentByTitle(title : String , onResponse : (ServiceResponse<Content>) -> Unit) {
        viewModelScope.launch {
            onResponse(contentRepo.getContentByTitle(title))
        }
    }


}