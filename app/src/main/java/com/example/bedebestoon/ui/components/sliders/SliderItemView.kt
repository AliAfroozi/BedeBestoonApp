package com.example.bedebestoon.ui.components.sliders

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bedebestoon.model.otherContent.Slider
import com.example.bedebestoon.ui.components.Loading
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun SliderItemView(slider: Slider) {

    Card(
        modifier = Modifier
            .size(300.dp, 200.dp)
            .shadow(8.dp, RoundedCornerShape(30.dp), clip = true),
        shape = RoundedCornerShape(20.dp)
    ) {
        Box() {
            GlideImage(
                modifier = Modifier.fillMaxSize(),
                imageModel = { slider.image },
                // shows an error text if fail to load an image.
                failure = {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = "image request failed."
                    )
                }
            )

            Box(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
            ) {
                Column() {
                    Text(
                        text = slider.title!!,
                        color = Color.White ,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Text(text = slider.subTitle!!, color = Color.LightGray, fontSize = 14.sp)
                }
            }
        }
    }

}