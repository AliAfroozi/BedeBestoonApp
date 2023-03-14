package com.example.bedebestoon.api.otherContent

import com.example.bedebestoon.model.ServiceResponse
import com.example.bedebestoon.model.otherContent.Slider
import retrofit2.http.GET
import retrofit2.http.Path

interface SliderApi {

    @GET("/api/slider")
    suspend fun getSliders() : ServiceResponse<Slider>

    @GET("/api/slider/{id}")
    suspend fun getSliderById(@Path("id") sliderId : Long) : ServiceResponse<Slider>
}