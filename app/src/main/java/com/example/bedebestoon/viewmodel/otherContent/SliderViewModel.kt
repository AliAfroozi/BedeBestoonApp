package com.example.bedebestoon.viewmodel.otherContent

import android.transition.Slide
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bedebestoon.model.ServiceResponse
import com.example.bedebestoon.model.otherContent.Slider
import com.example.bedebestoon.repository.otherContent.SliderRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SliderViewModel @Inject constructor(private val sliderRepo: SliderRepo) : ViewModel() {
    var slidersList = mutableStateOf<List<Slider>>(listOf())
    var isLoading = mutableStateOf(true)

    init {
        getSliders { response ->
            if (response.status == "OK"){
                isLoading.value = false
                slidersList.value = response.data!!
            }
        }
    }

    fun getSliders(onResponse: (response: ServiceResponse<Slider>) -> Unit) {
        viewModelScope.launch {
            onResponse(sliderRepo.getSliders())
        }
    }

    fun getSliderById(id: Long, onResponse: (response: ServiceResponse<Slider>) -> Unit) {
        viewModelScope.launch {
            onResponse(sliderRepo.getSliderById(id))
        }
    }
}