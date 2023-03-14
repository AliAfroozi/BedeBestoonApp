package com.example.bedebestoon.repository.otherContent

import com.example.bedebestoon.api.otherContent.ContentApi
import com.example.bedebestoon.model.ServiceResponse
import com.example.bedebestoon.model.otherContent.Content
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class ContentRepo @Inject constructor(private val ContentApi: ContentApi) {
    suspend fun getAllContents() : ServiceResponse<Content> {
        return try {
            ContentApi.getAllContent()
        }catch (e: Exception){
            ServiceResponse(status = "EXCEPTION" , message = e.message)
        }
    }

    suspend fun getContentByTitle(title : String) : ServiceResponse<Content> {
        return try {
            ContentApi.getContentByTitle(title)
        }catch (e: Exception){
            ServiceResponse(status = "EXCEPTION" , message = e.message)
        }
    }
}