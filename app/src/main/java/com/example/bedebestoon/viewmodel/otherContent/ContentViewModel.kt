package com.example.bedebestoon.viewmodel.otherContent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bedebestoon.model.ServiceResponse
import com.example.bedebestoon.model.otherContent.Content
import com.example.bedebestoon.repository.otherContent.ContentRepo
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