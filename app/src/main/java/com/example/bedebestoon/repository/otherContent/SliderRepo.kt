package com.example.bedebestoon.repository.otherContent

import com.example.bedebestoon.api.otherContent.SliderApi
import com.example.bedebestoon.model.ServiceResponse
import com.example.bedebestoon.model.otherContent.Slider
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class SliderRepo @Inject constructor(private val SliderApi: SliderApi) {
    suspend fun getSliders() : ServiceResponse<Slider> {
        return try {
            SliderApi.getSliders()
        }catch (e: Exception){
            ServiceResponse(status = "EXCEPTION" , message = e.message)
        }
    }

    suspend fun getSliderById(id : Long) : ServiceResponse<Slider> {
        return try {
            SliderApi.getSliderById(id)
        }catch (e: Exception){
            ServiceResponse(status = "EXCEPTION" , message = e.message)
        }
    }
}