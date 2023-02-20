package com.example.onlineshopapp.api

import com.example.onlineshopapp.model.ServiceResponse
import com.example.onlineshopapp.model.otherContent.Slider
import retrofit2.http.GET
import retrofit2.http.Path

interface SliderApi {

    @GET("/api/slider")
    suspend fun getSliders() : ServiceResponse<Slider>

    @GET("/api/slider/{id}")
    suspend fun getSliderById(@Path("id") sliderId : Long) : ServiceResponse<Slider>
}