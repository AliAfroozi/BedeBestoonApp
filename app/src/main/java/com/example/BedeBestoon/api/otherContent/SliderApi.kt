package com.example.BedeBestoon.api.otherContent

import com.example.BedeBestoon.model.ServiceResponse
import com.example.BedeBestoon.model.otherContent.Slider
import retrofit2.http.GET
import retrofit2.http.Path

interface SliderApi {

    @GET("/api/slider")
    suspend fun getSliders() : ServiceResponse<Slider>

    @GET("/api/slider/{id}")
    suspend fun getSliderById(@Path("id") sliderId : Long) : ServiceResponse<Slider>
}