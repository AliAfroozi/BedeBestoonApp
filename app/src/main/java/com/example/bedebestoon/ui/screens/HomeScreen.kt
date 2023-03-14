package com.example.bedebestoon.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.bedebestoon.model.otherContent.Slider
import com.example.bedebestoon.viewmodel.otherContent.SliderViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun HomeScreen(navController: NavHostController) {
    Column() {
        SliderListView()
    }
}

@Composable
fun SliderListView( sliderViewModel: SliderViewModel = hiltViewModel()) {
    val sliderList by remember { mutableStateOf(sliderViewModel.slidersList) }
    LazyRow(){
        items(sliderList.value.size , itemContent = { index ->
            SliderItemView(sliderList.value[index])
            Spacer(modifier = Modifier.width(10.dp))
        })
    }
}

@Composable
fun SliderItemView(slider: Slider) {
    GlideImage(
        modifier = Modifier.size(300.dp , 300.dp),
        imageModel = { slider.image },
        loading = {
            Box(modifier = Modifier.matchParentSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        },
        // shows an error text if fail to load an image.
        failure = {
            Text(text = "image request failed.")
        }
    )
}
