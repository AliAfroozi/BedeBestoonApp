package com.example.onlineshopapp.viewmodel.otherContent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshopapp.model.ServiceResponse
import com.example.onlineshopapp.model.otherContent.Slider
import com.example.onlineshopapp.repository.otherContent.SliderRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SliderViewModel @Inject constructor(private val sliderRepo: SliderRepo) : ViewModel() {
    fun getSliders(onResponse : (response: ServiceResponse<Slider>) -> Unit ) {
        viewModelScope.launch {
            onResponse(sliderRepo.getSliders())
        }
    }

    fun getSliderById(onResponse: (response: ServiceResponse<Slider>) -> Unit, id: Long) {
        viewModelScope.launch {
            onResponse(sliderRepo.getSliderById(id))
        }
    }
}