package com.example.bedebestoon.ui.components.products

import android.content.Context
import androidx.compose.State
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.state
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.unaryPlus
import androidx.navigation.NavHostController
import com.example.bedebestoon.model.product.Product
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ProductItemView(product: Product, navController : NavHostController) {
    Row(modifier = Modifier
        .fillMaxSize()
        .clickable(true) {
            product.id?.let { navController.navigate("product_detail/$it") }
        }
    ) {
        Card(
            modifier = Modifier
                .size(70.dp, 70.dp)
                .shadow(8.dp, RoundedCornerShape(20.dp), clip = true),
            shape = RoundedCornerShape(20.dp)
        )
        {
            GlideImage(
                modifier = Modifier.fillMaxSize(),
                imageModel = { product.image },
                loading = {
                    Box(modifier = Modifier.fillMaxSize()) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(30.dp, 30.dp),
                            color = Color.LightGray
                        )
                    }
                },
                // shows an error text if fail to load an image.
                failure = {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        textAlign = TextAlign.Center,
                        text = "image request failed.", fontSize = 10.sp
                    )
                }
            )
        }

        Spacer(modifier = Modifier.width(15.dp))

        Column() {
            Text(text = product.title!!, fontSize = 15.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = product.price!!, fontSize = 15.sp, color = Color.Black)
        }
    }
}


