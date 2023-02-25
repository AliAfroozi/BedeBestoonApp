package com.example.onlineshopapp.repository.otherContent

import com.example.onlineshopapp.api.otherContent.SliderApi
import com.example.onlineshopapp.model.ServiceResponse
import com.example.onlineshopapp.model.otherContent.Slider
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