package com.example.BedeBestoon.api.otherContent

import com.example.BedeBestoon.model.ServiceResponse
import com.example.BedeBestoon.model.otherContent.Content
import retrofit2.http.GET
import retrofit2.http.Path

interface ContentApi {
    @GET("/api/content")
    suspend fun getAllContent() : ServiceResponse<Content>

    @GET("/api/content/{title}")
    suspend fun getContentByTitle(@Path("title") title : String) : ServiceResponse<Content>

}