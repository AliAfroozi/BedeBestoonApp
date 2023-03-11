package com.example.BedeBestoon.repository.otherContent

import com.example.BedeBestoon.api.otherContent.SliderApi
import com.example.BedeBestoon.model.ServiceResponse
import com.example.BedeBestoon.model.otherContent.Slider
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