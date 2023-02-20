package com.example.onlineshopapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.onlineshopapp.model.ServiceResponse
import com.example.onlineshopapp.model.otherContent.Slider
import com.example.onlineshopapp.repository.SliderRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SliderViewModel @Inject constructor(private val sliderRepo: SliderRepo) : ViewModel() {
    fun getSliders(onSuccess : (response: ServiceResponse<Slider>) -> Unit ) {
        viewModelScope.launch {
            onSuccess(sliderRepo.getSliders())
        }
    }
}