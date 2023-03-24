package com.example.bedebestoon.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.bedebestoon.ui.components.sliders.SliderItemView
import com.example.bedebestoon.viewmodel.otherContent.SliderViewModel

@Composable
fun SliderListView(sliderViewModel: SliderViewModel = hiltViewModel()) {
    val sliderList by remember { mutableStateOf(sliderViewModel.slidersList) }
    LazyRow() {
        items(sliderList.value.size, itemContent = { index ->
            SliderItemView(sliderList.value[index])
            Spacer(modifier = Modifier.width(10.dp))
        })
    }
}